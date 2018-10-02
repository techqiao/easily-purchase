package com.epc.administration.facade.operator.handle;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : luozhixin
 */
@Data
public class RoleDetailInfo implements Serializable {

    private static final long serialVersionUID = -7643606947621478973L;
    /**
     * 注册人Id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 对公银行名称
     */
    private String publicBankName;

    /**
     *统一信用代码
     */
    private String uniformCreditCode;
    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;
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
     * 资质证书
     */
    private List<OperatorAttachmentHandle> qualificationCertificateList;


}
