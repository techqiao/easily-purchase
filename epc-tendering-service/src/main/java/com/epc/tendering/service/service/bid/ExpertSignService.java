package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.vo.SignVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:46
 * <p>@Author : wjq
 */
public interface ExpertSignService {
    /**
     * 评标专家签到
     * @param handleExpertSign
     * @return
     */
    Result<Boolean> insertExpertSign(HandleExpertSign handleExpertSign);

    /**
     * 设为组长
     *
     * @param handleExpertSign
     * @return
     */
    Result<Boolean> handleExpert( HandleExpertSign handleExpertSign);

    /**
     * 获开始评标前置条件
     * @param procurementProjectId
     * @return
     */
    Result<List<SignVO>> getExpertList(Long procurementProjectId);
}
