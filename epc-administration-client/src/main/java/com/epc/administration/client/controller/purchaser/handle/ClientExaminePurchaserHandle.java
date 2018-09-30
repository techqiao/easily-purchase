package com.epc.administration.client.controller.purchaser.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 11:48
 * <p>@Author : luozhixin
 * <p>ClientExaminePurchaserHandle
 */
@Data
public class ClientExaminePurchaserHandle implements Serializable {
    private static final long serialVersionUID = 6553879638578216080L;
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientExaminePurchaserHandle.purchaserId.null")
    private Long purchaserId;

    @ApiModelProperty(value = "审核状态:3-审核通过,4-审核失败")
    @NotEmpty(message = "ClientExaminePurchaserHandle.state.null")
    private int state;
}
