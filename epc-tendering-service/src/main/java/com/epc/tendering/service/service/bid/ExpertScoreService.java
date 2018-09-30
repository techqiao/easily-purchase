package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleScoreReport;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import com.epc.web.facade.terdering.bid.vo.ExpertScoreVO;
import com.epc.web.facade.terdering.bid.vo.ScoreAndPathVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:08
 * <p>@Author : wjq
 */
public interface ExpertScoreService {
    /**
     * 获取投标人列表
     *
     * @param procurementProjectId
     * @return
     */
    Result<List<BidderListVO>> getBidderList(Long procurementProjectId);

    /**
     * 专家评分
     *
     * @param handleExpertScore
     * @return
     */
    Result<Boolean> handleExpertScore(HandleExpertScore handleExpertScore);


    /**
     * 获取评分列表
     * @param bidId
     * @return
     */
     Result<ScoreAndPathVO> queryExpertScore(Long bidId) ;


    /**
     * 撰写评审报告
     * @param handleScore
     * @return
     */
     Result<Boolean> createExpertScoreReport(HandleScoreReport handleScore) ;


    }
