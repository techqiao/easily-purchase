package com.epc.mobile.client.controller.terdering.pretrial.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Description : 供应商资格审查
 * <p>Date : 2018-09-25 10:27
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientHandleMessage",description = "供应商资格审查")
@Data
public class ClientHandleMessage {
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientHandleMessage.id.null")
    private Long id;
    @ApiModelProperty(value = "是否通过: review-审核中,noPass-未通过,pass-通过")
    @NotEmpty(message = "ClientHandleMessage.status.null")
    private String status;
    @ApiModelProperty(value = "公告ID")
    @NotEmpty(message = "ClientHandleMessage.releaseAnnouncementId.null")
    private Long releaseAnnouncementId;
}
