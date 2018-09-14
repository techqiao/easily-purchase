package com.epc.administration.client.controller.biddingagency.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientRoleDetailInfo",description = "招标代理机构")
public class ClientRoleDetailInfo {

    @ApiModelProperty(value = "角色")
    @NotEmpty(message = "ClientRoleDetailInfo.systemRole.null")
    private String systemRole;
    @ApiModelProperty(value = "注册人Id")
    @NotEmpty(message = "ClientRoleDetailInfo.userId.null")
    private Long id;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientRoleDetailInfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientRoleDetailInfo.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientRoleDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;
    @ApiModelProperty(value = "招标(采购)代理机构 ID")
    @NotEmpty(message = "ClientRoleDetailInfo.agencyID.null")
    private String agencyID;
    @ApiModelProperty(value = "附件类型")
    @NotEmpty(message = "ClientRoleDetailInfo.certificateType.null")
    private String certificateType;
    @ApiModelProperty(value = "附件url")
    @NotEmpty(message = "ClientRoleDetailInfo.certificateFilePath.null")
    private String certificateFilePath;
    @ApiModelProperty(value = "附件号码")
    @NotEmpty(message = "ClientRoleDetailInfo.certificateNumber.null")
    private String certificateNumber;
    @ApiModelProperty(value = "附件对应证书名称")
    @NotEmpty(message = "ClientRoleDetailInfo.certificateName.null")
    private String certificateName;

    public String getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    public void setCertificateFilePath(String certificateFilePath) {
        this.certificateFilePath = certificateFilePath;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    @Override
    public String toString() {
        return "ClientRoleDetailInfo{" +
                "systemRole='" + systemRole + '\'' +
                ", id=" + id +
                ", companyName='" + companyName + '\'' +
                ", publicBankName='" + publicBankName + '\'' +
                ", publicBanAccountNumber='" + publicBanAccountNumber + '\'' +
                ", agencyID='" + agencyID + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateFilePath='" + certificateFilePath + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", certificateName='" + certificateName + '\'' +
                '}';
    }
}
