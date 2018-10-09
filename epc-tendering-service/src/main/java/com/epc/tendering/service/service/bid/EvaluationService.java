package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import com.epc.web.facade.bidding.vo.GuaranteeVO;
import com.epc.web.facade.bidding.vo.TPretrialFileVO;

import java.util.List;

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
    Result<Boolean> insertEvaluation(EvaluationHandle evaluationHandle);

    /**
     * 查询开标的标段保证金
     * @param procurementProjectId 采购项目ID
     * @return
     */
    Result<List<GuaranteeVO>> selectGuarantee(Long procurementProjectId);

    /**
     * 查询对应投递文件列表
     * @param companyId 发售招标文件表主键ID
     * @return
     */
    Result<List<TPretrialFileVO>> getFilesByCompanyId(Long companyId);
    /**
     * 根据id查询对应废标模板
     * @param id 废标模板id
     * @return
     */
    Result<ClauseTemplateVO> getClauseTemplateById(Long id);

}
