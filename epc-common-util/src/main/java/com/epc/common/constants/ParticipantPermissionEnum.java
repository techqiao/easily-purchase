package com.epc.common.constants;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 21:26
 * <p>@Author : wjq
 */
public enum ParticipantPermissionEnum {
    REPLY("reply","批复"),
    AGENT("agent","经办"),
    AUDITOR("auditor","审核"),
    PERSON_LIABLE("person_liable","负责人")
    ;
    private String code;
    private String desc;

    ParticipantPermissionEnum(String code, String desc) {
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
