package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:28
 * <p>@Author : luozhixin
 */
@Data
public class ClientUserHandle extends ClientUserLoginHandle implements Serializable {
    private static final long serialVersionUID = -7478233784938327985L;
    @ApiModelProperty(value = "用户姓名")
    @NotEmpty(message = "ClientUserHandle.name.null")
    private  String name;
    @ApiModelProperty(value = "用户部门id")
    @NotEmpty(message = "ClientUserHandle.depetid.null")
    private  Long depetid;
    @ApiModelProperty(value = "是否展示")
    @NotEmpty(message = "ClientUserHandle.isDeleted.null")
    private int isDeleted;
    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientUserHandle.id.null")
    private Long id;
    @ApiModelProperty(value = "资源id")
    @NotEmpty(message = "ClientUserHandle.roles.null")
    private Long[] roles;


}
