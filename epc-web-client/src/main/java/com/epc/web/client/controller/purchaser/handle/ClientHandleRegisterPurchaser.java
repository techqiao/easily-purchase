package com.epc.web.client.controller.purchaser.handle;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "ClientHandleRegisterPurchaser",description = "完善采购人信息")
public class ClientHandleRegisterPurchaser implements Serializable {
    private static final long serialVersionUID = 2008007322700666033L;

    /**
     * 采购人id
     */
    @ApiModelProperty(value = "采购人id")
    @NotEmpty(message = "ClientHandleRegisterPurchaser.purchaseId.null")
    private Long purchaseId;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String cellphone;
//    /**
//     * 密码
//     */
//    @ApiModelProperty(value = "密码")
//    private String password;

    /**
     * 采购人法人姓名
     */
    @ApiModelProperty(value = "法人姓名")
    private String name;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 统一的信用代码
     */
    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    @ApiModelProperty(value = "对公银行名字")
    private String publicBankName;
    /**
     * 对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;

    /**
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private long OperatorId;
    /**
     * 公司地址
     */
    @ApiModelProperty(value="公司地址")
    private String companyAddress;
    /**
     * 附件list
     */
    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "附件list")
    protected List<ClientAttachement> atts;
}
