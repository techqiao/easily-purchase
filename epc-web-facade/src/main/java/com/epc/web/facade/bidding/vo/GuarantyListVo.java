package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GuarantyListVo implements Serializable {
    private static final long serialVersionUID = -1581186297617995404L;
    @ApiModelProperty(value = "标段Id")
    private Long bidId;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
    @ApiModelProperty(value = "采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购项目编号")
    private String purchaseProjectCode;
    @ApiModelProperty(value = "标段金额")
    private BigDecimal bidMoney;
    @ApiModelProperty(value = "金额")
    private BigDecimal serviceMoney;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
