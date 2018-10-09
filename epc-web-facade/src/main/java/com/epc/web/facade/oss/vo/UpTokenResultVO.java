package com.epc.web.facade.oss.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SongXing
 * @Description: 上传凭证 返回值
 * @date 2018-10-9 10:19:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UpTokenResultVO {

    @ApiModelProperty("上传凭证")
    private String upToken;

    @ApiModelProperty("保存文件Key")
    private String savingFileKey;
}
