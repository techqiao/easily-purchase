package com.epc.web.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientHandleCreateProjectByAdmin",description = "指派项目负责人(在项目人员指派关系表 t_project_employee_relation 插入一条数据)")
@Data
public class ClientHandleCreateProjectByAdmin {

    @ApiModelProperty(value = "项目名字")
    private String projectName;

    @ApiModelProperty(value = "当前指派人id(管理员id或是法人id)")
    private Long createrId;

    @ApiModelProperty(value = "当前的角色 role(是法人还是管理员)")
    private Integer role;

    @ApiModelProperty(value = "创建项目人 姓名")
    private String createrName;


    @ApiModelProperty(value = "指派人的id(指派某个员工)")
    private Long executiveId;


}
