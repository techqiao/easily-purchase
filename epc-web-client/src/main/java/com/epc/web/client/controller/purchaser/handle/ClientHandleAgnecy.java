package com.epc.web.client.controller.purchaser.handle;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "ClientHandleAgnecy", description = "录入代理机构")
@Data
public class ClientHandleAgnecy implements Serializable {
    private static final long serialVersionUID = -5543183867560975179L;
    /**
     * 代理机构id
     */
    private Long agencyId;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientHandleAgnecy.cellphone.null")
    private String cellphone;

    /**
     * 法人姓名
     */
    @ApiModelProperty(value = "法人姓名")
    @NotEmpty(message = "ClientHandleAgnecy.name.null")
    private String name;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司姓名")
    private String companyName;
    /**
     * 统一的信用代码
     */
    @ApiModelProperty(value = "统一信用编码")
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;
    /**
     * 对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;
    /**
     * 附件list
     */
    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "附件")
    private List<ClientAttachement> atts;
    /**
     * 公司地址
     */
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;

    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String area;
}
