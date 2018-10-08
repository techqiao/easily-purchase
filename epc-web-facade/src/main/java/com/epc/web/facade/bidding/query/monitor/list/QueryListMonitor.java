package com.epc.web.facade.bidding.query.monitor.list;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryListMonitor implements Serializable {
    private static final long serialVersionUID = -5943163057299475317L;
    private  Long supplier;
    private Long bossId;
}
