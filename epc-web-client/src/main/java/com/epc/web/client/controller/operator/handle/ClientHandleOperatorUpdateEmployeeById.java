package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
@ApiModel(value = "ClientHandleOperatorUpdateEmployeeById",description = "依据员工id来修改员工信息")
public class ClientHandleOperatorUpdateEmployeeById {

    @ApiModelProperty(value = "要修改员工的id")
    @NotEmpty(message = "ClientHandleOperatorUpdateEmployeeById.id.null")
    private Long id;

    @ApiModelProperty(value = "要修改员工的名字")
    private String name;

    @ApiModelProperty(value = "要修改员工的电话")
    private String cellphone;


    @ApiModelProperty(value = "修改自己的密码")
    private String password;

    @ApiModelProperty(value = "是否禁用")
    private Integer isForbidden;

    @ApiModelProperty(value = "role 角色")
    private Integer role;


}
