package com.epc.administration.facade.purchaser.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 13:50
 * <p>@Author : luozhixin
 * <p>PurchaserForbiddenHandle
 */
@Data
public class PurchaserForbiddenHandle implements Serializable {

    private static final long serialVersionUID = 1694713788498403082L;

    private Long id;

    private Integer isForbidden;
}
