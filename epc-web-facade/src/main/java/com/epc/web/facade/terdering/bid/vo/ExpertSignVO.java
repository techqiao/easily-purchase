package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 20:00
 * <p>@Author : wjq
 */
@ApiModel(value = "评标专家签到")
@Data
public class ExpertSignVO {
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "评标专家ID")
    private Long expertId;
    @ApiModelProperty(value = "评标专家姓名")
    private String expertName;
    @ApiModelProperty(value = "评标专家电话")
    private String expertPhone;
    @ApiModelProperty(value = "是否已签到 0 否 1 是")
    private Integer isSign;
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "是否为组长 0 否 1 是")
    private Integer isLeader;

}
