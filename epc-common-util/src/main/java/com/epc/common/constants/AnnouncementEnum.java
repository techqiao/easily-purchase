package com.epc.common.constants;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-30 15:42
 * <p>@Author : wjq
 */
public enum AnnouncementEnum {
    //资格预审公告
    RELEASE("release","招标公告"),
    BID_CANDIDATE_PUBLICITY("bid_candidate_publicity","中标候选人公示"),
    BID_RESULT_PUBLICITY("bid_result_publicity","中标结果公示")
    ;
    private String code;
    private String desc;

    AnnouncementEnum(String code, String desc) {
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
