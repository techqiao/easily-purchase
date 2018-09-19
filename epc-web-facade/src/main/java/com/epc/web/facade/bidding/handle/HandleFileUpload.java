package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 供应商上传文件
 */

public class HandleFileUpload implements Serializable {

    private static final long serialVersionUID = 7632117491204100213L;
    private Long supplierId;
    private String certificateType;
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
