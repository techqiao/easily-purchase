package com.epc.web.service.domain.purchaser;

import java.io.Serializable;
import java.util.Date;

public class TPurchaserSupplier implements Serializable {

    private Long id;

    private String cellphone;

    private String password;

    private Integer state;

    private Long supplierId;

    private String supplierName;

    private String purchaserId;

    private String source;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId == null ? null : purchaserId.trim();
    }

    public String getSource() {
        return source;
    }


    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
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
        sb.append(", cellphone=").append(cellphone);
        sb.append(", password=").append(password);
        sb.append(", state=").append(state);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", source=").append(source);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}