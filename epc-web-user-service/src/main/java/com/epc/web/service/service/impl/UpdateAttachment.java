package com.epc.web.service.service.impl;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.web.facade.agency.handle.Attachement;
import com.epc.web.service.domain.agency.TAgencyAttachment;
import com.epc.web.service.domain.agency.TAgencyDetailInfo;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.purchaser.TPurchaserAttachment;
import com.epc.web.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
     * @author :winlin
     * @Description : 完善采购人附件信息
     * @date:2018/10/13
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

    public Result whichIsDuplicateForAgency(TAgencyDetailInfo detailInfo, String companyName, String uniformCreditCode, String publicBanAccountNumber) {
        if (detailInfo != null) {
            if (detailInfo.getPublicBanAccountNumber().equals(publicBanAccountNumber)) {
                return Result.success("对公账号已存在");
            }
            if (detailInfo.getUniformCreditCode().equals(uniformCreditCode)) {
                return Result.success("统一信用编码已存在");
            }
            if (detailInfo.getCompanyName().equals(companyName)) {
                return Result.success("公司已存在");
            }
        }
        return null;
    }

    public Result whichIsDuplicateForPurchaser(TPurchaserDetailInfo detailInfo, String companyName, String uniformCreditCode, String publicBanAccountNumber) {
        if (detailInfo != null) {
            if (detailInfo.getPublicBanAccountNumber().equals(publicBanAccountNumber)) {
                return Result.success("对公账号已存在");
            }
            if (detailInfo.getUniformCreditCode().equals(uniformCreditCode)) {
                return Result.success("统一信用编码已存在");
            }
            if (detailInfo.getCompanyName().equals(companyName)) {
                return Result.success("公司已存在");
            }
        }
        return null;
    }

    public Result whichIsDuplicateForSupplier(TSupplierDetailInfo detailInfo, String companyName, String uniformCreditCode, String publicBanAccountNumber) {
        if (detailInfo != null) {
            if (detailInfo.getPublicBanAccountNumber().equals(publicBanAccountNumber)) {
                return Result.success("对公账号已存在");
            }
            if (detailInfo.getUniformCreditCode().equals(uniformCreditCode)) {
                return Result.success("统一信用编码已存在");
            }
            if (detailInfo.getCompanyName().equals(companyName)) {
                return Result.success("公司已存在");
            }
        }
        return null;
    }

    public Result whichIdDuplicate(Class<?> clazzTarget, Class<?> clazzSource) {
        //获得目标资源字段
        Field[] fields = clazzTarget.getDeclaredFields();
        //获得源目标的字段
        Field[] fields1 = clazzSource.getDeclaredFields();
        for (Field f : fields) {
            for (Field field : fields1) {
                if (f.getName().equals(field.getName())) {
                    String methodName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                    try {
                        Method methodSource = clazzSource.getMethod(methodName);
                        Method methodTarget = clazzTarget.getMethod(methodName);
                        methodSource.setAccessible(true);
                        methodTarget.setAccessible(true);
                        String source = (String) methodSource.invoke(clazzSource.newInstance());
                        String target = (String) methodTarget.invoke(clazzTarget.newInstance());
                        if (source.equals(target)) {
                            if (methodSource.getName().equals("setUniformCreditCode")) {
                                return Result.success("统一信用编码已存在");
                            }
                            if (methodSource.getName().equals("setPublicBanAccountNumber")) {
                                return Result.success("对公银行账号已存在");
                            }
                            if (methodSource.getName().equals("setCompanyName")) {
                                return Result.success("公司名称已存在");
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
