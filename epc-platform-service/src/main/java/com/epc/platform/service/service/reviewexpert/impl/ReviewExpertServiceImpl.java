package com.epc.platform.service.service.reviewexpert.impl;
import com.epc.administration.facade.reviewexpert.vo.AttachmentVO;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.*;
import com.epc.administration.facade.reviewexpert.vo.ExpertDetailVO;
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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
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
     * @param userBasicInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo) {
        TExpertBasicInfoCriteria tExpertBasicInfoCriteria = new TExpertBasicInfoCriteria();
        tExpertBasicInfoCriteria.createCriteria().andCellphoneEqualTo(userBasicInfo.getCellphone());
        List<TExpertBasicInfo> tExpertBasicInfos = tExpertBasicInfoMapper.selectByExample(tExpertBasicInfoCriteria);
        if(!tExpertBasicInfos.isEmpty()){
            return Result.success("用户已存在，请直接登录");
        }

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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }
    }

    /**
     * 完善专家信息
     * @param reviewExpertHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        BeanUtils.copyProperties(reviewExpertHandle,tExpertDetailInfo);
        tExpertDetailInfo.setCreateAt(new Date());
        tExpertDetailInfo.setUpdateAt(new Date());
        tExpertDetailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        TExpertAttachment attachment = new TExpertAttachment();
        attachment.setExpertId(reviewExpertHandle.getId());
        attachment.setCreateAt(new Date());
        attachment.setUpdateAt(new Date());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
           //如果已存在详细信息
            TExpertDetailInfoCriteria tExpertDetailInfoCriteria = new TExpertDetailInfoCriteria();
            tExpertDetailInfoCriteria.createCriteria().andExpertIdEqualTo(reviewExpertHandle.getId());
            List<TExpertDetailInfo> tExpertDetailInfos = tExpertDetailInfoMapper.selectByExample(tExpertDetailInfoCriteria);
            //完善补全信息
            if(!tExpertDetailInfos.isEmpty()){
                tExpertDetailInfoMapper.updateByExample(tExpertDetailInfo,tExpertDetailInfoCriteria);
            }else {
                tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            }
            //上传身份证正面
            attachment.setCertificateFilePath(reviewExpertHandle.getLegalIdCardPositive());
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            tExpertAttachmentMapper.insertSelective(attachment);
            //上传身份证反面
            attachment.setCertificateFilePath(reviewExpertHandle.getLegalIdCardOther());
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            tExpertAttachmentMapper.insertSelective(attachment);
            for (AttachmentHandle attachmentHandle : reviewExpertHandle.getAttachmentHandleList()) {
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                attachment.setCertificateName(attachmentHandle.getCertificateName());
                tExpertAttachmentMapper.insertSelective(attachment);
            }
            //完善基本信息
            TExpertBasicInfo tExpertBasicInfo = new TExpertBasicInfo();
            BeanUtils.copyProperties(reviewExpertHandle,tExpertBasicInfo);
            tExpertBasicInfo.setState(Const.STATE.AUDIT_SUCCESS);
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
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }
    /**
     * 修改专家信息
     * @param reviewExpertHandle
     * @return
     */
    @Override
    public Result<Boolean> updateReviewExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        BeanUtils.copyProperties(tExpertDetailInfo,reviewExpertHandle);
        TExpertDetailInfoCriteria  tExpertDetailInfoCriteria = new TExpertDetailInfoCriteria();
        tExpertDetailInfoCriteria.createCriteria().andExpertIdEqualTo(reviewExpertHandle.getId());
        TExpertAttachmentCriteria criteria = new TExpertAttachmentCriteria();
        criteria.createCriteria().andExpertIdEqualTo(reviewExpertHandle.getId());
        try {
            tExpertDetailInfoMapper.updateByExample(tExpertDetailInfo,tExpertDetailInfoCriteria);
            tExpertAttachmentMapper.deleteByExample(criteria);
           return this.insertExpertDetailInfo(reviewExpertHandle);
        } catch (Exception e) {
            LOGGER.error("BusinessException updateReviewExpertDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }
    /**
     * 查询专家基本信息
     * @param whereId
     * @return
     */
    @Override
    public Result<ExpertDetailVO> queryExpertDetailInfo(Long whereId) {
        try {
            TExpertBasicInfo tExpertBasicInfo = tExpertBasicInfoMapper.selectByPrimaryKey(whereId);
            TExpertDetailInfoCriteria criteria = new TExpertDetailInfoCriteria();
            criteria.createCriteria().andExpertIdEqualTo(whereId);
            List<TExpertDetailInfo> tExpertDetailInfos = tExpertDetailInfoMapper.selectByExample(criteria);
            if(tExpertDetailInfos.isEmpty()){
                ExpertDetailVO expertDetailVO = new ExpertDetailVO();
                BeanUtils.copyProperties(tExpertBasicInfo,expertDetailVO);
                return Result.success(expertDetailVO);
            }
            TExpertDetailInfo tExpertDetailInfo = tExpertDetailInfos.get(0);

            ExpertDetailVO expertDetailVO = new ExpertDetailVO();
            List<AttachmentVO> attachmentVOS = new ArrayList<>();
            if(null != tExpertDetailInfo){
                TExpertAttachmentCriteria tExpertAttachmentCriteria = new TExpertAttachmentCriteria();
                tExpertAttachmentCriteria.createCriteria().andExpertIdEqualTo(whereId);
                List<TExpertAttachment> tExpertAttachments = tExpertAttachmentMapper.selectByExample(tExpertAttachmentCriteria);
                for (TExpertAttachment tExpertAttachment : tExpertAttachments) {

                    if(tExpertAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
                        expertDetailVO.setLegalIdCardPositive(tExpertAttachment.getCertificateFilePath());
                    }else if(tExpertAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
                        expertDetailVO.setLegalIdCardOther(tExpertAttachment.getCertificateFilePath());
                    }else {
                        AttachmentVO attachmentVO = new AttachmentVO();
                        attachmentVO.setCertificateName(tExpertAttachment.getCertificateName());
                        attachmentVO.setCertificateFilePath(tExpertAttachment.getCertificateFilePath());
                        attachmentVOS.add(attachmentVO);
                    }
                }
                expertDetailVO.setAttachmentVOList(attachmentVOS);
            }
            BeanUtils.copyProperties(tExpertBasicInfo,expertDetailVO);
            expertDetailVO.setCompanyName(tExpertDetailInfo.getCompanyName());
            expertDetailVO.setCompanyAddress(tExpertDetailInfo.getCompanyAddress());
            return Result.success(expertDetailVO);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException queryExpertDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
    }


    /**
     *分页查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<List<ReviewExpertVO>> selectAllExpertByPage(QueryDetailIfo queryDetailIfo) {
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(where)){
            where="%"+where+"%";
            queryDetailIfo.setWhere(where);
        }else{
            queryDetailIfo.setWhere(null);
        }
        return Result.success(tExpertDetailInfoMapper.selectByPage(queryDetailIfo)) ;

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
