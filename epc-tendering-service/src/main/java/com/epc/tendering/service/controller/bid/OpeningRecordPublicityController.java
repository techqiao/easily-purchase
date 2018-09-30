package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.OpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import com.epc.web.facade.terdering.bid.handle.HandlePurchaseProjectBegin;
import com.epc.web.facade.terdering.bid.vo.PurchaseProjectBeginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:51
 * <p>@Author : wjq
 */
@RestController
public class OpeningRecordPublicityController implements FacadeOpeningRecordPublicityService {
    @Autowired
    private OpeningRecordPublicityService openingRecordPublicityService;

    @Override
    public Result<Boolean> insertOpeningRecordPublicity(@RequestBody HandOpeningRecordPublicity handOpeningRecordPublicity) {
        return openingRecordPublicityService.insertOpeningRecordPublicity(handOpeningRecordPublicity);
    }

    @Override
    public Result<Boolean> insertPurchaseProjectBegin(@RequestBody HandlePurchaseProjectBegin handlePurchaseProjectBegin) {
        return openingRecordPublicityService.insertPurchaseProjectBegin(handlePurchaseProjectBegin);
    }

    @Override
    public Result<PurchaseProjectBeginVO> getPurchaseProjectBegin(@RequestParam(value = "purchaseProjectId") Long purchaseProjectId) {
        return openingRecordPublicityService.getPurchaseProjectBegin(purchaseProjectId);
    }
}
