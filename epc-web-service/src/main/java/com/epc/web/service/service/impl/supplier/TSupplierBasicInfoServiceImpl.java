package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.supplier.handle.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.handle.HandlerSupplierAddEmployee;
import com.epc.web.facade.supplier.handle.HandlerUpdateSupplierEmployeeById;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class TSupplierBasicInfoServiceImpl implements TSupplierBasicInfoService {

    private static final Logger LOGGER= LoggerFactory.getLogger(TSupplierBasicInfoServiceImpl.class);

    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;

    /**
    * @Description:    供应商增加一个员工
    * @Author:         donghuan
    * @param           handlerSupplierAddEmployee:供应商添加用户表单数据封装
    * @CreateDate:     13:57 2018/9/13
    * @UpdateUser:
    * @UpdateDate:
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {

        // 创建数据库插入对象
        TSupplierBasicInfo pojo=new TSupplierBasicInfo();

        //设置供应商的id
        pojo.setSupplierId(handlerSupplierAddEmployee.getSupplierId());

        //供应商状态3审核通过
        pojo.setState(Const.STATE.AUDIT_SUCCESS);

        //是否删除，0存在
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        //角色2员工
        pojo.setRole(Const.Role.ROLE_CUSTOMER);

        //设置名字
        pojo.setName(handlerSupplierAddEmployee.getName());

        //设置电话
        pojo.setCellphone(handlerSupplierAddEmployee.getCellphone());

        //设置密码
        pojo.setPassword(MD5Util.MD5EncodeUtf8(handlerSupplierAddEmployee.getPassword()));

        //创建时间
        pojo.setCreateAt(new Date());

        //最后修改时间
        pojo.setUpdateAt(new Date());


        //返回成功或者失败
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo)>0);
        }catch (Exception e){
            LOGGER.error("exception insertTSupplierBasicInfoMapper:{}",e);
            return Result.error(e.getMessage());
        }
    }


    /**
     * @Description:    通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     * @Author:         donghuan
     * @param
     * @CreateDate:     10:05 2018/9/15
     * @UpdateUser:
     * @UpdateDate:     10:05 2018/9/15
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {

        //通过这个员工的id来查询出他的所有信息
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(handlerUpdateSupplierEmployeeById.getId());

        //将最新的名字传入进去
        tSupplierBasicInfo.setName(handlerUpdateSupplierEmployeeById.getName());

        //将最新的电话传入进去
        tSupplierBasicInfo.setCellphone(handlerUpdateSupplierEmployeeById.getCellphone());

        //将状态传入进去
        tSupplierBasicInfo.setIsDeleted(handlerUpdateSupplierEmployeeById.getIsDeleted());

        //将最新的时间存进去
        tSupplierBasicInfo.setUpdateAt(new Date());

        //存入数据库
        try{
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateSupplierEmployeeById : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }

    }


    /**
    * @Description:    根据员工的名字来匹配出符合条件的员工返回一个list
    * @Author:         donghuan
    * @param
    * @CreateDate:     19:24 2018/9/14
    * @UpdateUser:
    * @UpdateDate:     19:24 2018/9/14
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<List<TSupplierBasicInfo>> querySupplierEmployeeAll(HandleSupplierFindAllByName handleSupplierFindAllByName) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();

        TSupplierBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();

        //获取输入的名字,来进行模糊查询
        String where=handleSupplierFindAllByName.getWhere();
        if(StringUtils.isNotBlank(where)){
            criteria1.andNameLike("%"+where+"%");
        }
        return Result.success(tSupplierBasicInfoMapper.selectByExample(criteria));
    }



}
