package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorIdAndIsDeleted implements Serializable {
    private static final long serialVersionUID = 7365873978719281934L;

    /**
     *  是什么角色
     */
//    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;


    private Long id;

    private Integer isDeleted;


}
