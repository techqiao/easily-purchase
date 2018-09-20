package com.epc.web.facade.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 公告详情
 * @author linzhixiang
 */
public class QueryNoticeDetail implements Serializable {

    private static final long serialVersionUID = -1840388516961313935L;
    private  Long noticeId;

    private  Long supplierId;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
