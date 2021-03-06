package com.epc.web.client.controller.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ClientHandleEmployee",description = "代理机构员工信息")
public class ClientHandleEmployee implements Serializable {

    private static final long serialVersionUID = 709531248696403820L;

    @ApiModelProperty(value = "员工姓名")
    @NotEmpty(message = "ClientHandleEmployee.name.null")
    private String name;

    @ApiModelProperty(value = "员工手机号")
    @NotEmpty(message = "ClientHandleEmployee.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "所属的角色")
    @NotEmpty(message = "ClientHandleEmployee.role.null")
    private Integer role;


}
