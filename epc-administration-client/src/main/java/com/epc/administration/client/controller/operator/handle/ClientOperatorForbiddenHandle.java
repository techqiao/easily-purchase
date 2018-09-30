package com.epc.administration.client.controller.operator.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 13:33
 * <p>@Author : luozhixin
 * <p>ClientOperatorForbiddenHandle
 */
@Data
public class ClientOperatorForbiddenHandle implements Serializable {
    private static final long serialVersionUID = 4411369385195713622L;

    @ApiModelProperty(value = "主键id" ,notes = "主键id")
    @NotEmpty(message = "ClientOperatorForbiddenHandle.id.null")
    private  Long id;
    @ApiModelProperty(value = "是否锁定 0启动 1锁定")
    @NotEmpty(message = "ClientOperatorForbiddenHandle.isForbidden.null")
    private Integer isForbidden;
}
