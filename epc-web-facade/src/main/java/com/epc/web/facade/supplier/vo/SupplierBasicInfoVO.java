package com.epc.web.facade.supplier.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 登陆进来的基本属性
 */
@Data
public class SupplierBasicInfoVO implements Serializable {

    private static final long serialVersionUID = -4387480918326084824L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String cellphone;


    /**
     * 用户角色:0-法人,1-管理员,2-普通员工
     */
    private Integer role;

    /**
     * 创建时间
     */
    private String createAt;

    /**
     * 最后修改时间
     */
    private String updateAt;

    /**
     * 是否禁用
     */
    private Integer isForbidden;


}
