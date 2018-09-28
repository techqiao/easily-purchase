package com.epc.web.facade.terdering.preview.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 11:23
 * <p>@Author : luozhixin
 * <p>ProJectPermissionVO
 */
@Data
public class ProJectPermissionVO implements Serializable {
    private static final long serialVersionUID = -7778981543301533239L;
    /**
     * 招标公告附件url
     */
    private String biddingDocumentsUrl;

    /**
     * 招标公告开始时间
     */
    private Date biddingStart;

    /**
     * 招标公告结束时间
     */
    private Date biddingEnd;

    /**
     * 公告评语
     */
    private String announcementContent;

    /**
     * 审核 auditing,
     * 批复 reply,
     * 待发布wait_release,
     * 已发布 released,
     * 未提交not_submit,
     * 失效invalid
     */
    private String processStatus;

    /**
     * 操作人ID
     */
    private Long operateId;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 最后修改时间
     */
    private Date updateAt;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 采购项目名称
     */
    private String purchaseProjectName;

    /**
     *采购项目编号
     */
    private String purchaseProjectCode;

    /**
     * 采购项目开始时间
     */
    private Date purchaseStartTime;

    /**
     * 采购项目结束时间
     */
    private Date purchaseEndTime;

    /**
     * 采购项目预算金额
     */
    private BigDecimal purchaseProjectBudgetaryAmount;

    /**
     * 采购方式
     * 招标采购:selective_tendering
     * 询比采购:
     * 竞价采购:
     * 谈判采购:
     * 直接采购:
     * 框架协议采购
     */
    private String purchaseMode;

    /**
     * 采购分类
     * 劳务分包
     * 专业分包
     * 2：设备租赁
     * 3：货物采购
     * 4：服务采购
     * 5：工程采购
     */
    private String purchaseCategory;

    /**
     *采购类型 36种 13种  根据采购分类来
     */
    private String purchaseType;

    /**
     * 可见范围
     */
    private Integer purchaseRange;

    /**
     * 采购项目状态 已创建 进行中 已结束 流标
     */
    private String purchaseProjectStatus;

    /**
     * 是否允许调价:0-不允许,1-允许
     */
    private Integer isAdjust;

    /**
     * 是否全权委托招标代理机构(0:不全权委托,1:全权委托)
     */
    private Integer isOtherAgency;

    /**
     * 参与者姓名
     */
    private String userName;

    /**
     * 参与者电话
     */
    private String userPhone;

    /**
     * 参与者机构名称
     */
    private String agencyName;

    /**
     * 项目参与者权限
     * 批复reply
     * 经办agent
     * 审核auditor
     * 负责人person_liable
     */
    private String participantPermission;




    @Override
    public String toString() {
        return "ProJectPermissionVO{" +
                "biddingDocumentsUrl='" + biddingDocumentsUrl + '\'' +
                ", biddingStart=" + biddingStart +
                ", biddingEnd=" + biddingEnd +
                ", announcementContent='" + announcementContent + '\'' +
                ", processStatus='" + processStatus + '\'' +
                ", operateId='" + operateId + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", projectName='" + projectName + '\'' +
                ", purchaseProjectName='" + purchaseProjectName + '\'' +
                ", purchaseProjectCode='" + purchaseProjectCode + '\'' +
                ", purchaseStartTime=" + purchaseStartTime +
                ", purchaseEndTime=" + purchaseEndTime +
                ", purchaseProjectBudgetaryAmount=" + purchaseProjectBudgetaryAmount +
                ", purchaseMode='" + purchaseMode + '\'' +
                ", purchaseCategory='" + purchaseCategory + '\'' +
                ", purchaseType='" + purchaseType + '\'' +
                ", purchaseRange='" + purchaseRange + '\'' +
                ", purchaseProjectStatus='" + purchaseProjectStatus + '\'' +
                ", isAdjust='" + isAdjust + '\'' +
                ", isOtherAgency='" + isOtherAgency + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", participantPermission='" + participantPermission + '\'' +
                '}';
    }
}
