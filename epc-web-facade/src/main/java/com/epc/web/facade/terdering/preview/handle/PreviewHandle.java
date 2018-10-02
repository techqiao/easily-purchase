package com.epc.web.facade.terdering.preview.handle;


import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:18
 * <p>@Author : luozhixin
 * <p>PreviewHandle
 */
public class PreviewHandle implements Serializable {

    private String projectCode;
    private String projectName;
    private String projectId;
    private String previewTitle;
    private String previewMemo;
    private Long purchaserId;
    private String creator;
    private Long setOperateId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getSetOperateId() {
        return setOperateId;
    }

    public void setSetOperateId(Long setOperateId) {
        this.setOperateId = setOperateId;
    }
}
