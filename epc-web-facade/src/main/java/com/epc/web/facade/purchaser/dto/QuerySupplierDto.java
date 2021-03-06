package com.epc.web.facade.purchaser.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class QuerySupplierDto implements Serializable {
    private static final long serialVersionUID = -1023471755306377489L;
    /**
     * 机构id
     */
    private Long supplierId;
    /**
     * 供应商名字
     */
    private String name;
    /**
     * 采购人id
     */
    private Long purchaserId;
}
