package com.epc.administration.client.controller.operator;

import com.epc.administration.client.controller.operator.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.operator.handle.ClientRoleDetailInfo;
import com.epc.administration.client.controller.operator.handle.ClientUserBasicInfo;
import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
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
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-10  18:31
 * <p>@author : wjq
 */
@Api(value = "运营商服务",tags = {"运营商服务"})
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController {
    @Autowired
    private OperatorClient operatorClient;

    @ApiOperation(value = "注册运营商",notes = "注册运营商")
    @PostMapping(value = "registry")
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody ClientUserBasicInfo clientUserBasicInfo) {
        UserBasicInfo pojo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,pojo);
        return operatorClient.insertOperatorBasicInfo(pojo);
    }

    @ApiOperation(value = "运营商完善资料",notes = "运营商完善资料")
    @PostMapping(value = "registryDetail")
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo) {
        RoleDetailInfo pojo = new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,pojo);
        return operatorClient.insertOperatorDetailInfo(pojo);
    }


    @ApiOperation(value = "运营商删除资料",notes = "运营商删除资料")
    @PostMapping(value = "deleteOperatorDetailInfo")
    public Result deleteOperatorDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo pojo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,pojo);
        return operatorClient.deleteOperatorDetailInfo(pojo);
    }

    @ApiOperation(value = "运营商查询资料",notes = "运营商查询资料")
    @PostMapping(value = "queryOperatorDetailInfo")
    public Result queryOperatorDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo pojo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,pojo);
        return operatorClient.queryOperatorDetailInfo(pojo);
    }

    @ApiOperation(value = "运营商模糊搜索查询资料",notes = "运营商模糊搜索查询资料")
    @PostMapping(value = "selectOperatorDetailInfo")
    public Result selectOperatorDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo pojo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,pojo);
        return operatorClient.selectOperatorDetailInfo(pojo);
    }

    @ApiOperation(value = "查询所有运营商分页展示" ,notes = "查询所有运营商分页展示")
    @PostMapping(value = "selectAllOperatorByPage")
    public Result selectAllOperatorByPage(@RequestBody QueryRequest queryRequest){
        return operatorClient.selectAllOperatorByPage(queryRequest);
    }
}
