package com.epc.web.facade.bidding.query.moneyPay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linzhixiang
 */
@Data
public class QueryMoneyPayDTO implements Serializable {

    private Long procurementProjectId;

    private Long companyId;


}
