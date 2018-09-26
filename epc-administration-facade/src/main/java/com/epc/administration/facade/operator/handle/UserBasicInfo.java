package com.epc.administration.facade.operator.handle;


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
public class UserBasicInfo implements Serializable {
    private static final long serialVersionUID = 2062584142645359465L;
    private String cellphone;
    private String username;
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
