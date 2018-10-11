package com.epc.web.client.controller.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * @author winlin
 */
@Data
@ApiModel(value = "ClientHandleSupplier",description = "新增供货商的信息")
public class ClientHandleSupplier implements Serializable{
    private static final long serialVersionUID = 171290314212527409L;
    @ApiModelProperty(value = "供货商姓名")
    @NotEmpty(message = "ClientHandleSupplier.name.null")
    private String name;

    @ApiModelProperty(value = "供货商电话")
    @NotEmpty(message = "ClientHandleSupplier.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "供货商公司名")
    private String companyName;

    @ApiModelProperty(value = "供货商信用证号")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行")
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
    @ApiModelProperty(value = "证件附件信息")
    private List<ClientAttachement> atts;
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String area;

}
