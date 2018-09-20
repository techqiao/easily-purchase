package com.epc.web.facade.operator.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OperatorDetailInfoVO implements Serializable {

    private static final long serialVersionUID = 6630370496984682864L;


    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一信用代码
     */
    private String uniformCreditCode;

    /**
     * 对公银行名称
     */
    private String publicBankName;

    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;

}
