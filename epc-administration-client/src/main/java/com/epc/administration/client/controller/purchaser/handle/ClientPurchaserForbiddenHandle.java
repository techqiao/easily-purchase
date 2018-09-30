package com.epc.administration.client.controller.purchaser.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 13:43
 * <p>@Author : luozhixin
 * <p>ClientPurchaserForbiddenHandle
 */
@Data
public class ClientPurchaserForbiddenHandle implements Serializable {

    private static final long serialVersionUID = -315782886113541757L;
    @ApiModelProperty(value = "主键id" ,notes = "主键id")
    @NotEmpty(message = "ClientPurchaserForbiddenHandle.id.null")
    private  Long id;
    @ApiModelProperty(value = "是否锁定 0启动 1锁定")
    @NotEmpty(message = "ClientPurchaserForbiddenHandle.isForbidden.null")
    private Integer isForbidden;
}
