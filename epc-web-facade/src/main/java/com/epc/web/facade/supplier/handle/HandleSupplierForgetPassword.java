package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * 忘记密码
 * @author donghuan
 */
@Data
public class HandleSupplierForgetPassword implements Serializable {


    private static final long serialVersionUID = -5061533612458075858L;

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

}
