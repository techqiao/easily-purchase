package com.epc.tendering.service.service;

import com.epc.common.Result;
import com.epc.web.facade.terdering.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.vo.ProjectDetailInfoVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description : 项目接口
 * <p>Date : 2018-09-18 13:43
 * <p>@Author : wjq
 */
public interface TProjectBasicInfoService {

    /**
     * 新增修改项目
     * @param handleProjectBasicInfo 项目相关参数
     * @return
     */
    Result<Boolean> handleProjectBasicInfo(HandleProjectBasicInfo handleProjectBasicInfo);


    /**
     * 获取项目详情
     * @param projectId
     * @return
     */
    Result<ProjectDetailInfoVO> getProjectDetailInfo(Long projectId);


    /**
     * 获取项目列表
     * @param queryProjectInfoDTO 查询项目类
     * @return
     */
    Result<List<ProjectBasicInfoVO>> getProjectList(QueryProjectInfoDTO queryProjectInfoDTO);
}
