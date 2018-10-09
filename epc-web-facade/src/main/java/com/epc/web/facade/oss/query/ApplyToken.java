package com.epc.web.facade.oss.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author SongXing
 * @Description: 前台获取'凭证'需要的参数
 * @date 2018-10-9 10:12:04
 */
@Data
@ApiModel
public class ApplyToken {

    @ApiModelProperty("业务模块Code")
    private String businessModelCode;

    @ApiModelProperty("文件原始名")
    private String regionFileName;




}
