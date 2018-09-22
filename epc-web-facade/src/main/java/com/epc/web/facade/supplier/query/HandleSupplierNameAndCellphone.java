package com.epc.web.facade.supplier.query;


import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplierNameAndCellphone implements Serializable {
    /**
     * 根据姓名电话来查找
     */

    private static final long serialVersionUID = 4237267317328216566L;
    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String cellphone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
