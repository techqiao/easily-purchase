package com.epc.web.facade.purchaser.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
* @Description:    运营商录入采购人
* @Author:          linzhixiang
* @CreateDate:     2018/9/13 10:00
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 10:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@ApiModel(value = "HandlePurchaser", description = "采购人员信息")
public class HandlePurchaser {
    @ApiModelProperty(value = "采购人Id")
    private long userId;
    @ApiModelProperty(value = "采购人姓名")
    @NotEmpty(message = "HandlePurchaser.name.null")
    private String name;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;
    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    private String operatorIdCardFront;
    @ApiModelProperty(value = "资质证书url")
    private String qualificationCertificate;
    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "操作人Id")
    private long OperatorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOperatorId() {
        return OperatorId;
    }

    public void setOperatorId(long operatorId) {
        OperatorId = operatorId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUniformCreditCode() {
        return uniformCreditCode;
    }

    public void setUniformCreditCode(String uniformCreditCode) {
        this.uniformCreditCode = uniformCreditCode;
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

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public void setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
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

    public String getPublicBankCount() {
        return publicBankCount;
    }

    public void setPublicBankCount(String publicBankCount) {
        this.publicBankCount = publicBankCount;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
