package com.epc.web.facade.dictionay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("字典")
public class SysDictionaryVO {

    @ApiModelProperty("字典主键")
    private Long dictId;

    @ApiModelProperty("文本")
    private String text;

    @ApiModelProperty("值（关联）")
    private String value;

    @ApiModelProperty("全路径（查询）")
    private String path;

    @ApiModelProperty("顺序（排序）")
    private Float seq;

    @ApiModelProperty("类型")
    private String type;

}
