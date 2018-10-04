package com.epc.administration.facade.reviewexpert.handle;

import lombok.Data;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-27 13:49
 * <p>@Author : luozhixin
 * <p>ExamineExpertHandle
 */
@Data
public class ExamineExpertHandle {

    /**
     * 评审专家用户id
     */
    private Long expertId;

    /**
     * 评审专家用户状态
     */
    private int state;
}
