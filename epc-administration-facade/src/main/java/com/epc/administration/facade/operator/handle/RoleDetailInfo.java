package com.epc.administration.facade.operator.handle;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
public class RoleDetailInfo implements Serializable {

    private static final long serialVersionUID = -7643606947621478973L;
    private String systemRole;
    private Long userId;
    private String companyName;
    private String publicBankName;
    private String publicBanAccountNumber;
    private String qualificationCertificate;
    private String businessLicense;
    private String legalIdCardPositive;
    private String legalIdCardOther;
    private String certificateOfAuthorization;
    private String operatorIdCardFront;

    public String getSystemRole() {
        return systemRole;
    }

    public RoleDetailInfo setSystemRole(String systemRole) {
        this.systemRole = systemRole;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public RoleDetailInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RoleDetailInfo setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPublicBankName() {
        return publicBankName;
    }

    public RoleDetailInfo setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName;
        return this;
    }

    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }

    public RoleDetailInfo setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber;
        return this;
    }

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public RoleDetailInfo setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
        return this;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public RoleDetailInfo setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
        return this;
    }

    public String getLegalIdCardPositive() {
        return legalIdCardPositive;
    }

    public RoleDetailInfo setLegalIdCardPositive(String legalIdCardPositive) {
        this.legalIdCardPositive = legalIdCardPositive;
        return this;
    }

    public String getLegalIdCardOther() {
        return legalIdCardOther;
    }

    public RoleDetailInfo setLegalIdCardOther(String legalIdCardOther) {
        this.legalIdCardOther = legalIdCardOther;
        return this;
    }

    public String getCertificateOfAuthorization() {
        return certificateOfAuthorization;
    }

    public RoleDetailInfo setCertificateOfAuthorization(String certificateOfAuthorization) {
        this.certificateOfAuthorization = certificateOfAuthorization;
        return this;
    }

    public String getOperatorIdCardFront() {
        return operatorIdCardFront;
    }

    public RoleDetailInfo setOperatorIdCardFront(String operatorIdCardFront) {
        this.operatorIdCardFront = operatorIdCardFront;
        return this;
    }
}
