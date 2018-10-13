package com.epc.web.client.controller.loginuser.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientModifyUser",description = "用户修改密码接受类")
public class ClientModifyUser implements Serializable {
    private static final long serialVersionUID = -4003836705629881242L;
    @ApiModelProperty(value = "手机账号")
    @NotEmpty(message = "ClientModifyUser.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "新的密码")
    @NotEmpty(message = "ClientModifyUser.newPassword.null")
    private String newPassword;
    @ApiModelProperty(value = "用户类型")
    private Integer type;
    @ApiModelProperty(value = "验证码")
    private String verityCode;
}
