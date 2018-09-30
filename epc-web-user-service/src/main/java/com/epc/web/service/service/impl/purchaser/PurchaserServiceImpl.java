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
import com.epc.web.service.domain.agency.*;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.expert.TExpertAttachmentCriteria;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfoCriteria;
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
import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.print.attribute.standard.MediaSizeName;
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
    TOperatorPurchaserMapper tOperatorPurchaserMapper;
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
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andCellphoneEqualTo(handleSupplier.getCellphone());
        criteria1.andNameEqualTo(handleSupplier.getName());

        //返回该供应商信息
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
        TSupplierBasicInfo basicInfo = !CollectionUtils.isEmpty(list) ? list.get(0) : null;

        //判断状态
        if (basicInfo != null) {
            int state = basicInfo.getState();
            int role = basicInfo.getRole();
            //假如状态是已审核并且角色是法人,同步到代理机构的私库
            if (state == Const.STATE.AUDIT_SUCCESS && role == Const.Role.ROLE_CORPORATION) {
                //查询详情库获得供应商的详细信息
                Long supplierId = basicInfo.getSupplierId();
                TSupplierDetailInfoCriteria criteria2 = new TSupplierDetailInfoCriteria();
                criteria2.createCriteria().andSupplierIdEqualTo(supplierId);
                List<TSupplierDetailInfo> list1 = tSupplierDetailInfoMapper.selectByExample(criteria2);
                TSupplierDetailInfo detailInfo = !CollectionUtils.isEmpty(list1) ? list1.get(0) : null;
                //设置私库存储对象
                //从页面传入
                TPurchaserSupplier purchaserSupplier = new TPurchaserSupplier();
                //从公库basicinfo中获得
                purchaserSupplier.setCellphone(basicInfo.getCellphone());
                purchaserSupplier.setPassword(basicInfo.getPassword());
                purchaserSupplier.setState(Const.STATE.AUDIT_SUCCESS);
                purchaserSupplier.setSupplierId(basicInfo.getSupplierId());
                purchaserSupplier.setSupplierName(basicInfo.getName());
                purchaserSupplier.setPurchaserId(handleSupplier.getPurcharseId() + "");
                purchaserSupplier.setSource(handleSupplier.getSource());
                purchaserSupplier.setCreateAt(new Date());
                purchaserSupplier.setUpdateAt(new Date());
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
            TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();

            basicInfo = new TSupplierBasicInfo();

            //添加姓名,手机号,代理id,来源
            purchaserSupplier.setCellphone(handleSupplier.getCellphone());
            purchaserSupplier.setState(Const.STATE.COMMITTED);
            purchaserSupplier.setSupplierName(handleSupplier.getCompanyName());
            purchaserSupplier.setPurchaserId(handleSupplier.getPurcharseId() + "");
            purchaserSupplier.setSource(handleSupplier.getSource());
            purchaserSupplier.setCreateAt(new Date());
            purchaserSupplier.setUpdateAt(new Date());

            //第一次新增basicinfo中的法人supplierid 代码生成
            basicInfo.setName(handleSupplier.getName());
            basicInfo.setCellphone(handleSupplier.getCellphone());
            basicInfo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            basicInfo.setInviterId(handleSupplier.getOperatorId());
            basicInfo.setInviterCompanyId((int) handleSupplier.getCompanyId());
            basicInfo.setState(Const.STATE.COMMITTED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            basicInfo.setCreateAt(new Date());
            basicInfo.setUpdateAt(new Date());


            //供应商详情
            detailInfo.setCompanyName(handleSupplier.getCompanyName());
            detailInfo.setUniformCreditCode(handleSupplier.getUniformCreditCode());
            detailInfo.setPublicBankName(handleSupplier.getPublicBankName());
            detailInfo.setPublicBanAccountNumber(handleSupplier.getPublicBankCount());
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());

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
        TExpertBasicInfoCriteria criteria = new TExpertBasicInfoCriteria();
        TExpertBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andNameEqualTo(handleExpert.getName());
        criteria1.andCellphoneEqualTo(handleExpert.getCellPhone());
        List<TExpertBasicInfo> list = tExpertBasicInfoMapper.selectByExample(criteria);
        if (!CollectionUtils.isEmpty(list)) {
            TExpertBasicInfo basicInfo = list.get(0);
            int state = basicInfo.getState(); //状态由数据库负责更新
            //同步到私库中,增加之前先查询私库是否存在
            TPurchaserExpertCriteria expertCriteria = new TPurchaserExpertCriteria();
            TPurchaserExpertCriteria.Criteria criteria2 = expertCriteria.createCriteria();
            criteria2.andCellphoneEqualTo(handleExpert.getCellPhone());
            criteria2.andExpertNameEqualTo(handleExpert.getName());
            List<TPurchaserExpert> purchaserBasicInfos = tPurchaserExpertMapper.selectByExample(expertCriteria);
            if (!CollectionUtils.isEmpty(purchaserBasicInfos)) {
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
                        LOGGER.error("采购人同步专家失败", e);
                        return Result.error("采购人同步专家失败");
                    }
                } else {
                    try {
                        //添加信息到私库中
                        tPurchaserExpertMapper.insertSelective(tPurchaserExpert);
                    } catch (Exception e) {
                        //捕获异常回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        LOGGER.error("采购人同步专家失败", e);
                        return Result.error("采购人同步专家失败");
                    }
                }
            }
        } else {
            //公库新增
            TExpertBasicInfo pojo = new TExpertBasicInfo();
            Date date = new Date();
            pojo.setCellphone(handleExpert.getCellPhone());
            pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
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
            operator.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            operator.setState(Const.STATE.REGISTERED);
            operator.setCreateAt(date);
            operator.setUpdateAt(date);
            try {
                tExpertBasicInfoMapper.insertSelective(pojo);
                //得到专家基本信心信息的id存入关联表中
                Long expert_id = pojo.getId();
                operator.setExpertId(expert_id);
                tPurchaserExpertMapper.insertSelective(operator);
            } catch (BusinessException e) {
                LOGGER.error("采购人专家入库失败", e);
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("采购人专家入库失败", e);
                return Result.error(e.getMessage());
            }
        }
        return Result.success("注册成功");
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
        TAgencyBasicInfoCriteria infoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andNameEqualTo(handleAgnecy.getName());
        criteria.andCellphoneEqualTo(handleAgnecy.getCellphone());
        List<TAgencyBasicInfo> list = tAgencyBasicInfoMapper.selectByExample(infoCriteria);
        if (!CollectionUtils.isEmpty(list)) {
            TAgencyBasicInfo basicInfo = list.get(0);
            int state = basicInfo.getState();
            int role = basicInfo.getRole();
            //代理机构信息存在且状态审核完毕,角色为法人
            if (state == Const.STATE.AUDIT_SUCCESS && role == Const.Role.ROLE_CORPORATION) {
                //获得代理机构的id
                Long agencyId = basicInfo.getAgencyId();
                //信息添加到私库t_purchaser_agency,先查询t_agency_detail信息
                TAgencyDetailInfoCriteria tAgencyDetailInfoCriteria = new TAgencyDetailInfoCriteria();
                TAgencyDetailInfoCriteria.Criteria criteria1 = tAgencyDetailInfoCriteria.createCriteria();
                criteria1.andAgencyIdEqualTo(agencyId);
                List<TAgencyDetailInfo> tAgencyDetailInfos = tAgencyDetailInfoMapper.selectByExample(tAgencyDetailInfoCriteria);
                if (CollectionUtils.isEmpty(tAgencyDetailInfos)) {
                    return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
                }
                //获得已存在代理机构的详细信息
                TAgencyDetailInfo detailInfo = tAgencyDetailInfos.get(0);
                TPurchaserAgency purchaserAgency = new TPurchaserAgency();
                purchaserAgency.setCellphone(basicInfo.getCellphone());
                purchaserAgency.setPassword(basicInfo.getPassword());
                purchaserAgency.setState(state);
                //数据库字段为角色id
                purchaserAgency.setSupplierId(basicInfo.getAgencyId());
                purchaserAgency.setSupplierName(detailInfo.getCompanyName());
                purchaserAgency.setPurchaserId(handleAgnecy.getCompanyId() + "");
                purchaserAgency.setSource(handleAgnecy.getSource());
                purchaserAgency.setCreateAt(new Date());
                purchaserAgency.setUpdateAt(new Date());
                //信息添加进入私库
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
            //公库t_agency_basic和私库t_purchaser_agency都不存在时候私库添加手机号和姓名
            //公库t_agency_basic添加详细信息
            TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
            basicInfo.setName(handleAgnecy.getName());
            basicInfo.setCellphone(handleAgnecy.getCellphone());
            basicInfo.setInviterType(Const.INVITER_TYPE.PURCHASER);
            basicInfo.setInviterId(handleAgnecy.getOperatorId());
            basicInfo.setInviterCompanyId((int) handleAgnecy.getCompanyId());
            basicInfo.setState(Const.STATE.COMMITTED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            basicInfo.setCreateAt(new Date());
            basicInfo.setUpdateAt(new Date());

            TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
            detailInfo.setCompanyName(handleAgnecy.getCompanyName());
            detailInfo.setUniformCreditCode(handleAgnecy.getUniformCreditCode());
            detailInfo.setPublicBankName(handleAgnecy.getPublicBankName());
            detailInfo.setPublicBanAccountNumber(handleAgnecy.getPublicBankCount());
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());


            //私库添加基本name和cellphone
            TPurchaserAgency agency = new TPurchaserAgency();
            agency.setCellphone(handleAgnecy.getCellphone());
            agency.setState(Const.STATE.COMMITTED);
            agency.setSupplierName(handleAgnecy.getCompanyName());
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
                agency.setSupplierId(agencyId);
                //id设置进入t_agency_detail
                detailInfo.setAgencyId(agencyId);
                tAgencyDetailInfoMapper.insertSelective(detailInfo);
                tPurchaserAgencyMapper.insertSelective(agency);
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
    public Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType) {
        //先查询是否存在,不存在添加私库
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andNameEqualTo(handleOperator.getName());
        criteria.andCellphoneEqualTo(handleOperator.getCellPhone());
        List<TPurchaserBasicInfo> list = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);

        if (!CollectionUtils.isEmpty(list)) {
            return Result.error("员工:" + handleOperator.getName() + "已存在");
        }
        TPurchaserBasicInfo pojo = new TPurchaserBasicInfo();
        Date date = new Date();
        pojo.setName(handleOperator.getName());
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        pojo.setRole(roleType);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
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
            LOGGER.error("完善供应商信息失败");
            return Result.error(e.getMessage());
        }
        //获得返回的id,作为supplier_id
        Long supplierId = basicInfo.getId();
        basicInfo.setSupplierId(supplierId);

        //id更新进入t_purchaser_supplier的数据库
        TPurchaserSupplierCriteria supplierCriteria = new TPurchaserSupplierCriteria();
        TPurchaserSupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        List<TPurchaserSupplier> suppliers = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        if (CollectionUtils.isEmpty(suppliers)) {
            return Result.error("没有此供应商信息");
        }
        TPurchaserSupplier supplier = suppliers.get(0);
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
            List<Attachement> atts = dto.getAtts();
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
            LOGGER.error("完善供货商信息失败", e);
            return Result.error(e.getMessage());
        }
        return Result.success("更新成功", true);
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
        TPurchaserAgencyCriteria agencyCriteria = new TPurchaserAgencyCriteria();
        TPurchaserAgencyCriteria.Criteria criteria = agencyCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        List<TPurchaserAgency> agencies = tPurchaserAgencyMapper.selectByExample(agencyCriteria);
        if (CollectionUtils.isEmpty(agencies)) {
            return Result.error("没有该代理机构的注册信息");
        }
        TPurchaserAgency agency = agencies.get(0);
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
            LOGGER.error("完善代理机构信息失败", e);
            return Result.error("完善代理机构信息失败");
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
            List<Attachement> atts = dto.getAtts();
            if (!CollectionUtils.isEmpty(atts)) {
                for (Attachement att : atts) {
                    TAgencyAttachment attachment = new TAgencyAttachment();
                    BeanUtils.copyProperties(att, attachment);
                    attachment.setAgencyId(agencyId);
                    tAgencyAttachmentMapper.insertSelective(attachment);
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
        String cellphone = purchaser.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(purchaser.getPassword());
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(pwd);
        List<TPurchaserBasicInfo> tPurchaserBasicInfos = tPurchaserBasicInfoMapper.selectByExample(infoCriteria);
        if (!CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
            return Result.error(ErrorMessagesEnum.LOGINNAME_NUMBER_EXIST);
        }
        basicInfo.setCellphone(cellphone);
        basicInfo.setPassword(pwd);
        basicInfo.setCreateAt(new Date());
        Result result = new Result();
        int sucess = 0;
        try {
            sucess = tPurchaserBasicInfoMapper.insertSelective(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("采购人注册失败", e);
            return Result.error(e.getMessage());
        }
        Long id = basicInfo.getId();
        if (sucess > 0) {
            //数据库生成的id放入对象传入下个页面
            purchaser.setPurchaseId(id);
            result.setData(purchaser);
            result.setMsg("注册成功");
            return result;
        }
        return Result.error("注册成功");
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
    public Result<PurchaserEmplyeeVo> queryEmployee(Long id) {
        //依据id查询所有的对应的信息t_purchaser_basic_info
        TPurchaserBasicInfoCriteria infoCriteria = new TPurchaserBasicInfoCriteria();
        TPurchaserBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        TPurchaserBasicInfo tPurchaserBasicInfo = tPurchaserBasicInfoMapper.selectByPrimaryKey(id);
        if (tPurchaserBasicInfo == null) {
            return Result.error("没有此id的员工");
        }
        //获得自己机构的id
        Long purchaseId = tPurchaserBasicInfo.getPurchaserId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TPurchaserDetailInfoCriteria detailCriteria = new TPurchaserDetailInfoCriteria();
        TPurchaserDetailInfoCriteria.Criteria criteria2 = detailCriteria.createCriteria();
        criteria2.andPurchaserIdEqualTo(purchaseId);
        List<TPurchaserDetailInfo> tPurchaserDetails = tPurchaserDetailInfoMapper.selectByExample(detailCriteria);
        if (CollectionUtils.isEmpty(tPurchaserDetails)) {
            return Result.error("查询失败");
        }
        TPurchaserDetailInfo tPurchaserDetail = tPurchaserDetails.get(0);
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
        if (CollectionUtils.isEmpty(tPurchaserBasicInfos)) {
            return Result.error("没有符合此条件的员工");
        }
        //获得自己机构的id
        Long purchaseId = employeeDto.getPurchaseId();
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


        if (list.isEmpty()) {
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
        List<TPurchaserSupplier> basicInfos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        if (CollectionUtils.isEmpty(supplierVos) || CollectionUtils.isEmpty(basicInfos)) {
            return Result.error("供应商不存在或信息不完全");
        }
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
        if (!CollectionUtils.isEmpty(attachments)) {
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
        }
        return Result.success("查询成功", vos);
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
        if (CollectionUtils.isEmpty(supplierVos)) {
            return Result.error("没有供货商存在");
        }
        //封装附件查询的条件list,得到该采购人下所有供货商的id
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
        if (CollectionUtils.isEmpty(infoList)) {
            return Result.error("供应商不存在或信息不完全");
        }
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
        return Result.success("查询成功", list);
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
        List<TPurchaserSupplier> basicInfos = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        if (CollectionUtils.isEmpty(supplierVos) || CollectionUtils.isEmpty(basicInfos)) {
            return Result.error("没有符合要求的供货商");
        }
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
        if (!CollectionUtils.isEmpty(attachments)) {
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
        }
        return Result.success("查询成功", vos);
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

        List<TPurchaserSupplier> purchaserSuppliers = tPurchaserSupplierMapper.selectByExample(supplierCriteria);
        List<TSupplierDetailInfo> detailInfos = tSupplierDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (CollectionUtils.isEmpty(purchaserSuppliers) || CollectionUtils.isEmpty(detailInfos)) {
            return Result.error("没有此供货商信息");
        }
        TPurchaserSupplier supplier = purchaserSuppliers.get(0);
        TSupplierDetailInfo detailInfo = detailInfos.get(0);
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

    /**
     * @author :winlin
     * @Description :修改供应商信息,需要供货商id
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateSuppliers(HandleSupplierDto dto) {
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
        basicInfo.setUpdateAt(new Date());

        TPurchaserSupplier supplier = new TPurchaserSupplier();
        supplier.setCellphone(dto.getCellphone());
        supplier.setSupplierName(dto.getCompanyName());
        supplier.setUpdateAt(new Date());

        TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
        detailInfo.setCompanyName(dto.getCompanyName());
        detailInfo.setUniformCreditCode(dto.getUniformCreditCode());
        detailInfo.setPublicBankName(dto.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(dto.getPublicBankCount());
        detailInfo.setUpdateAt(new Date());
        try {
            tSupplierBasicInfoMapper.updateByExample(basicInfo, tSupplierBasicInfoCriteria);
            tPurchaserSupplierMapper.updateByExample(supplier, supplierCriteria);
            tSupplierDetailInfoMapper.updateByExample(detailInfo, tSupplierDetailInfoCriteria);
            List<Attachement> list = dto.getAtts();
            if (!CollectionUtils.isEmpty(list)) {
                for (Attachement attachement : dto.getAtts()) {
                    TSupplierAttachment att = new TSupplierAttachment();
                    BeanUtils.copyProperties(attachement, att);
                    att.setSupplierId(supplierId);
                    tSupplierAttachmentMapper.updateByExample(att, tSupplierAttachmentCriteria);
                }
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改供货商信息失败", e);
            return Result.error("修改供货商信息失败");
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
        if (CollectionUtils.isEmpty(expertList) || CollectionUtils.isEmpty(infoList)) {
            return Result.error("没有符合条件的专家");
        }
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
        List<TPurchaserAgency> basicInfos = tPurchaserAgencyMapper.selectByExample(agencyCriteria);
        if (CollectionUtils.isEmpty(agencyVos) || CollectionUtils.isEmpty(basicInfos)) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
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
        if (!CollectionUtils.isEmpty(attachments)) {
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
        }
        return Result.success("查询成功", vos);
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
        List<TPurchaserExpert> tPurchaserExperts = tPurchaserExpertMapper.selectByExample(expertCriteria);
        if (CollectionUtils.isEmpty(tPurchaserExperts)) {
            return Result.error("没有此手机号" + dto.getCellphone() + "的专家");
        }
        TPurchaserExpert expert = tPurchaserExperts.get(0);
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
            List<Attachement> list = dto.getAtts();
            if(!CollectionUtils.isEmpty(list)) {
                for (Attachement attachement : dto.getAtts()) {
                    TAgencyAttachment att = new TAgencyAttachment();
                    BeanUtils.copyProperties(attachement, att);
                    att.setAgencyId(agencyId);
                    tAgencyAttachmentMapper.updateByExample(att, tExpertAttachmentCriteria);
                }
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改代理机构信息失败");
            return Result.error(e.getMessage());
        }
        return Result.success("更新成功", true);
    }

    /**
     * @author :winlin
     * @description :修改采购人专家的信息,前端页面附带专家唯一的id
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
            List<Attachement> list = dto.getAtts();
            if(!CollectionUtils.isEmpty(list)) {
                for (Attachement attachement : list) {
                    TExpertAttachment att = new TExpertAttachment();
                    BeanUtils.copyProperties(attachement, att);
                    att.setExpertId(expertId);
                    tExpertAttachmentMapper.updateByExample(att, tExpertAttachmentCriteria);
                }
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改专家信息失败",e);
            return Result.error(e.getMessage());
        }

        return Result.success("更新成功", true);
    }

    @Override
    public Result<Boolean> updateTrustListForSupplier(HandleTrustList trustList) {
        try{
            tPurchaserSupplierMapper.updateTrustList(trustList);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改状态失败",e);
            return Result.error("修改状态失败");
        }
        return Result.success("修改状态成功");
    }

    @Override
    public Result<Boolean> updateTrustListForAgency(HandleTrustList trustList) {
        try{
            tPurchaserAgencyMapper.updateTrustList(trustList);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改状态失败",e);
            return Result.error("修改状态失败");
        }
        return Result.success("修改状态成功");
    }


}