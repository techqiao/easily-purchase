package com.epc.administration.client.controller.biddingagency.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-26 21:07
 * <p>@Author : luozhixin
 * <p>ClientExamineAgencyHandle
 */
@Data
public class ClientExamineAgencyHandle {
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientExamineAgencyHandle.agencyId.null")
    private Long agencyId;

    @ApiModelProperty(value = "审核状态:3-审核通过,4-审核失败")
    @NotEmpty(message = "ClientExamineAgencyHandle.state.null")
    private int state;
}
