package com.epc.web.service.service.impl;

import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.web.facade.agency.handle.Attachement;
import com.epc.web.service.domain.agency.TAgencyAttachment;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.purchaser.TPurchaserAttachment;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

public class UpdateAttachment {
    @Autowired
    TAgencyAttachmentMapper tAgencyAttachmentMapper;

    @Autowired
    TExpertAttachmentMapper tExpertAttachmentMapper;

    @Autowired
    TSupplierAttachmentMapper tSupplierAttachmentMapper;

    @Autowired
    TPurchaserAttachmentMapper tPurchaserAttachmentMapper;

    /**
     * @author :winlin
     * @Description :完善代理机构附件信息
     * @date:2018/10/13
     */
    public void updateAgencyAttachment(List<Attachement> list, String legalIdCardPositive, String legalIdCardOther, String businessLicense, Long agencyId) {
        //跟新时间
        Date date = new Date();
        TAgencyAttachment attachment = new TAgencyAttachment();
        attachment.setAgencyId(agencyId);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        //添加身份证正面
        attachment.setCertificateFilePath(legalIdCardPositive);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
        tAgencyAttachmentMapper.insertSelective(attachment);
        //法人身份证反面照片url
        attachment.setCertificateFilePath(legalIdCardOther);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
        tAgencyAttachmentMapper.insertSelective(attachment);
        //营业执照照片url
        attachment.setCertificateFilePath(businessLicense);
        attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
        attachment.setCertificateName(AttachmentEnum.BUSINESS_LICENSE.getDesc());
        tAgencyAttachmentMapper.insertSelective(attachment);
        if (!CollectionUtils.isEmpty(list)) {
            for (Attachement att : list) {
                attachment.setCertificateFilePath(att.getCertificateFilePath());
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
                tAgencyAttachmentMapper.insertSelective(attachment);
            }
        }
    }

    /**
     * @author :winlin
     * @Description :完善供货商附件信息
     * @date:2018/10/13
     */
    public void updateSupplierAttachment(List<Attachement> list, String legalIdCardPositive, String legalIdCardOther, String businessLicense, Long supplierId) {
        //跟新时间
        Date date = new Date();
        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(supplierId);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        //添加身份证正面
        attachment.setCertificateFilePath(legalIdCardPositive);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
        tSupplierAttachmentMapper.insertSelective(attachment);
        //法人身份证反面照片url
        attachment.setCertificateFilePath(legalIdCardOther);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
        tSupplierAttachmentMapper.insertSelective(attachment);
        //营业执照照片url
        attachment.setCertificateFilePath(businessLicense);
        attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
        attachment.setCertificateName(AttachmentEnum.BUSINESS_LICENSE.getDesc());
        tSupplierAttachmentMapper.insertSelective(attachment);
        if (!CollectionUtils.isEmpty(list)) {
            for (Attachement att : list) {
                attachment.setCertificateFilePath(att.getCertificateFilePath());
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
                tSupplierAttachmentMapper.insertSelective(attachment);
            }
        }
    }

    /**
     * @author :winlin
     * @Description :完善专家附件信息
     * @date:2018/10/13
     */
    public void updateExpertAttachment(List<Attachement> list, String legalIdCardPositive, String legalIdCardOther, Long expertId) {
        //跟新时间
        Date date = new Date();
        TExpertAttachment attachment = new TExpertAttachment();
        attachment.setExpertId(expertId);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        //添加身份证正面
        attachment.setCertificateFilePath(legalIdCardPositive);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
        tExpertAttachmentMapper.insertSelective(attachment);
        //法人身份证反面照片url
        attachment.setCertificateFilePath(legalIdCardOther);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
        tExpertAttachmentMapper.insertSelective(attachment);
        if (!CollectionUtils.isEmpty(list)) {
            for (Attachement att : list) {
                attachment.setCertificateFilePath(att.getCertificateFilePath());
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
                tExpertAttachmentMapper.insertSelective(attachment);
            }
        }
    }

    /**
     *@author :winlin
     *@Description : 完善采购人附件信息
     *@date:2018/10/13
     */
    public void updatePuechaserAttachment(List<Attachement> list, String legalIdCardPositive, String legalIdCardOther, String businessLicense, Long purchaserId) {
        //跟新时间
        Date date = new Date();
        TPurchaserAttachment attachment = new TPurchaserAttachment();
        attachment.setPurchaserId(purchaserId);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        //添加身份证正面
        attachment.setCertificateFilePath(legalIdCardPositive);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
        tPurchaserAttachmentMapper.insertSelective(attachment);
        //法人身份证反面照片url
        attachment.setCertificateFilePath(legalIdCardOther);
        attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
        attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
        tPurchaserAttachmentMapper.insertSelective(attachment);
        //营业执照照片url
        attachment.setCertificateFilePath(businessLicense);
        attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
        attachment.setCertificateName(AttachmentEnum.BUSINESS_LICENSE.getDesc());
        tPurchaserAttachmentMapper.insertSelective(attachment);
        if (!CollectionUtils.isEmpty(list)) {
            for (Attachement att : list) {
                attachment.setCertificateFilePath(att.getCertificateFilePath());
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
                tPurchaserAttachmentMapper.insertSelective(attachment);
            }
        }
    }


}
