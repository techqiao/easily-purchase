package com.epc.web.facade.operator.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorId implements Serializable {

    private static final long serialVersionUID = -5053120932062748529L;


    /**
     *  是什么角色
     */
//    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;

    /**
     * 员工id(运营商id)
     */
    private Long loginId;

    /**
     * 法人id
     */
    private Long bossId;



}
