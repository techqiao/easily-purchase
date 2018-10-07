package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 运营商修改员工信息
 */
@Data
public class HandleOperatorUpdateEmployeeById implements Serializable {

    private static final long serialVersionUID = 7782843166198100959L;
    /**
     *  是什么角色
     */
    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;


    /**
     * 员工id(点哪个就是哪个)
     */
    private Long id;

    /**
     * 要修改员工的名字
     */
    private String name;

    /**
     * 要修改员工的电话
     */
    private String cellphone;

    /**
     * role 角色
     */
    private Integer role;

    /**
     * 是否禁用
     */
    private Integer isForbidden;


    /**
     * 修改自己的密码
     */
//    private String password;



}
