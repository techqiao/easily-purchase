package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplieIsDeleted implements Serializable {
    private static final long serialVersionUID = 8097108501834285998L;

    private Integer type;
    private Integer loginRole;

    private Long id;

    private Integer isDeleted;

}
