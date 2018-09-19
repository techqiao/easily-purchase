package com.epc.web.facade.bidding.query.downLoad;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QueryProgramPayDTO {

    private Long procurementProjectId;
    private Long purchaserId;
    private Long companyId;
    private BigDecimal money;
}
