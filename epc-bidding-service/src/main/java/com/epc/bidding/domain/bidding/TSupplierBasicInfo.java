package com.epc.bidding.domain.bidding;

import java.io.Serializable;
import java.util.Date;

public class TSupplierBasicInfo implements Serializable {
    private Long id;

    private String name;

    private String cellphone;

    private String password;

    private Long supplierId;

    private Integer inviterType;

    private Long inviterId;

    private Integer inviterCompanyId;

    private Integer state;

    private Integer role;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getInviterType() {
        return inviterType;
    }

    public void setInviterType(Integer inviterType) {
        this.inviterType = inviterType;
    }

    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public Integer getInviterCompanyId() {
        return inviterCompanyId;
    }

    public void setInviterCompanyId(Integer inviterCompanyId) {
        this.inviterCompanyId = inviterCompanyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
        sb.append(", name=").append(name);
        sb.append(", cellphone=").append(cellphone);
        sb.append(", password=").append(password);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", inviterType=").append(inviterType);
        sb.append(", inviterId=").append(inviterId);
        sb.append(", inviterCompanyId=").append(inviterCompanyId);
        sb.append(", state=").append(state);
        sb.append(", role=").append(role);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}