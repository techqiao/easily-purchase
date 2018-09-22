package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商修改员工信息
 * @author donghuan
 */
@Data
public class HandlerUpdateSupplierEmployeeById implements Serializable {
    private static final long serialVersionUID = 5772504294082133470L;

    /**
     * 员工id
     */
    private Long id;

    /**
     * 员工名字
     */
    private String name;

    /**
     * 员工电话
     */
    private String cellphone;

    /**
     * 员工状态是否启用与禁用
     */
    private Integer isDeleted;

    /**
     * 最后更新的时间
     */
    private Date updateAt;

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
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
