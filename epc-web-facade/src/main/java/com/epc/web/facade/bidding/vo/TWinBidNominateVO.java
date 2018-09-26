package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TWinBidNominateVO implements Serializable {

    private static final long serialVersionUID = -6604815634815564422L;

    private Long id;

    private Long purchaserId;

    private String purchaserName;

    private String agencyName;

    private String agencyPhone;

    private Integer isPowerAgency;

    private String projectName;

    private String projectCode;

    private Long purchaseProjectId;

    private String procurementProjectName;

    private String procurementProjectCode;

    private String purchaseMode;

    private String purchaseType;

    private String purchaseContent;

    private String bidCode;

    private Long firstSupplierid;

    private String firstCompanyname;

    private BigDecimal firstPrice;

    private Long twoSupplierid;

    private BigDecimal twoPrice;

    private String twoCompanyname;

    private Long threeSupplierid;

    private BigDecimal threePrice;

    private String threeCompanyname;

    private Long winBidSupplierid;

    private Date openStart;

    private Date openEnd;

}
