package com.epc.web.facade.supplier.handle;

import java.util.Arrays;


public class HandlerRegisterSupplier {
    /**
     * 供应商注册时传过来的数据
     */

    private String companyName; //公司名称
    private String uniformCreditCode;   //统一信用代码
    private String businessLicenseUrl;  //营业执照照片
    private String legalCardFrontUrl;   //法人身份证正面
    private String getLegalCardBackUrl; //法人身份证反面
    private String authorizationUrl;    //带公章的授权书照片
    private String agentCardFrontUrl;   //经办人手持身份证正面照片
    private String qualificationCardName; //资质证书名称
    private String qualificationCardUrl;    //资质证书
    private String[] region;    //所在地区(可填写多个)
    private String publicBankName;  //对公银行
    private String publicBankAccountNumber;  //对公银行帐号
    private String cellPhone;   //手机号
    private String password;    //密码
    private String confirmPassword; //确认密码
    private String sms;    //短信验证码

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUniformCreditCode() {
        return uniformCreditCode;
    }

    public void setUniformCreditCode(String uniformCreditCode) {
        this.uniformCreditCode = uniformCreditCode;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getLegalCardFrontUrl() {
        return legalCardFrontUrl;
    }

    public void setLegalCardFrontUrl(String legalCardFrontUrl) {
        this.legalCardFrontUrl = legalCardFrontUrl;
    }

    public String getGetLegalCardBackUrl() {
        return getLegalCardBackUrl;
    }

    public void setGetLegalCardBackUrl(String getLegalCardBackUrl) {
        this.getLegalCardBackUrl = getLegalCardBackUrl;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    public String getAgentCardFrontUrl() {
        return agentCardFrontUrl;
    }

    public void setAgentCardFrontUrl(String agentCardFrontUrl) {
        this.agentCardFrontUrl = agentCardFrontUrl;
    }

    public String getQualificationCardName() {
        return qualificationCardName;
    }

    public void setQualificationCardName(String qualificationCardName) {
        this.qualificationCardName = qualificationCardName;
    }

    public String getQualificationCardUrl() {
        return qualificationCardUrl;
    }

    public void setQualificationCardUrl(String qualificationCardUrl) {
        this.qualificationCardUrl = qualificationCardUrl;
    }

    public String[] getRegion() {
        return region;
    }

    public void setRegion(String[] region) {
        this.region = region;
    }

    public String getPublicBankName() {
        return publicBankName;
    }

    public void setPublicBankName(String publicBankName) {
        this.publicBankName = publicBankName;
    }

    public String getPublicBankAccountNumber() {
        return publicBankAccountNumber;
    }

    public void setPublicBankAccountNumber(String publicBankAccountNumber) {
        this.publicBankAccountNumber = publicBankAccountNumber;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return "HandlerRegisterSupplier{" +
                "companyName='" + companyName + '\'' +
                ", uniformCreditCode='" + uniformCreditCode + '\'' +
                ", businessLicenseUrl='" + businessLicenseUrl + '\'' +
                ", legalCardFrontUrl='" + legalCardFrontUrl + '\'' +
                ", getLegalCardBackUrl='" + getLegalCardBackUrl + '\'' +
                ", authorizationUrl='" + authorizationUrl + '\'' +
                ", agentCardFrontUrl='" + agentCardFrontUrl + '\'' +
                ", qualificationCardName='" + qualificationCardName + '\'' +
                ", qualificationCardUrl='" + qualificationCardUrl + '\'' +
                ", region=" + Arrays.toString(region) +
                ", publicBankName='" + publicBankName + '\'' +
                ", publicBankAccountNumber='" + publicBankAccountNumber + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", sms='" + sms + '\'' +
                '}';
    }
}
