package com.epc.administration.client.controller.supplier.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */

@Data
@ApiModel(value = "ClientSupplierDetailInfo", description = "运营商完善信息")
public class ClientSupplierDetailInfo implements Serializable {
    private static final long serialVersionUID = -2115939608760335030L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientSupplierDetailInfo.id.null")
    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientSupplierDetailInfo.companyName.null")
    private String companyName;

    @ApiModelProperty(value = "公司地址")
    @NotEmpty(message = "ClientSupplierDetailInfo.companyAddress.null")
    private String companyAddress;

    @ApiModelProperty(value = "省份")
    @NotEmpty(message = "ClientSupplierDetailInfo.province.null")
    private String province;
    @ApiModelProperty(value = "市区")
    @NotEmpty(message = "ClientSupplierDetailInfo.city.null")
    private String city;
    @ApiModelProperty(value = "区域")
    @NotEmpty(message = "ClientSupplierDetailInfo.area.null")
    private String area;
    /**
     *统一信用代码
     */
    @ApiModelProperty(value = "统一信用代码")
    @NotEmpty(message = "ClientSupplierDetailInfo.uniformCreditCode.null")
    private String uniformCreditCode;

    /**
     *对公银行名称
     */
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientSupplierDetailInfo.publicBankName.null")
    private String publicBankName;

    /**
     *对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientSupplierDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;

    /**
     * 营业执照照片url
     */
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "ClientSupplierDetailInfo.businessLicense.null")
    private String businessLicense;
    /**
     * 法人身份证正面照片url
     */
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientSupplierDetailInfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    /**
     * 法人身份证反面照片url
     */
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientSupplierDetailInfo.legalIdCardOther.null")
    private String legalIdCardOther;

    /**
     * 附件集合
     */
    @ApiModelProperty(value = "资质证书附件集合")
    @NotEmpty(message = "ClientSupplierDetailInfo.attachmentHandleList.null")
    private List<ClientAttachmentHandle> attachmentHandleList;
}
