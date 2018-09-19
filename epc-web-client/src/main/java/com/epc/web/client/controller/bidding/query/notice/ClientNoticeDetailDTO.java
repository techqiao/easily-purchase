package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author linzhixiang
 */
@ApiModel(value = "QueryNoticeDetail",description = "根据Id查看公告详情")
public class ClientNoticeDetailDTO{

    @ApiModelProperty(value = "公告Id")
    private  Long noticeId;
    @ApiModelProperty(value = "供应商Id")
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
