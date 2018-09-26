package com.epc.administration.client.controller.supplier;


import com.epc.administration.client.controller.reviewexpert.handle.ClientRoleDetailInfo;
import com.epc.administration.client.controller.reviewexpert.handle.ClientUserBasicInfo;
import com.epc.administration.client.controller.supplier.dto.ClientQueryDetailIfo;
import com.epc.administration.client.remoteapi.supplier.SupplierClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.QueryRequest;
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

/**
 * @date2018-9-17 09:46:01
 * @author luozhixin
 * 供应商接口
 */
@Api(value = "供应商服务",tags = {"供应商服务"})
@RestController
@RequestMapping(value = "/supplieruser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SupplierUserController {

    @Autowired
    private SupplierClient supplierClient;

    @ApiOperation(value = "添加供应商",notes = "添加供应商")
    @PostMapping(value = "createSupplierUser", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createSupplierUser(@RequestBody ClientUserBasicInfo clientUserBasicInfo){
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,userBasicInfo);
        return supplierClient.createSupplierUserInfo(userBasicInfo);
    }

    @ApiOperation(value = "供应商完善资料",notes = "供应商完善资料")
    @PostMapping(value = "registrySupplierDetail")
    public Result<Boolean> insertSupplierDetailInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo ) {
        SupplierHandle pojo = new SupplierHandle();
        BeanUtils.copyProperties(clientRoleDetailInfo,pojo);
        return supplierClient.insertSupplierDetailInfo(pojo);
    }

    @ApiOperation(value = "供应商删除资料",notes = "供应商删除资料")
    @PostMapping(value = "deleteSupplierDetailInfo")
    public Result deleteSupplierDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return supplierClient.deleteSupplierDetailInfo(queryDetailIfo);
    }
    @ApiOperation(value = "供应商查询资料",notes = "供应商查询资料")
    @PostMapping(value = "queryReviewExpertDetailInfo")
    public Result querySupplierDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return supplierClient.querySupplierDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "供应商模糊搜索查询资料",notes = "供应商模糊搜索查询资料")
    @PostMapping(value = "selectSupplierDetailInfo")
    public Result selectSupplierDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return supplierClient.selectSupplierDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "查询所有供应商资料分页展示",notes = "查询所有供应商资料分页展示")
    @PostMapping(value = "selectAllSupplierByPage")
    public Result selectAllSupplierByPage(@RequestBody QueryRequest queryRequest){
        return supplierClient.selectAllSupplierByPage(queryRequest);
    }
}
