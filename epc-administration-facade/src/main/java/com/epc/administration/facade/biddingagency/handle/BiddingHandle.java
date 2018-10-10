package com.epc.administration.facade.biddingagency.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author luozhixin
 */
@Data
public class BiddingHandle implements Serializable {
    private static final long serialVersionUID = 2295340220100317777L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 省份
     */
    private String province;
    /**
     * 市区
     */
    private String city;
    /**
     * 区域
     */
    private String area;
    /**
     *统一信用代码
     */
    private String uniformCreditCode;
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
     *对公银行名称
     */
    private String publicBankName;

    /**
     *对公银行账号
     */
    private String publicBanAccountNumber;

    /**
     * 附件集合
     */
    private List<AttachmentHandle> clientAttachmentHandles;


}
