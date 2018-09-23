package com.epc.web.client.controller.bidding.query.moneyPay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ClientMoneyPayRecordDTO implements Serializable {

    private Long moneyPayId;

    private Long operaterId;

    private String operaterName;

    private BigDecimal serviceMoney;
}
