package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;


/**
 * 供应商注册详情
 * @author donghuan
 */
@Data
public class HandleSupplierDetail implements Serializable {

    private static final long serialVersionUID = 8608242287921574415L;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 供应商注册id
     */
    private Long supplierId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一信用代码
     */
    private String uniformCreditCode;

    /**
     * 营业执照照片url
     */
    private String businessLicense;

    /**
     * 法人身份证正面照片url
     */
    private String legalIdCardPositive;

    /**
     * 法人身份证反面照片url
     */
    private String legalIdCardOther;

    /**
     * 带公章的授权书照片url
     */
    private String certificateOfAuthorization;

    /**
     * 经办人(运营商员工)手持身份证正面照片url
     */
    private String operatorIdCardFront;

    /**
     * 资质证书url
     */
    private String qualificationCertificate;

    /**
     * 所在地区
     */
    private String[] location;

    /**
     * 对公银行名称
     */
    private String publicBankName;

    /**
     * 对公银行账号
     */
    private String publicBankCount;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 密码
     */
    private String password;


}
