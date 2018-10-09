package com.epc.web.client.controller.bidding.query.moneyPay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel
public class ClientMoneyPayRecordDTO implements Serializable {

    private static final long serialVersionUID = 4221608538190868410L;
    @ApiModelProperty("采购项目id")
    private Long purchaseProjectId;
}
