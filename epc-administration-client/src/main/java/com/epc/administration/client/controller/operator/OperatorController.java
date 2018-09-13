package com.epc.administration.client.controller.operator;

import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-10  18:31
 * <p>@author : wjq
 */
@Api(value = "用户服务",tags = {"用户服务"})
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController {
    @Autowired
    private OperatorClient operatorClient;

    @ApiOperation(value = "注册运营商",notes = "平台添加运营商")
    @PostMapping(value = "registry")
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody UserBasicInfo userBasicInfo) {
        return operatorClient.insertOperatorBasicInfo(userBasicInfo);
    }

    @ApiOperation(value = "运营商完善资料",notes = "运营商完善资料")
    @PostMapping(value = "registryDetail")
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailIfo handleOperatorBasicInfo) {
        return operatorClient.insertOperatorDetailInfo(handleOperatorBasicInfo);
    }


    @ApiOperation(value = "运营商删除资料",notes = "运营商删除资料")
    @PostMapping(value = "deleteOperatorDetailInfo")
    public Result deleteOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorClient.deleteOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "运营商查询资料",notes = "运营商查询资料")
    @PostMapping(value = "queryOperatorDetailInfo")
    public Result queryOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorClient.queryOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "运营商模糊搜索查询资料",notes = "运营商模糊搜索查询资料")
    @PostMapping(value = "selectOperatorDetailInfo")
    public Result selectOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorClient.selectOperatorDetailInfo(queryDetailIfo);
    }

}
