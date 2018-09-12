package com.epc.administration.facade.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * <p>Description : 注册用户
 * <p>Date : 2018-09-10  18:14
 * <p>@author : wjq
 */
@ApiModel(value = "UserBasicInfo", description = "注册运营商")
public class UserBasicInfo {
    @ApiModelProperty(value = "电话号")
    @NotEmpty(message = "UserBasicInfo.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "UserBasicInfo.password.null")
    private String password;

    public String getCellphone() {
        return cellphone;
    }

    public UserBasicInfo setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBasicInfo setPassword(String password) {
        this.password = password;
        return this;
    }
}
