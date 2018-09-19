package com.epc.platform.service.service.supplier.impl;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.Result;
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
import com.epc.platform.service.service.supplier.SupplierUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 供应商实现接口
 */
public class SupplierServiceImpl  implements SupplierUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;

    /**
     * 新增供应商基本信息
     * @param handleOperator
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> insertSupplierUserInfo(UserBasicInfo handleOperator) {
        TSupplierBasicInfo pojo = new TSupplierBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellphone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
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
     * 新增运营商补全信息
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> insertSupplierDetailInfo(SupplierHandle supplierHandle) {
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(supplierHandle, tSupplierDetailInfo);
        Date date = new Date();
        tSupplierDetailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);
        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(supplierHandle.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            //公司名称
            tSupplierDetailInfo.setCompanyName(supplierHandle.getCompanyName());
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
            //统一信用代码
            tSupplierDetailInfo.setUniformCreditCode(supplierHandle.getCertificateOfAuthorization());
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
            //对公银行名称
            tSupplierDetailInfo.setPublicBankName(supplierHandle.getPublicBankName());
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
            //对公银行账号
            tSupplierDetailInfo.setPublicBanAccountNumber(supplierHandle.getPublicBanAccountNumber());
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertSupplierDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertSupplierDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }


    /**
     * 删除运营商
     * @param
     * @return
     */
    @Override
    public Result<Boolean> deleteSupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        TSupplierAttachment tOperatorAttachment = new TSupplierAttachment();
        tOperatorAttachment.setId(queryDetailIfo.getId());
        try{
            return Result.success(tSupplierAttachmentMapper.updateByPrimaryKeySelective(tOperatorAttachment)>0);
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
    public Result queryOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
        try {
            TSupplierDetailInfo tSupplierDetailInfo = tSupplierDetailInfoMapper.selectByPrimaryKey(queryDetailIfo.getId());
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
        TSupplierDetailInfoCriteria tSupplierDetailInfoCriteria = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria criteria = tSupplierDetailInfoCriteria.createCriteria();
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(queryDetailIfo.getWhere())){
            where = "%" + where + "%";
        }
        if(StringUtils.isNotBlank(where)){
            criteria.andCompanyNameEqualTo(where);
        }
        return Result.success(tSupplierDetailInfoMapper.selectByExample(tSupplierDetailInfoCriteria)) ;
    }
}
