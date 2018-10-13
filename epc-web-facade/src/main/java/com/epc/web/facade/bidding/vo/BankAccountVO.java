package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * @Description: 银行信息
 * @Author: linzhixiang
 * @Date: 2018/10/13
 */ 
@Data
@ApiModel("银行信息")
public class BankAccountVO implements Serializable {
    private static final long serialVersionUID = 2995426196744066280L;
    @ApiModelProperty("收款单位")
    private String proceedsUnit;
    @ApiModelProperty("开户银行")
    private String bankOfDeposit;
    @ApiModelProperty("收款账号")
    private String shroffAccountNumber;
    @ApiModelProperty("大额行号")
    private String wholesaleLineNumber;
    @ApiModelProperty("同城行号")
    private String locationLineNumber;
    @ApiModelProperty("需要交费金额")
    private BigDecimal money;

}
