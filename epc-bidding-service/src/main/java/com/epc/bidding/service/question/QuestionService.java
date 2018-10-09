package com.epc.bidding.service.question;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleQuestion;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQuestionListVO;

import java.util.List;

public interface QuestionService {
    /**
     * 查看 答疑列表
     * @param queryAnswerQuestionDTO
     * @return
     */
    Result<List<QueryAnswerQuestionListVO>> getAnswerQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO);

    /**
     * 新增一条问题
     * @param handleQuestion
     * @return
     */
    Result<Boolean> insertBAnswerQuestion(HandleQuestion handleQuestion);


}
