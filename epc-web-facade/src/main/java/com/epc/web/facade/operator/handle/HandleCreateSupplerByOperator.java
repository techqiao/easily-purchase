package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 运营商新增供应商
 */
@Data
public class HandleCreateSupplerByOperator implements Serializable {


    private static final long serialVersionUID = -5734560461282371421L;

    /**
     * 运营商员工主键id
     */
    private Long id;

    /**
     * 供应商法人姓名
     */
    private String name;

    /**
     * 手机号(登录账号)
     */
    private String cellphone;

    /**
     * 供应商姓名
     */
    private String supplierName;

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

    /**
     * 来源(public,private)
     */
    private String source;


    /**
     * 供应商的公司名字
     */
    private String companyName;



}
