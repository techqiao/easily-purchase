package com.epc.web.client.controller.terdering.question.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:41
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientQueryAnswerQuestionDTO",description = "查询采购项目咨询问题")
@Data
public class ClientQueryAnswerQuestionDTO extends PagerParam {
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "提问人姓名")
    private String questionerName;
    @ApiModelProperty(value = "问题状态 待回复 wait_reply 已回复 replied")
    private String status;
}
