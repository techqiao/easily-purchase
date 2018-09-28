package com.epc.platform.service.service.operator.impl;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.ExamineOperatorHandle;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.operator.*;
import com.epc.platform.service.mapper.operator.TOperatorAttachmentMapper;
import com.epc.platform.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.platform.service.mapper.operator.TOperatorDetailInfoMapper;
import com.epc.platform.service.service.operator.OperatorService;
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
 * <p>Description : 运营商接口实现类
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
@Service
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Autowired
    private TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    @Autowired
    private TOperatorDetailInfoMapper tOperatorDetailInfoMapper;
    @Autowired
    private TOperatorAttachmentMapper tOperatorAttachmentMapper;

    /**
     * 新增运营商基本信息
     * @param handleOperator
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertOperatorBasicInfo(UserBasicInfo handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellphone());
        pojo.setName(handleOperator.getUsername());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setName(handleOperator.getUsername());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.REGISTERED);
        try {
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorBasicInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertOperatorBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增运营商补全信息
     * @param roleDetailInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertOperatorDetailInfo(RoleDetailInfo roleDetailInfo) {
        TOperatorDetailInfo detailInfo = new TOperatorDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        TOperatorAttachment attachment = new TOperatorAttachment();
        attachment.setOperatorId(roleDetailInfo.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            System.out.println();
            tOperatorDetailInfoMapper.insertSelective(detailInfo);
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getCertificateOfAuthorization());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getOperatorIdCardFront());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardOther());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardPositive());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //资质证书url
            for (String qualificationCertificate : roleDetailInfo.getQualificationCertificateList()) {
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateFilePath(qualificationCertificate);
                tOperatorAttachmentMapper.insertSelective(attachment);
            }
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());
            return  Result.success(tOperatorAttachmentMapper.insertSelective(attachment)>0);

        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }


    /**
     * 删除运营商
     * @param
     * @return
     */
    @Override
    public Result<Boolean> deleteOperatorDetailInfo(Long whereId) {
        TOperatorDetailInfo tOperatorDetailInfo = new TOperatorDetailInfo();
        tOperatorDetailInfo.setId(whereId);
        tOperatorDetailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tOperatorDetailInfoMapper.updateByPrimaryKeySelective(tOperatorDetailInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 查询运营商基本信息
     * @param
     * @return
     */
    @Override
    public Result<TOperatorDetailInfo> queryOperatorDetailInfo(Long whereId) {
            try {
                TOperatorDetailInfo tOperatorDetailInfo = tOperatorDetailInfoMapper.selectByPrimaryKey(whereId);
                return Result.success(tOperatorDetailInfo);
            } catch (BusinessException e) {
                LOGGER.error("BusinessException deleteByPrimaryKey : {}", e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }
    }


    /**
     * 查询运营商 分页展示
     * @return
     */
    @Override
    public List<TOperatorDetailInfo> selectAllOperatorByPage(QueryDetailIfo queryDetailIfo) {
        try {
        TOperatorDetailInfoCriteria criteria = new TOperatorDetailInfoCriteria();
        criteria.setOrderByClause("id desc");
        if(queryDetailIfo.getWhereName()!=null){
        criteria.createCriteria().andCompanyNameEqualTo(queryDetailIfo.getWhereName());
        }
        return  tOperatorDetailInfoMapper.selectByExample(criteria);
        } catch (Exception e) {
            LOGGER.error("获取运营商失败", e);
            return new ArrayList<>();
        }
    }

    /**
     * 审核运营商
     * @param examineOperatorHandle
     * @return
     */
    @Override
    public Result<Boolean> examineOperator(ExamineOperatorHandle examineOperatorHandle) {
        TOperatorBasicInfo tOperatorBasicInfo= new TOperatorBasicInfo();
        tOperatorBasicInfo.setState(examineOperatorHandle.getState());
        TOperatorBasicInfoCriteria criteria = new TOperatorBasicInfoCriteria();
        criteria.createCriteria().andIdEqualTo(examineOperatorHandle.getOperatorId());
        return Result.success(tOperatorBasicInfoMapper.updateByExampleSelective(tOperatorBasicInfo,criteria)>0);
    }
}
