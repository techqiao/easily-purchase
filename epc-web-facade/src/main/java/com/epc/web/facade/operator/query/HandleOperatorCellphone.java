package com.epc.web.facade.operator.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorCellphone implements Serializable {
    private static final long serialVersionUID = 1834049633684570852L;

    /**
     * 电话
     */
    private String cellphone;

    /**
     * 是否删除
     */
    private Integer isDeleted;

}
