package com.epc.tendering.service.service.preview.impl;

import com.epc.common.Result;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncement;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncementCriteria;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipant;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantCriteria;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermission;
import com.epc.tendering.service.domain.participant.TPurchaseProjectParticipantPermissionCriteria;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfoCriteria;
import com.epc.tendering.service.mapper.announcement.BReleaseAnnouncementMapper;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantMapper;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantPermissionMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.service.preview.ProJectByPermissionService;
import com.epc.web.facade.terdering.preview.handle.ProJectPermissionHandle;
import com.epc.web.facade.terdering.preview.vo.ProJectPermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 10:48
 * <p>@Author : luozhixin
 * <p>ProJectByPermissionServiceImpl
 */
@Service
public class ProJectByPermissionServiceImpl implements ProJectByPermissionService {
    @Autowired
    private TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    private TPurchaseProjectParticipantMapper tPurchaseProjectParticipantMapper;
    @Autowired
    private TPurchaseProjectParticipantPermissionMapper tPurchaseProjectParticipantPermissionMapper;
    @Autowired
    private BReleaseAnnouncementMapper bReleaseAnnouncementMapper;
    /**
     * 根据登入者 审核 批复权限查询对应项目的详情
     * @param proJectPermissionHandle
     * @return
     */
    @Override
    public Result<List<ProJectPermissionVO>> getProJectListByPermission(ProJectPermissionHandle proJectPermissionHandle) {
        //查询用户对应的采购项目 招标流程:采购项目表
        TPurchaseProjectParticipantCriteria criteria = new TPurchaseProjectParticipantCriteria();
        TPurchaseProjectParticipantCriteria.Criteria subCriterid = criteria.createCriteria();
        subCriterid.andUserIdEqualTo(proJectPermissionHandle.getUserId());
        List<TPurchaseProjectParticipant> tPurchaseProjectParticipants =tPurchaseProjectParticipantMapper.selectByExample(criteria);
        //查询对应项目应有的权限 招标流程:采购项目参与人权限表
        TPurchaseProjectParticipantPermissionCriteria permissionCriteria = new TPurchaseProjectParticipantPermissionCriteria();
        TPurchaseProjectParticipantPermissionCriteria.Criteria subpermissionCriteria = permissionCriteria.createCriteria();
        for (int i = 0; i < tPurchaseProjectParticipants.size(); i++) {
            subpermissionCriteria.andParticipantIdEqualTo(proJectPermissionHandle.getUserId());
        }
        List<TPurchaseProjectParticipantPermission> tPurchaseProjectParticipantPermissions =
                tPurchaseProjectParticipantPermissionMapper.selectByExample(permissionCriteria);
        //查询对应的项目信息 招标流程:采购项目表
        TPurchaseProjectBasicInfoCriteria basicInfoCriteria = new TPurchaseProjectBasicInfoCriteria();
        TPurchaseProjectBasicInfoCriteria.Criteria subBasicInfoCriteria = basicInfoCriteria.createCriteria();
        for (int i = 0; i < tPurchaseProjectParticipants.size(); i++) {
            subBasicInfoCriteria.andPurchaseProjectCodeEqualTo(tPurchaseProjectParticipants.get(i).getPurchaseProjectId().toString());
        }
        List<TPurchaseProjectBasicInfo> tPurchaseProjectBasicInfos = tPurchaseProjectBasicInfoMapper.selectByExample(basicInfoCriteria);
        //查询对应的公告信息 招标流程:发布招标公告
        BReleaseAnnouncementCriteria brCriteria = new BReleaseAnnouncementCriteria();
        BReleaseAnnouncementCriteria.Criteria subBrCriteria = brCriteria.createCriteria();
        for (int i = 0; i < tPurchaseProjectParticipants.size(); i++) {
            subBrCriteria.andProcurementProjectIdEqualTo(tPurchaseProjectParticipants.get(i).getPurchaseProjectId());
        }
        List<BReleaseAnnouncement> bReleaseAnnouncements = bReleaseAnnouncementMapper.selectByExample(brCriteria);
        //返回前台需要信息 写入VO 返回
        List<ProJectPermissionVO> proJectPermissionVOS = new LinkedList<>();
        ProJectPermissionVO proJectPermissionVO = new ProJectPermissionVO();
        for (int i = 0; i < tPurchaseProjectParticipants.size(); i++) {
            //采购项目表
            proJectPermissionVO.setAgencyName(tPurchaseProjectParticipants.get(i).getAgencyName());
            proJectPermissionVO.setUserName(tPurchaseProjectParticipants.get(i).getUserName());
            proJectPermissionVO.setUserPhone(tPurchaseProjectParticipants.get(i).getUserPhone());
            proJectPermissionVO.setOperateId(tPurchaseProjectParticipants.get(i).getOperateId());
            //采购项目参与人权限表
            proJectPermissionVO.setParticipantPermission( tPurchaseProjectParticipantPermissions.get(i).getParticipantPermission());
           //采购项目表
            proJectPermissionVO.setAnnouncementContent(bReleaseAnnouncements.get(i).getAnnouncementContent());
            proJectPermissionVO.setBiddingDocumentsUrl( bReleaseAnnouncements.get(i).getBiddingDocumentsUrl());
            proJectPermissionVO.setBiddingEnd(bReleaseAnnouncements.get(i).getBiddingStart());
            proJectPermissionVO.setBiddingEnd( bReleaseAnnouncements.get(i).getBiddingEnd());
            proJectPermissionVO.setProcessStatus(bReleaseAnnouncements.get(i).getProcessStatus());
            //发布招标公告
            proJectPermissionVO.setProjectName( tPurchaseProjectBasicInfos.get(i).getPurchaseProjectName());
            proJectPermissionVO.setPurchaseProjectCode(tPurchaseProjectBasicInfos.get(i).getPurchaseProjectCode());
            proJectPermissionVO.setProjectName(tPurchaseProjectBasicInfos.get(i).getProjectName());
            proJectPermissionVO.setPurchaseStartTime( tPurchaseProjectBasicInfos.get(i).getPurchaseStartTime());
            proJectPermissionVO.setPurchaseEndTime( tPurchaseProjectBasicInfos.get(i).getPurchaseEndTime());
            proJectPermissionVO.setPurchaseProjectBudgetaryAmount(tPurchaseProjectBasicInfos.get(i).getPurchaseProjectBudgetaryAmount());
            proJectPermissionVO.setPurchaseMode(tPurchaseProjectBasicInfos.get(i).getPurchaseMode());
            proJectPermissionVO.setPurchaseCategory(tPurchaseProjectBasicInfos.get(i).getPurchaseCategory());
            proJectPermissionVO.setPurchaseType(tPurchaseProjectBasicInfos.get(i).getPurchaseType());
            proJectPermissionVO.setPurchaseRange(tPurchaseProjectBasicInfos.get(i).getPurchaseRange());
            proJectPermissionVO.setPurchaseProjectStatus(tPurchaseProjectBasicInfos.get(i).getPurchaseProjectStatus());
            proJectPermissionVO.setIsAdjust( tPurchaseProjectBasicInfos.get(i).getIsAdjust());
            proJectPermissionVO.setIsOtherAgency(tPurchaseProjectBasicInfos.get(i).getIsOtherAgency());
            proJectPermissionVOS.add(proJectPermissionVO);
        }
        return Result.success(proJectPermissionVOS);
    }
}
