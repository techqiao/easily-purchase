package com.epc.mobile.client.controller.terdering.project.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 15:58
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientQueryProjectInfoDTO",description = "查询项目")
@Data
public class ClientQueryProjectInfoDTO extends PagerParam {
    @ApiModelProperty(value = "采购人ID")
    private Long purchaserId;
    @ApiModelProperty(value = "项目编号")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
}
