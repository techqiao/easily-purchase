package com.epc.web.facade.terdering.bid.query;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 19:06
 * <p>@Author : wjq
 */
@Data
public class QueryBidsDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = -8086278045980297780L;
    private Long purchaseProjectId;

    public Long getPurchaseProjectId() {
        return purchaseProjectId;
    }

    public void setPurchaseProjectId(Long purchaseProjectId) {
        this.purchaseProjectId = purchaseProjectId;
    }
}
