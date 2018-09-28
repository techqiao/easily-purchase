package com.epc.administration.facade.admin.handle;


import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:46
 * <p>@Author : luozhixin
 */
public class RoleHandle implements Serializable {
    private static final long serialVersionUID = -6141001495978320281L;
    private String memo;
    private String name;
    private Long depId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


    public Long getDepId() {

        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "RoleHandle{" +
                "memo='" + memo + '\'' +
                ", name='" + name + '\'' +
                ", depId=" + depId +
                '}';
    }
}
