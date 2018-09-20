package com.epc.web.facade.terdering.project.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 13:53
 * <p>@Author : wjq
 */
@Data
public class HandleProjectBasicInfo implements Serializable {
    private static final long serialVersionUID = -4463269160620766739L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目描述
     */
    private String projectDescription;
    /**
     * 是否国家指定必须招标项目
     */
    private String isStateDesignation;
    /**
     * 项目总投资
     */
    private String totalProjectInvestment;
    /**
     * 投资来源
     */
    private String sourceOfInvestment;
    /**
     * 项目地址
     */
    private String projectAddress;
    /**
     * 项目备注
     */
    private String projectMemo;
    /**
     * 采购人ID
     */
    private Long purchaserId;
    /**
     * 操作人ID
     */
    private Long operateId;
    /**
     * 创建者姓名
     */
    private String creator;
}
