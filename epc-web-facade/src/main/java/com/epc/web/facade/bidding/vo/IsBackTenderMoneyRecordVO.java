package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class IsBackTenderMoneyRecordVO implements Serializable {
    private static final long serialVersionUID = -966103363414203576L;
    private String projectCode;
    private String projectName;
    private String bidsName;
    private String bidsCode;
    private Boolean isBack;
}
