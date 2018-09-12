package com.epc.user.service.domain.purchaser;

import java.io.Serializable;
import java.util.Date;

public class TPurchaserDetailInfo implements Serializable {

    private Long id;

    private Long purchaserId;

    private String companyName;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;

    private String qualificationCertificate;

    private String businessLicense;

    private String legalIdcardPositive;

    private String legalIdcardOther;

    private String certificateOfAuthorization;

    private String operatorIdCardFront;

    private String extendedField;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getUniformCreditCode() {
        return uniformCreditCode;
    }

    public void setUniformCreditCode(String uniformCreditCode) {
        this.uniformCreditCode = uniformCreditCode == null ? null : uniformCreditCode.trim();
    }

    public String getPublicBankName() {
        return publicBankName;
    }

    public void setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName == null ? null : publicBankName.trim();
    }

    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }


    public void setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber == null ? null : publicBanAccountNumber.trim();
    }

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public void setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate == null ? null : qualificationCertificate.trim();
    }


    public String getBusinessLicense() {
        return businessLicense;
    }


    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }


    public String getLegalIdcardPositive() {
        return legalIdcardPositive;
    }


    public void setLegalIdcardPositive(String legalIdcardPositive) {
        this.legalIdcardPositive = legalIdcardPositive == null ? null : legalIdcardPositive.trim();
    }


    public String getLegalIdcardOther() {
        return legalIdcardOther;
    }


    public void setLegalIdcardOther(String legalIdcardOther) {
        this.legalIdcardOther = legalIdcardOther == null ? null : legalIdcardOther.trim();
    }

    public String getCertificateOfAuthorization() {
        return certificateOfAuthorization;
    }


    public void setCertificateOfAuthorization(String certificateOfAuthorization) {
        this.certificateOfAuthorization = certificateOfAuthorization == null ? null : certificateOfAuthorization.trim();
    }

    public String getOperatorIdCardFront() {
        return operatorIdCardFront;
    }


    public void setOperatorIdCardFront(String operatorIdCardFront) {
        this.operatorIdCardFront = operatorIdCardFront == null ? null : operatorIdCardFront.trim();
    }


    public String getExtendedField() {
        return extendedField;
    }


    public void setExtendedField(String extendedField) {
        this.extendedField = extendedField == null ? null : extendedField.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }


    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }


    public Integer getIsDeleted() {
        return isDeleted;
    }


    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", companyName=").append(companyName);
        sb.append(", uniformCreditCode=").append(uniformCreditCode);
        sb.append(", publicBankName=").append(publicBankName);
        sb.append(", publicBanAccountNumber=").append(publicBanAccountNumber);
        sb.append(", qualificationCertificate=").append(qualificationCertificate);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", legalIdcardPositive=").append(legalIdcardPositive);
        sb.append(", legalIdcardOther=").append(legalIdcardOther);
        sb.append(", certificateOfAuthorization=").append(certificateOfAuthorization);
        sb.append(", operatorIdCardFront=").append(operatorIdCardFront);
        sb.append(", extendedField=").append(extendedField);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}