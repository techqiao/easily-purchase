package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.OpeningRecordService;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordService;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 10:18
 * <p>@Author : wjq
 */
@RestController
public class OpeningRecordController implements FacadeOpeningRecordService {
    @Autowired
    private OpeningRecordService openingRecordService;

    @Override
    public Result<Boolean> insertOpeningRecord(HandleOpeningRecord handleOpeningRecord) {
        return openingRecordService.insertOpeningRecord(handleOpeningRecord);
    }

    @Override
    public Result<List<OpeningRecordVO>> getOpeningRecordList(Long purchaseProjectId) {
        return openingRecordService.getOpeningRecordList(purchaseProjectId);
    }
}
