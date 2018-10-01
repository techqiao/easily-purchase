package com.epc.administration.facade.reviewexpert.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 14:03
 * <p>@Author : luozhixin
 * <p>ExpertForbiddenHandle
 */
@Data
public class ExpertForbiddenHandle implements Serializable {

    private static final long serialVersionUID = 1209673802859561152L;
    private Long id;

    private Integer isForbidden;
}
