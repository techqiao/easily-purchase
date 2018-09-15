package com.epc.administration.client.controller.Supplier;


import com.epc.administration.client.controller.reviewexpert.handle.ClientRoleDetailInfo;
import com.epc.administration.client.remoteapi.supplier.SupplierClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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

    @ApiOperation(value = "供应商完善资料",notes = "供应商完善资料")
    @PostMapping(value = "registrySupplierDetail")
    public Result<Boolean> insertSupplierDetailInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo ) {
        RoleDetailInfo pojo = new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,pojo);
        return supplierClient.insertOperatorDetailInfo(pojo);
    }


    @ApiOperation(value = "供应商删除资料",notes = "供应商删除资料")
    @PostMapping(value = "deleteSupplierDetailInfo")
    public Result deleteSupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return supplierClient.deleteOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "供应商查询资料",notes = "供应商查询资料")
    @PostMapping(value = "queryReviewExpertDetailInfo")
    public Result querySupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return supplierClient.queryOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "供应商模糊搜索查询资料",notes = "供应商模糊搜索查询资料")
    @PostMapping(value = "selectSupplierDetailInfo")
    public Result selectSupplierDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return supplierClient.selectOperatorDetailInfo(queryDetailIfo);
    }
}
