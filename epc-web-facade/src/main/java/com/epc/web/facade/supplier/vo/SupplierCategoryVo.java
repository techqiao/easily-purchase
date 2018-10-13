package com.epc.web.facade.supplier.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "SupplierCategoryVo",description = "供应商类别")
public class SupplierCategoryVo implements Serializable {
    private static final long serialVersionUID = -7322077162346567132L;
    @ApiModelProperty(value = "类别文字字面显示")
    private String categoryText;
    @ApiModelProperty(value="传回后端的值")
    private String  value;
}
