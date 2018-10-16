package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 委托书
 * @Author: linzhixiang
 * @Date: 2018/10/15
 */
@Data
@ApiModel("委托书信息")
public class Entrust implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("金额")
    private BigDecimal money;
    @ApiModelProperty("工程质量目标")
    private String qualityTarget;
    @ApiModelProperty("工期")
    private Integer duration;
    @ApiModelProperty("投标有效期")
    private Integer validity;
    @ApiModelProperty("项目经理姓名")
    private String managerName;
    @ApiModelProperty("执业证书号码")
    private String certificateNumber;
}
