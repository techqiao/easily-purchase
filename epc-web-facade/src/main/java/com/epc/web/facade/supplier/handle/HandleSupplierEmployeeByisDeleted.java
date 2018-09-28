package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplierEmployeeByisDeleted implements Serializable {
    private static final long serialVersionUID = 8414946572797980644L;

    //员工id
    private Long id;

    //是否禁用
    private Integer isDeleted;

}
