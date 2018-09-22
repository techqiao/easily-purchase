package com.epc.web.facade.terdering.preview.dto;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:33
 * <p>@Author : luozhixin
 * <p>QueryWhere
 */
public class QueryWhere implements Serializable {

    private static final long serialVersionUID = -6385951372729314856L;
    private  Long prID;

    public Long getPrID() {
        return prID;
    }

    public void setPrID(Long prID) {
        this.prID = prID;
    }
}
