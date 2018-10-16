package com.epc.mobile.facade.terdering.project;

import com.epc.common.Result;
import com.epc.mobile.facade.terdering.project.handle.HandleCreateProjectByAdmin;
import com.epc.mobile.facade.terdering.project.handle.HandleProjectBasicInfo;
import com.epc.mobile.facade.terdering.project.handle.HandleUpdateProjectAdmin;
import com.epc.mobile.facade.terdering.project.query.LoginInfo;
import com.epc.mobile.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.mobile.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.mobile.facade.terdering.project.vo.SelectProjectListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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
    @PostMapping(value = "getProjectDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<ProjectDetailInfoVO> getProjectDetailInfo(@RequestParam(value = "projectId") Long projectId);


    /**
     * 获取项目列表
     * @param queryProjectInfoDTO 动态条件查询项目类
     * @return
     */
    @PostMapping(value = "getProjectList", consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> getProjectList(@RequestBody QueryProjectInfoDTO queryProjectInfoDTO);


    /**0
     * 创建项目
     * 指定项目名
     * 指派项目经理(在项目人员指派关系表 t_project_employee_relation 插入一条数据)
     */
    @PostMapping(value = "createProjectByAdmin",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createProjectByAdmin(@RequestBody HandleCreateProjectByAdmin handleCreateProjectByAdmin);

    /**0.1
     *  删除一个项目
     *
     */
//    @PostMapping(value = "deleteProjectAdmin",consumes = "application/json; charset=UTF-8")
//    Result<Boolean> deleteProjectAdmin(@RequestBody HandleDeleteProjectAdmin handleDeleteProjectAdmin);

    /**0.2
     *  修改项目
     */
    @PostMapping(value = "updateProjectAdmin",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateProjectAdmin(@RequestBody HandleUpdateProjectAdmin handleUpdateProjectAdmin);

    /**0.3
     * 查看项目 列表
     *
     */
    @PostMapping(value = "selectProjectList",consumes = "application/json; charset=UTF-8")
    Result<List<SelectProjectListVO>> selectProjectList(@RequestBody LoginInfo loginInfo);



}
