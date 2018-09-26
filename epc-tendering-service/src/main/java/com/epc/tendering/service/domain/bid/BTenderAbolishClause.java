package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.util.Date;

public class BTenderAbolishClause implements Serializable {
    private Long id;

    private Long evaluationTenderStandardId;

    private Long operateId;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String tenderAbolishClause;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvaluationTenderStandardId() {
        return evaluationTenderStandardId;
    }

    public void setEvaluationTenderStandardId(Long evaluationTenderStandardId) {
        this.evaluationTenderStandardId = evaluationTenderStandardId;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
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

    public String getTenderAbolishClause() {
        return tenderAbolishClause;
    }

    public void setTenderAbolishClause(String tenderAbolishClause) {
        this.tenderAbolishClause = tenderAbolishClause == null ? null : tenderAbolishClause.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", evaluationTenderStandardId=").append(evaluationTenderStandardId);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", tenderAbolishClause=").append(tenderAbolishClause);
        sb.append("]");
        return sb.toString();
    }
}