package com.epc.platform.service.service.operator.impl;
import com.epc.administration.facade.operator.handle.*;
import com.epc.administration.facade.operator.vo.OperatorAttachmentVO;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.vo.OperatorUserVO;
import com.epc.administration.facade.operator.vo.OperatorVO;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.admin.SysAdminUserOperator;
import com.epc.platform.service.domain.operator.*;
import com.epc.platform.service.mapper.admin.SysAdminUserOperatorMapper;
import com.epc.platform.service.mapper.operator.TOperatorAttachmentMapper;
import com.epc.platform.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.platform.service.mapper.operator.TOperatorDetailInfoMapper;
import com.epc.platform.service.service.operator.OperatorService;
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
    @Autowired
    private SysAdminUserOperatorMapper sysAdminUserOperatorMapper;

    /**
     * 新增运营商基本信息
     * 附带新增此运营商拉取记录
     * @param userBasicInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertOperatorBasicInfo(UserBasicInfo userBasicInfo) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setName(userBasicInfo.getUsername());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.REGISTERED);
        SysAdminUserOperator sysAdminUserOperator = new SysAdminUserOperator();
        sysAdminUserOperator.setAdminUserId(pojo.getId());
        sysAdminUserOperator.setAdminUserName(pojo.getName());
        sysAdminUserOperator.setCreateAt(date);
        sysAdminUserOperator.setUpdateAt(date);
        sysAdminUserOperator.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            sysAdminUserOperatorMapper.insertSelective(sysAdminUserOperator);
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorBasicInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("BusinessException insertOperatorBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增运营商补全信息
     *
     * @param roleDetailInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertOperatorDetailInfo(RoleDetailInfo roleDetailInfo) {
        TOperatorDetailInfo detailInfo = new TOperatorDetailInfo();
        Date date = new Date();
        detailInfo.setOperatorId(roleDetailInfo.getId());
        detailInfo.setCompanyName(roleDetailInfo.getCompanyName());
        detailInfo.setUniformCreditCode(roleDetailInfo.getUniformCreditCode());
        detailInfo.setPublicBankName(roleDetailInfo.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(roleDetailInfo.getPublicBanAccountNumber());
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        TOperatorAttachment attachment = new TOperatorAttachment();
        attachment.setOperatorId(roleDetailInfo.getId());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        try {
            //新增详细信息
            tOperatorDetailInfoMapper.insertSelective(detailInfo);
            //新增带公章的授权书
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getCertificateOfAuthorization());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //法人手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardPositive());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //法人手持身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardOther());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //营业执照
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());

            //资质证书url
            List<OperatorAttachmentHandle> qualificationCertificateList = roleDetailInfo.getQualificationCertificateList();

            if (qualificationCertificateList != null) {
                for (OperatorAttachmentHandle operatorAttachmentHandle : qualificationCertificateList) {
                    attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                    attachment.setCertificateFilePath(operatorAttachmentHandle.getCertificateFilePath());
                    attachment.setCertificateName(operatorAttachmentHandle.getCertificateName());
                    tOperatorAttachmentMapper.insertSelective(attachment);
                }
            }
            //执行成功更新提交状态
            TOperatorBasicInfo tOperatorBasicInfo = new TOperatorBasicInfo();
            tOperatorBasicInfo.setId(roleDetailInfo.getId());
            tOperatorBasicInfo.setOperatorId(roleDetailInfo.getId());
            tOperatorBasicInfo.setState(Const.STATE.COMMITTED);
            tOperatorBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
            tOperatorBasicInfo.setUpdateAt(new Date());
            return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }


    /**
     * 删除运营商
     *
     * @param
     * @return
     */
    @Override
    public Result<Boolean> deleteOperatorDetailInfo(Long whereId) {
        TOperatorBasicInfo tOperatorBasicInfo = new TOperatorBasicInfo();
        tOperatorBasicInfo.setId(whereId);
        tOperatorBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 查询运营商基本信息
     *
     * @param
     * @return
     */
    @Override
    public Result<OperatorUserVO> queryOperatorDetailInfo(Long whereId) {

        TOperatorBasicInfo tOperatorBasicInfo;
        TOperatorDetailInfo tOperatorDetailInfo;
        List<TOperatorAttachment> tOperatorAttachments;
        try {
            tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(whereId);
            if(tOperatorBasicInfo.getIsDeleted()!=0){
                return Result.error();
            }
            TOperatorDetailInfoCriteria tOperatorDetailInfoCriteria = new TOperatorDetailInfoCriteria();
            tOperatorDetailInfoCriteria.createCriteria().andOperatorIdEqualTo(whereId);
            tOperatorDetailInfo = tOperatorDetailInfoMapper.selectByExample(tOperatorDetailInfoCriteria).get(0);
            TOperatorAttachmentCriteria tOperatorAttachmentCriteria = new TOperatorAttachmentCriteria();
            tOperatorAttachmentCriteria.createCriteria().andOperatorIdEqualTo(whereId);
            tOperatorAttachments = tOperatorAttachmentMapper.selectByExample(tOperatorAttachmentCriteria);
        } catch (Exception e1) {
            LOGGER.error("BusinessException selectOperatorUserVO : {}", e1);
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        List<OperatorAttachmentVO> operatorAttachmentVOS = new ArrayList<>();
        for (TOperatorAttachment tOperatorAttachment : tOperatorAttachments) {
            OperatorAttachmentVO operatorAttachmentVO = new OperatorAttachmentVO();
            operatorAttachmentVO.setCertificateFilePath(tOperatorAttachment.getCertificateFilePath());
            operatorAttachmentVO.setCertificateName(tOperatorAttachment.getCertificateName());
            operatorAttachmentVO.setCertificateType(tOperatorAttachment.getCertificateType());
            operatorAttachmentVOS.add(operatorAttachmentVO);
        }
        OperatorUserVO operatorUserVO = new OperatorUserVO();
        operatorUserVO.setOperatorAttachmentVOList(operatorAttachmentVOS);
        operatorUserVO.setId(tOperatorBasicInfo.getId());
        operatorUserVO.setCompanyName(tOperatorDetailInfo.getCompanyName());
        operatorUserVO.setUniformCreditCode(tOperatorDetailInfo.getUniformCreditCode());
        operatorUserVO.setPublicBankName(tOperatorDetailInfo.getPublicBankName());
        operatorUserVO.setPublicBanAccountNumber(tOperatorDetailInfo.getPublicBanAccountNumber());
        operatorUserVO.setCreateAt(new Date());
        operatorUserVO.setIsDeleted(tOperatorBasicInfo.getIsDeleted());
        operatorUserVO.setCellphone(tOperatorBasicInfo.getCellphone());
        operatorUserVO.setState(tOperatorBasicInfo.getState());
        operatorUserVO.setName(tOperatorBasicInfo.getName());
        return Result.success(operatorUserVO);
    }
    /**
     * 查询运营商 分页展示
     * @return
     */
    @Override
    public List<OperatorVO> selectAllOperatorByPage(QueryDetailIfo queryDetailIfo) {
        return  tOperatorDetailInfoMapper.selectByPage(queryDetailIfo);
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
        tOperatorBasicInfo.setId(examineOperatorHandle.getAgencyId());
        return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo)>0);
    }
    /**
     *启动锁定运营商
     * @param operatorForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenOperatorUser(OperatorForbiddenHandle operatorForbiddenHandle) {
        TOperatorBasicInfo tOperatorBasicInfo = new TOperatorBasicInfo();
        tOperatorBasicInfo.setIsForbidden(operatorForbiddenHandle.getIsForbidden());
        tOperatorBasicInfo.setId(operatorForbiddenHandle.getId());
        return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo)>0);
    }
}
