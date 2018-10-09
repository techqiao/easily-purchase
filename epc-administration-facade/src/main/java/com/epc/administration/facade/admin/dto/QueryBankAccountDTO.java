package com.epc.administration.facade.admin.dto;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:51
 * <p>@Author : luozhixin
 */
@Data
public class QueryBankAccountDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = -6383488898774231278L;
    /**
     * 收款类型
     */
    private Integer type;

    /**
     * 开户银行
     */
    private String bankOfDeposit;
}
