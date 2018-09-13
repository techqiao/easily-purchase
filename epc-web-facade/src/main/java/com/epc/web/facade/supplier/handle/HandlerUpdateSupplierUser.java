package com.epc.web.facade.supplier.handle;

public class HandlerUpdateSupplierUser {
    /**
     * 更新员工的一条信息
     */


    //员工名字
    private String name;
    //员工手机
    private String cellphone;

    public HandlerUpdateSupplierUser(){}

    public HandlerUpdateSupplierUser(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }

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

    @Override
    public String toString() {
        return "HandlerUpdateSupplierUser{" +
                "name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
