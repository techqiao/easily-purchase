package com.epc.web.client.controller.terdering.question.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 11:10
 * <p>@Author : luozhixin
 * <p>ClientAnswerQuestionHandle
 */
@Data
public class ClientAnswerQuestionHandle implements Serializable {
    private static final long serialVersionUID = -6021498666631509919L;
    @ApiModelProperty("问题类型（公告-announcement,招标文件-bidFile,评标-bidEvaluation）")
    @NotEmpty(message = "ClientAnswerQuestionHandle.questionType.null")
    private String questionType;
}
