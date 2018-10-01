package com.epc.web.facade.loginuser.dto;

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
public class RegisterDto implements Serializable {
    private static final long serialVersionUID = -8746674454679315502L;
    private String cellphone;
    private String password;
    private Long id;
}
