package com.epc.web.facade.operator.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorCellphone implements Serializable {
    private static final long serialVersionUID = 1834049633684570852L;


    /**
     *  是什么角色
     */
    private Integer systemRole;

    // 登陆时的用户角色
    private Integer loginRole;

    /**
     * 电话
     */
    private String cellphone;

    /**
     * 是否删除
     */
    private Integer isDeleted;

}
