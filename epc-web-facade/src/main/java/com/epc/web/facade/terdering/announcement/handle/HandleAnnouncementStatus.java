package com.epc.web.facade.terdering.announcement.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : 公告审批审核发布
 * <p>Date : 2018-09-20 19:49
 * <p>@Author : wjq
 */
@Data
public class HandleAnnouncementStatus implements Serializable {

    private static final long serialVersionUID = 6509628077636547448L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 公告状态
     */
    private String processStatus;
    /**
     * 审核人ID
     */
    private Long auditorId;
    /**
     * 批复人ID
     */
    private Long repliesId;
    /**
     * 操作人ID
     */
    private Long operateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
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

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }
}
