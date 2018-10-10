package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleFindSupplierBasicById implements Serializable {
    private static final long serialVersionUID = 2021866258766971617L;

    private Long id;

//    private Integer systemRole;

    private Integer loginRole;


}
