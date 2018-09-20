package com.epc.web.facade.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商:审核所需详细信息
 */
@Data
public class SupplierDetailInfoVO implements Serializable {
    private static final long serialVersionUID = -3093453172970974408L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 运营商法人ID
     */
    private Long supplierId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一信用代码
     */
    private String uniformCreditCode;

    /**
     * 对公银行名称
     */
    private String publicBankName;

    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;

    /**
     * 创建时间
     */
    private Date createAt;

    /***
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;

}
