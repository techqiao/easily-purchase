package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-15 09:47
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "专家签到VO")
public class SignVO {
    @ApiModelProperty(value = "专家签到VO")
    private List<ExpertSignVO> signVOList;
    @ApiModelProperty(value = "标段ID")
    private Long bidId;
}
