package com.epc.web.service.service.impl.agency;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.agency.handle.*;
import com.epc.web.facade.agency.vo.AgencyEmployeeVo;
import com.epc.web.service.domain.agency.*;
import com.epc.web.service.domain.expert.TAgencyExpertCriteria;
import com.epc.web.service.domain.expert.TAgencyExpert;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertBasicInfoCriteria;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfoCriteria;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfoCriteria;
import com.epc.web.service.mapper.agency.TAgencyAttachmentMapper;
import com.epc.web.service.mapper.agency.TAgencyBasicInfoMapper;
import com.epc.web.service.mapper.agency.TAgencyDetailInfoMapper;
import com.epc.web.service.mapper.agency.TAgencySupplierMapper;
import com.epc.web.service.mapper.expert.TAgencyExpertMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.agency.AgencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * @Author :winlin
     * @Description :新增员工的基本信息,新增再表t_agency_basic_info表中
     * 页面传入信息有name,cellphone,password,agencyId,role,isdelete为db默认为0
     * 其他字段需要生成,password需要加密Md5,内部员工状态为3,所属角色为页面传入
     * @Date:2018/9/13
     */
    @Override
    public Result insertEmployee(HandleEmployee handleEmployee) {
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
        handleEmployee.setCreateAt(new Date());
        //更新时间
        handleEmployee.setUpdateAt(new Date());
        //创建数据库插入对象
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        //复制对象数据到数据库对象中
        BeanUtils.copyProperties(handleEmployee, tAgencyBasicInfo);
        //调用Mapper存入数据库
        int success = tAgencyBasicInfoMapper.insertSelective(tAgencyBasicInfo);
        //返回页面信息
        return success > 0 ? Result.success("添加成功") : Result.error("添加失败");
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
    public Result insertExpert(HandleExpert handleExpert) {

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
                    //专家信息同步进入私库
                    return tAgencyExpertMapper.insertSelective(agencyExpert) > 0 ? Result.success() : Result.error();
                } else {
                    //专家信息同步进入私库
                    return tAgencyExpertMapper.insertSelective(agencyExpert) > 0 ? Result.success() : Result.error();
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

            //专家信息同步进入私库
            int success = tAgencyExpertMapper.insertSelective(agencyExpert);

            //添加信息到公库
            int success2 = tExpertBasicInfoMapper.insertSelective(expertBasicInfo);

            //返回信息
            return (success + success2) == 2 ? Result.success("success") : Result.error("fail");
        }
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
    public Result insertSupplier(HandleSupplier handleSupplier) {

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
                //添加到私库
                return tAgencySupplierMapper.insertSelective(agencySupplier) > 0 ? Result.success() : Result.error();
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
            int agency = tAgencySupplierMapper.insertSelective(agencySupplier);
            int basic = tSupplierBasicInfoMapper.insertSelective(basicInfo);
            int detail = tSupplierDetailInfoMapper.insertSelective(detailInfo);
            return (agency + basic + detail) == 3 ? Result.success("添加成功") : Result.error("添加失败");
        }
    }

    /**
     * @author :winlin
     * @Description :页面信息验证通过后传入存入
     * @param:
     * @return: 返回 agency信息给信息完善页面使用
     * @date:2018/9/18
     */
    @Override
    public Result regesityAgency(HandleAgency agency) {
        TAgencyBasicInfo basicInfo = new TAgencyBasicInfo();
        //或的基本信息密码加密密码加密
        basicInfo.setCellphone(agency.getCellphone());
        basicInfo.setPassword(MD5Util.MD5EncodeUtf8(agency.getPassword()));
        Result result = new Result();
        int sucess = tAgencyBasicInfoMapper.insertSelective(basicInfo);
        if (sucess > 0) {
            result.setData(agency);
            result.setMsg("注册成功");
            return result;
        }
        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
    }

    @Override
    public Result queryAgencies(HandleAgency agency) {
        return Result.success();
    }



    /**
     * @author :winlin
     * @Description :前端信息验证完成,跟新信息即可
     * @param:
     * @return:
     * @date:2018/9/18
     */
    @Override
    public Result modifypassword(HandleAgency agency) {
        //封装跟新信息
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        tAgencyBasicInfo.setCellphone(agency.getCellphone());
        tAgencyBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(agency.getPassword()));
        //跟新数据库
        TAgencyBasicInfoCriteria criteria = new TAgencyBasicInfoCriteria();
        criteria.createCriteria().andCellphoneEqualTo(agency.getCellphone());

        return tAgencyBasicInfoMapper.updateByExampleSelective(tAgencyBasicInfo, criteria) > 0 ? Result.success("密码修改成功") : Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
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
    public Result completeInfo(HandleAgency agency) {
        //创建时间
        Date date = new Date();
        //生成唯一的代理商的id
        Long agencyId = System.currentTimeMillis() + Math.round(Math.random() * 10000000);

        //基本t_agency_basic_info信息的封装
        TAgencyBasicInfo tAgencyBasicInfo = new TAgencyBasicInfo();
        tAgencyBasicInfo.setName(agency.getName());
        tAgencyBasicInfo.setAgencyId(agencyId);
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

        //基本t_agency_basic_info信息添加
        int sucess = tAgencyBasicInfoMapper.updateByExampleSelective(tAgencyBasicInfo, criteria);
        //t_agency_detail_info 信息添加
        int sucess1 = tAgencyDetailInfoMapper.insertSelective(tAgencyDetailInfo);
        //附件表信息添加
        int sucess2 = tAgencyAttachmentMapper.insertListAttachment(list);
        return (sucess + sucess1 + sucess2) > 3 ? Result.success("信息完善成功") : Result.error(ErrorMessagesEnum.INSERT_FAILURE);

    }

    @Override
    public Result proxySubjects() {
        return Result.success();
    }

    @Override
    public Result queryEmployee(HandleEmployee employee) {
        return Result.success();
    }

    /**
     * 依据手机号查询员工
     * @param cellphone
     * @return
     */
    @Override
    public Result queryEmployeeByCellphone(String cellphone) {
        AgencyEmployeeVo employeeVo = tAgencyBasicInfoMapper.queryEmployeeByCellphone(cellphone);
        return employeeVo==null?Result.error(ErrorMessagesEnum.SELECT_FAILURE):Result.success("查询成功",employeeVo);
    }

    /**
     * 依据id查询员工
     * @param id
     * @return
     */
    @Override
    public Result queryEmployeeById(Long id) {
        AgencyEmployeeVo employeeVo = tAgencyBasicInfoMapper.queryEmployeeById(id);
        return employeeVo==null?Result.error(ErrorMessagesEnum.SELECT_FAILURE):Result.success("查询成功",employeeVo);
    }

    @Override
    public Result updateEmployeeBy(HandleEmployee employee) {
        return Result.success();
    }
}
