package com.epc.platform.service.service.supplier.impl;

import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.*;
import com.epc.administration.facade.supplier.vo.AttachmentVO;
import com.epc.administration.facade.supplier.vo.SupplierAttachmentVO;
import com.epc.administration.facade.supplier.vo.SupplierUserVO;
import com.epc.administration.facade.supplier.vo.TWinBidVO;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.supplier.*;
import com.epc.platform.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.platform.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.platform.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.platform.service.mapper.supplier.TWinBidMapper;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import com.epc.platform.service.service.supplier.SupplierService;
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
    @Autowired
    private TWinBidMapper tWinBidMapper;

    /**
     * 新增供应商基本信息
     * @param userBasicInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertSupplierUserInfo(UserBasicInfo userBasicInfo) {
        TSupplierBasicInfo pojo = new TSupplierBasicInfo();
        BeanUtils.copyProperties(userBasicInfo,pojo);
        pojo.setName(userBasicInfo.getUsername());
        Date date = new Date();
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        pojo.setInviterId(userBasicInfo.getId());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.REGISTERED);
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertSupplierUserInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
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
        tSupplierDetailInfo.setCompanyAddress(supplierHandle.getCompanyAddress());
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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertSupplierDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
    /**
     * 修改供应商信息
     * @param supplierHandle
     * @return
     */
    @Override
    public Result<Boolean> updateSupplierDetailInfo(SupplierHandle supplierHandle) {
        TSupplierDetailInfoCriteria tSupplierDetailInfoCriteria = new TSupplierDetailInfoCriteria();
        tSupplierDetailInfoCriteria.createCriteria().andSupplierIdEqualTo(supplierHandle.getId());

        TSupplierAttachmentCriteria tSupplierAttachmentCriteria = new TSupplierAttachmentCriteria();
        tSupplierAttachmentCriteria.createCriteria().andSupplierIdEqualTo(supplierHandle.getId());

        try {
            tSupplierDetailInfoMapper.deleteByExample(tSupplierDetailInfoCriteria);
            tSupplierAttachmentMapper.deleteByExample(tSupplierAttachmentCriteria);
            return this.insertSupplierDetailInfo(supplierHandle);
        } catch (Exception e) {
            LOGGER.error("BusinessException updateSupplierDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
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
            LOGGER.error("BusinessException deleteSupplierDetailInfo : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
        supplierAttachmentVO.setCreateAt(tSupplierBasicInfo.getCreateAt());
        //如果没有完善信息
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
                if(tSupplierAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
                    supplierAttachmentVO.setLegalIdCardPositive(tSupplierAttachment.getCertificateFilePath());
                }else if(tSupplierAttachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
                    supplierAttachmentVO.setLegalIdCardOther(tSupplierAttachment.getCertificateFilePath());
                }else if (tSupplierAttachment.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())){
                    supplierAttachmentVO.setBusinessLicense(tSupplierAttachment.getCertificateType());

                }else {
                    AttachmentVO attachmentVO = new AttachmentVO();
                    attachmentVO.setCertificateFilePath(tSupplierAttachment.getCertificateFilePath());
                    attachmentVO.setCertificateName(tSupplierAttachment.getCertificateName());
                    attachmentVOS.add(attachmentVO);
                }
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
        String where = queryDetailIfo.getWhere();
        if(where!=null){
            where="%"+where+"%";
            queryDetailIfo.setWhere(where);
        }else{
            queryDetailIfo.setWhere(null);
        }
        return  tSupplierDetailInfoMapper.selectByPage(queryDetailIfo);
    }
    /**
     * 审核供应商
     * @param examineSupplierHandle
     * @return
     */
    @Override
    public Result<Boolean> examineSupplier(ExamineSupplierHandle examineSupplierHandle) {
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setState(examineSupplierHandle.getState());
        tSupplierBasicInfo.setId(examineSupplierHandle.getSupplierId());
        return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
    }

    /**
     * 启用禁用供应商
     * @param supplierForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenSupplierUser(SupplierForbiddenHandle supplierForbiddenHandle) {
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setId(supplierForbiddenHandle.getId());
        tSupplierBasicInfo.setIsForbidden(supplierForbiddenHandle.getIsForbidden());
        return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
    }

    /**
     * 供应商考评中标业绩列表
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<List<TWinBidVO>> supplierReviewWinningBid(QueryDetailIfo queryDetailIfo) {
        List<TWinBidVO> tWinBidVOList = new ArrayList<>();
        TWinBidVO tWinBidVO = new TWinBidVO();
        TWinBidCriteria tWinBidCriteria= new TWinBidCriteria();
        tWinBidCriteria.setOrderByClause("id desc");
        List<TWinBid> tWinBids = tWinBidMapper.selectByExample(tWinBidCriteria);
        List<Long> supplierIds = new ArrayList<>();
        for (TWinBid tWinBid : tWinBids) {
            tWinBidVO.setCreateAt(tWinBid.getCreateAt());
            tWinBidVO.setProcurementProjectName(tWinBid.getProcurementProjectName());
            TSupplierDetailInfoCriteria tSupplierDetailInfoCriteria = new TSupplierDetailInfoCriteria();
            tSupplierDetailInfoCriteria.createCriteria().andSupplierIdEqualTo(tWinBid.getSupplierId());
            List<TSupplierDetailInfo> tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(tSupplierDetailInfoCriteria);
            tWinBidVO.setSupplierName(tSupplierDetailInfos.get(0).getCompanyName());
            tWinBidVOList.add(tWinBidVO);
        }
        return Result.success(tWinBidVOList);
    }

    /**
     * 供应商考评 奖惩
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result supplierReviewRewardAndPunishment(QueryDetailIfo queryDetailIfo) {

        return null;

    }

    /**
     * 供应商考评 履约记录
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result supplierReviewRecordOfPerformance(QueryDetailIfo queryDetailIfo) {
        return null;

    }
    /**
     * 根据ID 查供应商考评 履约记录详情
     * @param id
     * @return
     */
    @Override
    public Result supplierReviewRecordOfPerformanceDetail(Long id) {
        return null;
    }

}
