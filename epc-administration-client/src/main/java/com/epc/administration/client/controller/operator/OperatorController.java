package com.epc.administration.client.controller.operator;

import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.common.Result;
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
public class OperatorController {
    @Autowired
    private OperatorClient operatorClient;

    @PostMapping(value = "insertOperatorBasicInfo")
    public Result<Boolean> insertOperatorBasicInfo(HandleOperatorBasicInfo handleOperatorBasicInfo) {
        return operatorClient.insertOperatorBasicInfo(handleOperatorBasicInfo);
    }

}
