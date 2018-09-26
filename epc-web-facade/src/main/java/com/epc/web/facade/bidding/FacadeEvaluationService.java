package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    @PostMapping(value = "insertEvaluation", consumes = "application/json; charset=UTF-8")
    Result insertEvaluation(@RequestBody EvaluationHandle evaluationHandle);

    /**
     * 查询开标的标段保证金
     * @param procurementProjectId 采购项目ID
     * @return
     */
    @GetMapping(value = "selectGuarantee", consumes = "application/json; charset=UTF-8")
    Result selectGuarantee(@RequestParam("procurementProjectId")  Long procurementProjectId);

    /**
     * 查询对应投递文件列表
     * @param companyId 发售招标文件表主键ID
     * @return
     */
    @GetMapping(value = "getFilesByCompanyId", consumes = "application/json; charset=UTF-8")
    Result getFilesByCompanyId(@RequestParam("companyId") Long companyId);


    /**
     * 根据id查询对应废标模板
     * @param id 废标模板id
     * @return
     */
    @GetMapping(value = "getClauseTemplateById" ,consumes = "application/json; charset=UTF-8")
    Result<ClauseTemplateVO> getClauseTemplateById(@RequestParam("id") Long id);
}
