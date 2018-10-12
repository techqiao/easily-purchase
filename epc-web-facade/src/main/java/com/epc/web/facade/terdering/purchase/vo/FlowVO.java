package com.epc.web.facade.terdering.purchase.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-12 19:14
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "采购项目流程")
public class FlowVO {
    @ApiModelProperty(value = "公告")
    private Long announcementId;
    @ApiModelProperty(value = "发售招标文件")
    private Long saleDocumentsId;
    @ApiModelProperty(value = "评标标准设定")
    private Long evaluationId;
    @ApiModelProperty(value = "组建评委会")
    private Long assessmentCommitteeId;
    @ApiModelProperty(value = "开标")
    private Long openingRecordId;
    @ApiModelProperty(value = "唱标")
    private Boolean bidAnnouncement;
    @ApiModelProperty(value = "公示开标记录")
    private Long recordPublicityId;
    @ApiModelProperty(value = "评标 专家签到 ")
    private Boolean expertSign;
    @ApiModelProperty(value = "专家评审 专家签到 是否有组长")
    private Boolean expertSignLeader;
    @ApiModelProperty(value = "评审报告")
    private Boolean report;
    @ApiModelProperty(value = "中标公示")
    private Long nominateId;
    @ApiModelProperty(value = "中标通知书")
    private Boolean winBid;
    @ApiModelProperty(value = "退还保证金")
    private Boolean openingPay;

}
