package com.epc.common.constants;

public enum ProcessStatusEnum {
    AUDITING("auditing","审核"),
    REPLY("reply","批复"),
    WAIT_RELEASE("wait_release","待发布"),
    RELEASED("released","已发布"),
    NOT_SUBMIT("not_submit","未提交"),
    INVALID("invalid","失效");

    private String code;
    private String desc;

    ProcessStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
