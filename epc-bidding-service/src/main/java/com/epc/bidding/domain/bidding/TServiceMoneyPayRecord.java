package com.epc.bidding.domain.bidding;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TServiceMoneyPayRecord implements Serializable {
    private Long id;

    private Long moneyPayId;

    private Long operaterId;

    private String operaterName;

    private BigDecimal guaranteePaymentReal;

    private String creator;

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

    public Long getMoneyPayId() {
        return moneyPayId;
    }

    public void setMoneyPayId(Long moneyPayId) {
        this.moneyPayId = moneyPayId;
    }

    public Long getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(Long operaterId) {
        this.operaterId = operaterId;
    }

    public String getOperaterName() {
        return operaterName;
    }

    public void setOperaterName(String operaterName) {
        this.operaterName = operaterName == null ? null : operaterName.trim();
    }

    public BigDecimal getGuaranteePaymentReal() {
        return guaranteePaymentReal;
    }

    public void setGuaranteePaymentReal(BigDecimal guaranteePaymentReal) {
        this.guaranteePaymentReal = guaranteePaymentReal;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        sb.append(", moneyPayId=").append(moneyPayId);
        sb.append(", operaterId=").append(operaterId);
        sb.append(", operaterName=").append(operaterName);
        sb.append(", guaranteePaymentReal=").append(guaranteePaymentReal);
        sb.append(", creator=").append(creator);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}