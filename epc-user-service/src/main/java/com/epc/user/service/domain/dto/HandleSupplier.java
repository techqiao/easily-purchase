package com.epc.user.service.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HandleOperator", description = "新增运营商员工")

public class HandleSupplier {
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    @Override
    public String toString() {
        return "HandleOperator{" +
                "userName='" + userName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
