package com.epc.administration.facade.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:38
 * <p>@Author : luozhixin
 */
public class DeptHandle implements Serializable {
    private static final long serialVersionUID = -4436239808687151630L;
    private String deptName;
    private Long parentId;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "DeptHandle{" +
                "deptName='" + deptName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
