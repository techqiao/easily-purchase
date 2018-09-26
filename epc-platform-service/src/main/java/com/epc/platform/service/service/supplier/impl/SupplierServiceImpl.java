package com.epc.platform.service.service.supplier.impl;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.supplier.TSupplierAttachment;
import com.epc.platform.service.domain.supplier.TSupplierBasicInfo;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfo;
import com.epc.platform.service.domain.supplier.TSupplierDetailInfoCriteria;
import com.epc.platform.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.platform.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.platform.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import com.epc.platform.service.service.supplier.SupplierService;
import org.apache.commons.lang.StringUtils;
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
        Date date = new Date();
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setPassword(userBasicInfo.getPassword());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
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
        BeanUtils.copyProperties(supplierHandle, tSupplierDetailInfo);
        Date date = new Date();
        tSupplierDetailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);
        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(supplierHandle.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            //公司名称
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(supplierHandle.getCertificateOfAuthorization());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(supplierHandle.getOperatorIdCardFront());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(supplierHandle.getLegalIdCardOther());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(supplierHandle.getLegalIdCardPositive());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(supplierHandle.getBusinessLicense());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //资质证书url
            System.out.println();
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(supplierHandle.getQualificationCertificate());
            return Result.success( tSupplierAttachmentMapper.insertSelective(attachment)>0);
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
    public Result deleteSupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        tSupplierDetailInfo.setId(queryDetailIfo.getWhereid());
        tSupplierDetailInfo.setIsDeleted(1);
        try{
            return Result.success(tSupplierDetailInfoMapper.updateByPrimaryKeySelective(tSupplierDetailInfo)>0);
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
    public Result querySupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        try {
                TSupplierDetailInfo tSupplierDetailInfo = tSupplierDetailInfoMapper.selectByPrimaryKey(queryDetailIfo.getWhereid());
            return Result.success(tSupplierDetailInfo);
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
    public Result selectSupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(queryDetailIfo.getWhere())){
            where = "%" + where + "%";
        }
        return Result.success(tSupplierDetailInfoMapper.selectByName(where));
    }

    @Override
    public List<TSupplierDetailInfo> selectAllSupplierByPage() {
        try {
            TSupplierDetailInfoCriteria criteria = new TSupplierDetailInfoCriteria();
            criteria.setOrderByClause("id desc");
            return tSupplierDetailInfoMapper.selectByExample(criteria);
        } catch (Exception e) {
            LOGGER.error("BusinessException deleteByPrimaryKey : {}",e);
            return new ArrayList<>();
        }
    }
}
