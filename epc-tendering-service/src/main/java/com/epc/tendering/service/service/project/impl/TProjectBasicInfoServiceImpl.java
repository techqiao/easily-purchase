package com.epc.tendering.service.service.project.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.GeneratorCodeUtil;
import com.epc.tendering.service.domain.project.TProjectBasicInfo;
import com.epc.tendering.service.domain.project.TProjectBasicInfoCriteria;
import com.epc.tendering.service.domain.purchaser.*;
import com.epc.tendering.service.mapper.project.TProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchaser.TProjectEmployeeRelationMapper;
import com.epc.tendering.service.mapper.purchaser.TProjectPurchaserEmployeeRelationMapper;
import com.epc.tendering.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.tendering.service.service.project.TProjectBasicInfoService;
import com.epc.web.facade.terdering.project.handle.*;
import com.epc.web.facade.terdering.project.query.QueryPurchaserEmployeeIdAndRole;
import com.epc.web.facade.terdering.project.query.QueryProjectInfoDTO;
import com.epc.web.facade.terdering.project.vo.*;
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
    @Autowired  //采购人基本表
    private TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;

    @Override
    public Result<Boolean> handleProjectBasicInfo(HandleProjectBasicInfo handleProjectBasicInfo) {
        TProjectBasicInfo pojo = new TProjectBasicInfo();
        BeanUtils.copyProperties(handleProjectBasicInfo, pojo);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setCreateAt(new Date());
        pojo.setUpdateAt(new Date());
        try {
            if(pojo.getId() == null){
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

    /**
     * 创建项目
     * 指定项目名
     * 指派项目负责人(在项目人员指派关系表 t_project_employee_relation 插入一条数据)
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createProjectByAdmin(HandleCreateProjectByAdmin handleCreateProjectByAdmin){
        //当前指派人id(管理员id或是法人id) 当前登陆人的id（角色是法人或者管理员）
        Long createrId = handleCreateProjectByAdmin.getCreaterId();
        //创建项目人 姓名  当前登陆人的姓名
        String createrName = handleCreateProjectByAdmin.getCreaterName();

        //当前的角色 role(是法人还是管理员)
        Integer role = handleCreateProjectByAdmin.getRole();
        //项目名字
        String projectName = handleCreateProjectByAdmin.getProjectName();

        //指派人的id(指派某个员工)这个员工必须是这个 当前指派人id 的 法人 下的 员工
        Long executiveId = handleCreateProjectByAdmin.getExecutiveId();
        //指派 人的姓名
        String executiveName = handleCreateProjectByAdmin.getExecutiveName();

        if(createrId==null || role==null || StringUtils.isBlank(projectName) || StringUtils.isBlank(createrName) || executiveId==null){
            return Result.error("[管理员指派项目负责人] createrId==null || role==null || StringUtils.isBlank(projectName) || StringUtils.isBlank(createrName) || executiveId==null {参数异常}");
        }
        if(role.intValue()==Const.Role.ROLE_CUSTOMER){  //是员工
            return Result.error("role类型不是管理员或者法人，不能指派项目负责人");
        }

        //先查询采购人basic表中的法人id
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByPrimaryKey(createrId);
        Long purchaserId = tPurchaserBasicInfo.getPurchaserId();

        //将数据插入到  在项目人员指派关系表 中
        TProjectEmployeeRelation tProjectEmployeeRelation=new TProjectEmployeeRelation();
        tProjectEmployeeRelation.setProjectName(projectName);
        tProjectEmployeeRelation.setCreaterId(createrId);
        tProjectEmployeeRelation.setCreaterName(createrName);
        tProjectEmployeeRelation.setPurchaserId(purchaserId);
        tProjectEmployeeRelation.setExecutiveName(executiveName);
        tProjectEmployeeRelation.setExecutiveId(executiveId);
        tProjectEmployeeRelation.setCreateAt(new Date());
        tProjectEmployeeRelation.setUpdateAt(new Date());

        try {
            return Result.success(tProjectEmployeeRelationMapper.insertSelective(tProjectEmployeeRelation) > 0);
        }catch (BusinessException e){
            LOGGER.error("[管理员指派项目负责人] tProjectEmployeeRelationMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[管理员指派项目负责人] tProjectEmployeeRelationMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**在已经存在的项目底下创建采购项目
     * 创建采购项目
     *      指定采购项目名
     *      指派采购项目负责人(在项目人员指派关系表 t_project_employee_relation 插入一条数据)
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createProjectPurchaserByAdmin(HandleCreateProjectPurchaserByAdmin handleCreateProjectPurchaserByAdmin){
        //这个 采购项目所属于哪个项目下面的子项目
        Long projectId = handleCreateProjectPurchaserByAdmin.getProjectId();
        //当前 创建人的id（当前登陆人的id）
        Long createrId = handleCreateProjectPurchaserByAdmin.getCreaterId();
        // 当前 创建人的姓名 （当前 登陆人的姓名）
        String createrName = handleCreateProjectPurchaserByAdmin.getCreaterName();
        //  当前 你创建的这个采购项目的 名字
        String projectPurchaserName = handleCreateProjectPurchaserByAdmin.getProjectPurchaserName();
        //  指定执行人的id （法人所下的员工）
        Long executiveId = handleCreateProjectPurchaserByAdmin.getExecutiveId();
        String executiveName = handleCreateProjectPurchaserByAdmin.getExecutiveName();
        //  当前 登陆人的角色
        Integer role = handleCreateProjectPurchaserByAdmin.getRole();

        if(projectId==null || createrId==null || createrName==null || StringUtils.isBlank(projectPurchaserName) || executiveId==null || role==null){
            return Result.error("[创建采购项目] projectId==null || createrId==null || createrName==null || StringUtils.isBlank(projectPurchaserName) || executiveId==null || role==null : {参数异常}");
        }
        if(role.intValue()==Const.Role.ROLE_CUSTOMER){  //是员工
            return Result.error("你的角色权限不够");
        }

        //依据当前 登陆人的id来查出 法人id
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByPrimaryKey(createrId);
        Long purchaserId = tPurchaserBasicInfo.getPurchaserId();

        //  将得到的信息插入到 采购 人员 关系表中
        TProjectPurchaserEmployeeRelation tProjectPurchaserEmployeeRelation=new TProjectPurchaserEmployeeRelation();
        tProjectPurchaserEmployeeRelation.setProjectId(projectId);
        tProjectPurchaserEmployeeRelation.setProjectPurchaserName(projectPurchaserName);
        tProjectPurchaserEmployeeRelation.setCreaterId(createrId);
        tProjectPurchaserEmployeeRelation.setCreaterName(createrName);
        tProjectPurchaserEmployeeRelation.setPurchaserId(purchaserId);
        tProjectPurchaserEmployeeRelation.setExecutiveId(executiveId);
        tProjectPurchaserEmployeeRelation.setExecutiveName(executiveName);
        tProjectPurchaserEmployeeRelation.setCreateAt(new Date());
        tProjectPurchaserEmployeeRelation.setUpdateAt(new Date());

        try{
            return Result.success(tProjectPurchaserEmployeeRelationMapper.insertSelective(tProjectPurchaserEmployeeRelation)>0);
        }catch (BusinessException e){
            LOGGER.error("[创建采购项目及指定负责人] tProjectPurchaserEmployeeRelationMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[创建采购项目及指定负责人] tProjectPurchaserEmployeeRelationMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**
     *  只查询 这个员工下的项目列表
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<List<ProjectEmployeeRelationVO>> getProjectListById(QueryPurchaserEmployeeIdAndRole queryPurchaserEmployeeIdAndRole){
        /**
         * 拿到自己当前登陆的一些信息
         */
        Long id = queryPurchaserEmployeeIdAndRole.getId();
        Integer role = queryPurchaserEmployeeIdAndRole.getRole();
        if(id==null || role==null){
            return Result.error("[查询 这个员工下的项目，列表] id==null || role==null : {参数异常}");
        }
        if(role.intValue()!=Const.Role.ROLE_CUSTOMER){  //如果你不是员工
            // 不是员工
            return Result.error("角色不匹配");
        }

        //查询 项目
        TProjectEmployeeRelationCriteria criteria=new TProjectEmployeeRelationCriteria();
        TProjectEmployeeRelationCriteria.Criteria subCriteria = criteria.createCriteria();

        subCriteria.andExecutiveIdEqualTo(id);

        List<TProjectEmployeeRelation> tProjectEmployeeRelations = tProjectEmployeeRelationMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tProjectEmployeeRelations)){
            return Result.success("你没有被指定项目");
        }
        //  证明这个员工有被管理人指定项目
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        //将数据 复制到返回类中
        List<ProjectEmployeeRelationVO> listVO=new ArrayList<ProjectEmployeeRelationVO>();
        for (TProjectEmployeeRelation single:tProjectEmployeeRelations) {
            ProjectEmployeeRelationVO vo=new ProjectEmployeeRelationVO();
            BeanUtils.copyProperties(single,vo);
            vo.setCreateAt(format.format(single.getCreateAt()));
            listVO.add(vo);
        }
        return Result.success(listVO);
    }
    /**
     *  只查询 这个员工下的采购项目列表
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<List<ProjectEmployeeRelationVO>> getProjectPurchaserListByEmployeeId(QueryPurchaserEmployeeIdAndRole queryPurchaserEmployeeIdAndRole){
        /**
         * 拿到自己当前登陆的一些信息
         */
        Long id = queryPurchaserEmployeeIdAndRole.getId();
        Integer role = queryPurchaserEmployeeIdAndRole.getRole();
        if(id==null || role==null){
            return Result.error("[查询 这个员工下的项目，列表] id==null || role==null : {参数异常}");
        }
        if(role.intValue()!=Const.Role.ROLE_CUSTOMER){  //如果你不是员工
            // 不是员工
            return Result.error("角色不匹配");
        }
        //查询 采购项目
        TProjectPurchaserEmployeeRelationCriteria criteria=new TProjectPurchaserEmployeeRelationCriteria();
        TProjectPurchaserEmployeeRelationCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andExecutiveIdEqualTo(id);
        List<TProjectPurchaserEmployeeRelation> tProjectPurchaserEmployeeRelations = tProjectPurchaserEmployeeRelationMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tProjectPurchaserEmployeeRelations)){
            return Result.success("没有查询到有被指派的采购项目");
        }
        List<ProjectEmployeeRelationVO> listVO=new ArrayList<ProjectEmployeeRelationVO>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        for(TProjectPurchaserEmployeeRelation single:tProjectPurchaserEmployeeRelations){
            ProjectEmployeeRelationVO vo=new ProjectEmployeeRelationVO();
            BeanUtils.copyProperties(single,vo);
            vo.setProjectName(single.getProjectPurchaserName());
            vo.setCreateAt(format.format(single.getCreateAt()));
            listVO.add(vo);
        }
        return  Result.success(listVO);
    }
    /**3
     * 管理员或者法人 查询所有的项目及其下面所有的采购项目列表
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<List<ProjectEmployeeRelationVO2>> getProjectPurchaserListById(QueryPurchaserEmployeeIdAndRole queryPurchaserEmployeeIdAndRole){
        /**
         * 拿到自己当前登陆的一些信息
         */
        Long id = queryPurchaserEmployeeIdAndRole.getId();
        Integer role = queryPurchaserEmployeeIdAndRole.getRole();
        if(id==null || role==null){
            return Result.error("[查询 这个员工下的项目，列表] id==null || role==null : {参数异常}");
        }
        if(role.intValue()==Const.Role.ROLE_CUSTOMER){
            // 是员工，
            return Result.error("角色不匹配");
        }
        //先拿到自己底下创建所有的项目，在通过项目的id来拿到这个项目id下面对应的采购项目
        TProjectEmployeeRelationCriteria criteria=new TProjectEmployeeRelationCriteria();
        TProjectEmployeeRelationCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCreaterIdEqualTo(id);
        List<TProjectEmployeeRelation> tProjectEmployeeRelations = tProjectEmployeeRelationMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tProjectEmployeeRelations)){
            return Result.success("您还没有创建项目");
        }

        List<ProjectEmployeeRelationVO2> listVO=new ArrayList<ProjectEmployeeRelationVO2>();

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        //拿到所有的已经创建的项目
        for(TProjectEmployeeRelation single:tProjectEmployeeRelations){
            ProjectEmployeeRelationVO2 vo2=new ProjectEmployeeRelationVO2();
            BeanUtils.copyProperties(single,vo2);
            vo2.setCreateAt(format.format(single.getCreateAt()));
            listVO.add(vo2);
        }
        TProjectPurchaserEmployeeRelationCriteria criteria1=new TProjectPurchaserEmployeeRelationCriteria();
        TProjectPurchaserEmployeeRelationCriteria.Criteria criteria2 = criteria1.createCriteria();
        //拿到所有的采购项目
        for(ProjectEmployeeRelationVO2 vo:listVO){
            Long id1 = vo.getId();
            List<ProjectPurchaserVO> listProjectPurchaser = vo.getListProjectPurchaser();
            criteria2.andProjectIdEqualTo(id1);
            criteria2.andCreaterIdEqualTo(id);
            List<TProjectPurchaserEmployeeRelation> tProjectPurchaserEmployeeRelations = tProjectPurchaserEmployeeRelationMapper.selectByExample(criteria1);
            BeanUtils.copyProperties(tProjectPurchaserEmployeeRelations,listProjectPurchaser);
            vo.setListProjectPurchaser(listProjectPurchaser);
        }
        return Result.success(listVO);
    }
    /**(重复)
     * 这个登陆人必须是管理员 或者 法人（反正是创建这个项目的人）
     * 查询 当前 登陆人下的对应项目下的所有采购项目
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<List<ProjectEmployeeRelationVO>> getProjectPurchaserByProjectId(HandleProjectPurchaserByProjectId handleProjectPurchaserByProjectId){
        Long id = handleProjectPurchaserByProjectId.getId();
        Long projectId = handleProjectPurchaserByProjectId.getProjectId();

        if(id==null || projectId==null){
            return Result.error("[查询项目下的所有采购项目] id==null || projectId==null {参数异常}");
        }
        TProjectPurchaserEmployeeRelationCriteria criteria=new TProjectPurchaserEmployeeRelationCriteria();
        TProjectPurchaserEmployeeRelationCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andProjectIdEqualTo(projectId);
        subCriteria.andCreaterIdEqualTo(id);

        List<TProjectPurchaserEmployeeRelation> tProjectPurchaserEmployeeRelations = tProjectPurchaserEmployeeRelationMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tProjectPurchaserEmployeeRelations)){
            return Result.success(null);
        }
        List<ProjectEmployeeRelationVO> listVO=new ArrayList<ProjectEmployeeRelationVO>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        for(TProjectPurchaserEmployeeRelation single:tProjectPurchaserEmployeeRelations){
            ProjectEmployeeRelationVO vo=new ProjectEmployeeRelationVO();
            BeanUtils.copyProperties(single,vo);
            vo.setProjectName(single.getProjectPurchaserName());
            vo.setCreateAt(format.format(single.getCreateAt()));
            listVO.add(vo);
        }
        return Result.success(listVO);
    }




    @Override
    public Result<ProjectDetailInfoVO> getProjectDetailInfo(Long projectId) {
        TProjectBasicInfo tProjectBasicInfo = tProjectBasicInfoMapper.selectByPrimaryKey(projectId);
        ProjectDetailInfoVO projectDetailInfoVO = new ProjectDetailInfoVO();
        if (tProjectBasicInfo==null){
            return Result.success(null);
        }
        BeanUtils.copyProperties(tProjectBasicInfo, projectDetailInfoVO);
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
        List<TProjectBasicInfo> tProjectBasicInfoList = tProjectBasicInfoMapper.selectByExampleWithRowbounds(criteria, queryProjectInfoDTO.getRowBounds());
        List<ProjectBasicInfoVO> returnList = new ArrayList<>();
        tProjectBasicInfoList.forEach(item -> {
            ProjectBasicInfoVO projectBasicInfoVO = new ProjectBasicInfoVO();
            BeanUtils.copyProperties(item, projectBasicInfoVO);
            returnList.add(projectBasicInfoVO);
        });
        return Result.success(returnList);
    }
}
