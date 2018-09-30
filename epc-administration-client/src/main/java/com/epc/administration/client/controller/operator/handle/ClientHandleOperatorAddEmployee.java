package com.epc.administration.client.controller.operator.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 17:07
 * <p>@Author : luozhixin
 * <p>ClientHandleOperatorAddEmployee
 */
@Data
public class ClientHandleOperatorAddEmployee implements Serializable {
    private static final long serialVersionUID = 4460044397363708341L;
    /**
     * 运营商id
     */
    @ApiModelProperty(value = "运营商id",notes = "操作者id")
    private Long id;
    /**
     * 手机号(登录账号)
     */
    private String cellphone;
    /**
     * 员工姓名
     */
    private String  name;
    /**
     * 员工登录密码
     */
    private String password;
    /**
     * 员工角色
     */
    private String role;

}
