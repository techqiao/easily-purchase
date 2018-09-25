package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:    供应商录入员工
 * @Author:          donghuan
 */
@Data
public class HandlerSupplierAddEmployee implements Serializable{
    private static final long serialVersionUID = -2240760593421147556L;

    /**
     * 供应商的id
     */
    private Long supplierId;

    /**
     * 供应商员工的状态
     */
    private Integer state;

    /**
     * 员工角色
     */
    private Integer role;

    /**
     * 员工名字
     */
    private String name;

    /**
     * 员工电话
     */
    private String cellphone;

    /**
     * 员工密码
     */
    private String password;

    /**
     * 是否存在
     */
    private Integer isDeleted;

    /**
     * 创建的时间
     */
    private Date createAt;

    /**
     * 修改的时间
     */
    private Date updateAt;

}

