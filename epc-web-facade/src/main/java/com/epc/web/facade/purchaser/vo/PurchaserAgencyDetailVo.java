package com.epc.web.facade.purchaser.vo;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PurchaserAgencyDetailVo implements Serializable{
    private static final long serialVersionUID = 1510127562692601158L;

    /**
     * 代理机构的id
     */
    private Long agencyId;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 法人姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
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
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;
    /**
     * 营业执照
     */
    private String businessLicense;


    /**
     * 附件list
     */
    protected List<Attachement> atts;

    private String companyAddress;
    private String province;
    private String city;
    private String area;
}
