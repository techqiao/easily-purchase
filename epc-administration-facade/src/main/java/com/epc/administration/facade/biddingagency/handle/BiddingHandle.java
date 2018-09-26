package com.epc.administration.facade.biddingagency.handle;

import java.io.Serializable;

/**
 * @author luozhixin
 */
public class BiddingHandle implements Serializable {
    private static final long serialVersionUID = 2295340220100317777L;
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

    @Override
    public String toString() {
        return "BiddingHandle{" +
                "systemRole='" + systemRole + '\'' +
                ", userId=" + userId +
                ", companyName='" + companyName + '\'' +
                ", publicBankName='" + publicBankName + '\'' +
                ", publicBanAccountNumber='" + publicBanAccountNumber + '\'' +
                ", qualificationCertificate='" + qualificationCertificate + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", legalIdCardPositive='" + legalIdCardPositive + '\'' +
                ", legalIdCardOther='" + legalIdCardOther + '\'' +
                ", certificateOfAuthorization='" + certificateOfAuthorization + '\'' +
                ", operatorIdCardFront='" + operatorIdCardFront + '\'' +
                '}';
    }

    public String getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPublicBankName() {
        return publicBankName;
    }

    public void setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName;
    }

    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }

    public void setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber;
    }

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public void setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLegalIdCardPositive() {
        return legalIdCardPositive;
    }

    public void setLegalIdCardPositive(String legalIdCardPositive) {
        this.legalIdCardPositive = legalIdCardPositive;
    }

    public String getLegalIdCardOther() {
        return legalIdCardOther;
    }

    public void setLegalIdCardOther(String legalIdCardOther) {
        this.legalIdCardOther = legalIdCardOther;
    }

    public String getCertificateOfAuthorization() {
        return certificateOfAuthorization;
    }

    public void setCertificateOfAuthorization(String certificateOfAuthorization) {
        this.certificateOfAuthorization = certificateOfAuthorization;
    }

    public String getOperatorIdCardFront() {
        return operatorIdCardFront;
    }

    public void setOperatorIdCardFront(String operatorIdCardFront) {
        this.operatorIdCardFront = operatorIdCardFront;
    }
}
