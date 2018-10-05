package com.epc.administration.facade.biddingagency.handle;

import lombok.Data;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 13:21
 * <p>@Author : luozhixin
 * <p>ExamineAgencyHandle
 */
@Data
public class ExamineAgencyHandle {

    /**
     * 主键id
     */
    private Long agencyId;

    /**
     * 当前状态
     */
    private int state;
}
