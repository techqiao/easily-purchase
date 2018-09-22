package com.epc.web.facade.bidding.vo;

import com.epc.web.facade.bidding.dto.FileListDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PretrialMessageVO implements Serializable {

    private static final long serialVersionUID = 1423008615238963440L;

    private Long id;

    private Long purchasProjectId;

    private Long releaseAnnouncementId;

    private Long companyId;

    private Long operateId;

    private String operateName;

    private String status;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String content;

    private List<FileListDTO> fileList;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<FileListDTO> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileListDTO> fileList) {
        this.fileList = fileList;
    }
}
