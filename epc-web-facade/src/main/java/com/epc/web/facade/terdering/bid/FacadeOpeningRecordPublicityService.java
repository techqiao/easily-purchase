package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import com.epc.web.facade.terdering.bid.handle.HandlePurchaseProjectBegin;
import com.epc.web.facade.terdering.bid.vo.PurchaseProjectBeginVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 发起招标 确定发包方式 是否资格预审
     * @param handlePurchaseProjectBegin
     * @return
     */
    @PostMapping(value = "insertPurchaseProjectBegin", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertPurchaseProjectBegin(@RequestBody HandlePurchaseProjectBegin handlePurchaseProjectBegin);

    /**
     * 查看招标发包方式 是否资格预审
     * @param purchaseProjectId
     * @return
     */
    @GetMapping(value = "getPurchaseProjectBegin", consumes = "application/json; charset=UTF-8")
    Result<PurchaseProjectBeginVO> getPurchaseProjectBegin(@RequestParam(value = "purchaseProjectId") Long purchaseProjectId);

}
