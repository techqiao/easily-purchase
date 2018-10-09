package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("缴费记录")
public class PayListForAllVO implements Serializable {
    @ApiModelProperty("流水编号")
    private String payCode;
    @ApiModelProperty("项目编号")
    private String projectCode;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("项目开始时间")
    private String startDate;
    @ApiModelProperty("项目结束时间")
    private String endDate;
    @ApiModelProperty("采购标段id")
    private Long bidId;
    @ApiModelProperty("采购标段名称")
    private String bidName;
    @ApiModelProperty("支付状态")
    private String payStatus;
}
