package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.EvaluationService;
import com.epc.web.facade.bidding.FacadeEvaluationService;
import com.epc.web.facade.bidding.handle.ClauseTemplateHandle;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import com.epc.web.facade.bidding.vo.GuaranteeVO;
import com.epc.web.facade.bidding.vo.SubEvaluationV0;
import com.epc.web.facade.bidding.vo.TPretrialFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Result<Boolean> insertEvaluation(@RequestBody EvaluationHandle evaluationHandle) {
        return evaluationService.insertEvaluation(evaluationHandle);
    }

    @Override
    public Result<SubEvaluationV0> getEvaluationDetail(@RequestParam("supplierId") Long supplierId,@RequestParam("procurementProjectId")  Long procurementProjectId) {
        return evaluationService.getEvaluationDetail(supplierId,procurementProjectId);
    }

    @Override
    public Result<List<GuaranteeVO>> selectGuarantee(@RequestParam("procurementProjectId") Long procurementProjectId) {
        return evaluationService.selectGuarantee(procurementProjectId);
    }

    @Override
    public Result<List<TPretrialFileVO>> getFilesByPurchaseProjectId(@RequestParam("purchaseProjectId") Long purchaseProjectId) {
        return evaluationService.getFilesByPurchaseProjectId(purchaseProjectId);
    }

    @Override
    public Result<ClauseTemplateVO> getClauseTemplateById(@RequestParam("id")Long id) {
        return evaluationService.getClauseTemplateById(id);
    }

    @Override
    public Result<Boolean> insertClauseTemplate(@RequestBody ClauseTemplateHandle clauseTemplateHandle) {
        return evaluationService.insertClauseTemplate(clauseTemplateHandle);
    }
}
