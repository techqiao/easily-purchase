package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeExpertScoreService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;

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
}
