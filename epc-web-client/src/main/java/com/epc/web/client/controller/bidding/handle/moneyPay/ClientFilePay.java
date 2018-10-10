package com.epc.web.client.controller.bidding.handle.moneyPay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "平台插入支付记录")
public class ClientFilePay implements Serializable {
    @ApiModelProperty(value = "采购项目Id")
    private Long purchaseProjectFileId;
    @ApiModelProperty(value = "实付金额")
    private BigDecimal filePaymentReal;
    @ApiModelProperty(value = "公司ID")
    private Long companyId;

}
