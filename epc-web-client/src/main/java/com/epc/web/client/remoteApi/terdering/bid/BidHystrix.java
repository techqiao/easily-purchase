package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadePurchaseProjectBidService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoSubVO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:24
 * <p>@Author : wjq
 */
public class BidHystrix implements FacadePurchaseProjectBidService {
    @Override
    public Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<BidsBasicInfoSubVO> getBidsDetailInfo(Long bidId) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<BidsBasicInfoVO>> getBidsList(QueryBidsDTO queryBidsDTO) {
        return Result.hystrixError();
    }
}
