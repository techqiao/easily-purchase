package com.epc.web.facade.supplier.handle;


import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSupplierNameAndCellphone implements Serializable {



    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String cellphone;

}
