package com.epc.administration.client.controller.purchaser.handle;


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
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientPurchaserUserDetailInfo", description = "运营商完善信息")
public class ClientPurchaserUserDetailInfo implements Serializable {
    private static final long serialVersionUID = 5398443561517530647L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.id.null")
    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.companyName.null")
    private String companyName;

    /**
     *统一信用代码
     */
    @ApiModelProperty(value = "统一信用代码")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.uniformCreditCode.null")
    private String uniformCreditCode;

    /**
     *对公银行名称
     */
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.publicBankName.null")
    private String publicBankName;

    /**
     *对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;

    /**
     * 营业执照照片url
     */
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.businessLicense.null")
    private String businessLicense;
    /**
     * 法人身份证正面照片url
     */
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    /**
     * 法人身份证反面照片url
     */
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.legalIdCardOther.null")
    private String legalIdCardOther;

    /**
     * 附件集合
     */
    @ApiModelProperty(value = "资质证书附件集合")
    @NotEmpty(message = "ClientPurchaserUserDetailInfo.attachmentHandleList.null")
    private List<ClientAttachmentHandle> attachmentHandleList;
}
