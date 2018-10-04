package com.epc.web.facade.terdering.project;

import com.epc.common.Result;
import com.epc.web.facade.terdering.project.handle.HandleProjectBasicInfo;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>Description : 项目接口
 * <p>Date : 2018-09-18 13:52
 * <p>@Author : wjq
 */
public interface FacadeTProjectBasicInfoService {

    /**
     * 新增修改项目
     * @param handleProjectBasicInfo 项目相关参数
     * @return
     */
    @PostMapping(value = "handleProjectBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleProjectBasicInfo(@RequestBody HandleProjectBasicInfo handleProjectBasicInfo);


    /**
     * 获取项目详情
     * @param projectId
     * @return
     */
    @GetMapping(value = "getProjectDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<ProjectDetailInfoVO> getProjectDetailInfo(@RequestParam(value = "projectId") Long projectId);


    /**
     * 获取项目列表
     * @param queryProjectInfoDTO 动态条件查询项目类
     * @return
     */
    @PostMapping(value = "getProjectList", consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> getProjectList(@RequestBody QueryProjectInfoDTO queryProjectInfoDTO);


}
