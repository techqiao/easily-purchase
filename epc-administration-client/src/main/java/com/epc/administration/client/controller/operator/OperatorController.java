package com.epc.administration.client.controller.operator;

import com.epc.administration.client.remoteapi.operator.FacadeOperatorClient;
import com.epc.administration.facade.operator.handle.HandleOperator;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:31
 * <p>@author : wjq
 */
@Api(value = "运营商服务", description = "运营商服务")
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController {
    @Autowired
    private FacadeOperatorClient facadeOperatorClient;

    @PostMapping(value = "insertOperator")
    @ApiOperation("")
    public Result<Boolean> insertOperator(@RequestBody  HandleOperator handleOperator) {
        return Result.createBySuccess(facadeOperatorClient.insert(handleOperator));
    }
}
