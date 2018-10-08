package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorCreateSupplier implements Serializable {
    private static final long serialVersionUID = -5736211877520353729L;

    /**
     *  是什么角色
     */
    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;

    // 当前 登陆人的法人 id
    private Long bossId;

    /**
     * 运营商员工主键id
     */
    private Long id;



    /**
     * 供应商法人姓名
     */
    private String name;

    /**
     * 手机号(登录账号)
     */
    private String cellphone;






}
