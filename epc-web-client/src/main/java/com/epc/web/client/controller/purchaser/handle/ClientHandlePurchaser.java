package com.epc.web.client.controller.purchaser.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
* @Description:    运营商录入采购人
* @Author:          linzhixiang
* @CreateDate:     2018/9/13 10:00
* @UpdateUser:     linzhixiang
* @UpdateDate:     2018/9/13 10:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
@ApiModel(value = "ClientHandlePurchaser", description = "采购机构人员信息")
public class ClientHandlePurchaser implements Serializable {
    private static final long serialVersionUID = -2197056195533241604L;
    @ApiModelProperty(value = "采购人机构id")
    @NotEmpty(message = "ClientHandlePurchaser.purchaserId.null")
    private long purchaserId;
    @ApiModelProperty(value = "采购人姓名")
    @NotEmpty(message = "ClientHandlePurchaser.name.null")
    private String name;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientHandlePurchaser.name.null")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "用户角色")
    @NotEmpty(message = "ClientHandlePurchaser.role.null")
    private long role;

}
