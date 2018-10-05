package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/** 
* @Description: 上传文件
* @Author: linzhixiang
* @Date: 2018/9/19 
*/
@Data
public class BasePretriaFile implements Serializable {
    private static final long serialVersionUID = -2062443423483279136L;
    @ApiModelProperty("文件Id")
    private Long id;
    @ApiModelProperty("文件路径")
    private String filePath;
    @ApiModelProperty("文件名称")
    private String fileName;
    @ApiModelProperty("是否删除（0-否，1-是）")
    private int isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
