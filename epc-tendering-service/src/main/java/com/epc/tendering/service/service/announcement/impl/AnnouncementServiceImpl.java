package com.epc.tendering.service.service.announcement.impl;

import com.epc.common.Result;
import com.epc.common.constants.*;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncement;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncementCriteria;
import com.epc.tendering.service.domain.bid.TWinBidNominate;
import com.epc.tendering.service.domain.bid.TWinBidNominateCriteria;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantCriteria;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermission;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermissionCriteria;
import com.epc.tendering.service.domain.preview.TBiddingPreview;
import com.epc.tendering.service.domain.preview.TBiddingPreviewCriteria;
import com.epc.tendering.service.mapper.announcement.BReleaseAnnouncementMapper;
import com.epc.tendering.service.mapper.bid.TWinBidNominateMapper;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantPermissionMapper;
import com.epc.tendering.service.mapper.preview.TBiddingPreviewMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.tendering.service.service.announcement.AnnouncementService;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:46
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private BReleaseAnnouncementMapper bReleaseAnnouncementMapper;
    @Autowired
    private TWinBidNominateMapper tWinBidNominateMapper;
    @Autowired
    private TPurchaseProjectParticipantPermissionMapper tPurchaseProjectParticipantPermissionMapper;
    @Autowired
    private TBiddingPreviewMapper tBiddingPreviewMapper;
    @Autowired
    private TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Override
    public Result<Boolean> insertAnnouncement(HandleAnnouncement handleAnnouncement) {
        BReleaseAnnouncement bReleaseAnnouncement = new BReleaseAnnouncement();
        BeanUtils.copyProperties(handleAnnouncement, bReleaseAnnouncement);
        bReleaseAnnouncement.setCreateAt(new Date());
        bReleaseAnnouncement.setUpdateAt(new Date());
        bReleaseAnnouncement.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        if(bReleaseAnnouncement.getId()==null){
            return Result.success(bReleaseAnnouncementMapper.insertSelective(bReleaseAnnouncement) > 0);
        }
        if(bReleaseAnnouncement.getId()!=null &&
                AnnouncementProcessStatusEnum.NOT_SUBMIT.equals(bReleaseAnnouncementMapper.getProcessStatusById(handleAnnouncement.getId()))){
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeyWithBLOBs(bReleaseAnnouncement) > 0);
        }
        return Result.error(ErrorMessagesEnum.FAILURE);
    }

    @Override
    public Result<Boolean> updateAnnouncementStatus(HandleAnnouncementStatus handleAnnouncementStatus) {
        BReleaseAnnouncement bReleaseAnnouncement = new BReleaseAnnouncement();
        bReleaseAnnouncement.setId(handleAnnouncementStatus.getId());
        bReleaseAnnouncement.setUpdateAt(new Date());
        handleAnnouncementStatus.setIsOtherAgency(tPurchaseProjectBasicInfoMapper.getIsOtherAgency(handleAnnouncementStatus.getId()));
        handleAnnouncementStatus.setPurchaseProjectId(bReleaseAnnouncementMapper.getProcurementProjectId(handleAnnouncementStatus.getId()));
        //当前状态为未提交 --> 待审核  提交公告等待审核
        if(handleAnnouncementStatus.getProcessStatus().equals(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode())){
            //公告状态待审核
            bReleaseAnnouncement.setProcessStatus(AnnouncementProcessStatusEnum.AUDITING.getCode());
            //将 审核 步骤的负责人流程状态更新为  待办
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.NEED_DEAL,AnnouncementProcessStatusEnum.AUDITING.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        // 审核通过 当前状态为待审核-->待批复  审核通过公告变成待批复
        if(handleAnnouncementStatus.getIsPass().equals(Const.IS_OK.IS_OK)
                && AnnouncementProcessStatusEnum.AUDITING.getCode().equals(handleAnnouncementStatus.getProcessStatus())){
            //将 审核 步骤的负责人流程状态更新为 完成
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.COMPLETE,AnnouncementProcessStatusEnum.AUDITING.getCode());
            //将 批复 步骤的负责人流程状态更新为 待办
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.NEED_DEAL,AnnouncementProcessStatusEnum.REPLY.getCode());
            //待批复
            bReleaseAnnouncement.setProcessStatus(AnnouncementProcessStatusEnum.REPLY.getCode());
            bReleaseAnnouncement.setAuditorId(handleAnnouncementStatus.getOperateId());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        // 审核不通过 当前状态为待审核-->待提交 审核不通过公告变成待提交
        if(handleAnnouncementStatus.getIsPass().equals(Const.IS_OK.IS_OK)
                && AnnouncementProcessStatusEnum.AUDITING.getCode().equals(handleAnnouncementStatus.getProcessStatus())){
            //将 审核 步骤的负责人流程状态更新为  未到此步
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.NOT_ARRIVING,AnnouncementProcessStatusEnum.AUDITING.getCode());
            //公告状态待提交
            bReleaseAnnouncement.setProcessStatus(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        // 审核通过 当前状态为待批复-->待发布  审核通过 公告变成待发布
        if(handleAnnouncementStatus.getIsPass().equals(Const.IS_OK.IS_OK)
                && AnnouncementProcessStatusEnum.REPLY.getCode().equals(handleAnnouncementStatus.getProcessStatus())) {
            //将 批复 步骤的负责人流程状态更新为 已完成
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.COMPLETE,AnnouncementProcessStatusEnum.REPLY.getCode());
            //将 经办 步骤的负责人流程状态更新为 待办
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.NEED_DEAL,AnnouncementProcessStatusEnum.AGENT.getCode());
            //待发布
            bReleaseAnnouncement.setRepliesId(handleAnnouncementStatus.getOperateId());
            bReleaseAnnouncement.setProcessStatus(AnnouncementProcessStatusEnum.WAIT_RELEASE.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        // 审核不通过 当前状态为待批复-->待审核  审核不通过 公告变成待审核
        if(handleAnnouncementStatus.getIsPass().equals(Const.IS_OK.IS_OK)
                && AnnouncementProcessStatusEnum.REPLY.getCode().equals(handleAnnouncementStatus.getProcessStatus())) {
            //将 批复 步骤的负责人流程状态更新为 未到此步
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.NOT_ARRIVING,AnnouncementProcessStatusEnum.REPLY.getCode());
            //将 审核 步骤的负责人流程状态更新为 打回到此步
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.PURCHASER,AnnouncementProcessStatusEnum.AUDITING.getCode());
            //待审核
            bReleaseAnnouncement.setRepliesId(handleAnnouncementStatus.getOperateId());
            bReleaseAnnouncement.setProcessStatus(AnnouncementProcessStatusEnum.AUDITING.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        // 经办人同意发布 当前状态待发布-->已发布
        if(handleAnnouncementStatus.getIsPass().equals(Const.IS_OK.IS_OK)
                &&AnnouncementProcessStatusEnum.WAIT_RELEASE.getCode().equals(handleAnnouncementStatus.getProcessStatus())){
            //步骤的负责人流程状态更新为 已完成
            updateActionState(handleAnnouncementStatus,Const.ACTION_STATE.COMPLETE,AnnouncementProcessStatusEnum.AGENT.getCode());
            //已发布
            bReleaseAnnouncement.setOperateId(handleAnnouncementStatus.getOperateId());
            bReleaseAnnouncement.setProcessStatus(AnnouncementProcessStatusEnum.RELEASED.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        return Result.success();
    }

    /**
     * 根据项目参与者权限 采购项目ID 用户ID 更新流程状态
     * @param handleAnnouncementStatus 条件
     * @param actionState  被更新的流程状态 0:暂未到达此步 1待办 2已完成 -1 打回到此步
     * @param participantPermission 项目参与者权限 批复reply 经办agent 审核auditor
     */
    private void updateActionState(HandleAnnouncementStatus handleAnnouncementStatus,Integer actionState,String participantPermission) {
        TPurchaseProjectParticipantPermission permission = new TPurchaseProjectParticipantPermission();
        permission.setUserId(handleAnnouncementStatus.getOperateId());
        permission.setPurchaseProjectId(handleAnnouncementStatus.getPurchaseProjectId());
        permission.setActionState(actionState);
        permission.setParticipantPermission(participantPermission);
        permission.setStepType("announcement");
        if(handleAnnouncementStatus.getIsOtherAgency().equals(Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY)){
            permission.setParticipantType(Const.LOGIN_USER_TYPE.PURCHASER);
        }else{
            permission.setParticipantType(Const.LOGIN_USER_TYPE.PROXY);
        }
        tPurchaseProjectParticipantPermissionMapper.updateActionState(permission);
    }

    @Override
    public Boolean handleAnnouncementBiddingEnd() {
        BReleaseAnnouncementCriteria criteria = new BReleaseAnnouncementCriteria();
        criteria.createCriteria().andBiddingEndGreaterThanOrEqualTo(new Date());
        List<BReleaseAnnouncement> list = bReleaseAnnouncementMapper.selectByExample(criteria);
        bReleaseAnnouncementMapper.batchUpdateStatus(list);
        return Boolean.TRUE;
    }


    @Override
    public Result<List<PurchaseProjectAnnouncement>> getPurchaseProjectAnnouncementList(QueryAnnouncement queryAnnouncement) {
        List<PurchaseProjectAnnouncement> returnList = new ArrayList<>();
        //资格预审公告 招标公告release 中标候选人公示 中标结果公示
        BReleaseAnnouncementCriteria criteria = new BReleaseAnnouncementCriteria();
        BReleaseAnnouncementCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andProcurementProjectIdEqualTo(queryAnnouncement.getProcurementProjectId());
        subCriteria.andProcessStatusNotEqualTo(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode());
        List<BReleaseAnnouncement> bReleaseAnnouncementList = bReleaseAnnouncementMapper.selectByExample(criteria);
        for (BReleaseAnnouncement item : bReleaseAnnouncementList) {
            PurchaseProjectAnnouncement pojo = new PurchaseProjectAnnouncement();
            pojo.setFilePath(item.getBiddingDocumentsUrl());
            pojo.setName(item.getTitle());
            pojo.setType(AnnouncementEnum.RELEASE.getCode());
            returnList.add(pojo);
        }

        TWinBidNominateCriteria nominateCriteria = new TWinBidNominateCriteria();
        TWinBidNominateCriteria.Criteria subNominateCriteria = nominateCriteria.createCriteria();
        subNominateCriteria.andPurchaseProjectIdEqualTo(queryAnnouncement.getProcurementProjectId());
        subNominateCriteria.andProcessStatusNotEqualTo(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode());
        List<TWinBidNominate> winBidNominateList = tWinBidNominateMapper.selectByExample(nominateCriteria);
        for (TWinBidNominate item : winBidNominateList) {
            PurchaseProjectAnnouncement pojo = new PurchaseProjectAnnouncement();
            pojo.setFilePath(item.getFilePath());
            pojo.setType(AnnouncementEnum.BID_CANDIDATE_PUBLICITY.getCode());
            returnList.add(pojo);
        }
        return Result.success(returnList);
    }

    @Override
    public Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(String type) {
        List<PurchaseProjectAnnouncementOfficialNetwork> returnList = new ArrayList<>();
        //预告
        if(type.equals("preview")){
            TBiddingPreviewCriteria criteria = new TBiddingPreviewCriteria();
            TBiddingPreviewCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andStatusEqualTo(BiddingPreviewStatusEnum.RELEASE.getCode());
            List<TBiddingPreview> tBiddingPreviewList = tBiddingPreviewMapper.selectByExample(criteria);
            //采购人公司 TODO
            for (TBiddingPreview item : tBiddingPreviewList) {
                PurchaseProjectAnnouncementOfficialNetwork pojo = new PurchaseProjectAnnouncementOfficialNetwork();
                BeanUtils.copyProperties(item, pojo);
                returnList.add(pojo);
            }
        }
        //公告
        if(type.equals("announcement")){
            BReleaseAnnouncementCriteria criteria = new BReleaseAnnouncementCriteria();
            BReleaseAnnouncementCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andProcessStatusEqualTo(BiddingPreviewStatusEnum.RELEASE.getCode());
            List<BReleaseAnnouncement> bReleaseAnnouncementList = bReleaseAnnouncementMapper.selectByExample(criteria);
            for (BReleaseAnnouncement item : bReleaseAnnouncementList) {
                PurchaseProjectAnnouncementOfficialNetwork pojo = new PurchaseProjectAnnouncementOfficialNetwork();
                BeanUtils.copyProperties(item, pojo);
                returnList.add(pojo);
            }
        }
        return Result.success();
    }


}
