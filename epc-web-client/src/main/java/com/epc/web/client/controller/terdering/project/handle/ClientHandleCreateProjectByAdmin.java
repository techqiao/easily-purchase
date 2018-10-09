package com.epc.web.client.controller.terdering.project.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientHandleCreateProjectByAdmin",description = "指派项目经理(在项目人员指派关系表 t_project_employee_relation 插入一条数据)")
@Data
public class ClientHandleCreateProjectByAdmin {

    @ApiModelProperty(value = "项目名字")
    private String projectName;

    @ApiModelProperty(value = "当前指派人id(管理员id或是法人id)")
    private Long executiveId;


    @ApiModelProperty(value = "创建项目人 姓名")
    private String executiveName;

    @ApiModelProperty(value = "备注")
    private String notes;



}
