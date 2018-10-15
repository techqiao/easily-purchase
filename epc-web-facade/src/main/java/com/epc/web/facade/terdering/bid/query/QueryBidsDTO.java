package com.epc.web.facade.terdering.bid.query;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 19:06
 * <p>@Author : wjq
 */
@ApiModel(value = "查询类")
@Data
public class QueryBidsDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = -8086278045980297780L;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;

}
