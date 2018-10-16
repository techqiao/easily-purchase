package com.epc.web.client.controller.bidding.query.evaluation;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-16 15:05
 * <p>@Author : wjq
 */
@ApiModel(value = "查询投标文件")
@Data
public class ClientQueryEvaluation extends PagerParam {
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
}
