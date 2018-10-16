package com.epc.web.facade.terdering.purchase.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-12 19:14
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "采购项目流程")
public class FlowVO {
    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "当前步骤")
    private String step;

}
