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
@ApiModel(value = "ClientRoleDetailInfo", description = "运营商完善信息")
public class ClientRoleDetailInfo  implements Serializable {
    private static final long serialVersionUID = 4115083942872587425L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键ID")
    @NotEmpty(message = "ClientRoleDetailInfo.id.null")
    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientRoleDetailInfo.companyName.null")
    private String companyName;

    /**
     *统一信用代码
     */
    @ApiModelProperty(value = "统一信用代码")
    @NotEmpty(message = "ClientRoleDetailInfo.uniformCreditCode.null")
    private String uniformCreditCode;

    /**
     *对公银行名称
     */
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientRoleDetailInfo.publicBankName.null")
    private String publicBankName;

    /**
     *对公银行账号
     */
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientRoleDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;

    /**
     * 附件集合
     */
    @ApiModelProperty(value = "附件集合")
    @NotEmpty(message = "ClientRoleDetailInfo.attachmentVOS.null")
    private List<ClientAttachmentHandle> clientAttachmentHandles;


}
