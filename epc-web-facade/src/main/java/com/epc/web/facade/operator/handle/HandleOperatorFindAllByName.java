package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorFindAllByName implements Serializable {

    private static final long serialVersionUID = -5503378128453752419L;
    /**
     *  员工id=运营商的（法人）id
     */
    private Long id;

    /**
     * 输入查询的员工名字
     */
    private String name;

}
