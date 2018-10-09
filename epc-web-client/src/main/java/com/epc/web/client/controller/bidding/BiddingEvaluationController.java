package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.evaluation.ClientEvaluationHandle;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.evaluation.EvaluationClient;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import com.epc.web.facade.bidding.vo.GuaranteeVO;
import com.epc.web.facade.bidding.vo.TPretrialFileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : 新增评标办法
 * <p>Date : 2018-09-25 13:32
 * <p>@Author : luozhixin
 * <p>BiddingEvaluationController
 */
@Api(value = "新增评标办法",tags="新增评标办法")
@RestController
@RequestMapping(value = "bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingEvaluationController extends BaseController{

    @Autowired
    private EvaluationClient evaluationClient;

    @ApiOperation(value = "新增技术评标办法",tags = "新增技术评标办法")
    @PostMapping(value = "insertEvaluation",consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertEvaluation(@RequestBody ClientEvaluationHandle clientEvaluationHandle){
        EvaluationHandle evaluationHandle = new EvaluationHandle();
        BeanUtils.copyProperties(clientEvaluationHandle,evaluationHandle);
        evaluationHandle.setOperateId(getLoginUser().getUserId());
        return evaluationClient.insertEvaluation(evaluationHandle);
    }
    @ApiOperation(value = "查询开标的标段保证金",tags = "查询开标的标段保证金")
    @GetMapping(value = "selectGuarantee"  )
    public Result<List<GuaranteeVO>> selectGuarantee(@RequestParam("procurementProjectId") Long procurementProjectId){
        return evaluationClient.selectGuarantee(procurementProjectId);
    }

    @ApiOperation(value = "查询投递文件列表",tags = "查询投递文件列表")
    @GetMapping(value = "getFilesByCompanyId" )
    public Result<List<TPretrialFileVO>> getFilesByCompanyId(@RequestParam("companyId") Long companyId){
         return   evaluationClient.getFilesByCompanyId(companyId);
    }

    @ApiOperation(value = "根据id查询对应废标模板",tags = "根据id查询对应废标模板")
    @GetMapping(value = "getClauseTemplateById" )
    public Result<ClauseTemplateVO> getClauseTemplateById(@RequestParam("id") Long id){
        return  evaluationClient.getClauseTemplateById(id);
    }


}
