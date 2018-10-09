package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class HandleWinBid implements Serializable {

    private Long bidId;

    private Long projectId;

    private Long procurementProjectId;

    private Long firstSupplierid;

    private BigDecimal firstPrice;

    private Long twoSupplierid;

    private BigDecimal twoPrice;

    private Long threeSupplierid;

    private BigDecimal threePrice;

    private String firstCompanyname;

    private String twoCompanyname;

    private String threeCompanyname;

    private Long purchaserId;

    private Long BossId;

    private Date openStart;

    private Date openEnd;
    private String filePath;


}
