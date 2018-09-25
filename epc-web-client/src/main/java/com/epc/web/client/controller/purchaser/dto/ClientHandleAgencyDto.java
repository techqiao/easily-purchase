package com.epc.web.client.controller.purchaser.dto;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
@ApiModel(value = "ClientHandleAgencyDto",description = "采购人代理机构和更新信息")
public class ClientHandleAgencyDto implements Serializable {
    private static final long serialVersionUID = -677472188453355486L;

    /**
     * 采购人的id
     */
    @ApiModelProperty(value = "采购人的id")
    private Long purchaseId;
    /**
     * 代理机构的id
     */
    @ApiModelProperty(value = "代理机构的id")
    private Long agencyId;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "电话")
    private String cellphone;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer state;
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
    @ApiModelProperty(value = "统一信用编码")
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    @ApiModelProperty(value = "对公银行name")
    private String publicBankName;
    /**
     * 对公银行账号
     */
    @ApiModelProperty(value = "对公账号")
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
    @ApiModelProperty(value = "附件 如身份证等")
    protected List<ClientAttachement> atts;

}
