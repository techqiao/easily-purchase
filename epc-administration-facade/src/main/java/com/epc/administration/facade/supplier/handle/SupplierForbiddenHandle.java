package com.epc.administration.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 14:26
 * <p>@Author : luozhixin
 * <p>SupplierForbiddenHandle
 */
@Data
public class SupplierForbiddenHandle implements Serializable {
    private static final long serialVersionUID = -8103054761108180882L;

    private Long id;

    private Integer isForbidden;
}
