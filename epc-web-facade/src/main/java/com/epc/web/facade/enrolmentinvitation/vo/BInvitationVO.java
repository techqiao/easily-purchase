package com.epc.web.facade.enrolmentinvitation.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("邀请信息")
public class BInvitationVO implements Serializable {

    private static final long serialVersionUID = 5704214442842529916L;
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("标段名称")
    private String bidsName;

    @ApiModelProperty("采购人名称")
    private String purchaserName;

    @ApiModelProperty("采购项目名称")
    private String procurementProjectName;

    @ApiModelProperty("邀请内容")
    private String context;

    @ApiModelProperty("时间")
    private String createAt;

}
