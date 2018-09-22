package com.epc.web.facade.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 忘记密码
 */
@Data
public class HandleOperatorForgetPassword implements Serializable {

    private static final long serialVersionUID = 6631877071810068334L;
    /**
     * 输入的是注册时的手机号
     */
    private String cellphone;

    /**
     * 输入的是新的密码
     */
    private String password;

    /**
     * 输入的是发送的的手机验证码
     */
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
