package com.epc.administration.facade.supplier.handle;

import lombok.Data;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 13:58
 * <p>@Author : luozhixin
 * <p>ExamineSupplierHandle
 */
@Data
public class ExamineSupplierHandle {

    /**
     * 供应商用户id
     */
    private Long supplierId;

    /**
     * 供应商用户状态
     */
    private int state;
}
