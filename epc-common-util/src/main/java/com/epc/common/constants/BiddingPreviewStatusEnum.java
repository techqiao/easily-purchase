package com.epc.common.constants;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 17:13
 * <p>@Author : luozhixin
 * <p>BiddingPreviewStatusEnum
 */
public enum BiddingPreviewStatusEnum {
    CREATED("created","已创建"),
    RELEASE("release","发布"),
    INVALID("invalid","失效")
            ;
    private String code;
    private String desc;

    BiddingPreviewStatusEnum(String code, String desc) {
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
