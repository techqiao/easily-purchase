package com.epc.administration.facade.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 14:24
 * <p>@Author : luozhixin
 */
@Data
public class BankAccountVO implements Serializable {
    private static final long serialVersionUID = -3202914450905773046L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;
    /**
     * 收款单位
     */
    @ApiModelProperty("收款单位")
    private String proceedsUnit;

    /**
     * 开户银行
     */
    @ApiModelProperty("开户银行")
    private String bankOfDeposit;

    /**
     * 收款账号
     */
    @ApiModelProperty("收款账号")
    private String shroffAccountNumber;

    /**
     * 大额行号
     */
    @ApiModelProperty("大额行号")
    private String wholesaleLineNumber;
    /**
     * 同城行号
     */
    @ApiModelProperty("同城行号")
    private String locationLineNumber;

    /**
     * 收款类型
     */
    @ApiModelProperty("收款类型")
    private Integer paymentType;
}
