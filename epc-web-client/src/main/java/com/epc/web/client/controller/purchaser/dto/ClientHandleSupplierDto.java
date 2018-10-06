package com.epc.web.client.controller.purchaser.dto;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "ClientHandleSupplierDto",description = "采购人完善供货商信息和供货商信息查询")
public class ClientHandleSupplierDto implements Serializable {
    private static final long serialVersionUID = -7953799077702459394L;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "供货商手机")
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
    @ApiModelProperty(value = "对公银行名")
    private String publicBankName;
    /**
     * 对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;
    /**
     * 公司地址
     */
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;
    /**
     * 附件list
     */
    @ApiModelProperty(value = "附件信息:证书身份证等")
    private List<ClientAttachement> atts;


}
