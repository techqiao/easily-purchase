package com.epc.web.client.controller.terdering.pretrial.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:49
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientQueryMessageDTO",description = "资格审查查询")
public class ClientQueryMessageDTO extends PagerParam implements Serializable {
    @ApiModelProperty(value = "公告id")
    private Long releaseAnnouncementId;
    @ApiModelProperty(value = "状态 review-审核中,noPass-未通过,pass-通过")
    private String status;
}
