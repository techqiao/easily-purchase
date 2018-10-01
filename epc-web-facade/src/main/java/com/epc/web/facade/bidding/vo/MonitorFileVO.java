package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "文件监控列表")
public class MonitorFileVO implements Serializable {
    private static final long serialVersionUID = -6728140862792760790L;
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("文件类型")
    private String fileType;
    @ApiModelProperty("文件id")
    private Long fileId;
    @ApiModelProperty("文件名")
    private String fileName;
    @ApiModelProperty("文件路径")
    private String filePath;
    @ApiModelProperty("操作人类型")
    private String operateType;
    @ApiModelProperty("操作人")
    private String operator;
    @ApiModelProperty("操作时间")
    private Date createAt;
}
