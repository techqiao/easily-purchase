package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleScoreReport;
import com.epc.web.facade.terdering.bid.FacadeExpertScoreService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import com.epc.web.facade.terdering.bid.vo.ScoreAndPathVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 11:27
 * <p>@Author : wjq
 */
public class ExpertScoreHystrix implements FacadeExpertScoreService {
    @Override
    public Result<List<BidderListVO>> getBidderList(Long procurementProjectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> handleExpertScore(HandleExpertScore handleExpertScore) {
        return Result.hystrixError();
    }

    @Override
    public Result<ScoreAndPathVO> queryExpertScore(Long bidId) {
        return Result.hystrixError();    }

    @Override
    public Result<Boolean> createExpertScoreReport(HandleScoreReport handleScore) {
        return Result.hystrixError();
    }
}
