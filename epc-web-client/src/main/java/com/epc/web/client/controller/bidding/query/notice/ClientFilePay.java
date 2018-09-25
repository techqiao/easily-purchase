package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
@ApiModel(value = "ClientFilePay",description = "下载文件支付查询")
public class ClientFilePay {

    @ApiModelProperty(value = "采购项目Id")
    private Long procurementProjectId;
    @ApiModelProperty(value = "采购人id")
    private Long purchaserId;
    @ApiModelProperty(value = "下载机构ID")
    private Long companyId;
    @ApiModelProperty(value = "应付下载金额")
    private BigDecimal money;
}
