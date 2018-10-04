package com.epc.web.facade.terdering.answer.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 11:13
 * <p>@Author : luozhixin
 * <p>AnswerQuestionHandle
 */
@Data
public class AnswerQuestionHandle implements Serializable {
    private static final long serialVersionUID = 7376773797452825484L;

    @ApiModelProperty("问题类型（公告-announcement,招标文件-bidFile,评标-bidEvaluation）")
    @NotEmpty(message = "AnswerQuestionHandle.questionType.null")
    private String questionType;
}
