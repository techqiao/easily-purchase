package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "ClientHandleOperatorForgetPassword",description = "忘记密码")
public class ClientHandleOperatorForgetPassword {

    @ApiModelProperty(value = "输入的是注册时的手机号")
    @NotEmpty(message = "ClientHandleOperatorForgetPassword.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "输入的是新的密码")
    @NotEmpty(message = "ClientHandleOperatorForgetPassword.cellphone.null")
    private String password;

    @ApiModelProperty(value = "输入的是发送的的手机验证码")
    private String msg;

}
