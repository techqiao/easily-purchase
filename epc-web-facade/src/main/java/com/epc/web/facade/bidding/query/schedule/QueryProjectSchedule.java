package com.epc.web.facade.bidding.query.schedule;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryProjectSchedule implements Serializable {
    private static final long serialVersionUID = 1918404524708265032L;
    private Long purchaseProjectId;
    private String operateType;
}
