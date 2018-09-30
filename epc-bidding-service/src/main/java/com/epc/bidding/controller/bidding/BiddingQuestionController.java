package com.epc.bidding.controller.bidding;

import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeQuestionService;
import com.epc.web.facade.bidding.handle.HandleQuestion;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQuestionListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiddingQuestionController implements FacadeQuestionService {

    @Autowired
    BiddingService biddingService;

    /**
     * 根据 类型+id 获取答疑列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<QueryAnswerQuestionListVO>> getAnswerQuestionList(@RequestBody QueryAnswerQuestionDTO dto){
        return biddingService.getAnswerQuestionList(dto);
    }

    /**
     * 插入一条问题记录
     * @param handleQuestion
     * @return
     */
    @Override
    public  Result<Boolean> insertQuestion(@RequestBody HandleQuestion handleQuestion){
        return biddingService.insertBAnswerQuestion(handleQuestion);
    }
}
