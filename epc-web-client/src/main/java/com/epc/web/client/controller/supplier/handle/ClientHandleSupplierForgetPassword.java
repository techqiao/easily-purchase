package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


@Data
@ApiModel(value = "ClientHandleSupplierForgetPassword",description = "忘记密码")
public class ClientHandleSupplierForgetPassword {


    /**
     * 忘记密码
     * @author donghuan
     */

    @ApiModelProperty(value = "输入的是注册时的手机号")
    @NotEmpty(message = "ClientHandleSupplierForgetPassword.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "输入的是新的密码")
    @NotEmpty(message = "ClientHandleSupplierForgetPassword.password.null")
    private String password;

    @ApiModelProperty(value = "输入的是发送的的手机验证码")
    private String msg;

}
