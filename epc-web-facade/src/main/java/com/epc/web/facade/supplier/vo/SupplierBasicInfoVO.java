package com.epc.web.facade.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
     * 供应商(法人)ID
     */
    private Long supplierId;

    /**
     * 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构
     */
    private Integer inviterType;

    /**
     * 邀请人Id
     */
    private Long inviterId;

    /**
     * 邀请人机构ID
     */
    private Integer inviterCompanyId;

    /**
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    private Integer state;

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
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;


}
