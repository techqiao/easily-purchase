package com.epc.web.facade.bidding.query.notice;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告列表查询，模糊查询
 * @author linzhixiang
 */
@Data
public class QueryNoticeDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = 4243161078452593344L;
    private Long supplierId;
    private String title;
    private Date biddingStart;
    private Date biddingEnd;
    private String biddingType;
}
