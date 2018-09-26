package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.EvaluationService;
import com.epc.web.facade.bidding.FacadeEvaluationService;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:53
 * <p>@Author : luozhixin
 * <p>EvaluationController
 */
@RestController
public class EvaluationController implements FacadeEvaluationService {

    @Autowired
    private EvaluationService evaluationService;

    @Override
    public Result insertEvaluation(@RequestBody EvaluationHandle evaluationHandle) {
        return evaluationService.insertEvaluation(evaluationHandle);
    }

    @Override
    public Result selectGuarantee(@RequestParam("procurementProjectId") Long procurementProjectId) {
        return evaluationService.selectGuarantee(procurementProjectId);
    }

    @Override
    public Result getFilesByCompanyId(@RequestParam("companyId") Long companyId) {
        return evaluationService.getFilesByCompanyId(companyId);
    }

    @Override
    public Result<ClauseTemplateVO> getClauseTemplateById(@RequestParam("id")Long id) {
        return evaluationService.getClauseTemplateById(id);
    }
}
