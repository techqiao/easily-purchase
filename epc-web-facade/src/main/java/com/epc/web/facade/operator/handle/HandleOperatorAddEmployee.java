package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorAddEmployee implements Serializable {

    private static final long serialVersionUID = -1222610669844392396L;

    /**
     *  是什么角色
     */
    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;

    /**
     * 员工id(运营商id)
     */
    private Long loginId;


    /**
     * 要添加的员工名字
     */
    private String name;

    /**
     * 要添加的员工电话
     */
    private String cellphone;

    /**
     * 要添加的员工的密码
     */
    private String password;



    /**
     * 员工的角色
     */
    private Integer role;


}
