package com.epc.web.facade.agency.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/9/18
 */
@Data
@ApiModel(value = "HandleAgency" , description = "代理机构信息")
public class HandleAgency implements Serializable {

    @ApiModelProperty(value = "代理商姓名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String cellphone;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty
    private String publicBanAccountNumber;

    @ApiModelProperty(value = "所有的附件")
    private List<Attachement> atts;

}
