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
     * 营业执照
     */
    private String businessLicense;
    /**
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;
    /**
     * 授权书
     */
    private String certificateOfAuthorization;
    /**
     * 附件信息
     */
    private List<Attachement> atts;


}
