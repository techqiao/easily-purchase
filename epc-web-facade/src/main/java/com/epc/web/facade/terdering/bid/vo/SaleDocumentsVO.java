package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description : 招标文件
 * <p>Date : 2018-09-25 13:19
 * <p>@Author : wjq
 */
@Data
public class SaleDocumentsVO {
    /**
     * id
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 审核人ID
     */
    private Long auditorId;
    /**
     * 批复人ID
     */
    private Long repliesId;
    /**
     * 招标文件附件上传url
     */
    private String biddingDocumentsUpUrl;
    /**
     * 招标文件附件下载url
     */
    private String biddingDocumentsDownloadUrl;
    /**
     * 发售方式: 0-线下,1-线上,3-线上线下
     */
    private Integer isUnderLine;
    /**
     * 投标文件递交截止时间
     */
    private Date biddingEndTime;
    /**
     * 投标保证金截止时间
     */
    private Date biddingBondEndTime;
    /**
     * 开标时间
     */
    private Date bidOpeningTime;
    /**
     * 开标地点
     */
    private String bidOpeningPlace;
    /**
     * 澄清问题时间
     */
    private Date clarificationProblemEndTime;
    /**
     * 解密方式 0 CA锁
     */
    private Integer decryptionMethod;
    /**
     * 状态 审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     */
    private String processStatus;
    /**
     * 操作人ID
     */
    private Long operateId;

}
