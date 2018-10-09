package com.epc.tendering.service.service.project.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.GeneratorCodeUtil;
import com.epc.tendering.service.domain.project.TProjectBasicInfo;
import com.epc.tendering.service.domain.project.TProjectBasicInfoCriteria;
import com.epc.tendering.service.domain.purchaser.TProjectEmployeeRelation;
import com.epc.tendering.service.domain.purchaser.TProjectEmployeeRelationCriteria;
import com.epc.tendering.service.domain.purchaser.TProjectPurchaserEmployeeRelation;
import com.epc.tendering.service.domain.purchaser.TProjectPurchaserEmployeeRelationCriteria;
import com.epc.tendering.service.mapper.project.TProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchaser.TProjectEmployeeRelationMapper;
import com.epc.tendering.service.mapper.purchaser.TProjectPurchaserEmployeeRelationMapper;
import com.epc.tendering.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.tendering.service.service.project.TProjectBasicInfoService;
import com.epc.web.facade.terdering.project.handle.*;
import com.epc.web.facade.terdering.project.query.LoginInfo;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.epc.web.facade.terdering.project.vo.ProjectDetailInfoVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectListVO;
import com.epc.web.facade.terdering.project.vo.SelectProjectPurchaserListVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : 项目实现类
 * <p>Date : 2018-09-18 13:48
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TProjectBasicInfoServiceImpl implements TProjectBasicInfoService {

    private static final Logger LOGGER= LoggerFactory.getLogger(TProjectBasicInfoServiceImpl.class);

    @Autowired
    private TProjectBasicInfoMapper tProjectBasicInfoMapper;

    @Autowired  //项目人员关系表
    private TProjectEmployeeRelationMapper tProjectEmployeeRelationMapper;
    @Autowired  //采购项目人员关系表
    private TProjectPurchaserEmployeeRelationMapper tProjectPurchaserEmployeeRelationMapper;
    @Autowired
    private TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;

    @Override
    public Result<Boolean> handleProjectBasicInfo(HandleProjectBasicInfo handleProjectBasicInfo) {
        TProjectBasicInfo pojo = new TProjectBasicInfo();
        BeanUtils.copyProperties(handleProjectBasicInfo, pojo);
        try {
            if(pojo.getId() == null){
                pojo.setTotalProjectInvestment(new BigDecimal(handleProjectBasicInfo.getTotalProjectInvestment()));
                pojo.setProjectCode(GeneratorCodeUtil.GeneratorProjectCode());
                return Result.success(tProjectBasicInfoMapper.insertSelective(pojo) > 0);
            }else {
                return Result.success(tProjectBasicInfoMapper.updateByPrimaryKeySelective(pojo) > 0);
            }
        }catch (BusinessException e){
            return Result.error(ErrorMessagesEnum.FAILURE);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    /**0
     * 创建项目
     * 指定项目名
     * 指派项目经理(在项目人员指派关系表 t_project_employee_relation 插入一条数据)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createProjectByAdmin(HandleCreateProjectByAdmin handleCreateProjectByAdmin){
        Long loginId = handleCreateProjectByAdmin.getLoginId();
        Long bossId = handleCreateProjectByAdmin.getBossId();
        String name = handleCreateProjectByAdmin.getName();

        Integer loginRole = handleCreateProjectByAdmin.getLoginRole();

        if(loginRole.intValue()==Const.Role.ROLE_CUSTOMER){
            return Result.error("是员工肯定不行");
        }
        String projectName = handleCreateProjectByAdmin.getProjectName();
        Long executiveId = handleCreateProjectByAdmin.getExecutiveId();
        String executiveName = handleCreateProjectByAdmin.getExecutiveName();
        String notes = handleCreateProjectByAdmin.getNotes();
        if(StringUtils.isBlank(projectName) || executiveId==null || StringUtils.isBlank(executiveName)){
            return Result.error("前端传入参数异常");
        }
        //补全信息
        TProjectEmployeeRelation tProjectEmployeeRelation=new TProjectEmployeeRelation();
        tProjectEmployeeRelation.setProjectName(projectName);
        tProjectEmployeeRelation.setCreaterId(loginId);
        tProjectEmployeeRelation.setCreaterName(name);
        tProjectEmployeeRelation.setPurchaserId(bossId);
        tProjectEmployeeRelation.setExecutiveId(executiveId);
        tProjectEmployeeRelation.setExecutiveName(executiveName);
        tProjectEmployeeRelation.setCreateAt(new Date());
        tProjectEmployeeRelation.setUpdateAt(new Date());
        tProjectEmployeeRelation.setNotes(notes);

        try {
            return Result.success(tProjectEmployeeRelationMapper.insertSelective(tProjectEmployeeRelation) > 0);
        }catch (BusinessException e){
            LOGGER.error("[管理员或法人指派项目及项目经理] tProjectEmployeeRelationMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[管理员或法人指派项目及项目经理] tProjectEmployeeRelationMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**0.1
     *  删除一个项目
     *
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Result<Boolean> deleteProjectAdmin(HandleDeleteProjectAdmin handleDeleteProjectAdmin){
//        Integer loginRole = handleDeleteProjectAdmin.getLoginRole();
//        if(loginRole.intValue()==Const.Role.ROLE_CUSTOMER){
//            return Result.error("是员工没有权限");
//        }
//        Long projectId = handleDeleteProjectAdmin.getProjectId();
//        Integer isDeleted = handleDeleteProjectAdmin.getIsDeleted();
//        if(projectId==null || isDeleted==null){
//            return Result.error("前端传输参数异常");
//        }
//        /**
//         * 先用项目id去采购项目表中去看下，有没有在这个项目底下创建具体的采购项目,那么就必须先将这个采购项目删除在进行 项目的删除
//         */
//        TProjectPurchaserEmployeeRelationCriteria criteria=new TProjectPurchaserEmployeeRelationCriteria();
//        TProjectPurchaserEmployeeRelationCriteria.Criteria subCriteria = criteria.createCriteria();
//        subCriteria.andProjectIdEqualTo(projectId);
//        List<TProjectPurchaserEmployeeRelation> tProjectPurchaserEmployeeRelations = tProjectPurchaserEmployeeRelationMapper.selectByExample(criteria);
//        if(!CollectionUtils.isEmpty(tProjectPurchaserEmployeeRelations)){
//            return Result.success("此项目底下已经有具体实施的采购项目，请先删除底下的采购项目，在删除此项目");
//        }
//
//        TProjectEmployeeRelation tProjectEmployeeRelation = tProjectEmployeeRelationMapper.selectByPrimaryKey(projectId);
//        tProjectEmployeeRelation.setIsDeleted(isDeleted);
//        int i=0;
//        try{
//            i=tProjectEmployeeRelationMapper.updateByPrimaryKeySelective(tProjectEmployeeRelation);
//            return Result.success(i>0);
//        }catch (BusinessException e){
//            LOGGER.error("[管理员或法人删除一个项目] tProjectEmployeeRelationMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
//        }catch (Exception e){
//            LOGGER.error("[管理员或法人删除一个项目] tProjectEmployeeRelationMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return Result.error(e.getMessage());
//        }
//    }
    /**0.2
     *  修改项目
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateProjectAdmin(HandleUpdateProjectAdmin handleUpdateProjectAdmin){
        Integer loginRole = handleUpdateProjectAdmin.getLoginRole();
        if(loginRole.intValue()==Const.Role.ROLE_CUSTOMER){
            return Result.error("是员工没有权限");
        }
        Long projectId = handleUpdateProjectAdmin.getProjectId();
        String projectName = handleUpdateProjectAdmin.getProjectName();
        Long executiveId = handleUpdateProjectAdmin.getExecutiveId();
        String executiveName = handleUpdateProjectAdmin.getExecutiveName();
        String notes = handleUpdateProjectAdmin.getNotes();

        if(projectId==null){
            return Result.error("前端传输参数异常");
        }
        TProjectEmployeeRelation tProjectEmployeeRelation = tProjectEmployeeRelationMapper.selectByPrimaryKey(projectId);
        if(StringUtils.isNotBlank(projectName)){
            tProjectEmployeeRelation.setProjectName(projectName);
        }
        if(executiveId!=null){
            tProjectEmployeeRelation.setExecutiveId(executiveId);
        }
        if(StringUtils.isNotBlank(executiveName)){
            tProjectEmployeeRelation.setExecutiveName(executiveName);
        }
        if(StringUtils.isNotBlank(notes)){
            tProjectEmployeeRelation.setNotes(notes);
        }
        tProjectEmployeeRelation.setUpdateAt(new Date());
        int i=0;
        try{
            i=tProjectEmployeeRelationMapper.updateByPrimaryKeySelective(tProjectEmployeeRelation);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[管理员或法人修改一个项目] tProjectEmployeeRelationMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[管理员或法人修改一个项目] tProjectEmployeeRelationMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**0.3
     * 查看项目 列表
     *
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<SelectProjectListVO>> selectProjectList(LoginInfo loginInfo){
        Integer loginRole = loginInfo.getLoginRole();
        Long loginId = loginInfo.getLoginId();

        if(loginRole.intValue()==Const.Role.ROLE_CUSTOMER){
            return Result.error("是员工没有权限");
        }
        TProjectEmployeeRelationCriteria criteria=new TProjectEmployeeRelationCriteria();
        TProjectEmployeeRelationCriteria.Criteria subCriteria= criteria.createCriteria();
        subCriteria.andCreaterIdEqualTo(loginId);
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<TProjectEmployeeRelation> tProjectEmployeeRelations = tProjectEmployeeRelationMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tProjectEmployeeRelations)){
            return Result.success("你还没有创建项目");
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        List<SelectProjectListVO> listVOS=new ArrayList<SelectProjectListVO>();
        for(TProjectEmployeeRelation single:tProjectEmployeeRelations){
            SelectProjectListVO vo=new SelectProjectListVO();
            BeanUtils.copyProperties(single,vo);
            vo.setCreateAt(format.format(single.getCreateAt()));
            vo.setUpdateAt(format.format(single.getUpdateAt()));
            listVOS.add(vo);
        }
        return Result.success(listVOS);
    }







    @Override
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(Long projectId) {
        TProjectBasicInfo tProjectBasicInfo = tProjectBasicInfoMapper.selectByPrimaryKey(projectId);
        ProjectDetailInfoVO projectDetailInfoVO = new ProjectDetailInfoVO();
        if (tProjectBasicInfo==null){
            return Result.success(null);
        }
        BeanUtils.copyProperties(tProjectBasicInfo, projectDetailInfoVO);
        projectDetailInfoVO.setCompanyName(tPurchaserBasicInfoMapper.getCompanyNameByPurchaserId(tProjectBasicInfo.getPurchaserId()));
        return Result.success(projectDetailInfoVO);
    }

    @Override
    public Result<List<ProjectBasicInfoVO>> getProjectList(QueryProjectInfoDTO queryProjectInfoDTO) {
        final TProjectBasicInfoCriteria criteria = new TProjectBasicInfoCriteria();
        final TProjectBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //项目编码
        if(StringUtils.isNotBlank(queryProjectInfoDTO.getProjectCode())) {
            subCriteria.andProjectCodeEqualTo(queryProjectInfoDTO.getProjectCode());
        }
        //项目名称
        if(StringUtils.isNotBlank(queryProjectInfoDTO.getProjectName())) {
            subCriteria.andProjectNameEqualTo(queryProjectInfoDTO.getProjectName());
        }
        //采购人
        if(queryProjectInfoDTO.getPurchaserId() != null) {
            subCriteria.andPurchaserIdEqualTo(queryProjectInfoDTO.getPurchaserId());
        }
        criteria.setOrderByClause("id desc");
        List<TProjectBasicInfo> tProjectBasicInfoList = tProjectBasicInfoMapper.selectByExample(criteria);
        List<ProjectBasicInfoVO> returnList = new ArrayList<>();
        tProjectBasicInfoList.forEach(item -> {
            ProjectBasicInfoVO projectBasicInfoVO = new ProjectBasicInfoVO();
            BeanUtils.copyProperties(item, projectBasicInfoVO);
            projectBasicInfoVO.setName(item.getCreator());
            projectBasicInfoVO.setCompanyName(tPurchaserBasicInfoMapper.getCompanyNameByPurchaserId(item.getPurchaserId()));
            returnList.add(projectBasicInfoVO);
        });
        return Result.success(returnList);
    }
}
