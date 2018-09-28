package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.domain.supplier.*;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
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
 * 供应商对员工的相关操作
 * @Description:
 * @Author:         donghuan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    private static final Logger LOGGER= LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;

    /**
     * 注册供应商
     *  {业务：    还需要要判断电话在数据库中有没有，（有无人拉。如无，就是自己注册；如有，就是添加密码登陆完善个人信息）
     *          第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *          所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *  }
     *  自己找到平台网站注册供应商
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        Date date=new Date();
        //得到 电话 密码
        String cellphone = handleSupplierDetail.getCellphone();
        String password=handleSupplierDetail.getPassword();

        if(StringUtils.isNotBlank(cellphone)){
            //通过 电话 查询数据库中有没有记录, 如果有，就设置密码,完善信息; 如果没有，就继续注册
            //我这个数据库是没有记录这个电话的
            TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
            TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
            if (CollectionUtils.isEmpty(listTSupplierBasicInfos)) {
                if(StringUtils.isNotBlank(password)){
                    //如果没有电话，就可以注册
                    //将电话，密码信息存入到这个表对象中
                    TSupplierBasicInfo tSupplierBasicInfo=new TSupplierBasicInfo();
                    //设置电话
                    tSupplierBasicInfo.setCellphone(cellphone);
                    //设置密码
                    tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handleSupplierDetail.getPassword()));
                    //设置状态
                    tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
                    //设置角色
                    tSupplierBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
                    //设置状态,已注册
                    tSupplierBasicInfo.setState(Const.STATE.REGISTERED);
                    //创建时间
                    tSupplierBasicInfo.setCreateAt(date);
                    //最后修改时间
                    tSupplierBasicInfo.setUpdateAt(date);
                    //短信验证

                    int i=0;
                    try{
                        i=tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
                        //更新数据库， 将主键id设置与operator_id一样，因为是运营商注册，
                        tSupplierBasicInfo.setSupplierId(tSupplierBasicInfo.getId());
                        tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
                    }catch (BusinessException e){
                        LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                    }catch (Exception e){
                        LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.error(e.getMessage());
                    }
                    return i>0 ? Result.success(true) : Result.success(false);
                }else{
                    return Result.error("密码不能空");
                }
            }else{
                //如果有电话
                return Result.error("数据库中有这条记录，不能注册，电话要唯一");
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {有误}");
        }
    }

    /**
     *  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> addPasswordSupplier(HandleSupplierDetail handleSupplierDetail){
        Date date=new Date();

        //得到电话 密码
        String cellphone=handleSupplierDetail.getCellphone();
        String password=handleSupplierDetail.getPassword();
        //依据电话查询数据库中有没有这样一条记录,有就让其设置密码，将状态改成完善信息中
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(password)){
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
            if(!CollectionUtils.isEmpty(tSupplierBasicInfos)){
                TSupplierBasicInfo operatorBasic = tSupplierBasicInfos.get(0);
                //设置一些表中必须的信息
                operatorBasic.setPassword(MD5Util.MD5EncodeUtf8(password));
                //完善中
                operatorBasic.setState(Const.STATE.PERFECTING);
                //最后修改时间
                operatorBasic.setUpdateAt(date);
                int i=0;
                try{
                    //更新数据到表中，完成账号的激活，后续 必须 要完善个人信息
                    i=tSupplierBasicInfoMapper.updateByExampleSelective(operatorBasic,criteria);
                }catch (BusinessException e){
                    LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.updateByExampleSelective, 异常信息e={}" , e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
                }catch (Exception e){
                    LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.updateByExampleSelective ： 异常信息e={}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }
                return i>0 ? Result.success(true) : Result.success(false);
            }else{
                return Result.error("[供应商注册] 数据库中没有这个电话，必须由平台拉取，或者在平台注册");
            }
        }else{
            return Result.error("[供应商注册] StringUtils.isNotBlank(cellphone) : {参数异常}");
        }
    }


    /**
     * 暂时没用,不知道后期有没有这个需求
     *   依据 用户角色 是法人的情况下，来查出 supplier_id,
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<Long> findSupplierIdByRole(Integer role){
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(role!=null && role==0){
            subCriteria.andRoleEqualTo(role);
            return Result.success(tSupplierBasicInfoMapper.selectByExample(criteria).get(0).getId());
        }else{
            return Result.error("role!=null && role==0 : {参数异常}");
        }
    }

    /**
     * 根据员工的id来查询基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        //得到supplierbasic表的id
        Long id= handleFindSupplierByInfo.getId();
        if(id!=null){
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
            if(tSupplierBasicInfo!=null){
                //将时间格式化
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
                String createAt = format.format(tSupplierBasicInfo.getCreateAt());
                String updateAt = format.format(tSupplierBasicInfo.getUpdateAt());
                SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
                vo.setCreateAt(createAt);
                vo.setUpdateAt(updateAt);
                BeanUtils.copyProperties(tSupplierBasicInfo,vo);
                return Result.success(vo);
            }else{
                return Result.error(ErrorMessagesEnum.ID_ILLEAGAL);
            }
        }else{
            return Result.error("id!=null 条件有异常");
        }
    }

    /**
     * 通过员工id 只 修改员工 是否禁用
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeByisDeleted(HandleSupplierEmployeeByisDeleted handleSupplierEmployeeByisDeleted){
        Long id=handleSupplierEmployeeByisDeleted.getId();
        if(id==null){
            return Result.error("[通过员工id 只 修改员工的状态] id==null : {条件异常}");
        }
        try{
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
            tSupplierBasicInfo.setIsDeleted(handleSupplierEmployeeByisDeleted.getIsDeleted());
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("[通过员工id 只 修改员工的状态] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[通过员工id 只 修改员工的状态] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteSupplierEmployeeById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        Long id=handleFindSupplierByInfo.getId();
        Integer isDeleted = handleFindSupplierByInfo.getIsDeleted();
        if(id!=null && isDeleted!=null){
            try{
                TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
                tSupplierBasicInfo.setIsDeleted(isDeleted);
                int i = tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
                return Result.success(i>0);
            }catch (BusinessException e){
                LOGGER.error("[供应商删除依id删除一个员工] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
            }catch (Exception e){
                LOGGER.error("[供应商删除依id删除一个员工] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        }else{
            return Result.error("[供应商删除依id删除一个员工] id!=null : {条件异常}");
        }
    }

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeRoleById(HandleOperatorRole handleOperatorRole){
        Long id=handleOperatorRole.getId();
        Integer role = handleOperatorRole.getRole();
        if(id==null || role==null){
            LOGGER.error("[根据用户id来修改他的role] id==null || role==null : {参数异常}");
            return Result.error("[根据用户id来修改他的role] id==null || role==null : {参数异常}");
        }
        try{
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
            tSupplierBasicInfo.setRole(role);
            int i = tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[根据用户id来修改他的role] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[根据用户id来修改他的role] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> findSupplierRecordByCellphone(HandleSupplierRecordByCellphone handleSupplierByCellphone){
        String cellphone=handleSupplierByCellphone.getCellphone();
//        System.out.println("电话 cellphone==="+cellphone);
        if(StringUtils.isNotBlank(cellphone)){
            TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
            TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
            if(!CollectionUtils.isEmpty(tSupplierBasicInfos)){
                return Result.success(true);
            }else{
                return Result.success(false);
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {条件异常}");
        }

    }

    /**
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        //得到员工的id
        Long id=handleFindSupplierByInfo.getId();
        if(id==null){
            return Result.error("[员工id来查询（公司法人supplier_id） 公司详情（包括附件）] id==null ： {条件异常}");
        }
        TSupplierBasicInfo supplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        //得到法人supplier_id
        Long supplierId = supplierBasicInfo.getSupplierId();

        /**
         * 然后在basic同一个表中将法人的名字，电话，状态，角色 ，创建时间，更新时间都查出来
         * 因为supplier_id与id一样
         */
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(supplierId);

        //依据员工的法人id来查询另外两张表，supplier_detail; supplier_attachment

        TSupplierAttachmentCriteria criteriaAtt=new TSupplierAttachmentCriteria();
        TSupplierAttachmentCriteria.Criteria subCriteriaAtt = criteriaAtt.createCriteria();

        TSupplierDetailInfoCriteria criteriaDetail=new TSupplierDetailInfoCriteria();
        TSupplierDetailInfoCriteria.Criteria subCriteriaDetail = criteriaDetail.createCriteria();

        subCriteriaAtt.andSupplierIdEqualTo(supplierId);
        subCriteriaDetail.andSupplierIdEqualTo(supplierId);
        //这里不能为空，因为殾已经能添加员工了，而且员工能来查看了，必须是 供应商各种资料已经通过审核，所以必须有内容
        TSupplierDetailInfo tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(criteriaDetail).get(0);
        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );

        List<TSupplierAttachment> tSupplierAttachments = tSupplierAttachmentMapper.selectByExample(criteriaAtt);

        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();

        for(TSupplierAttachment ts:tSupplierAttachments){
            if(ts.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())){
                //营业执照照片url
                roleDetailInfo.setBusinessLicense(ts.getCertificateFilePath());
                roleDetailInfo.setBusinessLicenseNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode())){
                //资质证书url
                roleDetailInfo.setQualificationCertificate(ts.getCertificateFilePath());
                roleDetailInfo.setQualificationCertificateNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
                //法人身份证正面照片url
                roleDetailInfo.setLegalIdCardPositive(ts.getCertificateFilePath());
                roleDetailInfo.setLegalIdCardPositiveNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
                //法人身份证反面照片url
                roleDetailInfo.setLegalIdCardOther(ts.getCertificateFilePath());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode())){
                //经办人(运营商员工)手持身份证正面照片url
                roleDetailInfo.setOperatorIdCardFront(ts.getCertificateFilePath());
                roleDetailInfo.setOperatorIdCardFrontNumber(ts.getCertificateNumber());
                continue;
            }
            if(ts.getCertificateType().equals(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode())){
                //带公章的授权书照片url
                roleDetailInfo.setCertificateOfAuthorization(ts.getCertificateFilePath());
                roleDetailInfo.setCertificateOfAuthorizationNumber(ts.getCertificateNumber());
                continue;
            }
        }
        SupplierAttachmentAndDetailVO vo=new SupplierAttachmentAndDetailVO();
        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );


//        vo.setName(tSupplierBasicInfo.getName());
//        vo.setCellphone(tSupplierBasicInfo.getCellphone());
//        vo.setState(tSupplierBasicInfo.getState());
//        vo.setRole(tSupplierBasicInfo.getRole());


        //将附件的所有信息复制到返回类中
        BeanUtils.copyProperties(roleDetailInfo,vo);

        //将依据supplier_id查询出来detail表中信息copy到返回类中
        BeanUtils.copyProperties(tSupplierDetailInfos,vo);

        //将法人的基本信息复制到返回类中
        BeanUtils.copyProperties(tSupplierBasicInfo,vo);

        //创建时间与更新时间取的是basic表中的时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss a");
        String createAt = format.format(tSupplierBasicInfo.getCreateAt());
        String updateAt=format.format(tSupplierBasicInfo.getUpdateAt());
        vo.setCreateAt(createAt);
        vo.setUpdateAt(updateAt);

        return Result.success(vo);
    }

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeStateById(HandleOperatorState handleOperatorState){
        Long id = handleOperatorState.getId();
        Integer state=handleOperatorState.getState();
        System.out.println("id + state==="+id+"   "+state);
        if(id==null || state==null){
            LOGGER.error("[通过id来修改对应的state] id==null || state==null : {参数异常}");
            return Result.error("[通过id来修改对应的state] id==null || state==null : {参数异常}");
        }
        try{
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
            tSupplierBasicInfo.setState(state);
            int i = tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[通过id来修改对应的state] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[通过id来修改对应的state] tSupplierBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        String cellphone= handleFindSupplierByInfo.getCellphone();

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
            try{
                List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
                TSupplierBasicInfo single = tSupplierBasicInfos.get(0);
                SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
                vo.setCreateAt(format.format(single.getCreateAt()));
                vo.setUpdateAt(format.format(single.getUpdateAt()));
                BeanUtils.copyProperties(single,vo);
                return Result.success(vo);
            }catch (BusinessException e){
                LOGGER.error("[依据电话来查找供应商基本信息] tSupplierBasicInfoMapper.selectByExample : 异常信息e={}",e);
                return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
            }catch (Exception e){
                LOGGER.error("[依据电话来查找供应商基本信息] tSupplierBasicInfoMapper.selectByExample : 异常信息e={}",e);
                return Result.error(e.getMessage());
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {参数异常}");
        }
    }

    /**
     *  忘记密码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //得到手机号,查询数据库中有没有这条数据
        String cellphone=handleSupplierForgetPassword.getCellphone();
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
            //查询出一条结果,然后将密码改掉
            List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
            if(CollectionUtils.isEmpty(listTSupplierBasicInfos)){
                return Result.error("[供应商忘记密码] tSupplierBasicInfoMapper.selectByExample : {查询异常，结果是空}");
            }
//            System.out.println(listTSupplierBasicInfos.get(0).getPassword());
            String password = handleSupplierForgetPassword.getPassword();
            if(StringUtils.isNotBlank(password)){
                //加密传过来的密码
                String newPassword = MD5Util.MD5EncodeUtf8(password);
                TSupplierBasicInfo tSupplierBasicInfo=listTSupplierBasicInfos.get(0);
                tSupplierBasicInfo.setPassword(newPassword);
                int i=0;
                try{
                    //将新密码更新到数据 库中
                    i = tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo, criteria);
                }catch (BusinessException e){
                    LOGGER.error("[供应商忘记密码] tSupplierBasicInfoMapper.updateByExampleSelective : {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
                }catch (Exception e){
                    LOGGER.error("[供应商忘记密码] tSupplierBasicInfoMapper.updateByExampleSelective : {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }
                return i>0 ? Result.<Boolean>success(true) : Result.<Boolean>success(false);
            }else{
                return Result.error("[供应商忘记密码] StringUtils.isNotBlank(password) : {条件异常}");
            }
        }else{
            return Result.error("[供应商忘记密码] StringUtils.isNotBlank(cellphone) : {参数异常}");
        }
    }

    /**
     * 供应商增加一个员工
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        Date date=new Date();
        // 创建数据库插入对象
        TSupplierBasicInfo pojo=new TSupplierBasicInfo();

        Long supplierId = handlerSupplierAddEmployee.getSupplierId();
        String name=handlerSupplierAddEmployee.getName();
        String cellphone=handlerSupplierAddEmployee.getCellphone();
        String password=handlerSupplierAddEmployee.getPassword();

        if(supplierId==null || StringUtils.isBlank(name) || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password)){
            return Result.error("[供应商增加一个员工] supplierId==null || StringUtils.isBlank(name) || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password) ：{传入参数异常}");
        }
        //设置供应商的id
        pojo.setSupplierId(supplierId);
        //设置名字
        pojo.setName(name);
        //设置电话
        pojo.setCellphone(cellphone);
        //设置密码
        pojo.setPassword(MD5Util.MD5EncodeUtf8(password));
        //供应商状态3审核通过
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        //是否删除，0存在
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //角色2员工
        pojo.setRole(Const.Role.ROLE_CUSTOMER);
        //创建时间
        pojo.setCreateAt(date);
        //最后修改时间
        pojo.setUpdateAt(date);
        //返回成功或者失败
        try {
            return Result.success(tSupplierBasicInfoMapper.insertSelective(pojo)>0);
        }catch (BusinessException e){
            LOGGER.error("[供应商增加一个员工] exception insertTSupplierBasicInfoMapper : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商增加一个员工] exception insertTSupplierBasicInfoMapper : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }


    /**
     *  供应商修改员工
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        Long id = handlerUpdateSupplierEmployeeById.getId();
        if(id==null){
            return Result.error("[供应商通过id修改员工] id==null : {参数异常}");
        }
        //通过这个员工的id来查询出他的所有信息
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        //将最新的名字传入进去
        tSupplierBasicInfo.setName(handlerUpdateSupplierEmployeeById.getName());
        //将最新的电话传入进去
        tSupplierBasicInfo.setCellphone(handlerUpdateSupplierEmployeeById.getCellphone());
        //将状态传入进去
        tSupplierBasicInfo.setIsDeleted(handlerUpdateSupplierEmployeeById.getIsDeleted());
        //将最新的时间存进去
        tSupplierBasicInfo.setUpdateAt(new Date());
        //更新这条记录
        try{
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("[供应商通过id修改员工] BusinessException updateSupplierEmployeeById : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商通过id修改员工] BusinessException updateSupplierEmployeeById : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }


    /**
     * 根据员工的名字来匹配出符合条件的员工返回一个list：（你给你的id,还有你输入的名字，我只查你id下面所有的符合你名字的所有）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleFindSupplierByInfo handleFindSupplierByInfo) {

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        //获取输入的名字,来进行模糊查询
        String name=handleFindSupplierByInfo.getName();
        //得到操作者本人的id，查出来的是这个供应商底下的员工列表
        Long supplierId=handleFindSupplierByInfo.getSupplierId();
        if(supplierId==null){
            return Result.error("[根据员工的名字来匹配出符合条件的员工返回一个list] supplierId==null ：{条件异常}");
        }
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameLike("%"+name+"%");
        }
        subCriteria.andSupplierIdEqualTo(supplierId);
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        List<SupplierBasicInfoVO> listVo=new ArrayList<SupplierBasicInfoVO>();

        for(TSupplierBasicInfo tsupplierBasicInfo:listTSupplierBasicInfos){
            SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
            BeanUtils.copyProperties(tsupplierBasicInfo,vo);
            //将时间格式化
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(tsupplierBasicInfo.getCreateAt()));
            vo.setUpdateAt(format.format(tsupplierBasicInfo.getUpdateAt()));
            //装入容器
            listVo.add(vo);
        }
        return Result.success(listVo);
    }

    /**
     * 由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(HandleFindSupplierByInfo handleFindSupplierByInfo){

        Long id=handleFindSupplierByInfo.getId();
        Integer role=handleFindSupplierByInfo.getRole();
        Integer isDeleted = handleFindSupplierByInfo.getIsDeleted();

        if(id==null || role==null || isDeleted==null){
            LOGGER.error("[由员工状态来查询出员工的列表] id==null || role==null || isDeleted==null : {参数异常}");
            return Result.error("参数异常");
        }

        // 因为有三种角色，法人，管理员，员工，可能是管理员，所以首先要依据查这个人的id来查出法人id,继而查出法人底下所有的员工
        //查出法人supplier_id
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        if(tSupplierBasicInfo==null){
            LOGGER.error("[由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)] tSupplierBasicInfoMapper.selectByPrimaryKey : {}");
            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
        }
        Long supplierId=tSupplierBasicInfo.getSupplierId();

        if(role==Const.Role.ROLE_CUSTOMER && isDeleted==Const.IS_DELETED.NOT_DELETED){
            //如果你选的是员工,并且状态是可用的，
            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
        }else if(role==Const.Role.ROLE_CUSTOMER && isDeleted==Const.IS_DELETED.IS_DELETED){
            //如果你选的是员工,并且状态禁用的，
            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
        }else if(role==Const.Role.ROLE_ADMIN && isDeleted==Const.IS_DELETED.IS_DELETED){
            //如果你选的是管理员,并且状态禁用的，
            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
        }else if(role==Const.Role.ROLE_ADMIN && isDeleted==Const.IS_DELETED.NOT_DELETED){
            //如果你选的是管理员,并且状态可用的，
            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
        }else{
            return Result.error("查询条件异常");
        }
    }

    /**
     *  为上面的实现方法服务，此方法是查出 所有的员工
     */
    private List<SupplierBasicInfoVO> findSupplierEmployeeByRoleOrisDeleted(Long supplierId,Integer role,Integer isDeleted){

        //查询出所有的员工
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andRoleEqualTo(role);
        subCriteria.andSupplierIdEqualTo(supplierId);
        subCriteria.andIsDeletedEqualTo(isDeleted);

        //给查询出来的结果一个容器，存储查找出来的数据
        List<SupplierBasicInfoVO> listVO=new ArrayList<SupplierBasicInfoVO>();

        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        //查询这样符合条件的员工

        for(TSupplierBasicInfo single:tSupplierBasicInfos){
            SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
            BeanUtils.copyProperties(single,vo);
            //将时间格式化
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(single.getCreateAt()));
            vo.setUpdateAt(format.format(single.getUpdateAt()));
            listVO.add(vo);
        }
        return listVO;
    }


    /**
     * 完善供应商信息
     * 肯定已经登陆成功，才能完善；根据本人的id来查询basic表，然后将填入的详情信息，分别存入另外两张表中
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {

        Long supplierId = roleDetailInfo.getSupplierId();
        if(supplierId==null){
            return Result.error("[完善供应商信息] supplierId==null : {条件异常}");
        }
        Date date=new Date();

        //设置供应商详情表中的一些信息，并插入一条数据到detail
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo, tSupplierDetailInfo);
        //将basic表中的主键id（员工id）设置到detail表中为法人supplier_id
        tSupplierDetailInfo.setSupplierId(roleDetailInfo.getSupplierId());
        tSupplierDetailInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);


        TSupplierAttachment attachment = new TSupplierAttachment();
        attachment.setSupplierId(roleDetailInfo.getSupplierId());
        attachment.setCreateAt(date);
        attachment.setUpdateAt(date);
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try {

            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);

            //证书类型(带公章的授权书照片)
            attachment.setCertificateType(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode());
            //带公章的授权书照片url
            attachment.setCertificateFilePath(roleDetailInfo.getCertificateOfAuthorization());
            //公章证书名字
            attachment.setCertificateName(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getDesc());
            //公章证书号码
            attachment.setCertificateNumber(roleDetailInfo.getCertificateOfAuthorizationNumber());
            tSupplierAttachmentMapper.insertSelective(attachment); //插入一条数据

            //证书类型(经办人(运营商员工)手持身份证正面照片)
            attachment.setCertificateType(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode());
            //经办人(运营商员工)手持身份证正面照片url
            attachment.setCertificateFilePath(roleDetailInfo.getOperatorIdCardFront());
            //证书名字
            attachment.setCertificateName(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getDesc());
            //证书上的号码
            attachment.setCertificateNumber(roleDetailInfo.getOperatorIdCardFrontNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(法人身份证反面照片)
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
            //法人身份证反面照片url
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardOther());
            //证书名字
            attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(法人身份证正面照片)
            attachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
            //法人身份证正面照片url
            attachment.setCertificateFilePath(roleDetailInfo.getLegalIdCardPositive());
            //证书名字
            attachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
            //证书号码
            attachment.setCertificateNumber(roleDetailInfo.getLegalIdCardPositiveNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(营业执照照片)
            attachment.setCertificateType(AttachmentEnum.BUSINESS_LICENSE.getCode());
            //营业执照照片url
            attachment.setCertificateFilePath(roleDetailInfo.getBusinessLicense());
            //证书名称
            attachment.setCertificateName(AttachmentEnum.BUSINESS_LICENSE.getDesc());
            //证书号码
            attachment.setCertificateNumber(roleDetailInfo.getBusinessLicenseNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);

            //证书类型(资质证书)
            attachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
            //资质证书url
            attachment.setCertificateFilePath(roleDetailInfo.getQualificationCertificate());
            //证书名称
            attachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
            //证书号码
            attachment.setCertificateNumber(roleDetailInfo.getQualificationCertificateNumber());
            tSupplierAttachmentMapper.insertSelective(attachment);


            //依据客户端传过来的id来查询对detail attachment 来操作
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(roleDetailInfo.getSupplierId());
            //设置法人姓名
            tSupplierBasicInfo.setName(roleDetailInfo.getName());
            //设置状态为（state）2:已提交
            tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
            //设置更新日期
            tSupplierBasicInfo.setUpdateAt(date);

            //将修改（增加）的数据更新到其中
            tSupplierBasicInfoMapper.updateByPrimaryKey(tSupplierBasicInfo);

            return Result.success();
        }catch (BusinessException e) {
            LOGGER.error("[供应商完善信息。详情表增加一条记录] tSupplierDetailInfoMapper.insertSelective : {}", e);
            LOGGER.error("[供应商完善信息。执行6次，有6种证书] tSupplierAttachmentMapper.insertSelective : {}", e);
            LOGGER.error("[供应商完善信息。更新supplier_basic中的一些信息] tSupplierBasicInfoMapper.updateByPrimaryKey : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商完善信息。详情表增加一条记录] tSupplierDetailInfoMapper.insertSelective : {}", e);
            LOGGER.error("[供应商完善信息。执行6次，有6种证书] tSupplierAttachmentMapper.insertSelective : {}", e);
            LOGGER.error("[供应商完善信息。更新supplier_basic中的一些信息] tSupplierBasicInfoMapper.updateByPrimaryKey : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }
}
