package com.epc.web.client.remoteApi.bidding.evaluation;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeEvaluationService;
import com.epc.web.facade.bidding.handle.ClauseTemplateHandle;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.query.evaluation.QueryEvaluation;
import com.epc.web.facade.bidding.vo.SubEvaluationV0;

import java.util.Map;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:30
 * <p>@Author : luozhixin
 * <p>EvaluationHystrix
 */
public class EvaluationHystrix implements FacadeEvaluationService {

    @Override
    public Result insertEvaluation(EvaluationHandle evaluationHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<SubEvaluationV0> getEvaluationDetail(Long supplierId, Long procurementProjectId) {
        return Result.hystrixError();
    }


    @Override
    public Result selectGuarantee(Long procurementProjectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Map<String, Object>> getFilesByPurchaseProjectId(QueryEvaluation queryEvaluation) {
        return Result.hystrixError();
    }


    @Override
    public Result getClauseTemplateById(Long id) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertClauseTemplate(ClauseTemplateHandle clauseTemplateHandle) {
        return Result.hystrixError();
    }
}
