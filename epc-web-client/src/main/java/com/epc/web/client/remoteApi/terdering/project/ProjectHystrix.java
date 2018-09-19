package com.epc.web.client.remoteApi.terdering.project;

import com.epc.common.Result;
import com.epc.web.facade.terdering.project.FacadeTProjectBasicInfoService;
import com.epc.web.facade.terdering.project.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 14:15
 * <p>@Author : wjq
 */
public class ProjectHystrix implements FacadeTProjectBasicInfoService {
    @Override
    public Result<Boolean> handleProjectBasicInfo(HandleProjectBasicInfo handleProjectBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(Long projectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<ProjectBasicInfoVO>> getProjectList(QueryProjectInfoDTO queryProjectInfoDTO) {
        return Result.hystrixError();
    }

}
