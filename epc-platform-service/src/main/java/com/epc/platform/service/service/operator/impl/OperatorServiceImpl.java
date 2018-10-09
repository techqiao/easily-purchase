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
        TOperatorBasicInfoCriteria tOperatorBasicInfoCriteria = new TOperatorBasicInfoCriteria();
        tOperatorBasicInfoCriteria.createCriteria().andCellphoneEqualTo(userBasicInfo.getCellphone());
        List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(tOperatorBasicInfoCriteria);
        if(!tOperatorBasicInfos.isEmpty()){
            return Result.success("用户已存在，请直接登录");
        }

        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setName(userBasicInfo.getUsername());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.COMMITTED);
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
        Date date = new Date();
        TOperatorDetailInfo detailInfo = new TOperatorDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo,detailInfo);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        TOperatorAttachment attachment = new TOperatorAttachment();
        attachment.setOperatorId(roleDetailInfo.getId());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        TOperatorDetailInfoCriteria tOperatorDetailInfoCriteria = new TOperatorDetailInfoCriteria();
        tOperatorDetailInfoCriteria.createCriteria().andOperatorIdEqualTo(roleDetailInfo.getId());
        TOperatorAttachmentCriteria tOperatorAttachmentCriteria = new TOperatorAttachmentCriteria();
        tOperatorAttachmentCriteria.createCriteria().andOperatorIdEqualTo(roleDetailInfo.getId());
        try {
            List<TOperatorDetailInfo> tOperatorDetailInfos = tOperatorDetailInfoMapper.selectByExample(tOperatorDetailInfoCriteria);
            //没有就新增 未通过重填就修改
            if(tOperatorDetailInfos.isEmpty()){
                //新增详细信息
                tOperatorDetailInfoMapper.insertSelective(detailInfo);
            }else {
                tOperatorDetailInfoMapper.updateByExampleSelective(detailInfo,tOperatorDetailInfoCriteria);
            }
                List<TOperatorAttachment> tOperatorAttachments = tOperatorAttachmentMapper.selectByExample(tOperatorAttachmentCriteria);
                if(!tOperatorAttachments.isEmpty()){
                          tOperatorAttachmentMapper.deleteByExample(tOperatorAttachmentCriteria);
                      }
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
                    tOperatorAttachmentMapper.insertSelective(attachment);
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
     * 修改运营商资料
     * @param roleDetailInfo
     * @return
     */
    @Override
    public Result<Boolean> updateOperatorDetailInfo(RoleDetailInfo roleDetailInfo) {
       TOperatorAttachment attachment = new TOperatorAttachment();
       Date date =  new Date();
       attachment.setCreateAt(date);
       attachment.setUpdateAt(date);
       attachment.setOperatorId(roleDetailInfo.getId());
        TOperatorDetailInfo detailInfo = new TOperatorDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo,detailInfo);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            //删除详细信息
            TOperatorDetailInfoCriteria tOperatorDetailInfoCriteria = new TOperatorDetailInfoCriteria();
            tOperatorDetailInfoCriteria.createCriteria().andOperatorIdEqualTo(roleDetailInfo.getId());
            tOperatorDetailInfoMapper.deleteByExample(tOperatorDetailInfoCriteria);
            //删除详细信息
            TOperatorAttachmentCriteria criteria = new TOperatorAttachmentCriteria();
            criteria.createCriteria().andOperatorIdEqualTo(roleDetailInfo.getId());
            tOperatorAttachmentMapper.deleteByExample(criteria);
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
            tOperatorAttachmentMapper.insertSelective(attachment);
            //资质证书url
            List<OperatorAttachmentHandle> qualificationCertificateList = roleDetailInfo.getQualificationCertificateList();

            if (qualificationCertificateList != null) {
                for (OperatorAttachmentHandle operatorAttachmentHandle : qualificationCertificateList) {
                    attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                    attachment.setCertificateName(operatorAttachmentHandle.getCertificateName());
                    attachment.setCertificateFilePath(operatorAttachmentHandle.getCertificateFilePath());
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
        } catch (Exception e) {
            LOGGER.error("BusinessException updateOperatorDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
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
            LOGGER.error("BusinessException deleteOperatorDetailInfo : {}", e);
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
        try {
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(whereId);
            TOperatorDetailInfoCriteria tOperatorDetailInfoCriteria = new TOperatorDetailInfoCriteria();
            tOperatorDetailInfoCriteria.createCriteria().andOperatorIdEqualTo(whereId);
            List<TOperatorDetailInfo> tOperatorDetailInfos = tOperatorDetailInfoMapper.selectByExample(tOperatorDetailInfoCriteria);
            //如果未完善信息返回基础信息
            if(tOperatorDetailInfos.isEmpty()){
                OperatorUserVO operatorUserVO = new OperatorUserVO();
                operatorUserVO.setId(tOperatorBasicInfo.getId());
                operatorUserVO.setName(tOperatorBasicInfo.getName());
                operatorUserVO.setState(tOperatorBasicInfo.getState());
                operatorUserVO.setCellphone(tOperatorBasicInfo.getCellphone());
                return Result.success(operatorUserVO) ;
            }
            //装填所有信息开始
            TOperatorDetailInfo tOperatorDetailInfo = tOperatorDetailInfos.get(0);
            OperatorUserVO operatorUserVO = new OperatorUserVO();
            BeanUtils.copyProperties(tOperatorDetailInfo,operatorUserVO);
            TOperatorAttachmentCriteria tOperatorAttachmentCriteria = new TOperatorAttachmentCriteria();
            tOperatorAttachmentCriteria.createCriteria().andOperatorIdEqualTo(whereId);
            List<TOperatorAttachment>  tOperatorAttachments = tOperatorAttachmentMapper.selectByExample(tOperatorAttachmentCriteria);
            List<OperatorAttachmentVO> operatorAttachmentVOS = new ArrayList<>();
            for (TOperatorAttachment tOperatorAttachment : tOperatorAttachments) {
                if(tOperatorAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
                    operatorUserVO.setLegalIdCardPositive(tOperatorAttachment.getCertificateFilePath());
                }else if(tOperatorAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
                    operatorUserVO.setLegalIdCardOther(tOperatorAttachment.getCertificateFilePath());
                }else if(tOperatorAttachment.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())){
                    operatorUserVO.setBusinessLicense(tOperatorAttachment.getCertificateFilePath());
                }else{
                    OperatorAttachmentVO operatorAttachmentVO = new OperatorAttachmentVO();
                    BeanUtils.copyProperties(tOperatorAttachment,operatorAttachmentVO);
                    operatorAttachmentVOS.add(operatorAttachmentVO);
                }
            }
            operatorUserVO.setOperatorAttachmentVOList(operatorAttachmentVOS);
            operatorUserVO.setCreateAt(new Date());
            BeanUtils.copyProperties(tOperatorBasicInfo,operatorUserVO);
            //装填所有信息结束
            return Result.success(operatorUserVO);
        } catch (Exception e1) {
            LOGGER.error("BusinessException queryOperatorDetailInfo : {}", e1);
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }

    }
    /**
     * 查询运营商 分页展示
     * @return
     */
    @Override
    public List<OperatorVO> selectAllOperatorByPage(QueryDetailIfo queryDetailIfo) {
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(where)){
            where="%"+where+"%";
            queryDetailIfo.setWhere(where);
        }else{
        queryDetailIfo.setWhere(null);
    }
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
