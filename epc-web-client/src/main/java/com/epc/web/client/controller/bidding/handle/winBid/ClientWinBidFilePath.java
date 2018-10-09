package com.epc.web.client.controller.bidding.handle.winBid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 中标公告
 * @Author: linzhixiang
 * @Date: 2018/10/8
 */ 
@Data
@ApiModel(value = "中标公告")
public class ClientWinBidFilePath implements Serializable {
    private static final long serialVersionUID = 534323726715343015L;
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "中标公示文件路径")
    private String filePath;
}
