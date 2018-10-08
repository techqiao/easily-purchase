package com.epc.common.constants;

public enum PretrialMessageEnum {
    REVIEW("review","审核中"),
    NO_PASS("noPass","未通过"),
    PASS("pass","通过");
    private String code;
    private String desc;
    PretrialMessageEnum(String code, String desc) {
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
