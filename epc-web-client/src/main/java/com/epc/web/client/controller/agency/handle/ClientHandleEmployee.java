package com.epc.web.client.controller.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientHandleEmployee",description = "代理机构员工信息")
public class ClientHandleEmployee implements Serializable {

    private Long id;

    @ApiModelProperty(value = "员工姓名")
    @NotEmpty(message = "HandleEmployee.name.null")
    private String name;

    @ApiModelProperty(value = "公司或法人id")
    private Long agencyId;

    @ApiModelProperty(value = "员工手机号")
    @NotEmpty(message = "HandleEmployee.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "密码")
    private String password;

    private Integer state;

    @ApiModelProperty(value = "所属的角色")
    @NotEmpty(message = "HandleEmployee.role.null")
    private Integer role;
}
