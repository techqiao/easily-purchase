package com.epc.web.client.controller.terdering.question;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.question.handle.ClientAnswerQuestionHandle;
import com.epc.web.client.remoteApi.terdering.question.AnswerQuestionClient;
import com.epc.web.facade.terdering.answer.handle.AnswerQuestionHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 10:58
 * <p>@Author : luozhixin
 * <p>bAnswerQuestionController
 */

@Api(value = "澄清公式")
@RestController
@RequestMapping(value = "/answerQuestion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class bAnswerQuestionController extends BaseController {

    @Autowired
    private AnswerQuestionClient answerQuestionClient ;


    @ApiOperation(value = "澄清公式")
    @PostMapping(value = "selectAnswerQuestion")
    public Result selectAnswerQuestion(@RequestBody ClientAnswerQuestionHandle clientAnswerQustionHandle){
        AnswerQuestionHandle answerQuestionHandle = new AnswerQuestionHandle();
        BeanUtils.copyProperties(clientAnswerQustionHandle,answerQuestionHandle);
        return answerQuestionClient.selectAnswerQuestion(answerQuestionHandle);

    }

}
