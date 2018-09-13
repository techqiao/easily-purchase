package com.epc.administration.facade.operator;

import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface SupplierUserService {
    /**
     * 供应商添加员工
     * @param
     * @return
     */
    @PostMapping(value = "createSupplierUser", consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierUser(@RequestBody UserBasicInfo userBasicInfo);

}
