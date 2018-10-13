package com.epc.web.client.controller.loginuser.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientLoginer",description = "角色登录信息接收")
public class ClientLoginer implements Serializable {
    private static final long serialVersionUID = -837512044661753751L;
    @ApiModelProperty(value = "电话")
    private String cellphone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "用户类型运营商1,代理商2,供货商3,采购商4,专家 5")
    private Integer type;
    @ApiModelProperty(value = "验证码")
    private String verityCode;
}
