package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @Description: 答疑列表
* @Author: linzhixiang
* @Date: 2018/9/18 
*/
@Data
@ApiModel("答疑列表")
public class QueryAnswerQuestionListVO implements Serializable {

    private static final long serialVersionUID = 3150403019447676651L;
    @ApiModelProperty("记录Id")
    private Long id;

    @ApiModelProperty(" 提问人")
    private String questionerName;

    @ApiModelProperty(" 回答人")
    private String answerName;

    @ApiModelProperty("问题")
    private String problem;

    @ApiModelProperty(" 回答")
    private String answer;

    @ApiModelProperty("创建时间")
    private String createAt;

}
