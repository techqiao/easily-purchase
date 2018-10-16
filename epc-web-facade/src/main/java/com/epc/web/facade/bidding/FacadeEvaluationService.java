package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.ClauseTemplateHandle;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.query.evaluation.QueryEvaluation;
import com.epc.web.facade.bidding.vo.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:18
 * <p>@Author : luozhixin
 * <p>FacadeEvaluationService
 */
public interface FacadeEvaluationService {

    /**
     * 新增评标标准设定 评标标准因素
     * @param evaluationHandle
     * @return
     */
    @PostMapping(value = "insertEvaluation")
    Result<Boolean> insertEvaluation(@RequestBody EvaluationHandle evaluationHandle);

    /**
     * 专家评审 评标详情
     * @param supplierId 供应商ID
     * @return
     */
    @GetMapping(value = "getEvaluationDetail")
    Result<SubEvaluationV0> getEvaluationDetail(@RequestParam("supplierId") Long supplierId,@RequestParam("procurementProjectId") Long procurementProjectId);

    /**
     * 查询开标的标段保证金
     * @param procurementProjectId 采购项目ID
     * @return
     */
    @GetMapping(value = "selectGuarantee")
    Result<List<GuaranteeVO>> selectGuarantee(@RequestParam("procurementProjectId")  Long procurementProjectId);

    /**
     * 查询对应投递文件列表
     * @param queryEvaluation
     * @return
     */
    @PostMapping(value = "getFilesByPurchaseProjectId",consumes = "application/json; charset=UTF-8"  )
    Result<Map<String, Object>> getFilesByPurchaseProjectId(@RequestBody QueryEvaluation queryEvaluation);


    /**
     * 根据id查询对应废标模板
     * @param id 废标模板id
     * @return
     */
    @GetMapping(value = "getClauseTemplateById" )
    Result<ClauseTemplateVO> getClauseTemplateById(@RequestParam("id") Long id);

    /**
     * 新增废标模板
     * @param clauseTemplateHandle
     * @return
     */
    @PostMapping(value = "insertClauseTemplate" ,consumes = "application/json; charset=UTF-8"  )
    Result<Boolean> insertClauseTemplate(@RequestBody ClauseTemplateHandle clauseTemplateHandle);
}
