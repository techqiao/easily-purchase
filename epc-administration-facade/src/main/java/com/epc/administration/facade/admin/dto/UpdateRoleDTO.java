package com.epc.administration.facade.admin.dto;

import com.epc.administration.facade.admin.handle.RoleHandle;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 21:44
 * <p>@Author : luozhixin
 * <p>UpdateRoleDTO
 */
public class UpdateRoleDTO extends RoleHandle implements Serializable {
    private static final long serialVersionUID = 4780978780936622074L;

    private  Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UpdateRoleDTO{" +
                "roleId=" + roleId +
                '}';
    }
}
