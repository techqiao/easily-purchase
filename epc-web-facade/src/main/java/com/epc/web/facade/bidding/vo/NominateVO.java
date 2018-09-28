package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class NominateVO implements Serializable {
    private static final long serialVersionUID = 1181266872890463344L;
    /**
     * 记录Id
     */
    private Long id;

    /**
     * 第一中标人id
     */
    private Long firstSupplierid;
    /**
     * 第一中标人姓名
     */
    private String firstCompanyname;
    /**
     * 第一中标人中标金额
     */
    private BigDecimal firstPrice;
    /**
     * 第二中标人id
     */
    private Long twoSupplierid;
    /**
     * 第二中标人中标金额
     */
    private BigDecimal twoPrice;
    /**
     * 第二中标人姓名
     */
    private String twoCompanyname;
    /**
     * 第三中标人id
     */
    private Long threeSupplierid;
    /**
     * 第三中标人中标金额
     */
    private BigDecimal threePrice;
    /**
     * 第三中标人姓名
     */
    private String threeCompanyname;
}
