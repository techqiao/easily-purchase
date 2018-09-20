package com.epc.web.facade.terdering.bid.query;

import com.epc.common.PagerParam;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 19:06
 * <p>@Author : wjq
 */
@Data
public class QueryBidsDTO extends PagerParam {

    private Long purchaseProjectId;

}
