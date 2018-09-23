package com.epc.web.client.controller.bidding.query.moneyPay;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linzhixiang
 */
@Data
public class ClientMoneyPayDTO implements Serializable {

    private Long procurementProjectId;

    private Long companyId;


}
