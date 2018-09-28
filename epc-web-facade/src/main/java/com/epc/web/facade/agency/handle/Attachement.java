package com.epc.web.facade.agency.handle;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Attachement implements Serializable{
    private static final long serialVersionUID = -661929575861972061L;
    /**
     * 类别角色自己的id号
     */
    private String typeId;
    /**
     * 证书类型
     */
    private String certificateType;
    /**
     * 证书网上存储路径
     */
    private String certificateFilePath;
    /**
     * 证书附件编号
     */
    private String certificateNumber;
    /**
     * 附件的名称
     */
    private String certificateName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;
    private Boolean isDelete;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    public void setCertificateFilePath(String certificateFilePath) {
        this.certificateFilePath = certificateFilePath;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
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

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
