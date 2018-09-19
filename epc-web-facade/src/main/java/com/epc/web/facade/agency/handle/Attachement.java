package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Attachement implements Serializable{
    private static final long serialVersionUID = -661929575861972061L;
    private String typeId;
    private String certificateType;
    private String certificateFilePath;
    private String certificateNumber;
    private String certificateName;
    private Date createAt;
    private Date updateAt;
    private Boolean isDelete;
}
