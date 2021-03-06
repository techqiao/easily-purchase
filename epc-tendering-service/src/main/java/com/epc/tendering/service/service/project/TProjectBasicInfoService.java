package com.epc.tendering.service.service.project;

import com.epc.common.Result;
import com.epc.web.facade.terdering.project.handle.*;
import com.epc.web.facade.terdering.project.query.LoginInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectListVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectPurchaserListVO;

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



    /**0
     * 创建项目
     * 指定项目名
     * 指派项目经理(在项目人员指派关系表 t_project_employee_relation 插入一条数据)
     */
    Result<Boolean> createProjectByAdmin(HandleCreateProjectByAdmin handleCreateProjectByAdmin);

    /**0.1
     *  删除一个项目
     *
     */
//    Result<Boolean> deleteProjectAdmin(HandleDeleteProjectAdmin handleDeleteProjectAdmin);

    /**0.2
     *  修改项目
     */
    Result<Boolean> updateProjectAdmin(HandleUpdateProjectAdmin handleUpdateProjectAdmin);

    /**0.3
     * 查看项目 列表
     *
     */
    Result<List<SelectProjectListVO>> selectProjectList(LoginInfo loginInfo);



    }
