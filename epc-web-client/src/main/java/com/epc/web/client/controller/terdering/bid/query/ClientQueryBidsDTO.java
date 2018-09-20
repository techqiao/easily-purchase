package com.epc.web.client.controller.terdering.bid.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 19:06
 * <p>@Author : wjq
 */
@ApiModel(value = "ClientQueryProjectInfoDTO",description = "查询标段")
@Data
public class ClientQueryBidsDTO extends PagerParam {
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;

}
