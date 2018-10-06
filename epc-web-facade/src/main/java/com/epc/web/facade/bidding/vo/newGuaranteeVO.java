package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ApiModel("缴费列表")
public class newGuaranteeVO {
    @ApiModelProperty(value = "标段Id")
    private Long bidId;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目开始时间")
    private Date startDate;
    @ApiModelProperty(value = "项目结束时间")
    private Date endDate;
    @ApiModelProperty(value = "缴费截至时间")
    private Date deadlineDate;
    @ApiModelProperty(value = "标段金额")
    private BigDecimal bidMoney;
    @ApiModelProperty(value = "金额")
    private BigDecimal serviceMoney;
    @ApiModelProperty(value = "状态")
    private String status;
}
