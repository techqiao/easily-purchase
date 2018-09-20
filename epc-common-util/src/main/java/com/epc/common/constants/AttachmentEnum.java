package com.epc.common.constants;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-12 11:48
 * <p>@Author : wjq
 * <P>Email : wujiangqiao@difengshanguo.com
 */
public enum AttachmentEnum {
    QUALIFICATION_CERTIFICATE("qualification_certificate","资质证书url"),
    BUSINESS_LICENSE("business_license","营业执照照片url"),
    LEGAL_ID_CARD_POSITIVE("legal_id_card_positive", "法人身份证正面照片url"),
    LEGAL_ID_CARD_OTHER("legal_id_card_other","法人身份证反面照片url"),
    CERTIFICATE_OF_AUTHORIZATION("certificate_of_authorization","带公章的授权书照片url"),
    OPERATOR_ID_CARD_FRONT("operator_id_card_front","经办人(运营商员工)手持身份证正面照片url"),
    PRETRIAL_FILE("pretrial_file","预审文件"),
    BIDDING_FILE("bidding_file","投标文件");
    private String code;
    private String desc;


    AttachmentEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
