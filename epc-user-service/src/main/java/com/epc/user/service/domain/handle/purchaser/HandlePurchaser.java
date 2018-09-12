package com.epc.user.service.domain.handle.purchaser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "HandlePurchaser", description = "新增采购人")

public class HandlePurchaser {
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "采购人名字")
    private String purchaserName;
    @ApiModelProperty(value = "密码")
    private String password;
    private List<Attachment> attachmentList;//附件

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
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
}
