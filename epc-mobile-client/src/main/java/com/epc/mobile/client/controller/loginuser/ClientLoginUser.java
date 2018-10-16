package com.epc.mobile.client.controller.loginuser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ApiModel(value = "ClientLoginUser",description = "角色登录信息和返回")
public class ClientLoginUser implements Serializable {
    private static final long serialVersionUID = 2531337669656261886L;
    @ApiModelProperty(value = "角色名")
    private String name;
    @ApiModelProperty(value = "登录密码")
    @NotEmpty(message = "ClientLoginUser.password.null")
    private String password;
    @ApiModelProperty(value = "手机")
    @NotEmpty(message = "ClientLoginUser.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "机构类型运营商1,代理商2,供货商3,采购商4")
    private Integer type;
    @ApiModelProperty(value = "法人id")
//    private String bossId;
    private Long bossId;
    @ApiModelProperty(value = "法人姓名")
    private String bossName;
    @ApiModelProperty(value = "用户id")
//    private String selfId;
    private Long userId;
    @ApiModelProperty(value = "公司名")
    private String companyName;
    @ApiModelProperty(value = "公司id")
    private Long companyId;
    @ApiModelProperty(value = "公司内部角色")
    private Integer loginRole;

    public ClientLoginUser() {

    }
}
