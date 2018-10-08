package com.epc.web.client.controller.bidding.query.answerQuestion;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "ClientAnswerQuestionDTO",description = "根据 类型+id 查看问答列表")
public class ClientAnswerQuestionDTO extends PagerParam {
    @ApiModelProperty(value = "采购项目ID")
    @NotEmpty(message = "ClientAnswerQuestionDTO.procurementProjectId.null")
    private Long procurementProjectId;
    @ApiModelProperty(value = "回答人姓名")
    private String answerName;
    @ApiModelProperty(value = "问题类型")
    private String questionType;
    @ApiModelProperty(value = "问题Id")
    private Long typeId;
    @ApiModelProperty(value = "提问人Id")
    private Long questionerId;
    @ApiModelProperty(value = "提问人姓名")
    private String questionerName;
}