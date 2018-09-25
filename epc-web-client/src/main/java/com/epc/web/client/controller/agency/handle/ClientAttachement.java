package com.epc.web.client.controller.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  winlin
 */
@Data
@ApiModel(value = "Attachment" ,description = "上传附件类型")
public class ClientAttachement implements Serializable{

    private static final long serialVersionUID = 6378334629429412094L;
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
