package com.epc.common.constants;

public enum QuestionTypeEnum {
    ANNOUNCEMENT("announcement","公告"),
    BID_FILE("bidFile","招标文件"),
    BID_EVALUATION("bidEvaluation","评标");

    private String code;
    private String desc;

    QuestionTypeEnum(String code, String desc) {
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
