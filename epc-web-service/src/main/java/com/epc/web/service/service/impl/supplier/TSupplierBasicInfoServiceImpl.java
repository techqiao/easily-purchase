package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.facade.supplier.handle.HandlerSupplierUser;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class TSupplierBasicInfoServiceImpl implements TSupplierBasicInfoService {

    private static final Logger LOGGER= LoggerFactory.getLogger(TSupplierBasicInfoServiceImpl.class);

    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;

    /**
    * @Description:    java类作用描述
    * @Author:         donghuan
    * @param           handlerSupplierUser:供应商添加用户表单数据封装
    * @CreateDate:     13:57 2018/9/13
    * @UpdateUser:
    * @UpdateDate:
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @Override
    public Result<Boolean> createSupplierUser(HandlerSupplierUser handlerSupplierUser) {
        TSupplierBasicInfo pojo=new TSupplierBasicInfo();
        Date date=new Date();// 创建的时间
        String name = handlerSupplierUser.getName();//从表单中得到员工的姓名
        String cellphone = handlerSupplierUser.getCellphone();//从表单中得到员工的电话
        String password = handlerSupplierUser.getPassword();//从表单中得到员工的密码

        pojo.setState(Const.STATE.AUDIT_SUCCESS);   //  供应商状态3审核通过
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED); // 是否删除，0存在
        pojo.setRole(Const.Role.ROLE_CORPORATION);      //角色0法人
        pojo.setName(name);
        pojo.setCellphone(cellphone);
        pojo.setPassword(password);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo)>0);
        }catch (Exception e){
            LOGGER.error("exception insertTSupplierBasicInfoMapper:{}",e);
            return Result.error(e.getMessage());
        }
    }


    /**
     * 采购人录入供应商
     * @param handleSupplierDetail
     * @Author linzhixiang
     * @return
     */
    @Override
    public Result<Boolean> createSupplierBasicInfo(HandleSupplierDetail handleSupplierDetail) {
        TSupplierBasicInfo pojo=new TSupplierBasicInfo();
        Date date=new Date();// 创建的时间
        pojo.setState(Const.STATE.COMMITTED);   //  供应商状态2提交
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED); // 是否删除，0存在
        pojo.setRole(Const.Role.ROLE_CORPORATION);      //角色0法人
        pojo.setCellphone(handleSupplierDetail.getCellPhone());
        pojo.setPassword(handleSupplierDetail.getPassword());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo)>0);
        }catch (Exception e){
            LOGGER.error("exception insertTSupplierBasicInfoMapper:{}",e);
            return Result.error(e.getMessage());
        }
    }


//    @Override
//    public boolean updateSupplierUser(HandlerUpdateSupplierUser handlerUpdateSupplierUser) {
//        //通过id查询这个用户信息，然后得到用户提交的数据，并且设置到对应的实体类中
//        String name=handlerUpdateSupplierUser.getName();
//        String cellphone = handlerUpdateSupplierUser.getCellphone();
//        Date date=new Date();
//        TSupplierBasicInfo pojo=new TSupplierBasicInfo();
//        pojo.setName(name);
//        pojo.setCellphone(cellphone);
//        pojo.setCreateAt(date);
//        tSupplierBasicInfoMapper.insertSelective(pojo);
//        return true;
//
//
//
//    }
//
//    @Override
//    public List<TSupplierBasicInfo> querySupplierAll() {
//
//        //  ？？？？？？？？？
//        //  查询所有的员工,有问题，不知道传啥参数
//        List<TSupplierBasicInfo> ListTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(null);
//
//        return ListTSupplierBasicInfos;
//    }


}
