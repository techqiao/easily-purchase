package com.epc.web.facade.terdering.answer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:21
 * <p>@Author : wjq
 */
@ApiModel(value = "采购项目相关详情")
@Data
public class FacadeAnswerQuestionVO implements Serializable {

    private static final long serialVersionUID = -975682350779699922L;

    @ApiModelProperty(value = "问题ID")
    private Long id;
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
    @ApiModelProperty(value = "问题")
    private String problem;
    @ApiModelProperty(value = "回答")
    private String answer;
    @ApiModelProperty(value = "问题状态")
    private String status;
}
