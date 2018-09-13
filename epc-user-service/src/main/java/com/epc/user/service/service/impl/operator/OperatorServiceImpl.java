package com.epc.user.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.user.service.domain.operator.TOperatorBasicInfo;
import com.epc.user.service.domain.purchaser.TPurchaserAttachment;
import com.epc.user.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.user.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.user.service.service.operator.OperatorService;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    @Autowired
    TPurchaserAttachmentMapper tPurchaserAttachmentMapper;
    @Autowired
    /**
    * @Description:    新增运营商人员
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 9:48
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 9:48
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @Override
    public Result<Boolean> createOperatorBasicInfo(HandleOperator handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date =new Date();
        pojo.setName(handleOperator.getUserName());
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassWord());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        try {
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (Exception e) {
            LOGGER.error("exception insertOperatorBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }



    /**
    * @Description:    运营商新增采购人
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 9:48
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 9:48
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @Override
    @Transactional
    public Result<Boolean> createPurchaseByOperator(HandlePurchaser handlePurchaser){
        TPurchaserDetailInfo detailInfo =new TPurchaserDetailInfo();
        BeanUtils.copyProperties(handlePurchaser,detailInfo);
        Date date = new Date();
        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        TPurchaserAttachment attachment = new TPurchaserAttachment();
        attachment.setPurchaserId(handlePurchaser.getUserId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        attachment.setIsDeleted(Const.IS_DELETED.IS_DELETED);
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
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

}
