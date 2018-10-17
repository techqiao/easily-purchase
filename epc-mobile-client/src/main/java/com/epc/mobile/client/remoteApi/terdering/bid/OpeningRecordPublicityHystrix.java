package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import com.epc.web.facade.terdering.bid.handle.HandlePurchaseProjectBegin;
import com.epc.web.facade.terdering.bid.vo.PurchaseProjectBeginVO;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 18:21
 * <p>@Author : wjq
 */
public class OpeningRecordPublicityHystrix implements FacadeOpeningRecordPublicityService {
    @Override
    public Result<Boolean> insertOpeningRecordPublicity(HandOpeningRecordPublicity handOpeningRecordPublicity) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertPurchaseProjectBegin(HandlePurchaseProjectBegin handlePurchaseProjectBegin) {
        return Result.hystrixError();
    }

    @Override
    public Result<PurchaseProjectBeginVO> getPurchaseProjectBegin(Long purchaseProjectId) {
        return Result.hystrixError();
    }
}
