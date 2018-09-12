package com.epc.user.service.controller.operator;

import com.epc.common.Result;
import com.epc.user.service.domain.handle.operator.HandleOperator;
import com.epc.user.service.domain.handle.purchaser.HandlePurchaser;
import com.epc.user.service.service.operator.OperatorService;
import com.epc.user.service.service.purchaser.PurchaserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "运营商服务", description = "运营商服务")
@RestController
@RequestMapping(value = "/operator",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController {

    @Autowired
    OperatorService operatorService;
    @Autowired
    PurchaserService purchaserService;

    @ApiOperation(value = "运营商新增员工", notes = "运营商新增员工")
    @PostMapping(value = "/insertOperatorUser")
    public Result<Boolean> insertOperatorUser(HandleOperator handleOperator) {
        return Result.createBySuccess(operatorService.createOperatorUserInfo(handleOperator));
    }

    @ApiOperation(value = "运营商新增采购人", notes = "运营商新增采购人")
    @PostMapping(value = "/insertPurchaserUser")
    public Result<Boolean> insertPurchaserUser(HandlePurchaser handlePurchaser) {
        return Result.createBySuccess(purchaserService.createPurchaserUserInfo(handlePurchaser));
    }



}
