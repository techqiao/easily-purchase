package com.epc.web.facade.terdering.bid.handle;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : 线下招标文件
 * <p>Date : 2018-09-25 14:08
 * <p>@Author : wjq
 */
@Data
public class HandleUnderLine {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long procurementProjectId;
    /**
     * 发售招标文件表主键ID
     */
    private Long bIssueDocumentsId;
    /**
     * 发售开始时间
     */
    private Date saleTimeStart;
    /**
     * 发售截止时间
     */
    private Date saleTimeEnd;
    /**
     * 发售地点
     */
    private String place;
    /**
     * 金额
     */
    private BigDecimal price;
    /**
     * 联系人
     */
    private String contactsName;
    /**
     * 联系电话
     */
    private String contactNumber;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 操作人ID
     */
    private Long operateId;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 修改时间
     */
    private Date updateAt;
    /**
     * 是否删除
     */
    private Integer isDeleted;
}
