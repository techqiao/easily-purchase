package com.epc.web.client.controller.bidding.handle.winBid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "中标公告")
public class ClientWinBid implements Serializable {
    @ApiModelProperty(value = "标段ID")
    private Long bidId;
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "第一中标人ID")
    private Long firstSupplierid;
    @ApiModelProperty(value = "第一中标人金额")
    private BigDecimal firstPrice;
    @ApiModelProperty(value = "第一中标人姓名")
    private String firstCompanyname;
    @ApiModelProperty(value = "第二中标人ID")
    private Long twoSupplierid;
    @ApiModelProperty(value = "第二中标人金额")
    private BigDecimal twoPrice;
    @ApiModelProperty(value = "第二中标人姓名")
    private String twoCompanyname;
    @ApiModelProperty(value = "第三中标人ID")
    private Long threeSupplierid;
    @ApiModelProperty(value = "第三中标人金额")
    private BigDecimal threePrice;
    @ApiModelProperty(value = "第三中标人姓名")
    private String threeCompanyname;

}
