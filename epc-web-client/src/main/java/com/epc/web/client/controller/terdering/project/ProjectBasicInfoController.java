package com.epc.web.client.controller.terdering.project;

import com.epc.common.Result;
import com.epc.web.client.controller.terdering.project.handle.ClientHandleProjectBasicInfo;
import com.epc.web.client.controller.terdering.project.query.ClientQueryProjectInfoDTO;
import com.epc.web.client.remoteApi.terdering.project.ProjectClient;
import com.epc.web.facade.terdering.project.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : 项目接口服务
 * <p>Date : 2018-09-18 14:03
 * <p>@Author : wjq
 */
@Api(value = "项目服务",tags = {"项目服务"})
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectBasicInfoController {

    @Autowired
    private ProjectClient projectClient;

    @ApiOperation(value = "新增|修改项目")
    @PostMapping(value="/handleProjectBasicInfo")
    public Result<Boolean> handleProjectBasicInfo(@RequestBody ClientHandleProjectBasicInfo clientHandleProjectBasicInfo){
        HandleProjectBasicInfo handleProjectBasicInfo = new HandleProjectBasicInfo();
        BeanUtils.copyProperties(clientHandleProjectBasicInfo, handleProjectBasicInfo);
        return projectClient.handleProjectBasicInfo(handleProjectBasicInfo);
    }

    @ApiOperation(value = "项目详情")
    @GetMapping(value="/getProjectDetailInfo")
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(@RequestParam Long projectId){
        return projectClient.getProjectDetailInfo(projectId);
    }

    @ApiOperation(value = "项目列表")
    @PostMapping(value="/getProjectList")
    public Result<List<ProjectBasicInfoVO>> getProjectList(@RequestBody ClientQueryProjectInfoDTO clientQueryProjectInfoDTO){
        QueryProjectInfoDTO queryProjectInfoDTO = new QueryProjectInfoDTO();
        BeanUtils.copyProperties(clientQueryProjectInfoDTO, queryProjectInfoDTO);
        return projectClient.getProjectList(queryProjectInfoDTO);
    }


}