package com.epc.web.facade.terdering.answer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-04 13:59
 * <p>@Author : wjq
 */
@ApiModel(value = "监控 ： 澄清列表")
public class MonitorAnswerQuestionVO {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "发生阶段")
    private String questionType;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "提问人ID")
    private Long questionerId;
    @ApiModelProperty(value = "提问人姓名")
    private String questionerName;
    @ApiModelProperty(value = "回答问题人Id")
    private Long answerId;
    @ApiModelProperty(value = "回答问题人姓名")
    private String answerName;
    @ApiModelProperty(value = "问题状态 待回复 wait_reply 已回复 replied")
    private String status;

}
