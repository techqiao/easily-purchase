package com.epc.web.client.remoteApi.bidding.question;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeQuestionService;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;

import java.util.List;

public class BiddingHystrix implements FacadeQuestionService {


    @Override
    public Result<List<QueryAnswerQustionListVO>> getAnswerQuestionfindById(QueryAnswerQuestionDTO dto) {
        return Result.hystrixError();
    }
}
