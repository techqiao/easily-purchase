package com.epc.platform.service.domain.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:t_expert_attachment表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-09-28
 */
public class TExpertAttachment implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 招标(采购)代理机构 ID
     */
    private Long expertId;

    /**
     * 附件类型
     */
    private String certificateType;

    /**
     * 附件url
     */
    private String certificateFilePath;

    /**
     * 附件号码
     */
    private String certificateNumber;

    /**
     * 附件对应证书名称
     */
    private String certificateName;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

    /**
     * t_expert_attachment
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 招标(采购)代理机构 ID
     * @return expert_id 招标(采购)代理机构 ID
     */
    public Long getExpertId() {
        return expertId;
    }

    /**
     * 招标(采购)代理机构 ID
     * @param expertId 招标(采购)代理机构 ID
     */
    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    /**
     * 附件类型
     * @return certificate_type 附件类型
     */
    public String getCertificateType() {
        return certificateType;
    }

    /**
     * 附件类型
     * @param certificateType 附件类型
     */
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    /**
     * 附件url
     * @return certificate_file_path 附件url
     */
    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    /**
     * 附件url
     * @param certificateFilePath 附件url
     */
    public void setCertificateFilePath(String certificateFilePath) {
        this.certificateFilePath = certificateFilePath == null ? null : certificateFilePath.trim();
    }

    /**
     * 附件号码
     * @return certificate_number 附件号码
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * 附件号码
     * @param certificateNumber 附件号码
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    /**
     * 附件对应证书名称
     * @return certificate_name 附件对应证书名称
     */
    public String getCertificateName() {
        return certificateName;
    }

    /**
     * 附件对应证书名称
     * @param certificateName 附件对应证书名称
     */
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName == null ? null : certificateName.trim();
    }

    /**
     * 创建时间
     * @return create_at 创建时间
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * 创建时间
     * @param createAt 创建时间
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 最后修改时间
     * @return update_at 最后修改时间
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * 最后修改时间
     * @param updateAt 最后修改时间
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 是否删除: 0-存在,1-删除
     * @return is_deleted 是否删除: 0-存在,1-删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除: 0-存在,1-删除
     * @param isDeleted 是否删除: 0-存在,1-删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", expertId=").append(expertId);
        sb.append(", certificateType=").append(certificateType);
        sb.append(", certificateFilePath=").append(certificateFilePath);
        sb.append(", certificateNumber=").append(certificateNumber);
        sb.append(", certificateName=").append(certificateName);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}