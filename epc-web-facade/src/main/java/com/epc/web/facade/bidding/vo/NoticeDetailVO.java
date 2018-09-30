package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告详情
 * @author linzhixiang
 */
@Data
public class NoticeDetailVO implements Serializable {

    private static  long serialVersionUID = -8445436128833921499L;
    /**
     * 公告Id
     */
    private Long id;
    /**
     * 开始时间
     */
    private Date biddingStart;
    /**
     * 结束时间
     */
    private Date biddingEnd;
    /**
     * 采购项目名称
     */
    private String procurementProjectName;
    /**
     * 招标方式
     */
    private String biddingType;
    /**
     * 标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String announcementContent;
    /**
     * 文件路径
     */
    private String biddingDocumentsUrl;

}
