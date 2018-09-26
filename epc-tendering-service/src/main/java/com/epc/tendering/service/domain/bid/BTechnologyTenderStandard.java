package com.epc.tendering.service.domain.bid;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 01
 */
public class BTechnologyTenderStandard implements Serializable {


    private Long id;

    private Long evaluationTenderStandardId;

    private String evaluationFactors;

    private String explain;

    private String dividingRangeStart;

    private String dividingRangeEnd;

    private Long operateId;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

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

    public String getEvaluationFactors() {
        return evaluationFactors;
    }

    public void setEvaluationFactors(String evaluationFactors) {
        this.evaluationFactors = evaluationFactors == null ? null : evaluationFactors.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getDividingRangeStart() {
        return dividingRangeStart;
    }

    public void setDividingRangeStart(String dividingRangeStart) {
        this.dividingRangeStart = dividingRangeStart == null ? null : dividingRangeStart.trim();
    }

    public String getDividingRangeEnd() {
        return dividingRangeEnd;
    }

    public void setDividingRangeEnd(String dividingRangeEnd) {
        this.dividingRangeEnd = dividingRangeEnd == null ? null : dividingRangeEnd.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", evaluationTenderStandardId=").append(evaluationTenderStandardId);
        sb.append(", evaluationFactors=").append(evaluationFactors);
        sb.append(", explain=").append(explain);
        sb.append(", dividingRangeStart=").append(dividingRangeStart);
        sb.append(", dividingRangeEnd=").append(dividingRangeEnd);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}