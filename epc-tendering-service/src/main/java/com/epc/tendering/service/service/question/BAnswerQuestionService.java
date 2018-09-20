package com.epc.tendering.service.service.question;

import com.epc.common.Result;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:50
 * <p>@Author : wjq
 */
public interface BAnswerQuestionService {
    /**
     * 查询采购项目问题
     * @param queryAnswerQuestionDTO
     * @return
     */
    Result<List<FacadeAnswerQuestionVO>> getQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO);

    /**
     * 回复采购项目问题
     * @param handleReplyQuestion
     * @return
     */
    Result<Boolean> replyQuestion(HandleReplyQuestion handleReplyQuestion);
}
