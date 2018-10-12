package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-12 10:45
 * <p>@Author : wjq
 */
@ApiModel(value = "标准设定")
@Data
public class EvaluationVO {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    @ApiModelProperty(value = "评标方法类型 商务评标 技术评标")
    private String standardType;
    @ApiModelProperty(value = "方法总分数")
    private Integer typeScore;
    @ApiModelProperty(value = "评标方法描述")
    private String memo;
}
