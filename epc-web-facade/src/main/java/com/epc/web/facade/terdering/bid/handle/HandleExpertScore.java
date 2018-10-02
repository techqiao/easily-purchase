package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 11:41
 * <p>@Author : wjq
 */
@Data
public class HandleExpertScore {
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 标段编号
     */
    private Long bidsCode;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 供应商(法人)ID
     */
    private Long supplierId;
    /**
     * 供应商公司名称
     */
    private String supplierCompanyName;
    /**
     * 技术评标分数
     */
    private Integer techTypeScore;
    /**
     * 商务评标分数
     */
    private Integer commerceTypeScore;
    /**
     * 最终评标分数
     */
    private Integer finalScore;
    /**
     * 专家ID
     */
    private Long expertId;
    /**
     * 专家姓名
     */
    private String expertName;
    /**
     * 操作人ID
     */
    private Long operateId;

}
