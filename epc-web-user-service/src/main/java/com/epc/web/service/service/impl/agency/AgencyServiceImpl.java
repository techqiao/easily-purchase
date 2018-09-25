package com.epc.web.service.service.impl.agency;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.agency.dto.AgencyExpertDto;
import com.epc.web.facade.agency.dto.AgencySubjectDto;
import com.epc.web.facade.agency.dto.AgencySupplierDto;
import com.epc.web.facade.agency.handle.*;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.facade.agency.vo.AgencyExpertVo;
import com.epc.web.facade.agency.vo.AgencySubjectsVo;
import com.epc.web.facade.agency.vo.AgencySupplierVo;
import com.epc.web.service.domain.agency.*;
import com.epc.web.service.domain.expert.*;
import com.epc.web.service.domain.expert.TAgencyExpertCriteria;
import com.epc.web.service.domain.supplier.*;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.util.resources.ga.LocaleNames_ga;

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
    public Result<Integer> insertEmployee(HandleEmployee handleEmployee) {
        //根据name和cellPhone查询
        TAgencyBasicInfoCriteria infoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = infoCriteria.createCriteria();
        criteria.andCellphoneEqualTo(handleEmployee.getCellphone());
        criteria.andNameEqualTo(handleEmployee.getName());
        List<TAgencyBasicInfo> list = tAgencyBasicInfoMapper.selectByExample(infoCriteria);
        if (list.size() > 0) {
            return Result.error("员工" + handleEmployee.getName() + "已经存在，重复添加错误！");
        }
        //设置状态为已审核
        handleEmployee.setState(Const.STATE.AUDIT_SUCCESS);
        //创建时间
        // handleEmployee.setCreateAt(new Date());
        //更新时间
        // handleEmployee.setUpdateAt(new Date());
        //创建数据库插入对象
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        //复制对象数据到数据库对象中
        BeanUtils.copyProperties(handleEmployee, tAgencyBasicInfo);
        int sucess = 0;
        try {
            //调用Mapper存入数据库
            sucess = tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        //返回页面信息
        return sucess > 0 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * @Author :winlin
     * @Description :新增专信息在t_agency_expert表中添加expert信息,在t_expert_basic_info
     * 先操作basic_info表,返回自动生成的id作为angency_expert的expert的专家ID
     * 添加信息供平台审核,新增专家页面需要传过来的信息
     * 1.专家本身就在平台内部通过 传入的信息查询,用专家state来决定
     * 2.专家完全新增,私库只添加姓名和手机号
     * 3.需要信息字段
     * name,cellphone,profession,positional,level,circular_dt,circular_method,password,inviterType,invite_id
     * agency_id,source
     * 4.先根据姓名和cellphone查询
     * @Date:2018/9/13
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Result<Integer> insertExpert(HandleExpert handleExpert) {

        //依旧专家提供的信息来查询是否在公库中有此专家的信息
        TExpertBasicInfoCriteria criteria = new TExpertBasicInfoCriteria();
        TExpertBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andCellphoneEqualTo(handleExpert.getCellphone());
        criteria1.andNameEqualTo(handleExpert.getName());

        //返回此专家
        List<TExpertBasicInfo> basicInfoList = tExpertBasicInfoMapper.selectByExample(criteria);

        //专家存在判断状态
        if (basicInfoList.size() > 0) {
            TExpertBasicInfo basicInfo = basicInfoList.get(0);
            int state = basicInfo.getState();
            //判断专家在私库中存不存在
            TAgencyExpertCriteria tAgencyExpertCriteria = new TAgencyExpertCriteria();
            TAgencyExpertCriteria.Criteria criteria2 = tAgencyExpertCriteria.createCriteria();
            criteria2.andCellphoneEqualTo(handleExpert.getCellphone());
            List<TAgencyExpert> tAgencyExperts = tAgencyExpertMapper.selectByExample(tAgencyExpertCriteria);
            if (tAgencyExperts.size() > 0) {
                return Result.error("专家:" + handleExpert.getName() + "已存在");
            } else {
                TAgencyExpert agencyExpert = new TAgencyExpert();
                agencyExpert.setCellphone(basicInfo.getCellphone() != null ? basicInfo.getCellphone() : null);
                agencyExpert.setExpertName(basicInfo.getName() != null ? basicInfo.getName() : null);
                agencyExpert.setAgencyId(handleExpert.getInviterid().toString() != null ? handleExpert.getInviterid().toString() : null);
                agencyExpert.setSource(handleExpert.getSource() != null ? handleExpert.getSource() : null);
                if (state == Const.STATE.AUDIT_SUCCESS) {
                    //设置相关的属性同步所有的信息
                    agencyExpert.setState(state);
                    agencyExpert.setExpertId(basicInfo.getId() != null ? basicInfo.getId() : null);
                    agencyExpert.setPassword(basicInfo.getPassword() != null ? basicInfo.getPassword() : null);
                    agencyExpert.setCreateAt(new Date());
                    agencyExpert.setUpdateAt(new Date());
                    try {
                        //专家信息同步进入私库
                        tAgencyExpertMapper.insertSelective(agencyExpert);
                    } catch (Exception e) {
                        //捕获异常回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        e.printStackTrace();
                    }
                } else {
                    try {
                        //专家信息同步进入私库
                        tAgencyExpertMapper.insertSelective(agencyExpert);
                    } catch (Exception e) {
                        //捕获异常回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        e.printStackTrace();
                    }
                }
            }

        } else {

            //专家不存在,在公库中添加详细的信息,私库中添加手机号名字
            TAgencyExpert agencyExpert = new TAgencyExpert();
            TExpertBasicInfo expertBasicInfo = new TExpertBasicInfo();

            //操作人的id和私库信息设置
            agencyExpert.setAgencyId(handleExpert.getInviterid().toString() != null ? handleExpert.getInviterid().toString() : null);
            agencyExpert.setCellphone(handleExpert.getCellphone() != null ? handleExpert.getCellphone() : null);
            agencyExpert.setExpertName(handleExpert.getName() != null ? handleExpert.getName() : null);
            agencyExpert.setSource(handleExpert.getSource() != null ? handleExpert.getSource() : null);


            //公库信息设置
            expertBasicInfo.setState(Const.STATE.COMMITTED);
            expertBasicInfo.setInviterType(handleExpert.getInvitertype() != null ? handleExpert.getInvitertype() : null);
            expertBasicInfo.setCellphone(handleExpert.getCellphone() != null ? handleExpert.getCellphone() : null);
            expertBasicInfo.setProfession(handleExpert.getProfession() != null ? handleExpert.getProfession() : null);
            expertBasicInfo.setPositional(handleExpert.getPositional() != null ? handleExpert.getPositional() : null);
            expertBasicInfo.setLevel(handleExpert.getLevel() != null ? handleExpert.getLevel() : null);
            expertBasicInfo.setCircularDt(handleExpert.getCircularDt() != null ? handleExpert.getCircularDt() : null);
            expertBasicInfo.setCircularMethod(handleExpert.getCircularMethod() != null ? handleExpert.getCircularMethod() : null);
            expertBasicInfo.setName(handleExpert.getName() != null ? handleExpert.getName() : null);
            expertBasicInfo.setInviterId(handleExpert.getInviterid() != null ? handleExpert.getInviterid() : null);
            expertBasicInfo.setInviterCompanyId(handleExpert.getInvterCompanyId() != null ? Integer.parseInt(handleExpert.getInvterCompanyId()) : null);

            expertBasicInfo.setCreateAt(new Date());
            expertBasicInfo.setUpdateAt(new Date());

            try {
                //专家信息同步进入私库
                int success = tAgencyExpertMapper.insertSelective(agencyExpert);
                //添加信息到公库
                int success2 = tExpertBasicInfoMapper.insertSelective(expertBasicInfo);

            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                e.printStackTrace();
            }
        }
        return Result.success("新增成功");
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

        //根据页面传入的信息查询依据手机号和姓名来查询
        TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria criteria1 = criteria.createCriteria();
        criteria1.andCellphoneEqualTo(handleSupplier.getCellphone());
        criteria1.andNameEqualTo(handleSupplier.getName());

        //返回该供应商信息
        List<TSupplierBasicInfo> list = tSupplierBasicInfoMapper.selectByExample(criteria);
        TSupplierBasicInfo basicInfo = list.size() > 0 ? list.get(0) : null;
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
                TSupplierDetailInfo detailInfo = list1.size() > 0 ? list1.get(0) : null;
                //设置私库存储对象
                //从页面传入
                TAgencySupplier agencySupplier = new TAgencySupplier();
                //从公库basicinfo中获得
                agencySupplier.setAgencyId(handleSupplier.getAgencyId() != null ? handleSupplier.getAgencyId() : null);
                agencySupplier.setCellphone(basicInfo.getCellphone() != null ? basicInfo.getCellphone() : null);
                agencySupplier.setPassword(basicInfo.getPassword() != null ? basicInfo.getPassword() : null);
                agencySupplier.setState(basicInfo.getState() != null ? basicInfo.getState() : null);
                agencySupplier.setSupplierId(basicInfo.getSupplierId() != null ? basicInfo.getSupplierId() : null);
                agencySupplier.setSupplierName(basicInfo.getName() != null ? basicInfo.getName() : null);

                //从detailinfo中获得
                if (detailInfo != null) {
                    agencySupplier.setPublicBanAccountNumber(detailInfo.getPublicBanAccountNumber() != null ? detailInfo.getPublicBanAccountNumber() : null);
                    agencySupplier.setPublicBankName(detailInfo.getPublicBankName() != null ? detailInfo.getPublicBankName() : null);
                    agencySupplier.setUniformCreditCode(detailInfo.getUniformCreditCode() != null ? detailInfo.getUniformCreditCode() : null);
                }

                //自定义生成
                agencySupplier.setUpdateAt(new Date());
                agencySupplier.setCreateAt(new Date());
                try {
                    //添加到私库
                    tAgencySupplierMapper.insertSelective(agencySupplier);
                } catch (Exception e) {
                    //捕获异常回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    e.printStackTrace();
                }
            } else {
                return Result.error(ErrorMessagesEnum.LOGINNAME_NUMBER_EXIST);
            }
        } else {
            //供应商不存在的时候抽取handleSupplier的字段添加
            TAgencySupplier agencySupplier = new TAgencySupplier();
            TSupplierBasicInfo supplierBasicInfo = new TSupplierBasicInfo();
            TSupplierDetailInfo detailInfo = new TSupplierDetailInfo();
            basicInfo = new TSupplierBasicInfo();

            //添加姓名,手机号,代理id,来源
            agencySupplier.setSupplierName(handleSupplier.getName() != null ? handleSupplier.getName() : null);
            agencySupplier.setCellphone(handleSupplier.getCellphone() != null ? handleSupplier.getCellphone() : null);
            agencySupplier.setAgencyId(handleSupplier.getAgencyId() != null ? handleSupplier.getAgencyId() : null);
            agencySupplier.setSource(handleSupplier.getSource() != null ? handleSupplier.getSource() : null);
            agencySupplier.setCreateAt(new Date());
            agencySupplier.setUpdateAt(new Date());

            //第一次新增basicinfo中的法人supplierid 代码生成
            Long supplierId = (Long) (System.currentTimeMillis() + Math.round(Math.random() * 10000));
            basicInfo.setSupplierId(supplierId);
            basicInfo.setName(handleSupplier.getName() != null ? handleSupplier.getName() : null);
            basicInfo.setCellphone(handleSupplier.getCellphone() != null ? handleSupplier.getCellphone() : null);
            basicInfo.setInviterType(handleSupplier.getInviterType() != null ? handleSupplier.getInviterType() : null);
            basicInfo.setInviterId(handleSupplier.getAgencyId() != null ? Long.parseLong(handleSupplier.getAgencyId()) : null);
            basicInfo.setState(Const.STATE.COMMITTED);
            basicInfo.setRole(Const.Role.ROLE_CORPORATION);
            basicInfo.setUpdateAt(new Date());
            basicInfo.setCreateAt(new Date());

            //供应商详情
            detailInfo.setSupplierId(supplierId);
            detailInfo.setCompanyName(handleSupplier.getCompanyName() != null ? handleSupplier.getCompanyName() : null);
            detailInfo.setPublicBanAccountNumber(handleSupplier.getPublicBanAccountNumber() != null ? handleSupplier.getPublicBanAccountNumber() : null);
            detailInfo.setPublicBankName(handleSupplier.getPublicBankName() != null ? handleSupplier.getPublicBankName() : null);
            detailInfo.setUniformCreditCode(handleSupplier.getUniformCreditCode() != null ? handleSupplier.getUniformCreditCode() : null);
            detailInfo.setUpdateAt(new Date());
            detailInfo.setCreateAt(new Date());

            //添加到数据库
            try {
                //添加到私库
                tAgencySupplierMapper.insertSelective(agencySupplier);
                tSupplierBasicInfoMapper.insertSelective(basicInfo);
                tSupplierDetailInfoMapper.insertSelective(detailInfo);
            } catch (Exception e) {
                //捕获异常回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                e.printStackTrace();
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
    public Result<HandleAgency> regesityAgency(HandleAgency agency) {
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        //或的基本信息密码加密密码加密
        basicInfo.setCellphone(agency.getCellphone());
        basicInfo.setPassword(MD5Util.MD5EncodeUtf8(agency.getPassword()));
        Result result = new Result();
        int sucess = 0;
        try {
            sucess = tAgencyBasicInfoMapper.insertSelective(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        Long id = basicInfo.getId();
        if (sucess > 0) {
            //数据库生成的id放入对象传入下个页面
            agency.setAgencyId(basicInfo.getId());
            result.setData(agency);
            result.setMsg("注册成功");
            return result;
        }
        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
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

        List<String> list = new ArrayList<>();
        for (Attachement attachement : agency.getAtts()) {
            String certificateName = attachement.getCertificateName();
            list.add(certificateName);
        }
        criteria2.andCertificateNameIn(list);

        //返回得到的信息
        List<TAgencyBasicInfo> tAgencyBasicInfos = tAgencyBasicInfoMapper.selectByExample(agencyBasicInfoCriteria);
        List<TAgencyDetailInfo> tAgencyDetailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        List<TAgencyAttachment> tAgencyAttachments = tAgencyAttachmentMapper.selectByExample(agencyAttachmentCriteria);

        if (tAgencyBasicInfos.isEmpty()) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        //封装信息返回数据
        List<HandleAgency> agencyList = new ArrayList<>();

        for (TAgencyBasicInfo basicInfo : tAgencyBasicInfos) {
            HandleAgency agency1 = new HandleAgency();
            Long agencyId = basicInfo.getAgencyId();
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
        for (HandleAgency handleAgency : agencyList) {
            List<Attachement> attachements = new ArrayList<>();
            Long agencyId2 = handleAgency.getAgencyId();
            for (TAgencyAttachment attachment : tAgencyAttachments) {
                Long agencyId3 = attachment.getAgencyId();
                Attachement attachement = new Attachement();
                if (agencyId2.equals(agencyId3)) {
                    BeanUtils.copyProperties(attachment, attachement);
                    attachement.setTypeId(agencyId3.toString());
                    attachements.add(attachement);
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
        //创建时间
        Date date = new Date();
        //生成唯一的代理商的id
        Long agencyId = agency.getAgencyId();

        //基本t_agency_basic_info信息的封装
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        tAgencyBasicInfo.setName(agency.getName());
        tAgencyBasicInfo.setCellphone(agency.getCellphone());
        //注册状态需要待平台审核
        tAgencyBasicInfo.setState(Const.STATE.REGISTERED);
        //角色必须是法人注册
        tAgencyBasicInfo.setRole(Const.Role.ROLE_CORPORATION);

        //封装信息查询一插入的信息
        TAgencyBasicInfoCriteria criteria = new TAgencyBasicInfoCriteria();
        criteria.createCriteria().andCellphoneEqualTo(agency.getCellphone());
        /**
         * 用户自注册邀请人为平台,也可自行传入邀请人信息,待完善
         */
        tAgencyBasicInfo.setCreateAt(date);

        //t_agency_detail_info 信息封装
        TAgencyDetailInfo tAgencyDetailInfo = new TAgencyDetailInfo();
        tAgencyDetailInfo.setAgencyId(agencyId);
        tAgencyDetailInfo.setCompanyName(agency.getCompanyName());
        tAgencyDetailInfo.setUniformCreditCode(agency.getUniformCreditCode());
        tAgencyDetailInfo.setPublicBankName(agency.getPublicBankName());
        tAgencyDetailInfo.setPublicBanAccountNumber(agency.getPublicBanAccountNumber());
        tAgencyDetailInfo.setCreateAt(date);

        //附件信息的封装
        List<TAgencyAttachment> list = new ArrayList<TAgencyAttachment>();
        for (Attachement att : agency.getAtts()) {
            TAgencyAttachment attachment = new TAgencyAttachment();
            attachment.setAgencyId(agencyId);
            attachment.setCreateAt(date);
            attachment.setCertificateFilePath(att.getCertificateFilePath());
            attachment.setCertificateType(att.getCertificateType());
            attachment.setCertificateName(att.getCertificateName());
            attachment.setCertificateNumber(att.getCertificateNumber());
            list.add(attachment);
        }

        try {
            //基本t_agency_basic_info信息添加
            tAgencyBasicInfoMapper.updateByExampleSelective(tAgencyBasicInfo, criteria);
            //t_agency_detail_info 信息添加
            tAgencyDetailInfoMapper.insertSelective(tAgencyDetailInfo);
            //附件表信息添加
            tAgencyAttachmentMapper.insertListAttachment(list);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return Result.success("信息完善成功");

    }

    /**
     * 代理机构名下的所有项目
     *
     * @return
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Override
    public Result<List<AgencySubjectsVo>> proxySubjects(AgencySubjectDto subjectDto) {
        /**
         * SQL 没有写实现
         */

        return Result.success("查新成功");
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
        if (employees == null) {
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
    public Result<List<AgencyEmployeeVo>> queryEmployee(HandleEmployee employee) {
        //获得公司的id
        Long agencyId = employee.getAgencyId();
        //封装查询条件,查询该id下的所有信息
        TAgencyBasicInfoCriteria basicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andAgencyIdEqualTo(agencyId);
        criteria.andIdEqualTo(employee.getId());
        criteria.andNameEqualTo(employee.getName());
        criteria.andCellphoneEqualTo(employee.getCellphone());
        criteria.andStateEqualTo(employee.getState());
        criteria.andRoleEqualTo(employee.getRole());
        criteria.andCreateAtEqualTo(employee.getCreateAt());
        criteria.andUpdateAtEqualTo(employee.getUpdateAt());
        //返回对应公司的信息
        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andAgencyIdEqualTo(agencyId);
        //返回公司的详细信息,依据agencyId查询,返回信息只有一条
        List<TAgencyDetailInfo> detailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        TAgencyDetailInfo detailInfo = detailInfos.get(0);
        List<TAgencyBasicInfo> basicInfos = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria);
        if (basicInfos == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
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
        TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria).get(0);
        //获得公司的id
        Long agencyId = basicInfo.getAgencyId();

        //返回对应公司的信息
        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andAgencyIdEqualTo(agencyId);
        //返回公司的详细信息,依据agencyId查询,返回信息只有一条
        List<TAgencyDetailInfo> detailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        TAgencyDetailInfo detailInfo = detailInfos.get(0);

        if (basicInfo == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        //找到老板的名字
        TAgencyBasicInfoCriteria basicInfoCriteria1 = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria2 = basicInfoCriteria.createCriteria();
        criteria2.andAgencyIdEqualTo(agencyId);
        criteria2.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        TAgencyBasicInfo boss = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria1).get(0);

        AgencyEmployeeVo vo = new AgencyEmployeeVo();
        vo.setUserId(basicInfo.getId().toString());
        vo.setUserName(basicInfo.getName());
        vo.setCellphone(basicInfo.getCellphone());
        vo.setCompanyId(basicInfo.getAgencyId().toString());
        vo.setCompanyName(detailInfo.getCompanyName());
        vo.setBossName(boss.getName());
        return Result.success("查询成功", vo);
    }

    /**
     * 依据id查询员工
     *
     * @param id
     * @return
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result queryEmployeeById(Long id) {
        //封装查询条件,查询该id下的所有信息
        TAgencyBasicInfoCriteria basicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        TAgencyBasicInfo basicInfo = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria).get(0);
        //获得公司的id
        Long agencyId = basicInfo.getAgencyId();

        //返回对应公司的信息
        TAgencyDetailInfoCriteria detailInfoCriteria = new TAgencyDetailInfoCriteria();
        TAgencyDetailInfoCriteria.Criteria criteria1 = detailInfoCriteria.createCriteria();
        criteria1.andAgencyIdEqualTo(agencyId);
        //返回公司的详细信息,依据agencyId查询,返回信息只有一条
        List<TAgencyDetailInfo> detailInfos = tAgencyDetailInfoMapper.selectByExample(detailInfoCriteria);
        TAgencyDetailInfo detailInfo = detailInfos.get(0);

        if (basicInfo == null) {
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        //找到老板的名字
        TAgencyBasicInfoCriteria basicInfoCriteria1 = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria2 = basicInfoCriteria.createCriteria();
        criteria2.andAgencyIdEqualTo(agencyId);
        criteria2.andRoleEqualTo(Const.Role.ROLE_CORPORATION);
        TAgencyBasicInfo boss = tAgencyBasicInfoMapper.selectByExample(basicInfoCriteria1).get(0);

        AgencyEmployeeVo vo = new AgencyEmployeeVo();
        vo.setUserId(basicInfo.getId().toString());
        vo.setUserName(basicInfo.getName());
        vo.setCellphone(basicInfo.getCellphone());
        vo.setCompanyId(basicInfo.getAgencyId().toString());
        vo.setCompanyName(detailInfo.getCompanyName());
        vo.setBossName(boss.getName());
        return Result.success("查询成功", vo);
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
        //封装对象查询
        TAgencyBasicInfoCriteria basicInfoCriteria = new TAgencyBasicInfoCriteria();
        TAgencyBasicInfoCriteria.Criteria criteria = basicInfoCriteria.createCriteria();
        criteria.andIdEqualTo(employee.getId());
        criteria.andAgencyIdEqualTo(employee.getAgencyId());
        //接受信息
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        basicInfo.setName(employee.getName());
        basicInfo.setCellphone(employee.getName());
        basicInfo.setPassword(MD5Util.MD5EncodeUtf8(employee.getPassword()));
        basicInfo.setState(employee.getState());
        basicInfo.setRole(employee.getState());
        basicInfo.setCreateAt(employee.getCreateAt());
        basicInfo.setUpdateAt(employee.getUpdateAt());


        int sucess = 0;
        try {
            tAgencyBasicInfoMapper.updateByExample(basicInfo, basicInfoCriteria);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        if (sucess > 0) {
            return Result.success("修改成功", true);
        }
        return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
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
    public Result<List<AgencySupplierVo>> querySupplierCriteria(AgencySupplierDto supplierDto) {
        //封装查询条件
        TAgencySupplierCriteria supplierCriteria = new TAgencySupplierCriteria();
        TAgencySupplierCriteria.Criteria criteria = supplierCriteria.createCriteria();
        criteria.andSupplierIdEqualTo(supplierDto.getAgencyId());

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
        List<TAgencySupplier> basicInfos = tAgencySupplierMapper.selectByExample(supplierCriteria);
        //封装附件查询的条件list
        List<Long> longs = new ArrayList<>();
        //封装
        List<AgencySupplierVo> vos = new ArrayList<>();
        for (TSupplierDetailInfo detailInfo : supplierVos) {
            AgencySupplierVo vo = new AgencySupplierVo();
            Long supplierId = detailInfo.getSupplierId();
            for (TAgencySupplier supplier : basicInfos) {
                Long supplierId1 = supplier.getSupplierId();
                if (supplierId.equals(supplierId1)) {
                    longs.add(supplierId);
                    vo.setCellphone(supplier.getCellphone());
                    vo.setUniformCreditCode(supplier.getUniformCreditCode());
                    vo.setPublicBankName(supplier.getPublicBankName());
                    vo.setPublicBanAccountNumber(supplier.getPublicBanAccountNumber());
                    vo.setCreateAt(detailInfo.getCreateAt());
                    vo.setCompanyName(detailInfo.getCompanyName());
                    vo.setSupplierId(supplierId);
                    vos.add(vo);
                }
            }
        }
        criteria2.andSupplierIdIn(longs);
        List<TSupplierAttachment> attachments = tSupplierAttachmentMapper.selectByExample(attachmentCriteria);
        for (AgencySupplierVo vo : vos) {
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
     * @Description :依据条件查专家 条件可以升是专家name,专家专业 profession
     * 专家职称 positional 专家水平 level,机构id为必须
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Result<List<AgencyExpertVo>> queryExpertCriteria(AgencyExpertDto expertDto) {

        //封装查询条件
        TAgencyExpertCriteria expertCriteria = new TAgencyExpertCriteria();
        TAgencyExpertCriteria.Criteria criteria = expertCriteria.createCriteria();
        criteria.andExpertNameLike(expertDto.getExpertName());
        criteria.andAgencyIdEqualTo(expertDto.getAgencyId().toString());

        TExpertBasicInfoCriteria basicInfoCriteria = new TExpertBasicInfoCriteria();
        TExpertBasicInfoCriteria.Criteria criteria1 = basicInfoCriteria.createCriteria();
        criteria1.andProfessionEqualTo(expertDto.getProfession());
        criteria1.andPositionalEqualTo(expertDto.getPositional());
        criteria1.andLevelEqualTo(expertDto.getLevel());

        //查询结果返回
        List<TAgencyExpert> expertList = tAgencyExpertMapper.selectByExample(expertCriteria);
        List<TExpertBasicInfo> infoList = tExpertBasicInfoMapper.selectByExample(basicInfoCriteria);
        //对结果进行返回
        List<AgencyExpertVo> voList = new ArrayList<>();
        for (TAgencyExpert expert : expertList) {
            Long expertId = expert.getExpertId();
            for (TExpertBasicInfo info : infoList) {
                Long id = info.getId();
                if (expertId.equals(id)) {
                    AgencyExpertVo vo = new AgencyExpertVo();
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
     * @Description :完善代理机构信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> completeAgencySupInfo(AgencySupplierDto dto) {
        //查询注册信息
        TAgencySupplierCriteria agencyCriteria = new TAgencySupplierCriteria();
        TAgencySupplierCriteria.Criteria criteria = agencyCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        TAgencySupplier supplier = tAgencySupplierMapper.selectByExample(agencyCriteria).get(0);
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //t_SUPPLIER_attachment,t_SUPPLIER_basic_info,t_SUPPLIER_detail_info,t_AGENCY_SUPPLIER
        //实例化插入对象接受数据
        TSupplierBasicInfo basicInfo = new TSupplierBasicInfo();
        //完善信息是对t_SUPPLIER_attachment,t_SUPPLIER_basic_info,t_SUPPLIER_detail_info,表做insert操作
        //封装对象
        basicInfo.setName(dto.getName());
        basicInfo.setCellphone(dto.getCellphone());
        //使用注册时候的密码
        basicInfo.setPassword(supplier.getPassword());
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
        //获得返回的id,作为agencyId
        Long supplierId = basicInfo.getId();
        basicInfo.setSupplierId(supplierId);

        //id更新进入t_purchaser_agency的数据库
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
            tAgencySupplierMapper.updateByPrimaryKey(supplier);
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
    }

    /**
     * @author :winlin
     * @Description :完善专家信息
     * @param:
     * @return:
     * @date:2018/9/21
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> completeAgencyExpertInfo(AgencyExpertDto dto) {
        //查询注册信息
        TAgencyExpertCriteria agencyCriteria = new TAgencyExpertCriteria();
        TAgencyExpertCriteria.Criteria criteria = agencyCriteria.createCriteria();
        criteria.andCellphoneEqualTo(dto.getCellphone());
        TAgencyExpert expert = tAgencyExpertMapper.selectByExample(agencyCriteria).get(0);
        //接受页面穿过来的信息,录入数据库,受影响的表,之前
        //t_agency_expert t_expert_attachment t_expert_basic_info
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
        try {
            tExpertBasicInfoMapper.insertSelective(basicInfo);
        } catch (Exception e) {
            //捕获异常回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        //获得返回的id,作为expertId
        Long expertId = basicInfo.getId();
        try {
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
}
