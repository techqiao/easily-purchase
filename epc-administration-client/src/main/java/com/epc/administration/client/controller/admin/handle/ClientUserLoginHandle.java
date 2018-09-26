package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 11:12
 * <p>@Author : luozhixin
 * <p>ClientUserLoginHandle
 */
public class ClientUserLoginHandle  implements Serializable {
    private static final long serialVersionUID = -4512454462134936472L;
    @ApiModelProperty(value = "用户手机")
    @NotEmpty(message = "ClientUserHandle.phone.null")
    private  String phone;
    @ApiModelProperty(value = "用户密码")
    @NotEmpty(message = "ClientUserHandle.password.null")
    private String  password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClientUserLoginHandle{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
