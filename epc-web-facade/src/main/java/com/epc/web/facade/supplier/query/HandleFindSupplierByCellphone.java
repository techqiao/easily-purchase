package com.epc.web.facade.supplier.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleFindSupplierByCellphone implements Serializable {
    private static final long serialVersionUID = 8441079463359348978L;

    /**
     * 根据电话来查询一条记录
     */
    private String cellPhone;

}
