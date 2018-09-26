package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:43
 * <p>@Author : wjq
 */
@Data
public class HandleExpertSign {
    /**
     * 评标专家ID
     */
    private Long expertId;
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 是否为组长
     */
    private Integer isLeader;
    /**
     * 操作人ID
     */
    private Long operateId;

}
