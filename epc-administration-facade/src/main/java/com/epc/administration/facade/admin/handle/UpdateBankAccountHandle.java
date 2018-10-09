package com.epc.administration.facade.admin.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:33
 * <p>@Author : luozhixin
 */
@Data
public class UpdateBankAccountHandle extends InsertBankAccountHandle implements Serializable {
    private static final long serialVersionUID = 2472136764880753354L;
    /**
     * 主键id
     */
    private Long id;

}
