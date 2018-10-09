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
import com.epc.common.util.MD5Util;
import com.epc.platform.service.domain.tagency.*;
import com.epc.platform.service.mapper.tagency.TAgencyAttachmentMapper;
import com.epc.platform.service.mapper.tagency.TAgencyBasicInfoMapper;
import com.epc.platform.service.mapper.tagency.TAgencyDetailInfoMapper;
import com.epc.platform.service.service.biddingagency.AgencyService;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.security.provider.MD5;

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
        TAgencyBasicInfoCriteria tAgencyBasicInfoCriteria = new TAgencyBasicInfoCriteria();
        tAgencyBasicInfoCriteria.createCriteria().andCellphoneEqualTo(userBasicInfo.getCellphone());
        List<TAgencyBasicInfo> tAgencyBasicInfos = tAgencyBasicInfoMapper.selectByExample(tAgencyBasicInfoCriteria);
        if(!tAgencyBasicInfos.isEmpty()){
            return Result.success("用户已存在，请直接登录");
        }
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        Date date = new Date();
        BeanUtils.copyProperties(userBasicInfo,tAgencyBasicInfo);
        tAgencyBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tAgencyBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tAgencyBasicInfo.setCreateAt(date);
        tAgencyBasicInfo.setUpdateAt(date);
        tAgencyBasicInfo.setState(Const.STATE.REGISTERED);
        tAgencyBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        try {
            return Result.success(tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertBiddingAgencyBasicInfo : {}",tAgencyBasicInfo.toString(), e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.MD5EncodeUtf8("epc1688"));
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
        BeanUtils.copyProperties(biddingHandle,detailInfo);
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
            tAgencyBasicInfo.setState(Const.STATE.AUDIT_SUCCESS);

            return Result.success(tAgencyBasicInfoMapper.updateByPrimaryKeySelective(tAgencyBasicInfo)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertBiddingAgencyDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertBiddingAgencyDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**
     * 修改招标代理机构补全信息
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateBiddingAgencyDetailInfo(BiddingHandle biddingHandle) {
        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
        TAgencyDetailInfoCriteria tAgencyDetailInfoCriteria = new TAgencyDetailInfoCriteria();
        tAgencyDetailInfoCriteria.createCriteria().andAgencyIdEqualTo(biddingHandle.getId());
        Date date = new Date();
        //详情
        BeanUtils.copyProperties(biddingHandle,detailInfo);
        detailInfo.setUpdateAt(date);
        TAgencyAttachment attachment = new TAgencyAttachment();
        attachment.setUpdateAt(date);
        try {
            List<TAgencyDetailInfo> tAgencyDetailInfos = tAgencyDetailInfoMapper.selectByExample(tAgencyDetailInfoCriteria);
            if(tAgencyDetailInfos.isEmpty()){
                tAgencyDetailInfoMapper.insertSelective(detailInfo);
            }else {
                tAgencyDetailInfoMapper.updateByExampleSelective(detailInfo,tAgencyDetailInfoCriteria);
            }
            TAgencyAttachmentCriteria criteria = new TAgencyAttachmentCriteria();
            criteria.createCriteria().andAgencyIdEqualTo(biddingHandle.getId());
            List<TAgencyAttachment> tAgencyAttachments = tAgencyAttachmentMapper.selectByExample(criteria);
            if(!tAgencyAttachments.isEmpty()){
                tAgencyAttachmentMapper.deleteByExample(criteria);
            }
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
                    attachment.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                    attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                    attachment.setCertificateName(attachmentHandle.getCertificateName());
                    tAgencyAttachmentMapper.insertSelective(attachment);
                }
            }
            //基础信息更新
            TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
            tAgencyBasicInfo.setId(biddingHandle.getId());
            tAgencyBasicInfo.setState(Const.STATE.AUDIT_SUCCESS);
            return Result.success(tAgencyBasicInfoMapper.updateByPrimaryKeySelective(tAgencyBasicInfo)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException updateBiddingAgencyDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException updateBiddingAgencyDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
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
            LOGGER.error("BusinessException deleteBiddingAgencyDetailInfo : {}", e);
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
                //查询对应基础信息
                TAgencyBasicInfo tAgencyBasicInfo = tAgencyBasicInfoMapper.selectByPrimaryKey(whereId);
                TAgencyDetailInfoCriteria criteria = new TAgencyDetailInfoCriteria();
                criteria.createCriteria().andAgencyIdEqualTo(whereId);
                List<TAgencyDetailInfo> tAgencyDetailInfos = tAgencyDetailInfoMapper.selectByExample(criteria);
                //如果未完善信息 返回基础信息
                if(tAgencyDetailInfos.isEmpty()){
                    AgencyUserAttachmentVO agencyUserAttachmentVO = new AgencyUserAttachmentVO();
                    BeanUtils.copyProperties(tAgencyBasicInfo,agencyUserAttachmentVO);
                    return Result.success(agencyUserAttachmentVO);
                }
                //装填用户所有信息开始
                TAgencyDetailInfo tAgencyDetailInfo = tAgencyDetailInfos.get(0);
                AgencyUserAttachmentVO agencyUserAttachmentVO = new AgencyUserAttachmentVO();
                agencyUserAttachmentVO.setId(whereId);
                if(tAgencyDetailInfo!=null){
                    BeanUtils.copyProperties(tAgencyDetailInfo,agencyUserAttachmentVO);
                }
                TAgencyAttachmentCriteria tAgencyAttachmentCriteria = new TAgencyAttachmentCriteria();
                tAgencyAttachmentCriteria.createCriteria().andAgencyIdEqualTo(whereId);
                List<TAgencyAttachment> tAgencyAttachments = tAgencyAttachmentMapper.selectByExample(tAgencyAttachmentCriteria);
                agencyUserAttachmentVO.setCreateAt(new Date());
                BeanUtils.copyProperties(tAgencyBasicInfo,agencyUserAttachmentVO);
                List<AgencyAttachmentVO> agencyAttachmentVOS = new ArrayList<>();
                for (TAgencyAttachment tAgencyAttachment : tAgencyAttachments) {
                    if(tAgencyAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
                        agencyUserAttachmentVO.setLegalIdCardOther(tAgencyAttachment.getCertificateFilePath());
                    }  else if (tAgencyAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
                        agencyUserAttachmentVO.setLegalIdCardPositive(tAgencyAttachment.getCertificateFilePath());
                    }   else if (tAgencyAttachment.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())){
                        agencyUserAttachmentVO.setBusinessLicense(tAgencyAttachment.getCertificateFilePath());
                    }
                    AgencyAttachmentVO agencyAttachmentVO = new AgencyAttachmentVO();
                    BeanUtils.copyProperties(tAgencyAttachment,agencyAttachmentVO);
                    agencyAttachmentVOS.add(agencyAttachmentVO);
                }
                agencyUserAttachmentVO.setAgencyAttachmentVOS(agencyAttachmentVOS);
                //装填用户所有信息结束
                return Result.success(agencyUserAttachmentVO);
            } catch (BusinessException e) {
                LOGGER.error("BusinessException queryBiddingAgencyDetailInfo : {}", e);
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
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(where)){
            where="%"+where+"%";
            queryDetailIfo.setWhere(where);
        }else{
            queryDetailIfo.setWhere(null);
        }
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
