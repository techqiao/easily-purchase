package com.epc.platform.service.service.reviewexpert.impl;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.reviewexpertr.TExpertAttachment;
import com.epc.platform.service.domain.reviewexpertr.TExpertBasicInfo;
import com.epc.platform.service.domain.reviewexpertr.TExpertDetailInfo;
import com.epc.platform.service.domain.reviewexpertr.TExpertDetailInfoCriteria;
import com.epc.platform.service.domain.supplier.TSupplierAttachment;
import com.epc.platform.service.mapper.reviewexpertr.TExpertAttachmentMapper;
import com.epc.platform.service.mapper.reviewexpertr.TExpertBasicInfoMapper;
import com.epc.platform.service.mapper.reviewexpertr.TExpertDetailInfoMapper;
import com.epc.platform.service.service.operator.impl.OperatorServiceImpl;
import com.epc.platform.service.service.reviewexpert.ReviewExpertService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

/**
 * 评审专家实现接口
 */
public class ReviewExpertServiceImpl  implements ReviewExpertService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Autowired
    private TExpertBasicInfoMapper tExpertBasicInfoMapper;

    @Autowired
    private TExpertDetailInfoMapper tExpertDetailInfoMapper;

    @Autowired
    private TExpertAttachmentMapper tExpertAttachmentMapper;

    @Override
    public Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo) {
        TExpertBasicInfo pojo = new TExpertBasicInfo();
        Date date = new Date();
        pojo.setCellphone(userBasicInfo.getCellphone());
        pojo.setPassword(userBasicInfo.getPassword());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.REGISTERED);
        try {
            return Result.success(tExpertBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertExpertBasicInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertExpertBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        BeanUtils.copyProperties(reviewExpertHandle, tExpertDetailInfo);
        Date date = new Date();
        tExpertDetailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        tExpertDetailInfo.setCreateAt(date);
        tExpertDetailInfo.setUpdateAt(date);
        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(reviewExpertHandle.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            System.out.println();
            tExpertDetailInfo.setCompanyName(reviewExpertHandle.getCompanyName());
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            //统一信用代码
            tExpertDetailInfo.setUniformCreditCode(reviewExpertHandle.getCertificateOfAuthorization());
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            //对公银行名称
            tExpertDetailInfo.setPublicBankName(reviewExpertHandle.getPublicBankName());
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            //对公银行账号
            tExpertDetailInfo.setPublicBanAccountNumber(reviewExpertHandle.getPublicBanAccountNumber());
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertExpertDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertExpertDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> deleteExpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        TExpertAttachment tExpertAttachment = new TExpertAttachment();
        tExpertAttachment.setId(queryDetailIfo.getId());
        try{
            return Result.success(tExpertAttachmentMapper.updateByPrimaryKeySelective(tExpertAttachment)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException deleteExpertDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    @Override
    public Result queryExpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        try {

            TExpertDetailInfo tExpertDetailInfo = tExpertDetailInfoMapper.selectByPrimaryKey(queryDetailIfo.getId());
            return Result.success(tExpertDetailInfo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException queryExpertDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
    }

    @Override
    public Result selectExpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        TExpertDetailInfoCriteria tExpertDetailInfoCriteria = new TExpertDetailInfoCriteria();
        TExpertDetailInfoCriteria.Criteria criteria = tExpertDetailInfoCriteria.createCriteria();
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(queryDetailIfo.getWhere())){
            where = "%" + where + "%";
        }
        if(StringUtils.isNotBlank(where)){
            criteria.andCompanyNameEqualTo(where);
        }
        return Result.success(tExpertDetailInfoMapper.selectByExample(tExpertDetailInfoCriteria)) ;
    }
}
