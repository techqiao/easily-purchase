package com.epc.web.service.service.impl.purchaser;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.agency.handle.Attachement;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.dto.*;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.*;
import com.epc.web.service.domain.agency.TAgencyAttachment;
import com.epc.web.service.domain.agency.TAgencyBasicInfo;
import com.epc.web.service.domain.agency.TAgencyDetailInfo;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertDetailInfo;
import com.epc.web.service.domain.purchaser.*;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.expert.TExpertDetailInfoMapper;
import com.epc.web.service.mapper.purchaser.*;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.impl.UpdateAttachment;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PurchaserServiceImpl extends UpdateAttachment implements PurchaserService {
    @Autowired
    TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;

    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
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
    @Autowired
    TExpertDetailInfoMapper tExpertDetailInfoMapper;
    @Autowired
    TPurchaseProjectParticipantPermissionMapper tPurchaseProjectParticipantPermissionMapper;

    @Autowired
    BReleaseAnnouncementMapper bReleaseAnnouncementMapper;

    @Autowired
    TWinBidNominateMapper tWinBidNominateMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaserServiceImpl.class);


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
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDto handleSupplier) {
        //根据页面传入的信息查询依据手机号和姓名来查询
        String cellphone = handleSupplier.getCellphone();
        //返回该供应商信息
        TSupplierBasicInfo basicInfo = null;
        try {
            basicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByCell(cellphone);
        } catch (Exception e) {
            LOGGER.error("查询错误:Exception:{}", e);
            return Result.error("用户名错误,请检查后重新输入!");
        }
        //判断状态
        if (basicInfo != null) {
            int state = basicInfo.getState();
            int role = basicInfo.getRole();
            //假如状态是已审核并且角色是法人,同步到代理机构的私库
            if (state == Const.STATE.AUDIT_SUCCESS && role == Const.Role.ROLE_CORPORATION) {
                //查询详情库获得供应商的详细信息
                Long supplierId = basicInfo.getSupplierId();
                //从页面传入
                TPurchaserSupplier purchaserSupplier = new TPurchaserSupplier();
                purchaserSupplier.setOperateId((int) handleSupplier.getOperatorId().intValue());
                purchaserSupplier.setSource(Const.SOURCE.PUBLICS);
                purchaserSupplier.setCreateAt(basicInfo.getCreateAt());
                purchaserSupplier.setUpdateAt(basicInfo.getUpdateAt());
                purchaserSupplier.setIsDeleted(basicInfo.getIsDeleted());
                purchaserSupplier.setSupplierType(Const.TRUST_OR_NOT.TRUST);
                //从公库basicinfo中获得
                purchaserSupplier.setState(Const.STATE.AUDIT_SUCCESS);
                purchaserSupplier.setSupplierId(supplierId);
                try {
                    //添加到私库
                    tPurchaserSupplierMapper.insertSelective(purchaserSupplier);
                } catch (Exception e) {
                    //捕获异常回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    LOGGER.error("采购人同步供货商入库失败", e);
                    return Result.error("采购人同步供货商入库失败");
                }
            } else {
                return Result.success("供货商没有审核通过或供货商信息不正确");
            }
        } else {
            //供应商不存在的时候抽取handleSupplier的字段添加
            TPurchaserSupplier purchaserSupplier = new TPurchaserSupplier();
            //跟新时间
            Date date = new Date();
            //采购人数据库
            purchaserSupplier.setOperateId((int) handleSupplier.getOperatorId().intValue());
            purchaserSupplier.setSource(Const.SOURCE.PRIVATES);
            purchaserSupplier.setCreateAt(new Date());
            purchaserSupplier.setUpdateAt(new Date());
            purchaserSupplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            purchaserSupplier.setSupplierType(Const.TRUST_OR_NOT.TRUST);
            purchaserSupplier.setState(Const.STATE.REGISTERED);
            purchaserSupplier.setOperateId(handleSupplier.getOperatorId().intValue());
            purchaserSupplier.setPurchaserId(handleSupplier.getCompanyId());
            //对公司信息唯一性进行校验
            TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectDetailByCriteria(handleSupplier.getCompanyName(), handleSupplier.getPublicBankCount(), handleSupplier.getUniformCreditCode());
            Result result = super.whichIsDuplicateForSupplier(detailInfo, handleSupplier.getCompanyName(), handleSupplier.getUniformCreditCode(), handleSupplier.getPublicBankCount());
            if (result != null) {
                return result;
            }
            detailInfo = new TSupplierDetailInfo();
            BeanUtils.copyProperties(handleSupplier, detailInfo, "id");
            detailInfo.setPublicBanAccountNumber(handleSupplier.getPublicBankCount());
            detailInfo.setCreateAt(date);
            detailInfo.setUpdateAt(date);
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            //供应商基本信息数据库
            basicInfo = new TSupplierBasicInfo();
            basicInfo.setName(handleSupplier.getName());
            basicInfo.setCellphone(handleSupplier.getCellphone());
            basicInfo.setPassword(MD5Util.MD5EncodeUtf8(Const.DEFAULT_PASSWORD.PASSWORD));
            basicInfo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            basicInfo.setInviterId(handleSupplier.getOperatorId());
            basicInfo.setInviterCompanyId(handleSupplier.getCompanyId());
            basicInfo.setState(Const.STATE.REGISTERED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            basicInfo.setCreateAt(date);
            basicInfo.setUpdateAt(date);
            basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            //附件信息
            List<Attachement> atts = handleSupplier.getAtts();
            //添加到数据库
            try {
                //添加到私库
                tSupplierBasicInfoMapper.insertSelective(basicInfo);
                //得到生成的id更新表单数据
                Long supplierId = basicInfo.getId();
                basicInfo.setSupplierId(supplierId);
                tSupplierBasicInfoMapper.updateByPrimaryKey(basicInfo);
                purchaserSupplier.setSupplierId(supplierId);
                tPurchaserSupplierMapper.insertSelective(purchaserSupplier);
                detailInfo.setSupplierId(supplierId);
                tSupplierDetailInfoMapper.insertSelective(detailInfo);
                super.updateSupplierAttachment(handleSupplier.getAtts(), handleSupplier.getLegalIdCardPositive(), handleSupplier.getLegalIdCardOther(), handleSupplier.getBusinessLicense(), supplierId);
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("采购人新增供货商入库失败", e);
                return Result.error("采购人新增供货商入库失败");
            }

        }
        return Result.success("采购人新增供应商信息成功");
    }


    /**
     * @Description: 平台审核通过的采购人新增 专家（私库）
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
        //根据提供的cellphone查询专家信息专家状态为已审核状态自动根跟新全部信息到私库,其他情况私库添加手机号码和name
        String cellphone = handleExpert.getCellPhone();
        TExpertBasicInfo basicInfo = null;
        TPurchaserExpert purchaserExpert = null;
        TPurchaserDetailInfo tPurchaserDetailInfo = null;
        try {
            basicInfo = tExpertBasicInfoMapper.selectExpertCellPhone(cellphone);
        } catch (Exception e) {
            LOGGER.error("新增专家失败Exception:{}", e);
            return Result.error("新增失败");
        }
        if (basicInfo != null) {
            //专家的审核状态
            int state = basicInfo.getState();
            Long expertId = basicInfo.getId();
            try {
                purchaserExpert = tPurchaserExpertMapper.selectExpertByExpertId(expertId);
                if (purchaserExpert != null) {
                    return Result.error("专家:" + handleExpert.getName() + "已存在");
                } else {
                    TPurchaserExpert tPurchaserExpert = new TPurchaserExpert();
                    tPurchaserExpert.setState(state);
                    tPurchaserExpert.setExpertId(basicInfo.getId());
                    tPurchaserExpert.setPurchaserId(handleExpert.getPurchaserId() + "");
                    tPurchaserExpert.setSource(Const.SOURCE.PUBLICS);
                    tPurchaserExpert.setCreaterId(handleExpert.getOperatorId());
                    tPurchaserExpert.setCreateAt(new Date());
                    tPurchaserExpert.setUpdateAt(new Date());
                    tPurchaserExpert.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    List<Attachement> list = handleExpert.getAtts();
                    //添加信息
                    tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
                }
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("采购人同步专家失败", e);
                return Result.error("采购人同步专家失败");
            }
        } else {
            //公库新增
            TExpertBasicInfo pojo = new TExpertBasicInfo();
            //pojo.setId(0L);
            Date date = new Date();
            BeanUtils.copyProperties(handleExpert, pojo, "id");
            pojo.setOtherInformation(handleExpert.getOtherInformation());
            pojo.setIsIdle(Const.IS_IDLE_OR_NOT.IS_IDLE);
            pojo.setPassword(MD5Util.MD5EncodeUtf8(Const.DEFAULT_PASSWORD.PASSWORD));//默认密码
            pojo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            pojo.setInviterId(handleExpert.getOperatorId());//操作人员的id
            pojo.setInviterCompanyId(handleExpert.getPurchaserId().intValue());//操作人员的公司id
            pojo.setState(Const.STATE.REGISTERED);
            pojo.setCreateAt(new Date());
            pojo.setUpdateAt(new Date());
            pojo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            //私库新增
            TPurchaserExpert operator = new TPurchaserExpert();
            operator.setState(Const.STATE.REGISTERED);
            operator.setPurchaserId(handleExpert.getPurchaserId() + "");
            operator.setCreaterId(handleExpert.getOperatorId());
            operator.setSource(Const.SOURCE.PRIVATES);
            operator.setCreateAt(date);
            operator.setUpdateAt(date);
            operator.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            //附件信息
            List<Attachement> list = handleExpert.getAtts();
            try {
                tPurchaserDetailInfo = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(handleExpert.getPurchaserId());
                tExpertBasicInfoMapper.insertSelective(pojo);
                //得到专家基本信心信息的id存入关联表中
                Long expertId = pojo.getId();
                operator.setExpertId(expertId);
                if (tPurchaserDetailInfo == null) {
                    TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
                    BeanUtils.copyProperties(tPurchaserDetailInfo, tExpertDetailInfo);
                    tExpertDetailInfo.setExpertId(expertId);
                    tExpertDetailInfo.setCreateAt(date);
                    tExpertDetailInfo.setUpdateAt(date);
                    tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
                }
                tPurchaserExpertMapper.insertSelective(operator);
                super.updateExpertAttachment(handleExpert.getAtts(), handleExpert.getLegalIdCardPositive(), handleExpert.getLegalIdCardOther(), expertId);
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("采购人专家入库失败", e);
                return Result.error(e.getMessage());
            }
        }
        return Result.success("采购人新增专家成功");
    }


    /**
     * 采购人新增代理机构
     *
     * @param handleAgnecy
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy) {
        //先查询是否存在,不存在添加私库
        String cellphone = handleAgnecy.getCellphone();
        TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphone(cellphone);
        Date date = new Date();
        if (basicInfo != null) {
            int state = basicInfo.getState();
            int role = basicInfo.getRole();
            //代理机构信息存在且状态审核完毕,角色为法人
            if (state == Const.STATE.AUDIT_SUCCESS && role == Const.Role.ROLE_CORPORATION) {
                //获得代理机构的id
                Long agencyId = basicInfo.getAgencyId();
                //信息添加到私库t_purchaser_agency,先查询t_agency_detail信息
                TAgencyDetailInfo detailInfo = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
                if (detailInfo == null) {
                    return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(), "代理商信息未完善");
                }
                //获得已存在代理机构的详细信息
                TPurchaserAgency purchaserAgency = new TPurchaserAgency();
                purchaserAgency.setState(basicInfo.getState());
                purchaserAgency.setAgencyId(agencyId);
                purchaserAgency.setCreaterId(handleAgnecy.getOperatorId());
                purchaserAgency.setPurchaserId(handleAgnecy.getCompanyId() + "");
                purchaserAgency.setSource(Const.SOURCE.PUBLICS);
                purchaserAgency.setCreateAt(date);
                purchaserAgency.setUpdateAt(date);
                purchaserAgency.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

                try {
                    tPurchaserAgencyMapper.insertSelective(purchaserAgency);
                } catch (Exception e) {
                    //捕获异常回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    LOGGER.error("采购人同步代理机构失败", e);
                    return Result.error(e.getCause().getMessage());
                }
            } else {
                return Result.error("未通过审核或机构不存在");
            }
        } else {
            //对公司信息唯一性进行校验
            TAgencyDetailInfo detailInfo = tAgencyDetailInfoMapper.selectDetailByCriteria(handleAgnecy.getCompanyName(), handleAgnecy.getPublicBankCount(), handleAgnecy.getUniformCreditCode());
            Result result = super.whichIsDuplicateForAgency(detailInfo, handleAgnecy.getCompanyName(), handleAgnecy.getUniformCreditCode(), handleAgnecy.getPublicBankCount());
            if (result != null) {
                return result;
            }
            //公库t_agency_basic添加详细信息
            basicInfo = new TAgencyBasicInfo();
            basicInfo.setName(handleAgnecy.getName());
            basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            basicInfo.setCellphone(handleAgnecy.getCellphone());
            basicInfo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            //采购人员工id
            basicInfo.setInviterId(handleAgnecy.getOperatorId());
            //采购人公司id
            basicInfo.setInviterCompanyId((int) handleAgnecy.getCompanyId());
            basicInfo.setState(Const.STATE.REGISTERED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            //指定默认密码
            basicInfo.setPassword(MD5Util.MD5EncodeUtf8(Const.DEFAULT_PASSWORD.PASSWORD));
            basicInfo.setCreateAt(date);
            basicInfo.setUpdateAt(date);

            detailInfo = new TAgencyDetailInfo();
            BeanUtils.copyProperties(handleAgnecy, detailInfo, "id");
            detailInfo.setCreateAt(date);
            detailInfo.setUpdateAt(date);
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            detailInfo.setPublicBanAccountNumber(handleAgnecy.getPublicBankCount());
            //私库添加基本name和cellphone
            TPurchaserAgency agency = new TPurchaserAgency();
            agency.setCreaterId(handleAgnecy.getOperatorId());
            agency.setCreateAt(date);
            agency.setUpdateAt(date);
            agency.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            agency.setState(Const.STATE.REGISTERED);
            agency.setPurchaserId(handleAgnecy.getCompanyId() + "");
            agency.setSource(Const.SOURCE.PRIVATES);

            try {
                //提交到 数据库
                tAgencyBasicInfoMapper.insertSelective(basicInfo);
                //得到公库生成的agencyId
                Long agencyId = basicInfo.getId();
                basicInfo.setAgencyId(agencyId);
                tAgencyBasicInfoMapper.updateByPrimaryKey(basicInfo);
                //id设如私库中
                agency.setAgencyId(agencyId);
                //id设置进入t_agency_detail
                detailInfo.setAgencyId(agencyId);
                tAgencyDetailInfoMapper.insertSelective(detailInfo);
                tPurchaserAgencyMapper.insertSelective(agency);
                super.updateAgencyAttachment(handleAgnecy.getAtts(), handleAgnecy.getLegalIdCardPositive(), handleAgnecy.getLegalIdCardOther(), handleAgnecy.getBusinessLicense(), agencyId);
            } catch (BusinessException e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("采购人添加代理机构失败", e);
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("采购人添加代理机构失败}", e);
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }
        }
        return Result.success("添加代理机构成功");
    }


    /**
     * @param handleOperator
     * @return
     * @Description 新增 采购人员信息
     * @Author linzhixiang
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator) {
        //先查询是否存在,不存在添加私库
        String name = handleOperator.getName();
        String phone = handleOperator.getCellPhone();
        TPurchaserBasicInfo basicInfo = null;
        try {
            basicInfo = tPurchaserBasicInfoMapper.selectPurchaserBasicInfoByCell(phone);
            if (basicInfo != null) {
                return Result.error("员工:" + handleOperator.getCellPhone() + "已存在");
            }
        } catch (Exception e) {
            LOGGER.error("新增采购人员失败:{}", e);
            return Result.error("新增采购人员失败!");
        }
        TPurchaserBasicInfo pojo = new TPurchaserBasicInfo();
        pojo.setName(handleOperator.getName());
        pojo.setCellphone(handleOperator.getCellPhone());
        //指定默认密码
        pojo.setPassword(MD5Util.MD5EncodeUtf8(Const.DEFAULT_PASSWORD.PASSWORD));
        pojo.setPurchaserId(handleOperator.getPurchaserId());
        pojo.setInviterType(Const.INVITER_TYPE.PURCHASER);
        pojo.setInviterId((int) handleOperator.getPurchaserId());
        pojo.setInviterCompanyId((int) handleOperator.getPurchaserId());
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        pojo.setRole(handleOperator.getRole());
        pojo.setCreateAt(new Date());
        pojo.setUpdateAt(new Date());
        pojo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {
            tPurchaserBasicInfoMapper.insertSelective(pojo);
        } catch (BusinessException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("采购人新增员工失败", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("采购人新增员工失败", e);
            return Result.error(e.getMessage());
        }
        return Result.success(handleOperator.getName() + "添加成功!");
    }

    /**
     * 采购人信息
     * 点击注册按钮后页面进入完善信息阶段,传递过去的信息,nama ,password,自动生成的id
     *
     * @param handlePurchaser
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updatePurchaserDetail(HandleRegisterPurchaser handlePurchaser) {
        Long purchaserId = handlePurchaser.getPurchaseId();
        if (purchaserId == null) {
            return Result.success("请传入有效的信息");
        }
        TPurchaserBasicInfo basicInfo = null;
        try {
            basicInfo = tPurchaserBasicInfoMapper.selectByPrimaryKey(purchaserId);
            if (basicInfo == null) {
                return Result.success("没有采购人的注册信息");
            }
        } catch (Exception e) {
            LOGGER.error("完善采购人信息失败Exception:{}", e);
            return Result.error("完善信息失败");
        }
        //设置更新时间和t_purchaser_detail_info,t_purchaser_attachment的创建时间
        Date date = new Date();
        //补全信息
        basicInfo.setPurchaserId(purchaserId);
        basicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        basicInfo.setInviterId(Const.INVITER_TYPE.PLATFORM_ID);
        basicInfo.setInviterCompanyId(Const.INVITER_TYPE.PLATFORM_ID);
        basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
        basicInfo.setState(Const.STATE.REGISTERED);
        basicInfo.setRole(Const.Role.ROLE_CORPORATION);
        basicInfo.setCreateAt(date);
        basicInfo.setUpdateAt(date);
        basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //分装添加的条件,和跟新对象,添加数据到数据库三张表,t_purchaser_basic_info,t_purchaser_detail_info,t_purchaser_attachment
        //对公司信息唯一性进行校验
        TPurchaserDetailInfo detailInfo = tPurchaserDetailInfoMapper.selectDetailByCriteria(handlePurchaser.getCompanyName(), handlePurchaser.getPublicBankCount(), handlePurchaser.getUniformCreditCode());
        Result result = super.whichIsDuplicateForPurchaser(detailInfo, handlePurchaser.getCompanyName(), handlePurchaser.getUniformCreditCode(), handlePurchaser.getPublicBankCount());
        if (result != null) {
            return result;
        }
        detailInfo = new TPurchaserDetailInfo();
        BeanUtils.copyProperties(handlePurchaser, detailInfo, "id");
        detailInfo.setPurchaserId(purchaserId);
        detailInfo.setPublicBanAccountNumber(handlePurchaser.getPublicBankCount());
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        List<Attachement> list = handlePurchaser.getAtts();
        try {
            //修该基本信息
            tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(basicInfo);
            //修改详细信息
            TPurchaserDetailInfo tPurchaserDetailInfo = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaserId);
            if (tPurchaserDetailInfo == null) {
                tPurchaserDetailInfoMapper.insertSelective(detailInfo);
            } else {
                detailInfo.setId(tPurchaserDetailInfo.getId());
                tPurchaserDetailInfoMapper.updateByPrimaryKey(detailInfo);
            }
            //是否存在附件
            int records = tPurchaserAttachmentMapper.selectCountByPurchaserId(purchaserId);
            if (records > 0) {
                tPurchaserAttachmentMapper.deleteByPurchaserId(purchaserId);
                super.updatePuechaserAttachment(list, handlePurchaser.getLegalIdCardPositive(), handlePurchaser.getLegalIdCardOther(), handlePurchaser.getBusinessLicense(), purchaserId);
            } else {
                super.updatePuechaserAttachment(list, handlePurchaser.getLegalIdCardPositive(), handlePurchaser.getLegalIdCardOther(), handlePurchaser.getBusinessLicense(), purchaserId);
            }

        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善采购人信息失败", e);
            return Result.error("完善采购人信息失败");
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
        //查询注册信息
        String name = dto.getName();
        String cellphone = dto.getCellphone();
        //供应商的id
        Long supplierId = dto.getSupplierId();
        TSupplierBasicInfo basicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(supplierId);
        if (basicInfo == null) {
            return Result.error("没有该供货商的注册信息");
        }
        try {
            TPurchaserSupplier supplier = new TPurchaserSupplier();
            supplier.setState(basicInfo.getState());
            supplier.setSupplierId(basicInfo.getSupplierId());
            supplier.setOperateId((int) dto.getOperatorId());
            supplier.setSupplierType(Const.TRUST_OR_NOT.TRUST);
            supplier.setSource(Const.SOURCE.PUBLICS);
            supplier.setCreateAt(new Date());
            supplier.setUpdateAt(new Date());
            supplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            TPurchaserSupplier psupplier = tPurchaserSupplierMapper.selectPurchaserSupplierBySupplierId(supplierId);
            if (psupplier == null) {
                tPurchaserSupplierMapper.insertSelective(supplier);
            } else {
                //防止重复完善
                supplier.setId(psupplier.getId());
                tPurchaserSupplierMapper.updateByPrimaryKeySelective(supplier);
            }

            //对公司信息唯一性进行校验
            TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectDetailByCriteria(dto.getCompanyName(), dto.getPublicBankCount(), dto.getUniformCreditCode());
            Result result = super.whichIsDuplicateForSupplier(detailInfo, dto.getCompanyName(), dto.getUniformCreditCode(), dto.getPublicBankCount());
            if (result != null) {
                return result;
            }
            detailInfo = new TSupplierDetailInfo();
            BeanUtils.copyProperties(dto, detailInfo, "id", "supplierId");
            detailInfo.setSupplierId(supplierId);
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            TSupplierDetailInfo info = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(supplierId);
            if (info == null) {
                tSupplierDetailInfoMapper.insertSelective(detailInfo);
            } else {
                detailInfo.setId(info.getId());
                tSupplierDetailInfoMapper.updateByPrimaryKeySelective(detailInfo);
            }
            //附件信息
            List<Attachement> list = dto.getAtts();
            int records = tSupplierAttachmentMapper.selectCountBySupplierId(supplierId);
            if (records > 0) {
                super.updateSupplierAttachment(list, dto.getLegalIdCardPositive(), dto.getLegalIdCardOther(), dto.getBusinessLicense(), supplierId);
            } else {
                tSupplierAttachmentMapper.deleteAttachamentById(supplierId);
                super.updateSupplierAttachment(list, dto.getLegalIdCardPositive(), dto.getLegalIdCardOther(), dto.getBusinessLicense(), supplierId);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善供应商信息失败", e);
            return Result.error("完善供应商信息失败");
        }
        return Result.success("供应商更新成功", true);

    }

    /**
     * @author :lingzhixiang
     * @Description :完善代理机构的信息,机构已经注册
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateAgencyDetail(HandleAgnecy dto) {
        //查询注册信息
        String name = dto.getName();
        String cellphone = dto.getCellphone();
        try {
            TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectByPrimaryKey(dto.getAgencyId());
            if (basicInfo == null) {
                return Result.success("没有代理机构的注册信息");
            }
            //代理机构的id
            Long agencyId = basicInfo.getAgencyId();
            TPurchaserAgency agency = new TPurchaserAgency();
            agency.setState(basicInfo.getState());
            agency.setAgencyId(basicInfo.getAgencyId());
            agency.setCreaterId(basicInfo.getInviterId());
            agency.setPurchaserId(basicInfo.getInviterCompanyId() + "");
            agency.setSource(Const.SOURCE.PRIVATES);
            agency.setCreateAt(new Date());
            agency.setUpdateAt(new Date());
            agency.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            agency.setPurchaserId(dto.getCompanyId() + "");
            TPurchaserAgency agencys = tPurchaserAgencyMapper.selectAgencyByAgencyId(agencyId);
            if (agencys == null) {
                tPurchaserAgencyMapper.insertSelective(agency);
            } else {
                agency.setId(agencys.getId());
                tPurchaserAgencyMapper.updateByPrimaryKeySelective(agency);
            }

            TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
            detailInfo.setAgencyId(agencyId);
            BeanUtils.copyProperties(dto, detailInfo);
            detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            TAgencyDetailInfo info = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
            if (info == null) {
                tAgencyDetailInfoMapper.insertSelective(detailInfo);
            } else {
                detailInfo.setId(info.getId());
                tAgencyDetailInfoMapper.updateByPrimaryKeySelective(detailInfo);
            }
            //附件信息
            int records = tAgencyAttachmentMapper.selectCountByAgencyId(agencyId);
            //List<TAgencyAttachment> tAgencyAttachments = tAgencyAttachmentMapper.selectAttachmentByAgencyId(agencyId);
            if (records > 0) {
                tAgencyAttachmentMapper.deleteAttachmentByAgencyId(agencyId);
                super.updateAgencyAttachment(dto.getAtts(), dto.getLegalIdCardPositive(), dto.getLegalIdCardOther(), dto.getBusinessLicense(), agencyId);
            } else {
                super.updateAgencyAttachment(dto.getAtts(), dto.getLegalIdCardPositive(), dto.getLegalIdCardOther(), dto.getBusinessLicense(), agencyId);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善代理机构信息失败", e);
            return Result.error("完善代理机构信息失败");
        }
        return Result.success("更新成功", true);

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
        List<TPurchaserDetailInfo> tPurchaserDetails = tPurchaserDetailInfoMapper.selectByExample(detailCriteria);
        if (CollectionUtils.isEmpty(tPurchaserBasicInfos) || CollectionUtils.isEmpty(tPurchaserDetails)) {
            return Result.error("没有此员工的信息");
        }
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetails.get(0);
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
        List<PurchaserEmplyeeVo> list = new ArrayList<PurchaserEmplyeeVo>();
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
        List<TPurchaserDetailInfo> tPurchaserDetails = tPurchaserDetailInfoMapper.selectByExample(detailCriteria);
        if (CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
            return Result.error("没有此员工的信息");
        }
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetails.get(0);

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

        try {
            tPurchaserBasicInfoMapper.updateEmployeeStateByCellphone(cellphone, state);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("依据手机号修改状态失败", e);
            return Result.error(e.getMessage());
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

        try {
            tPurchaserBasicInfoMapper.updateEmployeeStateById(id, state);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("依据id修改状态失败", e);
            return Result.error(e.getMessage());
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
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);
        if (CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
            return Result.error("没有员工信息");
        }
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfos.get(0);
        //获得自己机构的id
        Long purchaseId = tPurchaserBasicInfo.getPurchaserId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria2.andPurchaserIdEqualTo(purchaseId);
        List<TPurchaserDetailInfo> tPurchaserDetails = tPurchaserDetailInfoMapper.selectByExample(detailCriteria);
        if (CollectionUtils.isEmpty(tPurchaserDetails)) {
            return Result.error("没有此员工的信息");
        }
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetails.get(0);

        //获得老板name和公司name
        TPurchaserBasicInfoCriteria infoCriteria2 = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria3 = infoCriteria.createCriteria();
        criteria3.andPurchaserIdEqualTo(purchaseId);
        criteria3.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        List<TPurchaserBasicInfo> tPurchaserBasicInfos1 = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);
        if (CollectionUtils.isEmpty(tPurchaserBasicInfos1)) {
            return Result.error("没有员工公司信息");
        }
        TPurchaserBasicInfo boss = tPurchaserBasicInfos1.get(0);
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
    public Result<PurchaserEmplyeeVo> queryEmployeeDto(QueryDto dto) {
        Long id = dto.getId();
        //依据id查询所有的对应的信息t_purchaser_basic_info
        PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
        TPurchaserDetailInfo tPurchaserDetail = null;
        TPurchaserBasicInfo tPurchaserBasicInfo = null;
        TPurchaserBasicInfo boss = null;
        try {
            tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByPrimaryKey(id);
            if (tPurchaserBasicInfo == null) {
                return Result.error("没有此id的员工");
            }
            //获得自己机构的id
            Long purchaseId = tPurchaserBasicInfo.getPurchaserId();
            tPurchaserDetail = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaseId);
            boss = tPurchaserBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(purchaseId, Const.Role.ROLE_CORPORATION);
        } catch (Exception e) {
            LOGGER.error("查询员工失败Exception:{}", e);
            return Result.error("查询失败");
        }
        //插入基本信息
        vo.setUserId(tPurchaserBasicInfo.getId().toString());
        vo.setUserName(tPurchaserBasicInfo.getName());
        vo.setCellphone(tPurchaserBasicInfo.getCellphone());
        if (tPurchaserDetail == null) {
            return Result.success("查询成功", vo);
        }
        //获得老板name和公司name
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = boss.getName();
        String companyId = tPurchaserDetail.getId().toString();
        //拼装信息
        vo.setCompanyId(companyId);
        vo.setBossName(bossName);
        vo.setCompanyName(companyName);

        return vo == null ? Result.success("没有符合要求的员工") : Result.success("查询成功", vo);
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
        //所有符合条件的员工
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = null;
        //公司详细信息
        TPurchaserDetailInfo tPurchaserDetail = null;
        //法人基本信息
        TPurchaserBasicInfo boss = null;
        //机构id
        Long purchaseId = employeeDto.getPurchaseId();
        if (purchaseId == null) {
            return Result.success("请传入有效的信息!");
        }
        //返回对象的集合
        List<PurchaserEmplyeeVo> list = new ArrayList<>();
        try {
            tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectBasicInfoCriteria(employeeDto);
            if (CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
                return Result.success("没有符合此条件的员工");
            }
            //获得自己机构的id

            tPurchaserDetail = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaseId);
            Integer role = Const.Role.ROLE_CORPORATION;
            boss = tPurchaserBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(purchaseId, role);
            if (tPurchaserDetail == null || boss == null) {
                return Result.success("公司信息不完善");
            }
            String companyName = tPurchaserDetail.getCompanyName();
            String bossName = boss.getName();
            String companyId = tPurchaserDetail.getId().toString();
            //拼装信息
            for (TPurchaserBasicInfo tPurchaserBasicInfo : tPurchaserBasicInfos) {
                PurchaserEmplyeeVo vo = new PurchaserEmplyeeVo();
                vo.setUserId(tPurchaserBasicInfo.getId().toString());
                vo.setUserName(tPurchaserBasicInfo.getName());
                vo.setCellphone(tPurchaserBasicInfo.getCellphone());
                vo.setCompanyId(companyId);
                vo.setBossName(bossName);
                vo.setCreateAt(tPurchaserBasicInfo.getCreateAt());
                vo.setState(tPurchaserBasicInfo.getIsForbidden());
                vo.setCompanyName(companyName);
                list.add(vo);
            }
        } catch (Exception e) {
            LOGGER.error("条件查询员工失败Exception:{}", e);
            return Result.error("条件查询员工失败");
        }
        return CollectionUtils.isEmpty(list) ? Result.success("没有相关员工的信息") : Result.success("查询成功", list);
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
        try {
            tPurchaserBasicInfoMapper.updateEmployeeRoleById(id, role);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("依据员工id修改权限失败", e);
            return Result.error(e.getMessage());
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
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(QuerySupplierDto dto) {
        //查询结果
        List<PurchaserSupplierVo> supplierVos = null;
        try {
            supplierVos = tSupplierDetailInfoMapper.selectSupplierByCriteria(dto);
        } catch (Exception e) {
            LOGGER.error("条件查询供应商失败Exception{}", e);
            return Result.error("条件查询供应商失败");
        }
        if (CollectionUtils.isEmpty(supplierVos)) {
            return Result.success("供应商不存在或信息不完全");
        }
        return CollectionUtils.isEmpty(supplierVos) ? Result.success("没有符合要求的员工") : Result.success("查询成功", supplierVos);
    }


    /**
     * @author :winlin
     * @Description :根据供货商id查询供应商信息不是自增主键id
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<SupplierDetailVo> querySuppliersDto(QueryDto dto) {
        Long id = dto.getId();
        if (id == null) {
            return Result.error("请传入有效的id");
        }
        TSupplierDetailInfo detailInfo = null;
        TSupplierBasicInfo basicInfo = null;
        List<TSupplierAttachment> attachments = null;
        try {
            detailInfo = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(id);
            basicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
            if (detailInfo == null || basicInfo == null) {
                return Result.error("没有此供货商信息");
            }
            attachments = tSupplierAttachmentMapper.selectAttachmentBySupplierId(id);
        } catch (Exception e) {
            LOGGER.error("查询供货商详细信息失败Exception:{}", e);
            return Result.error("查询供货商详细信息失败");
        }
        //封装返回信息
        SupplierDetailVo vo = new SupplierDetailVo();
        BeanUtils.copyProperties(detailInfo, vo);
        vo.setSupplierId(id);
        if (!CollectionUtils.isEmpty(attachments)) {
            List<Attachement> list = new ArrayList<>();
            for (TSupplierAttachment attachment : attachments) {
                if (attachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())) {
                    vo.setLegalIdCardOther(attachment.getCertificateFilePath());
                    continue;
                }
                if (attachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())) {
                    vo.setLegalIdCardPositive(attachment.getCertificateFilePath());
                    continue;
                }
                if (attachment.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())) {
                    vo.setBusinessLicense(attachment.getCertificateFilePath());
                    continue;
                }
                Attachement att = new Attachement();
                BeanUtils.copyProperties(attachment, att);
                att.setTypeId(attachment.getSupplierId().toString());
                list.add(att);
            }
            vo.setAtts(list);
        }
        return vo == null ? Result.success("没有相关供货商的信息") : Result.success("查询成功", vo);
    }

    @Override
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(QueryDto dto) {
        Long expertId = dto.getId();
        PurchaserExpertDetailVo vo = new PurchaserExpertDetailVo();
        if (expertId == null) {
            return Result.error("请传入有效的id");
        }
        TExpertBasicInfo basicInfo = null;
        TExpertDetailInfo detailInfo = null;
        List<TExpertAttachment> list = null;
        try {
            basicInfo = tExpertBasicInfoMapper.selectByPrimaryKey(expertId);
            detailInfo = tExpertDetailInfoMapper.selectDetaiInfoByExpertInfo(expertId);
            if (basicInfo == null) {
                return Result.error("没有专家信息");
            }
            vo.setName(basicInfo.getName());
            vo.setCellphone(basicInfo.getCellphone());
            vo.setProfession(basicInfo.getProfession());
            vo.setPositional(basicInfo.getPositional());
            vo.setLevel(basicInfo.getLevel());
            vo.setOtherInformation(basicInfo.getOtherInformation());
            if (detailInfo != null) {
                vo.setCompanyAddress(detailInfo.getCompanyAddress());
                vo.setCompany(detailInfo.getCompanyName());
            }
            //附件信息
            list = tExpertAttachmentMapper.selectAttchamentByExpertId(expertId);
        } catch (Exception e) {
            LOGGER.error("查询专家详细信息失败Exception:{}", e);
            return Result.error("查询专家详细信息失败");
        }
        if (!CollectionUtils.isEmpty(list)) {
            List<Attachement> attachements = new ArrayList<>();
            for (TExpertAttachment att : list) {
                if (att.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())) {
                    vo.setLegalIdCardOther(att.getCertificateFilePath());
                    continue;
                }
                if (att.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())) {
                    vo.setLegalIdCardPositive(att.getCertificateFilePath());
                    continue;
                }
                Attachement attt = new Attachement();
                BeanUtils.copyProperties(att, attt);
                attachements.add(attt);
            }
            vo.setAtts(attachements);
        }
        return vo == null ? Result.success("没有相关专家信息") : Result.success("查询成功", vo);
    }

    @Override
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(QueryDto dto) {
        Long agencyId = dto.getId();
        if (agencyId == null) {
            return Result.error("请传入有效的id");
        }
        TAgencyBasicInfo basicInfo = null;
        TAgencyDetailInfo detailInfo = null;
        List<TAgencyAttachment> attachments = null;
        try {
            detailInfo = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
            basicInfo = tAgencyBasicInfoMapper.selectByPrimaryKey(agencyId);
            if (detailInfo == null || basicInfo == null) {
                return Result.error("没有代理机构的信息");
            }
            attachments = tAgencyAttachmentMapper.selectAttachmentByAgencyId(agencyId);
        } catch (Exception e) {
            LOGGER.error("查询代理机构详细信息失败Exception:{}", e);
            return Result.error("查询代理机构详细信息失败");
        }
        //封装返回信息
        PurchaserAgencyDetailVo vo = new PurchaserAgencyDetailVo();
        BeanUtils.copyProperties(detailInfo, vo);
        vo.setAgencyId(agencyId);
        vo.setPublicBankCount(detailInfo.getPublicBanAccountNumber());
        if (!CollectionUtils.isEmpty(attachments)) {
            List<Attachement> list = new ArrayList<>();
            for (TAgencyAttachment attachment : attachments) {
                if (attachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())) {
                    vo.setLegalIdCardOther(attachment.getCertificateFilePath());
                    continue;
                }
                if (attachment.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())) {
                    vo.setLegalIdCardPositive(attachment.getCertificateFilePath());
                    continue;
                }
                if (attachment.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())) {
                    vo.setBusinessLicense(attachment.getCertificateFilePath());
                    continue;
                }
                Attachement att = new Attachement();
                BeanUtils.copyProperties(attachment, att);
                att.setTypeId(attachment.getAgencyId().toString());
                list.add(att);
            }
            vo.setAtts(list);
        }
        return vo == null ? Result.success("没有代理机构相关信息") : Result.success("查询成功", vo);
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
    public Result<List<PurchaserExpertVo>> queryExperts(QueryExpertDto dto) {
        List<PurchaserExpertVo> infoList = null;
        try {
            infoList = tExpertBasicInfoMapper.selectExpertByQueryCriteria(dto);
        } catch (Exception e) {
            LOGGER.error("查询专家失败Exception:{}", e);
            return Result.error("查询专家失败");
        }
        return CollectionUtils.isEmpty(infoList) ? Result.success("没有符合条件的专家") : Result.success("查询成功", infoList);
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
        try {
            tPurchaserBasicInfoMapper.updateExpertStateById(id, state);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改专家状态失败 ={}", e);
            return Result.error("修改失败");
        }

        return Result.success("删除成功", true);
    }

    /**
     * @author :winlin
     * @Description :删除员工
     * @date:2018/10/12
     */
    @Override
    public Result<Boolean> deletePurchaserEmployee(Long id) {
        if (id == null) {
            return Result.success("请传入有效的信息");
        }
        int success = 0;
        try {
            success = tPurchaserBasicInfoMapper.updateDeleteStateById(id);
        } catch (Exception e) {
            LOGGER.error("删除员工失败Exception:{}", e);
            return Result.error("删除员工失败");
        }
        return success > 0 ? Result.success("删除员工成功") : Result.success("删除员工失败");
    }

    @Override
    public Result selectPurchaserProjectStatus(RoleProjectProcessDetail detail) {
        Long id = detail.getId();
        Integer userType = detail.getUserType();
        String stepType = detail.getStepType();
        if (stepType.equals("announcement")) {
            List<Long> list = this.selectProjectInfo(id, userType, stepType).getData();
            if (CollectionUtils.isEmpty(list)) {
                return Result.success("没有待操作的公告信息");
            }
            List<BReleaseAnnouncement> bReleaseAnnouncements = null;
            try {
                bReleaseAnnouncements = bReleaseAnnouncementMapper.selectByIds(list);
            } catch (Exception e) {
                LOGGER.error("查询代办公告失败Exception:{}", e);
                return Result.error("查询代办公告失败");
            }
            return CollectionUtils.isEmpty(bReleaseAnnouncements) ? Result.success("没有符合条件的公告") : Result.success("查询成功", bReleaseAnnouncements);
        }
        if (stepType.equals("publicity")) {
            List<Long> list = this.selectProjectInfo(id, userType, stepType).getData();
            if (CollectionUtils.isEmpty(list)) {
                return Result.success("没有待操作的中标公示信息");
            }
            List<TWinBidNominate> nominates = null;
            try {
                nominates = tWinBidNominateMapper.selectByIds(list);
            } catch (Exception e) {
                LOGGER.error("查询代办公告失败Exception:{}", e);
                return Result.error("查询代办公告失败");
            }
            return CollectionUtils.isEmpty(nominates) ? Result.success("没有符合条件的中标公示") : Result.success("查询成功", nominates);
        }
        return Result.success("没有待操作的公告或中标公示信息");
    }

    public Result<List<Long>> selectProjectInfo(Long id, Integer userType, String stepType) {
        if (id == null || userType == null) {
            return Result.success("请传入有效的信息");
        }
        List<TPurchaseProjectParticipantPermission> tPurchaseProjectParticipantPermissions = null;
        //所有的项目id
        List<Long> purchaseProjectIds = new ArrayList<>();
        try {
            //依据 userID 和 userType 查询项目代办信息
            Integer state = Const.ACTION_STATE.NEED_DEAL;
            tPurchaseProjectParticipantPermissions = tPurchaseProjectParticipantPermissionMapper.selectByUserId(id, userType, state);
            if (CollectionUtils.isEmpty(tPurchaseProjectParticipantPermissions)) {
                return Result.success("没有待操作的公告或中标工时信息");
            }
            for (TPurchaseProjectParticipantPermission permission : tPurchaseProjectParticipantPermissions) {
                if (permission.getStepType().equals(stepType)) {
                    purchaseProjectIds.add(permission.getPurchaseProjectId());
                }
            }
            if (CollectionUtils.isEmpty(purchaseProjectIds)) {
                return Result.success("没有待操作的公告或中标工时信息");
            }
        } catch (Exception e) {
            LOGGER.error("查询项目详情失败Exception:{}", e);
            return Result.error("查询项目详情失败");
        }
        return Result.success("查询成功", purchaseProjectIds);
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
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(QueryAgencyDto dto) {
        List<PurchaserAgencyVo> agencyVos = null;
        try {
            agencyVos = tAgencyDetailInfoMapper.selectAgencyByCriteria(dto);
        } catch (Exception e) {
            LOGGER.error("查询代理机构失败Exception:{}", e);
            return Result.error("查询代理机构失败");
        }
        return CollectionUtils.isEmpty(agencyVos) ? Result.success("没有符合条件代理机构") : Result.success("查询成功", agencyVos);
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
        String name = dto.getExpertName();
        String cellphone = dto.getCellphone();
        Long expertId = dto.getExpertId();
        try {
            TExpertBasicInfo basicInfo = tExpertBasicInfoMapper.selectByPrimaryKey(expertId);
            if (basicInfo == null) {
                return Result.error("没有此手机号" + dto.getCellphone() + "的专家");
            }
            //实例化插入对象接受数据
            TPurchaserExpert purchaserExpert = tPurchaserExpertMapper.selectExpertByExpertId(expertId);
            TPurchaserExpert tPurchaserExpert = new TPurchaserExpert();
            tPurchaserExpert.setState(Const.STATE.REGISTERED);
            tPurchaserExpert.setExpertId(expertId);
            tPurchaserExpert.setPurchaserId(basicInfo.getInviterCompanyId() + "");
            tPurchaserExpert.setCreaterId(basicInfo.getInviterId());
            tPurchaserExpert.setSource(Const.SOURCE.PRIVATES);
            tPurchaserExpert.setCreateAt(new Date());
            tPurchaserExpert.setUpdateAt(new Date());
            tPurchaserExpert.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            if (purchaserExpert == null) {
                tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
            } else {
                tPurchaserExpert.setId(purchaserExpert.getId());
                tPurchaserExpertMapper.updateByPrimaryKeySelective(tPurchaserExpert);
            }
            //采购人公司的详细信息
            TPurchaserDetailInfo tPurchaserDetailInfo = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(dto.getPuchaserId());
            if (tPurchaserDetailInfo != null) {
                TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
                BeanUtils.copyProperties(tExpertDetailInfo, tExpertDetailInfo, "id");
                tExpertDetailInfo.setExpertId(expertId);
                tExpertDetailInfo.setCreateAt(new Date());
                tExpertDetailInfo.setUpdateAt(new Date());
                tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            }
            //查询附件信息状态
            List<TExpertAttachment> list = tExpertAttachmentMapper.selectAttchamentByExpertId(expertId);
            List<Attachement> atts = dto.getAtts();
            if (CollectionUtils.isEmpty(list)) {
                super.updateExpertAttachment(atts, dto.getLegalIdCardPositive(), dto.getLegalIdCardOther(), expertId);
            } else {
                tExpertAttachmentMapper.deleteByAttachmentByExpertId(expertId);
                super.updateExpertAttachment(atts, dto.getLegalIdCardPositive(), dto.getLegalIdCardOther(), expertId);
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("更新专家信息失败");
            return Result.error(e.getCause().getMessage());
        }

        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @Description :删除采购人专家
     * @date:2018/9/30
     */
    @Override
    public Result<Boolean> deletePurchaserExpert(HandleTrustList trustList) {
        Long id = trustList.getId();
        if (id == null) {
            return Result.error("请传入有效的信息");
        }
        Integer del = Const.IS_DELETED.IS_DELETED;
        try {
            tPurchaserExpertMapper.deleteExpertById(id, del);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("deletePurchaserExpert删除采购人专家失败", e);
            return Result.error(ErrorMessagesEnum.DELETE_FAILURE.getErrCode(), "删除专家失败");
        }
        return Result.success("删除采购人专家成功", true);
    }

    /**
     * @author :winlin
     * @Description :机构员工启用或禁用
     * @param:
     * @return:
     * @date:2018/9/29
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> enableOrDisablePurchaserEmployee(HandleTrustList trustList) {
        Integer forbidden = trustList.getEnableOrDisable();
        Long id = trustList.getId();
        if (id == null || forbidden == null) {
            return Result.error("请传入有效的修改信息");
        }
        try {
            tPurchaserBasicInfoMapper.enableOrDisablePurchaserEmployee(id, forbidden);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改状态失败", e);
            return Result.error("修改状态失败");
        }
        return Result.success("修改状态成功");
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeRole(HandleTrustList trustList) {
        Integer role = trustList.getRole();
        Long id = trustList.getId();
        if (id == null || role == null) {
            return Result.error("请传入有效的修改信息");
        }
        try {
            tPurchaserBasicInfoMapper.updatePurchaserEmployeeRole(id, role);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改采购人员工角色失败失败Exception:{}", e);
            return Result.error("修改采购人员工角色失败失败");
        }
        return Result.success("修改采购人员工角色失败成功");


    }

    /**
     * @author :winlin
     * @Description :修改员工信息
     * @date:2018/9/30
     */
    @Override
    public Result<Boolean> updatePurchaserEmployeeInfo(HandlePurchaserDto handlePurchaser) {
        //依据id查询员工是存在
        Long id = handlePurchaser.getUserId();
        if (id == null) {
            return Result.error("请传入有效的修改信息");
        }
        TPurchaserBasicInfo info = null;
        try {
            info = tPurchaserBasicInfoMapper.selectByPrimaryKey(id);
            if (info == null) {
                return Result.success("没有相关员工的信息", true);
            }
            //封装修改信息
            info.setName(handlePurchaser.getName());
            info.setCellphone(handlePurchaser.getCellphone());
            info.setRole(handlePurchaser.getRole());
            info.setUpdateAt(new Date());
            info.setId(id);
            tPurchaserBasicInfoMapper.updatePurchaserEmployeeDetail(info);
        } catch (Exception e) {
            LOGGER.error("updatePurchaserEmployeeInfo修改员工信息失败", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "修改员工信息失败");
        }
        return Result.success("修改员工信息成功", true);

    }

    /**
     * @author :winlin
     * @Description :添加Supplier到白名单"white_list"或"black_list"
     * @param:
     * @return:
     * @date:2018/9/29
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateTrustListForSupplier(HandleTrustList trustList) {
        if (trustList == null || StringUtils.isEmpty(trustList.getTrustOrNot()) || StringUtils.isEmpty(trustList.getId())) {
            return Result.error("请传入有效的修改信息");
        }
        try {
            tPurchaserSupplierMapper.updateTrustList(trustList);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改状态失败", e);
            return Result.error("修改状态失败");
        }
        return Result.success("修改状态成功");
    }

    /**
     * @author :winlin
     * @Description :添加Agency到白名单"white_list"或"black_list"
     * @param:
     * @return:
     * @date:2018/9/29
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateTrustListForAgency(HandleTrustList trustList) {
        if (trustList == null || StringUtils.isEmpty(trustList.getTrustOrNot()) || StringUtils.isEmpty(trustList.getId())) {
            return Result.error("请传入有效的修改信息");
        }
        try {
            tPurchaserAgencyMapper.updateTrustList(trustList);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改状态失败", e);
            return Result.error("修改状态失败");
        }
        return Result.success("修改状态成功");
    }


}