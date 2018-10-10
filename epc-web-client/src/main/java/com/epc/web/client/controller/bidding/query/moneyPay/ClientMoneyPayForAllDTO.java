package com.epc.web.client.controller.bidding.query.moneyPay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linzhixiang
 */
@Data
@ApiModel("缴费记录-保证金")
public class ClientMoneyPayForAllDTO implements Serializable {
    private static final long serialVersionUID = 2447185530802838759L;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("项目状态")
    private Integer projectStatus;
    @ApiModelProperty("支付状态")
    private String payStatus;
}
