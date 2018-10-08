package com.epc.web.client.controller.purchaser.dto;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "ClientPurchaserHandleSupplierDto",description = "新增供货商")
public class ClientPurchaserHandleSupplierDto implements Serializable {
    private static final long serialVersionUID = -7426910175250603166L;
    /**
     * 用于接受数据库生成的的id
     */
    @ApiModelProperty(value = "供货商id")
    private Long supplierId;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机")
    private String cellphone;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 法人姓名
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
    @ApiModelProperty(value = "对公银行")
    private String publicBankName;
    /**
     * 对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;

//    /**
//     * 操作人id
//     */
//    @ApiModelProperty(value = "操作人id")
//    private long OperatorId;
//    /**
//     * 操作人公司的id
//     */
//    @ApiModelProperty(value = "操作人公司id")
//    private long companyId;
    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    private String businessLicense;
    /**
     * 身份证正面
     */
    @ApiModelProperty(value = "身份证正面")
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    @ApiModelProperty(value = "身份证反面")
    private String legalIdCardOther;
    /**
     * 附件list
     */
    @ApiModelProperty(value = "附件")
    protected List<ClientAttachement> atts;
//    /**
//     * 来源
//     */
//    @ApiModelProperty(value = "客户来源")
//    private String source;
}
