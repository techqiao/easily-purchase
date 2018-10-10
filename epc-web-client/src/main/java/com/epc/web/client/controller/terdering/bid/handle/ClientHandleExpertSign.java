package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:43
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientHandleExpertSign",description = "评标专家签到参数")
@Data
public class ClientHandleExpertSign {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "评标专家ID")
    private Long expertId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "是否为组长")
    private Integer isLeader;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;

}
