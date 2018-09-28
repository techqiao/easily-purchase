package com.epc.web.facade.bidding.handle;

import lombok.Data;

/**
 * 评审因素
 * <p>Description : easilys
 * <p>Date : 2018-09-25 14:49
 * <p>@Author : luozhixin
 * <p>TechnologyHandle
 */
@Data
public class TechnologyHandle {

    /**
     * 评审因素
     */
    private String evaluationFactors;

    /**
     * 说明
     */
    private String explain;

    /**
     * 分值开始范围
     */
    private String dividingRangeStart;

    /**
     * 分值结束范围
     */
    private String dividingRangeEnd;
}
