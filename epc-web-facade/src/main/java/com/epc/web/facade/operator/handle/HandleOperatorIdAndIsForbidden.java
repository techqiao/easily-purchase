package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorIdAndIsForbidden implements Serializable {
    private static final long serialVersionUID = 5033591405148047290L;

    private Long id;

    private Integer isForbidden;

}
