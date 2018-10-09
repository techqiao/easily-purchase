package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("中标服务费缴费")
public class ServiceBackVO implements Serializable {

    @ApiModelProperty("项目编号")
    private String projectCode;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("标段编号")
    private String bidCode;
    @ApiModelProperty("标段名称")
    private String bidName;
    @ApiModelProperty("保证金金额")
    private BigDecimal bidMoney;
    @ApiModelProperty("退还缴纳状态")
    private String status;
}
