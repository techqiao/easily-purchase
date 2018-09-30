package com.epc.web.facade.terdering.announcement.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : 监管 公告
 * <p>Date : 2018-09-30 15:10
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "监管 公告")
public class PurchaseProjectAnnouncement implements Serializable {
    @ApiModelProperty(value = "公告类型")
    private String type;
    @ApiModelProperty(value = "公告名称")
    private String name;
    @ApiModelProperty(value = "文件")
    private String filePath;
}
