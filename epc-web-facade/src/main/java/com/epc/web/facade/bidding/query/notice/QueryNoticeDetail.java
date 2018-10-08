package com.epc.web.facade.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 公告详情
 * @author linzhixiang
 */
@Data
public class QueryNoticeDetail implements Serializable {

    private static final long serialVersionUID = -1840388516961313935L;
    private  Long noticeId;

    private  Long supplierId;

    private Boolean isPay;
}
