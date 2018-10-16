package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-15 09:22
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "开标记录VO")
public class RecordVO {
    @ApiModelProperty(value = "开标记录")
    private List<OpeningRecordVO> openingRecordVOList;
    @ApiModelProperty(value = "标段ID")
    private Long bidId;
    @ApiModelProperty(value = "标段名称")
    private String bidName;
}
