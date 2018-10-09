package com.epc.web.client.controller.terdering.project;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.project.handle.*;
import com.epc.web.client.controller.terdering.project.query.ClientQueryProjectInfoDTO;
import com.epc.web.client.remoteApi.terdering.project.ProjectClient;
import com.epc.web.facade.terdering.project.handle.*;
import com.epc.web.facade.terdering.project.query.LoginInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectListVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectPurchaserListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : 项目接口服务
 * <p>Date : 2018-09-18 14:03
 * <p>@Author : wjq
 */
@Api(value = "项目服务",tags = {"项目服务"})
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectBasicInfoController extends BaseController {

    @Autowired
    private ProjectClient projectClient;

    /**
     * 是否国家项目 是否必须招标 是采购项目属性，当前创建项目已忽略
     * @param clientHandleProjectBasicInfo
     * @return
     */
    @ApiOperation(value = "新增|修改项目")
    @PostMapping(value="/handleProjectBasicInfo")
    public Result<Boolean> handleProjectBasicInfo(@RequestBody ClientHandleProjectBasicInfo clientHandleProjectBasicInfo){
        HandleProjectBasicInfo handleProjectBasicInfo = new HandleProjectBasicInfo();
        BeanUtils.copyProperties(clientHandleProjectBasicInfo, handleProjectBasicInfo);
        handleProjectBasicInfo.setPurchaserId(getLoginUser().getUserId());
        handleProjectBasicInfo.setOperateId(getLoginUser().getUserId());
        handleProjectBasicInfo.setCreator(getLoginUser().getName());
        return projectClient.handleProjectBasicInfo(handleProjectBasicInfo);
    }

    @ApiOperation(value = "项目详情")
    @GetMapping(value="/getProjectDetailInfo")
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(@RequestParam Long projectId){
        return projectClient.getProjectDetailInfo(projectId);
    }

    @ApiOperation(value = "项目列表")
    @PostMapping(value="/getProjectList")
    public Result<Map<String, Object>> getProjectList(@RequestBody ClientQueryProjectInfoDTO clientQueryProjectInfoDTO){
        QueryProjectInfoDTO queryProjectInfoDTO = new QueryProjectInfoDTO();
        BeanUtils.copyProperties(clientQueryProjectInfoDTO, queryProjectInfoDTO);
        queryProjectInfoDTO.setPurchaserId(getLoginUser().getUserId());
        return projectClient.getProjectList(queryProjectInfoDTO);
    }


    /**0
     * 创建项目
     * 指定项目名
     * 指派项目经理(在项目人员指派关系表 t_project_employee_relation 插入一条数据)
     */
    @ApiOperation(value = "项目列表")
    @PostMapping(value="/createProjectByAdmin")
    public Result<Boolean> createProjectByAdmin(@RequestBody ClientHandleCreateProjectByAdmin clientHandleCreateProjectByAdmin){
        HandleCreateProjectByAdmin handleCreateProjectByAdmin=new HandleCreateProjectByAdmin();
        BeanUtils.copyProperties(clientHandleCreateProjectByAdmin,handleCreateProjectByAdmin);
        Integer loginRole = getLoginUser().getLoginRole();
        Long bossId = getLoginUser().getBossId();
        String name = getLoginUser().getName();
        Long userId = getLoginUser().getUserId();
        if(loginRole==null || bossId==null || StringUtils.isBlank(name) || userId==null){
            return Result.error("从redis中取出异常");
        }
        handleCreateProjectByAdmin.setLoginRole(loginRole);
        handleCreateProjectByAdmin.setBossId(bossId);
        handleCreateProjectByAdmin.setName(name);
        handleCreateProjectByAdmin.setLoginId(userId);
        return projectClient.createProjectByAdmin(handleCreateProjectByAdmin);
    }

    /**0.1
     *  删除一个项目
     *
     */
    @ApiOperation(value = "删除一个项目")
    @PostMapping(value = "/deleteProjectAdmin")
    public Result<Boolean> deleteProjectAdmin(@RequestBody ClientHandleDeleteProjectAdmin clientHandleDeleteProjectAdmin){
        HandleDeleteProjectAdmin handleDeleteProjectAdmin=new HandleDeleteProjectAdmin();
        BeanUtils.copyProperties(clientHandleDeleteProjectAdmin,handleDeleteProjectAdmin);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中取出异常");
        }
        handleDeleteProjectAdmin.setLoginRole(loginRole);
        return projectClient.deleteProjectAdmin(handleDeleteProjectAdmin);
    }

    /**0.2
     *  修改项目
     */
    @ApiOperation(value = "修改项目")
    @PostMapping(value = "/updateProjectAdmin")
    public Result<Boolean> updateProjectAdmin(@RequestBody ClientHandleUpdateProjectAdmin clientHandleUpdateProjectAdmin){
        HandleUpdateProjectAdmin handleUpdateProjectAdmin=new HandleUpdateProjectAdmin();
        BeanUtils.copyProperties(clientHandleUpdateProjectAdmin,handleUpdateProjectAdmin);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中取出异常");
        }
        handleUpdateProjectAdmin.setLoginRole(loginRole);
        return projectClient.updateProjectAdmin(handleUpdateProjectAdmin);
    }

    /**0.3
     * 查看项目 列表
     *
     */
    @ApiOperation(value = "查看项目 列表")
    @PostMapping(value = "/selectProjectList")
    public Result<List<SelectProjectListVO>> selectProjectList(){
        Integer loginRole = getLoginUser().getLoginRole();
        Long userId = getLoginUser().getUserId();
        if(loginRole==null || userId==null){
            return Result.error("从redis中取出异常");
        }
        LoginInfo loginInfo=new LoginInfo();
        loginInfo.setLoginRole(loginRole);
        loginInfo.setLoginId(userId);
        return projectClient.selectProjectList(loginInfo);
    }

    /**1
     * 在已经存在的项目底下创建采购项目，指定采购项目名称，并指派经办人，批复人，审核人
     *      指派采购项目负责人(在项目人员指派关系表 t_project_employee_relation 插入一条数据,将状态改成 1进行中)
     */
    @ApiOperation(value = "新建采购项目")
    @PostMapping(value = "/createProjectPurchaserByAdmin")
    public Result<Boolean> createProjectPurchaserByAdmin(@RequestBody ClientHandleCreateProjectPurchaserByAdmin clientHandleCreateProjectPurchaserByAdmin){
        HandleCreateProjectPurchaserByAdmin handleCreateProjectPurchaserByAdmin=new HandleCreateProjectPurchaserByAdmin();
        BeanUtils.copyProperties(clientHandleCreateProjectPurchaserByAdmin,handleCreateProjectPurchaserByAdmin);
        Long userId = getLoginUser().getUserId();
        Long bossId = getLoginUser().getBossId();
        if(userId==null || bossId==null){
            return Result.error("从redis中取出异常");
        }
        handleCreateProjectPurchaserByAdmin.setLoginId(userId);
        handleCreateProjectPurchaserByAdmin.setBossId(bossId);
        return projectClient.createProjectPurchaserByAdmin(handleCreateProjectPurchaserByAdmin);
    }

    /**1.1
     * 获取 自己创建的采购项目 列表
     *
     */
    @ApiOperation(value = "获取 自己创建的采购项目 列表")
    @PostMapping(value = "/selectProjectPurchaserList")
    public Result<List<SelectProjectPurchaserListVO>> selectProjectPurchaserList(@RequestBody ClientHandleSelectProjectPurchaserList clientHandleSelectProjectPurchaserList){
        HandleSelectProjectPurchaserList handleSelectProjectPurchaserList=new HandleSelectProjectPurchaserList();
        BeanUtils.copyProperties(clientHandleSelectProjectPurchaserList,handleSelectProjectPurchaserList);
        Long userId = getLoginUser().getUserId();
        if(userId==null){
            return Result.error("从redis中取出异常");
        }
        handleSelectProjectPurchaserList.setLoginId(userId);
        return projectClient.selectProjectPurchaserList(handleSelectProjectPurchaserList);
    }

    /**1.2
     * 删除采购项目
     */
    @ApiOperation(value = "删除采购项目")
    @PostMapping(value = "/deleteProjectPurchaser")
    public Result<Boolean> deleteProjectPurchaser(@RequestBody ClientHandleDeleteProjectPurchaser clientHandleDeleteProjectPurchaser){
        HandleDeleteProjectPurchaser handleDeleteProjectPurchaser=new HandleDeleteProjectPurchaser();
        BeanUtils.copyProperties(clientHandleDeleteProjectPurchaser,handleDeleteProjectPurchaser);
        return projectClient.deleteProjectPurchaser(handleDeleteProjectPurchaser);
    }

    /**1.3
     * 修改采购项目
     *
     */
    @ApiOperation(value = "修改采购项目")
    @PostMapping(value = "/updateProjectPurchaser")
    public Result<Boolean> updateProjectPurchaser(@RequestBody ClientHandleUpdateProjectPurchaser clientHandleUpdateProjectPurchaser){
        HandleUpdateProjectPurchaser handleUpdateProjectPurchaser=new HandleUpdateProjectPurchaser();
        BeanUtils.copyProperties(clientHandleUpdateProjectPurchaser,handleUpdateProjectPurchaser);
        return projectClient.updateProjectPurchaser(handleUpdateProjectPurchaser);
    }


}
