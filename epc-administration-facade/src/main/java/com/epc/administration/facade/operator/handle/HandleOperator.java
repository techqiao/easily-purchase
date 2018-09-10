package com.epc.administration.facade.operator.handle;

import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:14
 * <p>@author : wjq
 */
public class HandleOperator {
    private String cellphone;
    private String password;

    public String getCellphone() {
        return cellphone;
    }

    public HandleOperator setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public HandleOperator setPassword(String password) {
        this.password = password;
        return this;
    }
}
