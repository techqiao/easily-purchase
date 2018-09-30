package com.epc.administration.client.controller.reviewexpert.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 13:47
 * <p>@Author : luozhixin
 * <p>ClientExamineExpertHandle
 */
@Data
public class ClientExamineExpertHandle {
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientExamineExpertHandle.expertId.null")
    private Long expertId;

    @ApiModelProperty(value = "审核状态:3-审核通过,4-审核失败")
    @NotEmpty(message = "ClientExamineExpertHandle.state.null")
    private int state;
}
