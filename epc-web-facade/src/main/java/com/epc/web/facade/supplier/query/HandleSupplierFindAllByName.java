package com.epc.web.facade.supplier.query;

import lombok.Data;

import java.io.Serializable;

/**
 * 模糊查询
 * @author donghuan
 */
@Data
public class HandleSupplierFindAllByName implements Serializable {

    private static final long serialVersionUID = 6442404196444822954L;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 模糊名称
     */
    private String where;


    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
