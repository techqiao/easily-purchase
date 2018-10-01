package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientAttachment",description = "附件信息")
@Data
public class ClientAttachment {

    @ApiModelProperty(value = "附件类型")
    private String certificateType;

    @ApiModelProperty(value = "附件url")
    private String certificateFilePath;

    @ApiModelProperty(value = "附件号码")
    private String certificateNumber;

    @ApiModelProperty(value = "附件对应证件名称")
    private String certificateName;
}
