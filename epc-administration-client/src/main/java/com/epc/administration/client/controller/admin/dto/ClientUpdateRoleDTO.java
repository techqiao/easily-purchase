package com.epc.administration.client.controller.admin.dto;

import com.epc.administration.client.controller.admin.handle.ClientRoleHandle;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 21:41
 * <p>@Author : luozhixin
 * <p>ClientUpdateRoleDTO
 */
@Data
public class ClientUpdateRoleDTO extends ClientRoleHandle implements Serializable {
    private static final long serialVersionUID = 5257785815263076327L;
    @ApiModelProperty(value = "角色ID")
    @NotEmpty(message = "ClientRoleHandle.roleId.null")
    private  Long roleId;
    @ApiModelProperty(value = "角色资源")
    @NotEmpty(message = "ClientRoleHandle.resourceIds.null")
    Long[] resourceIds;

}
