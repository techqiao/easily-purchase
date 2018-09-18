package com.epc.tendering.service.controller;

import com.epc.common.Result;
import com.epc.tendering.service.service.TProjectBasicInfoService;
import com.epc.web.facade.terdering.FacadeTProjectBasicInfoService;
import com.epc.web.facade.terdering.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.vo.ProjectDetailInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 项目接口
 * <p>Date : 2018-09-18 13:42
 * <p>@Author : wjq
 */
@RestController
public class FacadeTProjectBasicInfoController implements FacadeTProjectBasicInfoService {

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
    public Result<List<ProjectBasicInfoVO>> getProjectList(@RequestBody QueryProjectInfoDTO queryProjectInfoDTO) {
        return tProjectBasicInfoService.getProjectList(queryProjectInfoDTO);
    }


}
