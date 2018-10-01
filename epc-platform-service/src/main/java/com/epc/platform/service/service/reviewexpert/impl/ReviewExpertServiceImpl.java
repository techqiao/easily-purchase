package com.epc.platform.service.service.reviewexpert.impl;

import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.*;
import com.epc.administration.facade.reviewexpert.vo.ReviewExpertVO;
import com.epc.platform.service.domain.expert.*;
import com.epc.platform.service.mapper.reviewexpert.TExpertAttachmentMapper;
import com.epc.platform.service.mapper.reviewexpert.TExpertBasicInfoMapper;
import com.epc.platform.service.mapper.reviewexpert.TExpertDetailInfoMapper;
import com.epc.platform.service.service.reviewexpert.ExpertService;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

/**
 * 评审专家实现接口
 * @author luozhixin
 * @date 2018-9-19 20:30:00
 */
@Service
public class ReviewExpertServiceImpl implements ExpertService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Autowired
    private TExpertBasicInfoMapper tExpertBasicInfoMapper;

    @Autowired
    private TExpertDetailInfoMapper tExpertDetailInfoMapper;

    @Autowired
    private TExpertAttachmentMapper tExpertAttachmentMapper;

    /**
     * 注册专家
     *
     * @param userBasicInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo) {
        TExpertBasicInfo pojo = new TExpertBasicInfo();
        pojo.setName(userBasicInfo.getUsername());
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setCreateAt(new Date());
        pojo.setUpdateAt(new Date());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setInviterId(userBasicInfo.getId());
        pojo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        try {
            return Result.success(tExpertBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertExpertBasicInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertExpertBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * 完善专家信息
     *
     * @param reviewExpertHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        tExpertDetailInfo.setExpertId(reviewExpertHandle.getId());
        tExpertDetailInfo.setCompanyName(reviewExpertHandle.getName());
        tExpertDetailInfo.setUniformCreditCode(reviewExpertHandle.getUniformCreditCode());
        tExpertDetailInfo.setPublicBankName(reviewExpertHandle.getPublicBankName());
        tExpertDetailInfo.setPublicBanAccountNumber(reviewExpertHandle.getPublicBanAccountNumber());
        tExpertDetailInfo.setCreateAt(new Date());
        tExpertDetailInfo.setUpdateAt(new Date());
        tExpertDetailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        TExpertAttachment attachment = new TExpertAttachment();
        attachment.setExpertId(reviewExpertHandle.getId());
        attachment.setCreateAt(new Date());
        attachment.setUpdateAt(new Date());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            //完善补全信息
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            //上传身份证正面
            attachment.setCertificateFilePath(reviewExpertHandle.getLegalIdCardPositive());
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            tExpertAttachmentMapper.insertSelective(attachment);
            //上传身份证反面
            attachment.setCertificateFilePath(reviewExpertHandle.getLegalIdCardOther());
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            for (AttachmentHandle attachmentHandle : reviewExpertHandle.getAttachmentHandleList()) {
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                attachment.setCertificateName(attachmentHandle.getCertificateName());
                tExpertAttachmentMapper.insertSelective(attachment);
            }
            //完善基本信息
            TExpertBasicInfo tExpertBasicInfo = new TExpertBasicInfo();
            tExpertBasicInfo.setId(reviewExpertHandle.getId());
            tExpertBasicInfo.setName(reviewExpertHandle.getName());
            tExpertBasicInfo.setProfession(reviewExpertHandle.getProfession());
            tExpertBasicInfo.setLevel(reviewExpertHandle.getLevel());
            tExpertBasicInfo.setCircularDt(reviewExpertHandle.getCircularDt());
            tExpertBasicInfo.setCircularMethod(reviewExpertHandle.getCircularMethod());
            tExpertBasicInfo.setOtherInformation(reviewExpertHandle.getOtherInformation());
            tExpertBasicInfo.setState(Const.STATE.COMMITTED);
            tExpertBasicInfo.setUpdateAt(new Date());
            tExpertBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            return Result.success(tExpertBasicInfoMapper.updateByPrimaryKeySelective(tExpertBasicInfo)>0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertExpertDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertExpertDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }


    /**
     * 删除评审专家
     * @param whereId
     * @return
     */
    @Override
    public Result<Boolean> deleteExpertDetailInfo(Long whereId) {
        TExpertBasicInfo tExpertBasicInfo =new TExpertBasicInfo();
        tExpertBasicInfo.setId(whereId);
        tExpertBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tExpertBasicInfoMapper.updateByPrimaryKeySelective(tExpertBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException deleteExpertDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 查询专家基本信息
     * @param whereId
     * @return
     */
    @Override
    public Result<TExpertDetailInfo> queryExpertDetailInfo( Long whereId) {
        try {
            TExpertDetailInfo tExpertDetailInfo = tExpertDetailInfoMapper.selectByPrimaryKey(whereId);
            return Result.success(tExpertDetailInfo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException queryExpertDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
    }


    /**
     *分页查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public List<ReviewExpertVO> selectAllExpertByPage(QueryDetailIfo queryDetailIfo) {

        return  tExpertDetailInfoMapper.selectByPage(queryDetailIfo);

    }

    /**
     * 审核评审专家
     * @param examineExpertHandle
     * @return
     */
    @Override
    public Result<Boolean> examineExpert(ExamineExpertHandle examineExpertHandle) {
        TExpertBasicInfo tExpertBasicInfo = new TExpertBasicInfo();
        tExpertBasicInfo.setState(examineExpertHandle.getState());
        TExpertBasicInfoCriteria criteria = new TExpertBasicInfoCriteria();
        criteria.createCriteria().andIdEqualTo(examineExpertHandle.getExpertId());
        return Result.success(tExpertBasicInfoMapper.updateByExampleSelective(tExpertBasicInfo,criteria)>0);
    }

    /**
     * 启用锁定评审专家
     * @param expertForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenExpertUser(ExpertForbiddenHandle expertForbiddenHandle) {
        TExpertBasicInfo tExpertBasicInfo = new TExpertBasicInfo();
        tExpertBasicInfo.setId(expertForbiddenHandle.getId());
        tExpertBasicInfo.setIsForbidden(expertForbiddenHandle.getIsForbidden());
        return Result.success(tExpertBasicInfoMapper.updateByPrimaryKeySelective(tExpertBasicInfo)>0);
    }
}
