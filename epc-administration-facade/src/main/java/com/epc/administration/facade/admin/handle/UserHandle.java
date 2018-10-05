package com.epc.administration.facade.admin.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:28
 * <p>@Author : luozhixin
 */
@Data
public class UserHandle implements Serializable {
    private static final long serialVersionUID = -2906415443589618056L;
    /**
     * 用户姓名
     */
    private  String name;
    /**
     * 手机号
     */
    private  String phone;
    /**
     * 用户密码
     */
    private String  password;
    /**
     * 用户的部门id
     */
    private  Long deptId;
    /**
     * 用户是否删除 0 正常 1 删除
     */
    private int isDeleted;
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户所拥有的角色
     */
    private Long[] roles;

}
