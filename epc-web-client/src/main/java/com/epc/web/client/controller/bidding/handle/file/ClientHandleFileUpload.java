package com.epc.web.client.controller.bidding.handle.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 供应商上传文件
 * @author linzhixiang
 */

@ApiModel(value = "HandleFileUpload",description = "文件上传")

public class ClientHandleFileUpload {

    @ApiModelProperty(value = "供应商Id")
    private Long supplierId;
    @ApiModelProperty(value = "文件类型")
    private String certificateType;
    @ApiModelProperty(value = "文件路径集合")
    private List<BasePretriaFile> filePathList;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public List<BasePretriaFile> getFilePathList() {
        return filePathList;
    }

    public void setFilePathList(List<BasePretriaFile> filePathList) {
        this.filePathList = filePathList;
    }
}
