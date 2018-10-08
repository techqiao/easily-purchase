package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("中标服务费缴费")
public class ServicePayVO implements Serializable {
    @ApiModelProperty("标段id")
    private Long bidId;
    @ApiModelProperty("标段名称")
    private String bidName;
    @ApiModelProperty("中标金额")
    private BigDecimal bidMoney;
    @ApiModelProperty("服务费金额")
    private BigDecimal serviceMoney;
    @ApiModelProperty("缴纳状态")
    private String status;
}
