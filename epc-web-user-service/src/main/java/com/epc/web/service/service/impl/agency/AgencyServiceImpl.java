package com.epc.web.service.service.impl.agency;

import com.epc.web.facade.agency.dto.*;
import com.epc.web.facade.purchaser.dto.QueryDto;
import com.epc.web.facade.purchaser.vo.PurchaserEmplyeeVo;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserDetailInfo;
import com.google.common.collect.Lists;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.agency.handle.*;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertDetailVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.facade.purchaser.handle.HandleTrustList;
import com.epc.web.service.domain.agency.*;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.agency.TAgencySupplierMapper;
import com.epc.web.service.mapper.expert.TAgencyExpertMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.agency.AgencyService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :winlin
 * @description: 代理机构接口实现层
 * @date ate:2018/9/13
 */
@Service
public class AgencyServiceImpl implements AgencyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyServiceImpl.class);

    @Autowired
    TAgencyBasicInfoMapper tAgencyBasicInfoMapper;

    @Autowired
    TAgencyDetailInfoMapper tAgencyDetailInfoMapper;

    @Autowired
    TAgencyExpertMapper tAgencyExpertMapper;

    @Autowired
    TAgencySupplierMapper tAgencySupplierMapper;

    @Autowired
    TExpertBasicInfoMapper tExpertBasicInfoMapper;

    @Autowired
    TSupplierBasicInfoMapper tSupplierBasicInfoMapper;

    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;

    @Autowired
    TAgencyAttachmentMapper tAgencyAttachmentMapper;

    @Autowired
    TSupplierAttachmentMapper tSupplierAttachmentMapper;

    @Autowired
    TExpertAttachmentMapper tExpertAttachmentMapper;


    /**
     * @Author :winlin
     * @Description :新增员工的基本信息,新增再表t_agency_basic_info表中
     * 页面传入信息有name,cellphone,password,agencyId,role,isdelete为db默认为0
     * 其他字段需要生成,password需要加密Md5,内部员工状态为3,所属角色为页面传入
     * @Date:2018/9/13
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> insertEmployee(HandleEmployee handleEmployee) {
        //根据name和cellPhone查询
        String name = handleEmployee.getName();
        String cellphone = handleEmployee.getCellphone();
        TAgencyBasicInfo basicInfo = null;
        try {
            basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);
            if (basicInfo != null) {
                return Result.error("员工" + handleEmployee.getName() + "已经存在，重复添加错误！");
            }
        } catch (Exception e) {
            LOGGER.error("员工信息查询:{}", e);
            return Result.error("员工信息新增失败");
        }
        //创建数据库插入对象
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        //复制对象数据到数据库对象中
        tAgencyBasicInfo.setName(handleEmployee.getName());
        tAgencyBasicInfo.setAgencyId(handleEmployee.getAgencyId());
        tAgencyBasicInfo.setCellphone(handleEmployee.getCellphone());
        tAgencyBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handleEmployee.getPassword()));
        tAgencyBasicInfo.setInviterType(Const.INVITER_TYPE.PROXY);
        tAgencyBasicInfo.setInviterId(handleEmployee.getAgencyId());
        tAgencyBasicInfo.setInviterCompanyId(handleEmployee.getAgencyId().intValue());
        tAgencyBasicInfo.setState(Const.STATE.AUDIT_SUCCESS);
        tAgencyBasicInfo.setPassword(Const.DEFAULT_PASSWORD.PASSWORD);
        tAgencyBasicInfo.setRole(handleEmployee.getRole());
        tAgencyBasicInfo.setCreateAt(new Date());
        tAgencyBasicInfo.setUpdateAt(new Date());
        tAgencyBasicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
        tAgencyBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        int sucess = 0;
        try {
            //调用Mapper存入数据库
            sucess = tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("添加员工失败", e);
            return Result.error(e.getMessage());
        }
        //返回页面信息
        return sucess > 0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * @author :winlin
     * @Description :员工启用或禁用
     * @date:2018/9/30
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> enableOrDisableAgencyEmployee(HandleTrustList trustList) {
        Integer forbidden = trustList.getEnableOrDisable();
        Long id = trustList.getId();
        if (forbidden == null || id == null) {
            return Result.error("修改员工失败");
        }
        try {
            tAgencyBasicInfoMapper.updateAgencyForbbiden(id, forbidden);
        } catch (Exception e) {
            LOGGER.error("enableOrDisableAgencyEmployee修改员工状态失败", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "修改员工失败");
        }
        return Result.success("修改员工状态成功", true);
    }

    /**
     * @Author :winlin
     * @Description :新增专家信息
     * @Date:2018/9/13
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Result<Boolean> insertExpert(HandleExpert handleExpert) {
        //依旧专家提供的信息来查询是否在公库中有此专家的信息
        String expertName = handleExpert.getName();
        String cellphone = handleExpert.getCellphone();
        //返回此专家
        TExpertBasicInfo info = null;
        try {
            info = tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(expertName, cellphone);
        } catch (Exception e) {
            LOGGER.error("新增专家信息Exception:{}", e);
            return Result.error("专家新增失败");
        }
        //专家存在判断状态
        if (null != info) {
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "专家已经存在无法重复添加");
        } else {
            //专家不存在,在公库中添加详细的信息
            TExpertBasicInfo expertBasicInfo = new TExpertBasicInfo();
            expertBasicInfo.setName(handleExpert.getName());
            expertBasicInfo.setCellphone(handleExpert.getCellphone());
            expertBasicInfo.setProfession(handleExpert.getProfession());
            expertBasicInfo.setPositional(handleExpert.getPositional());
            expertBasicInfo.setLevel(handleExpert.getLevel());
            expertBasicInfo.setIsIdle(Const.IS_IDLE_OR_NOT.IS_IDLE);
            expertBasicInfo.setCircularDt(new Date());
            expertBasicInfo.setCircularMethod(handleExpert.getCircularMethod());
            expertBasicInfo.setOtherInformation(handleExpert.getOtherInformation());
            expertBasicInfo.setInviterType(Const.INVITER_TYPE.PROXY);
            expertBasicInfo.setInviterId(handleExpert.getInviterid());
            expertBasicInfo.setInviterCompanyId(Integer.parseInt(handleExpert.getInvterCompanyId()));
            expertBasicInfo.setState(Const.STATE.COMMITTED);
            expertBasicInfo.setPassword(Const.DEFAULT_PASSWORD.PASSWORD);
            expertBasicInfo.setCreateAt(new Date());
            expertBasicInfo.setUpdateAt(new Date());
            expertBasicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            expertBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            //添加附件信息
            List<Attachement> list = handleExpert.getAtts();
            //公库信息设置
            try {
                //添加信息到公库
                tExpertBasicInfoMapper.insertSelective(expertBasicInfo);
                Long expertId = expertBasicInfo.getId();
                //附件信息入库
                if (!CollectionUtils.isEmpty(list) && expertId != null) {
                    for (Attachement att : list) {
                        TExpertAttachment attachment = new TExpertAttachment();
                        BeanUtils.copyProperties(att, attachment);
                        attachment.setExpertId(expertId);
                        attachment.setCreateAt(new Date());
                        attachment.setUpdateAt(new Date());
                        tExpertAttachmentMapper.insertSelective(attachment);
                    }
                }
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("新增专家信息失败Exception:{}", e);
                return Result.error("新增专家信息失败");
            }
        }
        return Result.success("新增专家成功");
    }

    /**
     * @Author :winlin
     * @Description :新增供应商信息t_agency_supplier和t_suppiler_basic_info和t_supplier_detail_info添加信息
     * 1.代理商根据获得的信息完善三张表,信息完善直接提交平台审核,审核通过后代理商私库能看到所有供应商信息
     * 2.信息不完善,供货商登录页完善,提交平台审核
     * 3.跟新状态又数据库负责
     * 4.步骤
     * 1.根据供货商的手机号,姓名查询信息,
     * 2.有这个供货商依据状态来决定是否跟新数据私库
     * 3.没有依据1.2.3跟新状态
     * HnandleSupplier需要的字段
     * name cellphone,password
     * @Date:2018/9/13
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Result<Integer> insertSupplier(HandleSupplier handleSupplier) {
        String name = handleSupplier.getName();
        String cellphone = handleSupplier.getCellphone();
        TSupplierBasicInfo basicInfo = null;
        try {
            basicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByNameAndCell(name, cellphone);
        } catch (Exception e) {
            LOGGER.error("新增供货商信息失败Exception:{}", e);
            return Result.error("新增供货商信息失败");
        }
        //判断状态
        if (basicInfo != null) {
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "该供应商信息已存在");
        } else {
            //基本信息封装
            basicInfo = new TSupplierBasicInfo();
            basicInfo.setName(handleSupplier.getName());
            basicInfo.setCellphone(handleSupplier.getCellphone());
            basicInfo.setInviterType(Const.INVITER_TYPE.PROXY);
            basicInfo.setInviterId(handleSupplier.getInviterId());
            basicInfo.setInviterCompanyId(handleSupplier.getInviterCompanyId());
            basicInfo.setState(Const.STATE.COMMITTED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            //默认密码
            basicInfo.setPassword(Const.DEFAULT_PASSWORD.PASSWORD);
            basicInfo.setCreateAt(new Date());
            basicInfo.setUpdateAt(new Date());
            basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
            //详细信息封装
            TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
            detailInfo.setCompanyName(handleSupplier.getCompanyName());
            detailInfo.setUniformCreditCode(handleSupplier.getUniformCreditCode());
            detailInfo.setPublicBankName(handleSupplier.getPublicBankName());
            detailInfo.setPublicBanAccountNumber(handleSupplier.getPublicBanAccountNumber());
            detailInfo.setCreateAt(new Date());
            detailInfo.setUpdateAt(new Date());
            detailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

            //附件信息
            List<Attachement> list = handleSupplier.getAtts();
            //供货商id
            Long supplierId = basicInfo.getId();
            try {
                tSupplierBasicInfoMapper.insertSelective(basicInfo);
                //得到生成的id更新表单数据
                basicInfo.setSupplierId(supplierId);
                tSupplierBasicInfoMapper.updateByPrimaryKey(basicInfo);
                detailInfo.setSupplierId(basicInfo.getId());
                tSupplierDetailInfoMapper.insertSelective(detailInfo);
                if (!CollectionUtils.isEmpty(list)) {
                    for (Attachement att : list) {
                        TSupplierAttachment attachment = new TSupplierAttachment();
                        BeanUtils.copyProperties(att, attachment);
                        attachment.setSupplierId(supplierId);
                        tSupplierAttachmentMapper.insertSelective(attachment);
                    }
                }

            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                LOGGER.error("新增供货商失败", e);
                return Result.error(e.getCause().getMessage());
            }
        }
        return Result.success("添加成功");
    }

    /**
     * @author :winlin
     * @Description :页面信息验证通过后传入存入 代理机构注册
     * @param:
     * @return: 返回 agency信息给信息完善页面使用
     * @date:2018/9/18
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transactional(rollbackFor = {Exception.class})
    public Result<HandleAgency> regesityAgency(HandleAgency agency) {
        //二次验证
        String cellphone = agency.getCellphone();
        String pwd = MD5Util.MD5EncodeUtf8(agency.getPassword());
        TAgencyBasicInfoCriteria basicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(pwd);
        List<TAgencyBasicInfo> basicInfos = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria);
        if (!CollectionUtils.isEmpty(basicInfos)) {
            return Result.error(ErrorMessagesEnum.LOGINNAME_NUMBER_EXIST.getErrCode(), "代理机构已经注册");
        }
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        //或的基本信息密码加密密码加密
        basicInfo.setCellphone(cellphone);
        basicInfo.setPassword(pwd);
        Result result = new Result();
        try {
            int sucess = tAgencyBasicInfoMapper.insertSelective(basicInfo);
            Long agencyId = basicInfo.getId();
            basicInfo.setAgencyId(agencyId);
            tAgencyBasicInfoMapper.updateByPrimaryKey(basicInfo);
            if (sucess > 0) {
                //数据库生成的id放入对象传入下个页面
                agency.setAgencyId(basicInfo.getId());
                result.setData(agency);
                result.setMsg("注册成功");
                return result;
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            LOGGER.error("代理机构注册失败", e);
            return Result.error(e.getMessage());
        }
        return Result.error(ErrorMessagesEnum.INSERT_FAILURE.getErrCode(), "代理机构注册失败");
    }

    /**
     * @author :winlin
     * @Description :依据综合条件查询代理商
     * @param:
     * @return:
     * @date:2018/9/20
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<HandleAgency>> queryAgencies(HandleAgency agency) {

        //从前端取出来的值封装到查询条件中
        TAgencyBasicInfoCriteria agencyBasicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyAttachmentCriteria agencyAttachmentCriteria = new TAgencyAttachmentCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = agencyBasicInfoCriteria.createCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        TAgencyAttachmentCriteria.Criteria criteria2 = agencyAttachmentCriteria.createCriteria();

        criteria.andCellphoneLike(agency.getCellphone());
        criteria.andNameLike(agency.getName());
        criteria.andRoleEqualTo(0);

        criteria1.andCompanyNameLike(agency.getCompanyName());
        criteria1.andUniformCreditCodeLike(agency.getUniformCreditCode());
        criteria1.andPublicBanAccountNumberLike(agency.getPublicBanAccountNumber());
        criteria1.andPublicBankNameLike(agency.getPublicBankName());

        List<String> list = new ArrayList<String>();
        for (Attachement attachement : agency.getAtts()) {
            String certificateName = attachement.getCertificateName();
            list.add(certificateName);
        }
        criteria2.andCertificateNameIn(list);

        //返回得到的信息
        List<TAgencyBasicInfo> tAgencyBasicInfos = new ArrayList<>();
        List<TAgencyDetailInfo> tAgencyDetailInfos = new ArrayList<>();
        List<TAgencyAttachment> tAgencyAttachments = new ArrayList<>();
        tAgencyAttachments = tAgencyAttachmentMapper.selectByExample(agencyAttachmentCriteria);
        tAgencyBasicInfos = tAgencyBasicInfoMapper.selectByExample(agencyBasicInfoCriteria);
        tAgencyDetailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (CollectionUtils.isEmpty(tAgencyBasicInfos)) {
            return Result.error("没有符合此条件的机构");
        }
        //封装信息返回数据
        List<HandleAgency> agencyList = new ArrayList<>();
        for (TAgencyBasicInfo basicInfo : tAgencyBasicInfos) {
            HandleAgency agency1 = new HandleAgency();
            Long agencyId = basicInfo.getAgencyId();
            if (!CollectionUtils.isEmpty(tAgencyDetailInfos) && agencyId != null) {
                for (TAgencyDetailInfo detailInfo : tAgencyDetailInfos) {
                    Long agencyId1 = detailInfo.getAgencyId();
                    if (agencyId.equals(agencyId1)) {
                        agency1.setAgencyId(agencyId);
                        agency1.setCellphone(basicInfo.getCellphone());
                        agency1.setName(basicInfo.getName());
                        agency1.setCompanyName(detailInfo.getCompanyName());
                        agency1.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
                        agency1.setPublicBankName(detailInfo.getPublicBankName());
                        agency1.setUniformCreditCode(detailInfo.getUniformCreditCode());
                        agencyList.add(agency1);
                    }
                }
            }
        }
        for (HandleAgency handleAgency : agencyList) {
            List<Attachement> attachements = new ArrayList<>();
            Long agencyId2 = handleAgency.getAgencyId();
            if (!CollectionUtils.isEmpty(tAgencyAttachments) && agencyId2 != null) {
                for (TAgencyAttachment attachment : tAgencyAttachments) {
                    Long agencyId3 = attachment.getAgencyId();
                    Attachement attachement = new Attachement();
                    if (agencyId2.equals(agencyId3)) {
                        BeanUtils.copyProperties(attachment, attachement);
                        attachement.setTypeId(agencyId3.toString());
                        attachements.add(attachement);
                    }
                }
            }
            handleAgency.setAtts(attachements);
        }

        return Result.success("查新成功", agencyList);
    }


    /**
     * @author :winlin
     * @Description :前端信息验证完成,跟新信息即可
     * @param:
     * @return:
     * @date:2018/9/18
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> modifypassword(HandleAgency agency) {
        if (agency == null) {
            return Result.error("修改失败");
        }
        //封装跟新信息
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        tAgencyBasicInfo.setCellphone(agency.getCellphone());
        tAgencyBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(agency.getPassword()));
        //跟新数据库
        TAgencyBasicInfoCriteria criteria = new TAgencyBasicInfoCriteria();
        criteria.createCriteria().andCellphoneEqualTo(agency.getCellphone());
        try {
            tAgencyBasicInfoMapper.updateByExampleSelective(tAgencyBasicInfo, criteria);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        return Result.success("修改成功");
    }

    /**
     * @author :winlin
     * @Description :页面信传入后存入数据库,第一次注册后端生成唯一id,所有信息必须完善不允许为空
     * @param:
     * @return:返回完善状态
     * @date:2018/9/18
     */

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Result<Boolean> completeInfo(HandleAgency agency) {
        String name = agency.getName();
        String cellphone = agency.getCellphone();
        TAgencyBasicInfo basicInfo = null;
        try {
            basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);

            if (basicInfo == null) {
                return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "没有代理机构的注册信息");
            }
        } catch (Exception e) {
            LOGGER.error("代理机构完善信息失败Exception:{}", e);
            return Result.error("代理机构完善信息失败");
        }
        //获得purchaser的id
        Long agencyId = basicInfo.getId();
        //设置更新时间
        Date date = new Date();
        //补全信息
        basicInfo.setAgencyId(agencyId);
        basicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        basicInfo.setInviterId(Long.parseLong(Const.INVITER_TYPE.PLATFORM_ID + ""));
        basicInfo.setInviterCompanyId(Const.INVITER_TYPE.PLATFORM_ID);
        basicInfo.setIsForbidden(Const.ENABLE_OR_DISABLE.ENABLE);
        basicInfo.setState(Const.STATE.COMMITTED);
        basicInfo.setRole(Const.Role.ROLE_CORPORATION);
        basicInfo.setCreateAt(date);
        basicInfo.setUpdateAt(date);
        basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        //分装添加的条件
        TAgencyDetailInfo detailInfo = new TAgencyDetailInfo();
        detailInfo.setAgencyId(agencyId);
        detailInfo.setCompanyName(agency.getCompanyName());
        detailInfo.setUniformCreditCode(agency.getUniformCreditCode());
        detailInfo.setPublicBankName(agency.getPublicBankName());
        detailInfo.setPublicBanAccountNumber(agency.getPublicBanAccountNumber());
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);
        basicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        //附件信息
        List<Attachement> list = agency.getAtts();
        try {
            tAgencyBasicInfoMapper.updateByPrimaryKeySelective(basicInfo);
            tAgencyDetailInfoMapper.insertSelective(detailInfo);
            if (!CollectionUtils.isEmpty(list)) {
                for (Attachement att : list) {
                    TAgencyAttachment at = new TAgencyAttachment();
                    BeanUtils.copyProperties(att, at);
                    at.setAgencyId(agencyId);
                    at.setCreateAt(date);
                    at.setUpdateAt(date);
                    tAgencyAttachmentMapper.insertSelective(at);
                }
            }

        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善代理信息失败", e);
            return Result.error("完善代理信息失败");
        }

        return Result.success("代理机构信息完善成功", true);

    }


    /**
     * 查询该机构下所有的员工
     * 不查询的字段不返回,password
     *
     * @return
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Override
    public Result<List<AgencyEmployeeVo>> queryAllEmployee(Long agencyId) {
        //封装查询条件,查询该id下的所有信息
        TAgencyBasicInfoCriteria basicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);
        //返回对应公司的信息
        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andAgencyIdEqualTo(agencyId);
        //返回信息
        List<TAgencyBasicInfo> basicInfos = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria);
        //返回公司的详细信息,依据agencyId查询,返回信息只有一条
        List<TAgencyDetailInfo> detailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (CollectionUtils.isEmpty(basicInfos) || CollectionUtils.isEmpty(detailInfos)) {
            return Result.error("查询失败");
        }
        TAgencyDetailInfo detailInfo = detailInfos.get(0);
        //封装信息
        List<AgencyEmployeeVo> employees = new ArrayList<>();
        //找到老板的名字
        String bossName = "";
        for (TAgencyBasicInfo basicInfo : basicInfos) {
            if (basicInfo.getRole().equals(0)) {
                bossName = basicInfo.getName();
            }
        }
        for (TAgencyBasicInfo basicInfo : basicInfos) {
            AgencyEmployeeVo vo = new AgencyEmployeeVo();
            vo.setUserId(basicInfo.getId().toString());
            vo.setUserName(basicInfo.getName());
            vo.setCellphone(basicInfo.getCellphone());
            vo.setCompanyId(basicInfo.getAgencyId().toString());
            vo.setCompanyName(detailInfo.getCompanyName());
            vo.setBossName(bossName);
            employees.add(vo);
        }
        if (employees.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        return Result.success("查询成功", employees);
    }

    /**
     * 依据封装好的条件查询员工
     *
     * @param employee
     * @return
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<AgencyEmployeeVo>> queryEmployee(AgencyEmployeeDto employee) {
        //获得公司的id
        Long agencyId = employee.getAgencyId();
        //查找符合条件的员工
        List<TAgencyBasicInfo> basicInfos = null;
        //返回公司的详细信息,依据agencyId查询
        TAgencyDetailInfo detailInfo = null;
        try {
            basicInfos = tAgencyBasicInfoMapper.selectEmployee(employee);
            detailInfo = tAgencyDetailInfoMapper.selectByPrimaryKey(agencyId);
        } catch (Exception e) {
            LOGGER.error("员工信息查询失败Exception:{}", e);
            return Result.error("员工信息查询失败");
        }
        //员工由管理员和法人添加必须有detail信息
        if (CollectionUtils.isEmpty(basicInfos) || detailInfo == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(), "查询员工信息失败");
        }
        //获得代理机构法人的id
        Long bossId = detailInfo.getAgencyId();
        TAgencyBasicInfo boss = tAgencyBasicInfoMapper.selectByPrimaryKey(bossId);
        //封装信息
        List<AgencyEmployeeVo> employees = new ArrayList<>();
        //找到老板的名字
        String bossName = boss.getName();
        for (TAgencyBasicInfo basicInfo : basicInfos) {
            AgencyEmployeeVo vo = new AgencyEmployeeVo();
            vo.setUserId(basicInfo.getId().toString());
            vo.setUserName(basicInfo.getName());
            vo.setCellphone(basicInfo.getCellphone());
            vo.setCompanyId(basicInfo.getAgencyId().toString());
            vo.setCompanyName(detailInfo.getCompanyName());
            vo.setBossName(bossName);
            employees.add(vo);
        }
        return Result.success("查询成功", employees);
    }

    /**
     * 依据手机号查询员工
     *
     * @param cellphone
     * @return
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<AgencyEmployeeVo> queryEmployeeByCellphone(String cellphone) {
        //封装查询条件,查询该id下的所有信息
        TAgencyBasicInfoCriteria basicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        List<TAgencyBasicInfo> basicInfos = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria);
        if (CollectionUtils.isEmpty(basicInfos)) {
            return Result.error("没有手机号为:" + cellphone + "的员工");
        }
        //获得公司的id
        TAgencyBasicInfo basicInfo = basicInfos.get(0);
        Long agencyId = basicInfo.getAgencyId();

        //返回对应公司的信息
        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andAgencyIdEqualTo(agencyId);
        //返回公司的详细信息,依据agencyId查询,返回信息只有一条
        List<TAgencyDetailInfo> detailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        if (CollectionUtils.isEmpty(detailInfos)) {
            return Result.error("没有手机号为:" + cellphone + "的员工");
        }
        TAgencyDetailInfo detailInfo = detailInfos.get(0);
        //找到老板的名字
        TAgencyBasicInfoCriteria basicInfoCriteria1 = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria2 = basicInfoCriteria.createCriteria();
        criteria2.andAgencyIdEqualTo(agencyId);
        criteria2.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        List<TAgencyBasicInfo> bosses = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria1);
        String bossName = "";
        if (!CollectionUtils.isEmpty(bosses)) {
            bossName = bosses.get(0).getName();
        }
        AgencyEmployeeVo vo = new AgencyEmployeeVo();
        vo.setUserId(basicInfo.getId().toString());
        vo.setUserName(basicInfo.getName());
        vo.setCellphone(basicInfo.getCellphone());
        vo.setCompanyId(basicInfo.getAgencyId().toString());
        vo.setCompanyName(detailInfo.getCompanyName());
        vo.setBossName(bossName);
        return Result.success("查询成功", vo);
    }

    /**
     * 依据id查询员工
     *
     * @param
     * @return
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result queryEmployeeById(QueryDto dto) {
        Long id = dto.getId();
        //依据id查询所有的对应的信息t_purchaser_basic_info
        TAgencyBasicInfo tPurchaserBasicInfo = tAgencyBasicInfoMapper.selectByPrimaryKey(id);
        if (tPurchaserBasicInfo == null) {
            return Result.error("没有此id的员工");
        }
        //获得自己机构的id
        Long agencyId = tPurchaserBasicInfo.getAgencyId();
        //依据id查询所有的对应的信息t_purchaser_detail_info
        TAgencyDetailInfo tPurchaserDetail = null;
        TAgencyBasicInfo boss = null;
        try {
            tPurchaserDetail = tAgencyDetailInfoMapper.selectAgencyDetailByAgencyId(agencyId);
            if (tPurchaserDetail == null) {
                return Result.success("没有此id的员工");
            }
            boss = tAgencyBasicInfoMapper.selectBossBasicInfoByPurchaserIdAndRole(agencyId, Const.Role.ROLE_CORPORATION);
        } catch (Exception e) {
            LOGGER.error("没有此id相关信息Exception:{}", e);
            return Result.success("没有相关员工的信息", true);
        }
        //获得老板name和公司name
        String companyName = tPurchaserDetail.getCompanyName();
        String bossName = boss.getName();
        String companyId = tPurchaserDetail.getId().toString();
        //拼装信息
        AgencyEmployeeVo vo = new AgencyEmployeeVo();
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
     * @Description : 依据id查询供货商
     * @param:
     * @return:
     * @date:2018/10/1
     */
    @Override
    public Result<AgencySupplierVo> queryAgencySupplierDetail(QueryDto dto) {
        Long supplierId = dto.getId();
        if (supplierId != null) {
            TSupplierBasicInfo basicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(supplierId);
            if (basicInfo != null) {
                TSupplierDetailInfo detailInfo = null;
                List<TSupplierAttachment> list = null;
                try {
                    detailInfo = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(supplierId);
                    list = tSupplierAttachmentMapper.selectAttachmentBySupplierId(supplierId);
                } catch (Exception e) {
                    LOGGER.error("查询供应商信息失败exception:{}", e);
                    return Result.error("查询供应商失败");
                }
                if (!CollectionUtils.isEmpty(list) && detailInfo != null) {
                    AgencySupplierVo vo = new AgencySupplierVo();
                    vo.setEmployeeName(basicInfo.getName());
                    vo.setCompanyName(detailInfo.getCompanyName());
                    vo.setCreateAt(detailInfo.getCreateAt());
                    vo.setUniformCreditCode(detailInfo.getUniformCreditCode());
                    vo.setPublicBankName(detailInfo.getPublicBankName());
                    vo.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber());
                    vo.setCellphone(basicInfo.getCellphone());
                    List<Attachement> attachments = new ArrayList<>();
                    for (TSupplierAttachment attachment : list) {
                        Attachement att = new Attachement();
                        BeanUtils.copyProperties(attachment, att);
                        att.setTypeId(attachment.getSupplierId() + "");
                        attachments.add(att);
                    }
                    vo.setAtts(attachments);
                    vo.setSupplierId(detailInfo.getSupplierId());
                    return Result.success("查询成功", vo);
                }
            }
            return Result.success("没有相关供应商信息");
        }
        return Result.success("没有相关供应商信息");
    }

    /**
     * @author :winlin
     * @Description :修改员工信息单表操作t_angency_basci_info
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    public Result<Boolean> updateEmployeeBy(HandleEmployee employee) {
        //依据传过来的信息查询员工name和电话查询
        String name = employee.getName();
        String cellphone = employee.getCellphone();
        TAgencyBasicInfo basicInfo = null;
        try {
            basicInfo = tAgencyBasicInfoMapper.selectAgencyBasicByCellphoneAndName(name, cellphone);
            if (basicInfo == null) {
                return Result.success("没有该员工的信息");
            }
        } catch (Exception e) {
            LOGGER.error("修改员工信息失败", e);
            return Result.error("修该信息失败");
        }
        //修改信息的注入
        basicInfo.setName(employee.getName());
        basicInfo.setCellphone(employee.getCellphone());
        basicInfo.setRole(employee.getRole());
        basicInfo.setUpdateAt(new Date());
        try {
            tAgencyBasicInfoMapper.updateAgencyEmployeeDetail(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("修改员工信息失败", e);
            return Result.error("修改员工信息失败");
        }

        return Result.success("修改成功", true);
    }

    /**
     * @author :winlin
     * @Description :修改员工角色
     * @param:
     * @return:
     * @date:2018/9/30
     */
    @Override
    public Result<Boolean> updateAgencyEmployeeRoleById(HandleTrustList trustList) {
        Integer role = trustList.getRole();
        Long id = trustList.getId();
        if (role == null || id == null) {
            return Result.error("修改员工角色失败");
        }
        try {
            tAgencyBasicInfoMapper.updateAgencyEmployeeRoleById(id, role);
        } catch (Exception e) {
            LOGGER.error("updateAgencyEmployeeRoleById修改员工角色失败", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "修改员工角色失败");
        }
        return Result.success("修改员工角色成功", true);
    }

    /**
     * @author :winlin
     * @Description :依据条件查询供应商,
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Override
    public Result<List<AgencySupplierVo>> querySupplierCriteria(SupplierDto supplierDto) {
        //封装查询条依据id和时间查询
        Long agencyId = supplierDto.getAgencyId();
        String fuzzyName = supplierDto.getCompanyName();
        Long supplierId = supplierDto.getSupplierId();
        //查询结果
        List<AgencySupplierVo> supplierVos = null;
        try {
            supplierVos= tSupplierBasicInfoMapper.selectBasicInfo(agencyId, fuzzyName, supplierId);
        }catch(Exception e){
            LOGGER.error("条件查询供货商Exception:{}",e);
        }
        if (CollectionUtils.isEmpty(supplierVos)) {
            return Result.error("没有符合条件的供货商");
        }

        return Result.success("查询成功", supplierVos);
    }

    /**
     * @author :winlin
     * @Description :依据条件查专家 条件可以升是专家name,专家专业 profession
     * 专家职称 positional 专家水平 level,和机构id,从业年限
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<AgencyExpertVo>> queryExpertCriteria(ExpertDto expertDto) {

        List<AgencyExpertVo> expertList = tExpertBasicInfoMapper.selectExpertByCriteria(expertDto);
        if (CollectionUtils.isEmpty(expertList)) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(), "没有符合条件的专家");
        }
        return Result.success("查询成功", expertList);
    }

    /**
     * 依据id查询专家
     *
     * @return
     */
    @Override
    public Result<AgencyExpertDetailVo> queryExpertDetailById(QueryDto dto) {
        Long expertId = dto.getId();
        if (expertId != null) {
            TExpertBasicInfo basicInfo = tExpertBasicInfoMapper.selectByPrimaryKey(expertId);
            if (basicInfo != null) {
                List<TExpertAttachment> list = tExpertAttachmentMapper.selectAttchamentByExpertId(expertId);
                if (!CollectionUtils.isEmpty(list)) {
                    AgencyExpertDetailVo vo = new AgencyExpertDetailVo();
                    vo.setName(basicInfo.getName());
                    vo.setCellphone(basicInfo.getCellphone());
                    vo.setProfession(basicInfo.getProfession());
                    vo.setPositional(basicInfo.getPositional());
                    vo.setLevel(basicInfo.getLevel());
                    vo.setOtherInformation(basicInfo.getOtherInformation());
                    List<Attachement> attachements = new ArrayList<>();
                    for (TExpertAttachment att : list) {
                        Attachement attt = new Attachement();
                        BeanUtils.copyProperties(att, attt);
                        attachements.add(attt);
                    }
                    vo.setAtts(attachements);
                    return Result.success("查询成功", vo);
                }
            }
        }
        return Result.error(ErrorMessagesEnum.SELECT_FAILURE.getErrCode(), "查询失败");
    }

    /**
     * @author :winlin
     * @Description :完善代理机构供货商信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> completeAgencySupInfo(AgencySupplierDto dto) {
        String name = dto.getName();
        String cellphone = dto.getCellphone();
        TSupplierBasicInfo basicInfo = tSupplierBasicInfoMapper.selectSupplierBasicByNameAndCell(name, cellphone);
        if (basicInfo == null) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "没有符合条件的供应商");
        }
        Long supplierId = basicInfo.getId();
        TSupplierDetailInfo detailInfo = tSupplierDetailInfoMapper.selectTSupplierDetailInfoBySupplierId(supplierId);
        try {
            if (detailInfo == null) {
                detailInfo = new TSupplierDetailInfo();
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
            //附件新增
            List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectAttachmentBySupplierId(supplierId);
            if (CollectionUtils.isEmpty(attachments)) {
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
            LOGGER.error("完善代理机构供货商信息失败", e);
            return Result.error("完善代理机构供货商信息失败");
        }
        return Result.success("完善代理机构供货商信息成功", true);
    }

    /**
     * @author :winlin
     * @Description :完善专家信息,添加时候基本表的信息添加完成,附件表可能没有添加
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> completeAgencyExpertInfo(AgencyExpertDto dto) {
        String expertName = dto.getExpertName();
        String cellPhone = dto.getCellphone();
        //查询注册信息
        TExpertBasicInfo info = tExpertBasicInfoMapper.selectExpertByNameAndCellPhone(expertName, cellPhone);
        if (info == null) {
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "没有该专家的注册信息");
        }
        List<Attachement> list = dto.getAtts();
        try {
            //封装附件信息对象
            if (!CollectionUtils.isEmpty(list)) {
                //获得id
                Long expertId = info.getId();
                for (Attachement att : list) {
                    TExpertAttachment attachment = new TExpertAttachment();
                    BeanUtils.copyProperties(att, attachment);
                    attachment.setExpertId(expertId);
                    attachment.setCreateAt(new Date());
                    attachment.setUpdateAt(new Date());
                    tExpertAttachmentMapper.insertSelective(attachment);
                }
            }
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善专家信息失败", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "完善专家信息失败");
        }

        return Result.success("完善专家信息成功", true);
    }

    /**
     * @author :winlin
     * @Description :删除专家 修改is_delete的字段属性
     * @param:
     * @return:
     * @date:2018/9/30
     */
    @Override
    public Result<Boolean> deleteAgencyExpertById(HandleTrustList trustList) {
        Integer delete = Const.IS_DELETED.IS_DELETED;
        Long id = trustList.getId();
        try {
            tAgencyBasicInfoMapper.deleteAgencyExpertById(id, delete);
        } catch (Exception e) {
            LOGGER.error("deleteAgencyExpertById删除专家失败", e);
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE.getErrCode(), "删除专家失败");
        }
        return Result.success("删除专家成功", true);
    }
}
