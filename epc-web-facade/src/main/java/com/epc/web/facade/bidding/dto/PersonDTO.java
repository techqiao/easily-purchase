package com.epc.web.facade.bidding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 公司的人员信息
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1119946719598372004L;
    private String name;
    private String idCard;

}
