package com.epc.web.facade.terdering.pretrial.handle;

import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 11:07
 * <p>@Author : wjq
 */
@Data
public class HandlePretrialMessage {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 是否通过: review-审核中,noPass-未通过,pass-通过
     */
    private String status;
    /**
     * 公告ID
     */
    private Long releaseAnnouncementId;
    /**
     * 操作人ID
     */
    private Long operateId;
    /**
     * 操作人姓名
     */
    private String creator;
}
