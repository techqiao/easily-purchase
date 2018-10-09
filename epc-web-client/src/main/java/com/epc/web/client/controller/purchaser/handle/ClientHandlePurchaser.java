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
@ApiModel(value = "ClientHandleCreatePurchaserByOperator", description = "采购人员信息")
public class ClientHandlePurchaser implements Serializable {
    private static final long serialVersionUID = -2197056195533241604L;
//    /**
//     * 采购人机构id
//     */
//    @ApiModelProperty(value = "采购人机构id")
//    @NotEmpty(message = "ClientHandlePurchaser.purchaserId.null")
//    private long purchaserId;
    /**
     * 采购人员工姓名
     */
    @ApiModelProperty(value = "采购人姓名")
    @NotEmpty(message = "ClientHandlePurchaser.name.null")
    private String name;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    /**
     * 用户角色
     */
    @ApiModelProperty(value = "新增用户角色")
    private Integer role;

}
