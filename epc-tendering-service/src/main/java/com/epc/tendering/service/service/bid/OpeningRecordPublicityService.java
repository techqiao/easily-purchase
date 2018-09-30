package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import com.epc.web.facade.terdering.bid.handle.HandlePurchaseProjectBegin;
import com.epc.web.facade.terdering.bid.vo.PurchaseProjectBeginVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 发起招标表
     *
     * @param handlePurchaseProjectBegin
     * @return
     */
    Result<Boolean> insertPurchaseProjectBegin(HandlePurchaseProjectBegin handlePurchaseProjectBegin);


    /**
     * 查看招标发包方式 是否资格预审
     * @param purchaseProjectId
     * @return
     */
    Result<PurchaseProjectBeginVO> getPurchaseProjectBegin(Long purchaseProjectId);

}
