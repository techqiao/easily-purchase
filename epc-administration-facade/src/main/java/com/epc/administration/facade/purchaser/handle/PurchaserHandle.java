package com.epc.administration.facade.purchaser.handle;

import com.epc.administration.facade.supplier.handle.AttachmentHandle;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 01
 */
@Data
public class PurchaserHandle implements Serializable {
    private static final long serialVersionUID = -3264881159199310971L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String cellPhone;

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
