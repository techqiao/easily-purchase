package com.epc.web.client.remoteApi.terdering.question;

import com.epc.common.Result;
import com.epc.web.facade.terdering.answer.FacadeAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.AnswerQuestionHandle;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:40
 * <p>@Author : wjq
 */
public class AnswerQuestionHystrix implements FacadeAnswerQuestionService {

    @Override
    public Result<List<FacadeAnswerQuestionVO>> getQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> replyQuestion(HandleReplyQuestion handleReplyQuestion) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAnswerQuestion(AnswerQuestionHandle questionHandle) {
        return Result.hystrixError();
    }
}
