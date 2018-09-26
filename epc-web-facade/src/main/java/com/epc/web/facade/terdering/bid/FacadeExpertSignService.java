package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param id
     * @return
     */
    @PostMapping(value = "handleExpert", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleExpert(@RequestParam(value = "id") Long id);
}
