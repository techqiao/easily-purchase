package com.epc.administration.facade.admin.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:33
 * <p>@Author : luozhixin
 */
@Data
public class InsertBankAccountHandle implements Serializable {
    private static final long serialVersionUID = -5807760639259975413L;
    /**
     * 收款单位
     */
    private String proceedsUnit;

    /**
     * 开户银行
     */
    private String bankOfDeposit;

    /**
     * 收款账号
     */
    private String shroffAccountNumber;

    /**
     * 大额行号
     */
    private String wholesaleLineNumber;

    /**
     * 同城行号
     */
    private String locationLineNumber;

    /**
     * 收款类型
     */
    private Integer paymentType;

}
