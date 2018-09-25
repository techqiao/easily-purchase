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
    /**
     * supplierId供货商id
     */
    @ApiModelProperty(value = "供货商id")
    private Long supplierId;
    /**
     * 用于接受数据库生成的的机构id
     */

    @ApiModelProperty(value = "代理机构id")
    @NotEmpty(message = "ClientAgencySupplierDto.agencyId.null")
    private Long agencyId;
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
}
