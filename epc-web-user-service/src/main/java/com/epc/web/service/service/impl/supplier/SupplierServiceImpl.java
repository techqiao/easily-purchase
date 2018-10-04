package com.epc.web.service.service.impl.supplier;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.Attachment;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierId;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.query.QuerywithPageHandle;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.domain.supplier.*;
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
 * @Description:    供应商服务
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
    @Autowired
    private TTenderMessageMapper tTenderMessageMapper;

    /**0
     * 注册供应商
     *  {业务：    还需要要判断电话在数据库中有没有，（有无人拉。如无，就是自己注册；如有，就是添加密码登陆完善个人信息）
     *         1. 第一次只需要填写电话及密码就行，注册完成登陆成功后，可以做后续的完善信息工作
     *              所以目前，只操作一张基本信息表就行，等完善信息时，操作三张即可
     *         2.  由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *  }
     *  自己找到平台网站注册供应商
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        Date date=new Date();
        //得到 电话 密码
        String cellphone = handleSupplierDetail.getCellphone();
        String password=handleSupplierDetail.getPassword();

        if(StringUtils.isNotBlank(cellphone)){
            //通过 电话 查询数据库中有没有记录, 如果有，就设置密码,完善信息;
            //  如果没有，就继续注册
            TSupplierBasicInfoCriteria criteria = new TSupplierBasicInfoCriteria();
            TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
            if (CollectionUtils.isEmpty(listTSupplierBasicInfos)) {
                if(StringUtils.isNotBlank(password)){
                    //如果没有电话，就可以    自己  进行  注册
                    //将电话，密码信息存入到这个表对象中
                    TSupplierBasicInfo tSupplierBasicInfo=new TSupplierBasicInfo();
                    //设置电话
                    tSupplierBasicInfo.setCellphone(cellphone);
                    //设置密码
                    tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(password));
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
                    tSupplierBasicInfo.setInviterId(new Integer(10000000).longValue() );
                    tSupplierBasicInfo.setInviterCompanyId(4);
                    tSupplierBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);

                    int i=0;
                    try{
                        i=tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
                        //更新数据库， 将主键id设置与operator_id一样，因为是运营商注册，
                        tSupplierBasicInfo.setSupplierId(tSupplierBasicInfo.getId());
                        tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
                        return Result.success(i>0);
                    }catch (BusinessException e){
                        LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                    }catch (Exception e){
                        LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.error(e.getMessage());
                    }
                }else{
                    return Result.error("密码不能空");
                }
            }else{
                //如果有电话，证明是被其他人拉取的，可以直接通过电话与姓名进行登陆，进去直接设置密码，然后完善个人信息
                //也有可能这个电话已经是用户了，存在数据库中了（这种可能性几乎没有,因为是每次注册都是要验证码的。）
                return Result.error("数据库中有这条记录，不能注册，电话要唯一");
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {有误}");
        }
    }

    /**0.5
     * 已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> addPasswordSupplierLogin(HandleSupplierDetail handleSupplierDetail){

        //得到电话 姓名
        String cellphone=handleSupplierDetail.getCellphone();
        String name=handleSupplierDetail.getName();
        /**
         *  依据电话查询数据库中有没有这样一条记录,并且数据库中密码这一项为空，是的就让其设置密码，将状态改成完善信息中
         */
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)) {
            //传入的电话为空，让其调用接口失败
            return Result.error("[供应商注册] StringUtils.isNotBlank(cellphone) || StringUtils.isBlank(name) : {参数异常}");
        }
        subCriteria.andCellphoneEqualTo(cellphone);
        subCriteria.andNameEqualTo(name);
        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tSupplierBasicInfos)) {
            return Result.success(false);
        }
        return Result.success(true);
    }
    /**1
     *    2.由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号
     *      (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *      不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *      )
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> addPasswordSupplier(HandleSupplierDetail handleSupplierDetail){
        Date date=new Date();

        //得到电话 姓名
        String cellphone=handleSupplierDetail.getCellphone();
        String name=handleSupplierDetail.getName();
        /**
         *  依据电话查询数据库中有没有这样一条记录,并且数据库中密码这一项为空，是的就让其设置密码，将状态改成完善信息中
         */
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isBlank(cellphone)) {
            //传入的电话为空，让其调用接口失败
            return Result.error("[供应商注册] StringUtils.isNotBlank(cellphone) : {参数异常}");
        }
        subCriteria.andCellphoneEqualTo(cellphone);
        subCriteria.andNameEqualTo(name);
        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
        if(CollectionUtils.isEmpty(tSupplierBasicInfos)) {
            return Result.error("[供应商注册] 数据库中没有这个电话，名字，必须由别人拉取，或者在平台自己注册");
        }
        //通过电话,名字 能查出这个数据在数据库中 存在
        TSupplierBasicInfo operatorBasic = tSupplierBasicInfos.get(0);
        //然后判断从数据库中查出的这条数据 密码项为空
        String password = operatorBasic.getPassword();

        if(StringUtils.isNotBlank(password)){
            //如果密码不为空，那么只能用电话密码进行登陆，或者你可以在电话与密码那个页面用忘记密码进行登陆,绝对不能用这种方式进行登陆，不安全，
            //因为你的电话与名字可能某些人知道！！！
            return Result.error("如果密码不为空，那么只能用电话密码进行登陆，或者你可以在电话与密码那个页面用忘记密码进行登陆,绝对不能用这种方式进行登陆，不安全，因为你的电话与名字可能某些人知道！！！   您已经设置过密码，请在首页用电话与密码进行登陆。");
        }
        //数据库中 密码项为空，证明这个人是第一次进行登陆，并且是由别人拉取过来的
        //设置一些表中必须的信息
        String inputPassword = handleSupplierDetail.getPassword();
        if(StringUtils.isBlank(inputPassword)){
            return Result.error("密码传参异常");
        }
        operatorBasic.setPassword(MD5Util.MD5EncodeUtf8(inputPassword));
        //完善中
        operatorBasic.setState(Const.STATE.PERFECTING);
        //最后修改更新时间
        operatorBasic.setUpdateAt(date);
        int i=0;
        try{
            //更新数据到表中，完成账号的激活，后续 必须 要完善个人信息，并且审核通过之后 ，状态变为审核 通过，否则其它功能将不可用
            i=tSupplierBasicInfoMapper.updateByExampleSelective(operatorBasic,criteria);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.updateByExampleSelective, 异常信息e={}" , e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商注册] tSupplierBasicInfoMapper.updateByExampleSelective ： 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**2
     *  完善供应商信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {
        //供应商法人id
        Long supplierId = roleDetailInfo.getSupplierId();
        if(supplierId==null){
            return Result.error("[完善供应商信息] supplierId==null : {参数异常}");
        }
        Date date=new Date();

        //设置供应商详情表中的一些信息，并插入一条数据到detail
        TSupplierDetailInfo tSupplierDetailInfo = new TSupplierDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo, tSupplierDetailInfo);
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);
        try{
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
        }catch (BusinessException e) {
            LOGGER.error("[供应商完善信息。详情表增加一条记录] tSupplierDetailInfoMapper.insertSelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商完善信息。详情表增加一条记录] tSupplierDetailInfoMapper.insertSelective : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }


        TSupplierAttachment attachment = new TSupplierAttachment();
        List<Attachment> atts = roleDetailInfo.getAtts();
        for(Attachment att:atts){
            attachment.setSupplierId(supplierId);
            attachment.setCreateAt(date);
            attachment.setUpdateAt(date);
            attachment.setCertificateNumber(att.getCertificateNumber());
            attachment.setCertificateName(att.getCertificateName());
            attachment.setCertificateFilePath(att.getCertificateFilePath());
            attachment.setCertificateType(att.getCertificateType());
            try{
                tSupplierAttachmentMapper.insertSelective(attachment);
            }catch (BusinessException e) {
                LOGGER.error("[供应商完善信息。附件表增加多条记录] tSupplierAttachmentMapper.insertSelective : {}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("[供应商完善信息。附件表增加多条记录] tSupplierAttachmentMapper.insertSelective : {}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        }

        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(supplierId);
         //设置更新日期
        tSupplierBasicInfo.setUpdateAt(date);
        //设置状态为（state）2:已提交     等待被平台审核，审核通过之后 将状态改为 审核通过
        tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
        String name = tSupplierBasicInfo.getName();
        if(StringUtils.isBlank(name)){
            //如果为空,就是自己注册。就要对basic表进行相关的填写
            tSupplierBasicInfo.setName(name);
        }
        try{
            //将修改（增加）的数据更新到其中
            tSupplierBasicInfoMapper.updateByPrimaryKey(tSupplierBasicInfo);
        }catch (BusinessException e) {
            LOGGER.error("[供应商完善信息。主表更新记录] tSupplierBasicInfoMapper.updateByPrimaryKey : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商完善信息。主表更新记录] tSupplierBasicInfoMapper.updateByPrimaryKey : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.success(true);
    }

    //--------------------------平台审核通过之后----------------------------------

    /**3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        //得到当前操作人的用户id
        Long userId = handlerSupplierAddEmployee.getSupplierId();
        if(userId==null){
            return Result.error("[供应商增加一个员工] userId==null : {参数异常}");
        }
        //利用当前用户的id来查询出supplier_id
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(userId);
        Long supplierId = tSupplierBasicInfo.getSupplierId();

        Date date=new Date();
        String name=handlerSupplierAddEmployee.getName();
        String cellphone=handlerSupplierAddEmployee.getCellphone();
        String password=handlerSupplierAddEmployee.getPassword();
        Integer role = handlerSupplierAddEmployee.getRole();

        if(StringUtils.isBlank(name) || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password) || role==null){
            return Result.error("[供应商增加一个员工] StringUtils.isBlank(name) || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password) || role==null ：{传入参数异常}");
        }
        // 创建数据库插入对象
        TSupplierBasicInfo pojo=new TSupplierBasicInfo();
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
        //员工状态3审核通过
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
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

    /**4
     * 根据员工的id来查询基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleSupplierId handleSupplierId) {
        //得到supplierbasic表的id
        Long id= handleSupplierId.getId();
        if(id==null) {
            return Result.error("id!=null 条件有异常");
        }
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        //将时间格式化
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        String createAt = format.format(tSupplierBasicInfo.getCreateAt());
        String updateAt = format.format(tSupplierBasicInfo.getUpdateAt());
        SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
        vo.setCreateAt(createAt);
        vo.setUpdateAt(updateAt);
        BeanUtils.copyProperties(tSupplierBasicInfo,vo);
        return Result.success(vo);
    }

    /**5
     *  供应商通过id修改员工
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
        //设置密码
        tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handlerUpdateSupplierEmployeeById.getPassword()));
        //设置 角色 （管理员，员工）
        tSupplierBasicInfo.setRole(handlerUpdateSupplierEmployeeById.getRole());
        //是否禁用
        tSupplierBasicInfo.setIsForbidden(handlerUpdateSupplierEmployeeById.getIsForbidden());
        //将最新的时间存进去
        tSupplierBasicInfo.setUpdateAt(new Date());
        //更新这条记录
        try{
            return Result.success(tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo)>0);
        }catch (BusinessException e){
            LOGGER.error("[供应商通过id修改员工] BusinessException updateSupplierEmployeeById : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商通过id修改员工] BusinessException updateSupplierEmployeeById : 异常信息e={}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleSupplierId handleSupplierId) {
        //得到员工的id
        Long id=handleSupplierId.getId();
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
        //查出 法人的基本信息
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
        List<Attachment> atts = roleDetailInfo.getAtts();

        for(int i=0;i<tSupplierAttachments.size();i++){
            tSupplierAttachments.get(i).setCertificateType(atts.get(i).getCertificateType());
            tSupplierAttachments.get(i).setCertificateFilePath(atts.get(i).getCertificateFilePath());
            tSupplierAttachments.get(i).setCertificateName(atts.get(i).getCertificateName());
            tSupplierAttachments.get(i).setCertificateNumber(atts.get(i).getCertificateNumber());
        }


//        for(TSupplierAttachment ts:tSupplierAttachments){
//
//
//            if(ts.getCertificateType().equals(AttachmentEnum.BUSINESS_LICENSE.getCode())){
//
//                //营业执照照片url
//                roleDetailInfo.setBusinessLicense(ts.getCertificateFilePath());
//                roleDetailInfo.setBusinessLicenseNumber(ts.getCertificateNumber());
//                continue;
//            }
//            if(ts.getCertificateType().equals(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode())){
//                //资质证书url
//                roleDetailInfo.setQualificationCertificate(ts.getCertificateFilePath());
//                roleDetailInfo.setQualificationCertificateNumber(ts.getCertificateNumber());
//                continue;
//            }
//            if(ts.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode())){
//                //法人身份证正面照片url
//                roleDetailInfo.setLegalIdCardPositive(ts.getCertificateFilePath());
//                roleDetailInfo.setLegalIdCardPositiveNumber(ts.getCertificateNumber());
//                continue;
//            }
//            if(ts.getCertificateType().equals(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode())){
//                //法人身份证反面照片url
//                roleDetailInfo.setLegalIdCardOther(ts.getCertificateFilePath());
//                continue;
//            }
//            if(ts.getCertificateType().equals(AttachmentEnum.OPERATOR_ID_CARD_FRONT.getCode())){
//                //经办人(运营商员工)手持身份证正面照片url
//                roleDetailInfo.setOperatorIdCardFront(ts.getCertificateFilePath());
//                roleDetailInfo.setOperatorIdCardFrontNumber(ts.getCertificateNumber());
//                continue;
//            }
//            if(ts.getCertificateType().equals(AttachmentEnum.CERTIFICATE_OF_AUTHORIZATION.getCode())){
//                //带公章的授权书照片url
//                roleDetailInfo.setCertificateOfAuthorization(ts.getCertificateFilePath());
//                roleDetailInfo.setCertificateOfAuthorizationNumber(ts.getCertificateNumber());
//                continue;
//            }
//        }
        SupplierAttachmentAndDetailVO vo=new SupplierAttachmentAndDetailVO();
        //测试
//        System.out.println(tSupplierDetailInfos.getSupplierId()+"\n"+tSupplierDetailInfos.getPublicBanAccountNumber()+"\n"+
//            tSupplierDetailInfos.getPublicBankName()+"\n"+tSupplierDetailInfos.getId()+"\n"+tSupplierDetailInfos.getCompanyName()
//        );

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

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> findSupplierRecordByCellphone(HandleSupplierCellphone handleSupplierCellphone){
        String cellphone=handleSupplierCellphone.getCellphone();
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

    /**8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleSupplierCellphone handleSupplierCellphone) {
        String cellphone= handleSupplierCellphone.getCellphone();

        if(StringUtils.isBlank(cellphone)) {
            return Result.error("StringUtils.isNotBlank(cellphone) : {参数异常}");
        }

        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
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
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeByisDeleted(HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden){
        Long id=handleSupplierIdAndIsForbidden.getId();
        if(id==null){
            return Result.error("[通过员工id 只 修改员工的状态] id==null : {条件异常}");
        }
        try{
            TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
            tSupplierBasicInfo.setIsForbidden(handleSupplierIdAndIsForbidden.getIsForbidden());
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

    /**10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteSupplierEmployeeById(HandleSupplieIsDeleted handleSupplieIsDeleted) {
        Long id=handleSupplieIsDeleted.getId();
        Integer isDeleted = handleSupplieIsDeleted.getIsDeleted();
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

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
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

    /**12
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateSupplierEmployeeStateById(HandleOperatorState handleOperatorState){
        Long id = handleOperatorState.getId();
        Integer state=handleOperatorState.getState();
//        System.out.println("id + state==="+id+"   "+state);
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

    /**13
     *  忘记密码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> forgetPasswordSupplier(HandleSupplierForgetPassword handleSupplierForgetPassword) {

        //得到手机号,查询数据库中有没有这条数据
        String cellphone=handleSupplierForgetPassword.getCellphone();
        String newPassword = handleSupplierForgetPassword.getPassword();
        if(StringUtils.isBlank(cellphone) || StringUtils.isBlank(newPassword)) {
            return Result.error("[供应商忘记密码] StringUtils.isBlank(cellphone) || StringUtils.isBlank(newPassword) : {参数异常}");
        }
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);
//        System.out.println("cellphone电话：：："+cellphone);
        //查询出一条结果,然后将密码改掉
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
//        System.out.println("通过电话查询出来的对象有多少个   =="+listTSupplierBasicInfos.size());
        if(CollectionUtils.isEmpty(listTSupplierBasicInfos)){
            return Result.error("[供应商忘记密码] tSupplierBasicInfoMapper.selectByExample : {条件异常，查询结果是空}");
        }
        TSupplierBasicInfo tSupplierBasicInfo=listTSupplierBasicInfos.get(0);
        //加密传过来的密码
        tSupplierBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
        tSupplierBasicInfo.setUpdateAt(new Date());
        try{
            //将新密码更新到数据 库中
            tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo, criteria);
        }catch (BusinessException e){
            LOGGER.error("[供应商忘记密码] tSupplierBasicInfoMapper.updateByExampleSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商忘记密码] tSupplierBasicInfoMapper.updateByExampleSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.<Boolean>success(true);
    }


    /**14 :ok
     * 根据员工的名字,角色，是否禁用
     * 来匹配出符合条件的员工返回一个list：
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleSupplierIdAndName handleSupplierIdAndName) {

        //得到操作者本人的id，查出来的是这个供应商底下的员工列表
        Long id=handleSupplierIdAndName.getId();
        //获取输入的名字,来进行模糊查询
        String name=handleSupplierIdAndName.getName();
        //角色是管理员，员工
        Integer role = handleSupplierIdAndName.getRole();
        //是否禁用
        Integer isForbidden = handleSupplierIdAndName.getIsForbidden();
        if(id==null){
            return Result.error("[供应商查询员工列表] id==null  ：{参数异常}");
        }
        //依据操作者id来查出法人id
        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
        Long supplierId = tSupplierBasicInfo.getSupplierId();
        System.out.println("当前用户=="+id+"==下的法人supplierId=="+supplierId);

        //给出查询的条件，查询出符合条件的员工
        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //注意查出的是is_deleted是0（存在）的
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        subCriteria.andSupplierIdEqualTo(supplierId);
        if(role!=null){
            subCriteria.andRoleEqualTo(role);
        }
        if(isForbidden!=null){
            subCriteria.andIsForbiddenEqualTo(isForbidden);
        }
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameLike("%"+name+"%");
        }
        //得到符合符合条件的结果
        List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);

        //放数据的容器
        List<SupplierBasicInfoVO> listVo=new ArrayList<SupplierBasicInfoVO>();
        //装数据
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
     * 重复了，所以注释
     * 由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)
    */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(HandleFindSupplierByInfo handleFindSupplierByInfo){
//
//        Long id=handleFindSupplierByInfo.getId();
//        Integer role=handleFindSupplierByInfo.getRole();
//        Integer isDeleted = handleFindSupplierByInfo.getIsDeleted();
//
//        if(id==null || role==null || isDeleted==null){
//            LOGGER.error("[由员工状态来查询出员工的列表] id==null || role==null || isDeleted==null : {参数异常}");
//            return Result.error("参数异常");
//        }
//
//        // 因为有三种角色，法人，管理员，员工，可能是管理员，所以首先要依据查这个人的id来查出法人id,继而查出法人底下所有的员工
//        //查出法人supplier_id
//        TSupplierBasicInfo tSupplierBasicInfo = tSupplierBasicInfoMapper.selectByPrimaryKey(id);
//        if(tSupplierBasicInfo==null){
//            LOGGER.error("[由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)] tSupplierBasicInfoMapper.selectByPrimaryKey : {}");
//            return Result.error(ErrorMessagesEnum.SELECT_FAILURE);
//        }
//        Long supplierId=tSupplierBasicInfo.getSupplierId();
//
//        if(role==Const.Role.ROLE_CUSTOMER && isDeleted==Const.IS_DELETED.NOT_DELETED){
//            //如果你选的是员工,并且状态是可用的，
//            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
//        }else if(role==Const.Role.ROLE_CUSTOMER && isDeleted==Const.IS_DELETED.IS_DELETED){
//            //如果你选的是员工,并且状态禁用的，
//            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
//        }else if(role==Const.Role.ROLE_ADMIN && isDeleted==Const.IS_DELETED.IS_DELETED){
//            //如果你选的是管理员,并且状态禁用的，
//            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
//        }else if(role==Const.Role.ROLE_ADMIN && isDeleted==Const.IS_DELETED.NOT_DELETED){
//            //如果你选的是管理员,并且状态可用的，
//            return Result.success(findSupplierEmployeeByRoleOrisDeleted(supplierId,role,isDeleted));
//        }else{
//            return Result.error("查询条件异常");
//        }
//    }

   /* *
     *  为上面的实现方法服务，此方法是查出 所有的员工
    */
//    private List<SupplierBasicInfoVO> findSupplierEmployeeByRoleOrisDeleted(Long supplierId,Integer role,Integer isDeleted){
//
//        //查询出所有的员工
//        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
//        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        subCriteria.andRoleEqualTo(role);
//        subCriteria.andSupplierIdEqualTo(supplierId);
//        subCriteria.andIsDeletedEqualTo(isDeleted);
//
//        //给查询出来的结果一个容器，存储查找出来的数据
//        List<SupplierBasicInfoVO> listVO=new ArrayList<SupplierBasicInfoVO>();
//
//        List<TSupplierBasicInfo> tSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
//        //查询这样符合条件的员工
//
//        for(TSupplierBasicInfo single:tSupplierBasicInfos){
//            SupplierBasicInfoVO vo=new SupplierBasicInfoVO();
//            BeanUtils.copyProperties(single,vo);
//            //将时间格式化
//            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
//            vo.setCreateAt(format.format(single.getCreateAt()));
//            vo.setUpdateAt(format.format(single.getUpdateAt()));
//            listVO.add(vo);
//        }
//        return listVO;
//    }

    /**
     * 暂时没用,不知道后期有没有这个需求
     *   依据 用户角色 是法人的情况下，来查出 supplier_id,
    */
//    @Transactional(rollbackFor = Exception.class)
//    public Result<Long> findSupplierIdByRole(Integer role){
//        TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
//        TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        if(role!=null && role==0){
//            subCriteria.andRoleEqualTo(role);
//            return Result.success(tSupplierBasicInfoMapper.selectByExample(criteria).get(0).getId());
//        }else{
//            return Result.error("role!=null && role==0 : {参数异常}");
//        }
//    }


    /**
     * 根据当前登录者查对应的投标项目
     * @param querywithPageHandle
     * @return
     */
    @Override
    public Result querySupplierProject(QuerywithPageHandle querywithPageHandle) {
        List<TTenderMessage> tTenderMessages = tTenderMessageMapper.querySupplierProject(querywithPageHandle.getId());
        return Result.success(tTenderMessages);
    }
}
