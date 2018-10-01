package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;


/**
 * 供应商注册详情
 * @author donghuan
 */
@Data
public class  HandleSupplierDetail implements Serializable {

    private static final long serialVersionUID = 8608242287921574415L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String cellphone;

    /**
     * 密码
     */
    private String password;


}
