package com.epc.web.facade.terdering.answer;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.query.QueryPublicityDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import com.epc.web.facade.terdering.answer.vo.PublicityVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Map;

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
    Result<Map<String, Object>> getQuestionList(@RequestBody QueryAnswerQuestionDTO queryAnswerQuestionDTO);

    /**
     * 处理采购项目问题
     * @param handleReplyQuestion
     * @return
     */
    @PostMapping(value = "replyQuestion", consumes = "application/json; charset=UTF-8")
    Result<Boolean> replyQuestion(@RequestBody HandleReplyQuestion handleReplyQuestion);


    /**
     * 澄清公示
     * @param QueryPublicityDTO
     * @return
     */
    @PostMapping(value ="getPublicityListOfficialNetwork",consumes = "application/json; charset=UTF-8" )
    Result<List<PublicityVO>> getPublicityListOfficialNetwork(@RequestBody QueryPublicityDTO QueryPublicityDTO);


    /**
     * 官网:中标公示
     * @param pagerParam
     * @return Result
     */
    @PostMapping(value = "getBidPublicity")
    Result<Map<String, Object>> getBidPublicity(@RequestBody PagerParam pagerParam);
    /**
     * 监控 : 问题答复列表
     * @param queryAnswerQuestionDTO
     * @return
     */
    @PostMapping(value ="getProcurementProjectAnswerQuestionList",consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> getProcurementProjectAnswerQuestionList(@RequestBody QueryAnswerQuestionDTO queryAnswerQuestionDTO);
}
