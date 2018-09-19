package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.TPurchaseProjectBidsService;
import com.epc.web.facade.terdering.bid.FacadePurchaseProjectBidService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:28
 * <p>@Author : wjq
 */
@RestController
public class TPurchaseProjectBidsController implements FacadePurchaseProjectBidService {
    @Autowired
    private TPurchaseProjectBidsService tPurchaseProjectBidsService;
    @Override
    public Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo) {
        return tPurchaseProjectBidsService.handleBidsBasicInfo(handleBidsBasicInfo);
    }
}
