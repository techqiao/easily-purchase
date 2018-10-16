package com.epc.web.facade.purchaser.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientRoleProjectProcessDetail", description = "角色登录查看项目详情")
public class RoleProjectProcessDetail implements Serializable {
    private static final long serialVersionUID = -7588187928951672589L;

    private Long id;

    private Integer userType;

    private String stepType;

    private Integer pageSize;

    private Integer pageNum;
}
