package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:29
 * <p>@Author : wjq
 */
public interface TPurchaseProjectBidsService {

    /**
     * 新增|修改 标段
     * @param handleBidsBasicInfo
     * @return
     */
    Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo);
}
