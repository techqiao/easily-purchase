package com.epc.web.facade.terdering.pretrial.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:32
 * <p>@Author : wjq
 */
@Data
public class PretrialMessageVO {
    /**
     * id
     */
    private Long id;
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 公告ID
     */
    private Long releaseAnnouncementId;
    /**
     * 公司ID
     */
    private Long companyId;
    /**
     * 是否通过: review-审核中,noPass-未通过,pass-通过
     */
    private String status;
    /**
     * 信息
     */
    private String content;
    /**
     * 操作人ID
     */
    private Long operateId;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 文件
     */
    private List<String> url;

}
