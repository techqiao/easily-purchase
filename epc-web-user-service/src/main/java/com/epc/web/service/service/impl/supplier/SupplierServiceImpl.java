package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.query.QuerywithPageHandle;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierCategoryVo;
import com.epc.web.facade.supplier.vo.TenderMessageVO;
import com.epc.web.service.domain.bid.TProjectBasicInfo;
import com.epc.web.service.domain.bid.TPurchaseProjectBids;
import com.epc.web.service.domain.expert.TPurchaseProjectBasicInfo;
import com.epc.web.service.domain.supplier.*;
import com.epc.web.service.mapper.bid.TProjectBasicInfoMapper;
import com.epc.web.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.web.service.mapper.expert.TPurchaseProjectBasicInfoMapper;
import com.epc.web.service.mapper.supplier.*;
import com.epc.web.service.service.supplier.SupplierService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 供应商服务
 * @Author: donghuan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;
    @Autowired
    private TTenderMessageMapper tTenderMessageMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    TProjectBasicInfoMapper tProjectBasicInfoMapper;
    @Autowired
    TProjectProcedureMapper tProjectProcedureMapper;
    @Autowired
    SupplierCategoryMapper supplierCategoryMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;

    private String supplierCategory ="supplier.type";
    /**
     * 0
     * 注册供应商
     * 自己找到平台网站注册供应商
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {

        Date date = new Date();
        //得到 电话 密码
        String name = handleSupplierDetail.getName();
        String cellphone = handleSupplierDetail.getCellphone();
        String password = handleSupplierDetail.getPassword();

        if (StringUtils.isBlank(name) || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password)) {
            return Result.success("前端传入数据错误");
        }

        //通过 电话 查询数据库中有没有记录, 如果有，就设置密码,完善信息;
        //  如果没有，就继续注册
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        if (CollectionUtils.isEmpty(listTSupplierBasicInfos)) {

            //如果没有电话，就可以    自己  进行  注册
            //将电话，密码信息存入到这个表对象中
            TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
            tSupplierBasicInfo.setName(name);
            //设置电话
            tSupplierBasicInfo.setCellphone(cellphone);
            //设置密码
//            tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(password));
            //短信验证

            //设置状态 为 完善中
            tSupplierBasicInfo.setState(Const.STATE.PERFECTING);
            //设置角色 为法人
            tSupplierBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
            //创建时间
            tSupplierBasicInfo.setCreateAt(date);
            //最后修改时间
            tSupplierBasicInfo.setUpdateAt(date);
            //设置   邀请人类型 是平台的，因为这个电话没有在数据 库中存在
            tSupplierBasicInfo.setInviterId(Long.parseLong(Const.INVITER_TYPE.PLATFORM_ID + ""));
            tSupplierBasicInfo.setInviterCompanyId(Long.parseLong(Const.INVITER_TYPE.PLATFORM_ID + ""));
            tSupplierBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);

            int i = 0;
            try {
                i = tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
                //更新数据库， 将主键id设置与operator_id一样，因为是运营商注册，
                tSupplierBasicInfo.setSupplierId(tSupplierBasicInfo.getId());
                tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
                return Result.success(i > 0);
            } catch (BusinessException e) {
                LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            } catch (Exception e) {
                LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        } else {
            //如果有电话，证明是被其他人拉取的，可以直接通过电话与姓名进行登陆，进去直接设置密码，然后完善个人信息
            //也有可能这个电话已经是用户了，存在数据库中了（这种可能性几乎没有,因为是每次注册都是要验证码的。）
            return Result.success("数据库中有这个电话，不能注册，电话要唯一");
        }
    }


    /**
     * 2
     * 完善供应商信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {
        //登陆人的id(法人id)
        Long supplierId = roleDetailInfo.getSupplierId();
        if (supplierId == null) {
            return Result.success("前端传入参数问题");
        }
        Date date = new Date();
        //设置供应商详情表中的一些信息，并插入一条数据到detail
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo, tSupplierDetailInfo);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);
        try {
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
        } catch (BusinessException e) {
            LOGGER.error("[供应商完善信息。详情表增加一条记录] tSupplierDetailInfoMapper.insertSelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[供应商完善信息。详情表增加一条记录] tSupplierDetailInfoMapper.insertSelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }

        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(supplierId);
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        try {
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            attachment.setCertificateName(AttachmentEnum.BUSINESS_LICENSE.getDesc());
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());
            attachment.setCertificateNumber(roleDetailInfo.getBusinessLicenseNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardPositive());
            attachment.setCertificateNumber(roleDetailInfo.getLegalIdCardPositiveNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardOther());
            tSupplierAttachmentMapper.insertSelective(attachment);

            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            attachment.setCertificateName(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getDesc());
            attachment.setCertificateFilePath(roleDetailInfo.getCertificateOfAuthorization());
            attachment.setCertificateNumber(roleDetailInfo.getCertificateOfAuthorizationNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            attachment.setCertificateName(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getDesc());
            attachment.setCertificateFilePath(roleDetailInfo.getOperatorIdCardFront());
            attachment.setCertificateNumber(roleDetailInfo.getOperatorIdCardFrontNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            List<QualificationCertificate> listQcs = roleDetailInfo.getQcs();
            for (QualificationCertificate qcs : listQcs) {
                attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
                attachment.setCertificateFilePath(qcs.getQualificationCertificate());
                attachment.setCertificateNumber(qcs.getQualificationCertificateNumber());
                tSupplierAttachmentMapper.insertSelective(attachment);
            }

            TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();

            //设置更新日期
            tSupplierBasicInfo.setUpdateAt(date);
            //设置状态为 3（审核中）
            tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
            //将修改（增加）的数据更新到其中
            tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
        } catch (BusinessException e) {
            LOGGER.error("[供应商完善信息] tSupplierBasicInfoMapper.updateByPrimaryKey : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[供应商完善信息] tSupplierBasicInfoMapper.updateByPrimaryKey : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.success(true);
    }

    //--------------------------平台审核通过之后----------------------------------

    /**
     * 3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        Long supplierId = handlerSupplierAddEmployee.getSupplierId();
        Integer loginRole = handlerSupplierAddEmployee.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.error("角色不匹配");
        }

        Date date = new Date();
        String name = handlerSupplierAddEmployee.getName();
        String cellphone = handlerSupplierAddEmployee.getCellphone();
        String password = handlerSupplierAddEmployee.getPassword();
        Integer role = handlerSupplierAddEmployee.getRole();

        if (StringUtils.isBlank(name) || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password) || role == null) {
            return Result.error("前端传入参数异常");
        }
        // 创建数据库插入对象
        TSupplierBasicInfo pojo = new TSupplierBasicInfo();
        //设置供应商的id
        pojo.setSupplierId(supplierId);
        //设置名字
        pojo.setName(name);
        //设置电话
        pojo.setCellphone(cellphone);
        //设置密码
        pojo.setPassword(MD5Util.MD5EncodeUtf8(password));
        //设置role 是管理员还是员工
        pojo.setRole(role);
        //员工状态5审核通过
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        //创建时间
        pojo.setCreateAt(date);
        //最后修改时间
        pojo.setUpdateAt(date);
        //返回成功或者失败
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("[供应商增加一个员工] exception insertTSupplierBasicInfoMapper : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[供应商增加一个员工] exception insertTSupplierBasicInfoMapper : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 4
     * 根据员工的id来查询基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierBasicById handleFindSupplierBasicById) {
        Integer loginRole = handleFindSupplierBasicById.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("用户角色不对");
        }
        Long id = handleFindSupplierBasicById.getId();
        //得到supplierbasic表的id
        if (id == null) {
            return Result.success("前端传递有问题");
        }
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        //将时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        String createAt = format.format(tSupplierBasicInfo.getCreateAt());
        String updateAt = format.format(tSupplierBasicInfo.getUpdateAt());
        SupplierBasicInfoVO vo = new SupplierBasicInfoVO();
        vo.setCreateAt(createAt);
        vo.setUpdateAt(updateAt);
        BeanUtils.copyProperties(tSupplierBasicInfo, vo);
        return Result.success(vo);
    }

    /**
     * 5
     * 供应商通过id修改员工
     * 通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        Integer loginRole = handlerUpdateSupplierEmployeeById.getLoginRole();
        //必须是供应商，不是员工角色 来干这个事
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.error("用户角色不对");
        }

        Long id = handlerUpdateSupplierEmployeeById.getId();
        if (id == null) {
            return Result.error("[供应商通过id修改员工] id==null : {参数异常}");
        }
        //通过这个员工的id来查询出他的所有信息
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setId(id);
        //将最新的名字传入进去
        tSupplierBasicInfo.setName(handlerUpdateSupplierEmployeeById.getName());
        //将最新的电话传入进去
        tSupplierBasicInfo.setCellphone(handlerUpdateSupplierEmployeeById.getCellphone());
        //设置密码
//        tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handlerUpdateSupplierEmployeeById.getPassword()));
        //设置 角色 （管理员，员工）
        tSupplierBasicInfo.setRole(handlerUpdateSupplierEmployeeById.getRole());
        //是否禁用
        tSupplierBasicInfo.setIsForbidden(handlerUpdateSupplierEmployeeById.getIsForbidden());
        //将最新的时间存进去
        tSupplierBasicInfo.setUpdateAt(new Date());
        //更新这条记录
        try {
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("[供应商通过id修改员工] BusinessException updateSupplierEmployeeById : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[供应商通过id修改员工] BusinessException updateSupplierEmployeeById : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 6    查看登陆者的个人信息（包括详情）
     * 员工通过id来查询 个人信息   (分两种情况，是老板，不是老板。不需要前端 传任何数据，直接用登陆个人信息里面的id与role)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<RoleDetailInfo> findSupplierDetailByEmployee(HandleFindSupplierBasicById handleFindSupplierBasicById) {
        Integer loginRole = handleFindSupplierBasicById.getLoginRole();
        Long userId = handleFindSupplierBasicById.getId();
        RoleDetailInfo vo = new RoleDetailInfo();

        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(userId);

        BeanUtils.copyProperties(tSupplierBasicInfo, vo);
        //不是老板,是管理员或者是员工
        if (loginRole.intValue() != Const.Role.ROLE_CORPORATION) {
            return Result.success(vo);
        }

        //是老板   用户id 就是 法人id
        //查出 法人的基本信息
        //依据员工的法人id来查询另外两张表，supplier_detail; supplier_attachment

        TSupplierAttachmentCriteria criteriaAtt = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria subCriteriaAtt = criteriaAtt.createCriteria();

        TSupplierDetailInfoCriteria criteriaDetail = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria subCriteriaDetail = criteriaDetail.createCriteria();

        subCriteriaAtt.andSupplierIdEqualTo(userId);
        subCriteriaDetail.andSupplierIdEqualTo(userId);

        //这里不能为空，因为殾已经能添加员工了，而且员工能来查看了，必须是 供应商各种资料已经通过审核，所以必须有内容
        TSupplierDetailInfo tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(criteriaDetail).get(0);
        //将依据supplier_id查询出来detail表中信息copy到返回类中
        BeanUtils.copyProperties(tSupplierDetailInfos, vo);

        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );

        List<TSupplierAttachment> tSupplierAttachments = tSupplierAttachmentMapper.selectByExample(criteriaAtt);

        List<QualificationCertificate> listQcs = new ArrayList<QualificationCertificate>();

        for (TSupplierAttachment ts : tSupplierAttachments) {
            if (AttachmentEnum.BUSINESS_LICENSE.getCode().equals(ts.getCertificateType())) {
                //营业执照照片url
                vo.setBusinessLicense(ts.getCertificateFilePath());
                vo.setBusinessLicenseNumber(ts.getCertificateNumber());
                vo.setBusinessLicenseType(ts.getCertificateType());
                vo.setBusinessLicenseName(ts.getCertificateName());
                continue;
            }
            if (AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode().equals(ts.getCertificateType())) {
                //资质证书url
                QualificationCertificate qualificationCertificate = new QualificationCertificate();
                qualificationCertificate.setQualificationCertificate(ts.getCertificateFilePath());
                qualificationCertificate.setQualificationCertificateNumber(ts.getCertificateNumber());
                qualificationCertificate.setQualificationCertificateType(ts.getCertificateType());
                qualificationCertificate.setQualificationCertificateName(ts.getCertificateName());
                listQcs.add(qualificationCertificate);
                continue;
            }
            if (AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode().equals(ts.getCertificateType())) {
                //法人身份证正面照片url
                vo.setLegalIdCardPositive(ts.getCertificateFilePath());
                vo.setLegalIdCardPositiveNumber(ts.getCertificateNumber());
                vo.setLegalIdCardPositiveName(ts.getCertificateName());
                vo.setLegalIdCardPositiveType(ts.getCertificateType());
                continue;
            }
            if (AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode().equals(ts.getCertificateType())) {
                //法人身份证反面照片url
                vo.setLegalIdCardOther(ts.getCertificateFilePath());
                vo.setLegalIdCardOtherName(ts.getCertificateName());
                vo.setLegalIdCardOtherType(ts.getCertificateType());
                continue;
            }
            if (AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode().equals(ts.getCertificateType())) {
                //经办人(运营商员工)手持身份证正面照片url
                vo.setOperatorIdCardFront(ts.getCertificateFilePath());
                vo.setOperatorIdCardFrontNumber(ts.getCertificateNumber());
                vo.setOperatorIdCardFrontName(ts.getCertificateName());
                vo.setOperatorIdCardFrontType(ts.getCertificateType());
                continue;
            }
            if (AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode().equals(ts.getCertificateType())) {
                //带公章的授权书照片url
                vo.setCertificateOfAuthorization(ts.getCertificateFilePath());
                vo.setCertificateOfAuthorizationNumber(ts.getCertificateNumber());
                vo.setCertificateOfAuthorizationName(ts.getCertificateName());
                vo.setCertificateOfAuthorizationType(ts.getCertificateType());
                continue;
            }
        }
        vo.setQcs(listQcs);
//        测试
//        System.out.println(tSupplierDetailInfos.getSupplierId() + "\n" + tSupplierDetailInfos.getPublicBanAccountNumber() + "\n" +
//                tSupplierDetailInfos.getPublicBankName() + "\n" + tSupplierDetailInfos.getId() + "\n" + tSupplierDetailInfos.getCompanyName()
//        );


        //将法人的基本信息复制到返回类中
//        BeanUtils.copyProperties(tSupplierBasicInfo, vo);

        //创建时间与更新时间取的是basic表中的时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
        vo.setCreateAt(format.format(tSupplierBasicInfo.getCreateAt()));
        vo.setUpdateAt(format.format(tSupplierBasicInfo.getUpdateAt()));

        return Result.success(vo);
    }

    /**
     * 6.5
     * 员工查看公司详情
     * 管理员或者员工 通过登陆信息里面的 bossId 来查看  公司详情（包括附件）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<RoleDetailInfo> findSupplierByBossId(HandleFindSupplierBasicById handleFindSupplierBasicById) {
        Long bossId = handleFindSupplierBasicById.getId();
        Integer loginRole = handleFindSupplierBasicById.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CORPORATION) {
            return Result.success("角色不对");
        }
        /**
         * 然后在basic同一个表中将法人的名字，电话，状态，角色 ，创建时间，更新时间都查出来
         * 因为supplier_id与id一样
         */
        //查出 法人的基本信息
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(bossId);

        //依据员工的法人id来查询另外两张表，supplier_detail; supplier_attachment

        TSupplierAttachmentCriteria criteriaAtt = new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria subCriteriaAtt = criteriaAtt.createCriteria();

        TSupplierDetailInfoCriteria criteriaDetail = new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria subCriteriaDetail = criteriaDetail.createCriteria();

        subCriteriaAtt.andSupplierIdEqualTo(bossId);
        subCriteriaDetail.andSupplierIdEqualTo(bossId);
        //这里不能为空，因为殾已经能添加员工了，而且员工能来查看了，必须是 供应商各种资料已经通过审核，所以必须有内容
        TSupplierDetailInfo tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(criteriaDetail).get(0);

        RoleDetailInfo vo = new RoleDetailInfo();

        //将法人的基本信息复制到返回类中
        BeanUtils.copyProperties(tSupplierBasicInfo, vo);
        //将依据supplier_id查询出来detail表中信息copy到返回类中
        BeanUtils.copyProperties(tSupplierDetailInfos, vo);

        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );

        List<TSupplierAttachment> tSupplierAttachments = tSupplierAttachmentMapper.selectByExample(criteriaAtt);

        List<QualificationCertificate> listQcs = new ArrayList<QualificationCertificate>();

        for (TSupplierAttachment ts : tSupplierAttachments) {
            if (AttachmentEnum.BUSINESS_LICENSE.getCode().equals(ts.getCertificateType())) {
                //营业执照照片url
                vo.setBusinessLicense(ts.getCertificateFilePath());
                vo.setBusinessLicenseNumber(ts.getCertificateNumber());
                vo.setBusinessLicenseType(ts.getCertificateType());
                vo.setBusinessLicenseName(ts.getCertificateName());
                continue;
            }
            if (AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode().equals(ts.getCertificateType())) {
                //资质证书url
                QualificationCertificate qualificationCertificate = new QualificationCertificate();
                qualificationCertificate.setQualificationCertificate(ts.getCertificateFilePath());
                qualificationCertificate.setQualificationCertificateNumber(ts.getCertificateNumber());
                qualificationCertificate.setQualificationCertificateType(ts.getCertificateType());
                qualificationCertificate.setQualificationCertificateName(ts.getCertificateName());
                listQcs.add(qualificationCertificate);
                continue;
            }
            if (AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode().equals(ts.getCertificateType())) {
                //法人身份证正面照片url
                vo.setLegalIdCardPositive(ts.getCertificateFilePath());
                vo.setLegalIdCardPositiveNumber(ts.getCertificateNumber());
                vo.setLegalIdCardPositiveName(ts.getCertificateName());
                vo.setLegalIdCardPositiveType(ts.getCertificateType());
                continue;
            }
            if (AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode().equals(ts.getCertificateType())) {
                //法人身份证反面照片url
                vo.setLegalIdCardOther(ts.getCertificateFilePath());
                vo.setLegalIdCardOtherName(ts.getCertificateName());
                vo.setLegalIdCardOtherType(ts.getCertificateType());
                continue;
            }
            if (AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode().equals(ts.getCertificateType())) {
                //经办人(运营商员工)手持身份证正面照片url
                vo.setOperatorIdCardFront(ts.getCertificateFilePath());
                vo.setOperatorIdCardFrontNumber(ts.getCertificateNumber());
                vo.setOperatorIdCardFrontName(ts.getCertificateName());
                vo.setOperatorIdCardFrontType(ts.getCertificateType());
                continue;
            }
            if (AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode().equals(ts.getCertificateType())) {
                //带公章的授权书照片url
                vo.setCertificateOfAuthorization(ts.getCertificateFilePath());
                vo.setCertificateOfAuthorizationNumber(ts.getCertificateNumber());
                vo.setCertificateOfAuthorizationName(ts.getCertificateName());
                vo.setCertificateOfAuthorizationType(ts.getCertificateType());
                continue;
            }
        }
        vo.setQcs(listQcs);
        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId() + "\n" + tSupplierDetailInfos.getPublicBanAccountNumber() + "\n" +
//                tSupplierDetailInfos.getPublicBankName() + "\n" + tSupplierDetailInfos.getId() + "\n" + tSupplierDetailInfos.getCompanyName()
//        );


        //创建时间与更新时间取的是basic表中的时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
        vo.setCreateAt(format.format(tSupplierBasicInfo.getCreateAt()));
        vo.setUpdateAt(format.format(tSupplierBasicInfo.getUpdateAt()));
        return Result.success(vo);
    }


    /**
     * 7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> findSupplierRecordByCellphone(HandleSupplierCellphone handleSupplierCellphone) {
        Integer loginRole = handleSupplierCellphone.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("角色不对");
        }

        String cellphone = handleSupplierCellphone.getCellphone();
//        System.out.println("电话 cellphone==="+cellphone);
        if (StringUtils.isNotBlank(cellphone)) {
            TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
            TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
            if (!CollectionUtils.isEmpty(tSupplierBasicInfos)) {
                return Result.success(true);
            } else {
                return Result.success(false);
            }
        } else {
            return Result.success("前端传入参数异常");
        }
    }

    /**
     * 8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleSupplierCellphone handleSupplierCellphone) {
        Integer loginRole = handleSupplierCellphone.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("角色不对");
        }
        String cellphone = handleSupplierCellphone.getCellphone();

        if (StringUtils.isBlank(cellphone)) {
            return Result.success("前端传入参数异常");
        }

        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);

        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tSupplierBasicInfos)){
            return Result.success("没有这个电话");
        }
        TSupplierBasicInfo single = tSupplierBasicInfos.get(0);
        SupplierBasicInfoVO vo = new SupplierBasicInfoVO();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        vo.setCreateAt(format.format(single.getCreateAt()));
        vo.setUpdateAt(format.format(single.getUpdateAt()));
        BeanUtils.copyProperties(single, vo);
        return Result.success(vo);
    }

    /**
     * 9
     * 通过员工id 只 修改员工 是否禁用
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeByisDeleted(HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden) {
        Integer loginRole = handleSupplierIdAndIsForbidden.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("角色不对");
        }

        //你要操作的员工id
        Long id = handleSupplierIdAndIsForbidden.getId();
        if (id == null) {
            return Result.success("前端传入参数异常");
        }
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setId(id);
        tSupplierBasicInfo.setIsForbidden(handleSupplierIdAndIsForbidden.getIsForbidden());
        try {
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("[通过员工id 只 修改员工的状态] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[通过员工id 只 修改员工的状态] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteSupplierEmployeeById(HandleSupplieIsDeleted handleSupplieIsDeleted) {
        Integer loginRole = handleSupplieIsDeleted.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("角色不对");
        }

        Long id = handleSupplieIsDeleted.getId();
        Integer isDeleted = handleSupplieIsDeleted.getIsDeleted();
        if (id != null && isDeleted != null) {
            try {
                TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
                tSupplierBasicInfo.setIsDeleted(isDeleted);
                int i = tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
                return Result.success(i > 0);
            } catch (BusinessException e) {
                LOGGER.error("[供应商依id删除一个员工] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
            } catch (Exception e) {
                LOGGER.error("[供应商依id删除一个员工] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        } else {
            return Result.error("前端传入数据异常}");
        }
    }

    /**
     * 11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
     *
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        Integer loginRole = handleOperatorRole.getLoginRole();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("角色不对");
        }
        Long id = handleOperatorRole.getId();
        Integer role = handleOperatorRole.getRole();
        if (id == null || role == null) {
            return Result.success("前端传入参数异常");
        }
        TSupplierBasicInfo tSupplierBasicInfo = new TSupplierBasicInfo();
        tSupplierBasicInfo.setId(id);
        tSupplierBasicInfo.setRole(role);
        try {
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("[根据用户id来修改他的role] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[根据用户id来修改他的role] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 12
     * 通过id来修改对应的state  1-拉取 2-完善信息 3-审核中 4-禁用 5-审核通过
     *
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeStateById(HandleOperatorState handleOperatorState) {

        Long id = handleOperatorState.getId();
        Integer state = handleOperatorState.getState();
//        System.out.println("id + state==="+id+"   "+state);
        if (id == null || state == null) {
            return Result.success("前端传入参数异常");
        }
        try {
            TSupplierBasicInfo tSupplierBasicInfo =new TSupplierBasicInfo();
            tSupplierBasicInfo.setId(id);
            tSupplierBasicInfo.setState(state);
            return Result.success( tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo) > 0);
        } catch (BusinessException e) {
            LOGGER.error("[通过id来修改对应的state] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[通过id来修改对应的state] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 13
     * 忘记密码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> forgetPasswordSupplier(HandleSupplierForgetPassword handleSupplierForgetPassword) {
        //得到手机号,查询数据库中有没有这条数据
        String cellphone = handleSupplierForgetPassword.getCellphone();
        String newPassword = handleSupplierForgetPassword.getPassword();
        if (StringUtils.isBlank(cellphone) || StringUtils.isBlank(newPassword)) {
            return Result.success("前端传入参数异常");
        }
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);
//        System.out.println("cellphone电话：：："+cellphone);
        //查询出一条结果,然后将密码改掉
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
//        System.out.println("通过电话查询出来的对象有多少个   =="+listTSupplierBasicInfos.size());
        if (CollectionUtils.isEmpty(listTSupplierBasicInfos)) {
            return Result.success("检查电话是否输入错误");
        }
        TSupplierBasicInfo tSupplierBasicInfo = listTSupplierBasicInfos.get(0);
        //加密传过来的密码
        tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
        tSupplierBasicInfo.setUpdateAt(new Date());
        int i = 0;
        try {
            //将新密码更新到数据 库中
            i = tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo, criteria);
            return Result.success(i > 0);
        } catch (BusinessException e) {
            LOGGER.error("[供应商忘记密码] tSupplierBasicInfoMapper.updateByExampleSelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[供应商忘记密码] tSupplierBasicInfoMapper.updateByExampleSelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }


    /**
     * 14 :ok
     * 根据员工的名字,角色，是否禁用
     * 来匹配出符合条件的员工返回一个list：s
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleSupplierIdAndName handleSupplierIdAndName) {
        Integer loginRole = handleSupplierIdAndName.getLoginRole();
        Long bossId = handleSupplierIdAndName.getBossId();
        if (loginRole.intValue() == Const.Role.ROLE_CUSTOMER) {
            return Result.success("角色不匹配");
        }

        //获取输入的名字,来进行模糊查询
        String name = handleSupplierIdAndName.getName();
        //角色是管理员，员工
        Integer role = handleSupplierIdAndName.getRole();
        //是否禁用
        Integer isForbidden = handleSupplierIdAndName.getIsForbidden();

        //给出查询的条件，查询出符合条件的员工
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //注意查出的是is_deleted是0（存在）的
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        subCriteria.andSupplierIdEqualTo(bossId);
        if (role != null) {
            subCriteria.andRoleEqualTo(role);
        }
        if (isForbidden != null) {
            subCriteria.andIsForbiddenEqualTo(isForbidden);
        }
        if (StringUtils.isNotBlank(name)) {
            subCriteria.andNameLike("%" + name + "%");
        }
        //得到符合符合条件的结果
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);

        //放数据的容器
        List<SupplierBasicInfoVO> listVo = new ArrayList<SupplierBasicInfoVO>();
        //装数据
        for (TSupplierBasicInfo tsupplierBasicInfo : listTSupplierBasicInfos) {
            SupplierBasicInfoVO vo = new SupplierBasicInfoVO();
            BeanUtils.copyProperties(tsupplierBasicInfo, vo);
            //将时间格式化
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(tsupplierBasicInfo.getCreateAt()));
            vo.setUpdateAt(format.format(tsupplierBasicInfo.getUpdateAt()));
            //装入容器
            listVo.add(vo);
        }
        return Result.success(listVo);
    }



    /**
     * 根据当前登录者参与的投标项目列表
     * @param querywithPageHandle
     * @return
     */
    @Override
    public Result<List<TenderMessageVO>> querySupplierProject(QuerywithPageHandle querywithPageHandle) {
        //获取当前用户 参与的投标项目列表
        List<TTenderMessage> tTenderMessages = tTenderMessageMapper.querySupplierProject(querywithPageHandle.getUserId());
        List<TenderMessageVO> voList = new ArrayList<>();
        for (TTenderMessage entity : tTenderMessages) {
            TenderMessageVO vo = new TenderMessageVO();
            QueryProjectSchedule dto = new QueryProjectSchedule();
            TPurchaseProjectBids bisEntity = tPurchaseProjectBidsMapper.selectByPrimaryKey(entity.getBidsId());
            BeanUtils.copyProperties(bisEntity, vo);
            TProjectBasicInfo projectEntity = tProjectBasicInfoMapper.selectByPrimaryKey(bisEntity.getProjectId());
           if(querywithPageHandle.getProjectName()!=null && !bisEntity.getPurchaseProjectName().contains(querywithPageHandle.getProjectName())){
               break;
           }
            if (projectEntity.getSourceOfInvestment() == 0) {
                vo.setProjectType("国有投资");
            } else if (projectEntity.getSourceOfInvestment() == 1) {
                vo.setProjectType("私有投资");
            } else if (projectEntity.getSourceOfInvestment() == 2) {
                vo.setProjectType("国有占主体投资");
            }
            vo.setBidId(entity.getBidsId());
            dto.setPurchaseProjectId(entity.getPurchaseProjectId());
            dto.setOperateType("supplier");
            //获取
            String schedule = "";
            if (queryProjectSchedule(dto) != null) {
                schedule = queryProjectSchedule(dto).getData();
            }
            vo.setSchedule(schedule);
            //获取采购项目
            TPurchaseProjectBasicInfo purchaserBasicInfo=tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(bisEntity.getPurchaseProjectId());
            if (purchaserBasicInfo.getIsEnd()==Const.PROJECT_STATUS.NOT_START) {
                vo.setStatus("未开始");
            }else if (purchaserBasicInfo.getIsEnd()==Const.PROJECT_STATUS.STARTING) {
                vo.setStatus("进行中");
            } else  if (purchaserBasicInfo.getIsEnd()==Const.PROJECT_STATUS.END){
                vo.setStatus("已结束");
            }
            if(vo.getStatus()==null){
                continue;
            }else if(querywithPageHandle.getStatus()!=null && !querywithPageHandle.getStatus().equals(vo.getStatus())){
                break;
            }
            voList.add(vo);
        }
        return Result.success(voList);
    }


    /**
     * @author :winlin
     * @Description :获得供应商列表
     * @date:2018/10/11
     */
    @Override
    public Result<List<SupplierCategoryVo>> querySupplierCategory() {
        List<SupplierCategoryVo> categoryVos = null;
        try {
            categoryVos = supplierCategoryMapper.selectCategory(supplierCategory);
        } catch (Exception e) {
            LOGGER.error("查询供货商类别列表失败", e);
            return Result.error("查询供货商类别列表失败");
        }
        return CollectionUtils.isEmpty(categoryVos) ? Result.success("查询供货商类别列表失败") : Result.success(categoryVos);
    }


    /**
     * 根据bid 和 用户类型 判断标段环节步骤（）
     *
     * @param dto
     * @return
     */
    public Result<String> queryProjectSchedule(QueryProjectSchedule dto) {
        TProjectProcedureCriteria criteria = new TProjectProcedureCriteria();
        TProjectProcedureCriteria.Criteria cubCriteria = criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(dto.getPurchaseProjectId());
        cubCriteria.andOperateTypeEqualTo("supplier");
        criteria.setOrderByClause("create_at desc");
        List<TProjectProcedure> result = tProjectProcedureMapper.selectByExample(criteria);
        if (result.size() > 0) {
            return Result.success(result.get(0).getProcedureCode());
        } else {
            return Result.success(null);
        }
    }

}
