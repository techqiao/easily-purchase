package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplierRecordByCellphone implements Serializable {
    private static final long serialVersionUID = -9101853574553429537L;

    /**
     *  电话
     */
    private String cellphone;

}
