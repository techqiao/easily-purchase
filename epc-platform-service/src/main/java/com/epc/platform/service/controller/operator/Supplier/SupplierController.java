package com.epc.platform.service.controller.operator.Supplier;

import com.epc.administration.facade.operator.SupplierUserService;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.platform.service.service.operator.OperatorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SupplierController {
    @Autowired
    private SupplierUserService supplierUserService;

    /**
     * @Description:    平台添加供应商
     * @param
     * @CreateDate:     16:35 2018/9/13
     * @UpdateUser:
     * @UpdateDate:     16:35 2018/9/13
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @ApiOperation(value = "平台添加供应商",notes = "平台添加供应商")
    @PostMapping(value="/createOperatorUser")
    public Result<Boolean> createSupplierUser(@RequestBody UserBasicInfo userBasicInfo){
        return supplierUserService.createSupplierUser(userBasicInfo);
    }

}
