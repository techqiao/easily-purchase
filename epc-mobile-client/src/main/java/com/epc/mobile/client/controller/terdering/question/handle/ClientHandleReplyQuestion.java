package com.epc.mobile.client.controller.terdering.question.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 15:06
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientHandleReplyQuestion",description = "回复问题")
@Data
public class ClientHandleReplyQuestion {
    @ApiModelProperty(value = "回答内容")
    private String answer;
    @ApiModelProperty(value = "问题ID")
    private Long id;
}
