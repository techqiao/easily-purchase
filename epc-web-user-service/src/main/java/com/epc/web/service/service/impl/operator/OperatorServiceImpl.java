package com.epc.web.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.HandleFindOperatorAllByIdVO;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;
import com.epc.web.service.domain.operator.*;
import com.epc.web.service.domain.purchaser.TPurchaserAttachment;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.purchaser.TPurchaserDetailInfo;
import com.epc.web.service.domain.supplier.TSupplierAttachment;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.operator.*;
import com.epc.web.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierAttachmentMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.operator.OperatorService;
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
 * 运营商服务
 * @author  donghuan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    //运营商基本表
    @Autowired
    private TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    //运营商附件表
    @Autowired
    private TOperatorAttachmentMapper tOperatorAttachmentMapper;
    //运营商详情表
    @Autowired
    private TOperatorDetailInfoMapper tOperatorDetailInfoMapper;

    //采购人基本表
    @Autowired
    private TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;
    //采购人详情表
    @Autowired
    private TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    //采购人附件表
    @Autowired
    private TPurchaserAttachmentMapper tPurchaserAttachmentMapper;

    //供应商基本表
    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    //供应商详情表
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    //供应商附件表
    @Autowired
    private TSupplierAttachmentMapper tSupplierAttachmentMapper;


    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> registerOperator(HandleOperator handleOperator) {
        Date date=new Date();
        //得到 电话 密码 姓名
        String cellphone = handleOperator.getCellphone();
        String password=handleOperator.getPassword();
        String name = handleOperator.getName();
        Integer systemRole = handleOperator.getSystemRole();

        if(systemRole.intValue()!=Const.LOGIN_USER_TYPE.OPERATOR || StringUtils.isBlank(cellphone) || StringUtils.isBlank(password) || StringUtils.isBlank(name)){
            return Result.success("请填写正确的参数");
        }
        //先查询 数据库中有没有这个电话，有就不能注册
        TOperatorBasicInfoCriteria criteria = new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);
        List<TOperatorBasicInfo> listTOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);

        if(CollectionUtils.isEmpty(listTOperatorBasicInfos)){
            //电话在数据 中不存在,可以注册
            TOperatorBasicInfo tOperatorBasicInfo=new TOperatorBasicInfo();

            tOperatorBasicInfo.setCellphone(cellphone);
            tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(password));
            tOperatorBasicInfo.setName(name);
            //短信验证

            //设置状态 为 完善中。。。
            tOperatorBasicInfo.setState(Const.STATE.PERFECTING);
            //设置角色 为法人
            tOperatorBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
            //记录创建时间
            tOperatorBasicInfo.setCreateAt(date);
            tOperatorBasicInfo.setUpdateAt(date);
            int i=0;
            try{
                i=tOperatorBasicInfoMapper.insertSelective(tOperatorBasicInfo);
                //更新数据库， 将主键id设置与operator_id一样，因为是运营商注册，
                tOperatorBasicInfo.setOperatorId(tOperatorBasicInfo.getId());
                tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
                return Result.success(i>0);
            }catch (BusinessException e){
                LOGGER.error("[] tOperatorBasicInfoMapper.insertSelective : {运营商注册}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        }else{
            //如果依据电话能查出记录，就证明电话在数据库中存在
            //如果有电话，就请直接登陆
            return Result.success("数据库中有这个电话，不能注册，电话要唯一");
        }
    }


    /**0.5
     * 已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Result<Boolean> addPasswordOperatorLogin(HandleOperator handleOperator){
//
//        //得到电话 姓名
//        String cellphone=handleOperator.getCellphone();
//        String name = handleOperator.getName();
//
//        //依据电话查询数据库中有没有这样一条记录,有就让其设置密码，将状态改成完善信息中
//        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
//        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        if(StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)) {
//            return Result.error("[运营商注册] StringUtils.isBlank(cellphone) || StringUtils.isBlank(name) : {参数异常}");
//        }
//        subCriteria.andCellphoneEqualTo(cellphone);
//        subCriteria.andNameEqualTo(name);
//        List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
//
//        if(CollectionUtils.isEmpty(tOperatorBasicInfos)) {
//            return Result.success(false);
//        }
//        return Result.success(true);
//
//    }

    /**1
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Result<Boolean> addPasswordOperator(HandleOperator handleOperator){
//        Date date=new Date();
//
//        //得到电话 姓名
//        String cellphone=handleOperator.getCellphone();
//        String name = handleOperator.getName();
//
//        //依据电话查询数据库中有没有这样一条记录,有就让其设置密码，将状态改成完善信息中
//        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
//        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        if(StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)) {
//            return Result.error("[运营商注册] StringUtils.isBlank(cellphone) || StringUtils.isBlank(name) : {参数异常}");
//        }
//        subCriteria.andCellphoneEqualTo(cellphone);
//        subCriteria.andNameEqualTo(name);
//        List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
//        if(CollectionUtils.isEmpty(tOperatorBasicInfos)) {
//            return Result.error("[运营商注册] 查不到符合条件的信息");
//        }
//        //通过电话,名字 能查出这个数据在数据库中 存在
//        TOperatorBasicInfo operatorBasic = tOperatorBasicInfos.get(0);
//        //然后判断从数据库中查出的这条数据 密码项为空
//        String password = operatorBasic.getPassword();
//
//        if(StringUtils.isNotBlank(password)){
//            //如果密码不为空，那么只能用电话密码进行登陆，或者你可以在电话与密码那个页面用忘记密码进行登陆,绝对不能用这种方式进行登陆，不安全，
//            //因为你的电话与名字可能某些人知道！！
//            return Result.error("如果你由别人拉取，数据库密码不为空，那么只能用电话密码进行登陆，或者你可以在电话与密码那个页面用忘记密码进行登陆,绝对不能用这种方式进行登陆，不安全，因为你的电话与名字可能某些人知道！！！   您已经设置过密码，请在首页用电话与密码进行登陆。");
//        }
//        //数据库中 密码项为空，证明这个人是第一次进行登陆，并且是由别人拉取过来的
//        //设置一些表中必须的信息
//        String inputPassword = handleOperator.getPassword();
//        operatorBasic.setPassword(MD5Util.MD5EncodeUtf8(inputPassword));
//        //完善中
//        operatorBasic.setState(Const.STATE.PERFECTING);
//        //最后修改时间
//        operatorBasic.setUpdateAt(date);
//        int i=0;
//        try{
//            //更新数据到表中，完成账号的激活，后续 必须 要完善个人信息,并且审核通过之后 ，状态变为审核 通过，否则其它功能将不可用
//            tOperatorBasicInfoMapper.updateByExampleSelective(operatorBasic,criteria);
//        }catch (BusinessException e){
//            LOGGER.error("tOperatorBasicInfoMapper.updateByExampleSelective ： {由平台拉取完成登陆，更新密码}",e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
//        }catch (Exception e){
//            LOGGER.error("tOperatorBasicInfoMapper.updateByExampleSelective ： {}",e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return Result.error(e.getMessage());
//        }
//        return  Result.success(true);
//    }


    /**2
     * 完善运营商信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertCompleteOperatorInfo(RoleDetailInfo roleDetailInfo){
        //运营商法人id
        Long supplierId = roleDetailInfo.getSupplierId();
        Integer systemRole = roleDetailInfo.getSystemRole();
        if(supplierId==null || systemRole.intValue()!=Const.INVITER_TYPE.OPERATOR){
            return Result.success("[完善运营商信息] supplierId==null || systemRole.intValue()!=Const.INVITER_TYPE.OPERATOR : {条件异常}");
        }
        Date date=new Date();
        //完善详情表
        TOperatorDetailInfo detailInfo=new TOperatorDetailInfo();
        BeanUtils.copyProperties(roleDetailInfo,detailInfo);
        detailInfo.setOperatorId(supplierId);
        detailInfo.setCreateAt(date);
        detailInfo.setUpdateAt(date);

        try{
            //插入运营商详情表
            tOperatorDetailInfoMapper.insertSelective(detailInfo);
        }catch (BusinessException e){
            LOGGER.error("[供应商完善信息] tOperatorDetailInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商完善信息] tOperatorDetailInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }


        //完善附件表
        TOperatorAttachment attachment=new TOperatorAttachment();
        List<Attachment> atts = roleDetailInfo.getAtts();
        for(Attachment att:atts){
            attachment.setOperatorId(supplierId);
            attachment.setCreateAt(date);
            attachment.setUpdateAt(date);

            attachment.setCertificateFilePath(att.getCertificateFilePath());
            attachment.setCertificateName(att.getCertificateName());
            attachment.setCertificateNumber(att.getCertificateNumber());
            attachment.setCertificateType(att.getCertificateType());

            try{
                tOperatorAttachmentMapper.insertSelective(attachment);
            }catch (BusinessException e){
                LOGGER.error("[供应商完善信息] tOperatorAttachmentMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("[供应商完善信息] tOperatorAttachmentMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        }

        try{
            //将运营商主表中的basic信息更新
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(supplierId);
            //设置更新日期
            tOperatorBasicInfo.setUpdateAt(date);
            //信息完善完成后，将状态改为 （state 2） 已提交
            tOperatorBasicInfo.setState(Const.STATE.COMMITTED);
            //查看basic表中的name有没有值，如果有，证明别人拉取进来的（因为拉取的时候要填入姓名，电话，而自己注册则直接通过手机号就可以）；如果没有，就证明是自己注册的
//            String name = roleDetailInfo.getName();
//            System.out.println("当前完善信息法人的名字:"+name);
//            if(StringUtils.isBlank(tOperatorBasicInfo.getName())){
                //如果为空,就是自己注册。就要对basic表进行相关的填写
//                tOperatorBasicInfo.setName(name);
//                System.out.println("name名字为空 ，完善你的名字，ok "+name);
//            }
            //如果不为空，就只需要更改状态,以及更新时间就可以
            tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
        }catch (BusinessException e){
            LOGGER.error("[供应商完善信息] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[供应商完善信息] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.success(true);
    }




    //--------------------------平台审核通过之后----------------------------------


    /**3
     * 运营商增加一个员工
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee) {

        //得到当前操作者的id，然后得到法人id
        Long id=handleOperatorAddEmployee.getId();
        Integer systemRole = handleOperatorAddEmployee.getSystemRole();
        Integer loginRole = handleOperatorAddEmployee.getLoginRole();

        if(id==null || systemRole.intValue()!=Const.LOGIN_USER_TYPE.OPERATOR || loginRole.intValue()==Const.Role.ROLE_CUSTOMER) {  // 不是运营商 ,或者是 员工
            return Result.success("[运营商增加一个员工] id==null : {条件异常}");
        }

        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        Long operatorId = tOperatorBasicInfo.getOperatorId();

        Date date =new Date();
        // 创建数据库插入对象
        String name=handleOperatorAddEmployee.getName();
        String password=handleOperatorAddEmployee.getPassword();
        String cellphone = handleOperatorAddEmployee.getCellphone();
        Integer role = handleOperatorAddEmployee.getRole();
        if(StringUtils.isBlank(name) && StringUtils.isBlank(password) && StringUtils.isBlank(cellphone) && role==null) {
            return Result.error("[运营商增加一个员工] StringUtils.isBlank(name) && StringUtils.isBlank(password) && StringUtils.isBlank(cellphone) && role==null ：{传入参数异常}");
        }
        //实例化一个与数据库映射对象
        TOperatorBasicInfo pojo=new TOperatorBasicInfo();
        //将页面的数据来封装到对象中
        pojo.setOperatorId(operatorId);
        pojo.setName(name);
        pojo.setPassword(MD5Util.MD5EncodeUtf8(password));
        pojo.setCellphone(cellphone);
        pojo.setRole(role);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try{
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo)>0);
        }catch (BusinessException e){
            LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {运营商添加员工}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.success(e.getMessage());
        }
    }

    /**4
     * 依据id查询已经登陆的个人基本信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<OperatorBasicInfoVO> findByName(HandleOperatorId handleOperatorId) {
        Long id=handleOperatorId.getId();
        if(id==null) {
            return Result.error("用户id为空");
        }
        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
        //格式化时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        vo.setCreateAt(format.format(tOperatorBasicInfo.getCreateAt()));
        vo.setUpdateAt(format.format(tOperatorBasicInfo.getUpdateAt()));
        //将对象copy
        BeanUtils.copyProperties(tOperatorBasicInfo,vo);
        return Result.success(vo);
    }

    /**4.5
     *  依据当前 id 来查询你的个人信息(以当前人的id和各种role来判断查询具体的哪几张表)
     */
    public Result<HandleFindOperatorAllByIdVO> findOperatorAllById(HandleOperatorRole handleOperatorRole){

        Long id = handleOperatorRole.getId();
        Integer role = handleOperatorRole.getRole();

        if(id==null || role==null){
            return Result.error("[运营商查询个人信息] id==null || role==null ：{参数异常}");
        }
        HandleFindOperatorAllByIdVO vo=new HandleFindOperatorAllByIdVO();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");

        switch (role){
            case Const.Role.ROLE_CORPORATION:

                break;
            //是管理员
            case Const.Role.ROLE_ADMIN:
                TOperatorBasicInfo tOperatorBasicInfo1 = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
                BeanUtils.copyProperties(tOperatorBasicInfo1,vo);

                return Result.success(vo);
            //是员工
            case Const.Role.ROLE_CUSTOMER:
                TOperatorBasicInfo tOperatorBasicInfo2 = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
                BeanUtils.copyProperties(tOperatorBasicInfo2,vo);
                return Result.success(vo);
        }

        return null;
    }

    /**5
     * 通过员工id来修改员工信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        //得出员工的id
        Long id=handleOperatorUpdateEmployeeById.getId();
        if(id==null){
            return Result.error("[运营商修改员工信息] id==null : {参数异常}");
        }
        //通过id来查询出一条员工对象信息
        TOperatorBasicInfo pojo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);

        //利用这个对象把最新从网页传输过来的的数据set进去，更新数据库,达到更新的目的
        //设置姓名
        pojo.setName(handleOperatorUpdateEmployeeById.getName());
        //设置电话
        pojo.setCellphone(handleOperatorUpdateEmployeeById.getCellphone());
        //设置密码
//        pojo.setPassword(MD5Util.MD5EncodeUtf8(handleOperatorUpdateEmployeeById.getPassword()));
        //设置 角色 （管理员，员工）
        pojo.setRole(handleOperatorUpdateEmployeeById.getRole());
        //是否禁用
        pojo.setIsForbidden(handleOperatorUpdateEmployeeById.getIsForbidden());
        pojo.setUpdateAt(new Date());
        try{
            //更新员工信息
            return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(pojo)>0);
        }catch (BusinessException e){
            LOGGER.error("tOperatorBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("tOperatorBasicInfoMapper.updateByPrimaryKeySelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> findOperatorRecordByCellphone(HandleOperatorCellphone handleOperatorCellphone){
        String cellphone=handleOperatorCellphone.getCellphone();
//        System.out.println("电话 cellphone==="+cellphone);
        if(StringUtils.isNotBlank(cellphone)){
            TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
            TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
            if(!CollectionUtils.isEmpty(tOperatorBasicInfos)){
                return Result.success(true);
            }else{
                return Result.success(false);
            }
        }else{
            return Result.success(false);
        }
    }

    /**8
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteOperatorEmployeeByCellphone(HandleOperatorCellphone handleOperatorCellphone){
        String cellphone = handleOperatorCellphone.getCellphone();
        Integer isDeleted = handleOperatorCellphone.getIsDeleted();

        if(StringUtils.isBlank(cellphone) || isDeleted==null) {
            return Result.error("[依据电话来删除一个员工] StringUtils.isBlank(cellphone) && isDeleted==null : {参数异常}");
        }
        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCellphoneEqualTo(cellphone);

        //先看这个电话是否在数据中存在
        List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);

        TOperatorBasicInfo tOperatorBasicInfo=tOperatorBasicInfos.get(0);
        tOperatorBasicInfo.setIsDeleted(isDeleted);
        tOperatorBasicInfo.setUpdateAt(new Date());
        try {
            return Result.success(tOperatorBasicInfoMapper.updateByExampleSelective(tOperatorBasicInfo,criteria)>0);
        }catch (BusinessException e){
            LOGGER.error("[运营商依据电话来删除一个员工] tOperatorBasicInfoMapper.updateByExampleSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商依据电话来删除一个员工] tOperatorBasicInfoMapper.updateByExampleSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }

    }

    /**9
     *
     */


    /**10
     * 依据id来删除一个员工,只是改变is_deleted 为1
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteOperatorEmployeeById(HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted) {
        Long id = handleOperatorIdAndIsDeleted.getId();
        Integer isDeleted = handleOperatorIdAndIsDeleted.getIsDeleted();
        if (id == null || isDeleted == null) {
            return Result.error("[运营商依据id删除员工] id != null && isDeleted!=null : {参数异常}");
        }
        try {
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            tOperatorBasicInfo.setIsDeleted(isDeleted);
            tOperatorBasicInfo.setUpdateAt(new Date());
            tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);

        } catch (BusinessException e) {
            LOGGER.error("[运营商依据id来删除一个员工] tOperatorBasicInfoMapper.updateByExample : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        } catch (Exception e) {
            LOGGER.error("[运营商依据id来删除一个员工] tOperatorBasicInfoMapper.updateByExample : {}", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.success(true);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        Long id=handleOperatorRole.getId();
        Integer role = handleOperatorRole.getRole();
        if(id==null || role==null){
            return Result.error("[根据用户id来修改他的role] id==null || role==null : {参数异常}");
        }
        try{
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            tOperatorBasicInfo.setRole(role);
            tOperatorBasicInfo.setUpdateAt(new Date());
            int i = tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[根据用户id来修改他的role] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[根据用户id来修改他的role] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**12
     *  通过id来改变员工是否禁用
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeByisDeleted(HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden){
        Long id = handleOperatorIdAndIsForbidden.getId();
        Integer isForbidden = handleOperatorIdAndIsForbidden.getIsForbidden();
        if(id==null || isForbidden==null){
            return Result.error("[运营商通过id来改变员工是否禁用] id==null || isForbidden==null : {条件异常}");
        }
        try{
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            tOperatorBasicInfo.setIsForbidden(handleOperatorIdAndIsForbidden.getIsForbidden());
            int i = tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[运营商通过id来改变员工是否禁用] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商通过id来改变员工是否禁用] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**13
     * 运营商忘记密码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword) {

        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //通过手机号查询 数据库中有没有，确实有这个人，才能更改密码
        String cellphone=handleOperatorForgetPassword.getCellphone();
        //拿到输入新的密码
        String newPassword=handleOperatorForgetPassword.getPassword();
        if(StringUtils.isBlank(cellphone) || StringUtils.isBlank(newPassword)){
            return Result.error("[运营商忘记密码] StringUtils.isBlank(cellphone) || StringUtils.isBlank(newPassword) : {参数异常}");
        }
        subCriteria.andCellphoneEqualTo(cellphone);
        List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
//        System.out.println("通过电话查询出来的对象有多少个   =="+tOperatorBasicInfos.size());
        if(CollectionUtils.isEmpty(tOperatorBasicInfos)) {
            return Result.error("[运营商忘记密码] tOperatorBasicInfoMapper.selectByExample : {条件异常，查询结果是空}");
        }
        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfos.get(0);
        //重新设置密码,更新数据库中的这条记录中的密码
        tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
        tOperatorBasicInfo.setUpdateAt(new Date());
        try{
            tOperatorBasicInfoMapper.updateByExampleSelective(tOperatorBasicInfo, criteria);
        }catch (BusinessException e){
            LOGGER.error("[运营商忘记密码] tOperatorBasicInfoMapper.updateByExample : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商忘记密码] tOperatorBasicInfoMapper.updateByExample : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.success(true);
    }

    /**14
     * 根据员工的名字,角色，是否禁用
     *     来匹配出符合条件的员工返回一个list：
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName) {
        Long id=handleOperatorFindAllByName.getId();
        //名字
        String name=handleOperatorFindAllByName.getName();
        //是否禁用
        Integer isForbidden = handleOperatorFindAllByName.getIsForbidden();
        //角色是管理员，还是员工
        Integer role = handleOperatorFindAllByName.getRole();
        if(id==null){
            return Result.error("[运营商查询员工列表] id==null : {参数异常}");
        }
        //根据当前操作人的id来得到法人id (因为你所有的查询列表都是基于法人id员工之下)
        TOperatorBasicInfo basic = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        Long operatorId = basic.getOperatorId();

        //给出查询的条件，查询出符合条件的员工列表
        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //注意，is_deleted 为0 （存在） 的
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        subCriteria.andOperatorIdEqualTo(operatorId);
        if(role!=null){
            subCriteria.andRoleEqualTo(role);
        }
        if(isForbidden!=null){
            subCriteria.andIsForbiddenEqualTo(isForbidden);
        }
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameLike("%"+name+"%");
        }

        //得到符合条件的结果
        List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);

        //装入容器
        List<OperatorBasicInfoVO> listVO=new ArrayList<OperatorBasicInfoVO>();
        for(TOperatorBasicInfo single:tOperatorBasicInfos){
            OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
            BeanUtils.copyProperties(single,vo);
            /**
             * 设置时间为格式化后的
             */
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(single.getCreateAt()));
            vo.setUpdateAt(format.format(single.getUpdateAt()));
            listVO.add(vo);
        }
        return Result.success(listVO);
    }

    /**15
     *  运营商新增采购人（包括完善信息）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createPurchaseByOperator(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator){

        //得到电话 姓名  当前运营商的主键id
        String cellphone=handleCreatePurchaserByOperator.getCellphone();
        String name=handleCreatePurchaserByOperator.getName();
        Long id=handleCreatePurchaserByOperator.getId();

        if(id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)) {
            return Result.error("[运营商新增采购人]  id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name) : {参数异常} ");
        }
        Date date = new Date();

        //先查出自己的法人id
        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        Long operatorId = tOperatorBasicInfo.getOperatorId();

        //创建TPurchaserBasicInfo表对象，添加信息
        TPurchaserBasicInfo tPurchaserBasicInfo=new TPurchaserBasicInfo();
        tPurchaserBasicInfo.setCellphone(cellphone);
        tPurchaserBasicInfo.setName(name);
        //设置 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构   1-运营商
        tPurchaserBasicInfo.setInviterType(Const.INVITER_TYPE.OPERATOR);
        //邀请人id
        tPurchaserBasicInfo.setInviterId(id.intValue());
        //邀请机构 id
        tPurchaserBasicInfo.setInviterCompanyId(operatorId.intValue());
        //设置状态，已注册
        tPurchaserBasicInfo.setState(Const.STATE.REGISTERED);
        //邀请人角色
        tPurchaserBasicInfo.setRole(Const.Role.ROLE_CORPORATION);

        tPurchaserBasicInfo.setCreateAt(date);
        tPurchaserBasicInfo.setUpdateAt(date);

        //此id, 采购basic表中的主键id,同时也是采购法人purchaser_id
        Long purchaserId=null;
        try{
            tPurchaserBasicInfoMapper.insertSelective(tPurchaserBasicInfo);
            //将采购这张basic表中的主键id设置到purcheser_id上（同时是员工，也是采购法人）
            purchaserId = tPurchaserBasicInfo.getId();
            tPurchaserBasicInfo.setPurchaserId(purchaserId);
            tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tPurchaserBasicInfo);
        }catch (BusinessException e){
            LOGGER.error("[运营商添加采购人] tPurchaserBasicInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商添加采购人] tPurchaserBasicInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }

        //添加详情表信息
        TPurchaserDetailInfo tPurchaserDetailInfo=new TPurchaserDetailInfo();
        tPurchaserDetailInfo.setPurchaserId(purchaserId);
        //公司名字
        tPurchaserDetailInfo.setCompanyName(handleCreatePurchaserByOperator.getCompanyName());
        //统一信用代码
        tPurchaserDetailInfo.setUniformCreditCode(handleCreatePurchaserByOperator.getUniformCreditCode());
        //对公银行名称
        tPurchaserDetailInfo.setPublicBankName(handleCreatePurchaserByOperator.getPublicBankName());
        //对公银行账号
        tPurchaserDetailInfo.setPublicBanAccountNumber(handleCreatePurchaserByOperator.getPublicBanAccountNumber());

        tPurchaserDetailInfo.setCreateAt(date);
        tPurchaserDetailInfo.setUpdateAt(date);

        try{
            tPurchaserDetailInfoMapper.insertSelective(tPurchaserDetailInfo);
        }catch (BusinessException e){
            LOGGER.error("[运营商添加采购人] tPurchaserDetailInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商添加采购人] tPurchaserDetailInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }

        //拿到全部的附件信息
        List<Attachment> atts = handleCreatePurchaserByOperator.getAtts();

        //添加附件表信息
        TPurchaserAttachment tPurchaserAttachment=new TPurchaserAttachment();
        //完善附件表
        for(Attachment att:atts){
            tPurchaserAttachment.setCertificateType(att.getCertificateType());
            tPurchaserAttachment.setCertificateFilePath(att.getCertificateFilePath());
            tPurchaserAttachment.setCertificateName(att.getCertificateName());
            tPurchaserAttachment.setCertificateNumber(att.getCertificateNumber());
            tPurchaserAttachment.setPurchaserId(purchaserId);
            tPurchaserAttachment.setCreateAt(date);
            tPurchaserAttachment.setUpdateAt(date);
            try {
                tPurchaserAttachmentMapper.insertSelective(tPurchaserAttachment);
            }catch (BusinessException e){
                LOGGER.error("[运营商添加采购人] tPurchaserAttachmentMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("[运营商添加采购人] tPurchaserAttachmentMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        }
        return  Result.success(true);
    }

    /**15.5
     *  查看自己拉的采购人列表,查看采购人的信息
     *      参数:传入当前运营商的id,去采购basic表中去查，看有哪几个采购人是自己拉的
     */
    public Result lookPurchaserByOperatorId(){
        return null;
    }

    /**16
     *  运营商新增采购人（不包括完善信息，只填写姓名，电话）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createPurchaseByOperatorSimple(HandleOperatorCreateSupplier handleOperatorCreateSupplier){

        //得到电话 姓名  当前运营商的主键id
        String cellphone=handleOperatorCreateSupplier.getCellphone();
        String name=handleOperatorCreateSupplier.getName();
        Long id=handleOperatorCreateSupplier.getId();

        if(id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)) {
            return Result.error("[运营商新增采购人]  id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name) : {参数异常} ");
        }
        Date date = new Date();

        //先查出自己的法人id
        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        Long operatorId = tOperatorBasicInfo.getOperatorId();

        //创建TPurchaserBasicInfo表对象，添加信息，插入一条数据
        TPurchaserBasicInfo tPurchaserBasicInfo=new TPurchaserBasicInfo();
        tPurchaserBasicInfo.setCellphone(cellphone);
        tPurchaserBasicInfo.setName(name);
        //设置 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构   1-运营商
        tPurchaserBasicInfo.setInviterType(Const.INVITER_TYPE.OPERATOR);
        //邀请人id
        tPurchaserBasicInfo.setInviterId(id.intValue());
        //邀请机构 id
        tPurchaserBasicInfo.setInviterCompanyId(operatorId.intValue());
        //设置状态，已注册
        tPurchaserBasicInfo.setState(Const.STATE.REGISTERED);
        //邀请人角色
        tPurchaserBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tPurchaserBasicInfo.setCreateAt(date);
        tPurchaserBasicInfo.setUpdateAt(date);

        //此id, 采购basic表中的主键id,同时也是采购法人purchaser_id
        Long purchaserId=null;
        try{
            tPurchaserBasicInfoMapper.insertSelective(tPurchaserBasicInfo);
            //将采购这张basic表中的主键id设置到purcheser_id上（同时是员工，也是采购法人）
            purchaserId = tPurchaserBasicInfo.getId();
            tPurchaserBasicInfo.setPurchaserId(purchaserId);
            tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tPurchaserBasicInfo);
        }catch (BusinessException e){
            LOGGER.error("[运营商添加采购人] tPurchaserBasicInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商添加采购人] tPurchaserBasicInfoMapper.insertSelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return  Result.success(true);
    }

    /**16.5
     *  查看自己拉的供应商列表,查看供应商信息
     *
     */


    /**17
     *  运营商新增供应商  (不包括完善信息,只填 姓名、电话)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> operatorCreateSupplierSimple(HandleOperatorCreateSupplier handleOperatorCreateSupplier){

        //  运营商操作人id
        Long id = handleOperatorCreateSupplier.getId();
        String cellphone = handleOperatorCreateSupplier.getCellphone();
        String name=handleOperatorCreateSupplier.getName();
        if(id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)){
            return Result.error("[运营商新增供应商] id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name) : {参数异常}");
        }
        Date date=new Date();

        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        //  得到当前 运营商法人id
        Long operatorId = tOperatorBasicInfo.getOperatorId();

        /**
         * 创建供应商基本表信息   t_supplier_basic_info
         */
        TSupplierBasicInfo tSupplierBasicInfo=new TSupplierBasicInfo();
        tSupplierBasicInfo.setName(name);
        tSupplierBasicInfo.setCellphone(cellphone);
        //邀请人类型 运营商
        tSupplierBasicInfo.setInviterType(Const.INVITER_TYPE.OPERATOR);
        //邀请人id
        tSupplierBasicInfo.setInviterId(id);
        //邀请人机构 id
        tSupplierBasicInfo.setInviterCompanyId(operatorId.intValue());
        //已注册
        tSupplierBasicInfo.setState(Const.STATE.REGISTERED);
        //法人
        tSupplierBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tSupplierBasicInfo.setCreateAt(date);
        tSupplierBasicInfo.setUpdateAt(date);

        //供应商法人id
        Long supplierId=null;
        try {
            tSupplierBasicInfoMapper.insert(tSupplierBasicInfo);
            supplierId = tSupplierBasicInfo.getId();
            tSupplierBasicInfo.setSupplierId(supplierId);
            tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
        }catch (BusinessException e){
            LOGGER.error("[运营商新增供应商] tSupplierBasicInfoMapper.insert : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商新增供应商] tSupplierBasicInfoMapper.insert : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
        return Result.success(true);
    }


    /**18
     *  运营商新增供应商（包括完善信息）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> operatorCreateSupplier(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator){
        //当前运营商员工的id
        Long id = handleCreatePurchaserByOperator.getId();
        String cellphone = handleCreatePurchaserByOperator.getCellphone();
        String name = handleCreatePurchaserByOperator.getName();
        if(id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name)){
            return Result.error("[运营商新增供应商（包括完善信息）] id==null || StringUtils.isBlank(cellphone) || StringUtils.isBlank(name) : {参数异常}");
        }
        Date date=new Date();
        TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        //得到法人id
        Long operatorId = tOperatorBasicInfo.getOperatorId();

        //创建供应商基本信息对象
        TSupplierBasicInfo tSupplierBasicInfo=new TSupplierBasicInfo();
        tSupplierBasicInfo.setName(name);
        tSupplierBasicInfo.setCellphone(cellphone);
        tSupplierBasicInfo.setInviterType(Const.INVITER_TYPE.OPERATOR);
        tSupplierBasicInfo.setInviterId(id);
        tSupplierBasicInfo.setInviterCompanyId(operatorId.intValue());
        tSupplierBasicInfo.setState(Const.STATE.COMMITTED);
        tSupplierBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
        tSupplierBasicInfo.setCreateAt(date);
        tSupplierBasicInfo.setUpdateAt(date);
        Long supplierId=null;
        try {
            tSupplierBasicInfoMapper.insertSelective(tSupplierBasicInfo);
            supplierId = tSupplierBasicInfo.getId();
            tSupplierBasicInfo.setSupplierId(supplierId);
            tSupplierBasicInfoMapper.updateByPrimaryKeySelective(tSupplierBasicInfo);
        }catch (BusinessException e){
            LOGGER.error("[运营商新增供应商（包括完善信息）] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商新增供应商（包括完善信息）] tSupplierBasicInfoMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }

        //完善供应商详情表
        TSupplierDetailInfo tSupplierDetailInfo=new TSupplierDetailInfo();
        tSupplierDetailInfo.setSupplierId(supplierId);
        tSupplierDetailInfo.setCompanyName(handleCreatePurchaserByOperator.getCompanyName());
        tSupplierDetailInfo.setUniformCreditCode(handleCreatePurchaserByOperator.getUniformCreditCode());
        tSupplierDetailInfo.setPublicBankName(handleCreatePurchaserByOperator.getPublicBankName());
        tSupplierDetailInfo.setPublicBanAccountNumber(handleCreatePurchaserByOperator.getPublicBanAccountNumber());
        tSupplierDetailInfo.setCreateAt(date);
        tSupplierDetailInfo.setUpdateAt(date);
        try {
            tSupplierDetailInfoMapper.insertSelective(tSupplierDetailInfo);
        }catch (BusinessException e){
            LOGGER.error("[运营商新增供应商（包括完善信息）] tSupplierDetailInfoMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("[运营商新增供应商（包括完善信息）] tSupplierDetailInfoMapper.insertSelective : 异常信息e={}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }

        //完善供应商附件表
        TSupplierAttachment tSupplierAttachment=new TSupplierAttachment();
        List<Attachment> atts = handleCreatePurchaserByOperator.getAtts();
        for(Attachment att:atts){
            tSupplierAttachment.setCertificateFilePath(att.getCertificateFilePath());
            tSupplierAttachment.setCertificateName(att.getCertificateName());
            tSupplierAttachment.setCertificateNumber(att.getCertificateNumber());
            tSupplierAttachment.setCertificateType(att.getCertificateType());

            tSupplierAttachment.setSupplierId(supplierId);
            tSupplierAttachment.setCreateAt(date);
            tSupplierAttachment.setUpdateAt(date);
            try {
                tSupplierAttachmentMapper.insertSelective(tSupplierAttachment);
            }catch (BusinessException e){
                LOGGER.error("[运营商新增供应商（包括完善信息）] tSupplierAttachmentMapper.insertSelective : 异常信息e={}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("[运营商新增供应商（包括完善信息）] tSupplierAttachmentMapper.insertSelective : 异常信息e={}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        }
        return  Result.success(true);
    }



    /*-------------------------------------------------*/

    /**(暂时没想到有什么用)
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Result<Boolean> updateOperatorEmployeeStateById(HandleOperatorState handleOperatorState){
//        Long id = handleOperatorState.getId();
//        Integer state=handleOperatorState.getState();
//        if(id==null || state==null){
//            LOGGER.error("[通过id来修改对应的state] id==null || state==null : {参数异常}");
//            return Result.error("[通过id来修改对应的state] id==null || state==null : {参数异常}");
//        }
//        try{
//            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
//            tOperatorBasicInfo.setState(state);
//            int i = tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
//            return Result.success(i>0);
//        }catch (BusinessException e){
//            LOGGER.error("[通过id来修改对应的state] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
//        }catch (Exception e){
//            LOGGER.error("[通过id来修改对应的state] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return Result.error(e.getMessage());
//        }
//    }


}
