package com.epc.web.facade.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.HandlerSupplierUser;
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
     * @param handlerSupplierUser
     * @return
     */
    @PostMapping(value = "createSupplierUser", consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierUser(@RequestBody HandlerSupplierUser handlerSupplierUser);


}
