package com.epc.administration.client.controller.biddingagency.handle;


import com.epc.administration.client.controller.supplier.handle.ClientAttachmentHandle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : luozhixin
 */
@Data
@ApiModel(value = "ClientBiddingAgencyDetailInfo", description = "运营商完善信息")
public class ClientBiddingAgencyDetailInfo implements Serializable {
    private static final long serialVersionUID = 4115083942872587425L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.id.null")
    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "公司地址")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.companyAddress.null")
    private String companyAddress;
    @ApiModelProperty(value = "省份")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.province.null")
    private String province;
    @ApiModelProperty(value = "市区")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.city.null")
    private String city;
    @ApiModelProperty(value = "区域")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.area.null")
    private String area;

    /**
     *统一信用代码
     */
    @ApiModelProperty(value = "统一信用代码")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.uniformCreditCode.null")
    private String uniformCreditCode;
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.businessLicense.null")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.legalIdCardOther.null")
    private String legalIdCardOther;
    /**
     *对公银行名称
     */
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.publicBankName.null")
    private String publicBankName;

    /**
     *对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;

    /**
     * 附件集合
     */
    @ApiModelProperty(value = "附件集合")
    @NotEmpty(message = "ClientBiddingAgencyDetailInfo.clientAttachmentHandles.null")
    private List<ClientAttachmentHandle> clientAttachmentHandles;


}
