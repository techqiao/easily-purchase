package com.epc.web.client.controller.bidding.query.tender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "标段查询",description = "查询标段保证金支付情况")
@Data
public class ClientBidPay {
    @ApiModelProperty(value = "公告Id")
    private Long id;
}
