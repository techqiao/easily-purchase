package com.epc.web.client.controller.terdering.announcement.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-30 15:16
 * <p>@Author : wjq
 */
@ApiModel(value = "项目经理监控")
@Data
public class ClientQueryAnnouncement extends PagerParam implements Serializable {
    private static final long serialVersionUID = 7773945870339866999L;
    @ApiModelProperty(value = "采购人ID")
    private Long purchaserId;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
}
