package com.epc.administration.client.controller.biddingagency.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 11:53
 * <p>@Author : luozhixin
 * <p>ClientAgencyForbiddenHandle
 */
@Data
public class ClientAgencyForbiddenHandle implements Serializable {
    private static final long serialVersionUID = -3906349896508670944L;

    @ApiModelProperty(value = "主键id",notes = "主键id")
    @NotEmpty(message = "ClientAgencyForbiddenHandle.id.null")
    private Long id;
    @ApiModelProperty(value = "是否禁用 0启用 1禁用")
    @NotEmpty(message = "ClientAgencyForbiddenHandle.isForbidden.null")
    private Integer isForbidden;
}
