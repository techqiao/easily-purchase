package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author linzhixiang
 */
@ApiModel(value = "支付")
@Data
public class MoneyPayVO implements Serializable {
    @ApiModelProperty(value = "标段Id")
    private Long bidId;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
    @ApiModelProperty(value = "标段金额")
    private BigDecimal bidMoney;
    @ApiModelProperty(value = "状态")
    private String status;
}
