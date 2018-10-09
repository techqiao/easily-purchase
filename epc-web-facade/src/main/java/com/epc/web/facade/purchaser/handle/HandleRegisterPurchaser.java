package com.epc.web.facade.purchaser.handle;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HandleRegisterPurchaser implements Serializable{
    private static final long serialVersionUID = 1878870949796620070L;
    /**
     * 用于接受数据库生成的的id
     */
    private Long purchaseId;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;

    /**
     * 采购人法人姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
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
     * 附件list
     */
    protected List<Attachement> atts;
}
