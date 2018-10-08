package com.epc.web.facade.terdering.project.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ProjectEmployeeRelationVO",description = "员工查看分配给自己的项目列表及其项目的一些基本信息")
@Data
public class ProjectEmployeeRelationVO {

    @ApiModelProperty(value = "当前项目的条目id")
    private Long id;

    @ApiModelProperty(value = "项目名字")
    private String projectName;

    @ApiModelProperty(value = "项目的发起人(姓名)")
    private String createrName;


    @ApiModelProperty(value = "创建时间")
    private String createAt;





}
