package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.query.answerQuestion.ClientAnswerQuestionDTO;
import com.epc.web.client.remoteApi.bidding.question.BiddingClient;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "投标流程",tags = {"招标文件问题回复列表"})
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingQuestionController {

    @Autowired
    BiddingClient biddingClient;
    @ApiOperation(value = "招标文件问题")
    @PostMapping(value="/getQuestionList")
    public Result<List<QueryAnswerQustionListVO>> getQuestionListById(@RequestBody ClientAnswerQuestionDTO dto){
        QueryAnswerQuestionDTO queryAnswerQuestionDTO=new QueryAnswerQuestionDTO();
        BeanUtils.copyProperties(dto,queryAnswerQuestionDTO);
        return  biddingClient.getAnswerQuestionfindById(queryAnswerQuestionDTO);
    }


}
