package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HandlePretriaFile implements Serializable {
    private static final long serialVersionUID = 4136754272238787996L;

    private Long id;

    private Long purchasProjectId;

    private Long releaseAnnouncementId;

    private Long companyId;

    private Long operateId;

    private String operateName;

    private String content;

    private List<BasePretriaFile> filePathList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchasProjectId() {
        return purchasProjectId;
    }

    public void setPurchasProjectId(Long purchasProjectId) {
        this.purchasProjectId = purchasProjectId;
    }

    public Long getReleaseAnnouncementId() {
        return releaseAnnouncementId;
    }

    public void setReleaseAnnouncementId(Long releaseAnnouncementId) {
        this.releaseAnnouncementId = releaseAnnouncementId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BasePretriaFile> getFilePathList() {
        return filePathList;
    }

    public void setFilePathList(List<BasePretriaFile> filePathList) {
        this.filePathList = filePathList;
    }
}
