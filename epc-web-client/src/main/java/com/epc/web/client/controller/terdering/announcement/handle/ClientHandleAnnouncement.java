package com.epc.web.client.controller.terdering.announcement.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:32
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleAnnouncement",description = "公告相关参数")
public class ClientHandleAnnouncement {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "审核人ID")
    private Long auditorId;
    @ApiModelProperty(value = "批复人ID")
    private Long repliesId;
    @ApiModelProperty(value = "招标公告附件url")
    private String biddingDocumentsUrl;
    @ApiModelProperty(value = "招标公告开始时间")
    private Date biddingStart;
    @ApiModelProperty(value = "招标公告结束时间")
    private Date biddingEnd;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "澄清开始时间")
    private Date defecationStart;
    @ApiModelProperty(value = "澄清结束时间")
    private Date defecationEnd;
    @ApiModelProperty(value = "是否删除 删除时传 0-存在,1-删除")
    private Integer isDeleted;
    @ApiModelProperty(value = "公告评语")
    private String announcementContent;
}
