package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.EvaluationHandle;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:55
 * <p>@Author : luozhixin
 * <p>EvaluationService
 */
public interface EvaluationService {

    /**
     * 新增评标标准设定 评标标准因素
     * @param evaluationHandle
     * @return
     */
    Result insertEvaluation(EvaluationHandle evaluationHandle);

    /**
     * 查询开标的标段保证金
     * @param procurementProjectId 采购项目ID
     * @return
     */
    Result selectGuarantee(Long procurementProjectId);

    /**
     * 查询对应投递文件列表
     * @param companyId 发售招标文件表主键ID
     * @return
     */
    Result getFilesByCompanyId(Long companyId);
}
