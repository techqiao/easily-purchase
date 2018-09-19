package com.epc.web.client.controller.bidding.handle.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 上传文件附件信息
 * @author linzhixiang
 */
@ApiModel(value = "BasePretriaFile",description = "预审文件")
public class BasePretriaFile {
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    @ApiModelProperty(value = "文件名")
    private String fileName;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
