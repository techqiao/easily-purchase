package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:22
 * <p>@Author : wjq
 */
public interface FacadePurchaseProjectBidService {
    /**
     * 新增|修改标段
     * @param handleBidsBasicInfo
     * @return
     */
    @PostMapping(value = "handleBidsBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleBidsBasicInfo(@RequestBody HandleBidsBasicInfo handleBidsBasicInfo);
}
