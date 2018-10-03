package com.epc.web.facade.terdering.pretrial.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:32
 * <p>@Author : wjq
 */
@ApiModel(value = "资格审查详情")
@Data
public class PretrialMessageVO implements Serializable {
    private static final long serialVersionUID = -3859386139226644319L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "公告ID")
    private Long releaseAnnouncementId;
    @ApiModelProperty(value = "公司ID")
    private Long companyId;
    @ApiModelProperty(value = "是否通过: review-审核中,noPass-未通过,pass-通过")
    private String status;
    @ApiModelProperty(value = "信息")
    private String content;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;
    @ApiModelProperty(value = "创建者")
    private String creator;
    @ApiModelProperty(value = "文件")
    private List<String> url;
    @ApiModelProperty(value = "标段ID")
    private Long bidId;

}
