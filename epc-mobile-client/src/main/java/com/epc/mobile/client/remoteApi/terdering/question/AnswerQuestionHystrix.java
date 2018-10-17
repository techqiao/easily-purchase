package com.epc.mobile.client.remoteApi.terdering.question;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.facade.terdering.answer.FacadeAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.query.QueryPublicityDTO;
import com.epc.web.facade.terdering.answer.vo.PublicityVO;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:40
 * <p>@Author : wjq
 */
public class AnswerQuestionHystrix implements FacadeAnswerQuestionService {

    @Override
    public Result<Map<String, Object>> getQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> replyQuestion(HandleReplyQuestion handleReplyQuestion) {
        return Result.hystrixError();
    }


    @Override
    public Result<List<PublicityVO>> getPublicityListOfficialNetwork(QueryPublicityDTO QueryPublicityDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result getBidPublicity(PagerParam pagerParam) {
        return Result.hystrixError();
    }

    @Override
    public Result<Map<String, Object>> getProcurementProjectAnswerQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        return Result.hystrixError();
    }
}
