package com.epc.web.facade.terdering.project.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "ProjectEmployeeRelationVO2",description = "管理员查看项目列表")
@Data
public class ProjectEmployeeRelationVO2 {

    @ApiModelProperty(value = "当前项目的条目id")
    private Long id;

    @ApiModelProperty(value = "项目名字")
    private String projectName;

    @ApiModelProperty(value = "项目的发起人(姓名)")
    private String createrName;

    @ApiModelProperty(value = "执行人的id")
    private Long executiveId;

    @ApiModelProperty(value = "执行人的名字")
    private String executiveName;

    @ApiModelProperty(value = "创建时间")
    private String createAt;

    @ApiModelProperty(value = "采购项目")
    private List<ProjectPurchaserVO> listProjectPurchaser;



}
