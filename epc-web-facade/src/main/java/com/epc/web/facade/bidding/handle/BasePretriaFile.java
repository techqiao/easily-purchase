package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/** 
* @Description: 上传文件
* @Author: linzhixiang
* @Date: 2018/9/19 
*/ 
public class BasePretriaFile implements Serializable {
    private static final long serialVersionUID = -2062443423483279136L;
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
