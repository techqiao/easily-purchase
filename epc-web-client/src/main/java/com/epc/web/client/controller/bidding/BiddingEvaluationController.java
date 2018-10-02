package com.epc.web.client.controller.bidding;

import com.alibaba.fastjson.JSON;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.client.controller.bidding.handle.evaluation.ClientEvaluationHandle;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.evaluation.EvaluationClient;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description : 新增评标办法
 * <p>Date : 2018-09-25 13:32
 * <p>@Author : luozhixin
 * <p>BiddingEvaluationController
 */
@Api(value = "新增评标办法",description="新增评标办法")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingEvaluationController extends BaseController {

    @Autowired
    private EvaluationClient evaluationClient;

    @ApiOperation(value = "新增技术评标办法",tags = "新增技术评标办法")
    @PostMapping(value = "insertEvaluation",consumes = "application/json; charset=UTF-8")
    public Result insertEvaluation(@RequestBody ClientEvaluationHandle clientEvaluationHandle){
        EvaluationHandle evaluationHandle = new EvaluationHandle();
        BeanUtils.copyProperties(clientEvaluationHandle,evaluationHandle);
        //测试数据
        RedisShardedPoolUtil.setEx("123",JSON.toJSONString("123123123:123123123") , Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        System.out.println(RedisShardedPoolUtil.get("123"));
//        evaluationHandle.setOperateId(getLoginUser().getUserId());
        return evaluationClient.insertEvaluation(evaluationHandle);
    }
    @ApiOperation(value = "查询供应商列表",tags = "查询供应商列表")
    @GetMapping(value = "selectGuarantee" ,consumes = "application/json; charset=UTF-8" )
    public Result selectGuarantee(@RequestParam("procurementProjectId") Long procurementProjectId){
        return evaluationClient.selectGuarantee(procurementProjectId);
    }

    @ApiOperation(value = "查询投递文件列表",tags = "查询投递文件列表")
    @GetMapping(value = "getFilesByCompanyId" ,consumes = "application/json; charset=UTF-8")
    public Result getFilesByCompanyId(@RequestParam("companyId") Long companyId){
         return   evaluationClient.getFilesByCompanyId(companyId);
    }

    @ApiOperation(value = "根据id查询对应废标模板",tags = "根据id查询对应废标模板")
    @GetMapping(value = "getClauseTemplateById" ,consumes = "application/json; charset=UTF-8")
    public Result getClauseTemplateById(@RequestParam("id") Long id){
        return  evaluationClient.getClauseTemplateById(id);
    }


}
