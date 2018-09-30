package com.epc.web.facade.terdering.announcement.query;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-30 15:16
 * <p>@Author : wjq
 */
@Data
public class QueryAnnouncementVO extends PagerParam implements Serializable {
    /**
     * 采购人ID
     */
    private Long purchaserId;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
}
