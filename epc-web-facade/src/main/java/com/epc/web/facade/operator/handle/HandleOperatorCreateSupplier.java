package com.epc.web.facade.operator.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleOperatorCreateSupplier implements Serializable {
    private static final long serialVersionUID = -5736211877520353729L;

    /**
     * 运营商员工主键id
     */
    private Long id;

    /**
     * 供应商法人姓名
     */
    private String name;

    /**
     * 手机号(登录账号)
     */
    private String cellphone;






}
