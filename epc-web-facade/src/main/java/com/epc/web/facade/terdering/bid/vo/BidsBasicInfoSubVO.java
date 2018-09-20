package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 18:02
 * <p>@Author : wjq
 */
@Data
public class BidsBasicInfoSubVO extends BidsBasicInfoVO{
    /**
     * 采购项目名称
     */
    private String purchaseProjectName;
    /**
     * 采购项目编号
     */
    private String purchaseProjectCode;
    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 预算金额
     */
    private BigDecimal bidBudgetaryAmount;
    /**
     * 保证金金额
     */
    private BigDecimal guaranteePayment;
    /**
     * 标段说明
     */
    private String bidMemo;
}
