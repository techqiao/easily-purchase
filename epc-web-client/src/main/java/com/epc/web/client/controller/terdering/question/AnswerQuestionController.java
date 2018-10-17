package com.epc.web.client.controller.terdering.question;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.common.constants.LoginTypeEnum;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.question.handle.ClientHandleReplyQuestion;
import com.epc.web.client.controller.terdering.question.query.ClientQueryAnswerQuestionDTO;
import com.epc.web.client.remoteApi.terdering.question.AnswerQuestionClient;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.query.QueryPublicityDTO;
import com.epc.web.facade.terdering.answer.vo.FacadeAnswerQuestionVO;
import com.epc.web.facade.terdering.answer.vo.PublicityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Result<Map<String, Object>> getPurchaseProjectBasicInfo(@RequestBody ClientQueryAnswerQuestionDTO clientQueryAnswerQuestionDTO) {
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
        if(getLoginUser().getLoginRole()!=null){
            switch (getLoginUser().getLoginRole()){
                //代理商2,供货商3,采购商4,专家 5
                case 2:
                    handleReplyQuestion.setAnswerPersonType(LoginTypeEnum.AGENCY.getCode());
                    break;
                case 3:
                    handleReplyQuestion.setAnswerPersonType(LoginTypeEnum.SUPPLIER.getCode());
                    break;
                case 4:
                    handleReplyQuestion.setAnswerPersonType(LoginTypeEnum.PURCHASER.getCode());
                    break;
                case 5:
                    handleReplyQuestion.setAnswerPersonType(LoginTypeEnum.EXPERT.getCode());
                    break;
            }
        }
        return answerQuestionClient.replyQuestion(handleReplyQuestion);
    }

    @ApiOperation(value = "官网:澄清公示")
    @PostMapping(value = "getPublicityListOfficialNetwork")
    public Result<List<PublicityVO>> getPublicityListOfficialNetwork(@RequestBody String type) {
        QueryPublicityDTO queryPublicityDTO = new QueryPublicityDTO();
        queryPublicityDTO.setType(type);
        return answerQuestionClient.getPublicityListOfficialNetwork(queryPublicityDTO);
    }

    @ApiOperation(value = "官网:中标公示")
    @PostMapping(value = "getBidPublicity")
    public Result<Map<String, Object>> getBidPublicity(@RequestBody PagerParam pagerParam){
        return answerQuestionClient.getBidPublicity(pagerParam);
    }

    @ApiOperation(value = "监控 : 问题答复列表")
    @PostMapping(value = "getProcurementProjectAnswerQuestionList")
    public Result<Map<String,Object>> getProcurementProjectAnswerQuestionList(@RequestBody Long procurementProjectId) {
        QueryAnswerQuestionDTO queryAnswerQuestionDTO = new QueryAnswerQuestionDTO();
        queryAnswerQuestionDTO.setProcurementProjectId(procurementProjectId);
        return answerQuestionClient.getProcurementProjectAnswerQuestionList(queryAnswerQuestionDTO);
    }

}
