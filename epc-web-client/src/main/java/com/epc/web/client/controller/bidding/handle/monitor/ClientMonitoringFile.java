package com.epc.web.client.controller.bidding.handle.monitor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 监控文件
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel("新增文件监控记录")
public class ClientMonitoringFile implements Serializable {

    private static final long serialVersionUID = -3614878021944416043L;
    @ApiModelProperty("文件类型")
    private String fileType;
    @ApiModelProperty("文件id")
    private Long fileId;
    @ApiModelProperty("文件名")
    private String fileName;
    @ApiModelProperty("文件路径")
    private String filePath;
    @ApiModelProperty("人员类型")
    private String operateType;
    @ApiModelProperty("人员id")
    private Long operateId;
    @ApiModelProperty("人员姓名")
    private String operator;
}
