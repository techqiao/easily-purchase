package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 11:21
 * <p>@Author : luozhixin
 * <p>InsertUserHandle
 */
@Data
public class InsertUserHandle implements Serializable{
    private static final long serialVersionUID = 496970299142601713L;
    @ApiModelProperty(value = "用户姓名")
    @NotEmpty(message = "InsertUserHandle.name.null")
    private  String name;
    @ApiModelProperty(value = "用户手机")
    @NotEmpty(message = "InsertUserHandle.phone.null")
    private  String phone;
    @ApiModelProperty(value = "用户密码")
    @NotEmpty(message = "InsertUserHandle.password.null")
    private String password;
    @ApiModelProperty(value = "用户部门id")
    @NotEmpty(message = "InsertUserHandle.deptId.null")
    private  Long deptId;
    @ApiModelProperty(value = "是否展示")
    @NotEmpty(message = "InsertUserHandle.isDeleted.null")
    private int isDeleted;
    @ApiModelProperty(value = "用户角色")
    @NotEmpty(message = "InsertUserHandle.roles.null")
    private Long[] roles;

}
