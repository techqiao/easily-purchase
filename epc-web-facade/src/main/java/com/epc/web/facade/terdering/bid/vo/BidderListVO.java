package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 09:59
 * <p>@Author : wjq
 */
@ApiModel(value = "标段人列表")
@Data
public class BidderListVO {
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
    @ApiModelProperty(value = "投标人列表")
    private List<BidderVO> bidderVOList;
}
