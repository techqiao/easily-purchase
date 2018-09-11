package com.epc.administration.facade.operator.handle;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : 运营商完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
public class HandleOperatorDetailIfo {

    //运营商法人Id
    @NotEmpty(message = "OperatorDetailIfo.cellphone.null")
    private Long operatorId;
    //公司名称
    @NotEmpty(message = "OperatorDetailIfo.companyName.null")
    private String companyName;
    //对公银行名称
    @NotEmpty(message = "OperatorDetailIfo.publicBankName.null")
    private String publicBankName;
    //对公银行账号
    @NotEmpty(message = "OperatorDetailIfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;
    //资质证书url
    @NotEmpty(message = "OperatorDetailIfo.qualificationCertificate.null")
    private String qualificationCertificate;


}
