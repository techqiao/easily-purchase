package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HandleWinBid implements Serializable {

    private Long bidId;

    private Long projectId;

    private Long procurementProjectId;

    private Long firstSupplierid;

    private BigDecimal firstPrice;

    private Long twoSupplierid;

    private BigDecimal twoPrice;

    private Long threeSupplierid;

    private BigDecimal threePrice;

}
