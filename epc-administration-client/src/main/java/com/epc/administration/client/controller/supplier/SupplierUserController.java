package com.epc.administration.client.controller.supplier;


import com.epc.administration.client.controller.common.BaseController;
import com.epc.administration.client.controller.supplier.handle.ClientSupplierDetailInfo;
import com.epc.administration.client.controller.supplier.handle.ClientUserBasicInfo;
import com.epc.administration.client.controller.supplier.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.supplier.handle.ClientExamineSupplierHandle;
import com.epc.administration.client.remoteapi.supplier.SupplierClient;
import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @date2018-9-17 09:46:01
 * @author luozhixin
 * 供应商接口
 */
@Api(value = "供应商服务",tags = {"供应商服务"})
@RestController
@RequestMapping(value = "/supplieruser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SupplierUserController extends BaseController {
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
    @PostMapping(value = "registrySupplierDetail" ,consumes = "application/json;charset=UTF-8" )
    public Result<Boolean> insertSupplierDetailInfo(@RequestBody ClientSupplierDetailInfo clientSupplierDetailInfo) {
        SupplierHandle pojo = new SupplierHandle();
        BeanUtils.copyProperties(clientSupplierDetailInfo,pojo);
        return supplierClient.insertSupplierDetailInfo(pojo);
    }
    @ApiOperation(value = "供应商删除资料",notes = "供应商删除资料")
    @GetMapping(value = "deleteSupplierDetailInfo")
    public Result deleteSupplierDetailInfo(@RequestParam("whereId") Long whereId) {
        return supplierClient.deleteSupplierDetailInfo(whereId);
    }
    @ApiOperation(value = "供应商查询资料",notes = "供应商查询资料")
    @GetMapping(value = "querySupplierDetailInfo")
    public Result querySupplierDetailInfo(@RequestParam("whereId") Long whereId) {
        return supplierClient.querySupplierDetailInfo(whereId);
    }

    @ApiOperation(value = "查询所有供应商资料分页展示",notes = "查询所有供应商资料分页展示")
    @PostMapping(value = "selectAllSupplierByPage",consumes = "application/json;charset=UTF-8")
    public Result selectAllSupplierByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo){
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return supplierClient.selectAllSupplierByPage(queryDetailIfo);
    }

    @ApiOperation(value = "审核供应商", notes = "审核供应商")
    @PostMapping(value = "examineSupplier",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> examineSupplier(@RequestBody ClientExamineSupplierHandle clientExamineSupplierHandle) {
        ExamineSupplierHandle examineSupplierHandle = new ExamineSupplierHandle();
        BeanUtils.copyProperties(clientExamineSupplierHandle, examineSupplierHandle);
        return supplierClient.examineSupplier(examineSupplierHandle);
    }

}
