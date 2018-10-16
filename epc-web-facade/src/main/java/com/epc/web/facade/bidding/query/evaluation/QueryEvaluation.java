package com.epc.web.facade.bidding.query.evaluation;

import com.epc.common.PagerParam;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-16 15:05
 * <p>@Author : wjq
 */
@Data
public class QueryEvaluation extends PagerParam {
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
}
