package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : 招标文件
 * <p>Date : 2018-09-25 13:19
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleUnderLine",description = "招标文件")
public class ClientHandleSaleDocuments {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "招标文件附件上传url")
    private String biddingDocumentsUpUrl;
    @ApiModelProperty(value = "招标文件附件下载url")
    private String biddingDocumentsDownloadUrl;
    @ApiModelProperty(value = "发售方式: 0-线下,1-线上,3-线上线下")
    private Integer isUnderLine;
    @ApiModelProperty(value = "投标文件递交截止时间")
    private Date biddingEndTime;
    @ApiModelProperty(value = "投标保证金截止时间")
    private Date biddingBondEndTime;
    @ApiModelProperty(value = "开标时间")
    private Date bidOpeningTime;
    @ApiModelProperty(value = "开标地点")
    private String bidOpeningPlace;
    @ApiModelProperty(value = "澄清问题时间")
    private Date clarificationProblemEndTime;
    @ApiModelProperty(value = "解密方式 0 CA锁")
    private Integer decryptionMethod;
    @ApiModelProperty(value = "状态 已发布 released, 未提交not_submit, 失效invalid")
    private String processStatus;
    @ApiModelProperty(value = "是否删除 0存在 1删除")
    private Integer isDeleted;
    @ApiModelProperty(value = "招标公告url")
    private String announcementUrl;
    @ApiModelProperty(value = "投标人须知url")
    private String noticeBidderUrl;
    @ApiModelProperty(value = "技术要求url")
    private String technicalRequirementUrl;
    @ApiModelProperty(value = "合同主要条款url")
    private String termsContractUrl;
    @ApiModelProperty(value = "评标标准url")
    private String evaluationUrl;
}
