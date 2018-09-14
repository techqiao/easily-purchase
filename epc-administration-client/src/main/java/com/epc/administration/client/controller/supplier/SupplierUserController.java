package com.epc.administration.client.controller.supplier;


import com.epc.administration.client.remoteapi.supplier.SupplierClient;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "供应商",tags = {"供应商"})
@RestController
@RequestMapping(value = "/supplieruser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SupplierUserController {

    @Autowired
    private SupplierClient supplierClient;

    @ApiOperation(value = "添加供应商",notes = "添加供应商")
    @PostMapping(value = "createSupplierUser", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createSupplierUser(@RequestBody UserBasicInfo userBasicInfo){
        return supplierClient.createSupplierUserInfo(userBasicInfo);
    }
}
