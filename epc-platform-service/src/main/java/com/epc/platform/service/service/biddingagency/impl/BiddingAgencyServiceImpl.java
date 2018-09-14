package com.epc.platform.service.service.biddingagency.impl;

import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.platform.service.domain.admin.SysAdminResourceCriteria;
import com.epc.platform.service.domain.admin.SysAdminUserCriteria;
import com.epc.platform.service.domain.tagency.TAgencyAttachment;
import com.epc.platform.service.domain.tagency.TAgencyBasicInfo;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfo;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfoCriteria;
import com.epc.platform.service.mapper.tagency.TAgencyAttachmentMapper;
import com.epc.platform.service.mapper.tagency.TAgencyBasicInfoMapper;
import com.epc.platform.service.mapper.tagency.TAgencyDetailInfoMapper;
import com.epc.platform.service.service.biddingagency.BiddingAgencyService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * <p>Description : 招标代理机构接口实现类
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
@Service
public class BiddingAgencyServiceImpl implements BiddingAgencyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiddingAgencyServiceImpl.class);

    @Autowired
    private TAgencyBasicInfoMapper tAgencyBasicInfoMapper;
    @Autowired
    private TAgencyDetailInfoMapper tAgencyDetailInfoMapper;
    @Autowired
    private TAgencyAttachmentMapper tAgencyAttachmentMapper;

    /**
     * 新增招标代理机构基本信息
     * @param
     * @return
     */
    @Override
    @Transactional
    public Result<Boolean> insertBiddingAgencyBasicInfo(UserBasicInfo handleOperator) {
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        Date date = new Date();
        tAgencyBasicInfo.setCellphone(handleOperator.getCellphone());
        tAgencyBasicInfo.setPassword(handleOperator.getPassword());
        tAgencyBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tAgencyBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        tAgencyBasicInfo.setCreateAt(date);
        tAgencyBasicInfo.setUpdateAt(date);
        tAgencyBasicInfo.setState(Const.STATE.REGISTERED);
        try {
            return Result.success(tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException inserttAgencyBasicInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException inserttAgencyBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }



    /**
     * 新增招标代理机构补全信息
     * @param
     * @return
     */
    @Override
    @Transactional
    public Result<Boolean> insertBiddingAgencyDetailInfo(BiddingHandle biddingHandle) {
        SysAdminResourceCriteria sysAdminResourceCriteria = new SysAdminResourceCriteria();
        SysAdminResourceCriteria.Criteria criteria1 = sysAdminResourceCriteria.createCriteria();
        SysAdminUserCriteria sysAdminUserCriteria = new SysAdminUserCriteria();
        SysAdminUserCriteria.Criteria criteria = sysAdminUserCriteria.createCriteria();
        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
        BeanUtils.copyProperties(biddingHandle, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        try {
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            //公司名称
            detailInfo.setCompanyName(biddingHandle.getCompanyName());
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            //统一信用代码
            detailInfo.setUniformCreditCode(biddingHandle.getCertificateOfAuthorization());
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            //对公银行名称
            detailInfo.setPublicBankName(biddingHandle.getPublicBankName());
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            //对公银行账号
            detailInfo.setPublicBanAccountNumber(biddingHandle.getPublicBanAccountNumber());
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("BusinessException inserttAgencyDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException inserttAgencyDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }



    /**
     * 删除招标代理机构
     * @param
     * @return
     */
    @Override
    public Result<Boolean> deleteBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo) {
        TAgencyAttachment tAgencyAttachment = new TAgencyAttachment();
        tAgencyAttachment.setId(queryDetailIfo.getId());
        try{
            return Result.success(tAgencyAttachmentMapper.updateByPrimaryKeySelective(tAgencyAttachment)>0);
        }catch (BusinessException e){
            LOGGER.error("BusinessException updateByPrimaryKeySelective : {}", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }





    /**
     * 查询招标代理机构基本信息
     * @param
     * @return
     */
    @Override
    public Result queryBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo) {
            try {

                TAgencyDetailInfo tAgencyDetailInfo = tAgencyDetailInfoMapper.selectByPrimaryKey(queryDetailIfo.getId());
                return Result.success(tAgencyDetailInfo);
            } catch (BusinessException e) {
                LOGGER.error("BusinessException deleteByPrimaryKey : {}", e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }
    }




    /**
     * 根据公司名模糊查询招标代理机构
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result selectBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo) {
        TAgencyDetailInfoCriteria tAgencyDetailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria = tAgencyDetailInfoCriteria.createCriteria();
        String where = queryDetailIfo.getWhere();
        if(StringUtils.isNotBlank(queryDetailIfo.getWhere())){
            where = "%" + where + "%";
        }
        if(StringUtils.isNotBlank(where)){
            criteria.andCompanyNameEqualTo(where);
        }
        return Result.success(tAgencyDetailInfoMapper.selectByExample(tAgencyDetailInfoCriteria)) ;
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
