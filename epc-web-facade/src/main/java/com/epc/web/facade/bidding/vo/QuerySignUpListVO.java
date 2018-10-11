package com.epc.web.facade.bidding.vo;

import com.epc.web.facade.bidding.dto.SupplierSignDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 供应商报名列表
 * @Author: linzhixiang
 * @Date: 2018/10/11
 */ 
@Data
@ApiModel("供应商报名列表")
public class QuerySignUpListVO implements Serializable {
    private static final long serialVersionUID = 3819043116097548450L;
    @ApiModelProperty("标段Id")
    private Long bidsId;
    @ApiModelProperty("标段名称")
    private String bidsName;
    @ApiModelProperty("报名总数")
    private Integer count;
    @ApiModelProperty
    private List<SupplierSignDTO>  SupplierSignList;
}
