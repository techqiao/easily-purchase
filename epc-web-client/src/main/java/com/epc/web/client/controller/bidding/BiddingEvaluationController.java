package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.evaluation.ClientClauseTemplateHandle;
import com.epc.web.client.controller.bidding.handle.evaluation.ClientEvaluationHandle;
import com.epc.web.client.controller.bidding.query.evaluation.ClientQueryEvaluation;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.evaluation.EvaluationClient;
import com.epc.web.facade.bidding.handle.ClauseTemplateHandle;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.query.evaluation.QueryEvaluation;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import com.epc.web.facade.bidding.vo.GuaranteeVO;
import com.epc.web.facade.bidding.vo.SubEvaluationV0;
import com.epc.web.facade.bidding.vo.TPretrialFileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>Description : 新增评标办法
 * <p>Date : 2018-09-25 13:32
 * <p>@Author : luozhixin
 * <p>BiddingEvaluationController
 */
@Api(value = "新增评标办法", tags = "新增评标办法")
@RestController
@RequestMapping(value = "bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingEvaluationController extends BaseController {

    @Autowired
    private EvaluationClient evaluationClient;

    @ApiOperation(value = "新增技术评标办法", tags = "新增技术评标办法")
    @PostMapping(value = "insertEvaluation", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertEvaluation(@RequestBody ClientEvaluationHandle clientEvaluationHandle) {
        EvaluationHandle evaluationHandle = new EvaluationHandle();
        BeanUtils.copyProperties(clientEvaluationHandle, evaluationHandle);
        evaluationHandle.setOperateId(getLoginUser().getUserId());
        return evaluationClient.insertEvaluation(evaluationHandle);
    }


    @ApiOperation(value = "专家评审 评标详情", tags = "专家评审 评标详情")
    @GetMapping(value = "getEvaluationDetail")
    public Result<SubEvaluationV0> getEvaluationDetail(@RequestParam("supplierId") Long supplierId, @RequestParam("procurementProjectId") Long procurementProjectId) {
        return evaluationClient.getEvaluationDetail(supplierId, procurementProjectId);
    }


    @ApiOperation(value = "查询开标的标段保证金", tags = "查询开标的标段保证金")
    @GetMapping(value = "selectGuarantee")
    public Result<List<GuaranteeVO>> selectGuarantee(@RequestParam("procurementProjectId") Long procurementProjectId) {
        return evaluationClient.selectGuarantee(procurementProjectId);
    }

    @ApiOperation(value = "查询投递文件列表", tags = "查询投递文件列表")
    @PostMapping(value = "getFilesByPurchaseProjectId", consumes = "application/json; charset=UTF-8")
    public Result<Map<String, Object>> getFilesByPurchaseProjectId(@RequestBody ClientQueryEvaluation clientQueryEvaluation) {
        QueryEvaluation queryEvaluation = new QueryEvaluation();
        BeanUtils.copyProperties(clientQueryEvaluation,queryEvaluation);
        return evaluationClient.getFilesByPurchaseProjectId(queryEvaluation);
    }

    @ApiOperation(value = "根据id查询对应废标模板", tags = "根据id查询对应废标模板")
    @GetMapping(value = "getClauseTemplateById")
    public Result<ClauseTemplateVO> getClauseTemplateById(@RequestParam("id") Long id) {
        return evaluationClient.getClauseTemplateById(id);
    }

    @ApiOperation(value = "新增废标模板", tags = "新增废标模板")
    @PostMapping(value = "insertClauseTemplate", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertClauseTemplate(@RequestBody ClientClauseTemplateHandle clientClauseTemplateHandle) {
        ClauseTemplateHandle clauseTemplateHandle = new ClauseTemplateHandle();
        BeanUtils.copyProperties(clientClauseTemplateHandle, clauseTemplateHandle);
        return evaluationClient.insertClauseTemplate(clauseTemplateHandle);
    }

}
