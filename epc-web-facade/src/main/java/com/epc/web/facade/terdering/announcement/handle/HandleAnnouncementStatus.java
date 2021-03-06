package com.epc.web.facade.terdering.announcement.handle;

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
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 是否全权委托代理机构
     */
    private Integer isOtherAgency;
    /**
     * 是否通过 0不通过 1通过
     */
    private Integer isPass;



}
