package com.epc.mobile.client.controller.terdering.bid.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-13 10:14
 * <p>@Author : wjq
 */
@ApiModel(value = "QueryExpertDTO",description = "获取开始评标前置条件")
@Data
public class ClientQueryExpertDTO extends PagerParam {
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
}
