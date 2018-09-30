package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:46
 * <p>@Author : luozhixin
 */
@Data
public class ClientRoleHandle implements Serializable {
    private static final long serialVersionUID = 1894280172699042141L;
    @ApiModelProperty(value = "备注")
    @NotEmpty(message = "ClientRoleHandle.memo.null")
    private String memo;
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "ClientRoleHandle.name.null")
    private String name;
    @ApiModelProperty(value = "资源列表id")
    @NotEmpty(message = "ClientRoleHandle.resourceIds.null")
    private Long[] resourceIds;



}
