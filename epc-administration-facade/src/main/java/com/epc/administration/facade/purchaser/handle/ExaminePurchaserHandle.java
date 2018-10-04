package com.epc.administration.facade.purchaser.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 12:02
 * <p>@Author : luozhixin
 * <p>ExaminePurchaserHandle
 */
@Data
public class ExaminePurchaserHandle implements Serializable {

    private static final long serialVersionUID = 2422282308712763793L;

    /**
     * 采购人用户id
     */
    private Long purchaserId;

    /**
     * 采购人用户状态
     */
    private int state;
}
