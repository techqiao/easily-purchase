package com.epc.web.facade.agency.dto;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AgencySupplierDto implements Serializable {
    private static final long serialVersionUID = 631901486442300798L;
    /**
     * 代理机构id
     */
    private Long agencyId;
    /**
     * supplierId供货商id
     */
    private Long supplierId;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;

    /**
     * 法人姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
     private String area;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 统一的信用代码
     */
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBankCount;

    /**
     * 操作人id
     */
    private long OperatorId;
    /**
     * 操作人公司的id
     */
    private long companyId;
    /**
     * 营业执照
     */
    private String businessLicense;
    /**
     * 身份证政面
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
     * 附件list
     */
    private List<Attachement> atts;


}
