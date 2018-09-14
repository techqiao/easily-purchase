package com.epc.platform.service.controller.supplier;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.SupplierUserService;
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
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 * <p>@author : wjq
 */
@Api(value = "供应商服务", description = "供应商服务")
@RestController
public class SupplierController implements SupplierUserService {
    @Autowired
    private OperatorService operatorService;

    @ApiOperation(value = "供应商注册", notes = "供应商注册")
    @Override
    public Result<Boolean> createSupplierUserInfo(@RequestBody UserBasicInfo handleOperator) {
        return operatorService.insertOperatorBasicInfo(handleOperator);
    }
    @ApiOperation(value = "供应商资料补全", notes = "供应商资料补全")
    @Override
    public Result<Boolean> insertOperatorDetailInfo(@RequestBody RoleDetailInfo roleDetailIfo) {
        return operatorService.insertOperatorDetailInfo(roleDetailIfo);
    }


    @ApiOperation(value = "供应商资料删除", notes = "供应商资料删除")
    @Override
    public Result<Boolean> deleteOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.deleteOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "供应商资料查询", notes = "供应商资料查询")
    @Override
    public Result<TOperatorDetailInfo> queryOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.queryOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "供应商资料模糊查询", notes = "供应商资料模糊查询")
    @Override
    public Result<List<TOperatorDetailInfo>> selectOperatorDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.selectOperatorDetailInfo(queryDetailIfo);
    }

}
