package com.epc.mobile.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:41
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandOpeningRecordPublicity",description = "处理公示开标记录")
public class ClientHandOpeningRecordPublicity {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "公示开始时间")
    private Date startTime;
    @ApiModelProperty(value = "公示结束时间")
    private Date endTime;
    @ApiModelProperty(value = "唱标ID")
    private Long bidAnnouncementId;
    @ApiModelProperty(value = "状态  已发布 released, 未提交not_submit")
    private String processStatus;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;
    @ApiModelProperty(value = "经办人ID")
    private Long agentId;
    @ApiModelProperty(value = "审核人ID")
    private Long auditorId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "是否删除 0-存在,1-删除")
    private Integer isDeleted;

}
