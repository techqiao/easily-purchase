package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Description : 保证金
 * <p>Date : 2018-09-25 13:43
 * <p>@Author : wjq
 */
@Data
public class BidsGuaranteeAmountVO {
    /**
     * ID
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
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
     * 标段编号
     */
    private String bidsCode;
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 收款单位
     */
    private String receivables;
    /**
     * 开户行帐号
     */
    private String bankAccount;
    /**
     * 操作人ID
     */
    private Long operateId;

}
