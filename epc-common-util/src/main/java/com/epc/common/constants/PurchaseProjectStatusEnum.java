package com.epc.common.constants;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 10:23
 * <p>@Author : wjq
 */
public enum PurchaseProjectStatusEnum {
    CREATED("created","已创建"),
    UNDERWAY("underway","正在进行中"),
    END("end","结束"),
    AGAIN_BIDDING("again_bidding","流标")
    ;
    private String code;
    private String desc;

    PurchaseProjectStatusEnum(String code, String desc) {
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
