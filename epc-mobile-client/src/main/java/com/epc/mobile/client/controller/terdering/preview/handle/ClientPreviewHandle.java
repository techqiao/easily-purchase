package com.epc.mobile.client.controller.terdering.preview.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:07
 * <p>@Author : luozhixin
 * <p>
 */
@Data
public class ClientPreviewHandle  implements Serializable {
    private static final long serialVersionUID = -8995905669161336733L;

    @ApiModelProperty("项目编号")
    @NotEmpty(message = "ClientPreviewHandle.projectCode.null")
    private String projectCode;
    @ApiModelProperty("项目名称")
    @NotEmpty(message = "ClientPreviewHandle.projectName.null")
    private String projectName;
    @ApiModelProperty("项目ID")
    @NotEmpty(message = "ClientPreviewHandle.projectId.null")
    private Long projectId;
    @ApiModelProperty("预告标题")
    @NotEmpty(message = "ClientPreviewHandle.previewTitle.null")
    private String previewTitle;
    @ApiModelProperty("预告内容")
    @NotEmpty(message = "ClientPreviewHandle.previewMemo.null")
    private String previewMemo;


}
