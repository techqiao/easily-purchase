package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value = "ClientHandleOperatorRole",description = "员工的角色role")
@Data
public class ClientHandleOperatorRole {

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "ClientHandleOperatorRole.id.null")
    private Long id;

    @ApiModelProperty(value = "当前用户的角色")
    @NotEmpty(message = "ClientHandleOperatorRole.role.null")
    private Integer role;

}
