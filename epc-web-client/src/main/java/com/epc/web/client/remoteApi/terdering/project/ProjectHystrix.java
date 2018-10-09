package com.epc.web.client.remoteApi.terdering.project;

import com.epc.common.Result;
import com.epc.web.facade.terdering.project.FacadeTProjectBasicInfoService;
import com.epc.web.facade.terdering.project.handle.*;
import com.epc.web.facade.terdering.project.query.LoginInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectListVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectPurchaserListVO;

import java.util.List;
import java.util.Map;

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
    public Result<Map<String, Object>> getProjectList(QueryProjectInfoDTO queryProjectInfoDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createProjectByAdmin(HandleCreateProjectByAdmin handleCreateProjectByAdmin) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updateProjectAdmin(HandleUpdateProjectAdmin handleUpdateProjectAdmin) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<SelectProjectListVO>> selectProjectList(LoginInfo loginInfo) {
        return Result.hystrixError();
    }

}
