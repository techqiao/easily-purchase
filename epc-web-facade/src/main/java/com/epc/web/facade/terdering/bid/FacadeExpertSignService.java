package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.vo.ExpertSignVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description : 评标专家签到
 * <p>Date : 2018-09-26 19:42
 * <p>@Author : wjq
 */
public interface FacadeExpertSignService {

    /**
     * 评标专家签到
     * @param handleExpertSign
     * @return
     */
    @PostMapping(value = "insertExpertSign", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertExpertSign(@RequestBody HandleExpertSign handleExpertSign);

    /**
     * 设为组长
     * @param handleExpertSign
     * @return
     */
    @PostMapping(value = "handleExpert", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleExpert(@RequestBody HandleExpertSign handleExpertSign);

    /**
     * 获开始评标前置条件
     * @param procurementProjectId
     * @return
     */
    @GetMapping(value = "getExpertList", consumes = "application/json; charset=UTF-8")
    Result<List<ExpertSignVO>> getExpertList(@RequestParam(value = "procurementProjectId") Long procurementProjectId);
}
