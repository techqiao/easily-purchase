package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linzhixiang
 */
@Data
public class MoneyPayVO implements Serializable {

    /**
     * 标段Id
     */
    private Long bidId;

    /**
     * 标段名称
     */
    private String bidName;

    /**
     * 标段金额
     */
    private BigDecimal bidMoney;

    /**
     * 服务费金额
     */
    private BigDecimal serviceMoney;

    /**
     * 状态
     */
    private Integer status;
}
