package com.epc.web.facade.terdering.answer;

import com.epc.common.Result;
import com.epc.web.facade.terdering.answer.handle.AnswerQuestionHandle;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>Description : 采购项目问题相关接口
 * <p>Date : 2018-09-20 14:35
 * <p>@Author : wjq
 */
public interface FacadeAnswerQuestionService {

    /**
     * 获取采购项目相关问题
     * @param queryAnswerQuestionDTO  采购项目ID
     * @return
     */
    @PostMapping(value = "getQuestionList", consumes = "application/json; charset=UTF-8")
    Result<List<FacadeAnswerQuestionVO>> getQuestionList(@RequestBody QueryAnswerQuestionDTO queryAnswerQuestionDTO);

    /**
     * 处理采购项目问题
     * @param handleReplyQuestion
     * @return
     */
    @PostMapping(value = "replyQuestion", consumes = "application/json; charset=UTF-8")
    Result<Boolean> replyQuestion(@RequestBody HandleReplyQuestion handleReplyQuestion);

    /**
     * 澄清公式
     * @return
     */
    @PostMapping(value ="selectAnswerQuestion",consumes = "application/json; charset=UTF-8" )
    Result selectAnswerQuestion(@RequestBody AnswerQuestionHandle questionHandle);
}
