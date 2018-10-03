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
     * 采购人id
     */
    @ApiModelProperty(value = "采购人id")
    @NotEmpty(message = "ClientAgencySupplierDto.purcharseId.null")
    private Long purcharseId;
    /**
     * supplierId供货商id
     */
    @ApiModelProperty(value = "供货商id")
    private Long supplierId;
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
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private long OperatorId;
    /**
     * 操作人公司的id
     */
    @ApiModelProperty(value = "操作人公司id")
    private long companyId;
    /**
     * 附件list
     */
    @ApiModelProperty(value = "附件信息:证书身份证等")
    private List<ClientAttachement> atts;
    /**
     * 来源
     */
    @ApiModelProperty(value = "来源")
    private String source;
}
