package com.epc.administration.client.controller.biddingagency.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


/**
 * <p>Description : 注册用户
 * <p>Date : 2018-09-10  18:14
 * <p>@author : wjq
 */
@ApiModel(value = "UserBasicInfo", description = "注册运营商")
public class ClientUserBasicInfo implements Serializable {
    private static final long serialVersionUID = 4585162016948286872L;
    @ApiModelProperty(value = "电话号")
    @NotEmpty(message = "ClientUserBasicInfo.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "电话号")
    @NotEmpty(message = "ClientUserBasicInfo.username.null")
    private String username;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "ClientUserBasicInfo.password.null")
    private String password;

    public String getCellphone() {
        return cellphone;
    }

    public ClientUserBasicInfo setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserBasicInfo{" +
                "cellphone='" + cellphone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
