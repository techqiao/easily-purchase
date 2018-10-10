package com.epc.web.facade.operator.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorFindAllByName implements Serializable {

    private static final long serialVersionUID = -5503378128453752419L;

    /**
     *  当前登陆人的id
     */
//    private Long id;
    /**
     *  是什么角色
     */
//    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;

    // 当前 登陆人的法人 id
    private Long bossId;



    /**
     * 输入查询的员工名字
     */
    private String name;

    //role 角色
    private Integer role;

    //是否禁用
    private Integer isForbidden;

}
