package com.epc.administration.facade.biddingagency.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 11:59
 * <p>@Author : luozhixin
 * <p>AgencyForbiddenHandle
 */
@Data
public class AgencyForbiddenHandle implements Serializable {
    private static final long serialVersionUID = 1728901411823109032L;

    private  Long id;

    private Integer isForbidden;
}
