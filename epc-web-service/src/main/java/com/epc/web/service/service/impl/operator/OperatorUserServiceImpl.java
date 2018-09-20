package com.epc.web.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.HandleOperatorDetail;
import com.epc.web.facade.operator.handle.HandleOperatorForgetPassword;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfoCriteria;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.service.operator.OperatorUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author donghuan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class OperatorUserServiceImpl implements OperatorUserService {


    //运营商:法人及其员工基本(登录)信息
    @Autowired
    TOperatorBasicInfoMapper tOperatorBasicInfoMapper;


    /**
     * 注册
     * @param HandleOperatorDetail
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> registerOperator(HandleOperatorDetail HandleOperatorDetail) {
        TOperatorBasicInfo pojo=new TOperatorBasicInfo();

        pojo.setCellphone(HandleOperatorDetail.getCellPhone());
        pojo.setPassword(MD5Util.MD5EncodeUtf8(HandleOperatorDetail.getPassword()));
        //已注册
        pojo.setState(Const.STATE.REGISTERED);
        //法人
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        //记录创建时间
        pojo.setCreateAt(new Date());
        //已存在
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        return tOperatorBasicInfoMapper.insertSelective(pojo)>0 ? Result.success(true) : Result.success(false);
    }



    /**
     * 查询运营商用户信息
     * @param name
     * @param cellphone
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<OperatorBasicInfoVO> findByName(String name, String cellphone) {
        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameEqualTo(name);
        }
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TOperatorBasicInfo> list = tOperatorBasicInfoMapper.selectByExample(criteria);
        OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
        BeanUtils.copyProperties(list.get(0),vo);

        return Result.success(vo);
    }

    /**
     * 忘记密码
     * @param handleOperatorForgetPassword
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword) {

        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //通过手机号查询 数据库中有没有，有就能查到一个对象
        String cellphone=handleOperatorForgetPassword.getCellphone();
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TOperatorBasicInfo> listTOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
        //拿到这个对象
        TOperatorBasicInfo tOperatorBasicInfo=listTOperatorBasicInfos.get(0);
        //重新设置密码,更新数据库中的这条记录中的密码
        tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handleOperatorForgetPassword.getPassword()));

        return tOperatorBasicInfoMapper.updateByExample(tOperatorBasicInfo,criteria) >0 ? Result.success(true) : Result.success(false);
    }



}
