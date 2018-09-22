package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WinBidVO implements Serializable {

    private static final long serialVersionUID = 1655676185679171880L;

    private Long id;

    private String procurementProjectName;

    private String bidName;

    private BigDecimal purchaserMonety;

    private String sort;

    private Long supplierId;

    private String supplierName;

}
