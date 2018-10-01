package com.epc.web.facade.supplier.query;


import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplierIdAndName implements Serializable {

    private static final long serialVersionUID = 4294897343334948695L;

    private Long id;

    //名字
    private String name;

    //role 角色
    private Integer role;

    //是否禁用
    private Integer isForbidden;


}
