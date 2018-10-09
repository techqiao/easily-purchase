package com.epc.web.client.controller.agency.handle;


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
@ApiModel(value = "ClientHandleAgency" , description = "代理机构信息")
public class ClientHandleAgency implements Serializable {

    private static final long serialVersionUID = 3451904421494723626L;


    @ApiModelProperty(value = "代理机构的id")
    private  Long agencyId;
//    @ApiModelProperty(value = "代理商姓名")
//    private String name;

//    @ApiModelProperty(value = "密码")
//    private String password;
//
//    @ApiModelProperty(value = "电话")
//    private String cellphone;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBanAccountNumber;

    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "所有的附件")
    private List<ClientAttachement> atts;

}
