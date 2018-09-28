package com.epc.platform.service.service.reviewexpert.impl;

import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.platform.service.domain.reviewexpertr.*;
import com.epc.platform.service.service.reviewexpert.ExpertService;

import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.mapper.reviewexpertr.TExpertAttachmentMapper;
import com.epc.platform.service.mapper.reviewexpertr.TExpertBasicInfoMapper;
import com.epc.platform.service.mapper.reviewexpertr.TExpertDetailInfoMapper;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import org.apache.commons.lang.StringUtils;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo) {
        TExpertBasicInfo pojo = new TExpertBasicInfo();
        Date date = new Date();
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setPassword("123456");
        pojo.setName(userBasicInfo.getUsername());
        pojo.setState(Const.STATE.REGISTERED);
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        BeanUtils.copyProperties(reviewExpertHandle, tExpertDetailInfo);
        Date date = new Date();
        tExpertDetailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        tExpertDetailInfo.setCreateAt(date);
        tExpertDetailInfo.setUpdateAt(date);
        TExpertAttachment attachment = new TExpertAttachment();
        attachment.setExpertId(reviewExpertHandle.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            //公司名称
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(reviewExpertHandle.getCertificateOfAuthorization());
            tExpertAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(reviewExpertHandle.getOperatorIdCardFront());
            tExpertAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            System.out.println();
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(reviewExpertHandle.getLegalIdCardOther());
            tExpertAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(reviewExpertHandle.getLegalIdCardPositive());
            tExpertAttachmentMapper.insertSelective(attachment);

            //资质证书url
            for (String qualificationCertificate : reviewExpertHandle.getQualificationCertificateList()) {
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateFilePath(qualificationCertificate);
                tExpertAttachmentMapper.insertSelective(attachment);
            }
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(reviewExpertHandle.getBusinessLicense());
            return Result.success(tExpertAttachmentMapper.insertSelective(attachment)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertExpertDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertExpertDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> deleteExpertDetailInfo(Long whereId) {
        TExpertDetailInfo tExpertDetailInfo =new TExpertDetailInfo();
        tExpertDetailInfo.setId(whereId);
        tExpertDetailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tExpertDetailInfoMapper.deleteByKey(tExpertDetailInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException deleteExpertDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

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


    @Override
    public List<TExpertDetailInfo> selectAllExpertByPage(QueryDetailIfo queryDetailIfo) {
        try {
            TExpertDetailInfoCriteria criteria = new TExpertDetailInfoCriteria();
            criteria.setOrderByClause("id desc");
            if(queryDetailIfo.getWhereName()!=null){
                criteria.createCriteria().andCompanyNameEqualTo(queryDetailIfo.getWhereName());
            }            return tExpertDetailInfoMapper.selectByExample(criteria);
        } catch (Exception e) {
            LOGGER.error("BusinessException selectByExample : {}", e);
            e.printStackTrace();
            return  new ArrayList<>();
        }
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
}
