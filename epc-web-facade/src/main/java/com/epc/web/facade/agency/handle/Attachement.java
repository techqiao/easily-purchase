package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Attachement implements Serializable{
    private static final long serialVersionUID = -661929575861972061L;
    /**
     * 类别角色自己的id号
     */
    private String typeId;
    /**
     * 证书类型
     */
    private String certificateType;
    /**
     * 证书网上存储路径
     */
    private String certificateFilePath;
    /**
     * 证书附件编号
     */
    private String certificateNumber;
    /**
     * 附件的名称
     */
    private String certificateName;
    private Date createAt;
    private Date updateAt;
    private Boolean isDelete;
}
