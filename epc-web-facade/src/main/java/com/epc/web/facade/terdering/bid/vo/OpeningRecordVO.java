package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 10:22
 * <p>@Author : wjq
 */
@Data
public class OpeningRecordVO {
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 提交投标文件ID
     */
    private Long tenderMessageId;
    /**
     * 投标单位名称ID 供应商
     */
    private Long supplierCompanyId;
    /**
     * 投标单位名称(供应商名称)
     */
    private String supplierCompanyName;
    /**
     * 是否缴纳保证金 0 否 1是
     */
    private Integer isPayBond;
    /**
     * 是否签到 0 否 1是
     */
    private Integer isSign;
    /**
     * 标书封装检查是否合格 0 否 1是
     */
    private Integer isBiddingQualified;
    /**
     * 是否拒收标书 0 否 1是
     */
    private Integer isBiddingRefuse;
    /**
     * 拒收理由
     */
    private String biddingRefuseReason;
    /**
     * 状态 0不正常 1正常
     */
    private Integer status;
    /**
     * 操作人ID
     */
    private Long operateId;
}
