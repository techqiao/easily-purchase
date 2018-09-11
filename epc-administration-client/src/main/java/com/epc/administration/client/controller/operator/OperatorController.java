package com.epc.administration.client.controller.operator;

import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
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
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "运营商服务")
public class OperatorController {
    @Autowired
    private OperatorClient operatorClient;


    @ApiOperation(value = "添加运营商")
    @PostMapping(value = "insertOperatorBasicInfo")
    public Result<Boolean> insertOperatorBasicInfo(@ApiParam HandleOperatorBasicInfo handleOperatorBasicInfo) {
        return operatorClient.insertOperatorBasicInfo(handleOperatorBasicInfo);
    }

}
