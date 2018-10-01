package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "中标通知详情")
@Data
public class NominateVO implements Serializable {
    private static final long serialVersionUID = 1181266872890463344L;
    @ApiModelProperty(value = "记录Id")
    private Long id;
    @ApiModelProperty(value = "第一中标人id")
    private Long firstSupplierid;
    @ApiModelProperty(value = "第一中标人姓名")
    private String firstCompanyname;
    @ApiModelProperty(value = "第一中标人中标金额")
    private BigDecimal firstPrice;
    @ApiModelProperty(value = "第二中标人id")
    private Long twoSupplierid;
    @ApiModelProperty(value = "第二中标人中标金额")
    private BigDecimal twoPrice;
    @ApiModelProperty(value = "第二中标人姓名")
    private String twoCompanyname;
    @ApiModelProperty(value = "第三中标人id")
    private Long threeSupplierid;
    @ApiModelProperty(value = "第三中标人中标金额")
    private BigDecimal threePrice;
    @ApiModelProperty(value = "第三中标人姓名")
    private String threeCompanyname;
}
