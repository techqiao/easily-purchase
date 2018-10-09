package com.epc.web.facade.bidding.query.moneyPay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class QueryMoneyPayRecordDTO implements Serializable {

    private Long operaterId;

    private String operaterName;

    private Long companyId;

    private Long purchaseProjectId;
}
