package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class HandleGuaranteeAmountPay implements Serializable {

    private static final long serialVersionUID = -1144436275203450312L;

    private Long procurementProjectId;

    private Long bIssueDocumentsId;

    private BigDecimal tenderGuaranteeAmount;

    private String bidsName;

    private String bidsCode;

    private Long bidsId;

    private String receivables;

    private String bankAccount;

    private Long operateId;

}
