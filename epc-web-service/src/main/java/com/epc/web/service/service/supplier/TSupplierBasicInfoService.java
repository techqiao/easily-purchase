package com.epc.web.service.service.supplier;


import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;

import java.util.List;


/**
 * @author donghuan
 */
public interface TSupplierBasicInfoService {

    /**
     * 注册供应商
     * @param handleSupplierDetail
     * @return
     */
    Result<Boolean> registerSupplier( HandleSupplierDetail handleSupplierDetail);

    /**
     * 查询用户信息，依据电话或者密码来查找这个人的详细信息
     */
    Result<SupplierDetailInfoVO> findByName(HandleSupplierNameAndCellphone handleSupplierNameAndCellphone);

    /**
     * 忘记密码
     * @param handleSupplierForgetPassword
     */
    Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword);


    /**
     * @Description:    供应商添加员工
     * @param handlerSupplierAddEmployee
     * @return
     */
    Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee);

    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     * @param
     * @return
     */
    Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);


    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     * @return
     */
    Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleSupplierFindAllByName handleSupplierFindAllByName);


}
