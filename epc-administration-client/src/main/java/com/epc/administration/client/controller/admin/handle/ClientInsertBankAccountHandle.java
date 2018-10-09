package com.epc.administration.client.controller.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:24
 * <p>@Author : luozhixin
 */
@Data
public class ClientInsertBankAccountHandle implements Serializable {
    private static final long serialVersionUID = 7253482263109527708L;

    @ApiModelProperty(value = "收款单位")
    @NotEmpty(message = "ClientInsertBankAccountHandle.proceedsUnit.null")
    private String proceedsUnit;

    @ApiModelProperty(value = "开户银行")
    @NotEmpty(message = "ClientInsertBankAccountHandle.bankOfDeposit.null")
    private String bankOfDeposit;

    @ApiModelProperty(value = "收款账号")
    @NotEmpty(message = "ClientInsertBankAccountHandle.shroffAccountNumber.null")
    private String shroffAccountNumber;

    @ApiModelProperty(value = "大额行号")
    @NotEmpty(message = "ClientInsertBankAccountHandle.wholesaleLineNumber.null")
    private String wholesaleLineNumber;

    @ApiModelProperty(value = "同城行号")
    @NotEmpty(message = "ClientInsertBankAccountHandle.locationLineNumber.null")
    private String locationLineNumber;

    @ApiModelProperty(value = "收款类型")
    @NotEmpty(message = "ClientInsertBankAccountHandle.paymentType.null")
    private Integer paymentType;
}
