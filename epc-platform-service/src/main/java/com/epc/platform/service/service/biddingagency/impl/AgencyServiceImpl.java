package com.epc.platform.service.service.biddingagency.impl;
import com.epc.administration.facade.biddingagency.handle.*;
import com.epc.administration.facade.biddingagency.vo.AgencyAttachmentVO;

import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.vo.AgencyUserAttachmentVO;
import com.epc.administration.facade.biddingagency.vo.BiddingAgencyVO;
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
        tAgencyBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tAgencyBasicInfo.setCreateAt(date);
        tAgencyBasicInfo.setName(userBasicInfo.getUsername());
        tAgencyBasicInfo.setUpdateAt(date);
        tAgencyBasicInfo.setState(Const.STATE.PERFECTING);
        tAgencyBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        tAgencyBasicInfo.setInviterId(userBasicInfo.getId());
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
        Date date = new Date();
        detailInfo.setAgencyId(biddingHandle.getId());
        detailInfo.setCompanyName(biddingHandle.getCompanyName());
        detailInfo.setUniformCreditCode(biddingHandle.getUniformCreditCode());
        detailInfo.setPublicBankName(biddingHandle.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(biddingHandle.getPublicBanAccountNumber());
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        TAgencyAttachment attachment = new TAgencyAttachment();
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        attachment.setAgencyId(biddingHandle.getId());
        try {
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(biddingHandle.getLegalIdCardOther());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(biddingHandle.getLegalIdCardPositive());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(biddingHandle.getBusinessLicense());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //资质证书url
            List<AttachmentHandle> clientAttachmentHandles = biddingHandle.getClientAttachmentHandles();
            if(clientAttachmentHandles!=null){
                for (AttachmentHandle attachmentHandle : clientAttachmentHandles) {
                    attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                    attachment.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                    attachment.setCertificateName(attachmentHandle.getCertificateName());
                    tAgencyAttachmentMapper.insertSelective(attachment);
                }
            }
            TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
            tAgencyBasicInfo.setId(biddingHandle.getId());
            tAgencyBasicInfo.setState(Const.STATE.COMMITTED);
            return Result.success(tAgencyBasicInfoMapper.updateByPrimaryKeySelective(tAgencyBasicInfo)>0);
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
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        tAgencyBasicInfo.setId(whereId);
        tAgencyBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tAgencyBasicInfoMapper.updateByPrimaryKeySelective(tAgencyBasicInfo)>0);
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
    public Result<AgencyUserAttachmentVO> queryBiddingAgencyDetailInfo(Long whereId) {

            try {
                TAgencyBasicInfo tAgencyBasicInfo = tAgencyBasicInfoMapper.selectByPrimaryKey(whereId);

                TAgencyDetailInfoCriteria criteria = new TAgencyDetailInfoCriteria();
                criteria.createCriteria().andAgencyIdEqualTo(whereId);



                TAgencyAttachmentCriteria tAgencyAttachmentCriteria = new TAgencyAttachmentCriteria();
                tAgencyAttachmentCriteria.createCriteria().andAgencyIdEqualTo(whereId);

                List<TAgencyAttachment> tAgencyAttachments = tAgencyAttachmentMapper.selectByExample(tAgencyAttachmentCriteria);

                AgencyUserAttachmentVO agencyUserAttachmentVO = new AgencyUserAttachmentVO();
                agencyUserAttachmentVO.setId(whereId);
                TAgencyDetailInfo tAgencyDetailInfo = tAgencyDetailInfoMapper.selectByExample(criteria).get(0);
                if(tAgencyDetailInfo!=null){
                    agencyUserAttachmentVO.setCompanyName(tAgencyDetailInfo.getCompanyName());
                    agencyUserAttachmentVO.setUniformCreditCode(tAgencyDetailInfo.getUniformCreditCode());
                    agencyUserAttachmentVO.setPublicBankName(tAgencyDetailInfo.getPublicBankName());
                    agencyUserAttachmentVO.setPublicBanAccountNumber(tAgencyDetailInfo.getPublicBanAccountNumber());

                }
                agencyUserAttachmentVO.setCreateAt(new Date());
                agencyUserAttachmentVO.setIsDeleted(tAgencyBasicInfo.getIsDeleted());
                agencyUserAttachmentVO.setCellphone(tAgencyBasicInfo.getCellphone());
                agencyUserAttachmentVO.setState(tAgencyBasicInfo.getState());
                agencyUserAttachmentVO.setName(tAgencyBasicInfo.getName());
                List<AgencyAttachmentVO> agencyAttachmentVOS = new ArrayList<>();

                for (TAgencyAttachment tAgencyAttachment : tAgencyAttachments) {
                    AgencyAttachmentVO agencyAttachmentVO = new AgencyAttachmentVO();
                    agencyAttachmentVO.setCertificateFilePath(tAgencyAttachment.getCertificateFilePath());
                    agencyAttachmentVO.setCertificateName(tAgencyAttachment.getCertificateName());
                    agencyAttachmentVO.setCertificateType(tAgencyAttachment.getCertificateType());
                    agencyAttachmentVOS.add(agencyAttachmentVO);
                }
                agencyUserAttachmentVO.setAgencyAttachmentVOS(agencyAttachmentVOS);
                return Result.success(agencyUserAttachmentVO);
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
    public List<BiddingAgencyVO> selectAllAgencyByPage(QueryDetailIfo queryDetailIfo) {
        return  tAgencyDetailInfoMapper.selectByPage(queryDetailIfo);
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

    /**
     * 锁定招标代理机构
     * @param agencyForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenAgencyUser(AgencyForbiddenHandle agencyForbiddenHandle) {
        TAgencyBasicInfo tAgencyBasicInfo= new TAgencyBasicInfo();
        tAgencyBasicInfo.setId(agencyForbiddenHandle.getId());
        tAgencyBasicInfo.setIsForbidden(agencyForbiddenHandle.getIsForbidden());
        return Result.success(tAgencyBasicInfoMapper.updateByPrimaryKeySelective(tAgencyBasicInfo)>0);
    }
}
