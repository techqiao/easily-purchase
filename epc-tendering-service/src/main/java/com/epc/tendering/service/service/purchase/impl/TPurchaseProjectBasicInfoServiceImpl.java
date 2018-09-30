package com.epc.tendering.service.service.purchase.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.constants.ParticipantPermissionEnum;
import com.epc.common.constants.PurchaseProjectStatusEnum;
import com.epc.common.exception.BusinessException;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipant;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantCriteria;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermission;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermissionCriteria;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfoCriteria;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantMapper;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantPermissionMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.service.purchase.TPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.participant.handle.HandleParticipantBasicInfo;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : 采购项目实现类
 * <p>Date : 2018-09-18 19:08
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TPurchaseProjectBasicInfoServiceImpl implements TPurchaseProjectBasicInfoService {
    @Autowired
    private TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    private TPurchaseProjectParticipantMapper tPurchaseProjectParticipantMapper;
    @Autowired
    private TPurchaseProjectParticipantPermissionMapper tPurchaseProjectParticipantPermissionMapper;

    @Override
    @Transactional
    public Result<Boolean> handlePurchaseProjectBasicInfo(HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub) {
        TPurchaseProjectBasicInfo pojo = new TPurchaseProjectBasicInfo();
        BeanUtils.copyProperties(handlePurchaseProjectBasicInfoSub, pojo);
        //操作人ID
        Long operateId = handlePurchaseProjectBasicInfoSub.getOperateId();
        //操作人姓名
        String creator = handlePurchaseProjectBasicInfoSub.getCreator();
        //经办人ID
        Long agentId = handlePurchaseProjectBasicInfoSub.getAgentId();
        //审核人ID
        Long auditorId = handlePurchaseProjectBasicInfoSub.getAuditorId();
        //采购人项目ID
        Long purchaseProjectId = handlePurchaseProjectBasicInfoSub.getPurchaseProjectId();
        //采购项目参与者集合
        List<HandleParticipantBasicInfo> basicInfoList = handlePurchaseProjectBasicInfoSub.getHandleParticipantBasicInfoList();
        //不全权委托招标代理机构
        if (Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY == handlePurchaseProjectBasicInfoSub.getIsOtherAgency()) {
            try {
                if (pojo.getId() == null) {
                    pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    pojo.setPurchaseProjectStatus(PurchaseProjectStatusEnum.CREATED.getCode());
                    //新增采购项目
                    tPurchaseProjectBasicInfoMapper.insertSelective(pojo);
                    //指定采购项目参与者 经办人 审核人 批复人 负责人
                    addUserRole(basicInfoList, operateId, creator, agentId, auditorId, purchaseProjectId);
                } else if (pojo.getId() != null &&
                        tPurchaseProjectBasicInfoMapper.getPurchaseProjectStatusById(pojo.getId())
                                .equals(PurchaseProjectStatusEnum.CREATED.getCode())) {
                    //修改|刪除采购项目 isDeleted 前端控制，修改删除
                    deleteAndUpdatePurchaseProject(pojo, operateId, creator, agentId, auditorId, purchaseProjectId, basicInfoList);
                }
                return Result.success();
            } catch (BusinessException e) {
                return Result.error(ErrorMessagesEnum.FAILURE);
            } catch (Exception e) {
                return Result.error(e.getMessage());
            }
        }
        //全权委托招标代理机构
        else {
            try {
                if (pojo.getId() == null) {
                    //招标代理机构ID
                    Long purchaserAgencyId = handlePurchaseProjectBasicInfoSub.getPurchaserAgencyId();
                    pojo.setPurchaseProjectStatus(PurchaseProjectStatusEnum.CREATED.getCode());
                    pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    pojo.setIsOtherAgency(Const.IS_OTHER_AGENCY.IS_OTHER_AGENCY);
                    //新增采购项目
                    tPurchaseProjectBasicInfoMapper.insertSelective(pojo);
                    //指定批复人
                    addUserRole(ParticipantPermissionEnum.REPLY.getCode(), basicInfoList, operateId, creator, operateId, purchaseProjectId);
                    //指定负责人
                    addUserRole(ParticipantPermissionEnum.PERSON_LIABLE.getCode(), basicInfoList, operateId, creator, purchaserAgencyId, purchaseProjectId);
                } else if (pojo.getId() != null &&
                        tPurchaseProjectBasicInfoMapper.getPurchaseProjectStatusById(pojo.getId())
                                .equals(PurchaseProjectStatusEnum.CREATED.getCode())) {
                    //修改|刪除采购项目
                    deleteAndUpdatePurchaseProject(pojo, operateId, creator, agentId, auditorId, purchaseProjectId, basicInfoList);
                }
                return Result.success();
            } catch (BusinessException e) {
                return Result.error(ErrorMessagesEnum.FAILURE);
            } catch (Exception e) {
                return Result.error(e.getMessage());
            }
        }

    }

    /**
     * 修改|刪除采购项目  采购项目参与者
     *
     * @param pojo
     * @param operateId
     * @param creator
     * @param agentId
     * @param auditorId
     * @param purchaseProjectId
     * @param basicInfoList
     */
    private void  deleteAndUpdatePurchaseProject(TPurchaseProjectBasicInfo pojo, Long operateId, String creator, Long agentId, Long auditorId, Long purchaseProjectId, List<HandleParticipantBasicInfo> basicInfoList) {
        tPurchaseProjectBasicInfoMapper.updateByPrimaryKeySelective(pojo);
        final TPurchaseProjectParticipantCriteria criteria = new TPurchaseProjectParticipantCriteria();
        criteria.createCriteria().andPurchaseProjectIdEqualTo(pojo.getId());
        List<TPurchaseProjectParticipant> tpppList = tPurchaseProjectParticipantMapper.selectByExample(criteria);
        deleteParticipantAndPermission(operateId, creator, tpppList);
        if (pojo.getIsDeleted() != Const.IS_DELETED.IS_DELETED) {
            addUserRole(basicInfoList, operateId, creator, agentId, auditorId, purchaseProjectId);
        }
    }

    /**
     * 指定采购项目参与者 经办人 审核人 批复人 负责人
     *
     * @param basicInfoList
     * @param operateId
     * @param creator
     * @param agentId
     * @param auditorId
     * @param purchaseProjectId
     */
    private void addUserRole(List<HandleParticipantBasicInfo> basicInfoList, Long operateId, String creator, Long agentId, Long auditorId, Long purchaseProjectId) {
        //指定经办人
        addUserRole(ParticipantPermissionEnum.AGENT.getCode(), basicInfoList, operateId, creator, agentId, purchaseProjectId);
        //指定审核人
        addUserRole(ParticipantPermissionEnum.AUDITOR.getCode(), basicInfoList, operateId, creator, auditorId, purchaseProjectId);
        //指定批复人
        addUserRole(ParticipantPermissionEnum.REPLY.getCode(), basicInfoList, operateId, creator, operateId, purchaseProjectId);
        //指定负责人
        addUserRole(ParticipantPermissionEnum.REPLY.getCode(), basicInfoList, operateId, creator, operateId, purchaseProjectId);
    }

    /**
     * 删除采购项目参与者 is_delete=1
     *
     * @param operateId 操作人
     * @param creator   操作人姓名
     * @param tpppList  参与者集合
     */
    private void deleteParticipantAndPermission(Long operateId, String creator, List<TPurchaseProjectParticipant> tpppList) {
        for (TPurchaseProjectParticipant item : tpppList) {
            item.setIsDeleted(Const.IS_DELETED.IS_DELETED);
            item.setCreator(creator);
            item.setOperateId(operateId);
            item.setUpdateAt(new Date());
            tPurchaseProjectParticipantMapper.updateByPrimaryKeySelective(item);
            final TPurchaseProjectParticipantPermissionCriteria permissionCriteria = new TPurchaseProjectParticipantPermissionCriteria();
            permissionCriteria.createCriteria().andParticipantIdEqualTo(item.getId());
            List<TPurchaseProjectParticipantPermission> permissionList = tPurchaseProjectParticipantPermissionMapper.selectByExample(permissionCriteria);
            for (TPurchaseProjectParticipantPermission permission : permissionList) {
                permission.setIsDeleted(Const.IS_DELETED.IS_DELETED);
                permission.setCreator(creator);
                permission.setOperateId(operateId);
                permission.setUpdateAt(new Date());
                tPurchaseProjectParticipantPermissionMapper.updateByPrimaryKeySelective(permission);
            }

        }
    }

    /**
     * 指定审核人经办人批复人负责人
     *
     * @param type              角色类型
     * @param basicInfoList     参与者集合
     * @param operateId         操作人ID
     * @param creator           操作人姓名
     * @param userId            当前角色ID
     * @param purchaseProjectId 采购项目ID
     */
    private void addUserRole(String type, List<HandleParticipantBasicInfo> basicInfoList, Long operateId, String creator, Long userId, Long purchaseProjectId) {
        TPurchaseProjectParticipant tppp = new TPurchaseProjectParticipant();
        tppp.setPurchaseProjectId(purchaseProjectId);
        tppp.setUserId(userId);
        tppp.setOperateId(operateId);
        tppp.setCreator(creator);
        tppp.setCreateAt(new Date());
        tppp.setUpdateAt(new Date());
        tppp.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        for (HandleParticipantBasicInfo item : basicInfoList) {
            if (item.getType().equals(type)) {
                BeanUtils.copyProperties(item, tppp);
            }
        }
        //参与者
        tPurchaseProjectParticipantMapper.insertSelective(tppp);
        TPurchaseProjectParticipantPermission tpppp = new TPurchaseProjectParticipantPermission();
        tpppp.setParticipantId(tppp.getId());
        tpppp.setParticipantPermission(type);
        tpppp.setOperateId(operateId);
        tpppp.setCreator(creator);
        tpppp.setCreateAt(new Date());
        tpppp.setUpdateAt(new Date());
        tpppp.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //分配权限
        tPurchaseProjectParticipantPermissionMapper.insertSelective(tpppp);
    }


    @Override
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(Long id) {
        TPurchaseProjectBasicInfo tProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(id);
        PurchaseProjectBasicInfoVO projectDetailInfoVO = new PurchaseProjectBasicInfoVO();
        if (tProjectBasicInfo == null) {
            return Result.success(null);
        }
        BeanUtils.copyProperties(tProjectBasicInfo, projectDetailInfoVO);
        return Result.success(projectDetailInfoVO);
    }


    @Override
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectList(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        final TPurchaseProjectBasicInfoCriteria criteria = new TPurchaseProjectBasicInfoCriteria();
        final TPurchaseProjectBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        criteriaBuild(queryPurchaseBasicInfoVO, criteria, subCriteria);
        List<PurchaseProjectBasicInfoVO> returnList = new ArrayList<>();
        List<TPurchaseProjectBasicInfo> infoList = tPurchaseProjectBasicInfoMapper.selectByExampleWithRowbounds(criteria, queryPurchaseBasicInfoVO.getRowBounds());
        infoList.forEach(item -> {
            PurchaseProjectBasicInfoVO pojo = new PurchaseProjectBasicInfoVO();
            BeanUtils.copyProperties(item, pojo);
            returnList.add(pojo);
        });
        return Result.success(returnList);
    }

    /**
     * 条件过滤查询
     *
     * @param queryPurchaseBasicInfoVO
     * @param criteria
     * @param subCriteria
     */
    private void criteriaBuild(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO, TPurchaseProjectBasicInfoCriteria criteria, TPurchaseProjectBasicInfoCriteria.Criteria subCriteria) {
        criteria.setOrderByClause("id desc");
        subCriteria.andProjectIdEqualTo(queryPurchaseBasicInfoVO.getProjectId());
        //采购分类
        if (StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseCategory())) {
            subCriteria.andPurchaseCategoryEqualTo(queryPurchaseBasicInfoVO.getPurchaseCategory());
        }
        //采购类型
        if (StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseType())) {
            subCriteria.andPurchaseTypeEqualTo(queryPurchaseBasicInfoVO.getPurchaseType());
        }
        //采购方式
        if (StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseMode())) {
            subCriteria.andPurchaseModeEqualTo(queryPurchaseBasicInfoVO.getPurchaseMode());
        }
        //采购项目状态
        if (StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseProjectStatus())) {
            subCriteria.andPurchaseProjectStatusEqualTo(queryPurchaseBasicInfoVO.getPurchaseProjectStatus());
        }
        //采购项目编号
        if (StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseProjectCode())) {
            subCriteria.andPurchaseProjectCodeEqualTo(queryPurchaseBasicInfoVO.getPurchaseProjectCode());
        }
        //采购项目名称
        if (StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseProjectName())) {
            subCriteria.andPurchaseProjectNameEqualTo(queryPurchaseBasicInfoVO.getPurchaseProjectName());
        }
        //开始时间
        if (queryPurchaseBasicInfoVO.getPurchaseStartTime() != null) {
            subCriteria.andPurchaseStartTimeGreaterThanOrEqualTo(queryPurchaseBasicInfoVO.getPurchaseStartTime());
        }
        //结束时间
        if (queryPurchaseBasicInfoVO.getPurchaseEndTime() != null) {
            subCriteria.andPurchaseStartTimeLessThanOrEqualTo(queryPurchaseBasicInfoVO.getPurchaseEndTime());
        }
    }
}
