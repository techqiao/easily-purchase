package com.epc.web.client.controller.terdering.question;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.question.handle.ClientHandleReplyQuestion;
import com.epc.web.client.controller.terdering.question.query.ClientQueryAnswerQuestionDTO;
import com.epc.web.client.remoteApi.terdering.question.AnswerQuestionClient;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:37
 * <p>@Author : wjq
 */
@RestController
@Api(value = "采购项目相关咨询问题服务", tags = {"采购项目相关咨询问题服务"})
@RequestMapping(value = "/purchase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AnswerQuestionController extends BaseController {
    @Autowired
    private AnswerQuestionClient answerQuestionClient;

    @ApiOperation(value = "查询采购项目问题列表")
    @PostMapping(value = "getQuestionList")
    public Result<List<FacadeAnswerQuestionVO>> getPurchaseProjectBasicInfo(@RequestBody ClientQueryAnswerQuestionDTO clientQueryAnswerQuestionDTO) {
        QueryAnswerQuestionDTO queryAnswerQuestionDTO = new QueryAnswerQuestionDTO();
        BeanUtils.copyProperties(clientQueryAnswerQuestionDTO,queryAnswerQuestionDTO);
        return answerQuestionClient.getQuestionList(queryAnswerQuestionDTO);
    }

    @ApiOperation(value = "回答采购项目问题")
    @PostMapping(value = "replyQuestion")
    public Result<Boolean> replyQuestion(@RequestBody ClientHandleReplyQuestion clientHandleReplyQuestion) {
        HandleReplyQuestion handleReplyQuestion = new HandleReplyQuestion();
        BeanUtils.copyProperties(clientHandleReplyQuestion, handleReplyQuestion);
        handleReplyQuestion.setOperateId(getLoginUser().getUserId());
        handleReplyQuestion.setOperateName(getLoginUser().getName());
        return answerQuestionClient.replyQuestion(handleReplyQuestion);
    }

}
