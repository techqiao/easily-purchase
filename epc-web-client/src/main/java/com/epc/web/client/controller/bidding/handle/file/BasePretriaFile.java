package com.epc.web.client.controller.bidding.handle.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 上传文件附件信息
 * @author linzhixiang
 */
@Data
@ApiModel(value = "BasePretriaFile",description = "预审文件")
public class BasePretriaFile {
    @ApiModelProperty(value = "文件ID")
    private String id;
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    @ApiModelProperty(value = "文件名")
    private String fileName;
}
