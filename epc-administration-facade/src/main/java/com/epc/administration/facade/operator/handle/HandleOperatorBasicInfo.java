package com.epc.administration.facade.operator.handle;


import org.hibernate.validator.constraints.NotEmpty;


/**
 * <p>Description : 预注册运营商
 * <p>Date : 2018-09-10  18:14
 * <p>@author : wjq
 */
public class HandleOperatorBasicInfo {
    //电话号
    @NotEmpty(message = "OperatorBasicInfo.cellphone.null")
    private String cellphone;
    //密码
    @NotEmpty(message = "OperatorBasicInfo.password.null")
    private String password;

    public String getCellphone() {
        return cellphone;
    }

    public HandleOperatorBasicInfo setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public HandleOperatorBasicInfo setPassword(String password) {
        this.password = password;
        return this;
    }
}
