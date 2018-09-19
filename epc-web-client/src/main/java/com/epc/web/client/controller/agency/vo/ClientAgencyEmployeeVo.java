package com.epc.web.client.controller.agency.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
@ApiModel(value="AgencyEmployee",description = "机构员工返回")
public class ClientAgencyEmployeeVo implements Serializable{
    private static final long serialVersionUID = 4094362399011284663L;
    @ApiModelProperty(value = "人员id")
    private String userId;
    @ApiModelProperty(value = "人员姓名")
    private String userName;
    @ApiModelProperty(value = "人员手机")
    private String cellphone;
    @ApiModelProperty(value = "公司id")
    private String companyId;
    @ApiModelProperty(value = "老板名")
    private  String  bossName;
    @ApiModelProperty(value = "公司名")
    private String companyName;
}
