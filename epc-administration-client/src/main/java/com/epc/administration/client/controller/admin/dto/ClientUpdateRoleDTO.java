package com.epc.administration.client.controller.admin.dto;

import com.epc.administration.client.controller.admin.handle.ClientRoleHandle;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 21:41
 * <p>@Author : luozhixin
 * <p>ClientUpdateRoleDTO
 */
public class ClientUpdateRoleDTO extends ClientRoleHandle implements Serializable {
    private static final long serialVersionUID = 5257785815263076327L;
    @ApiModelProperty(value = "角色ID")
    @NotEmpty(message = "ClientRoleHandle.roleId.null")
    private  Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "ClientUpdateRoleDTO{" +
                "roleId=" + roleId +
                '}';
    }
}
