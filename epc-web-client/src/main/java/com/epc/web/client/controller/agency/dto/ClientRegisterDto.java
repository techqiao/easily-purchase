package com.epc.web.client.controller.agency.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientRegisterDto" ,description = "密码修改,密码登录")
public class ClientRegisterDto implements Serializable {
    private static final long serialVersionUID = -3569502200909581795L;
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientRegisterDto.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "ClientRegisterDto.password.null")
    private String password;
    @ApiModelProperty(value = "id,查询出来后装入")
    private Long id;
}
