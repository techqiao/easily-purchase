package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商修改员工信息
 * @author donghuan
 */
@Data
public class HandlerUpdateSupplierEmployeeById implements Serializable {
    private static final long serialVersionUID = 5772504294082133470L;

    /**
     * 员工id
     */
    private Long id;

    /**
     * 员工名字
     */
    private String name;

    /**
     * 员工电话
     */
    private String cellphone;

    /**
     * 密码
     */
    private String password;

    /**
     * role 角色
     */
    private Integer role;


    /**
     * 是否禁用
     */
    private Integer isForbidden;

}
