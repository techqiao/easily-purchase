package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorLoginInfo implements Serializable {


    private static final long serialVersionUID = 7421331888941810560L;
    /**
     *  是什么角色
     */
    private Integer systemRole;

    // 登陆时的用户角色
    private Long id;

    //登陆人的bossid
    private Long bossId;

}
