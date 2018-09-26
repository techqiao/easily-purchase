package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 10:19
 * <p>@Author : wjq
 */
public interface OpeningRecordService {

    /**
     * 插入开标记录
     * @param handleOpeningRecord
     * @return
     */
    Result<Boolean> insertOpeningRecord(HandleOpeningRecord handleOpeningRecord);

    /**
     * 查询开标前置条件
     *
     * @param purchaseProjectId
     * @return
     */
    Result<List<OpeningRecordVO>> getOpeningRecordList(Long purchaseProjectId);
}
