package com.epc.web.service.service.impl.purchaser;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.handle.HandPurchaserAttachment;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.purchaser.handle.HandleRegisterPurchaser;
import com.epc.web.facade.purchaser.vo.PurchaserEmplyeeVo;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.service.domain.agency.TAgencyAttachment;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.agency.TAgencyBasicInfoCriteria;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfoCriteria;
import com.epc.web.service.domain.operator.TOperatorPurchaser;
import com.epc.web.service.domain.operator.TOperatorPurchaserCriteria;
import com.epc.web.service.domain.purchaser.*;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.web.service.mapper.purchaser.*;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.impl.operator.OperatorServiceImpl;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PurchaserServiceImpl implements PurchaserService {
    @Autowired
    TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;
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
     * @Description: 新增 运营商--采购人员关系记录
     * @Author: linzhixiang
     * @CreateDate: 2018/9/13 13:47
     * @UpdateUser: linzhixiang & winlin
     * @UpdateDate: 2018/9/13 13:47
     * @UpdateRemark: 修改内容，所有的新增先依据name和cellphone查询是否存在
     * @Version: 1.0
     */
    @Override
    public Result<Boolean> createOperatePurchaser(HandlePurchaser handleOperator) {
        TOperatorPurchaserCriteria criteria = new TOperatorPurchaserCriteria();
        TOperatorPurchaserCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andPurchaserNameEqualTo(handleOperator.getName());
        criteria1.andCellphoneEqualTo(handleOperator.getCellPhone());
        List<TOperatorPurchaser> list = tOperatorPurchaserMapper.selectByExample(criteria);
        if (list.size() > 0) {
            return Result.error("采购人员" + handleOperator.getName() + "已存在,勿重复添加");
        }


        TOperatorPurchaser pojo = new TOperatorPurchaser();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone() != null ? handleOperator.getCellPhone() : null);
        pojo.setOperatorId(handleOperator.getOperatorId() != 0 ? handleOperator.getOperatorId() : 0);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            tOperatorPurchaserMapper.insertSelective(pojo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }
        return Result.success();
    }


    /**
     * @Description: 采购人新增 供应商信息
     * @Author: linzhixiang
     * @CreateDate: 2018/9/13 13:47
     * @UpdateUser: linzhixiang & winlin
     * @UpdateDate: 2018/9/13 13:47
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleSupplierDetail) {

        //同一个要约人不能再数据库中有两条以上相同信息的供货商,根据要约人的id
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andCellphoneEqualTo(handleSupplierDetail.getCellPhone());
        criteria1.andNameEqualTo(handleSupplierDetail.getName());
        criteria1.andInviterIdEqualTo(handleSupplierDetail.getOperatorId());
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
        if (list.size() > 0) {
            return Result.error("供应商" + handleSupplierDetail.getName() + "已存在,勿重复添加");
        }


        TSupplierBasicInfo pojo = new TSupplierBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleSupplierDetail.getCellPhone() != null ? handleSupplierDetail.getCellPhone() : null);
        pojo.setName(handleSupplierDetail.getName() != null ? handleSupplierDetail.getName() : null);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setInviterId(handleSupplierDetail.getOperatorId());
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
    }


    /**
     * @Description: 采购人新增 专家（私库）
     * @Author: linzhixiang
     * @CreateDate: 2018/9/13 13:47
     * @UpdateUser: linzhixiang & winlin
     * @UpdateDate: 2018/9/13 13:47
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */
    @Override
    public Result<Boolean> createExpertUserInfo(HandleExpert handleExpert) {
        System.out.println("房价肯定撒恢复健康哈撒房间看撒谎房间卡死了好合计罚款多少拉回到附近开了:" + handleExpert.getName());
        //根据提供的name和cellphone查询专家信息专家状态为已审核状态自动根跟新全部信息到私库,其他情况私库添加手机号码和name
        //以及经办人id
        TExpertBasicInfoCriteria criteria = new TExpertBasicInfoCriteria();
        TExpertBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andNameEqualTo(handleExpert.getName());
        criteria1.andCellphoneEqualTo(handleExpert.getCellPhone());
        List<TExpertBasicInfo> list = tExpertBasicInfoMapper.selectByExample(criteria);
        if (list.size() > 0) {
            TExpertBasicInfo basicInfo = list.get(0);
            int state = basicInfo.getState(); //状态由数据库负责更新
            //同步到私库中,增加之前先查询私库是否存在
            TPurchaserExpertCriteria expertCriteria = new TPurchaserExpertCriteria();
            TPurchaserExpertCriteria.Criteria criteria2 = expertCriteria.createCriteria();
            criteria2.andCellphoneEqualTo(handleExpert.getCellPhone());
            criteria2.andExpertNameEqualTo(handleExpert.getName());
            List<TPurchaserExpert> purchaserBasicInfos = tPurchaserExpertMapper.selectByExample(expertCriteria);
            if (purchaserBasicInfos.size() > 0) {
                return Result.error("专家:" + handleExpert.getName() + "已存在");
            } else {
                TPurchaserExpert tPurchaserExpert = new TPurchaserExpert();
                tPurchaserExpert.setCellphone(basicInfo.getCellphone());
                tPurchaserExpert.setExpertName(basicInfo.getName());
                if (state == Const.STATE.AUDIT_SUCCESS) {
                    //专家不在私库中
                    tPurchaserExpert.setExpertId(basicInfo.getId());
                    tPurchaserExpert.setPassword(basicInfo.getPassword());
                    tPurchaserExpert.setState(state);
                    return tPurchaserExpertMapper.insertSelective(tPurchaserExpert) > 0 ? Result.<Boolean>success() : Result.<Boolean>error();
                } else {
                    //添加信息到私库中,添加之前查询是否存在
                    return tPurchaserExpertMapper.insertSelective(tPurchaserExpert) > 0 ? Result.<Boolean>success() : Result.<Boolean>error();
                }
            }

        } else {
            //公库新增
            TExpertBasicInfo pojo = new TExpertBasicInfo();
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
            TPurchaserExpert operator = new TPurchaserExpert();
            operator.setCellphone(handleExpert.getCellPhone());
            operator.setIsDeleted(Const.IS_DELETED.IS_DELETED);
            operator.setState(Const.STATE.REGISTERED);
            operator.setCreateAt(date);
            operator.setUpdateAt(date);
            try {
                tExpertBasicInfoMapper.insertSelective(pojo);
                tPurchaserExpertMapper.insertSelective(operator);
            } catch (BusinessException e) {
                LOGGER.error("BusinessException createExpertUserInfo : {}", e);
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            } catch (Exception e) {
                LOGGER.error("BusinessException createExpertUserInfo : {}", e);
                return Result.error(e.getMessage());
            }
        }

        return Result.success();
    }


    /**
     * 新增代理机构人员
     *
     * @param handleAgnecy
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy) {
        //先查询是否存在,不存在添加私库
        TAgencyBasicInfoCriteria infoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andNameEqualTo(handleAgnecy.getName());
        criteria.andCellphoneEqualTo(handleAgnecy.getCellPhone());
        List<TAgencyBasicInfo> list = tAgencyBasicInfoMapper.selectByExample(infoCriteria);
        if (list.size() > 0) {
            return Result.error("员工:" + handleAgnecy.getName() + "已存在");
        }
        TAgencyBasicInfo pojo = new TAgencyBasicInfo();
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
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }


    /**
     * @param handleOperator
     * @return
     * @Description 新增 采购人员信息
     * @Author linzhixiang
     */
    @Override
    public Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType) {
        //先查询是否存在,不存在添加私库
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andNameEqualTo(handleOperator.getName());
        criteria.andCellphoneEqualTo(handleOperator.getCellPhone());
        List<TPurchaserBasicInfo> list = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);
        if (list.size() > 0) {
            return Result.error("员工:" + handleOperator.getName() + "已存在");
        }
        TPurchaserBasicInfo pojo = new TPurchaserBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(roleType);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setName(handleOperator.getName());
        try {
            tPurchaserBasicInfoMapper.insertSelective(pojo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 完善采购人信息
     *
     * @param handlePurchaser
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
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
        } catch (BusinessException e) {
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 完善供应商信息
     *
     * @param HandleSupplierDetail ,依据页面提供的信息更新,需增加查询接口
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
        } catch (BusinessException e) {
            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
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

        } catch (BusinessException e) {
            LOGGER.error("BusinessException updateAgencyDetail : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("BusinessException updateAgencyDetail : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 采购人注册
     * @param purchaser
     * @return
     */
    @Override
    public Result registerPurchaser(HandleRegisterPurchaser purchaser) {
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        //或的基本信息密码加密密码加密
        basicInfo.setCellphone(purchaser.getCellphone());
        basicInfo.setPassword(MD5Util.MD5EncodeUtf8(purchaser.getPassword()));
        Result result = new Result();
        int sucess = tAgencyBasicInfoMapper.insertSelective(basicInfo);
        if (sucess > 0) {
            result.setData(purchaser);
            result.setMsg("注册成功");
            return result;
        }
        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
    }

    /**
     * 查找所有的员工
     *
     * @return
     */
    @Override
    public Result allEmployee(Long supplierId) {
        List<PurchaserEmplyeeVo> emplyeeVos = tPurchaserBasicInfoMapper.queryEmplyees(supplierId);
        if (emplyeeVos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", emplyeeVos);
    }

    /**
     * 通过姓名模糊查找
     *
     * @param fuzzyName
     * @return
     */
    @Override
    public Result findEmployeeByName(String fuzzyName,Long purchaseId) {
        List<PurchaserEmplyeeVo> emplyeeVos = tPurchaserBasicInfoMapper.findEmployeeByName(fuzzyName,purchaseId);
        if (emplyeeVos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", emplyeeVos);
    }

    /**
     * 修改员工状态是否禁用,修改is_delete
     *
     * @param cellphone 手机号
     * @return
     */
    @Override
    public Result updateEmployeeState(String cellphone, Integer state) {
        int sucess = tPurchaserBasicInfoMapper.updateEmployeeStateByCellphone(cellphone, state);
        return sucess > 0 ? Result.success("跟新成功") : Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
    }

    /**
     * 修改员工状态根据id
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public Result updateEmployeeState(Long id, Integer state) {
        int sucess = tPurchaserBasicInfoMapper.updateEmployeeStateById(id, state);
        return sucess > 0 ? Result.success("跟新成功") : Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
    }

    /**
     * 依据手机号查询员工
     *
     * @param cellphone
     * @return
     */
    @Override
    public Result queryEmployee(String cellphone) {
        PurchaserEmplyeeVo emplyeeVo = tPurchaserBasicInfoMapper.queryEmplyeeByCellphone(cellphone);
        return emplyeeVo == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", emplyeeVo);
    }

    /**
     * 依据id查员工
     *
     * @param id
     * @return
     */
    @Override
    public Result queryEmployee(Long id) {
        PurchaserEmplyeeVo emplyeeVo = tPurchaserBasicInfoMapper.queryEmplyeeById(id);
        return emplyeeVo == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", emplyeeVo);
    }

    /**
     * 根据条件查询
     *
     * @param employeeDto
     * @return
     */
    @Override
    public Result queryEmplyee(HandleEmployeeDto employeeDto) {
//        List<PurchaserEmplyeeVo> emplyeeVos = tPurchaserBasicInfoMapper.queryEmplyeeByCriteria(basicInfo);
//        if (emplyeeVos.isEmpty()) {
//            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
//        }
//        return Result.success("查询成功", emplyeeVos);
        return Result.success();
    }

    /**
     * 根据id修改员工权限
     *
     * @param id
     * @param role
     * @return
     */
    @Override
    public Result updateRole(Long id, Integer role) {
        int sucess = tPurchaserBasicInfoMapper.updateEmployeeRoleById(id, role);
        return sucess > 0 ? Result.success("跟新成功") : Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
    }

    /**
     * 查询名下所有的suppliers
     *
     * @param purchaseId
     * @return
     */
    @Override
    public Result queryAllSuppliers(Long purchaseId) {
//        List<PurchaserSupplierVo> supplierVos = tPurchaserBasicInfoMapper.queryAllSuppliers(purchaseId);
//        if (supplierVos.isEmpty()) {
//            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
//        }
//        return Result.success("查询成功", supplierVos);
        return Result.success();
    }

    /**
     * 根据供应商名查询
     *
     * @param fuzzyName
     * @return
     */
    @Override
    public Result querySuppliers(String fuzzyName,Long purchaseId) {
//        List<PurchaserSupplierVo> supplierVos = tPurchaserBasicInfoMapper.querySuppliersByName(fuzzyName);
//        if (supplierVos.isEmpty()) {
//            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
//        }
//        return Result.success("查询成功", supplierVos);
        return Result.success();
    }

    /**
     * 依据供应商ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Result querySuppliers(Long id) {
//        PurchaserSupplierVo supplierVos = tPurchaserBasicInfoMapper.querySuppliersById(id);
//        if (supplierVos == null) {
//            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
//        }
//        return Result.success("查询成功", supplierVos);

        return Result.success();
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Result updateSuppliers(HandPurchaserAttachment attachment) {
        return Result.success();
    }

    /**
     * 依据综合条件查询所有专家信息
     *
     * @param dto
     * @return
     */
    @Override
    public Result queryExperts(HandleExpertDto dto) {
//        List<PurchaserExpertVo> expertVos = tPurchaserBasicInfoMapper.queryExpertsByCriteria(dto);
//        if (expertVos.isEmpty()) {
//            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
//        }
//        return Result.success("查询成功", expertVos);
        return Result.success();
    }

    /**
     * :根据id删除专家,修改is_delete状态
     * @param id
     * @param state
     * @return
     */
    @Override
    public Result updateExpertState(Long id, Integer state) {
        int sucess = tPurchaserBasicInfoMapper.updateExpertStateById(id, state);
        return sucess > 0 ? Result.success("跟新成功") : Result.error(ErrorMessagesEnum.UPDATE_FAILURE);

    }
}