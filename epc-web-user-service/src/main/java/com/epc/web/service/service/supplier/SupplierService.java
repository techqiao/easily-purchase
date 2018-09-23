package com.epc.web.service.service.supplier;


import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;

import java.util.List;


/**
 * @author donghuan
 */
public interface SupplierService {

    /**
     * 注册供应商
     */
    Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail);

    /**
     * 根据员工id来删除一个员工
     */
    Result<Boolean> deleteSupplierEmployeeById(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据员工的id来查询基本信息
     */
    Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据员工id来查询 公司详情
     */
    Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 查询用户信息，依据电话或者密码来查找这个人的详细信息
     */
    Result<SupplierBasicInfoVO> findByName(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 忘记密码
     */
    Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword);

    /**
     *  供应商添加员工
     */
    Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee);

    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     */
    Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);

    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     */
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleFindSupplierByInfo handleFindSupplierByInfo);

    /**
     * 完善供应商信息
     */
    Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo);

}
