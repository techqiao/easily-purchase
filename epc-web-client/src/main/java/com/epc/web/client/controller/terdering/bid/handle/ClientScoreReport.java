package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "撰写评审报告")
@Data
public class ClientScoreReport implements Serializable {
    private static final long serialVersionUID = 745331002085740264L;
    @ApiModelProperty(value = "报告记录路径")
    private String filePath;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;
    @ApiModelProperty(value = "报告详情")
    private String memo;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
}
