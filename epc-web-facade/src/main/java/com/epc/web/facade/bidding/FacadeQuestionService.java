package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleQuestion;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @Description: 答疑记录
 * @Author: linzhixiang
 * @Date: 2018/9/20
 */
public interface FacadeQuestionService {

    /**
     * 根据公告Id 查询问答列表
     * @param dto
     * @return
     */

    @PostMapping(value = "getAnswerQuestionFindById", consumes = "application/json; charset=UTF-8")
    Result<List<QueryAnswerQustionListVO>> getAnswerQuestionFindById(@RequestBody QueryAnswerQuestionDTO dto);

    /**
     * 新增一条问题记录
     * @param handleQuestion
     * @return
     */
    @PostMapping(value = "insertQuestion", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertQuestion(@RequestBody HandleQuestion handleQuestion);
}
