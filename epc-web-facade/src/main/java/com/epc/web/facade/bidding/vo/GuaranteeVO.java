package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 15:46
 * <p>@Author : luozhixin
 * <p>GuaranteeVO
 */
@Data
public class GuaranteeVO {

    /**
     * 采购项目ID
     */
    private  Long procurementProjectId;
    /**
     * 发售招标文件表主键ID
     */
    private Long bIssueDocumentsId;
    /**
     * 投标保证金
     */
    private BigDecimal tenderGuaranteeAmount;
    /**
     * 标段名称
     */
    private String bidsName;
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 收款单位
     */
    private String receivables;
    /**
     *开户行帐号
     */
    private String bankAccount;

    /**
     * 标段保证金ID
     */
    private Long bidsGuaranteeAmountId;
    /**
     * 投标人ID
     */
    private Long tendererId;
    /**
     * 投标人单位ID
     */
    private Long tendererCompanyId;
    /**
     * 投标人姓名
     */
    private String tendererName;
    /**
     * 投标人单位
     */
    private String tendererCompanyName;
    /**
     * 付款时间
     */
    private Date amountMoneyTime;
    /**
     * 到账金额
     */
    private String amountMoney;
    /**
     * 付款人姓名
     */
    private String paymentName;
    /**
     * 支付账户
     */
    private String paymentAccountNumber;
    /**
     * 付款人ID
     */
    private Long paymentId;
}
