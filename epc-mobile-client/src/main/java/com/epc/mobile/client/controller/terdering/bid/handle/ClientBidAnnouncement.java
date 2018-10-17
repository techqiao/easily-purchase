package com.epc.mobile.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
* @Description:  创建唱标记录
* @Author: linzhixiang
* @Date: 2018/9/25
*/
@Data
@ApiModel(value = "唱标记录",description = "唱标记录")
public class ClientBidAnnouncement implements Serializable {

    private static final long serialVersionUID = -7767001037669780657L;

    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "文件路径")
    private String filePath;

}
