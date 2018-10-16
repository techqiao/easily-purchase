package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-15 11:36
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "唱标VO")
public class LetterTenderSubVO {
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "详情VO")
    private List<LetterTenderVO> letterTenderVOList;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
}
