package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告详情
 * @author linzhixiang
 */
public class NoticeDetailVO implements Serializable {

    private static final long serialVersionUID = -8445436128833921499L;
    private Long id;
    private Date biddingStart;
    private Date biddingEnd;
    private String procurementProjectName;
    private String biddingType;
    private String title;
    private String announcementContent;
    private String biddingDocumentsUrl;

    public String getBiddingDocumentsUrl() {
        return biddingDocumentsUrl;
    }

    public void setBiddingDocumentsUrl(String biddingDocumentsUrl) {
        this.biddingDocumentsUrl = biddingDocumentsUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getProcurementProjectName() {
        return procurementProjectName;
    }

    public void setProcurementProjectName(String procurementProjectName) {
        this.procurementProjectName = procurementProjectName;
    }

    public String getBiddingType() {
        return biddingType;
    }

    public void setBiddingType(String biddingType) {
        this.biddingType = biddingType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }
}
