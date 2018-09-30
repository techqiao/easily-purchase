package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description: 标段详情
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel("标段详情")
public class TenderVO implements Serializable {
    private static final long serialVersionUID = -5356014540658555198L;
    @ApiModelProperty("标段ID")
    private Long id;
    @ApiModelProperty("标段编号")
    private String bidCode;
    @ApiModelProperty("标段名称")
    private String bidName;
    @ApiModelProperty("标段文件路径")
    private String bidFilePath;
    @ApiModelProperty("标段内容")
    private String bidMemo;
    @ApiModelProperty("创建时间")
    private Date createAt;
}
