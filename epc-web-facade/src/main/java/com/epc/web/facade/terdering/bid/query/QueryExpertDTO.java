package com.epc.web.facade.terdering.bid.query;

import com.epc.common.PagerParam;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-13 10:14
 * <p>@Author : wjq
 */
@Data
public class QueryExpertDTO extends PagerParam {
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
}
