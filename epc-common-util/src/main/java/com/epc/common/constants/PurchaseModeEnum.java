package com.epc.common.constants;

/**
 * <p>Description : 采购方式
 * <p>Date : 2018-09-18 19:14
 * <p>@Author : wjq
 */
public enum PurchaseModeEnum {

    //采购方式 :招标采购 询比采购 竞价采购 谈判采购 直接采购 框架协议采购
    SELECTIVE_TENDERING_INVITATION("selective_tendering_invitation","招标采购-邀请招标"),
    SELECTIVE_TENDERING_AFTER("selective_tendering_after","招标采购-资格后审"),
    SELECTIVE_TENDERING_RETRIAL("selective_tendering_retrial","招标采购-资格预审"),
    INQUIRIES_TENDERING("inquiries_tendering","询比采购"),
    BIDDING_TENDERING("bidding_tendering","竞价采购"),
    NEGOTIATION_TENDERING("negotiation_tendering","谈判采购"),
    DIRECT_TENDERING("direct_tendering","直接采购"),
    FRAMEWORK_TENDERING("framework_tendering","框架协议采购")
    ;
    private String code;
    private String desc;

    PurchaseModeEnum(String code, String desc) {
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
