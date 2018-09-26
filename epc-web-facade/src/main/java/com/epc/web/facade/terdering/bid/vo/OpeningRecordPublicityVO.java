package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 18:14
 * <p>@Author : wjq
 */
@Data
public class OpeningRecordPublicityVO {
    /**
     * 唱标信息附件
     */
    private String filePath;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 标段ID
     */
    private Long bidsId;

}
