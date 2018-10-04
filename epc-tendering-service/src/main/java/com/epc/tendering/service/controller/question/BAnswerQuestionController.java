package com.epc.tendering.service.controller.question;

import com.epc.common.Result;
import com.epc.tendering.service.service.question.BAnswerQuestionService;
import com.epc.web.facade.terdering.answer.FacadeAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.AnswerQuestionHandle;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.query.QueryPublicityDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import com.epc.web.facade.terdering.answer.vo.PublicityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:19
 * <p>@Author : wjq
 */
@RestController
public class BAnswerQuestionController implements FacadeAnswerQuestionService {

    @Autowired
    private BAnswerQuestionService bAnswerQuestionService;

    @Override
    public Result<List<FacadeAnswerQuestionVO>> getQuestionList(@RequestBody QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        return bAnswerQuestionService.getQuestionList(queryAnswerQuestionDTO);
    }

    @Override
    public Result<Boolean> replyQuestion(@RequestBody HandleReplyQuestion handleReplyQuestion) {
        return bAnswerQuestionService.replyQuestion(handleReplyQuestion);
    }


    @Override
    public Result<List<PublicityVO>> getPublicityListOfficialNetwork(@RequestBody QueryPublicityDTO QueryPublicityDTO) {
        return bAnswerQuestionService.getPublicityListOfficialNetwork(QueryPublicityDTO);
    }

}
