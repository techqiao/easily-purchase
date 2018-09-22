package com.epc.web.facade.supplier.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindSupplierByCellphoneVO implements Serializable {
    private static final long serialVersionUID = 1423167433707831433L;

    /**
     * 运营商法人ID
     */
    private Long supplierId;
}
