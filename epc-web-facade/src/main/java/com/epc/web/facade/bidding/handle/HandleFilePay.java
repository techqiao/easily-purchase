package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linzhixiang
 */
@Data
public class HandleFilePay implements Serializable {

    private static final long serialVersionUID = 1961845577050928473L;
    private Long purchaseProjectFileId;

    private BigDecimal filePaymentReal;

    private Long companyId;

    private Long operateId;

    private String creator;

}
