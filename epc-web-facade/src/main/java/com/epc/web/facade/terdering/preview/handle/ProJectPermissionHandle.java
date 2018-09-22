package com.epc.web.facade.terdering.preview.handle;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 11:16
 * <p>@Author : luozhixin
 * <p>ProJectPermissionHandle
 */
public class ProJectPermissionHandle extends PagerParam implements Serializable {
    private static final long serialVersionUID = -1442447248833368290L;
    @ApiModelProperty("用户编号")
    @NotEmpty(message = "ProJectPermissionHandle.userId.null")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
