package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 22:50
 * <p>@Author : luozhixin
 * <p>CodeHandle
 */
@Data
public class CodeHandle implements Serializable {
    private static final long serialVersionUID = 6704460942985118510L;
    private List<String> method;
}
