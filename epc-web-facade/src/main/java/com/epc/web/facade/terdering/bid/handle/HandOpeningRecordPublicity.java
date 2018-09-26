package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:41
 * <p>@Author : wjq
 */
@Data
public class HandOpeningRecordPublicity {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 公示开始时间
     */
    private Date startTime;

    /**
     * 公示结束时间
     */
    private Date endTime;

    /**
     * 唱标ID
     */
    private Long bidAnnouncementId;

    /**
     * 状态  审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     */
    private String processStatus;

    /**
     * 操作人ID
     */
    private Long operateId;

    /**
     * 经办人ID
     */
    private Long agentId;
    /**
     * 审核人ID
     */
    private Long auditorId;
    /**
     * 标段ID
     */
    private Long bidsId;

}
