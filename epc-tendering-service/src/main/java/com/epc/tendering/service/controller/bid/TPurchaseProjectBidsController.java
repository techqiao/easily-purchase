package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.TPurchaseProjectBidsService;
import com.epc.web.facade.terdering.bid.FacadePurchaseProjectBidService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoSubVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public Result<BidsBasicInfoSubVO> getBidsDetailInfo(Long bidId) {
        return tPurchaseProjectBidsService.getBidsDetailInfo(bidId);
    }


    @Override
    public Result<List<BidsBasicInfoSubVO>> getBidsList(@RequestBody QueryBidsDTO queryBidsDTO) {
        return tPurchaseProjectBidsService.getBidsList(queryBidsDTO);
    }
}
