package com.epc.administration.facade.admin.handle;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:46
 * <p>@Author : luozhixin
 */
@Data
public class RoleHandle implements Serializable {
    private static final long serialVersionUID = -6141001495978320281L;
    /**
     * 角色备注
     */
    private String memo;
    /**
     * 角色名字
     */
    private String name;
    /**
     * 角色对应资源id
     */
    private Long[] resourceIds;

}
