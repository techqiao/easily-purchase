package com.epc.platform.service.controller.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.service.operator.OperatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@Api(value = "运营商服务", description = "运营商服务")
@RestController
public class OperatorServerController implements FacadeOperatorService {
    @Autowired
    private OperatorService operatorService;

    @ApiOperation(value = "运营商注册", notes = "运营商注册")
    @Override
    public Result<Boolean> insertOperatorBasicInfo(@RequestBody UserBasicInfo handleOperator) {
        return operatorService.insertOperatorBasicInfo(handleOperator);
    }
    @ApiOperation(value = "运营商资料补全", notes = "运营商资料补全")
    @Override
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailIfo roleDetailIfo) {
        return operatorService.insertOperatorDetailInfo(roleDetailIfo);
    }


    @ApiOperation(value = "运营商资料删除", notes = "运营商资料删除")
    @Override
    public Result<Boolean> deleteOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.deleteOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "运营商资料查询", notes = "运营商资料查询")
    @Override
    public Result<TOperatorDetailInfo> queryOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.queryOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "运营商资料模糊查询", notes = "运营商资料模糊查询")
    @Override
    public Result<List<TOperatorDetailInfo>> selectOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.selectOperatorDetailInfo(queryDetailIfo);
    }

}
