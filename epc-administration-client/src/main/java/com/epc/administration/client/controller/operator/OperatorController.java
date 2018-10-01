package com.epc.administration.client.controller.operator;

import com.epc.administration.client.controller.common.BaseController;
import com.epc.administration.client.controller.operator.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.operator.handle.ClientExamineOperatorHandle;
import com.epc.administration.client.controller.operator.handle.ClientOperatorDetailInfo;
import com.epc.administration.client.controller.operator.handle.ClientOperatorForbiddenHandle;
import com.epc.administration.client.controller.operator.handle.ClientUserBasicInfo;
import com.epc.administration.client.remoteapi.operator.OperatorClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.OperatorForbiddenHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.vo.OperatorUserVO;
import com.epc.administration.facade.operator.vo.OperatorVO;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-10  18:31
 * <p>@author : wjq
 */
@Api(value = "运营商服务 @罗志鑫",tags = {"运营商服务"})
@RestController
@RequestMapping(value = "/operator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController extends BaseController {
    @Autowired
    private OperatorClient operatorClient;

    @ApiOperation(value = "注册运营商", notes = "注册运营商")
    @PostMapping(value = "registry",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody ClientUserBasicInfo clientUserBasicInfo) {
        UserBasicInfo pojo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo, pojo);
        pojo.setId(getLoginUser().getId());
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
    public Result<Boolean> deleteOperatorDetailInfo(@RequestParam("whereId") Long whereId)  {
        return operatorClient.deleteOperatorDetailInfo(whereId);
    }

    @ApiOperation(value = "运营商查询资料", notes = "运营商查询资料")
    @GetMapping(value = "queryOperatorDetailInfo")
    public Result<OperatorUserVO> queryOperatorDetailInfo(@RequestParam("whereId") Long whereId) {
        return operatorClient.queryOperatorDetailInfo(whereId);
    }

    @ApiOperation(value = "查询所有运营商分页展示", notes = "查询所有运营商分页展示")
    @PostMapping(value = "selectAllOperatorByPage",consumes = "application/json;charset=UTF-8")
    public Result<List<OperatorVO>> selectAllOperatorByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
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

    @ApiOperation(value = "锁定运营商 0启动 1锁定")
    @PostMapping(value = "forbiddenOperatorUser",consumes = "application/json;charset=UTF-8")
   public Result<Boolean> forbiddenOperatorUser(@RequestBody ClientOperatorForbiddenHandle clientOperatorForbiddenHandle){
        OperatorForbiddenHandle operatorForbiddenHandle = new OperatorForbiddenHandle();
        BeanUtils.copyProperties(clientOperatorForbiddenHandle,operatorForbiddenHandle);
        return operatorClient.forbiddenOperatorUser(operatorForbiddenHandle);
   }
}
