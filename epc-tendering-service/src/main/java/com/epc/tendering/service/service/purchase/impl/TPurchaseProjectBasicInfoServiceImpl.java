package com.epc.tendering.service.service.purchase.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.constants.ParticipantPermissionEnum;
import com.epc.common.constants.PurchaseProjectStatusEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.GeneratorCodeUtil;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipant;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantCriteria;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermission;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermissionCriteria;
import com.epc.tendering.service.domain.purchase.TProcurementProjectSupplier;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfoCriteria;
import com.epc.tendering.service.domain.purchaser.TProjectPurchaserEmployeeRelation;
import com.epc.tendering.service.mapper.announcement.BReleaseAnnouncementMapper;
import com.epc.tendering.service.mapper.bid.*;
import com.epc.tendering.service.mapper.committee.BAssessmentCommitteeMapper;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantMapper;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantPermissionMapper;
import com.epc.tendering.service.mapper.pretrial.TPretrialMessageMapper;
import com.epc.tendering.service.mapper.project.TProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchase.TProcurementProjectSupplierMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchaser.TProjectPurchaserEmployeeRelationMapper;
import com.epc.tendering.service.mapper.question.BAnswerQuestionMapper;
import com.epc.tendering.service.mapper.signup.BInvitationMapper;
import com.epc.tendering.service.mapper.winBid.TWinBidMapper;
import com.epc.tendering.service.service.purchase.TPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.participant.handle.HandleParticipantBasicInfo;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.FlowVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private TProjectBasicInfoMapper tProjectBasicInfoMapper;
    @Autowired
    private TProcurementProjectSupplierMapper tProcurementProjectSupplierMapper;
    @Autowired
    private BReleaseAnnouncementMapper bReleaseAnnouncementMapper;
    @Autowired
    private BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    private BEvaluationTenderStandardMapper bEvaluationTenderStandardMapper;
    @Autowired
    private BAssessmentCommitteeMapper bAssessmentCommitteeMapper;
    @Autowired
    private TOpeningRecordMapper tOpeningRecordMapper;
    @Autowired
    private TBidAnnouncementMapper tBidAnnouncementMapper;
    @Autowired
    private TOpeningRecordPublicityMapper tOpeningRecordPublicityMapper;
    @Autowired
    private BExpertSignMapper bExpertSignMapper;
    @Autowired
    private BExpertScoreReportMapper bExpertScoreReportMapper;
    @Autowired
    private TWinBidNominateMapper tWinBidNominateMapper;
    @Autowired
    private TWinBidMapper tWinBidMapper;
    @Autowired
    private BBidOpeningPayMapper bBidOpeningPayMapper;
    @Autowired
    private LetterOfTenderMapper letterOfTenderMapper;
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;

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
        //是否全权委托代理机构
        Integer isOtherAgency = handlePurchaseProjectBasicInfoSub.getIsOtherAgency();
        //供应商集合
        List<Long> supplierIds = handlePurchaseProjectBasicInfoSub.getSupplierIds();
        //采购项目参与者集合
        List<HandleParticipantBasicInfo> basicInfoList = handlePurchaseProjectBasicInfoSub.getHandleParticipantBasicInfoList();
        //不全权委托招标代理机构
        if (Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY == isOtherAgency) {
            try {
                Long id = pojo.getId();
                if (id == null) {
                    pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    pojo.setPurchaseProjectStatus(PurchaseProjectStatusEnum.CREATED.getCode());
                    pojo.setPurchaseProjectCode(GeneratorCodeUtil.GeneratorProjectCode());
                    //新增采购项目
                    tPurchaseProjectBasicInfoMapper.insertSelective(pojo);
                    //指定供应商
                    insertProjectSupplier(pojo, supplierIds);
                    purchaseProjectId = pojo.getId();
                    //指定采购项目参与者 经办人 审核人 批复人 负责人
                    addUserRole(isOtherAgency, basicInfoList, operateId, creator, agentId, auditorId, purchaseProjectId);
                } else if (id != null &&
                        tPurchaseProjectBasicInfoMapper.getPurchaseProjectStatusById(id)
                                .equals(PurchaseProjectStatusEnum.CREATED.getCode())) {
                    //修改|刪除采购项目 isDeleted 前端控制，修改删除
                    deleteAndUpdatePurchaseProject(isOtherAgency, pojo, operateId, creator, agentId, auditorId, purchaseProjectId, basicInfoList);
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
                Long id = pojo.getId();
                if (id == null) {
                    //招标代理机构ID
                    Long purchaserAgencyId = handlePurchaseProjectBasicInfoSub.getPurchaserAgencyId();
                    pojo.setPurchaseProjectStatus(PurchaseProjectStatusEnum.CREATED.getCode());
                    pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    pojo.setIsOtherAgency(Const.IS_OTHER_AGENCY.IS_OTHER_AGENCY);
                    pojo.setPurchaseProjectCode(GeneratorCodeUtil.GeneratorProjectCode());
                    //新增采购项目
                    tPurchaseProjectBasicInfoMapper.insertSelective(pojo);
                    insertProjectSupplier(pojo, supplierIds);
                    purchaseProjectId = pojo.getId();
                    //指定批复人
                    addUserRole(isOtherAgency, ParticipantPermissionEnum.REPLY.getCode(), basicInfoList, operateId, creator, operateId, purchaseProjectId);
                    //指定负责人
                    addUserRole(isOtherAgency, ParticipantPermissionEnum.PERSON_LIABLE.getCode(), basicInfoList, operateId, creator, purchaserAgencyId, purchaseProjectId);
                } else if (id != null &&
                        tPurchaseProjectBasicInfoMapper.getPurchaseProjectStatusById(id)
                                .equals(PurchaseProjectStatusEnum.CREATED.getCode())) {
                    //修改|刪除采购项目
                    deleteAndUpdatePurchaseProject(isOtherAgency, pojo, operateId, creator, agentId, auditorId, id, basicInfoList);
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
     * 指定供应商
     *
     * @param pojo
     * @param supplierIds
     */
    private void insertProjectSupplier(TPurchaseProjectBasicInfo pojo, List<Long> supplierIds) {
        if (!CollectionUtils.isEmpty(supplierIds)
                && pojo.getPurchaseRange().equals(Const.IS_OK.IS_OK)) {
            for (Long supplierId : supplierIds) {
                TProcurementProjectSupplier projectSupplier = new TProcurementProjectSupplier();
                projectSupplier.setProcurementProjectId(pojo.getId());
                projectSupplier.setSupplierId(supplierId);
                tProcurementProjectSupplierMapper.insertSelective(projectSupplier);
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
    private void deleteAndUpdatePurchaseProject(Integer isOtherAgency, TPurchaseProjectBasicInfo pojo, Long operateId, String creator, Long agentId, Long auditorId, Long purchaseProjectId, List<HandleParticipantBasicInfo> basicInfoList) {
        tPurchaseProjectBasicInfoMapper.updateByPrimaryKeySelective(pojo);
        final TPurchaseProjectParticipantCriteria criteria = new TPurchaseProjectParticipantCriteria();
        criteria.createCriteria().andPurchaseProjectIdEqualTo(pojo.getId());
        List<TPurchaseProjectParticipant> tpppList = tPurchaseProjectParticipantMapper.selectByExample(criteria);
        deleteParticipantAndPermission(operateId, creator, tpppList);
        //如果不刪除 采购项目
        if (pojo.getIsDeleted() != null && pojo.getIsDeleted() != Const.IS_DELETED.IS_DELETED &&
                agentId != null && auditorId != null) {
            addUserRole(isOtherAgency, basicInfoList, operateId, creator, agentId, auditorId, pojo.getId());
        }
    }

    /**
     * 指定采购项目参与者 经办人 审核人 批复人 负责人
     *
     * @param isOtherAgency     是否全权委托
     * @param basicInfoList
     * @param operateId
     * @param creator
     * @param agentId
     * @param auditorId
     * @param purchaseProjectId
     */
    private void addUserRole(Integer isOtherAgency, List<HandleParticipantBasicInfo> basicInfoList, Long operateId, String creator, Long agentId, Long auditorId, Long purchaseProjectId) {
        //指定经办人
        addUserRole(isOtherAgency, ParticipantPermissionEnum.AGENT.getCode(), basicInfoList, operateId, creator, agentId, purchaseProjectId);
        //指定审核人
        addUserRole(isOtherAgency, ParticipantPermissionEnum.AUDITOR.getCode(), basicInfoList, operateId, creator, auditorId, purchaseProjectId);
        //指定批复人
        addUserRole(isOtherAgency, ParticipantPermissionEnum.REPLY.getCode(), basicInfoList, operateId, creator, operateId, purchaseProjectId);
        //指定负责人
        addUserRole(isOtherAgency, ParticipantPermissionEnum.PERSON_LIABLE.getCode(), basicInfoList, operateId, creator, operateId, purchaseProjectId);
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
    private void addUserRole(Integer isOtherAgency, String type, List<HandleParticipantBasicInfo> basicInfoList, Long operateId, String creator, Long userId, Long purchaseProjectId) {
        TPurchaseProjectParticipant tppp = new TPurchaseProjectParticipant();
        tppp.setUserId(userId);
        tppp.setOperateId(operateId);
        tppp.setCreator(creator);
        tppp.setCreateAt(new Date());
        tppp.setUpdateAt(new Date());
        tppp.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        if (isOtherAgency.equals(Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY)) {
            //采购人类型
            tppp.setParticipantType(4);
        } else {
            //招标代理机构类型
            tppp.setParticipantType(2);
        }
        for (HandleParticipantBasicInfo item : basicInfoList) {
            if (item.getType().equals(type)) {
                BeanUtils.copyProperties(item, tppp);
            }
        }
        tppp.setPurchaseProjectId(purchaseProjectId);
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
        if (isOtherAgency.equals(Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY)) {
            //采购人类型
            tpppp.setParticipantType(4);
        } else {
            //招标代理机构类型
            tpppp.setParticipantType(2);
        }
        //0:暂未到达此步 1待办 2已完成 -1 打回到此步
        tpppp.setActionState(0);
        tpppp.setPurchaseProjectId(purchaseProjectId);
        tpppp.setUserId(userId);
        tpppp.setStepType("announcement");
        //分配权限 公告
        tPurchaseProjectParticipantPermissionMapper.insertSelective(tpppp);
        tpppp.setStepType("publicity");
        tpppp.setId(null);
        //分配权限 发布招标公示
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
            pojo.setProjectAddress(tProjectBasicInfoMapper.getProjectAddress(item.getProjectId()));
            returnList.add(pojo);
        });
        return Result.success(returnList);
    }

    @Autowired
    private TPretrialMessageMapper tPretrialMessageMapper;
    @Autowired
    private BInvitationMapper bInvitationMapper;
    @Autowired
    private BAnswerQuestionMapper bAnswerQuestionMapper;
    @Autowired
    private TTenderMessageMapper tTenderMessageMapper;

    @Override
    public Result<FlowVO> getFlowByProcurementProjectId(Long procurementProjectId) {
        FlowVO flowVO = new FlowVO();
        //公告ID 状态=发布 --> 发布成功
        Long announcementId = bReleaseAnnouncementMapper.getId(procurementProjectId);
        //供应商资格审查 预审信息状态=审核 count=0 false -->审核完成
        Boolean message = tPretrialMessageMapper.getMessage(procurementProjectId);
        //供应商邀请  true --> 邀请完成
        Boolean invitation = bInvitationMapper.getInvitation(procurementProjectId);
        //发售招标文件ID 状态=发布 ->发布完成
        Long bSaleDocumentsId = bSaleDocumentsMapper.getId(procurementProjectId);
        //评标标准设定ID 状态=发布 ->发布完成
        Long evaluationId = bEvaluationTenderStandardMapper.getId(procurementProjectId);
        //招标文件答疑 状态为wait_reply 待回复 0 false ->已完成
        Boolean question = bAnswerQuestionMapper.getId(procurementProjectId);
        //确认供应商数量 3家为可以进行下一步
        Boolean countSupplier = tTenderMessageMapper.countSupplier(procurementProjectId) > 2;
        //组建评委会ID 状态为2 通过 ->已完成
        Long committeeId = bAssessmentCommitteeMapper.getId(procurementProjectId);
        //开标ID 状态为1 正常 true 已完成
        Boolean openingRecord = tOpeningRecordMapper.getId(procurementProjectId);
        //唱标 唱标备注为null count=0 false -->唱标已完成
        Boolean tender = letterOfTenderMapper.getIdMEMO(procurementProjectId);
        //公示开标记录ID 开标记录为已发布 ->已完成
        Long recordPublicityId = tOpeningRecordPublicityMapper.getId(procurementProjectId);
        //评标专家是否签到 true 签到完成
        Integer totalNumber = bAssessmentCommitteeMapper.getTotalNumber(procurementProjectId);
        Integer number = bExpertSignMapper.getId(procurementProjectId);
        Boolean expert =Boolean.FALSE;
        if (totalNumber != null) {
            expert  = (totalNumber-number==0);
        }
        //专家评审 专家签到 true 设定组长完成
        Boolean idLeader = bExpertSignMapper.getIdLeader(procurementProjectId);
        //评审报告 true 评审报告发布完成
        Boolean report = (tPurchaseProjectBidsMapper.getBidsNum(procurementProjectId) - bExpertScoreReportMapper.getId(procurementProjectId) == 0);
        //中标公示ID
        Long winBidNominateId = tWinBidNominateMapper.getId(procurementProjectId);
        //中标通知书ID
        Long winBidId = tWinBidMapper.getId(procurementProjectId);
        //退还保证金ID
        Long payId = bBidOpeningPayMapper.getId(procurementProjectId);
        if(payId!=null){
            flowVO.setStep("pay");
            flowVO.setId(payId);
            return Result.success(flowVO);
        }
        if(winBidId!=null){
            flowVO.setStep("winBid");
            flowVO.setId(winBidId);
            return Result.success(flowVO);
        }
        if(winBidNominateId!=null){
            flowVO.setStep("winBidNominate");
            flowVO.setId(winBidNominateId);
            return Result.success(flowVO);
        }
        if(report){
            flowVO.setStep("report");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(idLeader){
            flowVO.setStep("idLeader");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(expert){
            flowVO.setStep("expert");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(recordPublicityId!=null){
            flowVO.setStep("recordPublicity");
            flowVO.setId(recordPublicityId);
            return Result.success(flowVO);
        }
        if(!tender){
            flowVO.setStep("tender");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(openingRecord){
            flowVO.setStep("openingRecord");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(committeeId!=null){
            flowVO.setStep("committee");
            flowVO.setId(committeeId);
            return Result.success(flowVO);
        }
        if(countSupplier){
            flowVO.setStep("countSupplier");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(!question){
            flowVO.setStep("question");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if(evaluationId!=null){
            flowVO.setStep("evaluation");
            flowVO.setId(evaluationId);
            return Result.success(flowVO);
        }
        if(bSaleDocumentsId!=null){
            flowVO.setStep("bSaleDocuments");
            flowVO.setId(bSaleDocumentsId);
            return Result.success(flowVO);
        }
        if(invitation){
            flowVO.setStep("invitation");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if (!message) {
            flowVO.setStep("message");
            flowVO.setId(null);
            return Result.success(flowVO);
        }
        if (announcementId != null) {
            flowVO.setStep("announcement");
            flowVO.setId(announcementId);
            return Result.success(flowVO);
        }
        return Result.success(flowVO);
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
        if (queryPurchaseBasicInfoVO.getProjectId() != null) {
            subCriteria.andProjectIdEqualTo(queryPurchaseBasicInfoVO.getProjectId());
        }
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
