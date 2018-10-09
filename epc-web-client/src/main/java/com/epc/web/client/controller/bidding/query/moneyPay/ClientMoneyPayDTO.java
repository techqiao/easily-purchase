package com.epc.web.client.controller.bidding.query.moneyPay;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linzhixiang
 */
@Data
public class ClientMoneyPayDTO implements Serializable {
    private static final long serialVersionUID = 2447185530802838759L;
    private Long companyId;

    private Long purchaseProjectId;

}
