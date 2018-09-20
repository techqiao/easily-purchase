package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
@ApiModel(value = "ClientHandleOperatorAddEmployee",description = "运营商增加员工")
public class ClientHandleOperatorAddEmployee {

    @ApiModelProperty(value = "要添加的员工名字")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.name.null")
    private String name;

    @ApiModelProperty(value = "要添加的员工电话")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "要添加的员工的密码")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.password.null")
    private String password;

    @ApiModelProperty(value = "创建的时间")
    @NotEmpty(message = "ClientHandleOperatorAddEmployee.createAt.null")
    private Date createAt;

    @ApiModelProperty(value = "修改的时间")
    private Date updateAt;

    @ApiModelProperty(value = "用户的角色，0-法人,1-管理员,2-普通员工")
    private Integer role;

    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "运营商id")
    private Long operatorId;

    @ApiModelProperty(value = "员工的审核状态，0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败")
    private Integer state;

}
