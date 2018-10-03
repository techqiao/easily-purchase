package com.epc.web.facade.terdering.pretrial.query;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:49
 * <p>@Author : wjq
 */
@Data
public class QueryMessageDTO extends PagerParam implements Serializable {
    /**
     * 公告ID
     */
    private Long releaseAnnouncementId;
    /**
     * 状态
     */
    private String status;
}
