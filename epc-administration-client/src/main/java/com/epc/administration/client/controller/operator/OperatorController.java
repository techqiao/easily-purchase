package com.epc.administration.client.controller.operator;

import com.epc.administration.client.controller.operator.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.operator.handle.ClientExamineOperatorHandle;
import com.epc.administration.client.controller.operator.handle.ClientOperatorDetailInfo;
import com.epc.administration.client.controller.operator.handle.ClientUserBasicInfo;
import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


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

    @ApiOperation(value = "注册运营商", notes = "注册运营商")
    @PostMapping(value = "registry",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody ClientUserBasicInfo clientUserBasicInfo) {
        UserBasicInfo pojo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo, pojo);
        return operatorClient.insertOperatorBasicInfo(pojo);
    }

    @ApiOperation(value = "运营商完善资料", notes = "运营商完善资料")
    @PostMapping(value = "registryDetail",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody ClientOperatorDetailInfo clientOperatorDetailInfo) {
        RoleDetailInfo pojo = new RoleDetailInfo();
        BeanUtils.copyProperties(clientOperatorDetailInfo, pojo);
        return operatorClient.insertOperatorDetailInfo(pojo);
    }


    @ApiOperation(value = "运营商删除资料", notes = "运营商删除资料")
    @GetMapping(value = "deleteOperatorDetailInfo")
    public Result deleteOperatorDetailInfo(@RequestParam("whereId") Long whereId)  {
        return operatorClient.deleteOperatorDetailInfo(whereId);
    }

    @ApiOperation(value = "运营商查询资料", notes = "运营商查询资料")
    @GetMapping(value = "queryOperatorDetailInfo")
    public Result queryOperatorDetailInfo(@RequestParam("whereId") Long whereId) {
        return operatorClient.queryOperatorDetailInfo(whereId);
    }

    @ApiOperation(value = "查询所有运营商分页展示", notes = "查询所有运营商分页展示")
    @PostMapping(value = "selectAllOperatorByPage",consumes = "application/json;charset=UTF-8")
    public Result selectAllOperatorByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo  queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return operatorClient.selectAllOperatorByPage(queryDetailIfo);
    }

    @ApiOperation(value = "审核运营商", notes = "审核运营商")
    @PostMapping(value = "examineOperator",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> examineOperator(@RequestBody ClientExamineOperatorHandle clientExamineOperatorHandle) {
        ExamineOperatorHandle examineOperatorHandle = new ExamineOperatorHandle();
        BeanUtils.copyProperties(clientExamineOperatorHandle, examineOperatorHandle);
        return operatorClient.examineOperator(examineOperatorHandle);
    }

   /* @GetMapping(value = )
    public Result<Boolean> getOperator(){

    }*/
}
