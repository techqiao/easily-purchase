package com.epc.web.client.controller.bidding.query.monitor;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 文件监控 模糊查询
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel(value = "文件监控")
public class ClientMonitoringFileDTO extends PagerParam implements Serializable {

    private static final long serialVersionUID = 5073558120339217414L;
    @ApiModelProperty("文件类型")
    private String fileType;
    @ApiModelProperty("文件名")
    private String fileName;
    @ApiModelProperty("操作人类型")
    private String operateType;
    @ApiModelProperty("操作人姓名")
    private String operator;
    @ApiModelProperty("开始时间")
    private Date startDate;
    @ApiModelProperty("结束时间")
    private Date endDate;

}
