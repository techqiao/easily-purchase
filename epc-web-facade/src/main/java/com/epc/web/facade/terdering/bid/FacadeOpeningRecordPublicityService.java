package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>Description : 公示开标记录
 * <p>Date : 2018-09-26 17:39
 * <p>@Author : wjq
 */
public interface FacadeOpeningRecordPublicityService {
    /**
     * 处理公示开标记录
     * @param handOpeningRecordPublicity
     * @return
     */
    @PostMapping(value = "insertOpeningRecordPublicity", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOpeningRecordPublicity(@RequestBody HandOpeningRecordPublicity handOpeningRecordPublicity);

//    /**
//     * 查询唱标记录
//     * @param purchaseProjectId
//     * @return
//     */
//    @GetMapping(value = "getOpeningRecordPublicity", consumes = "application/json; charset=UTF-8")
//    Result<OpeningRecordPublicityVO> getOpeningRecordPublicity(@RequestParam(value = "purchaseProjectId") Long purchaseProjectId);
}
