package com.epc.web.facade.bidding.vo;

import com.epc.web.facade.bidding.dto.OfflineDetailDTO;
import com.epc.web.facade.bidding.dto.OnlineDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @Description: 招标信息
 * @Author: linzhixiang
 * @Date: 2018/10/12
 */ 
@Data
@ApiModel("招标信息")
public class PretrialMessageDetailVO implements Serializable {
    private static final long serialVersionUID = 7622146275625130942L;
    @ApiModelProperty("线下信息")
    private OfflineDetailDTO offline;
    @ApiModelProperty("线上信息")
    private OnlineDetailDTO online;

}
