package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HandleWinBidding implements Serializable {
    private Long id;
    private Long supplierId;
    private String supplierName;
    private BigDecimal money;
    private String filePath;
}
