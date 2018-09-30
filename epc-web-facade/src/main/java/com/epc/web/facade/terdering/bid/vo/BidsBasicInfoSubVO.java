package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 18:02
 * <p>@Author : wjq
 */
@ApiModel(value = "标段详情")
@Data
public class BidsBasicInfoSubVO extends BidsBasicInfoVO implements Serializable {
    private static final long serialVersionUID = 4350117270881291030L;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目编号")
    private String purchaseProjectCode;
    @ApiModelProperty(value = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "预算金额")
    private BigDecimal bidBudgetaryAmount;
    @ApiModelProperty(value = "保证金金额")
    private BigDecimal guaranteePayment;
    @ApiModelProperty(value = "标段说明")
    private String bidMemo;
}
