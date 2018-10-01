package com.epc.web.facade.bidding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("文件基本信息")
public class FileListDTO implements Serializable {

    private static final long serialVersionUID = 5654812284762647152L;
    @ApiModelProperty("文件Id")
    private Long id;
    @ApiModelProperty("文件名")
    private String fileName;
    @ApiModelProperty("文件路径")
    private String filePath;
}
