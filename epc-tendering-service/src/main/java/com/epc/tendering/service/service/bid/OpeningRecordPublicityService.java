package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:52
 * <p>@Author : wjq
 */
public interface OpeningRecordPublicityService {

    /**
     * 处理公示开标记录
     *
     * @param handOpeningRecordPublicity
     * @return
     */
    Result<Boolean> insertOpeningRecordPublicity(HandOpeningRecordPublicity handOpeningRecordPublicity);
}
