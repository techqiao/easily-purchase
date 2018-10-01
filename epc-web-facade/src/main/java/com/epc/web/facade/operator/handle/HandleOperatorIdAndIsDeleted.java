package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorIdAndIsDeleted implements Serializable {
    private static final long serialVersionUID = 7365873978719281934L;

    private Long id;

    private Integer isDeleted;

}
