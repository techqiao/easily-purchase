package com.epc.web.facade.agency.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/9/18
 */
@Data
public class HandleAgency implements Serializable {

    private static final long serialVersionUID = -5650940360397347119L;
    /**
     * 代理机构id
     */
    private Long agencyId;

    /**
     * 员工名字
     */
    private String name;
    /**
     *登录密码
     */
    private String password;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 统一信用号
     */
    private String uniformCreditCode;
    /**
     * 对公银行名字
     */
        private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;
    /**
     * 附件信息
     */
    private List<Attachement> atts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

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

    public List<Attachement> getAtts() {
        return atts;
    }

    public void setAtts(List<Attachement> atts) {
        this.atts = atts;
    }
}
