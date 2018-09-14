package com.epc.platform.service.controller.reviewexpert;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.ReviewexpertService;
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
 * <p>Description : 评审专家控制器
 * <p>Date : 2018-09-14 10:33:12
 * <p>@author : lzx
 */
@Api(value = "评审专家服务", description = "评审专家服务")
@RestController
public class ReviewexpertController implements ReviewexpertService {
    @Autowired
    private OperatorService operatorService;

    @ApiOperation(value = "评审专家注册", notes = "评审专家注册")
    @Override
    public Result<Boolean> insertReviewexpertBasicInfo(@RequestBody UserBasicInfo handleOperator) {
        return operatorService.insertOperatorBasicInfo(handleOperator);
    }

    @ApiOperation(value = "评审专家资料补全", notes = "评审专家资料补全")
    @Override
    public Result<Boolean> insertReviewexpertDetailInfo(@RequestBody RoleDetailInfo roleDetailIfo) {
        return operatorService.insertOperatorDetailInfo(roleDetailIfo);
    }


    @ApiOperation(value = "评审专家资料删除", notes = "评审专家资料删除")
    @Override
    public Result<Boolean> deleteReviewexpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.deleteOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "评审专家资料查询", notes = "评审专家资料查询")
    @Override
    public Result<TOperatorDetailInfo> queryReviewexpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.queryOperatorDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "评审专家资料模糊查询", notes = "评审专家资料模糊查询")
    @Override
    public Result<List<TOperatorDetailInfo>> selectReviewexpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return operatorService.selectOperatorDetailInfo(queryDetailIfo);
    }

}
