package com.epc.platform.service.domain.supplier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:t_win_bid表的实体类
 * @version
 * @author:  01
 * @创建时间: 2018-10-05
 */
public class TWinBid implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 采购项目id
     */
    private Long procurementProjectId;

    /**
     * 采购项目名称
     */
    private String procurementProjectName;

    /**
     * 标段id
     */
    private Long bidId;

    /**
     * 标段名称
     */
    private String bidName;

    /**
     * 标段编号
     */
    private String bidCode;

    /**
     * 采购人(法人)ID
     */
    private Long purchaserId;

    /**
     * 采购人中标价格
     */
    private BigDecimal purchaserMonety;

    /**
     * 中标通知书路径
     */
    private String filePath;

    /**
     * 供应商Id
     */
    private Long supplierId;

    /**
     * 操作人ID
     */
    private Long operateId;

    /**
     * 审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     */
    private String processStatus;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

    /**
     * t_win_bid
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
     * 项目id
     * @return project_id 项目id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 项目id
     * @param projectId 项目id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 项目名称
     * @return project_name 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 项目编号
     * @return project_code 项目编号
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * 项目编号
     * @param projectCode 项目编号
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    /**
     * 采购项目id
     * @return procurement_project_id 采购项目id
     */
    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    /**
     * 采购项目id
     * @param procurementProjectId 采购项目id
     */
    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    /**
     * 采购项目名称
     * @return procurement_project_name 采购项目名称
     */
    public String getProcurementProjectName() {
        return procurementProjectName;
    }

    /**
     * 采购项目名称
     * @param procurementProjectName 采购项目名称
     */
    public void setProcurementProjectName(String procurementProjectName) {
        this.procurementProjectName = procurementProjectName == null ? null : procurementProjectName.trim();
    }

    /**
     * 标段id
     * @return bid_id 标段id
     */
    public Long getBidId() {
        return bidId;
    }

    /**
     * 标段id
     * @param bidId 标段id
     */
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    /**
     * 标段名称
     * @return bid_name 标段名称
     */
    public String getBidName() {
        return bidName;
    }

    /**
     * 标段名称
     * @param bidName 标段名称
     */
    public void setBidName(String bidName) {
        this.bidName = bidName == null ? null : bidName.trim();
    }

    /**
     * 标段编号
     * @return bid_code 标段编号
     */
    public String getBidCode() {
        return bidCode;
    }

    /**
     * 标段编号
     * @param bidCode 标段编号
     */
    public void setBidCode(String bidCode) {
        this.bidCode = bidCode == null ? null : bidCode.trim();
    }

    /**
     * 采购人(法人)ID
     * @return purchaser_id 采购人(法人)ID
     */
    public Long getPurchaserId() {
        return purchaserId;
    }

    /**
     * 采购人(法人)ID
     * @param purchaserId 采购人(法人)ID
     */
    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    /**
     * 采购人中标价格
     * @return purchaser_monety 采购人中标价格
     */
    public BigDecimal getPurchaserMonety() {
        return purchaserMonety;
    }

    /**
     * 采购人中标价格
     * @param purchaserMonety 采购人中标价格
     */
    public void setPurchaserMonety(BigDecimal purchaserMonety) {
        this.purchaserMonety = purchaserMonety;
    }

    /**
     * 中标通知书路径
     * @return file_path 中标通知书路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 中标通知书路径
     * @param filePath 中标通知书路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * 供应商Id
     * @return supplier_id 供应商Id
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 供应商Id
     * @param supplierId 供应商Id
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 操作人ID
     * @return operate_id 操作人ID
     */
    public Long getOperateId() {
        return operateId;
    }

    /**
     * 操作人ID
     * @param operateId 操作人ID
     */
    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    /**
     * 审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     * @return process_status 审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     */
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     * 审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     * @param processStatus 审核 auditing, 批复 reply, 待发布wait_release,已发布 released, 未提交not_submit, 失效invalid
     */
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
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
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectCode=").append(projectCode);
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", procurementProjectName=").append(procurementProjectName);
        sb.append(", bidId=").append(bidId);
        sb.append(", bidName=").append(bidName);
        sb.append(", bidCode=").append(bidCode);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", purchaserMonety=").append(purchaserMonety);
        sb.append(", filePath=").append(filePath);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", operateId=").append(operateId);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", createAt=").append(createAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}