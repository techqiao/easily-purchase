package com.epc.common.constants;

public enum MonitoringFileEnum {

    PRETRIAL_FILE("pretrialFile","资格预审文件"),
    BIDDING_DOCUMENTS("biddingDocuments","招标文件"),
    INVITATION("invitation","投标邀请书"),
    TENDER_DOCUMENTS("tenderDocuments投标文件","投标文件"),
    EVALUATION_REPORT("evaluationReport","评标报告"),
    WIN_BID("winBid","中标通知书"),
    CONTRACT("contract","合同");


    private String code;
    private String desc;

    MonitoringFileEnum(String code, String desc) {
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
