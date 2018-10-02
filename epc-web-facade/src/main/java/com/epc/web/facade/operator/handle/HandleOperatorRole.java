package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorRole implements Serializable {
    private static final long serialVersionUID = -2118661856286487712L;

    /**
     * 用户的id
     */
    private Long id;

    /**
     * 用户当前的角色
     */
    private Integer role;

}
