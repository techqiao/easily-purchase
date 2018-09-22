package com.epc.web.client.controller.terdering.preview.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 11:16
 * <p>@Author : luozhixin
 * <p>ClientProJectPermissionHandle
 */
public class ClientProJectPermissionHandle implements Serializable {
    private static final long serialVersionUID = -1442447248833368290L;
    @ApiModelProperty("当前用户id")
    @NotEmpty(message = "ClientProJectPermissionHandle.userId.null")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
