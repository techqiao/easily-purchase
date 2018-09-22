package com.epc.web.facade.terdering.announcement.handle;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:32
 * <p>@Author : wjq
 */
@Data
public class HandleAnnouncement {
    /**
     * 主键ID
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
     * 招标公告附件url
     */
    private String biddingDocumentsUrl;
    /**
     * 招标公告开始时间
     */
    private Date biddingStart;
    /**
     * 招标公告结束时间
     */
    private Date biddingEnd;
    /**
     * 公告评语
     */
    private String announcementContent;
    /**
     * 操作人ID
     */
    private Long operateId;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 是否删除
     */
    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Long getRepliesId() {
        return repliesId;
    }

    public void setRepliesId(Long repliesId) {
        this.repliesId = repliesId;
    }

    public String getBiddingDocumentsUrl() {
        return biddingDocumentsUrl;
    }

    public void setBiddingDocumentsUrl(String biddingDocumentsUrl) {
        this.biddingDocumentsUrl = biddingDocumentsUrl;
    }

    public Date getBiddingStart() {
        return biddingStart;
    }

    public void setBiddingStart(Date biddingStart) {
        this.biddingStart = biddingStart;
    }

    public Date getBiddingEnd() {
        return biddingEnd;
    }

    public void setBiddingEnd(Date biddingEnd) {
        this.biddingEnd = biddingEnd;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
