package com.epc.common.constants;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-16 11:28
 * <p>@Author : luozhixin
 */
public enum  ProcessTheEnum {
    RELEASE_PURCHASING_INFORMATION("release_purchasing_information","发布采购信息"),
    SUPPLIER_REGISTRATION("supplier_registration","供应商报名"),
    ISSUE_PROCUREMENT_REQUIREMENTS("issue_procurement_requirements","发布采购要求"),
    SUPPLIER_TENDER("supplier_tender","供应商投标"),
    SET_UP_A_JUDGING_COMMITTEE("set_up_a_judging_committee","组建评委会"),
    EVALUATION_OF_BID("evaluation_of_bid","正在评标"),
    THE_EVALUATION_RESULTS("the_evaluation_results","已出评标结果"),
    SET_UP_WINNING_BIDDER("set_up_winning_bidder","设置中标人"),
    SEND_THE_BID_ACCEPTANCE_NOTIFICATION("send_the_bid_acceptance_notification","发送中标通知书"),
    SUPPLIER_PAY_PLATFORM_SERVICE_FEE("SUPPLIER_PAY_PLATFORM_SERVICE_FEE","供应商正在缴纳平台服务费"),
    UPLOAD_THE_CONTRACT("upload_the_contract","合同上传");



    private String code;
    private String desc;

    ProcessTheEnum(String code, String desc) {
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
