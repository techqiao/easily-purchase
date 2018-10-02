package com.epc.platform.service.service.purchaser.impl;

import com.epc.administration.facade.purchaser.dto.QueryDetailIfo;
import com.epc.administration.facade.purchaser.handle.ExaminePurchaserHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserForbiddenHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserHandle;
import com.epc.administration.facade.purchaser.handle.UserBasicInfo;
import com.epc.administration.facade.purchaser.vo.PurchaserVO;
import com.epc.administration.facade.supplier.handle.AttachmentHandle;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.purchaser.*;
import com.epc.platform.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.platform.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.platform.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import com.epc.platform.service.service.purchaser.PurchaserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>Description : 采购人业务实现层
 * <p>Date : 2018-09-28 13:14
 * <p>@Author : luozhixin
 * <p>PurchaserServiceImpl
 */
@Service
public class PurchaserServiceImpl implements PurchaserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Autowired
    private TPurchaserAttachmentMapper tPurchaserAttachmentMapper;
    @Autowired
    private TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;
    @Autowired
    private TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;


    /**
     * 供采购人注册
     * @param userBasicInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertPurchaserUserInfo(UserBasicInfo userBasicInfo) {
        TPurchaserBasicInfo tPurchaserBasicInfo = new TPurchaserBasicInfo();
        Date date = new Date();
        tPurchaserBasicInfo.setCellphone(userBasicInfo.getCellphone());
        tPurchaserBasicInfo.setName(userBasicInfo.getUsername());
        tPurchaserBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tPurchaserBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tPurchaserBasicInfo.setCreateAt(date);
        tPurchaserBasicInfo.setUpdateAt(date);
        tPurchaserBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        tPurchaserBasicInfo.setState(Const.STATE.REGISTERED);
        tPurchaserBasicInfo.setInviterId(userBasicInfo.getId());
        try {
            return Result.success(tPurchaserBasicInfoMapper.insertSelective(tPurchaserBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertSelective : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertSelective : {}", e);
            return Result.error(e.getMessage());
        }
    }
    /**
     * 完善采购人资料
     * @param purchaserHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updatePurchaserDetailInfo(PurchaserHandle purchaserHandle) {
        Date date = new Date();
        TPurchaserDetailInfo tPurchaserDetailInfo = new TPurchaserDetailInfo();
        tPurchaserDetailInfo.setPurchaserId(purchaserHandle.getId());
        tPurchaserDetailInfo.setCompanyName(purchaserHandle.getCompanyName());
        tPurchaserDetailInfo.setUniformCreditCode(purchaserHandle.getUniformCreditCode());
        tPurchaserDetailInfo.setPublicBankName(purchaserHandle.getPublicBankName());
        tPurchaserDetailInfo.setPublicBanAccountNumber(purchaserHandle.getPublicBanAccountNumber());
        tPurchaserDetailInfo.setExtendedField(purchaserHandle.getBusinessLicense());
        tPurchaserDetailInfo.setUpdateAt(date);
        TPurchaserDetailInfoCriteria tPurchaserDetailInfoCriteria = new TPurchaserDetailInfoCriteria();
        tPurchaserDetailInfoCriteria.createCriteria().andPurchaserIdEqualTo(purchaserHandle.getId());

        TPurchaserAttachment attachment = new TPurchaserAttachment();
        attachment.setPurchaserId(purchaserHandle.getId());
        attachment.setUpdateAt(date);
        try {
            //公司名称
            tPurchaserDetailInfoMapper.updateByExampleSelective(tPurchaserDetailInfo,tPurchaserDetailInfoCriteria);
            //经办人(采购人员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(purchaserHandle.getLegalIdCardPositive());
            tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(purchaserHandle.getLegalIdCardOther());
            tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(purchaserHandle.getBusinessLicense());
            tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            //资质证书url
            List<AttachmentHandle> attachmentHandleList = purchaserHandle.getAttachmentHandleList();
            for (AttachmentHandle attachmentHandle : attachmentHandleList) {
                attachment.setCertificateName(attachmentHandle.getCertificateName());
                attachment.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            }
            //完善信息完成后 更新信息状态至已提交
            TPurchaserBasicInfo tSupplierBasicInfo = new TPurchaserBasicInfo();
            tSupplierBasicInfo.setId(purchaserHandle.getId());
            tSupplierBasicInfo.setName("");
            tSupplierBasicInfo.setCellphone("");
            tSupplierBasicInfo.setPassword("");
            tSupplierBasicInfo.setPurchaserId(0L);
            tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
            tSupplierBasicInfo.setUpdateAt(new Date());
            return Result.success(tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }
    /**
     * 采购人完善资料
     * @param purchaserHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertPurchaserDetailInfo(PurchaserHandle purchaserHandle) {
        Date date = new Date();
        TPurchaserDetailInfo tPurchaserDetailInfo = new TPurchaserDetailInfo();
        tPurchaserDetailInfo.setPurchaserId(purchaserHandle.getId());
        tPurchaserDetailInfo.setCompanyName(purchaserHandle.getCompanyName());
        tPurchaserDetailInfo.setUniformCreditCode(purchaserHandle.getUniformCreditCode());
        tPurchaserDetailInfo.setPublicBankName(purchaserHandle.getPublicBankName());
        tPurchaserDetailInfo.setPublicBanAccountNumber(purchaserHandle.getPublicBanAccountNumber());
        tPurchaserDetailInfo.setExtendedField(purchaserHandle.getBusinessLicense());
        tPurchaserDetailInfo.setUpdateAt(date);
        TPurchaserDetailInfoCriteria tPurchaserDetailInfoCriteria = new TPurchaserDetailInfoCriteria();
        tPurchaserDetailInfoCriteria.createCriteria().andPurchaserIdEqualTo(purchaserHandle.getId());

        TPurchaserAttachment attachment = new TPurchaserAttachment();
        attachment.setPurchaserId(purchaserHandle.getId());
        attachment.setUpdateAt(date);
        try {
            tPurchaserDetailInfoMapper.deleteByExample(tPurchaserDetailInfoCriteria);
            TPurchaserAttachmentCriteria criteria = new TPurchaserAttachmentCriteria();
            criteria.createCriteria().andPurchaserIdEqualTo(purchaserHandle.getId());
            tPurchaserAttachmentMapper.deleteByExample(criteria);
            //公司名称
            tPurchaserDetailInfoMapper.updateByExampleSelective(tPurchaserDetailInfo,tPurchaserDetailInfoCriteria);
            //经办人(采购人员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(purchaserHandle.getLegalIdCardPositive());
            tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(purchaserHandle.getLegalIdCardOther());
            tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(purchaserHandle.getBusinessLicense());
            tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            //资质证书url
            List<AttachmentHandle> attachmentHandleList = purchaserHandle.getAttachmentHandleList();
            for (AttachmentHandle attachmentHandle : attachmentHandleList) {
                attachment.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                attachment.setCertificateName(attachmentHandle.getCertificateName());
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                tPurchaserAttachmentMapper.updateByPrimaryKeySelective(attachment);
            }
            //完善信息完成后 更新信息状态至已提交
            TPurchaserBasicInfo tSupplierBasicInfo = new TPurchaserBasicInfo();
            tSupplierBasicInfo.setId(purchaserHandle.getId());
            tSupplierBasicInfo.setName("");
            tSupplierBasicInfo.setCellphone("");
            tSupplierBasicInfo.setPassword("");
            tSupplierBasicInfo.setPurchaserId(0L);
            tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
            tSupplierBasicInfo.setUpdateAt(new Date());
            return Result.success(tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }
    /**
     *  删除采购人资料
     * @param whereId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deletePurchaserDetailInfo(Long whereId) {
        TPurchaserBasicInfo tPurchaserBasicInfo = new TPurchaserBasicInfo();
        tPurchaserBasicInfo.setId(whereId);
        tPurchaserBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tPurchaserBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }
    /**
     * 采购人资料查询
     * @param id
     * @return
     */
    @Override
    public Result<TPurchaserDetailInfo> queryPurchaserDetailInfo(Long id) {
        try {
            TPurchaserDetailInfo tPurchaserDetailInfo = tPurchaserDetailInfoMapper.selectByPrimaryKey(id);
            return Result.success(tPurchaserDetailInfo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException deleteByPrimaryKey : {}", e);
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
    }
    /**
     * 查询所有采购人 ，分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public List<PurchaserVO> selectAllPurchaserByPage(QueryDetailIfo queryDetailIfo) {
        String where = queryDetailIfo.getWhere();
        if(where!=null){
            where="%"+where+"%";
            queryDetailIfo.setWhere(where);
        }
        return  tPurchaserDetailInfoMapper.selectByPage(queryDetailIfo);
    }
    /**
     * 审核采购人
     * @param examinePurchaserHandle
     * @return
     */
    @Override
    public Result<Boolean> examinePurchaser(ExaminePurchaserHandle examinePurchaserHandle) {
        TPurchaserBasicInfo tPurchaserBasicInfo = new TPurchaserBasicInfo();
        tPurchaserBasicInfo.setState(examinePurchaserHandle.getState());
        tPurchaserBasicInfo.setId(examinePurchaserHandle.getPurchaserId());
        TPurchaserBasicInfoCriteria criteria = new TPurchaserBasicInfoCriteria() ;
        criteria.createCriteria().andIdEqualTo(examinePurchaserHandle.getPurchaserId());
        return Result.success(tPurchaserBasicInfoMapper.updateByExampleSelective(tPurchaserBasicInfo,criteria)>0);
    }

    /**
     * 启用锁定采购人
     * @param purchaserForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenPurchaserUser(PurchaserForbiddenHandle purchaserForbiddenHandle) {
        TPurchaserBasicInfo tPurchaserBasicInfo = new TPurchaserBasicInfo();
        tPurchaserBasicInfo.setId(purchaserForbiddenHandle.getId());
        tPurchaserBasicInfo.setIsForbidden(purchaserForbiddenHandle.getIsForbidden());
        return Result.success(tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tPurchaserBasicInfo)>0);
    }
}
