package com.epc.mobile.client.controller.loginuser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientRegisterUser",description = "用户依据角色注册")
public class ClientRegisterUser implements Serializable {
    private static final long serialVersionUID = 4888937816886414945L;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientRegisterUser.cellphone.null")
    private String cellphone;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "ClientRegisterUser.password.null")
    private String password;
    /**
     * 注册类型
     */
    @ApiModelProperty(value = "用户类型运营商1,代理商2,供货商3,采购商4专家5")
    @NotEmpty(message = "ClientRegisterUser.type.null")
    private Integer type;
    /**
     * 注册姓名
     */
    @ApiModelProperty(value = "用户姓名")
    @NotEmpty(message = "ClientRegisterUser.cellphone.null")
    private String name;

    @ApiModelProperty(value = "验证码")
    @NotEmpty(message = "ClientRegisterUser.verifyCode.null")
    private String verityCode;
    @ApiModelProperty(value = "供货商类型，供货商专用，其他角色忽略")
    @NotEmpty(message = "ClientRegisterUser.categorySupplier.null")
    private String categorySupplier;

}
