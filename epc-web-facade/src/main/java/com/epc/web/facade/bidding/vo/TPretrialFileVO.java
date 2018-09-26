package com.epc.web.facade.bidding.vo;

import lombok.Data;

/**
 * <p>Description : 查询文件列表返回
 * <p>Date : 2018-09-25 16:31
 * <p>@Author : luozhixin
 * <p>TPretrialFileVO
 */
@Data
public class TPretrialFileVO {

    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;

    /**
     * 公告ID
     */
    private Long releaseAnnouncementId;

    /**
     * company_id
     */
    private Long companyId;

    /**
     * 是否通过:
     * review-审核中,
     * noPass-未通过,
     * pass-通过
     */
    private String status;

    /**
     * 信息
     */
    private String content;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名
     */
    private String fileName;

}
