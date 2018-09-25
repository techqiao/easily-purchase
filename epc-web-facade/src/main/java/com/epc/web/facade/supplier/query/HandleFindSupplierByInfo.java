package com.epc.web.facade.supplier.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleFindSupplierByInfo implements Serializable {
    private static final long serialVersionUID = 8441079463359348978L;

    /**
     * 根据电话来查询一条记录
     */
    private String cellphone;

    /**
     * 根据id来查询一条记录
     * 员工id
     */
    private Long id;

    /**
     * 根据姓名电话来查找  /  模糊查询名称
     */
    private String name;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 依据role来查找 出supplier_id
     */
    private Integer role;



}
