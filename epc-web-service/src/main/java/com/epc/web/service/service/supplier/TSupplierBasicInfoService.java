package com.epc.web.service.service.supplier;


import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.handle.HandlerSupplierAddEmployee;
import com.epc.web.facade.supplier.handle.HandlerUpdateSupplierEmployeeById;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;

import java.util.List;


public interface TSupplierBasicInfoService {

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
    Result querySupplierEmployeeAll(HandleSupplierFindAllByName handleSupplierFindAllByName);







}
