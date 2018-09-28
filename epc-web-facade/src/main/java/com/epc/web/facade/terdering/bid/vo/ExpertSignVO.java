package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 20:00
 * <p>@Author : wjq
 */
@Data
public class ExpertSignVO {
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 评标专家ID
     */
    private Long expertId;
    /**
     * 评标专家姓名
     */
    private String expertName;
    /**
     * 评标专家电话
     */
    private String expertPhone;
    /**
     * 是否已签到
     */
    private Integer isSign;
}
