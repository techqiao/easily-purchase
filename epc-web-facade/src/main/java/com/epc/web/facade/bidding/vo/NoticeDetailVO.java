package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author linzhixiang
 */
@Data
@ApiModel("公告详情")
public class NoticeDetailVO implements Serializable {

    private static  long serialVersionUID = -8445436128833921499L;

    @ApiModelProperty("公告Id")
    private Long id;
    @ApiModelProperty("开始时间")
    private String biddingStart;
    @ApiModelProperty("结束时间")
    private String biddingEnd;
    @ApiModelProperty("采购项目id")
    private Long procurementProjectId;
    @ApiModelProperty("采购项目名称")
    private String procurementProjectName;
    @ApiModelProperty("招标方式")
    private String biddingType;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("公告内容")
    private String announcementContent;
    @ApiModelProperty("文件路径")
    private String biddingDocumentsUrl;
    @ApiModelProperty("澄清开始时间")
    private String defecationStart;
    @ApiModelProperty("澄清结束时间")
    private String defecationEnd;

}
