package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.handle.HandlerSupplierAddEmployee;
import com.epc.web.facade.supplier.handle.HandlerUpdateSupplierEmployeeById;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description:    供应商添加员工
 * @Author:         donghuan
 * @CreateDate:     14:21 2018/9/13
 * @UpdateUser:
 * @UpdateDate:
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public interface FacadeTSupplierBasicInfoService {

    /**
     * 供应商添加员工
     * @param handlerSupplierAddEmployee
     * @return
     */
    @PostMapping(value = "createSupplierEmployee", consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee);


    /**
     * 供应商通过员工id来修改名字和手机号及状态是否可用
     * @param
     * @return
     */
    @PostMapping(value = "updateSupplierEmployeeById", consumes ="application/json;charset=UTF-8" )
    Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById);


    /**
     *  模糊查询
     *  传入员工的姓名查询所有的员工列表
     * @return
     */
    @PostMapping(value = "querySupplierEmployeeAll", consumes = "application/json;charset=UTF-8")
    Result querySupplierEmployeeAll(@RequestBody HandleSupplierFindAllByName handleSupplierFindAllByName);

}
