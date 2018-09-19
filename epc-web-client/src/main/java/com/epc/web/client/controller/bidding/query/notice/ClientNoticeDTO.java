package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "ClientNoticeDTO",description = "根据供应商ID查看公告列表")
public class ClientNoticeDTO implements Serializable {
    private static final long serialVersionUID = -4204083265444147940L;
    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;
    @ApiModelProperty(value = "公告标题")
    private String title;
    @ApiModelProperty(value = "招标公告开始时间")
    private Date biddingStart;
    @ApiModelProperty(value = "招标公告结束时间")
    private Date biddingEnd;
    @ApiModelProperty(value = "招标公告类型")
    private String biddingType;

}
