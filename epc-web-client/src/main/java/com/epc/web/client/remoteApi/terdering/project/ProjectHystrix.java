package com.epc.web.client.remoteApi.terdering.project;

import com.epc.common.Result;
import com.epc.web.facade.terdering.FacadeTProjectBasicInfoService;
import com.epc.web.facade.terdering.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.vo.ProjectDetailInfoVO;

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
