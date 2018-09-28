package com.epc.administration.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 01
 */
@Data
public class SupplierHandle implements Serializable {
    private static final long serialVersionUID = 1528368763872630879L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     *统一信用代码
     */
    private String uniformCreditCode;

    /**
     *对公银行名称
     */
    private String publicBankName;

    /**
     *对公银行账号
     */
    private String publicBanAccountNumber;

    /**
     * 营业执照照片url
     */
    private String businessLicense;
    /**
     * 法人身份证正面照片url
     */
    private String legalIdCardPositive;
    /**
     * 法人身份证反面照片url
     */
    private String legalIdCardOther;

    /**
     * 附件集合
     */
    private List<AttachmentHandle> attachmentHandleList;


}
