package com.epc.platform.service.controller.biddingAgency;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.biddingAgency.BiddingAgencyService;
import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
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
 * <p>Description : 招标代理机构
 * <p>Date : 2018-09-14 10:31:14
 * <p>@author : lzx
 */
@Api(value = "招标代理机构服务", description = "招标代理机构服务")
@RestController
public class BiddingAgencyController implements BiddingAgencyService {
    @Autowired
    private OperatorService operatorService;

    @ApiOperation(value = "招标代理机构注册", notes = "招标代理机构注册")
    @Override
    public Result<Boolean> insertBiddingAgencyBasicInfo(@RequestBody UserBasicInfo handleOperator) {
        return operatorService.insertOperatorBasicInfo(handleOperator);
    }
    @ApiOperation(value = "招标代理机构资料补全", notes = "招标代理机构资料补全")
    @Override
    public Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody RoleDetailIfo roleDetailIfo) {
        return operatorService.insertOperatorDetailInfo(roleDetailIfo);
    }


    @ApiOperation(value = "招标代理机构资料删除", notes = "招标代理机构资料删除")
    @Override
    public Result<Boolean> deleteBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.deleteOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "招标代理机构资料查询", notes = "招标代理机构资料查询")
    @Override
    public Result<TOperatorDetailInfo> queryBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.queryOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "招标代理机构资料模糊查询", notes = "招标代理机构资料模糊查询")
    @Override
    public Result<List<TOperatorDetailInfo>> selectBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.selectOperatorDetailInfo(queryDetailIfo);
    }



}
