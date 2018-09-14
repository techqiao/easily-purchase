package com.epc.user.service.service.impl.purchaser;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.user.service.domain.agency.TAgencyAttachment;
import com.epc.user.service.domain.agency.TAgencyBasicInfo;
import com.epc.user.service.domain.expert.TExpertBasicInfo;
import com.epc.user.service.domain.operator.TOperatorPurchaser;
import com.epc.user.service.domain.purchaser.TPurchaserAttachment;
import com.epc.user.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.user.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.user.service.domain.purchaser.TPurchaserExpert;
import com.epc.user.service.domain.supplier.TSupplierAttachment;
import com.epc.user.service.domain.supplier.TSupplierBasicInfo;
import com.epc.user.service.domain.supplier.TSupplierDetailInfo;
import com.epc.user.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.user.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.user.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.user.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.user.service.mapper.purchaser.*;
import com.epc.user.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.user.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.user.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.user.service.service.impl.operator.OperatorServiceImpl;
import com.epc.user.service.service.purchaser.PurchaserService;
import com.epc.user.service.service.supplier.TSupplierBasicInfoService;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PurchaserServiceImpl implements PurchaserService {
    @Autowired
    TPurchaserBasicInfoMapper  tPurchaserBasicInfoMapper;
    @Autowired
    TPurchaserUserMapper tPurchaserUserMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TOperatorPurchaserMapper tOperatorPurchaserMapper;
    @Autowired
    TSupplierBasicInfoService tSupplierBasicInfoService;
    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    TSupplierAttachmentMapper tSupplierAttachmentMapper;
    @Autowired
    TExpertBasicInfoMapper tExpertBasicInfoMapper;
    @Autowired
    TAgencyBasicInfoMapper tAgencyBasicInfoMapper;
    @Autowired
    PurchaserService purchaserService;
    @Autowired
    TAgencyAttachmentMapper tAgencyAttachmentMapper;
    @Autowired
    TPurchaserAttachmentMapper tPurchaserAttachmentMapper;
    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    TPurchaserExpertMapper tPurchaserExpertMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);


    /**
    * @Description:    新增 运营商--采购人员关系记录
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 13:47
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 13:47
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public  Result<Boolean> createOperatePurchaser(HandlePurchaser handleOperator){
        TOperatorPurchaser pojo=new TOperatorPurchaser();
        Date date =new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setOperatorId(handleOperator.getOperatorId());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            tOperatorPurchaserMapper.insertSelective(pojo);
        }catch (BusinessException e){
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }
        return Result.success();
    }


    /**
     * @Description:    采购人新增 供应商信息
     * @Author:         linzhixiang
     * @CreateDate:     2018/9/13 13:47
     * @UpdateUser:     linzhixiang
     * @UpdateDate:     2018/9/13 13:47
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @Override
    @Transactional
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleSupplierDetail) {

        TSupplierBasicInfo pojo=new TSupplierBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleSupplierDetail.getCellPhone());
        pojo.setName(handleSupplierDetail.getName());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            return  Result.success(tSupplierBasicInfoMapper.insertSelective(pojo)>0);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }



    /**
     * @Description:    采购人新增 专家（私库）
     * @Author:         linzhixiang
     * @CreateDate:     2018/9/13 13:47
     * @UpdateUser:     linzhixiang
     * @UpdateDate:     2018/9/13 13:47
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @Override
    public Result<Boolean> createExpertUserInfo(HandleExpert handleExpert) {
        //公库新增
        TExpertBasicInfo pojo=new TExpertBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleExpert.getCellPhone());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setName(handleExpert.getName());
        pojo.setProfession(handleExpert.getProfession());
        pojo.setPositional(handleExpert.getPositional());
        pojo.setLevel(handleExpert.getLevel());
        pojo.setCircularDt(handleExpert.getCircularDt());
        pojo.setCircularMethod(handleExpert.getCircularMethod());
        pojo.setOtherInformation(handleExpert.getOtherInformation());
        //私库新增
        TPurchaserExpert operator=new TPurchaserExpert();
        operator.setCellphone(handleExpert.getCellPhone());
        operator.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        operator.setState(Const.STATE.REGISTERED);
        operator.setCreateAt(date);
        operator.setUpdateAt(date);
        try {
            tExpertBasicInfoMapper.insertSelective(pojo);
            tPurchaserExpertMapper.insertSelective(operator);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException createExpertUserInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException createExpertUserInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }


    /**
     * 新增代理机构人员
     * @param handleAgnecy
     * @return
     */
    @Override
    @Transactional
    public Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy) {
        TAgencyBasicInfo pojo=new TAgencyBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleAgnecy.getCellPhone());
        pojo.setName(handleAgnecy.getName());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            //提交到 数据库
            tAgencyBasicInfoMapper.insertSelective(pojo);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }


    /**
     * @Description 新增 采购人员信息
     * @Author linzhixiang
     * @param handleOperator
     * @return
     */
    public Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType) {

        TPurchaserBasicInfo pojo=new TPurchaserBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(roleType);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            tPurchaserBasicInfoMapper.insertSelective(pojo);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 完善采购人信息
     * @param handlePurchaser
     * @return
     */
    @Override
    @Transactional
    public Result<Boolean> updatePurchaserDetail(HandlePurchaser handlePurchaser) {
        TPurchaserDetailInfo detailInfo = new TPurchaserDetailInfo();
        BeanUtils.copyProperties(handlePurchaser, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        //新增附件
        TPurchaserAttachment attachment = new TPurchaserAttachment();
        attachment.setPurchaserId(handlePurchaser.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            tPurchaserDetailInfoMapper.insertSelective(detailInfo);
            //带公章的授权书照片url
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(handlePurchaser.getCertificateOfAuthorization());
            tPurchaserAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(handlePurchaser.getOperatorIdCardFront());
            tPurchaserAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(handlePurchaser.getLegalIdCardOther());
            tPurchaserAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(handlePurchaser.getLegalIdCardPositive());
            tPurchaserAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(handlePurchaser.getBusinessLicense());
            tPurchaserAttachmentMapper.insertSelective(attachment);
            //资质证书url
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(handlePurchaser.getQualificationCertificate());
            tPurchaserAttachmentMapper.insertSelective(attachment);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 完善供应商信息
     * @param HandleSupplierDetail
     * @return
     */
    @Override
    public Result<Boolean> updateSupplierDetail(HandleSupplierDetail HandleSupplierDetail) {
        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(HandleSupplierDetail, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        //新增附件
        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(HandleSupplierDetail.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            tSupplierDetailInfoMapper.insertSelective(detailInfo);
            //带公章的授权书照片url
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(HandleSupplierDetail.getCertificateOfAuthorization());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(HandleSupplierDetail.getOperatorIdCardFront());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(HandleSupplierDetail.getLegalIdCardOther());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(HandleSupplierDetail.getLegalIdCardPositive());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(HandleSupplierDetail.getBusinessLicense());
            tSupplierAttachmentMapper.insertSelective(attachment);
            //资质证书url
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(HandleSupplierDetail.getQualificationCertificate());
            tSupplierAttachmentMapper.insertSelective(attachment);
            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy) {
        TAgencyBasicInfo detailInfo = new TAgencyBasicInfo();
        BeanUtils.copyProperties(handleAgnecy, detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        //新增附件
        TAgencyAttachment attachment = new TAgencyAttachment();
        attachment.setAgencyId(handleAgnecy.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            tAgencyBasicInfoMapper.insertSelective(detailInfo);
            //带公章的授权书照片url
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateFilePath(handleAgnecy.getCertificateOfAuthorization());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateFilePath(handleAgnecy.getOperatorIdCardFront());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //法人身份证反面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateFilePath(handleAgnecy.getLegalIdCardOther());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //法人身份证正面照片url
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateFilePath(handleAgnecy.getLegalIdCardPositive());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //营业执照照片url
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateFilePath(handleAgnecy.getBusinessLicense());
            tAgencyAttachmentMapper.insertSelective(attachment);
            //资质证书url
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            attachment.setCertificateFilePath(handleAgnecy.getQualificationCertificate());
            tAgencyAttachmentMapper.insertSelective(attachment);

        }catch (BusinessException e) {
            LOGGER.error("BusinessException updateAgencyDetail : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException updateAgencyDetail : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

}