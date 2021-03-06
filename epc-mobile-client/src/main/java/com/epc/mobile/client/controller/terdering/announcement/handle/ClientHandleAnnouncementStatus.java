package com.epc.mobile.client.controller.terdering.announcement.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 19:49
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleAnnouncementStatus",description = "公告审批审核发布")
public class ClientHandleAnnouncementStatus {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "当前公告状态")
    private String processStatus;
    @ApiModelProperty(value = "是否通过 0不通过 1通过")
    private Integer isPass;

}
