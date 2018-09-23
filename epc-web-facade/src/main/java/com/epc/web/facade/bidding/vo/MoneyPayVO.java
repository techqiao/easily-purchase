package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linzhixiang
 */
@Data
public class MoneyPayVO implements Serializable {

    private Long bidId;

    private String bidName;

    private BigDecimal bidMoney;

    private BigDecimal serviceMoney;

    private Integer status;

}
