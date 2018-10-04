package com.epc.tendering.service.controller.project;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.project.TProjectBasicInfoService;
import com.epc.web.facade.terdering.project.FacadeTProjectBasicInfoService;
import com.epc.web.facade.terdering.project.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * <p>Description : 项目接口
 * <p>Date : 2018-09-18 13:42
 * <p>@Author : wjq
 */
@RestController
public class TProjectBasicInfoController extends BaseController implements FacadeTProjectBasicInfoService {

    @Autowired
    private TProjectBasicInfoService tProjectBasicInfoService;

    @Override
    public Result<Boolean> handleProjectBasicInfo(@RequestBody HandleProjectBasicInfo handleProjectBasicInfo) {
        return tProjectBasicInfoService.handleProjectBasicInfo(handleProjectBasicInfo);
    }

    @Override
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(@RequestParam Long projectId) {
        return tProjectBasicInfoService.getProjectDetailInfo(projectId);
    }

    @Override
    public Result<Map<String, Object>> getProjectList(@RequestBody QueryProjectInfoDTO queryProjectInfoDTO) {
        PageHelper.startPage(queryProjectInfoDTO.getPage(),queryProjectInfoDTO.getRows());
        Result<List<ProjectBasicInfoVO>> projectList = tProjectBasicInfoService.getProjectList(queryProjectInfoDTO);
        PageInfo<ProjectBasicInfoVO> pageInfo = new PageInfo<>(projectList.getData());
        return Result.success(getDataTable(pageInfo));
    }

}
