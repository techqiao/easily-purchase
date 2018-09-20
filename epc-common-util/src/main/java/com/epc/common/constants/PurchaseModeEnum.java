package com.epc.common.constants;

/**
 * <p>Description : 采购方式
 * <p>Date : 2018-09-18 19:14
 * <p>@Author : wjq
 */
public enum PurchaseModeEnum {
    //招标采购 询比采购 竞价采购 谈判采购 直接采购 框架协议采购
    SELECTIVE_TENDERING("selective_tendering","招标采购")
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
