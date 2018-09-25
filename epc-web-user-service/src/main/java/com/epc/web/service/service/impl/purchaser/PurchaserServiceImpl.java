package com.epc.web.service.service.impl.purchaser;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.agency.handle.Attachement;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.HandleAgencyDto;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.dto.HandleSupplierDto;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.PurchaserAgencyVo;
import com.epc.web.facade.purchaser.vo.PurchaserEmplyeeVo;
import com.epc.web.facade.purchaser.vo.PurchaserExpertVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.service.domain.agency.*;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.expert.TExpertAttachmentCriteria;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfoCriteria;
import com.epc.web.service.domain.operator.TOperatorPurchaser;
import com.epc.web.service.domain.operator.TOperatorPurchaserCriteria;
import com.epc.web.service.domain.purchaser.*;
import com.epc.web.service.domain.supplier.*;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.web.service.mapper.purchaser.*;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import com.fasterxml.jackson.annotation.JsonInclude;
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

@Service
@Transactional
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
    @Autowired
    TPurchaserSupplierMapper tPurchaserSupplierMapper;

    @Autowired
    TPurchaserAgencyMapper tPurchaserAgencyMapper;
    @Autowired
    TAgencyDetailInfoMapper tAgencyDetailInfoMapper;

    @Autowired
    TExpertAttachmentMapper tExpertAttachmentMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaserServiceImpl.class);


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
    @Transactional(rollbackFor = {Exception.class})
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
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            tOperatorPurchaserMapper.insertSelective(pojo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
        criteria1.andNameEqualTo(handleSupplierDetail.getCompanyName());
        criteria1.andInviterIdEqualTo(handleSupplierDetail.getSupplierId());
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
        if (list.size() > 0) {
            return Result.error("供应商" + handleSupplierDetail.getCompanyName() + "已存在,勿重复添加");
        }


        TSupplierBasicInfo pojo = new TSupplierBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleSupplierDetail.getCellPhone());
        pojo.setName(handleSupplierDetail.getCompanyName());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException insertOperatorDetailInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> createExpertUserInfo(HandleExpert handleExpert) {
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
                    try {
                        tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
                    } catch (Exception e) {
                        //捕获异常回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        e.printStackTrace();
                    }
                } else {
                    try {
                        //添加信息到私库中,添加之前查询是否存在
                        tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
                    } catch (Exception e) {
                        //捕获异常回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        e.printStackTrace();
                    }
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
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
        criteria.andCellphoneEqualTo(handleAgnecy.getCellphone());
        List<TAgencyBasicInfo> list = tAgencyBasicInfoMapper.selectByExample(infoCriteria);
        if (list.size() > 0) {
            return Result.error("员工:" + handleAgnecy.getName() + "已存在");
        }
        TAgencyBasicInfo pojo = new TAgencyBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleAgnecy.getCellphone());
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
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
    @Transactional(rollbackFor = {Exception.class})
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
        try {
            tPurchaserBasicInfoMapper.insertSelective(pojo);
        } catch (BusinessException e) {
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 完善采购人信息
     * 点击注册按钮后页面进入完善信息阶段,传递过去的信息,nama ,password,自动生成的id
     *
     * @param handlePurchaser
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updatePurchaserDetail(HandleRegisterPurchaser handlePurchaser) {

        //分装添加的条件,和跟新对象,添加数据到数据库三张表,t_purchaser_basic_info,t_purchaser_detail_info,t_purchaser_attachment
        TPurchaserBasicInfo basicInfo = new TPurchaserBasicInfo();
        TPurchaserDetailInfo detailInfo = new TPurchaserDetailInfo();

        //设置更新时间和t_purchaser_detail_info,t_purchaser_attachment的创建时间
        Date date = new Date();

        //对象数据的转移拷贝
        basicInfo.setName(handlePurchaser.getName());
        basicInfo.setPurchaserId(handlePurchaser.getPurchaseId());

        //角色为法人状态为注册
        basicInfo.setState(Const.STATE.REGISTERED);
        basicInfo.setRole(Const.Role.ROLE_CORPORATION);
        basicInfo.setUpdateAt(date);

        //封装详细信息
        detailInfo.setPurchaserId(handlePurchaser.getPurchaseId());
        detailInfo.setCompanyName(handlePurchaser.getCompanyName());
        detailInfo.setUniformCreditCode(handlePurchaser.getUniformCreditCode());
        detailInfo.setPublicBankName(handlePurchaser.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(handlePurchaser.getPublicBankCount());
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        //封装附件信息
        List<TPurchaserAttachment> list = new ArrayList<>();
        for (Attachement at : handlePurchaser.getAtts()) {
            TPurchaserAttachment att = new TPurchaserAttachment();
            att.setId(handlePurchaser.getPurchaseId());
            att.setCertificateFilePath(at.getCertificateFilePath());
            att.setCertificateName(at.getCertificateName());
            att.setCertificateNumber(at.getCertificateNumber());
            att.setCertificateType(at.getCertificateType());
            att.setCreateAt(date);
            att.setUpdateAt(date);
            list.add(att);
        }
        //封装更新条件update数据到数据库
        TPurchaserBasicInfoCriteria basicInfoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andCellphoneEqualTo(handlePurchaser.getCellphone());
        try {
            tPurchaserBasicInfoMapper.updateByExampleSelective(basicInfo, basicInfoCriteria);
            tPurchaserDetailInfoMapper.insertSelective(detailInfo);
            for (TPurchaserAttachment attachment : list) {
                tPurchaserAttachmentMapper.insertSelective(attachment);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return Result.success("信息完善成功", true);
    }

    /**
     * 完善供应商信息,
     *
     * @param dto ,依据页面提供的信息更新,完善信息状态没有审核通过
     *            私库内容保持不变(name,cellphone),公库数据更新
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateSupplierDetail(PurchaserHandleSupplierDto dto) {
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //t_purchaser_supplier,t_supplier_basic_info,t_supplier_attachment,t_supplier_detail_info
        //实例化插入对象接受数据
        TSupplierBasicInfo basicInfo = new TSupplierBasicInfo();
        //完善信息是对t_supplier_basic_info,t_supplier_attachment,t_supplier_detail_info表做insert操作
        //封装对象
        basicInfo.setName(dto.getName());
        basicInfo.setCellphone(dto.getCellphone());
        //密码加密
        basicInfo.setPassword(MD5Util.MD5EncodeUtf8(dto.getPassword()));
        basicInfo.setInviterId(dto.getOperatorId());
        basicInfo.setInviterCompanyId((int) dto.getCompanyId());
        basicInfo.setState(Const.STATE.COMMITTED);
        basicInfo.setRole(Const.Role.ROLE_CORPORATION);
        basicInfo.setCreateAt(new Date());
        basicInfo.setUpdateAt(new Date());
        try {
            tSupplierBasicInfoMapper.insertSelective(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        //获得返回的id,作为supplier_id
        Long supplierId = basicInfo.getId();
        basicInfo.setSupplierId(supplierId);

        //id更新进入t_purchaser_supplier的数据库
        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        TPurchaserSupplier supplier = tPurchaserSupplierMapper.selectByExample(supplierCriteria).get(0);
        supplier.setSupplierId(supplierId);

        //封装供应商详细对象
        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
        detailInfo.setSupplierId(supplierId);
        detailInfo.setCompanyName(dto.getCompanyName());
        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
        detailInfo.setPublicBankName(dto.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
        detailInfo.setCreateAt(new Date());
        detailInfo.setUpdateAt(new Date());
        try {

            tSupplierBasicInfoMapper.updateByPrimaryKey(basicInfo);
            tPurchaserSupplierMapper.updateByPrimaryKey(supplier);
            tSupplierDetailInfoMapper.insertSelective(detailInfo);
            //封装附件信息对象
            for (Attachement att : dto.getAtts()) {
                TSupplierAttachment attachment = new TSupplierAttachment();
                BeanUtils.copyProperties(att, attachment);
                attachment.setSupplierId(supplierId);
                tSupplierAttachmentMapper.insertSelective(attachment);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return Result.success("更新成功", true);

//        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
//        BeanUtils.copyProperties(HandleSupplierDetail, detailInfo);
//        Date date = new Date();
//        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
//        detailInfo.setCreateAt(date);
//        detailInfo.setUpdateAt(date);
//
//        //新增附件
//        TSupplierAttachment attachment = new TSupplierAttachment();
//        attachment.setSupplierId(HandleSupplierDetail.getUserId());
//        attachment.setCreateAt(date);
//        attachment.setUpdateAt(date);
//        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
//        try {
//            tSupplierDetailInfoMapper.insertSelective(detailInfo);
//            //带公章的授权书照片url
//            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
//            attachment.setCertificateFilePath(HandleSupplierDetail.getCertificateOfAuthorization());
//            tSupplierAttachmentMapper.insertSelective(attachment);
//            //经办人(运营商员工)手持身份证正面照片url
//            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
//            attachment.setCertificateFilePath(HandleSupplierDetail.getOperatorIdCardFront());
//            tSupplierAttachmentMapper.insertSelective(attachment);
//            //法人身份证反面照片url
//            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
//            attachment.setCertificateFilePath(HandleSupplierDetail.getLegalIdCardOther());
//            tSupplierAttachmentMapper.insertSelective(attachment);
//            //法人身份证正面照片url
//            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
//            attachment.setCertificateFilePath(HandleSupplierDetail.getLegalIdCardPositive());
//            tSupplierAttachmentMapper.insertSelective(attachment);
//            //营业执照照片url
//            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
//            attachment.setCertificateFilePath(HandleSupplierDetail.getBusinessLicense());
//            tSupplierAttachmentMapper.insertSelective(attachment);
//            //资质证书url
//            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
//            attachment.setCertificateFilePath(HandleSupplierDetail.getQualificationCertificate());
//            tSupplierAttachmentMapper.insertSelective(attachment);
//            return Result.success();
//        } catch (BusinessException e) {
//            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
//            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
//        } catch (Exception e) {
//            LOGGER.error("BusinessException updatePurchaserDetail : {}", e);
//            return Result.error(e.getMessage());
//        }
    }

    /**
     * @author :lingzhixiang
     * @Description :完善代理机构的信息,机构易注册
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateAgencyDetail(HandleAgnecy dto) {
        //查询注册信息
        TPurchaserAgencyCriteria agencyCriteria = new TPurchaserAgencyCriteria();
        TPurchaserAgencyCriteria.Criteria criteria = agencyCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        TPurchaserAgency agency = tPurchaserAgencyMapper.selectByExample(agencyCriteria).get(0);
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //t_agency_attachment,t_agency_basic_info,t_agency_detail_info,t_purchaser_agency
        //实例化插入对象接受数据
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        //完善信息是对t_agency_attachment,t_agency_basic_info,t_agency_detail_info表做insert操作
        //封装对象
        basicInfo.setName(dto.getName());
        basicInfo.setCellphone(dto.getCellphone());
        //使用注册时候的密码
        basicInfo.setPassword(agency.getPassword());
        basicInfo.setInviterId(dto.getOperatorId());
        basicInfo.setInviterCompanyId((int) dto.getCompanyId());
        basicInfo.setState(Const.STATE.COMMITTED);
        basicInfo.setRole(Const.Role.ROLE_CORPORATION);
        basicInfo.setCreateAt(new Date());
        basicInfo.setUpdateAt(new Date());
        try {
            tAgencyBasicInfoMapper.insertSelective(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        //获得返回的id,作为agencyId
        Long agencyId = basicInfo.getId();
        basicInfo.setAgencyId(agencyId);

        //id更新进入t_purchaser_agency的数据库
        agency.setSupplierId(agencyId);

        //封装供应商详细对象
        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
        detailInfo.setAgencyId(agencyId);
        detailInfo.setCompanyName(dto.getCompanyName());
        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
        detailInfo.setPublicBankName(dto.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
        detailInfo.setCreateAt(new Date());
        detailInfo.setUpdateAt(new Date());
        try {
            tAgencyBasicInfoMapper.updateByPrimaryKey(basicInfo);
            tPurchaserAgencyMapper.updateByPrimaryKey(agency);
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            //封装附件信息对象
            for (Attachement att : dto.getAtts()) {
                TAgencyAttachment attachment = new TAgencyAttachment();
                BeanUtils.copyProperties(att, attachment);
                attachment.setAgencyId(agencyId);
                tAgencyAttachmentMapper.insertSelective(attachment);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return Result.success("更新成功", true);
//        TAgencyBasicInfo detailInfo = new TAgencyBasicInfo();
//        BeanUtils.copyProperties(handleAgnecy, detailInfo);
//        Date date = new Date();
//        detailInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
//        detailInfo.setCreateAt(date);
//        detailInfo.setUpdateAt(date);
//
//        //新增附件
//        TAgencyAttachment attachment = new TAgencyAttachment();
//        attachment.setAgencyId(handleAgnecy.getUserId());
//        attachment.setCreateAt(date);
//        attachment.setUpdateAt(date);
//        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
//        try {
//            tAgencyBasicInfoMapper.insertSelective(detailInfo);
//            //带公章的授权书照片url
//            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
//            attachment.setCertificateFilePath(handleAgnecy.getCertificateOfAuthorization());
//            tAgencyAttachmentMapper.insertSelective(attachment);
//            //经办人(运营商员工)手持身份证正面照片url
//            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
//            attachment.setCertificateFilePath(handleAgnecy.getOperatorIdCardFront());
//            tAgencyAttachmentMapper.insertSelective(attachment);
//            //法人身份证反面照片url
//            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
//            attachment.setCertificateFilePath(handleAgnecy.getLegalIdCardOther());
//            tAgencyAttachmentMapper.insertSelective(attachment);
//            //法人身份证正面照片url
//            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
//            attachment.setCertificateFilePath(handleAgnecy.getLegalIdCardPositive());
//            tAgencyAttachmentMapper.insertSelective(attachment);
//            //营业执照照片url
//            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
//            attachment.setCertificateFilePath(handleAgnecy.getBusinessLicense());
//            tAgencyAttachmentMapper.insertSelective(attachment);
//            //资质证书url
//            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
//            attachment.setCertificateFilePath(handleAgnecy.getQualificationCertificate());
//            tAgencyAttachmentMapper.insertSelective(attachment);
//
//        } catch (BusinessException e) {
//            LOGGER.error("BusinessException updateAgencyDetail : {}", e);
//            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
//        } catch (Exception e) {
//            LOGGER.error("BusinessException updateAgencyDetail : {}", e);
//            return Result.error(e.getMessage());
//        }
//        return Result.success();
    }

    /**
     * @author :winlin
     * @Description :采购人注册
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<HandleRegisterPurchaser> registerPurchaser(HandleRegisterPurchaser purchaser) {
        TPurchaserBasicInfo basicInfo = new TPurchaserBasicInfo();
        //或的基本信息密码加密密码加密
        basicInfo.setCellphone(purchaser.getCellphone());
        basicInfo.setPassword(MD5Util.MD5EncodeUtf8(purchaser.getPassword()));
        basicInfo.setCreateAt(new Date());
        Result result = new Result();
        int sucess = 0;
        try {
            sucess = tPurchaserBasicInfoMapper.insertSelective(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        Long id = basicInfo.getId();
        if (sucess > 0) {
            //数据库生成的id放入对象传入下个页面
            purchaser.setPurchaseId(id);
            result.setData(purchaser);
            result.setMsg("注册成功");
            return result;
        }
        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
    }

    /**
     * @author :winlin
     * @Description :采购人下的所有员工
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserEmplyeeVo>> allEmployee(Long purchaserId) {

        //依据id查询所有的对应的信息t_purchaser_basic_info
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaserId);
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);

        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaserId);
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectByExample(detailCriteria).get(0);

        //获得老板name和公司name
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = "";
        String companyId = tPurchaserDetail.getId().toString();
        for (TPurchaserBasicInfo basicInfo : tPurchaserBasicInfos) {
            if (basicInfo.getRole() == Const.Role.ROLE_CORPORATION) {
                bossName = basicInfo.getName();
            }
        }
        //拼装信息
        List<PurchaserEmplyeeVo> list = new ArrayList<>();
        for (TPurchaserBasicInfo basicInfo : tPurchaserBasicInfos) {
            PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
            vo.setUserId(basicInfo.getId().toString());
            vo.setUserName(basicInfo.getName());
            vo.setCellphone(basicInfo.getCellphone());
            vo.setCompanyId(companyId);
            vo.setBossName(bossName);
            vo.setCompanyName(companyName);
            list.add(vo);
        }

        if (list.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", list);
    }

    /**
     * @author :winlin
     * @Description :模糊查询员工
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserEmplyeeVo>> findEmployeeByName(String fuzzyName, Long purchaseId) {
        //依据id查询所有的对应的信息t_purchaser_basic_info
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaseId);
        criteria.andNameLike(fuzzyName);
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);

        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaseId);
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectByExample(detailCriteria).get(0);

        //获得老板name和公司name
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = "";
        String companyId = tPurchaserDetail.getId().toString();
        for (TPurchaserBasicInfo basicInfo : tPurchaserBasicInfos) {
            if (basicInfo.getRole() == Const.Role.ROLE_CORPORATION) {
                bossName = basicInfo.getName();
            }
        }
        //拼装信息
        List<PurchaserEmplyeeVo> list = new ArrayList<>();
        for (TPurchaserBasicInfo basicInfo : tPurchaserBasicInfos) {
            PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
            vo.setUserId(basicInfo.getId().toString());
            vo.setUserName(basicInfo.getName());
            vo.setCellphone(basicInfo.getCellphone());
            vo.setCompanyId(companyId);
            vo.setBossName(bossName);
            vo.setCompanyName(companyName);
            list.add(vo);
        }

        if (list.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", list);
    }

    /**
     * @author :winlin
     * @Description :根据手机号修改状态
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateEmployeeState(String cellphone, Integer state) {
        int sucess = 0;
        try {
            sucess = tPurchaserBasicInfoMapper.updateEmployeeStateByCellphone(cellphone, state);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        if (sucess == 0) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :根据id修改状态
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateEmployeeState(Long id, Integer state) {
        int sucess = 0;
        try {
            sucess = tPurchaserBasicInfoMapper.updateEmployeeStateById(id, state);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        if (sucess == 0) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :根据手机查员工
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<PurchaserEmplyeeVo> queryEmployee(String cellphone) {
        //依据id查询所有的对应的信息t_purchaser_basic_info
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByExample(infoCriteria).get(0);
        //获得自己机构的id
        Long purchaseId = tPurchaserBasicInfo.getPurchaserId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria2.andPurchaserIdEqualTo(purchaseId);
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectByExample(detailCriteria).get(0);

        //获得老板name和公司name
        TPurchaserBasicInfoCriteria infoCriteria2 = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria3 = infoCriteria.createCriteria();
        criteria3.andPurchaserIdEqualTo(purchaseId);
        criteria3.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        TPurchaserBasicInfo boss = tPurchaserBasicInfoMapper.selectByExample(infoCriteria).get(0);
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = boss.getName();
        String companyId = tPurchaserDetail.getId().toString();
        //拼装信息
        PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
        vo.setUserId(tPurchaserBasicInfo.getId().toString());
        vo.setUserName(tPurchaserBasicInfo.getName());
        vo.setCellphone(tPurchaserBasicInfo.getCellphone());
        vo.setCompanyId(companyId);
        vo.setBossName(bossName);
        vo.setCompanyName(companyName);


        if (vo == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", vo);

    }

    /**
     * @author :winlin
     * @Description :根据id查员工
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<PurchaserEmplyeeVo> queryEmployee(Long id) {
        //依据id查询所有的对应的信息t_purchaser_basic_info
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByExample(infoCriteria).get(0);
        //获得自己机构的id
        Long purchaseId = tPurchaserBasicInfo.getPurchaserId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria2.andPurchaserIdEqualTo(purchaseId);
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectByExample(detailCriteria).get(0);

        //获得老板name和公司name
        TPurchaserBasicInfoCriteria infoCriteria2 = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria3 = infoCriteria.createCriteria();
        criteria3.andPurchaserIdEqualTo(purchaseId);
        criteria3.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        TPurchaserBasicInfo boss = tPurchaserBasicInfoMapper.selectByExample(infoCriteria).get(0);
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = boss.getName();
        String companyId = tPurchaserDetail.getId().toString();
        //拼装信息
        PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
        vo.setUserId(tPurchaserBasicInfo.getId().toString());
        vo.setUserName(tPurchaserBasicInfo.getName());
        vo.setCellphone(tPurchaserBasicInfo.getCellphone());
        vo.setCompanyId(companyId);
        vo.setBossName(bossName);
        vo.setCompanyName(companyName);


        if (vo == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", vo);
    }

    /**
     * @author :winlin
     * @Description :根据综合条件查员工
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(HandleEmployeeDto employeeDto) {
        //依据id查询所有的对应的信息t_purchaser_basic_info
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andIdEqualTo(employeeDto.getEmployeeId());
        criteria.andRoleEqualTo(employeeDto.getRole());
        criteria.andPurchaserIdEqualTo(employeeDto.getPurchaseId());
        criteria.andCellphoneEqualTo(employeeDto.getCellphone());
        criteria.andNameLike(employeeDto.getName());
        criteria.andStateEqualTo(employeeDto.getState());
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);
        //获得自己机构的id
        Long purchaseId = tPurchaserBasicInfos.get(0).getPurchaserId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria2.andPurchaserIdEqualTo(purchaseId);
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectByExample(detailCriteria).get(0);

        //获得老板name和公司name
        TPurchaserBasicInfoCriteria infoCriteria2 = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria3 = infoCriteria.createCriteria();
        criteria3.andPurchaserIdEqualTo(purchaseId);
        criteria3.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        TPurchaserBasicInfo boss = tPurchaserBasicInfoMapper.selectByExample(infoCriteria).get(0);
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = boss.getName();
        String companyId = tPurchaserDetail.getId().toString();

        //拼装信息
        List<PurchaserEmplyeeVo> list = new ArrayList<>();
        for (TPurchaserBasicInfo tPurchaserBasicInfo : tPurchaserBasicInfos) {
            PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
            vo.setUserId(tPurchaserBasicInfo.getId().toString());
            vo.setUserName(tPurchaserBasicInfo.getName());
            vo.setCellphone(tPurchaserBasicInfo.getCellphone());
            vo.setCompanyId(companyId);
            vo.setBossName(bossName);
            vo.setCompanyName(companyName);
            list.add(vo);
        }


        if (list == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", list);
    }

    /**
     * @author :winlin
     * @Description :根据id修改员工权限
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateRole(Long id, Integer role) {
        int sucess = 0;
        try {
            sucess = tPurchaserBasicInfoMapper.updateEmployeeRoleById(id, role);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        if (sucess == 0) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :条件检索供应商
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(HandleSupplierDto supplierDto) {
        //封装查询条件
        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(supplierDto.getPurcharseId().toString());

        TSupplierDetailInfoCriteria detailInfoCriteria = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andCompanyNameLike(supplierDto.getCompanyName());

        TSupplierAttachmentCriteria attachmentCriteria = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();

        //查询结果
        List<TSupplierDetailInfo> supplierVos = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (supplierVos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        List<TPurchaserSupplier> basicInfos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        //封装附件查询的条件list
        List<Long> longs = new ArrayList<>();
        //封装
        List<PurchaserSupplierVo> vos = new ArrayList<>();
        for (TSupplierDetailInfo detailInfo : supplierVos) {
            PurchaserSupplierVo vo = new PurchaserSupplierVo();
            Long supplierId = detailInfo.getSupplierId();
            for (TPurchaserSupplier supplier : basicInfos) {
                Long supplierId1 = supplier.getSupplierId();
                if (supplierId.equals(supplierId1)) {
                    longs.add(supplierId);
                    vo.setCellphone(supplier.getCellphone());
                    vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
                    vo.setPublicBankName(detailInfo.getPublicBankName());
                    vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
                    vo.setCreateAt(detailInfo.getCreateAt());
                    vo.setCompanyName(detailInfo.getCompanyName());
                    vo.setSupplierId(supplierId);
                    vos.add(vo);
                }
            }
        }
        criteria2.andSupplierIdIn(longs);
        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);
        for (PurchaserSupplierVo vo : vos) {
            Long supplierId = vo.getSupplierId();
            List<Attachement> list = new ArrayList<>();
            for (TSupplierAttachment attachment : attachments) {
                Long supplierId2 = attachment.getSupplierId();
                if (supplierId.equals(supplierId2)) {
                    Attachement att = new Attachement();
                    BeanUtils.copyProperties(attachment, att);
                    att.setTypeId(attachment.getSupplierId().toString());
                    list.add(att);
                }
            }
            vo.setAtts(list);
        }
        return vos == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", vos);
    }

    /**
     * @author :winlin
     * @Description :查找所有的供货商
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserSupplierVo>> queryAllSuppliers(Long purchaseId) {
        //封装查询条件
        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaseId.toString());

        TSupplierDetailInfoCriteria detailInfoCriteria = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();

        TSupplierAttachmentCriteria attachmentCriteria = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();

        //查询结果
        List<TPurchaserSupplier> supplierVos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        if (supplierVos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        //封装附件查询的条件list
        List<Long> supplierIds = new ArrayList<>();
        for (TPurchaserSupplier supplier : supplierVos) {
            Long supplierId = supplier.getSupplierId();
            supplierIds.add(supplierId);
        }
        //依据id查询所有的供应商
        criteria1.andSupplierIdIn(supplierIds);
        criteria2.andSupplierIdIn(supplierIds);
        List<TSupplierDetailInfo> infoList = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria);
        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);
        //封装返回值
        List<PurchaserSupplierVo> list = new ArrayList<>();
        for (TPurchaserSupplier supplierVo : supplierVos) {
            Long supplierId = supplierVo.getSupplierId();
            for (TSupplierDetailInfo info : infoList) {
                Long supplierId1 = info.getSupplierId();
                if (supplierId.equals(supplierId1)) {
                    PurchaserSupplierVo vo = new PurchaserSupplierVo();
                    vo.setSupplierId(supplierId);
                    vo.setCompanyName(info.getCompanyName());
                    vo.setCreateAt(new Date());
                    vo.setUniformCreditCode(info.getUniformCreditCode());
                    vo.setPublicBankName(info.getPublicBankName());
                    vo.setPublicBanAccountNumber(info.getPublicBanAccountNumber());
                    vo.setCellphone(supplierVo.getCellphone());
                    list.add(vo);
                }
            }
        }
        for (PurchaserSupplierVo vo : list) {
            Long supplierId = vo.getSupplierId();
            List<Attachement> attachements = new ArrayList<>();
            for (TSupplierAttachment attachment : attachments) {
                Long supplierId1 = attachment.getSupplierId();
                Attachement attachement = new Attachement();
                if (supplierId.equals(supplierId1)) {
                    BeanUtils.copyProperties(attachment, attachement);
                    attachement.setTypeId(supplierId.toString());
                    attachements.add(attachement);
                }
            }
            vo.setAtts(attachements);
        }
        return list == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", list);
    }

    /**
     * @author :winlin
     * @Description :依据姓名模糊查找供货商
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserSupplierVo>> querySuppliers(String fuzzyName, Long purchaseId) {
        //封装查询条件
        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaseId.toString());

        TSupplierDetailInfoCriteria detailInfoCriteria = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andCompanyNameLike(fuzzyName);

        TSupplierAttachmentCriteria attachmentCriteria = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();

        //查询结果
        List<TSupplierDetailInfo> supplierVos = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (supplierVos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        List<TPurchaserSupplier> basicInfos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        //封装附件查询的条件list
        List<Long> longs = new ArrayList<>();
        //封装
        List<PurchaserSupplierVo> vos = new ArrayList<>();
        for (TSupplierDetailInfo detailInfo : supplierVos) {
            PurchaserSupplierVo vo = new PurchaserSupplierVo();
            Long supplierId = detailInfo.getSupplierId();
            for (TPurchaserSupplier supplier : basicInfos) {
                Long supplierId1 = supplier.getSupplierId();
                if (supplierId.equals(supplierId1)) {
                    longs.add(supplierId);
                    vo.setCellphone(supplier.getCellphone());
                    vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
                    vo.setPublicBankName(detailInfo.getPublicBankName());
                    vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
                    vo.setCreateAt(detailInfo.getCreateAt());
                    vo.setCompanyName(detailInfo.getCompanyName());
                    vo.setSupplierId(supplierId);
                    vos.add(vo);
                }
            }
        }
        criteria2.andSupplierIdIn(longs);
        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);
        for (PurchaserSupplierVo vo : vos) {
            Long supplierId = vo.getSupplierId();
            List<Attachement> list = new ArrayList<>();
            for (TSupplierAttachment attachment : attachments) {
                Long supplierId2 = attachment.getSupplierId();
                if (supplierId.equals(supplierId2)) {
                    Attachement att = new Attachement();
                    BeanUtils.copyProperties(attachment, att);
                    att.setTypeId(attachment.getSupplierId().toString());
                    list.add(att);
                }
            }
            vo.setAtts(list);
        }
        return vos == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", vos);
    }

    /**
     * @author :winlin
     * @Description :根据id查询供应商信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<PurchaserSupplierVo> querySuppliers(Long id) {
        //封装查询条件
        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andSupplierIdEqualTo(id);

        TSupplierDetailInfoCriteria detailInfoCriteria = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andSupplierIdEqualTo(id);

        TSupplierAttachmentCriteria attachmentCriteria = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();
        criteria2.andSupplierIdEqualTo(id);

        TPurchaserSupplier supplier = tPurchaserSupplierMapper.selectByExample(supplierCriteria).get(0);
        TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria).get(0);
        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);

        //封装返回信息
        PurchaserSupplierVo vo = new PurchaserSupplierVo();
        vo.setSupplierId(id);
        vo.setCompanyName(detailInfo.getCompanyName());
        vo.setCreateAt(new Date());
        vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
        vo.setPublicBankName(detailInfo.getPublicBankName());
        vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
        vo.setCellphone(supplier.getCellphone());
        List<Attachement> list = new ArrayList<>();
        for (TSupplierAttachment attachment : attachments) {
            Attachement att = new Attachement();
            BeanUtils.copyProperties(attachment, att);
            att.setTypeId(attachment.getSupplierId().toString());
            list.add(att);
        }
        vo.setAtts(list);

        return vo == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", vo);
    }

    /**
     * @author :winlin
     * @Description :修改供应商信息,需要供货商id
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<Boolean> updateSuppliers(HandPurchaserAttachment dto) {
        //t_purchaser_Supplier t_SUPPLIER _attachment t_SUPPLIER _basic_info ,t_SUPPLIER_detail_info查询信息封装
        //供货商id
        Long supplierId = dto.getSupplierId();

        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        //数据库字段为supplierId
        criteria.andSupplierIdEqualTo(supplierId);

        TSupplierBasicInfoCriteria tSupplierBasicInfoCriteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria criteria1 = tSupplierBasicInfoCriteria.createCriteria();
        criteria1.andIdEqualTo(supplierId);

        TSupplierAttachmentCriteria tSupplierAttachmentCriteria = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria criteria2 = tSupplierAttachmentCriteria.createCriteria();
        criteria2.andSupplierIdEqualTo(supplierId);

        TSupplierDetailInfoCriteria tSupplierDetailInfoCriteria = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria criteria3 = tSupplierDetailInfoCriteria.createCriteria();
        criteria3.andSupplierIdEqualTo(supplierId);
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //实例化对象接受数据
        TSupplierBasicInfo basicInfo = new TSupplierBasicInfo();
        basicInfo.setName(dto.getName());
        basicInfo.setCellphone(dto.getCellphone());
        basicInfo.setState(dto.getState());
        basicInfo.setUpdateAt(new Date());
        int sucess = tSupplierBasicInfoMapper.updateByExample(basicInfo, tSupplierBasicInfoCriteria);

        TPurchaserSupplier supplier = new TPurchaserSupplier();
        supplier.setCellphone(dto.getCellphone());
        supplier.setState(dto.getState());
        supplier.setSupplierName(dto.getCompanyName());
        supplier.setUpdateAt(new Date());
        tPurchaserSupplierMapper.updateByExample(supplier, supplierCriteria);

        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
        detailInfo.setCompanyName(dto.getCompanyName());
        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
        detailInfo.setPublicBankName(dto.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
        detailInfo.setUpdateAt(new Date());
        tSupplierDetailInfoMapper.updateByExample(detailInfo, tSupplierDetailInfoCriteria);

        for (Attachement attachement : dto.getAtts()) {
            TSupplierAttachment att = new TSupplierAttachment();
            BeanUtils.copyProperties(attachement, att);
            att.setSupplierId(supplierId);
            tSupplierAttachmentMapper.updateByExample(att, tSupplierAttachmentCriteria);
        }

        if (sucess == 0) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "更新失败");
        }
        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :依据条件查专家 条件可以升是专家name,专家专业 profession
     * 专家职称 positional 专家水平 level,机构id为必须
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserExpertVo>> queryExperts(HandleExpertDto dto) {
        //封装查询条件
        TPurchaserExpertCriteria expertCriteria = new TPurchaserExpertCriteria();
        TPurchaserExpertCriteria.Criteria criteria = expertCriteria.createCriteria();
        criteria.andExpertNameLike(dto.getExpertName());
        criteria.andPurchaserIdEqualTo(dto.getPuchaserId().toString());

        TExpertBasicInfoCriteria basicInfoCriteria = new TExpertBasicInfoCriteria();
        TExpertBasicInfoCriteria.Criteria criteria1 = basicInfoCriteria.createCriteria();
        criteria1.andProfessionEqualTo(dto.getProfession());
        criteria1.andPositionalEqualTo(dto.getPositional());
        criteria1.andLevelEqualTo(dto.getLevel());

        //查询结果返回
        List<TPurchaserExpert> expertList = tPurchaserExpertMapper.selectByExample(expertCriteria);
        List<TExpertBasicInfo> infoList = tExpertBasicInfoMapper.selectByExample(basicInfoCriteria);
        //对结果进行返回
        List<PurchaserExpertVo> voList = new ArrayList<>();
        for (TPurchaserExpert expert : expertList) {
            Long expertId = expert.getExpertId();
            for (TExpertBasicInfo info : infoList) {
                Long id = info.getId();
                if (expertId.equals(id)) {
                    PurchaserExpertVo vo = new PurchaserExpertVo();
                    vo.setExpertName(expert.getExpertName());
                    vo.setLevel(info.getLevel());
                    vo.setPositional(info.getPositional());
                    vo.setSerialNum(info.getId());
                    vo.setProfession(info.getProfession());
                    voList.add(vo);
                }
            }
        }

        if (voList.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", voList);
    }

    /**
     * @author :winlin
     * @Description :根据id删除专家,修改is_delete状态,单表操作
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateExpertState(Long id, Integer state) {
        int sucess = 0;
        try {
            sucess = tPurchaserBasicInfoMapper.updateExpertStateById(id, state);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        if (sucess == 0) {
            return Result.error(ErrorMessagesEnum.DELETE_FAILURE);
        }
        return Result.success("删除成功", true);
    }

    /**
     * @author :winlin
     * @Description :依据条件检索代理机构
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(HandleAgencyDto agencyDto) {
        //封装查询条件
        TPurchaserAgencyCriteria agencyCriteria = new TPurchaserAgencyCriteria();
        TPurchaserAgencyCriteria.Criteria criteria = agencyCriteria.createCriteria();
        criteria.andPurchaserIdEqualTo(agencyDto.getPurchaseId().toString());

        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andCompanyNameLike(agencyDto.getCompanyName());

        TAgencyAttachmentCriteria attachmentCriteria = new TAgencyAttachmentCriteria();
        TAgencyAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();

        //查询结果
        List<TAgencyDetailInfo> agencyVos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (agencyVos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        List<TPurchaserAgency> basicInfos = tPurchaserAgencyMapper.selectByExample(agencyCriteria);
        //封装附件查询的条件list
        List<Long> longs = new ArrayList<>();
        //封装
        List<PurchaserAgencyVo> vos = new ArrayList<>();
        for (TAgencyDetailInfo detailInfo : agencyVos) {
            PurchaserAgencyVo vo = new PurchaserAgencyVo();
            Long agencyId = detailInfo.getAgencyId();
            for (TPurchaserAgency agency : basicInfos) {
                //数据路字段为supplier_id;
                Long agencyId1 = agency.getSupplierId();
                if (agencyId.equals(agencyId1)) {
                    longs.add(agencyId);
                    vo.setCellphone(agency.getCellphone());
                    vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
                    vo.setPublicBankName(detailInfo.getPublicBankName());
                    vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
                    vo.setCreateAt(detailInfo.getCreateAt());
                    vo.setCompanyName(detailInfo.getCompanyName());
                    vo.setAgencyId(agencyId);
                    vos.add(vo);
                }
            }
        }
        criteria2.andAgencyIdIn(longs);
        List<TAgencyAttachment> attachments = tAgencyAttachmentMapper.selectByExample(attachmentCriteria);
        for (PurchaserAgencyVo vo : vos) {
            Long agecnyId = vo.getAgencyId();
            List<Attachement> list = new ArrayList<>();
            for (TAgencyAttachment attachment : attachments) {
                Long supplierId2 = attachment.getAgencyId();
                if (agecnyId.equals(supplierId2)) {
                    Attachement att = new Attachement();
                    BeanUtils.copyProperties(attachment, att);
                    att.setTypeId(attachment.getAgencyId().toString());
                    list.add(att);
                }
            }
            vo.setAtts(list);
        }
        return vos == null ? Result.error(ErrorMessagesEnum.SELECT_FAILURE) : Result.success("查询成功", vos);
    }


    /**
     * @author :winlin
     * @Description :完善采购人专家信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<Boolean> completePurchaserExpertInfo(HandleExpertDto dto) {
        //查询注册信息
        TPurchaserExpertCriteria expertCriteria = new TPurchaserExpertCriteria();
        TPurchaserExpertCriteria.Criteria criteria = expertCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        TPurchaserExpert expert = tPurchaserExpertMapper.selectByExample(expertCriteria).get(0);
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //t_purchaser_expert t_expert_attachment t_expert_basic_info
        //实例化插入对象接受数据
        TExpertBasicInfo basicInfo = new TExpertBasicInfo();
        //完善信息是对t_SUPPLIER_attachment,t_SUPPLIER_basic_info,t_SUPPLIER_detail_info,表做insert操作
        //封装对象
        basicInfo.setName(dto.getExpertName());
        basicInfo.setCellphone(dto.getCellphone());
        //使用注册时候的密码
        basicInfo.setPassword(expert.getPassword());
        basicInfo.setInviterId(dto.getInviterId());
        basicInfo.setInviterCompanyId(Integer.parseInt(dto.getInviterCompanyId().toString()));
        basicInfo.setState(Const.STATE.COMMITTED);
        basicInfo.setProfession(dto.getProfession());
        basicInfo.setPositional(dto.getPositional());
        basicInfo.setCreateAt(new Date());
        basicInfo.setUpdateAt(new Date());
        basicInfo.setLevel(dto.getLevel());
        basicInfo.setInviterType(3);
        //获得返回的id,作为expertId
        Long expertId = basicInfo.getId();
        try {
            tExpertBasicInfoMapper.insertSelective(basicInfo);
            //封装附件信息对象
            for (Attachement att : dto.getAtts()) {
                TExpertAttachment attachment = new TExpertAttachment();
                BeanUtils.copyProperties(att, attachment);
                attachment.setExpertId(expertId);
                tExpertAttachmentMapper.insertSelective(attachment);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :修改采购人代理机构的信息前端页面附带代理机构唯一的id
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updatePurchaserAgency(HandleAgencyDto dto) {
        //t_purchaser_Agency t_Agency _attachment t_Agency _basic_info ,t_agency_detail_info查询信息封装
        //代理机构id
        Long agencyId = dto.getAgencyId();

        TPurchaserAgencyCriteria agencyCriteria = new TPurchaserAgencyCriteria();
        TPurchaserAgencyCriteria.Criteria criteria = agencyCriteria.createCriteria();
        //数据库字段为supplierId
        criteria.andSupplierIdEqualTo(agencyId);

        TAgencyBasicInfoCriteria tAgencyBasicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria1 = tAgencyBasicInfoCriteria.createCriteria();
        criteria1.andIdEqualTo(agencyId);

        TAgencyAttachmentCriteria tExpertAttachmentCriteria = new TAgencyAttachmentCriteria();
        TAgencyAttachmentCriteria.Criteria criteria2 = tExpertAttachmentCriteria.createCriteria();
        criteria2.andAgencyIdEqualTo(agencyId);

        TAgencyDetailInfoCriteria tAgencyDetailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria3 = tAgencyDetailInfoCriteria.createCriteria();
        criteria3.andAgencyIdEqualTo(agencyId);
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //实例化对象接受数据
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        basicInfo.setName(dto.getName());
        basicInfo.setCellphone(dto.getCellphone());
        basicInfo.setState(dto.getState());
        basicInfo.setUpdateAt(new Date());

        TPurchaserAgency agency = new TPurchaserAgency();
        agency.setCellphone(dto.getCellphone());
        agency.setState(dto.getState());
        agency.setSupplierName(dto.getCompanyName());
        agency.setUpdateAt(new Date());

        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
        detailInfo.setCompanyName(dto.getCompanyName());
        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
        detailInfo.setPublicBankName(dto.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
        detailInfo.setUpdateAt(new Date());
        try {
            tAgencyBasicInfoMapper.updateByExample(basicInfo, tAgencyBasicInfoCriteria);
            tPurchaserAgencyMapper.updateByExample(agency, agencyCriteria);
            tAgencyDetailInfoMapper.updateByExample(detailInfo, tAgencyDetailInfoCriteria);
            for (Attachement attachement : dto.getAtts()) {
                TAgencyAttachment att = new TAgencyAttachment();
                BeanUtils.copyProperties(attachement, att);
                att.setAgencyId(agencyId);
                tAgencyAttachmentMapper.updateByExample(att, tExpertAttachmentCriteria);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :修改采购人专家的信息,前端页面附带专家唯一的id
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updatePurchaserExpert(HandleExpertDto dto) {
        //t_purchaser_expert t_expert_attachment t_expert_basic_info 查询信息封装
        //专家id
        Long expertId = dto.getExpertId();

        TPurchaserExpertCriteria expertCriteria = new TPurchaserExpertCriteria();
        TPurchaserExpertCriteria.Criteria criteria = expertCriteria.createCriteria();
        criteria.andExpertIdEqualTo(expertId);

        TExpertBasicInfoCriteria tExpertBasicInfoCriteria = new TExpertBasicInfoCriteria();
        TExpertBasicInfoCriteria.Criteria criteria1 = tExpertBasicInfoCriteria.createCriteria();
        criteria1.andIdEqualTo(expertId);

        TExpertAttachmentCriteria tExpertAttachmentCriteria = new TExpertAttachmentCriteria();
        TExpertAttachmentCriteria.Criteria criteria2 = tExpertAttachmentCriteria.createCriteria();
        criteria2.andExpertIdEqualTo(expertId);

        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //实例化对象接受数据
        TExpertBasicInfo basicInfo = new TExpertBasicInfo();

        basicInfo.setName(dto.getExpertName());
        basicInfo.setCellphone(dto.getCellphone());
        basicInfo.setProfession(dto.getProfession());
        basicInfo.setPositional(dto.getPositional());
        basicInfo.setLevel(dto.getLevel());
        basicInfo.setState(dto.getState());
        basicInfo.setUpdateAt(new Date());

        TPurchaserExpert expert = new TPurchaserExpert();
        expert.setCellphone(dto.getCellphone());
        expert.setState(dto.getState());
        expert.setExpertName(dto.getExpertName());
        expert.setUpdateAt(new Date());
        try {
            tExpertBasicInfoMapper.updateByExample(basicInfo, tExpertBasicInfoCriteria);
            tPurchaserExpertMapper.updateByExample(expert, expertCriteria);
            for (Attachement attachement : dto.getAtts()) {
                TExpertAttachment att = new TExpertAttachment();
                BeanUtils.copyProperties(attachement, att);
                att.setExpertId(expertId);
                tExpertAttachmentMapper.updateByExample(att, tExpertAttachmentCriteria);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return Result.success("更新成功", true);
    }

}