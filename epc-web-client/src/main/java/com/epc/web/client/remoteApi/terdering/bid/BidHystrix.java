package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadePurchaseProjectBidService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:24
 * <p>@Author : wjq
 */
public class BidHystrix implements FacadePurchaseProjectBidService {
    @Override
    public Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo) {
        return Result.hystrixError();
    }
}
