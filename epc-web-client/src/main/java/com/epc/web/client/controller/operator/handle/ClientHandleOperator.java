package com.epc.web.client.controller.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


/**
 * @Description:    运营商信息录入
 * @Author:         linzhixiang
 * @CreateDate:     2018/9/13 9:56
 * @UpdateUser:     linzhixiang
 * @UpdateDate:     2018/9/13 9:56
 * @UpdateRemark:  修改内容
 * @Version:        1.0
 */

@ApiModel(value = "ClientHandleOperator", description = "运营商人员信息")
@Data
public class ClientHandleOperator  {

    @ApiModelProperty(value = "员工id")
    private Long id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientHandleOperator.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "ClientHandleOperator.passWord.null")
    private String password;

}
