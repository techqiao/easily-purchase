package com.epc.administration.facade.admin.dto;

import com.epc.administration.facade.admin.handle.RoleHandle;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 21:44
 * <p>@Author : luozhixin
 * <p>UpdateRoleDTO
 */
@Data
public class UpdateRoleDTO extends RoleHandle implements Serializable {
    private static final long serialVersionUID = 4780978780936622074L;

    /**
     * 角色id
     */
    private  Long roleId;

    /**
     * 角色资源
     */
    private Long[] resourceIds;

}
