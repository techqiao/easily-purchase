package com.epc.web.service.domain.purchaser;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TPurchaserAgency implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 审核状态
     */
    private Integer state;
    /**
     * 代理机构id
     */
    private Long agencyId;
    /**
     * 操作人id
     */
    private Long createrId;
    /**
     * 采购人id
     */
    private String purchaserId;
    /**
     * 来源
     */
    private String source;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    private static final long serialVersionUID = 1L;


}