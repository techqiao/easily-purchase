package com.epc.web.service.service.impl.purchaser;
import com.google.common.collect.Lists;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
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
import com.epc.web.service.domain.purchaser.*;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.purchaser.*;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
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
public class PurchaserServiceImpl implements PurchaserService {
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
        String name = handleSupplier.getName();
        String cellphone = handleSupplier.getCellphone();
        //返回该供应商信息
       TSupplierBasicInfo basicInfo  = tSupplierBasicInfoMapper.selectSupplierBasicByNameAndCell(name,cellphone);

        //判断状态
        if (basicInfo != null) {
            int state = basicInfo.getState();
            int role = basicInfo.getRole();
            //假如状态是已审核并且角色是法人,同步到代理机构的私库
            if (state == Const.STATE.AUDIT_SUCCESS && role == Const.Role.ROLE_CORPORATION) {
                //查询详情库获得供应商的详细信息
                Long supplierId = basicInfo.getSupplierId();
                TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(supplierId);
                //从页面传入
                TPurchaserSupplier purchaserSupplier = new TPurchaserSupplier();
                purchaserSupplier.setOperateId((int)handleSupplier.getOperatorId());
                purchaserSupplier.setSource(handleSupplier.getSource());
                purchaserSupplier.setCreateAt(basicInfo.getCreateAt());
                purchaserSupplier.setUpdateAt(basicInfo.getUpdateAt());
                purchaserSupplier.setIsDeleted(basicInfo.getIsDeleted());
                purchaserSupplier.setSupplierType(Const.TRUST_OR_NOT.TRUST);
                //从公库basicinfo中获得
                purchaserSupplier.setState(Const.STATE.AUDIT_SUCCESS);
                purchaserSupplier.setSupplierId(basicInfo.getSupplierId());
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
                return Result.error("供货商没有审核通过或供货商信息不正确");
            }
        } else {
            //供应商不存在的时候抽取handleSupplier的字段添加
            TPurchaserSupplier purchaserSupplier = new TPurchaserSupplier();
            //采购人数据库
            purchaserSupplier.setOperateId((int)handleSupplier.getOperatorId());
            purchaserSupplier.setSource(handleSupplier.getSource());
            purchaserSupplier.setCreateAt(new Date());
            purchaserSupplier.setUpdateAt(new Date());
            purchaserSupplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            purchaserSupplier.setSupplierType(Const.TRUST_OR_NOT.TRUST);
            purchaserSupplier.setState(Const.STATE.COMMITTED);


            //供应商详情数据库
            TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
            //if(StringUtils.)
            detailInfo.setCompanyName(handleSupplier.getCompanyName());
            detailInfo.setUniformCreditCode(handleSupplier.getUniformCreditCode());
            detailInfo.setPublicBankName(handleSupplier.getPublicBankName());
            detailInfo.setPublicBanAccountNumber(handleSupplier.getPublicBankCount());
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);


            //供应商基本信息数据库
            basicInfo = new TSupplierBasicInfo();
            basicInfo.setName(handleSupplier.getName());
            basicInfo.setCellphone(handleSupplier.getCellphone());

            basicInfo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            basicInfo.setInviterId(handleSupplier.getOperatorId());
            basicInfo.setInviterCompanyId((int)handleSupplier.getCompanyId());
            basicInfo.setState(Const.STATE.COMMITTED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            basicInfo.setCreateAt(new Date());
            basicInfo.setUpdateAt(new Date());
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
                if (!CollectionUtils.isEmpty(atts)) {
                    for (Attachement att : atts) {
                        TSupplierAttachment attachment = new TSupplierAttachment();
                        BeanUtils.copyProperties(att, attachment);
                        attachment.setSupplierId(supplierId);
                        tSupplierAttachmentMapper.insertSelective(attachment);
                    }
                }
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
        String name = handleExpert.getName();
        String cellphone = handleExpert.getCellPhone();
        TExpertBasicInfo basicInfo = tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(name, cellphone);
        if (basicInfo != null) {
            //专家的审核状态
            int state = basicInfo.getState();
            TPurchaserExpert purchaserExpert = tPurchaserExpertMapper.selectExpertByNameAndCellPhone(name, cellphone);
            if (purchaserExpert != null) {
                return Result.error("专家:" + handleExpert.getName() + "已存在");
            } else {
                TPurchaserExpert tPurchaserExpert = new TPurchaserExpert();
                tPurchaserExpert.setState(state);
                tPurchaserExpert.setExpertId(basicInfo.getId());
                tPurchaserExpert.setPurchaserId(handleExpert.getPurchaserId() + "");
                tPurchaserExpert.setSource(handleExpert.getSource());
                tPurchaserExpert.setCreateAt(new Date());
                tPurchaserExpert.setUpdateAt(new Date());
                tPurchaserExpert.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                List<Attachement> list = handleExpert.getAtts();
                try {
                    //添加信息
                    tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
                } catch (Exception e) {
                    //捕获异常回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    LOGGER.error("采购人同步专家失败", e);
                    return Result.error("采购人同步专家失败");
                }
            }
        } else {
            //公库新增
            TExpertBasicInfo pojo = new TExpertBasicInfo();
            //pojo.setId(0L);
            Date date = new Date();
            pojo.setName(handleExpert.getName());
            pojo.setCellphone(handleExpert.getCellPhone());
            pojo.setProfession(handleExpert.getProfession());
            pojo.setPositional(handleExpert.getPositional());
            pojo.setLevel(handleExpert.getLevel());
            pojo.setIsIdle(Const.IS_IDLE_OR_NOT.IS_IDLE);
            pojo.setCircularDt(date);
            pojo.setCircularMethod(handleExpert.getCircularMethod());
            pojo.setOtherInformation(handleExpert.getOtherInformation());
            //pojo.setPassword("");
            pojo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            pojo.setInviterId(handleExpert.getOperatorId());
            pojo.setInviterCompanyId(handleExpert.getPurchaserId().intValue());
            pojo.setState(Const.STATE.COMMITTED);
            pojo.setCreateAt(new Date());
            pojo.setUpdateAt(new Date());
            pojo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

            //私库新增
            TPurchaserExpert operator = new TPurchaserExpert();
            //operator.setId(0L);
            operator.setState(Const.STATE.COMMITTED);
            //operator.setExpertId(0L);
            operator.setPurchaserId(handleExpert.getPurchaserId() + "");
            operator.setCreaterId(handleExpert.getOperatorId());
            operator.setSource(handleExpert.getSource());
            operator.setCreateAt(date);
            operator.setUpdateAt(date);
            operator.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            //附件信息
            List<Attachement> list = handleExpert.getAtts();
            try {
                tExpertBasicInfoMapper.insertSelective(pojo);
                //得到专家基本信心信息的id存入关联表中
                Long expertId = pojo.getId();
                operator.setExpertId(expertId);
                tPurchaserExpertMapper.insertSelective(operator);
                if (!CollectionUtils.isEmpty(list)) {
                    for (Attachement att : list) {
                        TExpertAttachment expertAttachment = new TExpertAttachment();
                        BeanUtils.copyProperties(att, expertAttachment);
                        expertAttachment.setExpertId(expertId);
                        tExpertAttachmentMapper.insertSelective(expertAttachment);
                    }
                }
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
        String name = handleAgnecy.getName();
        String cellphone = handleAgnecy.getCellphone();
        TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);
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
                //purchaserAgency.setId(0L);
                purchaserAgency.setState(basicInfo.getState());
                purchaserAgency.setAgencyId(agencyId);
                purchaserAgency.setCreaterId(handleAgnecy.getOperatorId());
                purchaserAgency.setPurchaserId(handleAgnecy.getCompanyId() + "");
                purchaserAgency.setSource(handleAgnecy.getSource());
                purchaserAgency.setCreateAt(new Date());
                purchaserAgency.setUpdateAt(new Date());
                purchaserAgency.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

//                List<Attachement> list = handleAgnecy.getAtts();
                try {
                    tPurchaserAgencyMapper.insertSelective(purchaserAgency);
//                    if (!CollectionUtils.isEmpty(list)) {
//                        for (Attachement att : list) {
//                            TAgencyAttachment attachment = new TAgencyAttachment();
//                            BeanUtils.copyProperties(att, attachment);
//                            attachment.setAgencyId(agencyId);
//                            tAgencyAttachmentMapper.insertSelective(attachment);
//                        }
//                    }
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
            //公库t_agency_basic和私库t_purchaser_agency都不存在时候私库添加手机号和姓名
            //公库t_agency_basic添加详细信息
            basicInfo = new TAgencyBasicInfo();
            basicInfo.setId(0L);
            basicInfo.setName(handleAgnecy.getName());
            basicInfo.setAgencyId(0L);
            basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            basicInfo.setCellphone(handleAgnecy.getCellphone());
            basicInfo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            basicInfo.setInviterId(handleAgnecy.getOperatorId());
            basicInfo.setInviterCompanyId((int) handleAgnecy.getCompanyId());
            basicInfo.setState(Const.STATE.COMMITTED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            basicInfo.setCreateAt(new Date());
            basicInfo.setUpdateAt(new Date());

            TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
            detailInfo.setId(0L);
            detailInfo.setAgencyId(0L);
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

            detailInfo.setCompanyName(handleAgnecy.getCompanyName());
            detailInfo.setUniformCreditCode(handleAgnecy.getUniformCreditCode());
            detailInfo.setPublicBankName(handleAgnecy.getPublicBankName());
            detailInfo.setPublicBanAccountNumber(handleAgnecy.getPublicBankCount());
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());


            //私库添加基本name和cellphone
            TPurchaserAgency agency = new TPurchaserAgency();
            agency.setId(0L);
            agency.setAgencyId(0L);
            agency.setCreaterId(handleAgnecy.getOperatorId());
            agency.setCreateAt(new Date());
            agency.setUpdateAt(new Date());
            agency.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

            agency.setState(Const.STATE.COMMITTED);
            agency.setPurchaserId(handleAgnecy.getCompanyId() + "");
            agency.setSource(handleAgnecy.getSource());
            agency.setCreateAt(new Date());
            agency.setUpdateAt(new Date());
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
                //附件信息
                List<Attachement> list = handleAgnecy.getAtts();
                if (!CollectionUtils.isEmpty(list)) {
                    for (Attachement att : list) {
                        TAgencyAttachment attachment = new TAgencyAttachment();
                        BeanUtils.copyProperties(att, attachment);
                        attachment.setAgencyId(agencyId);
                        tAgencyAttachmentMapper.insertSelective(attachment);
                    }
                }
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
        TPurchaserBasicInfo basicInfo = tPurchaserBasicInfoMapper.selectBasicInfoByNameAndPhone(name, phone);

        if (basicInfo != null) {
            return Result.error("员工:" + handleOperator.getName() + "已存在");
        }
        TPurchaserBasicInfo pojo = new TPurchaserBasicInfo();
        pojo.setName(handleOperator.getName());
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
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
     * 完善采购人信息
     * 点击注册按钮后页面进入完善信息阶段,传递过去的信息,nama ,password,自动生成的id
     *
     * @param handlePurchaser
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updatePurchaserDetail(HandleRegisterPurchaser handlePurchaser) {
        String name =handlePurchaser.getName();
        String cellphone = handlePurchaser.getCellphone();
        TPurchaserBasicInfo basicInfo = tPurchaserBasicInfoMapper.selectBasicInfoByNameAndPhone(name,cellphone);


        if(basicInfo==null){
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(),"没有供应商的注册信息");
        }
        //获得purchaser的id
        Long purchaserId = basicInfo.getId();
        //设置更新时间和t_purchaser_detail_info,t_purchaser_attachment的创建时间
        Date date = new Date();
        //补全信息
        basicInfo.setPurchaserId(purchaserId);
        basicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        basicInfo.setInviterId(Const.INVITER_TYPE.PLATFORM_ID);
        basicInfo.setInviterCompanyId(Const.INVITER_TYPE.PLATFORM_ID);
        basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
        basicInfo.setState(Const.STATE.COMMITTED);
        basicInfo.setRole(Const.Role.ROLE_CORPORATION);
        basicInfo.setCreateAt(date);
        basicInfo.setUpdateAt(date);
        basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //分装添加的条件,和跟新对象,添加数据到数据库三张表,t_purchaser_basic_info,t_purchaser_detail_info,t_purchaser_attachment
        TPurchaserDetailInfo detailInfo = new TPurchaserDetailInfo();
        detailInfo.setPurchaserId(purchaserId);
        detailInfo.setCompanyName(handlePurchaser.getCompanyName());
        detailInfo.setUniformCreditCode(handlePurchaser.getUniformCreditCode());
        detailInfo.setPublicBankName(handlePurchaser.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(handlePurchaser.getPublicBankCount());
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        //附件信息
        List<Attachement> list =handlePurchaser.getAtts();

        try {
            tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(basicInfo);
            tPurchaserDetailInfoMapper.insertSelective(detailInfo);
            if (!CollectionUtils.isEmpty(list)) {
                for (Attachement att : list) {
                    TPurchaserAttachment at = new TPurchaserAttachment();
                    BeanUtils.copyProperties(att, at);
                    at.setPurchaserId(purchaserId);
                    at.setCreateAt(date);
                    at.setUpdateAt(date);
                    tPurchaserAttachmentMapper.insertSelective(at);
                }
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
        TSupplierBasicInfo basicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByNameAndCell(name, cellphone);
        if (basicInfo == null) {
            return Result.error("没有该供货商的注册信息");
        }
        //代理机构的id
        Long supplierId = basicInfo.getId();
        TPurchaserSupplier supplier = tPurchaserSupplierMapper.selectPurchaserSupplierBySupplierId(supplierId);
        TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(supplierId);
        try {
            if (supplier == null) {
                supplier = new TPurchaserSupplier();
                //agency.setId(0L);
                supplier.setState(basicInfo.getState());
                supplier.setSupplierId(basicInfo.getSupplierId());
                supplier.setOperateId((int)dto.getOperatorId());
                supplier.setSupplierType(Const.TRUST_OR_NOT.TRUST);
                supplier.setSource(dto.getSource());
                supplier.setCreateAt(new Date());
                supplier.setUpdateAt(new Date());
                supplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                tPurchaserSupplierMapper.insertSelective(supplier);
            }
            if(detailInfo==null){
                detailInfo = new TSupplierDetailInfo();
                //detailInfo.setId(0L);
                detailInfo.setSupplierId(supplierId);
                detailInfo.setCompanyName(dto.getCompanyName());
                detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
                detailInfo.setPublicBankName(dto.getPublicBankName());
                detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
                detailInfo.setCreateAt(new Date());
                detailInfo.setUpdateAt(new Date());
                detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                tSupplierDetailInfoMapper.insertSelective(detailInfo);
            }
            //附件信息
            List<TSupplierAttachment> tAgencyAttachments = tSupplierAttachmentMapper.selectAttachmentBySupplierId(supplierId);
            if (CollectionUtils.isEmpty(tAgencyAttachments)) {
                List<Attachement> list = dto.getAtts();
                if (!CollectionUtils.isEmpty(list)) {
                    for (Attachement att : list) {
                        TSupplierAttachment attachment = new TSupplierAttachment();
                        BeanUtils.copyProperties(att, attachment);
                        attachment.setSupplierId(supplierId);
                        tSupplierAttachmentMapper.insertSelective(attachment);
                    }
                }
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
        TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);
        if (basicInfo == null) {
            return Result.error("没有该代理机构的注册信息");
        }
        //代理机构的id
        Long agencyId = basicInfo.getId();
        TPurchaserAgency agency = tPurchaserAgencyMapper.selectAgencyByAgencyId(agencyId);
        TAgencyDetailInfo detailInfo = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
        try {
            if (agency == null) {
                agency = new TPurchaserAgency();
                //agency.setId(0L);
                agency.setState(basicInfo.getState());
                agency.setAgencyId(basicInfo.getAgencyId());
                agency.setCreaterId(dto.getOperatorId());
                agency.setPurchaserId(dto.getCompanyId() + "");
                agency.setSource(dto.getSource());
                agency.setCreateAt(new Date());
                agency.setUpdateAt(new Date());
                agency.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                tPurchaserAgencyMapper.insertSelective(agency);
            }
            if(detailInfo==null){
                 detailInfo = new TAgencyDetailInfo();
                //detailInfo.setId(0L);
                detailInfo.setAgencyId(agencyId);
                detailInfo.setCompanyName(dto.getCompanyName());
                detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
                detailInfo.setPublicBankName(dto.getPublicBankName());
                detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
                detailInfo.setCreateAt(new Date());
                detailInfo.setUpdateAt(new Date());
                detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                tAgencyDetailInfoMapper.insertSelective(detailInfo);
            }
            //附件信息
            List<TAgencyAttachment> tAgencyAttachments = tAgencyAttachmentMapper.selectAttachmentByAgencyId(agencyId);
            if (CollectionUtils.isEmpty(tAgencyAttachments)) {
                List<Attachement> list = dto.getAtts();
                if (!CollectionUtils.isEmpty(list)) {
                    for (Attachement att : list) {
                        TAgencyAttachment attachment = new TAgencyAttachment();
                        BeanUtils.copyProperties(att, attachment);
                        attachment.setAgencyId(agencyId);
                        tAgencyAttachmentMapper.insertSelective(attachment);
                    }
                }
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善代理机构信息失败", e);
            return Result.error("完善代理机构信息失败");
        }
        return Result.success("更新成功", true);

    }

//    /**
//     * @author :winlin
//     * @Description :采购人注册
//     * @param:
//     * @return:
//     * @date:2018/9/20
//     */
//    @Override
//    @Transactional(rollbackFor = {Exception.class})
//    public Result<HandleRegisterPurchaser> registerPurchaser(HandleRegisterPurchaser purchaser) {
//        TPurchaserBasicInfo basicInfo = new TPurchaserBasicInfo();
//        //或的基本信息密码加密密码加密
//        String cellphone = purchaser.getCellphone();
//        String pwd = MD5Util.MD5EncodeUtf8(purchaser.getPassword());
//        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
//        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
//        criteria.andCellphoneEqualTo(cellphone);
//        criteria.andPasswordEqualTo(pwd);
//        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);
//        if (!CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
//            return Result.error(ErrorMessagesEnum.LOGINNAME_NUMBER_EXIST);
//        }
//        basicInfo.setCellphone(cellphone);
//        basicInfo.setPassword(pwd);
//        basicInfo.setCreateAt(new Date());
//        Result result = new Result();
//        int sucess = 0;
//        try {
//            sucess = tPurchaserBasicInfoMapper.insertSelective(basicInfo);
//        } catch (Exception e) {
//            //捕获异常回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            LOGGER.error("采购人注册失败", e);
//            return Result.error(e.getMessage());
//        }
//        Long id = basicInfo.getId();
//        if (sucess > 0) {
//            //数据库生成的id放入对象传入下个页面
//            purchaser.setPurchaseId(id);
//            result.setData(purchaser);
//            result.setMsg("注册成功");
//            return result;
//        }
//        return Result.error("注册成功");
//    }

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
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByPrimaryKey(id);
        if (tPurchaserBasicInfo == null) {
            return Result.error("没有此id的员工");
        }
        //获得自己机构的id
        Long purchaseId = tPurchaserBasicInfo.getPurchaserId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaseId);
        if (tPurchaserDetail==null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(),"查询失败");
        }
        TPurchaserBasicInfo boss =tPurchaserBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(purchaseId,Const.Role.ROLE_CORPORATION);
        //获得老板name和公司name
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
     * @Description :根据综合条件查员工
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(HandleEmployeeDto employeeDto) {
        //依据id查询所有的对应的信息t_purchaser_basic_info
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectBasicInfoCriteria(employeeDto);
        if (CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
            return Result.error("没有符合此条件的员工");
        }
        //获得自己机构的id
        Long purchaseId = employeeDto.getPurchaseId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetailInfoMapper.selectDetailByPurchaserId(purchaseId);

        Integer role = Const.Role.ROLE_CORPORATION;
        TPurchaserBasicInfo boss = tPurchaserBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(purchaseId, role);

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


        if (CollectionUtils.isEmpty(list)) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(), "查询失败");
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
        List<PurchaserSupplierVo> supplierVos = tSupplierDetailInfoMapper.selectSupplierByCriteria(dto);
        if (CollectionUtils.isEmpty(supplierVos) ) {
            return Result.error("供应商不存在或信息不完全");
        }

        return Result.success("查询成功", supplierVos);
    }

//    /**
//     * @author :winlin
//     * @Description :查找所有的供货商
//     * @param:
//     * @return:
//     * @date:2018/9/20
//     */
//    @Override
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public Result<List<PurchaserSupplierVo>> queryAllSuppliers(Long purchaseId) {
//        //封装查询条件
//        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
//        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
//        criteria.andPurchaserIdEqualTo(purchaseId.toString());
//
//        TSupplierDetailInfoCriteria detailInfoCriteria = new TSupplierDetailInfoCriteria();
//        TSupplierDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
//
//        TSupplierAttachmentCriteria attachmentCriteria = new TSupplierAttachmentCriteria();
//        TSupplierAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();
//
//        //查询结果
//        List<TPurchaserSupplier> supplierVos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
//        if (CollectionUtils.isEmpty(supplierVos)) {
//            return Result.error("没有供货商存在");
//        }
//        //封装附件查询的条件list,得到该采购人下所有供货商的id
//        List<Long> supplierIds = new ArrayList<>();
//        for (TPurchaserSupplier supplier : supplierVos) {
//            Long supplierId = supplier.getSupplierId();
//            supplierIds.add(supplierId);
//        }
//        //依据id查询所有的供应商
//        criteria1.andSupplierIdIn(supplierIds);
//        criteria2.andSupplierIdIn(supplierIds);
//        List<TSupplierDetailInfo> infoList = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria);
//        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);
//        if (CollectionUtils.isEmpty(infoList)) {
//            return Result.error("供应商不存在或信息不完全");
//        }
//        //封装返回值
//        List<PurchaserSupplierVo> list = new ArrayList<>();
//        for (TPurchaserSupplier supplierVo : supplierVos) {
//            Long supplierId = supplierVo.getSupplierId();
//            for (TSupplierDetailInfo info : infoList) {
//                Long supplierId1 = info.getSupplierId();
//                if (supplierId.equals(supplierId1)) {
//                    PurchaserSupplierVo vo = new PurchaserSupplierVo();
//                    vo.setSupplierId(supplierId);
//                    vo.setCompanyName(info.getCompanyName());
//                    vo.setCreateAt(new Date());
//                    vo.setUniformCreditCode(info.getUniformCreditCode());
//                    vo.setPublicBankName(info.getPublicBankName());
//                    vo.setPublicBanAccountNumber(info.getPublicBanAccountNumber());
//                    vo.setCellphone(supplierVo.getCellphone());
//                    list.add(vo);
//                }
//            }
//        }
//        for (PurchaserSupplierVo vo : list) {
//            Long supplierId = vo.getSupplierId();
//            List<Attachement> attachements = new ArrayList<>();
//            for (TSupplierAttachment attachment : attachments) {
//                Long supplierId1 = attachment.getSupplierId();
//                Attachement attachement = new Attachement();
//                if (supplierId.equals(supplierId1)) {
//                    BeanUtils.copyProperties(attachment, attachement);
//                    attachement.setTypeId(supplierId.toString());
//                    attachements.add(attachement);
//                }
//            }
//            vo.setAtts(attachements);
//        }
//        return Result.success("查询成功", list);
//    }

//    /**
//     * @author :winlin
//     * @Description :依据姓名模糊查找供货商
//     * @param:
//     * @return:
//     * @date:2018/9/21
//     */
//    @Override
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public Result<List<PurchaserSupplierVo>> querySuppliers(String fuzzyName, Long purchaseId) {
//        //封装查询条件
//        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
//        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
//        criteria.andPurchaserIdEqualTo(purchaseId.toString());
//
//        TSupplierDetailInfoCriteria detailInfoCriteria = new TSupplierDetailInfoCriteria();
//        TSupplierDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
//        criteria1.andCompanyNameLike(fuzzyName);
//
//        TSupplierAttachmentCriteria attachmentCriteria = new TSupplierAttachmentCriteria();
//        TSupplierAttachmentCriteria.Criteria criteria2 = attachmentCriteria.createCriteria();
//
//        //查询结果
//        List<TSupplierDetailInfo> supplierVos = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria);
//        List<TPurchaserSupplier> basicInfos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
//        if (CollectionUtils.isEmpty(supplierVos) || CollectionUtils.isEmpty(basicInfos)) {
//            return Result.error("没有符合要求的供货商");
//        }
//        //封装附件查询的条件list
//        List<Long> longs = new ArrayList<>();
//        //封装
//        List<PurchaserSupplierVo> vos = new ArrayList<>();
//        for (TSupplierDetailInfo detailInfo : supplierVos) {
//            PurchaserSupplierVo vo = new PurchaserSupplierVo();
//            Long supplierId = detailInfo.getSupplierId();
//            for (TPurchaserSupplier supplier : basicInfos) {
//                Long supplierId1 = supplier.getSupplierId();
//                if (supplierId.equals(supplierId1)) {
//                    longs.add(supplierId);
//                    vo.setCellphone(supplier.getCellphone());
//                    vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
//                    vo.setPublicBankName(detailInfo.getPublicBankName());
//                    vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
//                    vo.setCreateAt(detailInfo.getCreateAt());
//                    vo.setCompanyName(detailInfo.getCompanyName());
//                    vo.setSupplierId(supplierId);
//                    vos.add(vo);
//                }
//            }
//        }
//        criteria2.andSupplierIdIn(longs);
//        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);
//        if (!CollectionUtils.isEmpty(attachments)) {
//            for (PurchaserSupplierVo vo : vos) {
//                Long supplierId = vo.getSupplierId();
//                List<Attachement> list = new ArrayList<>();
//                for (TSupplierAttachment attachment : attachments) {
//                    Long supplierId2 = attachment.getSupplierId();
//                    if (supplierId.equals(supplierId2)) {
//                        Attachement att = new Attachement();
//                        BeanUtils.copyProperties(attachment, att);
//                        att.setTypeId(attachment.getSupplierId().toString());
//                        list.add(att);
//                    }
//                }
//                vo.setAtts(list);
//            }
//        }
//        return Result.success("查询成功", vos);
//    }

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
        TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(id);
        TSupplierBasicInfo basicInfo =tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        if (detailInfo==null||basicInfo== null) {
            return Result.error("没有此供货商信息");
        }

        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectAttachmentBySupplierId(id);

        //封装返回信息
        SupplierDetailVo vo = new SupplierDetailVo();
        vo.setSupplierId(id);
        vo.setCompanyName(detailInfo.getCompanyName());
        vo.setCreateAt(new Date());
        vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
        vo.setPublicBankName(detailInfo.getPublicBankName());
        vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
        vo.setCellphone(basicInfo.getCellphone());
        if (!CollectionUtils.isEmpty(attachments)) {
            List<Attachement> list = new ArrayList<>();
            for (TSupplierAttachment attachment : attachments) {
                Attachement att = new Attachement();
                BeanUtils.copyProperties(attachment, att);
                att.setTypeId(attachment.getSupplierId().toString());
                list.add(att);
            }
            vo.setAtts(list);
        }
        return Result.success("查询成功", vo);
    }

    @Override
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(QueryDto dto) {
        Long expertId = dto.getId();
        if(expertId!=null){
            TExpertBasicInfo basicInfo =tExpertBasicInfoMapper.selectByPrimaryKey(expertId);
            if(basicInfo!=null){
                List<TExpertAttachment> list = tExpertAttachmentMapper.selectAttchamentByExpertId(expertId);
                if(!CollectionUtils.isEmpty(list)){
                    PurchaserExpertDetailVo vo = new PurchaserExpertDetailVo();
                    vo.setName(basicInfo.getName());
                    vo.setCellphone(basicInfo.getCellphone());
                    vo.setProfession(basicInfo.getProfession());
                    vo.setPositional(basicInfo.getPositional());
                    vo.setLevel(basicInfo.getLevel());
                    vo.setOtherInformation(basicInfo.getOtherInformation());
                    List<Attachement> attachements = new ArrayList<>();
                    for (TExpertAttachment att:list) {
                        Attachement attt = new Attachement();
                        BeanUtils.copyProperties(att,attt);
                        attachements.add(attt);
                    }
                    vo.setAtts(attachements);
                    return Result.success("查询成功",vo);
                }
            }
        }
        return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(),"查询失败");
    }

    @Override
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(QueryDto dto) {
        Long agencyId = dto.getId();
        if(agencyId!=null){
            TAgencyBasicInfo basicInfo =tAgencyBasicInfoMapper.selectByPrimaryKey(agencyId);
            if(basicInfo!=null){
                TAgencyDetailInfo detailInfo =tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
                List<TAgencyAttachment> list = tAgencyAttachmentMapper.selectAttachmentByAgencyId(agencyId);
                if(!CollectionUtils.isEmpty(list)){
                    PurchaserAgencyDetailVo vo = new PurchaserAgencyDetailVo();
                    vo.setAgencyId(agencyId);
                    vo.setCellphone(basicInfo.getCellphone());
                    vo.setState(basicInfo.getState());
                    vo.setName(basicInfo.getName());
                    vo.setCompanyName(detailInfo.getCompanyName());
                    vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
                    vo.setPublicBankName(detailInfo.getPublicBankName());
                    vo.setPublicBankCount(detailInfo.getPublicBanAccountNumber());
                    List<Attachement> attachements = new ArrayList<>();
                    for (TAgencyAttachment att:list) {
                        Attachement attt = new Attachement();
                        BeanUtils.copyProperties(att,attt);
                        attachements.add(attt);
                    }
                    vo.setAtts(attachements);
                    return Result.success("查询成功",vo);
                }
            }
        }
        return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(),"查询失败");
    }

//    /**
//     * @author :winlin
//     * @Description :修改供应商信息,需要供货商id
//     * @param:
//     * @return:
//     * @date:2018/9/21
//     */
//    @Override
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @Transactional(rollbackFor = {Exception.class})
//    public Result<Boolean> updateSuppliers(HandleSupplierDto dto) {
//        //t_purchaser_Supplier t_SUPPLIER _attachment t_SUPPLIER _basic_info ,t_SUPPLIER_detail_info查询信息封装
//        //供货商id
//        Long supplierId = dto.getSupplierId();
//
//        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
//        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
//        //数据库字段为supplierId
//        criteria.andSupplierIdEqualTo(supplierId);
//
//        TSupplierBasicInfoCriteria tSupplierBasicInfoCriteria = new TSupplierBasicInfoCriteria();
//        TSupplierBasicInfoCriteria.Criteria criteria1 = tSupplierBasicInfoCriteria.createCriteria();
//        criteria1.andIdEqualTo(supplierId);
//
//        TSupplierAttachmentCriteria tSupplierAttachmentCriteria = new TSupplierAttachmentCriteria();
//        TSupplierAttachmentCriteria.Criteria criteria2 = tSupplierAttachmentCriteria.createCriteria();
//        criteria2.andSupplierIdEqualTo(supplierId);
//
//        TSupplierDetailInfoCriteria tSupplierDetailInfoCriteria = new TSupplierDetailInfoCriteria();
//        TSupplierDetailInfoCriteria.Criteria criteria3 = tSupplierDetailInfoCriteria.createCriteria();
//        criteria3.andSupplierIdEqualTo(supplierId);
//        //接受页面穿过来的信息,录入数据库,受影响的表,之前
//        //实例化对象接受数据
//        TSupplierBasicInfo basicInfo = new TSupplierBasicInfo();
//        basicInfo.setName(dto.getName());
//        basicInfo.setCellphone(dto.getCellphone());
//        basicInfo.setUpdateAt(new Date());
//
//        TPurchaserSupplier supplier = new TPurchaserSupplier();
//        supplier.setCellphone(dto.getCellphone());
//        supplier.setSupplierName(dto.getCompanyName());
//        supplier.setUpdateAt(new Date());
//
//        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
//        detailInfo.setCompanyName(dto.getCompanyName());
//        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
//        detailInfo.setPublicBankName(dto.getPublicBankName());
//        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
//        detailInfo.setUpdateAt(new Date());
//        try {
//            tSupplierBasicInfoMapper.updateByExample(basicInfo, tSupplierBasicInfoCriteria);
//            tPurchaserSupplierMapper.updateByExample(supplier, supplierCriteria);
//            tSupplierDetailInfoMapper.updateByExample(detailInfo, tSupplierDetailInfoCriteria);
//            List<Attachement> list = dto.getAtts();
//            if (!CollectionUtils.isEmpty(list)) {
//                for (Attachement attachement : dto.getAtts()) {
//                    TSupplierAttachment att = new TSupplierAttachment();
//                    BeanUtils.copyProperties(attachement, att);
//                    att.setSupplierId(supplierId);
//                    tSupplierAttachmentMapper.updateByExample(att, tSupplierAttachmentCriteria);
//                }
//            }
//        } catch (Exception e) {
//            //捕获异常回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            LOGGER.error("修改供货商信息失败", e);
//            return Result.error("修改供货商信息失败");
//        }
//
//
//        return Result.success("更新成功", true);
//    }

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
        List<PurchaserExpertVo> infoList = tExpertBasicInfoMapper.selectExpertByQueryCriteria(dto);
        if (CollectionUtils.isEmpty(infoList)) {
            return Result.error("没有符合条件的专家");
        }
        return Result.success("查询成功", infoList);
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
            LOGGER.error("修改专家状态失败", e);
            return Result.error("修改失败");
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
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(QueryAgencyDto dto) {

        //查询结果
        List<PurchaserAgencyVo> agencyVos = tAgencyDetailInfoMapper.selectAgencyByCriteria(dto);

        if (CollectionUtils.isEmpty(agencyVos)) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(),"没有符合条件的供应商");
        }
        return Result.success("查询成功", agencyVos);
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
        TExpertBasicInfo basicInfo = tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(name, cellphone);
        if (basicInfo == null) {
            return Result.error("没有此手机号" + dto.getCellphone() + "的专家");
        }
        //得到expertid
        Long expertId = basicInfo.getId();
        //实例化插入对象接受数据
        TPurchaserExpert tPurchaserExpert = tPurchaserExpertMapper.selectExpertByExpertId(expertId);
        try {
            if (tPurchaserExpert == null) {
                tPurchaserExpert = new TPurchaserExpert();
                tPurchaserExpert.setState(Const.STATE.COMMITTED);
                tPurchaserExpert.setExpertId(expertId);
                tPurchaserExpert.setPurchaserId(basicInfo.getInviterCompanyId() + "");
                tPurchaserExpert.setCreaterId(basicInfo.getInviterId());
                tPurchaserExpert.setSource(dto.getSource());
                tPurchaserExpert.setCreateAt(new Date());
                tPurchaserExpert.setUpdateAt(new Date());
                tPurchaserExpert.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
            }
            //封装附件信息对象
            List<Attachement> atts = dto.getAtts();
            if (!CollectionUtils.isEmpty(atts)) {
                for (Attachement att : atts) {
                    TExpertAttachment attachment = new TExpertAttachment();
                    BeanUtils.copyProperties(att, attachment);
                    attachment.setExpertId(expertId);
                    tExpertAttachmentMapper.insertSelective(attachment);
                }
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

//    /**
//     * @author :winlin
//     * @Description :修改采购人代理机构的信息前端页面附带代理机构唯一的id
//     * @param:
//     * @return:
//     * @date:2018/9/21
//     */
//    @Override
//    @Transactional(rollbackFor = {Exception.class})
//    public Result<Boolean> updatePurchaserAgency(HandleAgencyDto dto) {
//        //t_purchaser_Agency t_Agency _attachment t_Agency _basic_info ,t_agency_detail_info查询信息封装
//        //代理机构id
//        Long agencyId = dto.getAgencyId();
//
//        TPurchaserAgencyCriteria agencyCriteria = new TPurchaserAgencyCriteria();
//        TPurchaserAgencyCriteria.Criteria criteria = agencyCriteria.createCriteria();
//        //数据库字段为supplierId
//        criteria.andSupplierIdEqualTo(agencyId);
//
//        TAgencyBasicInfoCriteria tAgencyBasicInfoCriteria = new TAgencyBasicInfoCriteria();
//        TAgencyBasicInfoCriteria.Criteria criteria1 = tAgencyBasicInfoCriteria.createCriteria();
//        criteria1.andIdEqualTo(agencyId);
//
//        TAgencyAttachmentCriteria tExpertAttachmentCriteria = new TAgencyAttachmentCriteria();
//        TAgencyAttachmentCriteria.Criteria criteria2 = tExpertAttachmentCriteria.createCriteria();
//        criteria2.andAgencyIdEqualTo(agencyId);
//
//        TAgencyDetailInfoCriteria tAgencyDetailInfoCriteria = new TAgencyDetailInfoCriteria();
//        TAgencyDetailInfoCriteria.Criteria criteria3 = tAgencyDetailInfoCriteria.createCriteria();
//        criteria3.andAgencyIdEqualTo(agencyId);
//        //接受页面穿过来的信息,录入数据库,受影响的表,之前
//        //实例化对象接受数据
//        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
//        basicInfo.setName(dto.getName());
//        basicInfo.setCellphone(dto.getCellphone());
//        basicInfo.setState(dto.getState());
//        basicInfo.setUpdateAt(new Date());
//
//        TPurchaserAgency agency = new TPurchaserAgency();
//        agency.setCellphone(dto.getCellphone());
//        agency.setState(dto.getState());
//        agency.setSupplierName(dto.getCompanyName());
//        agency.setUpdateAt(new Date());
//
//        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
//        detailInfo.setCompanyName(dto.getCompanyName());
//        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
//        detailInfo.setPublicBankName(dto.getPublicBankName());
//        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
//        detailInfo.setUpdateAt(new Date());
//        try {
//            tAgencyBasicInfoMapper.updateByExample(basicInfo, tAgencyBasicInfoCriteria);
//            tPurchaserAgencyMapper.updateByExample(agency, agencyCriteria);
//            tAgencyDetailInfoMapper.updateByExample(detailInfo, tAgencyDetailInfoCriteria);
//            List<Attachement> list = dto.getAtts();
//            if (!CollectionUtils.isEmpty(list)) {
//                for (Attachement attachement : dto.getAtts()) {
//                    TAgencyAttachment att = new TAgencyAttachment();
//                    BeanUtils.copyProperties(attachement, att);
//                    att.setAgencyId(agencyId);
//                    tAgencyAttachmentMapper.updateByExample(att, tExpertAttachmentCriteria);
//                }
//            }
//        } catch (Exception e) {
//            //捕获异常回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            LOGGER.error("修改代理机构信息失败");
//            return Result.error(e.getMessage());
//        }
//        return Result.success("更新成功", true);
//    }

//    /**
//     * @author :winlin
//     * @description :修改采购人专家的信息,前端页面附带专家唯一的id
//     * @param:
//     * @return:
//     * @date:2018/9/21
//     */
//    @Override
//    @Transactional(rollbackFor = {Exception.class})
//    public Result<Boolean> updatePurchaserExpert(HandleExpertDto dto) {
//        //t_purchaser_expert t_expert_attachment t_expert_basic_info 查询信息封装
//        //专家id
//        Long expertId = dto.getExpertId();
//
//        TPurchaserExpertCriteria expertCriteria = new TPurchaserExpertCriteria();
//        TPurchaserExpertCriteria.Criteria criteria = expertCriteria.createCriteria();
//        criteria.andExpertIdEqualTo(expertId);
//
//        TExpertBasicInfoCriteria tExpertBasicInfoCriteria = new TExpertBasicInfoCriteria();
//        TExpertBasicInfoCriteria.Criteria criteria1 = tExpertBasicInfoCriteria.createCriteria();
//        criteria1.andIdEqualTo(expertId);
//
//        TExpertAttachmentCriteria tExpertAttachmentCriteria = new TExpertAttachmentCriteria();
//        TExpertAttachmentCriteria.Criteria criteria2 = tExpertAttachmentCriteria.createCriteria();
//        criteria2.andExpertIdEqualTo(expertId);
//
//        //接受页面穿过来的信息,录入数据库,受影响的表,之前
//        //实例化对象接受数据
//        TExpertBasicInfo basicInfo = new TExpertBasicInfo();
//
//        basicInfo.setName(dto.getExpertName());
//        basicInfo.setCellphone(dto.getCellphone());
//        basicInfo.setProfession(dto.getProfession());
//        basicInfo.setPositional(dto.getPositional());
//        basicInfo.setLevel(dto.getLevel());
//        basicInfo.setState(dto.getState());
//        basicInfo.setUpdateAt(new Date());
//
//        TPurchaserExpert expert = new TPurchaserExpert();
//        expert.setCellphone(dto.getCellphone());
//        expert.setState(dto.getState());
//        expert.setExpertName(dto.getExpertName());
//        expert.setUpdateAt(new Date());
//        try {
//            tExpertBasicInfoMapper.updateByExample(basicInfo, tExpertBasicInfoCriteria);
//            tPurchaserExpertMapper.updateByExample(expert, expertCriteria);
//            List<Attachement> list = dto.getAtts();
//            if (!CollectionUtils.isEmpty(list)) {
//                for (Attachement attachement : list) {
//                    TExpertAttachment att = new TExpertAttachment();
//                    BeanUtils.copyProperties(attachement, att);
//                    att.setExpertId(expertId);
//                    tExpertAttachmentMapper.updateByExample(att, tExpertAttachmentCriteria);
//                }
//            }
//        } catch (Exception e) {
//            //捕获异常回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            LOGGER.error("修改专家信息失败", e);
//            return Result.error(e.getMessage());
//        }
//
//        return Result.success("更新成功", true);
//    }

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
        if (forbidden == null) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "员工启用或禁用失败");
        }
        try {
            tPurchaserBasicInfoMapper.enableOrDisablePurchaserEmployee(id, forbidden);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            if (forbidden.equals(Const.ENABLE_OR_DISABLE.DISABLE)) {

            }
            LOGGER.error("修改状态失败", e);
            return Result.error("修改状态失败");
        }
        return Result.success("修改状态成功");
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeRole(HandleTrustList trustList) {
        Integer role = trustList.getRole();
        Long id = trustList.getId();
        if (role == null) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "修改采购人员工角色失败失败");
        }
        try {
            tPurchaserBasicInfoMapper.updatePurchaserEmployeeRole(id, role);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改采购人员工角色失败失败", e);
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
        TPurchaserBasicInfo info = tPurchaserBasicInfoMapper.selectByPrimaryKey(id);
        if (info == null) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "没有员工信息");
        }
        //封装修改信息
        info.setName(handlePurchaser.getName());
        info.setCellphone(handlePurchaser.getCellphone());
        info.setRole(handlePurchaser.getRole());
        info.setUpdateAt(new Date());
        info.setId(id);
        try {
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
        if (StringUtils.isEmpty(trustList.getTrustOrNot())) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "修改供货商信任状态失败");
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
        if (StringUtils.isEmpty(trustList.getTrustOrNot())) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "修改代理机构信任状态失败");
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