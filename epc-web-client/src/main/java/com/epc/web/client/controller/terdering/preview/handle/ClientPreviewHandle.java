package com.epc.web.client.controller.terdering.preview.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:07
 * <p>@Author : luozhixin
 * <p>
 */
public class ClientPreviewHandle  implements Serializable {
    private static final long serialVersionUID = -8995905669161336733L;

    @ApiModelProperty("项目编号")
    @NotEmpty(message = "ClientPreviewHandle.projectCode.null")
    private String projectCode;
    @ApiModelProperty("项目名称")
    @NotEmpty(message = "ClientPreviewHandle.projectName.null")
    private String projectName;
    @ApiModelProperty("项目ID")
    @NotEmpty(message = "ClientPreviewHandle.projectId.null")
    private String projectId;
    @ApiModelProperty("预告标题")
    @NotEmpty(message = "ClientPreviewHandle.previewTitle.null")
    private String previewTitle;
    @ApiModelProperty("预告内容")
    @NotEmpty(message = "ClientPreviewHandle.previewMemo.null")
    private String previewMemo;
    @ApiModelProperty("采购商(法人)ID")
    @NotEmpty(message = "ClientPreviewHandle.purchaserId.null")
    private Long purchaserId;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPreviewTitle() {
        return previewTitle;
    }

    public void setPreviewTitle(String previewTitle) {
        this.previewTitle = previewTitle;
    }

    public String getPreviewMemo() {
        return previewMemo;
    }

    public void setPreviewMemo(String previewMemo) {
        this.previewMemo = previewMemo;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    @Override
    public String toString() {
        return "ClientPreviewHandle{" +
                "projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", previewTitle='" + previewTitle + '\'' +
                ", previewMemo='" + previewMemo + '\'' +
                ", purchaserId='" + purchaserId + '\'' +
                '}';
    }
}
