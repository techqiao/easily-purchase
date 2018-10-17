package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordService;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 15:18
 * <p>@Author : wjq
 */
public class OpeningRecordHystrix implements FacadeOpeningRecordService {

    @Override
    public Result<Boolean> insertOpeningRecord(List<HandleOpeningRecord> recordList) {
        return Result.hystrixError();
    }

    @Override
    public Result<Map<String, Object>> getOpeningRecordList(QueryBidsDTO queryBidsDTO) {
        return Result.hystrixError();
    }
}
