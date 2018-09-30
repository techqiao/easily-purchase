package com.epc.platform.service.service.supplier.impl;

import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.AttachmentHandle;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.vo.AttachmentVO;
import com.epc.administration.facade.supplier.vo.SupplierAttachmentVO;
import com.epc.administration.facade.supplier.vo.SupplierUserVO;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.supplier.*;
import com.epc.platform.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.platform.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.platform.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import com.epc.platform.service.service.supplier.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 供应商实现接口
 * @author luozhixin
 * @date 2018-9-15 20:27:36
 */
@Service
public class SupplierServiceImpl  implements SupplierService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;

    /**
     * 新增供应商基本信息
     * @param userBasicInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertSupplierUserInfo(UserBasicInfo userBasicInfo) {
        TSupplierBasicInfo pojo = new TSupplierBasicInfo();
        pojo.setName(userBasicInfo.getName());
        pojo.setInviterType(0);
        pojo.setInviterId(0L);
        pojo.setInviterCompanyId(0);
        pojo.setSupplierId(0L);
        Date date = new Date();
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setPassword("123456");
        pojo.setName(userBasicInfo.getUsername());
        pojo.setState(Const.STATE.REGISTERED);
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertSupplierBasicInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertSupplierBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增供应商补全信息
     * @param supplierHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertSupplierDetailInfo(SupplierHandle supplierHandle) {
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        tSupplierDetailInfo.setSupplierId(supplierHandle.getId());
        tSupplierDetailInfo.setCompanyName(supplierHandle.getCompanyName());
        tSupplierDetailInfo.setUniformCreditCode(supplierHandle.getUniformCreditCode());
        tSupplierDetailInfo.setPublicBankName(supplierHandle.getPublicBankName());
        tSupplierDetailInfo.setPublicBanAccountNumber(supplierHandle.getPublicBanAccountNumber());
        Date date = new Date();
        tSupplierDetailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);
        List<AttachmentHandle> AttachmentHandles = supplierHandle.getAttachmentHandleList();
        try {
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
            //经办人(运营商员工)手持身份证正面照片url
            TSupplierAttachment attachment = new TSupplierAttachment();
            attachment.setSupplierId(supplierHandle.getId());
            attachment.setCreateAt(date);
            attachment.setUpdateAt(date);
            attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
            attachment.setCertificateFilePath(supplierHandle.getLegalIdCardPositive());
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateFilePath(supplierHandle.getLegalIdCardOther());
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateFilePath(supplierHandle.getBusinessLicense());
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //新增完善资料的资质证书
            for (AttachmentHandle attachmentHandle : AttachmentHandles) {
                TSupplierAttachment attachments = new TSupplierAttachment();
                attachments.setSupplierId(supplierHandle.getId());
                attachments.setCreateAt(date);
                attachments.setUpdateAt(date);
                attachments.setIsDeleted(Const.IS_DELETED.IS_DELETED);
                attachments.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachments.setCertificateFilePath(attachmentHandle.getCertificateFilePath());
                attachments.setCertificateName(attachmentHandle.getCertificateName());
                tSupplierAttachmentMapper.insertSelective(attachments);
            }
            //完善信息完成后 更新信息状态至已提交
            TSupplierBasicInfo tSupplierBasicInfo =new TSupplierBasicInfo();
            tSupplierBasicInfo.setId(supplierHandle.getId());
            tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
            tSupplierBasicInfo.setUpdateAt(new Date());
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertSupplierDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertSupplierDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }
    /**
     * 删除供应商
     * @param
     * @return
     */
    @Override
    public Result deleteSupplierDetailInfo( Long whereId) {
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setId(whereId);
        tSupplierBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try{
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 查询供应商基本信息
     * @param
     * @return
     */
    @Override
    public Result querySupplierDetailInfo(Long id) {
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        if(tSupplierBasicInfo==null){
            return Result.error("未找到该用户");
        }
        SupplierAttachmentVO supplierAttachmentVO = new SupplierAttachmentVO();
        supplierAttachmentVO.setId(tSupplierBasicInfo.getId());
        supplierAttachmentVO.setIsDeleted(tSupplierBasicInfo.getIsDeleted());
        supplierAttachmentVO.setCellphone(tSupplierBasicInfo.getCellphone());
        supplierAttachmentVO.setState(tSupplierBasicInfo.getState());
        supplierAttachmentVO.setName(tSupplierBasicInfo.getName());
        if(tSupplierBasicInfo.getState()!=0){
            TSupplierDetailInfoCriteria criteria = new TSupplierDetailInfoCriteria();
            criteria.createCriteria().andSupplierIdEqualTo(id);
            List<TSupplierDetailInfo> tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(criteria);
            TSupplierDetailInfo tSupplierDetailInfo = tSupplierDetailInfos.get(0);
            supplierAttachmentVO.setCompanyName(tSupplierDetailInfo.getCompanyName());
            supplierAttachmentVO.setUniformCreditCode(tSupplierDetailInfo.getUniformCreditCode());
            supplierAttachmentVO.setPublicBankName(tSupplierDetailInfo.getPublicBankName());
            supplierAttachmentVO.setPublicBanAccountNumber(tSupplierDetailInfo.getPublicBanAccountNumber());
            TSupplierAttachmentCriteria attachment= new TSupplierAttachmentCriteria();
            attachment.createCriteria().andSupplierIdEqualTo(tSupplierBasicInfo.getId());
            List<TSupplierAttachment> tSupplierAttachments = tSupplierAttachmentMapper.selectByExample(attachment);

            List<AttachmentVO> attachmentVOS = new ArrayList<>();
            for (TSupplierAttachment tSupplierAttachment : tSupplierAttachments) {
                AttachmentVO attachmentVO = new AttachmentVO();
                attachmentVO.setCertificateType(tSupplierAttachment.getCertificateType());
                attachmentVO.setCertificateFilePath(tSupplierAttachment.getCertificateFilePath());
                attachmentVO.setCertificateName(tSupplierAttachment.getCertificateName());
                attachmentVOS.add(attachmentVO);
            }
            supplierAttachmentVO.setAttachmentVOList(attachmentVOS);
            return Result.success(supplierAttachmentVO);
        }
            return Result.success(supplierAttachmentVO);

    }
    /**
     * 查询所有供应商
     * @param queryDetailIfo
     * @return
     */
    @Override
    public List<SupplierUserVO> selectAllSupplierByPage(QueryDetailIfo queryDetailIfo) {

        return  tSupplierDetailInfoMapper.selectByPage(queryDetailIfo);
    }
    /**
     * 审核运营商
     * @param examineSupplierHandle
     * @return
     */
    @Override
    public Result<Boolean> examineSupplier(ExamineSupplierHandle examineSupplierHandle) {
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setState(examineSupplierHandle.getState());
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria() ;
        criteria.createCriteria().andIdEqualTo(examineSupplierHandle.getSupplierId());
        return Result.success(tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo,criteria)>0);
    }


}
