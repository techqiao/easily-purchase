package com.epc.administration.facade.operator.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class BaseDetailIfo {
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "RoleDetailIfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "RoleDetailIfo.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "RoleDetailIfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "RoleDetailIfo.qualificationCertificate.null")
    private String qualificationCertificate;
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "RoleDetailIfo.businessLicense.null")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "RoleDetailIfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "RoleDetailIfo.legalIdCardOther.null")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    @NotEmpty(message = "RoleDetailIfo.certificateOfAuthorization.null")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    @NotEmpty(message = "RoleDetailIfo.operatorIdCardFront.null")
    private String operatorIdCardFront;

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

    @Override
    public String toString() {
        return "BaseDetailIfo{" +
                "companyName='" + companyName + '\'' +
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
}
