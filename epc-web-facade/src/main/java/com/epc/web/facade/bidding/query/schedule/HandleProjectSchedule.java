package com.epc.web.facade.bidding.query.schedule;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleProjectSchedule implements Serializable  {

    private Long projectId;

    private Long purchaseProjectId;

    private String procedureName;

    private String operateType;
}
