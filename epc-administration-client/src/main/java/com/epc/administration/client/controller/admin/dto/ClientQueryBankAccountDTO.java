package com.epc.administration.client.controller.admin.dto;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:44
 * <p>@Author : luozhixin
 */
@Data
public class ClientQueryBankAccountDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = 984368642584612787L;

    @ApiModelProperty(value = "收款类型")
    @NotEmpty(message = "ClientQueryBankAccountDTO.type.null")
    private Integer type;

    @ApiModelProperty(value = "开户银行")
    @NotEmpty(message = "ClientQueryBankAccountDTO.bankOfDeposit.null")
    private String bankOfDeposit;

}
