package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
@ApiModel(value = "ClientHandleOperatorAddEmployee",description = "运营商增加员工")
public class ClientHandleOperatorAddEmployee {

    @ApiModelProperty(value = "要添加的员工名字")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.name.null")
    private String name;

    @ApiModelProperty(value = "要添加的员工电话")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "要添加的员工的密码")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.password.null")
    private String password;

    @ApiModelProperty(value = "员工id(运营商id)")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.id.null")
    private Long id;

    @ApiModelProperty(value = "员工角色role")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.role.null")
    private Integer role;


}
