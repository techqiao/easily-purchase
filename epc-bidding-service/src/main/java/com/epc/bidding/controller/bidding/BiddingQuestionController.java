package com.epc.bidding.controller.bidding;

import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeQuestionService;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiddingQuestionController implements FacadeQuestionService {

    @Autowired
    BiddingService biddingService;

    /**
     * 根据采购项目ID获取答疑列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<QueryAnswerQustionListVO>> getAnswerQuestionfindById(@RequestBody QueryAnswerQuestionDTO dto){
        return biddingService.getAnswerQuestionfindByNoticeId(dto);
    }
}
