package com.epc.administration.facade.operator.handle;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : 运营商完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
public class HandleOperatorDetailIfo {

    //运营商法人Id
    @NotEmpty(message = "OperatorDetailIfo.operatorId.null")
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
    //营业执照照片url
    @NotEmpty(message = "OperatorDetailIfo.businessLicense.null")
    private String businessLicense;
    //法人身份证正面照片url
    @NotEmpty(message = "OperatorDetailIfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    //法人身份证反面照片url
    @NotEmpty(message = "OperatorDetailIfo.legalIdCardOther.null")
    private String legalIdCardOther;
    //带公章的授权书照片url
    @NotEmpty(message = "OperatorDetailIfo.certificateOfAuthorization.null")
    private String certificateOfAuthorization;
    //经办人(运营商员工)手持身份证正面照片url
    @NotEmpty(message = "OperatorDetailIfo.operatorIdCardFront.null")
    private String operatorIdCardFront;


    public Long getOperatorId() {
        return operatorId;
    }

    public HandleOperatorDetailIfo setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public HandleOperatorDetailIfo setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPublicBankName() {
        return publicBankName;
    }

    public HandleOperatorDetailIfo setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName;
        return this;
    }

    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }

    public HandleOperatorDetailIfo setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber;
        return this;
    }

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public HandleOperatorDetailIfo setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
        return this;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public HandleOperatorDetailIfo setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
        return this;
    }

    public String getLegalIdCardPositive() {
        return legalIdCardPositive;
    }

    public HandleOperatorDetailIfo setLegalIdCardPositive(String legalIdCardPositive) {
        this.legalIdCardPositive = legalIdCardPositive;
        return this;
    }

    public String getLegalIdCardOther() {
        return legalIdCardOther;
    }

    public HandleOperatorDetailIfo setLegalIdCardOther(String legalIdCardOther) {
        this.legalIdCardOther = legalIdCardOther;
        return this;
    }

    public String getCertificateOfAuthorization() {
        return certificateOfAuthorization;
    }

    public HandleOperatorDetailIfo setCertificateOfAuthorization(String certificateOfAuthorization) {
        this.certificateOfAuthorization = certificateOfAuthorization;
        return this;
    }

    public String getOperatorIdCardFront() {
        return operatorIdCardFront;
    }

    public HandleOperatorDetailIfo setOperatorIdCardFront(String operatorIdCardFront) {
        this.operatorIdCardFront = operatorIdCardFront;
        return this;
    }
}
