package com.epc.administration.client.controller.reviewexpert.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 14:00
 * <p>@Author : luozhixin
 * <p>ClientExpertForbiddenHandle
 */
@Data
public class ClientExpertForbiddenHandle implements Serializable {

    private static final long serialVersionUID = 2459983768278086647L;
    @ApiModelProperty(value = "主键id" ,notes = "主键id")
    @NotEmpty(message = "ClientExpertForbiddenHandle.id.null")
    private  Long id;
    @ApiModelProperty(value = "是否锁定 0启动 1锁定")
    @NotEmpty(message = "ClientExpertForbiddenHandle.isForbidden.null")
    private Integer isForbidden;
}
