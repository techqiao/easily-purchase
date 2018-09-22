package com.epc.web.client.controller.bidding.handle.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 供应商上传文件
 * @author linzhixiang
 */

@ApiModel(value = "HandleFileUpload",description = "文件上传")
@Data
public class ClientHandleFileUpload {
    @ApiModelProperty(value = "记录Id")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchasProjectId;
    @ApiModelProperty(value = "公告ID")
    private Long releaseAnnouncementId;
    @ApiModelProperty(value = "供应商Id")
    private Long companyId;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;
    @ApiModelProperty(value = "操作人姓名")
    private String operateName;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "文件路径集合")
    private List<BasePretriaFile> filePathList;
}
