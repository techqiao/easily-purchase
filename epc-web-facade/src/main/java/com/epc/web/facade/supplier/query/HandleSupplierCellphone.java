package com.epc.web.facade.supplier.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplierCellphone implements Serializable {
    private static final long serialVersionUID = -9101853574553429537L;

    /**
     *  电话
     */
    private String cellphone;

}
