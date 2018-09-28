package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;

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
}
