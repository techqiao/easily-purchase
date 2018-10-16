package com.epc.web.facade.bidding.query.monitor.list;

import com.epc.common.QueryRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryListMonitor extends QueryRequest implements Serializable {
    private static final long serialVersionUID = -5943163057299475317L;
    private  Long supplier;
    private Long bossId;
    private String projectName;
    private String purchaseMode ;
    private Integer isEnd;
}
