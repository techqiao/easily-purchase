package com.epc.web.facade.bidding.query.downLoad;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class QueryProgramPayDTO implements Serializable {

    private static final long serialVersionUID = -7947117795961660137L;
    private Long procurementProjectId;
    private Long purchaserId;
    private Long companyId;
    private BigDecimal money;
}
