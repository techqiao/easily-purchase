package com.epc.common.constants;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:54
 * <p>@Author : wjq
 */
public enum  AnnouncementProcessStatusEnum {

    AUDITING("auditing","审核"),
    REPLY("reply","批复"),
    AGENT("agent","经办"),
    RELEASED("released","已发布"),
    WAIT_RELEASE("wait_release","待发布"),
    NOT_SUBMIT("not_submit","未提交"),
    INVALID("invalid","失效"),
    ;
    private String code;
    private String desc;

    AnnouncementProcessStatusEnum(String code, String desc) {
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
