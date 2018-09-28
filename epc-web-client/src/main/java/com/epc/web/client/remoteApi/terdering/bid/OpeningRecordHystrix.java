package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordService;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 15:18
 * <p>@Author : wjq
 */
public class OpeningRecordHystrix implements FacadeOpeningRecordService {
    @Override
    public Result<Boolean> insertOpeningRecord(HandleOpeningRecord handleOpeningRecord) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<OpeningRecordVO>> getOpeningRecordList(Long purchaseProjectId) {
        return Result.hystrixError();
    }
}