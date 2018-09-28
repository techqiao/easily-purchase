package com.epc.administration.client.controller.operator.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 13:39
 * <p>@Author : luozhixin
 * <p>ClientExamineOperatorHandle
 */
@Data
public class ClientExamineOperatorHandle {
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientExamineOperatorHandle.agencyId.null")
    private Long agencyId;

    @ApiModelProperty(value = "审核状态:3-审核通过,4-审核失败")
    @NotEmpty(message = "ClientExamineOperatorHandle.state.null")
    private int state;
}
