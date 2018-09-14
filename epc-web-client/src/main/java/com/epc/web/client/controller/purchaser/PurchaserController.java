package com.epc.web.client.controller.purchaser;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.purchaser.PurchaserClient;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "采购人服务",tags = {"采购人服务"})
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaserController {
    @Autowired
    PurchaserClient purchaserClient;

    @ApiOperation(value = "注册采购人员",notes = "注册采购人员")
    @PostMapping(value = "/createPurchaseBasicInfo")
    public Result<Boolean> createPurchaseBasicInfo(@RequestBody HandlePurchaser handlePurchaser) {
        return purchaserClient.createPurchaseBasicInfo(handlePurchaser);
    }

    @ApiOperation(value = "注册供应商",notes = "注册供应商")
    @PostMapping(value = "/createSupplierBasicInfo")
    public Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return purchaserClient.createSupplierByPurchaser(handleSupplierDetail);
    }

    @ApiOperation(value = "注册专家",notes = "注册专家")
    @PostMapping(value = "/createExpertBasicInfo")
    public Result<Boolean> createExpertByPurchaser(@RequestBody HandleExpert handleExpert) {
        return purchaserClient.createExpertByPurchaser(handleExpert);
    }

    @ApiOperation(value = "注册代理机构",notes = "注册代理机构")
    @PostMapping(value = "/createAgencyBasicInfo")
    public Result<Boolean> createAgencyByPurchaser(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserClient.createAgencyByPurchaser(handleAgnecy);
    }

    @ApiOperation(value = "完善采购人信息",notes = "完善采购人信息")
    @PostMapping(value = "/updatePurchaserDetail")
    public Result<Boolean> updatePurchaserDetail(@RequestBody HandlePurchaser handlePurchaser) {
        return purchaserClient.updatePurchaserDetail(handlePurchaser);
    }

    @ApiOperation(value = "完善代理机构信息",notes = "完善代理机构信息")
    @PostMapping(value = "/updateAgencyDetail")
    public Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserClient.updateAgencyDetail(handleAgnecy);
    }
}
