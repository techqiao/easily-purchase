package com.epc.administration.facade.operator.handle;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 12:05
 * <p>@Author : luozhixin
 * <p>OperatorForbiddenHandle
 */
@Data
public class OperatorForbiddenHandle implements Serializable {
    private static final long serialVersionUID = 4679379294721214046L;
    /**
     * 主键id
     */
    private  Long id;

    /**
     * 是否锁定 0 启用 1 锁定
     */
    private Integer isForbidden;
}
