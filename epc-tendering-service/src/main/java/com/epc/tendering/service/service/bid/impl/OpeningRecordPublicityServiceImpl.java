package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.common.constants.ParticipantPermissionEnum;
import com.epc.tendering.service.domain.bid.TOpeningRecordPublicity;
import com.epc.tendering.service.mapper.bid.TOpeningRecordPublicityMapper;
import com.epc.tendering.service.service.bid.OpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:52
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OpeningRecordPublicityServiceImpl implements OpeningRecordPublicityService {

    @Autowired
    private TOpeningRecordPublicityMapper tOpeningRecordPublicityMapper;

    @Override
    public Result<Boolean> insertOpeningRecordPublicity(HandOpeningRecordPublicity handOpeningRecordPublicity) {
        if(handOpeningRecordPublicity.getId() == null){
            TOpeningRecordPublicity tOpeningRecordPublicity = new TOpeningRecordPublicity();
            BeanUtils.copyProperties(handOpeningRecordPublicity, tOpeningRecordPublicity);
            return Result.success(tOpeningRecordPublicityMapper.insertSelective(tOpeningRecordPublicity) > 0);
        }
        if(handOpeningRecordPublicity.getId()!=null){
            String processStatus = tOpeningRecordPublicityMapper.getProcessStatus(handOpeningRecordPublicity.getId());
            //状态为未提交 或者发布 为修改
            if(handOpeningRecordPublicity.getProcessStatus().equals(AnnouncementProcessStatusEnum.WAIT_RELEASE.getCode())
                    || handOpeningRecordPublicity.getProcessStatus().equals(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode())){
                TOpeningRecordPublicity tOpeningRecordPublicity = new TOpeningRecordPublicity();
                BeanUtils.copyProperties(handOpeningRecordPublicity, tOpeningRecordPublicity);
                return Result.success(tOpeningRecordPublicityMapper.updateByPrimaryKeySelective(tOpeningRecordPublicity) > 0);
            }
            //审核
            if(processStatus.equals(AnnouncementProcessStatusEnum.AUDITING.getCode())
                    && handOpeningRecordPublicity.getProcessStatus().equals(AnnouncementProcessStatusEnum.REPLY.getCode())) {
                TOpeningRecordPublicity tOpeningRecordPublicity = new TOpeningRecordPublicity();
                BeanUtils.copyProperties(handOpeningRecordPublicity, tOpeningRecordPublicity);
                //审核人
                tOpeningRecordPublicity.setAuditorId(handOpeningRecordPublicity.getAuditorId());
                return Result.success(tOpeningRecordPublicityMapper.updateByPrimaryKeySelective(tOpeningRecordPublicity) > 0);
            }
            //批复
            if(processStatus.equals(AnnouncementProcessStatusEnum.REPLY.getCode())
                    && handOpeningRecordPublicity.getProcessStatus().equals(AnnouncementProcessStatusEnum.WAIT_RELEASE.getCode())) {
                TOpeningRecordPublicity tOpeningRecordPublicity = new TOpeningRecordPublicity();
                BeanUtils.copyProperties(handOpeningRecordPublicity, tOpeningRecordPublicity);
                //批复人
                tOpeningRecordPublicity.setRepliesId(handOpeningRecordPublicity.getAuditorId());
                return Result.success(tOpeningRecordPublicityMapper.updateByPrimaryKeySelective(tOpeningRecordPublicity) > 0);
            }

        }
        return Result.success();
    }
}
