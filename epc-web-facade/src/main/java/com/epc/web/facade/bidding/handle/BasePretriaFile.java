package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class BasePretriaFile {
    private String filePath;
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
