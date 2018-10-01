package com.epc.administration.client.controller.admin.handle;

import com.epc.administration.facade.admin.handle.LoginHandle;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 11:21
 * <p>@Author : luozhixin
 * <p>InsertUserHandle
 */
@Data
public class InsertUserHandle extends LoginHandle {
    private static final long serialVersionUID = -7478233784938327985L;
    @ApiModelProperty(value = "用户姓名")
    @NotEmpty(message = "InsertUserHandle.name.null")
    private  String name;
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
