package com.epc.web.facade.terdering.project;

import com.epc.common.Result;
import com.epc.web.facade.terdering.project.handle.*;
import com.epc.web.facade.terdering.project.query.LoginInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectListVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectPurchaserListVO;
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
    @PostMapping(value = "deleteProjectAdmin",consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteProjectAdmin(@RequestBody HandleDeleteProjectAdmin handleDeleteProjectAdmin);

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

    /**1
     * 在已经存在的项目底下创建采购项目，指定采购项目名称，并指派经办人，批复人，审核人
     *      指派采购项目负责人(在项目人员指派关系表 t_project_employee_relation 插入一条数据,将状态改成 1进行中)
     */
    @PostMapping(value = "createProjectPurchaserByAdmin",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createProjectPurchaserByAdmin(@RequestBody HandleCreateProjectPurchaserByAdmin handleCreateProjectPurchaserByAdmin);

    /**1.1
     * 获取 自己创建的采购项目 列表
     *
     */
    @PostMapping(value = "selectProjectPurchaserList",consumes = "application/json; charset=UTF-8")
    Result<List<SelectProjectPurchaserListVO>> selectProjectPurchaserList(@RequestBody HandleSelectProjectPurchaserList handleSelectProjectPurchaserList);

    /**1.2
     * 删除采购项目
     */
    @PostMapping(value = "deleteProjectPurchaser",consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteProjectPurchaser(@RequestBody HandleDeleteProjectPurchaser handleDeleteProjectPurchaser);

    /**1.3
     * 修改采购项目
     *
     */
    @PostMapping(value = "updateProjectPurchaser",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateProjectPurchaser(@RequestBody HandleUpdateProjectPurchaser handleUpdateProjectPurchaser);


}
