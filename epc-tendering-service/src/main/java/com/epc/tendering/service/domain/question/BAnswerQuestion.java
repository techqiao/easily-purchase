package com.epc.tendering.service.domain.question;

import java.io.Serializable;
import java.util.Date;

public class BAnswerQuestion implements Serializable {
    private Long id;

    private Long procurementProjectId;

    private String questionerFromType;

    private Long questionerId;

    private String questionType;

    private String questionerName;

    private Long typeId;

    private String answerPersonType;

    private Long answerId;

    private String answerName;

    private String status;

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

    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    public String getQuestionerFromType() {
        return questionerFromType;
    }

    public void setQuestionerFromType(String questionerFromType) {
        this.questionerFromType = questionerFromType == null ? null : questionerFromType.trim();
    }

    public Long getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(Long questionerId) {
        this.questionerId = questionerId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getQuestionerName() {
        return questionerName;
    }

    public void setQuestionerName(String questionerName) {
        this.questionerName = questionerName == null ? null : questionerName.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getAnswerPersonType() {
        return answerPersonType;
    }

    public void setAnswerPersonType(String answerPersonType) {
        this.answerPersonType = answerPersonType == null ? null : answerPersonType.trim();
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName == null ? null : answerName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", procurementProjectId=").append(procurementProjectId);
        sb.append(", questionerFromType=").append(questionerFromType);
        sb.append(", questionerId=").append(questionerId);
        sb.append(", questionType=").append(questionType);
        sb.append(", questionerName=").append(questionerName);
        sb.append(", typeId=").append(typeId);
        sb.append(", answerPersonType=").append(answerPersonType);
        sb.append(", answerId=").append(answerId);
        sb.append(", answerName=").append(answerName);
        sb.append(", status=").append(status);
        sb.append(", operateId=").append(operateId);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}