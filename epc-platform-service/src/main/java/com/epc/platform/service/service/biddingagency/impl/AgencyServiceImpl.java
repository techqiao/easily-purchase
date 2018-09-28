package com.epc.platform.service.service.biddingagency.impl;

import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.administration.facade.biddingagency.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.tagency.*;
import com.epc.platform.service.mapper.tagency.TAgencyAttachmentMapper;
import com.epc.platform.service.mapper.tagency.TAgencyBasicInfoMapper;
import com.epc.platform.service.mapper.tagency.TAgencyDetailInfoMapper;
import com.epc.platform.service.service.biddingagency.AgencyService;
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
 * <p>Description : 招标代理机构接口实现类
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
@Service
public class AgencyServiceImpl implements AgencyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyServiceImpl.class);

    @Autowired
    private TAgencyBasicInfoMapper tAgencyBasicInfoMapper;
    @Autowired
    private TAgencyDetailInfoMapper tAgencyDetailInfoMapper;
    @Autowired
    private TAgencyAttachmentMapper tAgencyAttachmentMapper;

    /**
     * 新增招标代理机构基本信息
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertBiddingAgencyBasicInfo(UserBasicInfo userBasicInfo) {
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        Date date = new Date();
        tAgencyBasicInfo.setCellphone(userBasicInfo.getCellphone());
        tAgencyBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tAgencyBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        tAgencyBasicInfo.setPassword("123456");
        tAgencyBasicInfo.setCreateAt(date);
        tAgencyBasicInfo.setUpdateAt(date);
        tAgencyBasicInfo.setState(Const.STATE.PERFECTING);
        int i = tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo);

        try {
            return Result.success(tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException inserttAgencyBasicInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException inserttAgencyBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }
    /**
     * 新增招标代理机构补全信息
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertBiddingAgencyDetailInfo(BiddingHandle biddingHandle) {
        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
        BeanUtils.copyProperties(biddingHandle, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        TAgencyAttachment attachment = new TAgencyAttachment();
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        TAgencyBasicInfo tAgencyBasicInfo= new TAgencyBasicInfo();
        tAgencyBasicInfo.setState(Const.STATE.COMMITTED);
        tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo);
        try {
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(biddingHandle.getCertificateOfAuthorization());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(biddingHandle.getOperatorIdCardFront());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(biddingHandle.getLegalIdCardOther());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(biddingHandle.getLegalIdCardPositive());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //资质证书url
            for (String qualificationCertificate : biddingHandle.getQualificationCertificateList()) {
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateFilePath(qualificationCertificate);
                 Result.success(tAgencyAttachmentMapper.insertSelective(attachment)>0);
            }
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(biddingHandle.getBusinessLicense());
            return Result.success(tAgencyAttachmentMapper.insertSelective(attachment)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException inserttAgencyDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException inserttAgencyDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**
     * 删除招标代理机构
     * @param
     * @return
     */
    @Override
    public Result<Boolean> deleteBiddingAgencyDetailInfo(Long  whereId) {
        TAgencyDetailInfo tAgencyDetailInfo = new TAgencyDetailInfo();
        tAgencyDetailInfo.setId(whereId);
        tAgencyDetailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tAgencyDetailInfoMapper.updateByPrimaryKeySelective(tAgencyDetailInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }
    /**
     * 查询招标代理机构基本信息
     * @param
     * @return
     */
    @Override
    public Result queryBiddingAgencyDetailInfo(Long whereId) {
            try {
                TAgencyDetailInfo tAgencyDetailInfo = tAgencyDetailInfoMapper.selectByPrimaryKey(whereId);
                return Result.success(tAgencyDetailInfo);
            } catch (BusinessException e) {
                LOGGER.error("BusinessException deleteByPrimaryKey : {}", e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }
    }
    /**
     * 查询所有招标代理机构 分页
     * @param queryDetailIfo
     * @return
     */
    @Override
    public List<TAgencyDetailInfo> selectAllAgencyByPage(QueryDetailIfo queryDetailIfo) {
        try {
            final TAgencyDetailInfoCriteria criteria = new TAgencyDetailInfoCriteria();
            criteria.setOrderByClause("id desc");
            if(queryDetailIfo.getWhereName()!=null){
                TAgencyDetailInfoCriteria.Criteria subCriteria = criteria.createCriteria();
                subCriteria.andCompanyNameEqualTo(queryDetailIfo.getWhereName());
            }
            return tAgencyDetailInfoMapper.selectByExample(criteria);
        } catch (Exception e) {
            LOGGER.error("获取招标代理机构信息失败", e);
            return new ArrayList<>();
        }
    }

    /**
     * 审核招标代理机构
     * @param examineAgencyHandle
     * @return
     */
    @Override
    public Result<Boolean> examineAgency(ExamineAgencyHandle examineAgencyHandle) {

        TAgencyBasicInfo tAgencyBasicInfo= new TAgencyBasicInfo();
        TAgencyBasicInfoCriteria criteria = new TAgencyBasicInfoCriteria();
         criteria.createCriteria().andIdEqualTo(examineAgencyHandle.getAgencyId());
        tAgencyBasicInfo.setState(examineAgencyHandle.getState());
        tAgencyBasicInfo.setUpdateAt(new Date());
        return Result.success(tAgencyBasicInfoMapper.updateByExampleSelective(tAgencyBasicInfo,criteria)>0);
    }
}
