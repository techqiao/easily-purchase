package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FacadeQuestionService {

    /**
     * 根据公告Id 查询问答列表
     * @param dto
     * @return
     */

    @PostMapping(value = "getAnswerQuestionfindById", consumes = "application/json; charset=UTF-8")
    Result<List<QueryAnswerQustionListVO>> getAnswerQuestionfindById(@RequestBody QueryAnswerQuestionDTO dto);

}
