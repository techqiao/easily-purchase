package com.epc.web.facade.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Description:    供应商录入员工
 * @Author:          donghuan
 * @CreateDate:     2018/9/13 11:00
 * @UpdateUser:     donghuan
 * @UpdateDate:     2018/9/13 11:00
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */

@ApiModel(value = "HandlerSupplierUser", description = "供应商录入员工信息")
public class HandlerSupplierUser {

    @ApiModelProperty(value = "员工名字")
    @NotEmpty(message = "HandlerSupplierUser.name.null")
    private String name;
    @ApiModelProperty(value = "员工电话")
    @NotEmpty(message = "HandlerSupplierUser.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "员工密码")
    @NotEmpty(message = "HandlerSupplierUser.password.null")
    private String password;

    public HandlerSupplierUser(){}

    public HandlerSupplierUser(String name, String cellphone, String password) {
        this.name = name;
        this.cellphone = cellphone;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HandlerSupplierUser{" +
                "name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
