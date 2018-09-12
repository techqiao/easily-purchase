package com.epc.platform.service.service.operator.impl;

import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.administration.facade.operator.handle.HandleOperatorDetailIfo;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.platform.service.domain.operator.TOperatorAttachment;
import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.mapper.operator.TOperatorAttachmentMapper;
import com.epc.platform.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.platform.service.mapper.operator.TOperatorDetailInfoMapper;
import com.epc.platform.service.service.operator.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>Description : 运营商接口实现类
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Autowired
    private TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    @Autowired
    private TOperatorDetailInfoMapper tOperatorDetailInfoMapper;
    @Autowired
    private TOperatorAttachmentMapper tOperatorAttachmentMapper;

    @Override
    public Result<Boolean> insertOperatorBasicInfo(HandleOperatorBasicInfo handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellphone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.REGISTERED);
        try {
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (Exception e) {
            LOGGER.error("exception insertOperatorBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Result<Boolean> insertOperatorDetailInfo(HandleOperatorDetailIfo handleOperatorDetailIfo) {
        TOperatorDetailInfo detailInfo = new TOperatorDetailInfo();
        BeanUtils.copyProperties(handleOperatorDetailIfo, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        TOperatorAttachment attachment = new TOperatorAttachment();
        attachment.setOperatorId(handleOperatorDetailIfo.getOperatorId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            tOperatorDetailInfoMapper.insertSelective(detailInfo);
            //带公章的授权书照片url
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(handleOperatorDetailIfo.getCertificateOfAuthorization());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(handleOperatorDetailIfo.getOperatorIdCardFront());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(handleOperatorDetailIfo.getLegalIdCardOther());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(handleOperatorDetailIfo.getLegalIdCardPositive());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(handleOperatorDetailIfo.getBusinessLicense());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //资质证书url
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(handleOperatorDetailIfo.getQualificationCertificate());
            tOperatorAttachmentMapper.insertSelective(attachment);
            return Result.success();
        }catch (Exception e) {
            LOGGER.error("exception insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

}
