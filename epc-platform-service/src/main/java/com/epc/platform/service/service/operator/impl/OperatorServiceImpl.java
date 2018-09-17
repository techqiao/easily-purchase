package com.epc.platform.service.service.operator.impl;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.admin.SysAdminResourceCriteria;
import com.epc.platform.service.domain.admin.SysAdminUserCriteria;
import com.epc.platform.service.domain.operator.TOperatorAttachment;
import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.domain.operator.TOperatorDetailInfoCriteria;
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
    @Transactional
    public Result<Boolean> insertOperatorBasicInfo(UserBasicInfo handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellphone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setName(handleOperator.getUsername());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
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
    @Transactional
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
            tOperatorDetailInfoMapper.insertSelective(detailInfo);
            //带公章的授权书照片url
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
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());
            tOperatorAttachmentMapper.insertSelective(attachment);
            //资质证书url
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(roleDetailInfo.getQualificationCertificate());
            tOperatorAttachmentMapper.insertSelective(attachment);
            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }


    /**
     * 删除运营商
     * @param
     * @return
     */
    @Override
    public Result<Boolean> deleteOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
        TOperatorAttachment tOperatorAttachment = new TOperatorAttachment();
        tOperatorAttachment.setId(queryDetailIfo.getId());
        try{
            return Result.success(tOperatorAttachmentMapper.updateByPrimaryKeySelective(tOperatorAttachment)>0);
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
    public Result<TOperatorDetailInfo> queryOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
            try {
                TOperatorDetailInfo tOperatorDetailInfo = tOperatorDetailInfoMapper.selectByPrimaryKey(queryDetailIfo.getId());
                return Result.success(tOperatorDetailInfo);
            } catch (BusinessException e) {
                LOGGER.error("BusinessException deleteByPrimaryKey : {}", e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }
    }

    /**
     * 根据公司名模糊查询运营商
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<List<TOperatorDetailInfo>> selectOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
        TOperatorDetailInfoCriteria tOperatorDetailInfoCriteria = new TOperatorDetailInfoCriteria();
        TOperatorDetailInfoCriteria.Criteria criteria = tOperatorDetailInfoCriteria.createCriteria();
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(queryDetailIfo.getWhere())){
            where = "%" + where + "%";
        }
        if(StringUtils.isNotBlank(where)){
            criteria.andCompanyNameEqualTo(where);
        }
        return Result.success(tOperatorDetailInfoMapper.selectByExample(tOperatorDetailInfoCriteria)) ;
    }

    /**
     * 运营商新增员工
     * @param userBasicInfo
     * @return
     */
//    @Override
//    public Result<Boolean> createSupplierUser(UserBasicInfo userBasicInfo) {
//        Date date = new Date();
//        TOperatorBasicInfo tOperatorBasicInfo = new TOperatorBasicInfo();
//        tOperatorBasicInfo.setCellphone(userBasicInfo.getCellphone());
//        tOperatorBasicInfo.setPassword(userBasicInfo.getPassword());
//        tOperatorBasicInfo.setCreateAt(date);
//        tOperatorBasicInfo.setUpdateAt(date);
//        tOperatorBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
//        tOperatorBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
//        tOperatorBasicInfo.setState(Const.STATE.REGISTERED);
//        try {
//            return Result.success(tOperatorBasicInfoMapper.insertSelective(tOperatorBasicInfo) > 0);
//        } catch (BusinessException e) {
//            LOGGER.error("BusinessException tOperatorBasicInfo : {}", e);
//            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
//        } catch (Exception e) {
//            LOGGER.error("BusinessException tOperatorBasicInfo : {}", e);
//            return Result.error(e.getMessage());
//        }
//
//    }
}
