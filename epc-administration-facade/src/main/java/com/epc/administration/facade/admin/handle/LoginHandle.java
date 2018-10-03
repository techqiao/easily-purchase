package com.epc.administration.facade.admin.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 11:15
 * <p>@Author : luozhixin
 * <p>LoginHandle
 */
@Data
public class LoginHandle implements Serializable {
    private static final long serialVersionUID = -2786704516067092737L;
    /**
     * 用戶id
     */
    private Long id;
    /**
     * 用戶手机号
     */
    private  String phone;
    /**
     * 用户密码
     */
    private String  password;
    /**
     * 用户名
     */
    private String name;



}
