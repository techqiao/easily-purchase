package com.epc.web.client.controller.terdering.bid.handle;

import lombok.Data;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-30 11:13
 * <p>@Author : wjq
 */
@Data
public class ClientPurchaseProjectBegin {
    /**
     * 发包方式
     */
    private String packetMode;
    /**
     * 是否资格预审
     */
    private Integer isPrequalification;
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 采购项目名称
     */
    private String purchaseProjectName;
    /**
     * 采购项目编码
     */
    private String purchaseProjectCode;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目编码
     */
    private String projectCode;
    /**
     * 采购地点
     */
    private String purchasePlace;

    private Long operateId;

    private String creator;

}
