package com.epc.administration.facade.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@ApiModel(value = "RoleDetailIfo", description = "运营商完善信息")
public class RoleDetailIfo {

    @ApiModelProperty(value = "角色")
    @NotEmpty(message = "RoleDetailIfo.systemRole.null")
    private String systemRole;
    @ApiModelProperty(value = "注册人Id")
    @NotEmpty(message = "RoleDetailIfo.userId.null")
    private Long userId;
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

    public String getSystemRole() {
        return systemRole;
    }

    public RoleDetailIfo setSystemRole(String systemRole) {
        this.systemRole = systemRole;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public RoleDetailIfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RoleDetailIfo setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPublicBankName() {
        return publicBankName;
    }

    public RoleDetailIfo setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName;
        return this;
    }

    public String getPublicBanAccountNumber() {
        return publicBanAccountNumber;
    }

    public RoleDetailIfo setPublicBanAccountNumber(String publicBanAccountNumber) {
        this.publicBanAccountNumber = publicBanAccountNumber;
        return this;
    }

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public RoleDetailIfo setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
        return this;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public RoleDetailIfo setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
        return this;
    }

    public String getLegalIdCardPositive() {
        return legalIdCardPositive;
    }

    public RoleDetailIfo setLegalIdCardPositive(String legalIdCardPositive) {
        this.legalIdCardPositive = legalIdCardPositive;
        return this;
    }

    public String getLegalIdCardOther() {
        return legalIdCardOther;
    }

    public RoleDetailIfo setLegalIdCardOther(String legalIdCardOther) {
        this.legalIdCardOther = legalIdCardOther;
        return this;
    }

    public String getCertificateOfAuthorization() {
        return certificateOfAuthorization;
    }

    public RoleDetailIfo setCertificateOfAuthorization(String certificateOfAuthorization) {
        this.certificateOfAuthorization = certificateOfAuthorization;
        return this;
    }

    public String getOperatorIdCardFront() {
        return operatorIdCardFront;
    }

    public RoleDetailIfo setOperatorIdCardFront(String operatorIdCardFront) {
        this.operatorIdCardFront = operatorIdCardFront;
        return this;
    }
}