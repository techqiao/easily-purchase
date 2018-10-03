package com.epc.web.facade.terdering.announcement.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : 官网 公告预告
 * <p>Date : 2018-09-30 15:10
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "官网 公告 预告")
public class PurchaseProjectAnnouncementOfficialNetwork implements Serializable {
    @ApiModelProperty(value = "招标名称(采购项目名称)")
    private String purchaseProjectName;
    @ApiModelProperty(value = "采购单位")
    private String companyName;
    @ApiModelProperty(value = "招标地点")
    private String filePath;
    @ApiModelProperty(value = "结束日期")
    private Date biddingEnd;
    @ApiModelProperty(value = "开始日期")
    private Date biddingStart;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "预告内容")
    private String previewMemo;
    @ApiModelProperty(value = "预告标题")
    private String previewTitle;
    @ApiModelProperty(value = "项目ID")
    private Long  projectId;
    @ApiModelProperty(value = "采购项目ID")
    private Long  purchaseProjectId;
}
