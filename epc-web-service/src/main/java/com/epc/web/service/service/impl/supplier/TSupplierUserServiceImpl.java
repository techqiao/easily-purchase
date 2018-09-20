package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.facade.supplier.handle.HandleSupplierForgetPassword;
import com.epc.web.facade.supplier.vo.SupplierAttachmentVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.supplier.TSupplierUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class TSupplierUserServiceImpl implements TSupplierUserService {

    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;

    /**
     * 注册供应商
     * @param handleSupplierDetail
     * @return
     */
    @Override
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        //将公司名称，电话，密码信息存入到这个表对象中
        TSupplierBasicInfo tSupplierBasicInfo=new TSupplierBasicInfo();
        TSupplierDetailInfo tSupplierDetailInfo=new TSupplierDetailInfo();
        //设置公司名称
        tSupplierDetailInfo.setCompanyName(handleSupplierDetail.getCompanyName());
        //设置电话
        tSupplierBasicInfo.setCellphone(handleSupplierDetail.getCellPhone());
        //设置密码
        tSupplierBasicInfo.setPassword(handleSupplierDetail.getPassword());
        //设置状态
        tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
        //设置角色
        tSupplierBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        //设置状态,已注册
        tSupplierBasicInfo.setState(Const.STATE.REGISTERED);
        //创建时间
        tSupplierBasicInfo.setCreateAt(new Date());
        //最后修改时间(预计注册时可能不需要，默认没有，只有当修改了才会有这个 修改时间)
        //tSupplierBasicInfo.setUpdateAt(new Date());

        int i = tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
        int i2 = tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
        return (i>0 && i2>0)?Result.success("注册成功"):Result.success("注册失败");
    }

    /**
     *  登陆
     * @param cellphone
     * @param password
     * @return
     */
    @Override
    public Result<SupplierBasicInfoVO> login(String cellphone, String password) {
        //判断不为null
        Validate.notNull(cellphone);
        Validate.notNull(password);
        //
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //校验电话与密码
        subCriteria.andCellphoneEqualTo(cellphone);
        subCriteria.andPasswordEqualTo(MD5Util.MD5EncodeUtf8(password));
        //得到数据库人的信息
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);

        SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
        //将这个人的信息复制给vo类
        BeanUtils.copyProperties(list.get(0),vo);
        return Result.success(vo);
    }


    /**
     * 依据名字和电话查询用户信息
     * @param name
     * @param cellphone
     * @return
     */
    @Override
    public Result<SupplierDetailInfoVO> findByName(String name, String cellphone) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameEqualTo(name);
        }
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
        SupplierDetailInfoVO vo=new SupplierDetailInfoVO();
        BeanUtils.copyProperties(list.get(0),vo);
        return Result.success(vo);
    }

    /**
     *  忘记密码
     * @param handleSupplierForgetPassword
     */
    @Override
    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //得到手机号,查询数据库中有没有这条数据
        String cellphone=handleSupplierForgetPassword.getCellphone();
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        //查询出一条结果,然后将密码改掉
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        //加密传过来的密码
        String newPassword = MD5Util.MD5EncodeUtf8(handleSupplierForgetPassword.getPassword());
        TSupplierBasicInfo tSupplierBasicInfo=listTSupplierBasicInfos.get(0);
        tSupplierBasicInfo.setPassword(newPassword);
        //将新数据更新到数据 库中
        return tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo,criteria)>0?Result.<Boolean>success("修改成功"):Result.<Boolean>success("修改失败");
    }


}
