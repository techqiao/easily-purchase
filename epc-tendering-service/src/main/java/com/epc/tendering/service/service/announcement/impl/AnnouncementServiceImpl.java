package com.epc.tendering.service.service.announcement.impl;

import com.epc.common.Result;
import com.epc.common.constants.AnnouncementEnum;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncement;
import com.epc.tendering.service.domain.announcement.BReleaseAnnouncementCriteria;
import com.epc.tendering.service.domain.bid.TWinBidNominate;
import com.epc.tendering.service.domain.bid.TWinBidNominateCriteria;
import com.epc.tendering.service.mapper.announcement.BReleaseAnnouncementMapper;
import com.epc.tendering.service.mapper.bid.TWinBidNominateMapper;
import com.epc.tendering.service.service.announcement.AnnouncementService;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
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
        if(AnnouncementProcessStatusEnum.NOT_SUBMIT.equals(handleAnnouncementStatus.getProcessStatus())){
            //待审核
            bReleaseAnnouncement.setAnnouncementContent(AnnouncementProcessStatusEnum.AUDITING.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        if(AnnouncementProcessStatusEnum.AUDITING.getCode().equals(handleAnnouncementStatus.getProcessStatus())){
            //待批复
            bReleaseAnnouncement.setAnnouncementContent(AnnouncementProcessStatusEnum.REPLY.getCode());
            bReleaseAnnouncement.setAuditorId(handleAnnouncementStatus.getOperateId());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        if(AnnouncementProcessStatusEnum.REPLY.getCode().equals(handleAnnouncementStatus.getProcessStatus())) {
            //待发布
            bReleaseAnnouncement.setRepliesId(handleAnnouncementStatus.getOperateId());
            bReleaseAnnouncement.setAnnouncementContent(AnnouncementProcessStatusEnum.WAIT_RELEASE.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        if(AnnouncementProcessStatusEnum.WAIT_RELEASE.getCode().equals(handleAnnouncementStatus.getProcessStatus())){
            //已发布
            bReleaseAnnouncement.setOperateId(handleAnnouncementStatus.getOperateId());
            bReleaseAnnouncement.setAnnouncementContent(AnnouncementProcessStatusEnum.RELEASED.getCode());
            return Result.success(bReleaseAnnouncementMapper.updateByPrimaryKeySelective(bReleaseAnnouncement) > 0);
        }
        return Result.success();
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


}
