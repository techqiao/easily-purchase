package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Attachment" ,description = "上传附件类型")
public class Attachement implements Serializable{
    @ApiModelProperty(value = "角色id")
    private String typeId;
    @ApiModelProperty(value = "附件类型")
    private String certificateType;
    @ApiModelProperty(value = "附件url")
    private String certificateFilePath;
    @ApiModelProperty(value = "附件号码")
    private String certificateNumber;
    @ApiModelProperty(value = "附件对应证书的名称")
    private String certificateName;
    @ApiModelProperty(value = "新增时间")
    private Date createAt;
    @ApiModelProperty(value = "更新时间")
    private Date updateAt;
    @ApiModelProperty(value ="存在状态")
    private Boolean isDelete;
}
