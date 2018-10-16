package com.epc.mobile.facade.loginer.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/10/1
 */
@Data
public class RegisterUser implements Serializable {
    private static final long serialVersionUID = -8746674454679315502L;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;
    /**
     * 注册类型
     */
    private Integer type;
    /**
     * 注册姓名
     */
    private String name;
    /**
     * 验证码
     */
    private String verityCode;
    /**
     * 供货商leibie
     */
    private String categorySupplier;
}
