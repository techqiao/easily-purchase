package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.ExpertScoreService;
import com.epc.web.facade.terdering.bid.FacadeExpertScoreService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:07
 * <p>@Author : wjq
 */
@RestController
public class ExpertScoreController implements FacadeExpertScoreService {

    @Autowired
    private ExpertScoreService expertScoreService;

    @Override
    public Result<List<BidderListVO>> getBidderList(@RequestParam(value = "procurementProjectId")Long procurementProjectId) {
        return expertScoreService.getBidderList(procurementProjectId);
    }

    @Override
    public Result<Boolean> handleExpertScore(@RequestBody HandleExpertScore handleExpertScore) {
        return expertScoreService.handleExpertScore(handleExpertScore);
    }
}
