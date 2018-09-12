package com.epc.administration.client.controller.operator;

import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.administration.facade.operator.handle.HandleOperatorDetailIfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-10  18:31
 * <p>@author : wjq
 */
@Api(value = "运营商服务")
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController {
    @Autowired
    private OperatorClient operatorClient;


    @ApiOperation(value = "注册运营商",notes = "平台添加运营商")
    @PostMapping(value = "insertOperatorBasicInfo")
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody HandleOperatorBasicInfo handleOperatorBasicInfo) {
        return operatorClient.insertOperatorBasicInfo(handleOperatorBasicInfo);
    }

    @ApiOperation(value = "运营商完善资料",notes = "运营商完善资料")
    @PostMapping(value = "insertOperatorDetailInfo")
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody HandleOperatorDetailIfo handleOperatorBasicInfo) {
        return operatorClient.insertOperatorDetailInfo(handleOperatorBasicInfo);
    }
}
