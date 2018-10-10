package com.epc.web.client.controller.agency.dto;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;
@Data
@ApiModel(value = "ClientAgencySupplierDto",description = "代理机构供货商查询条件和信息完善类")
public class ClientAgencySupplierDto implements Serializable {
    private static final long serialVersionUID = -1284782860769313490L;

    @ApiModelProperty(value = "供货商id")
    private Long supplierId;

    @ApiModelProperty(value = "代理机构id")
    @NotEmpty(message = "ClientAgencySupplierDto.agencyId.null")
    private Long agencyId;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "供货商手机")
    private String cellphone;


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
    @ApiModelProperty(value = "对公银行名")
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
    @ApiModelProperty(value = "附件信息:证书身份证等")
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
