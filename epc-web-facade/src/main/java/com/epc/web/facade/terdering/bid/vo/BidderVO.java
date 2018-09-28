package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:02
 * <p>@Author : wjq
 */
@Data
public class BidderVO {
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 供应商ID
     */
    private Long supplierId;
    /**
     * 供应商公司名称
     */
    private String supplierCompanyName;
    /**
     * 状态 待评分 已评分
     */
    private String status;
}
