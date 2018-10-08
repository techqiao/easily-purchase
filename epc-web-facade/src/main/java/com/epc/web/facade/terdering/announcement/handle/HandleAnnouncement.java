package com.epc.web.facade.terdering.announcement.handle;

import io.swagger.annotations.ApiModelProperty;
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
     * 澄清开始时间
     */
    private Date defecationStart;
    /**
     * 澄清结束时间
     */
    private Date defecationEnd;
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


}
