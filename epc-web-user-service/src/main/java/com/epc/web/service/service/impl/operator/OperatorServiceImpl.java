package com.epc.web.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfoCriteria;
import com.epc.web.service.domain.operator.TOperatorPurchaser;
import com.epc.web.service.domain.operator.TOperatorSupplier;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.domain.supplier.TSupplierDetailInfo;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.web.service.mapper.operator.TOperatorSupplierMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.web.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.web.service.service.operator.OperatorService;
import org.apache.commons.lang3.StringUtils;
import org.apache.el.parser.BooleanNode;
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

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Autowired
    private TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    @Autowired
    private TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;
    @Autowired
    private TOperatorPurchaserMapper tOperatorPurchaserMapper;

    @Autowired
    private TSupplierBasicInfoMapper tSupplierBasicInfoMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private TOperatorSupplierMapper tOperatorSupplierMapper;


    /**
     * 运营商增加一个员工
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee) {

        Date date =new Date();

        Long id=handleOperatorAddEmployee.getId();
        String name=handleOperatorAddEmployee.getName();
        String password=handleOperatorAddEmployee.getPassword();
        String cellphone = handleOperatorAddEmployee.getCellphone();
        if(id!=null && StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(cellphone)){
            //实例化一个与数据库映射对象
            TOperatorBasicInfo pojo=new TOperatorBasicInfo();
            //将页面的数据来封装到对象中
            pojo.setOperatorId(id);
            pojo.setName(name);
            pojo.setPassword(MD5Util.MD5EncodeUtf8(password));
            pojo.setCellphone(cellphone);
            pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            pojo.setRole(Const.Role.ROLE_CUSTOMER);
            pojo.setState(Const.STATE.REGISTERED);
            pojo.setCreateAt(date);
            pojo.setUpdateAt(date);
            try{
                return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo)>0 ? true : false);
            }catch (BusinessException e){
                LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {运营商添加员工}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.success(e.getMessage());
            }
        }else{
            return Result.error("id!=null && StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(cellphone) :{参数异常}");
        }

    }

    /**
     * 通过员工id来修改员工信息
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        //得出员工的id
        Long id=handleOperatorUpdateEmployeeById.getId();

        TOperatorBasicInfo pojo=null;
        if(id!=null){
            //通过id来查询出一条员工对象信息
            pojo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
        }else{
            return Result.error("id为空");
        }
        //利用这个对象把最新从网页传输过来的的数据set进去，更新数据库,达到更新的目的
        pojo.setName(handleOperatorUpdateEmployeeById.getName());
        pojo.setCellphone(handleOperatorUpdateEmployeeById.getCellphone());
        pojo.setPassword(MD5Util.MD5EncodeUtf8(handleOperatorUpdateEmployeeById.getPassword()));
        pojo.setIsDeleted(handleOperatorUpdateEmployeeById.getIsDeleted());
        pojo.setUpdateAt(new Date());
        try{
            return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(pojo)>0);
        }catch (BusinessException e){
            LOGGER.error("tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 依据id来删除一个员工,只是改变is_deleted 为1
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteOperatorEmployeeById(HandleOperatorId handleOperatorId) {
        Long id = handleOperatorId.getId();
        Integer isDeleted = handleOperatorId.getIsDeleted();
        if (id != null && isDeleted!=null) {
            try {

                TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
                tOperatorBasicInfo.setIsDeleted(isDeleted);
                tOperatorBasicInfo.setUpdateAt(new Date());

                return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo)>0);
            } catch (BusinessException e) {
                LOGGER.error("[依据id来删除一个员工] tOperatorBasicInfoMapper.updateByExample : {}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
            } catch (Exception e) {
                LOGGER.error("[依据id来删除一个员工] tOperatorBasicInfoMapper.updateByExample : {}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
        } else {
            LOGGER.error("id != null && isDeleted!=null : {参数异常}");
            return Result.error("id != null && isDeleted!=null : {参数异常}");
        }
    }

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeStateById(HandleOperatorState handleOperatorState){
        Long id = handleOperatorState.getId();
        Integer state=handleOperatorState.getState();
        if(id==null || state==null){
            LOGGER.error("[通过id来修改对应的state] id==null || state==null : {参数异常}");
            return Result.error("[通过id来修改对应的state] id==null || state==null : {参数异常}");
        }
        try{
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            tOperatorBasicInfo.setState(state);
            int i = tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[通过id来修改对应的state] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[通过id来修改对应的state] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        Long id=handleOperatorRole.getId();
        Integer role = handleOperatorRole.getRole();
        if(id==null || role==null){
            LOGGER.error("[根据用户id来修改他的role] id==null || role==null : {参数异常}");
            return Result.error("[根据用户id来修改他的role] id==null || role==null : {参数异常}");
        }
        try{
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            tOperatorBasicInfo.setRole(role);
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

    /**
     *  通过id来改变员工的生命,是否禁用
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeByisDeleted(HandleOperatorId handleOperatorId){
        Long id = handleOperatorId.getId();
        if(id==null){
            return Result.error("[通过员工id 只 修改员工的状态] id==null : {条件异常}");
        }
        try{
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            tOperatorBasicInfo.setIsDeleted(handleOperatorId.getIsDeleted());
            int i = tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
            return Result.success(i>0);
        }catch (BusinessException e){
            LOGGER.error("[通过员工id 只 修改员工的状态] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }catch (Exception e){
            LOGGER.error("[通过员工id 只 修改员工的状态] tOperatorBasicInfoMapper.updateByPrimaryKeySelective : {}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据电话来查找一条记录,返回一个真假值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> findOperatorRecordByCellphone(HandleOperatorCellphone handleOperatorCellphone){
        String cellphone=handleOperatorCellphone.getCellphone();
        System.out.println("电话 cellphone==="+cellphone);
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

    /**
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     *  @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteOperatorEmployeeByCellphone(HandleOperatorCellphone handleOperatorCellphone){
        String cellphone = handleOperatorCellphone.getCellphone();
        if(StringUtils.isNotBlank(cellphone)){
            TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
            TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            //先看这个电话是否在数据中存在
            List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
            if(!CollectionUtils.isEmpty(tOperatorBasicInfos)){
                TOperatorBasicInfo tOperatorBasicInfo=tOperatorBasicInfos.get(0);
                tOperatorBasicInfo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
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
            }else{
                Result.error("[运营商依据电话来删除一个员工] !CollectionUtils.isEmpty(tOperatorBasicInfos) : {参数问题}");
            }
        }
        return Result.error("[依据电话来删除一个员工] StringUtils.isNotBlank(cellphone) : {参数异常}");
    }

    /**
     * 根据运营商输入的员工姓名来模糊匹配，得到员工列表
     *      查询 哪个运营商下面的哪些员工
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName) {

        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        Long operatorId=handleOperatorFindAllByName.getId();
        String where=handleOperatorFindAllByName.getName();

        if(operatorId!=null){
            subCriteria.andOperatorIdEqualTo(operatorId);
        }else{
            return Result.error("运营商id不能为空");
        }
        if(StringUtils.isNotBlank(where)){
            subCriteria.andNameLike("%"+where+"%");
        }
        List<TOperatorBasicInfo> listTOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
        List<OperatorBasicInfoVO> listVO=new ArrayList<OperatorBasicInfoVO>();
        for(TOperatorBasicInfo tOperatorBasicInfo: listTOperatorBasicInfos){
            OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
            BeanUtils.copyProperties(tOperatorBasicInfo,vo);
            /**
             * 设置时间为格式化后的
             */
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(tOperatorBasicInfo.getCreateAt()));
            vo.setUpdateAt(format.format(tOperatorBasicInfo.getUpdateAt()));
            listVO.add(vo);
        }
        return Result.success(listVO);
    }

    /**
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> registerOperator(HandleOperator handleOperator) {
        Date date=new Date();
        //得到 电话 密码
        String cellphone = handleOperator.getCellphone();
        String password=handleOperator.getPassword();

        if(StringUtils.isNotBlank(cellphone)){
            //通过 电话 查询数据库中有没有记录, 如果有，就设置密码,完善信息; 如果没有，就继续注册
            //我这个数据库是没有记录这个电话的
            TOperatorBasicInfoCriteria criteria = new TOperatorBasicInfoCriteria();
            TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TOperatorBasicInfo> listTOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
            if (CollectionUtils.isEmpty(listTOperatorBasicInfos)) {
                if(StringUtils.isNotBlank(password)){
                    //如果没有电话，就可以注册
                    TOperatorBasicInfo tOperatorBasicInfo=new TOperatorBasicInfo();

                    tOperatorBasicInfo.setCellphone(cellphone);
                    tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(password));
                    //短信验证

                    //已注册--完善中。。。
                    tOperatorBasicInfo.setState(Const.STATE.PERFECTING);
                    //法人
                    tOperatorBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
                    //记录创建时间
                    tOperatorBasicInfo.setCreateAt(date);
                    tOperatorBasicInfo.setUpdateAt(date);
                    //已存在
                    tOperatorBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    int i=0;
                    try{
                        i=tOperatorBasicInfoMapper.insertSelective(tOperatorBasicInfo);
                        //更新数据库， 将主键id设置与operator_id一样，因为是运营商注册，
                        tOperatorBasicInfo.setOperatorId(tOperatorBasicInfo.getId());
                        tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);
                    }catch (BusinessException e){
                        LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {运营商注册}",e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                    }catch (Exception e){
                        LOGGER.error("tOperatorBasicInfoMapper.insertSelective : {}",e);
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
     *  运营商注册,(有人拉的，手机与名字都有,只需要设置密码就可以登陆)
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> addPasswordOperator(HandleOperator handleOperator){
        Date date=new Date();

        //得到电话 密码
        String cellphone=handleOperator.getCellphone();
        String password=handleOperator.getPassword();
        //依据电话查询数据库中有没有这样一条记录,有就让其设置密码，将状态改成完善信息中
        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        if(StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(password)){
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
            if(!CollectionUtils.isEmpty(tOperatorBasicInfos)){
                TOperatorBasicInfo operatorBasic = tOperatorBasicInfos.get(0);
                //设置一些表中必须的信息
                operatorBasic.setPassword(MD5Util.MD5EncodeUtf8(password));
                //完善中
                operatorBasic.setState(Const.STATE.PERFECTING);
                //最后修改时间
                operatorBasic.setUpdateAt(date);
                int i=0;
                try{
                    //更新数据到表中，完成账号的激活，后续 必须 要完善个人信息
                    i=tOperatorBasicInfoMapper.updateByExampleSelective(operatorBasic,criteria);
                }catch (BusinessException e){
                    LOGGER.error("tOperatorBasicInfoMapper.updateByExampleSelective ： {由平台拉取完成登陆，更新密码}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tOperatorBasicInfoMapper.updateByExampleSelective ： {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }
                return i>0 ? Result.success(true) : Result.success(false);
            }else{
                return Result.error("没有这个电话，必须由平台拉取，或者在平台注册");
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {有问题}");
        }


    }

    /**
     * 依据id查询已经登陆的个人信息
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<OperatorBasicInfoVO> findByName(HandleOperatorId handleOperatorId) {

        Long id=handleOperatorId.getId();

        if(id!=null){
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
            //格式化时间
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(tOperatorBasicInfo.getCreateAt()));
            vo.setUpdateAt(format.format(tOperatorBasicInfo.getUpdateAt()));
            //将对象copy
            BeanUtils.copyProperties(tOperatorBasicInfo,vo);
            return Result.success(vo);
        }else{
            return Result.error("用户id为空");
        }
    }

    /**
     * 运营商忘记密码
     * @author donghuan
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
        if(StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(newPassword)){
            subCriteria.andCellphoneEqualTo(cellphone);
            List<TOperatorBasicInfo> tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
            if(tOperatorBasicInfos.size()>0){
                TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfos.get(0);
                //重新设置密码,更新数据库中的这条记录中的密码
                tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
                int i=0;
                try{
                    i = tOperatorBasicInfoMapper.updateByExample(tOperatorBasicInfo, criteria);
                }catch (BusinessException e){
                    LOGGER.error("tOperatorBasicInfoMapper.updateByExample : {忘记密码，修改密码}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tOperatorBasicInfoMapper.updateByExample : {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }
                return i>0 ? Result.success(true) : Result.success(false);
            }else {
                return Result.error("你输入的电话有误，数据库没有这个电话");
            }
        }else{
            return Result.error("StringUtils.isNotBlank(cellphone) : {cellphone里面有问题}");
        }
    }

    /**
     * @Description:    运营商新增采购人
     * @Author:         linzhixiang
     * @CreateDate:     2018/9/13 9:48
     * @UpdateUser:     donghuan
     * @UpdateDate:     2018/9/26 16:39
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createPurchaseByOperator(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator){
        Date date = new Date();

        //得到电话 姓名  当前运营商的主键id
        String cellphone=handleCreatePurchaserByOperator.getCellphone();
        String name=handleCreatePurchaserByOperator.getName();
        Long id=handleCreatePurchaserByOperator.getId();

        if(StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(name) && id!=null){
            //创建公库信息
            TPurchaserBasicInfo tPurchaserBasicInfo=new TPurchaserBasicInfo();
            tPurchaserBasicInfo.setCellphone(cellphone);
            tPurchaserBasicInfo.setName(name);
            //设置 邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构

            tPurchaserBasicInfo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            tPurchaserBasicInfo.setState(Const.STATE.REGISTERED);
            tPurchaserBasicInfo.setRole(Const.Role.ROLE_CORPORATION);
            tPurchaserBasicInfo.setCreateAt(date);
            tPurchaserBasicInfo.setUpdateAt(date);

            int i=0;
            int k=0;

            //此id, 采购basic表中的主键id,同时也是采购法人purchaser_id
            Long nowId=null;
            try{
                i=tPurchaserBasicInfoMapper.insertSelective(tPurchaserBasicInfo);
                //将采购这张basic表中的主键id设置到purcheser_id上（同时是员工，也是采购法人）
                nowId = tPurchaserBasicInfo.getId();
                tPurchaserBasicInfo.setPurchaserId(nowId);
                tPurchaserBasicInfoMapper.updateByPrimaryKeySelective(tPurchaserBasicInfo);
            }catch (BusinessException e){
                LOGGER.error("tPurchaserBasicInfoMapper.insertSelective : {运营商添加采购人到公库}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("tPurchaserBasicInfoMapper.insertSelective : {}",e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }

            //创建私库信息
            TOperatorPurchaser tOperatorPurchaser=new TOperatorPurchaser();
            //设置操作人id   （谁加的采购人的员工id---运营商员工id）
            tOperatorPurchaser.setOperatorId(id+"");
            //purchaser_id 采购人的id
            tOperatorPurchaser.setPurchaserId(nowId);
            //设置来源
            tOperatorPurchaser.setSource(handleCreatePurchaserByOperator.getSource());
            tOperatorPurchaser.setCellphone(cellphone);
            tOperatorPurchaser.setPurchaserName(name);
            tOperatorPurchaser.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            tOperatorPurchaser.setState(Const.STATE.REGISTERED);
            tOperatorPurchaser.setCreateAt(date);
            tOperatorPurchaser.setUpdateAt(date);
            try {
                k=tOperatorPurchaserMapper.insertSelective(tOperatorPurchaser);
            }catch (BusinessException e) {
                LOGGER.error("tOperatorPurchaserMapper.insertSelective : {运营商添加采购人到私库}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
            }catch (Exception e){
                LOGGER.error("tOperatorPurchaserMapper.insertSelective : {}", e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error(e.getMessage());
            }
            return i>0 && k>0 ? Result.success(true) : Result.success(false);
        }else{
            return Result.error("传入的cellphone,name,id 有问题,其中id可能为空");
        }
    }

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createSupplierByOperator(HandleCreateSupplerByOperator handleCreateSupplerByOperator) {
        Date date=new Date();

        //运营商员工的主键id    （操作人id）
        Long id=handleCreateSupplerByOperator.getId();

        if(id!=null){

            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            //查出运营商的法人operator_id
            Long operatorId = tOperatorBasicInfo.getOperatorId();

            //公司名称
            String companyName = handleCreateSupplerByOperator.getCompanyName();
            //供应商法人名字
            String name = handleCreateSupplerByOperator.getName();
            //电话
            String cellphone=handleCreateSupplerByOperator.getCellphone();
            if(StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(name)){
                /*
                    创建公库信息
                */
                /*供应商:法人及其员工基本(登录)信息  表*/
                TSupplierBasicInfo supplierBasic=new TSupplierBasicInfo();
                //供应商名字
                supplierBasic.setName(name);
                //设置电话
                supplierBasic.setCellphone(cellphone);
                //创建时间
                supplierBasic.setCreateAt(date);
                supplierBasic.setUpdateAt(date);
                //状态已注册
                supplierBasic.setState(Const.STATE.REGISTERED);
                //存在
                supplierBasic.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                //用户角色(供应商法人)
                supplierBasic.setRole(Const.Role.ROLE_CORPORATION);
                //邀请人类型,0-采购人, 1-运营商, 2-供应商, 3-代理机构
                supplierBasic.setInviterType(Const.INVITER_TYPE.OPERATOR);
                //邀请人Id
                supplierBasic.setInviterId(id);
                //邀请人机构ID
                supplierBasic.setInviterCompanyId(operatorId.intValue());
                //供应商法人supplier_id
                Long nowId=null;

                int i=0;
                int j=0;
                int k=0;
                try {
                    i=tSupplierBasicInfoMapper.insertSelective(supplierBasic);
                    nowId = supplierBasic.getId();
                    supplierBasic.setSupplierId(nowId);
                    tSupplierBasicInfoMapper.updateByPrimaryKeySelective(supplierBasic);
                }catch (BusinessException e){
                    LOGGER.error("tSupplierBasicInfoMapper.insertSelective : {运营商添加供应商basic信息}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tSupplierBasicInfoMapper.insertSelective : {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }

                /*
                   供应商:审核所需详细信息  表
                */
                TSupplierDetailInfo supplierDetail=new TSupplierDetailInfo();
                //供应商的公司名字
                supplierDetail.setCompanyName(companyName);
                //设置supplier_detail表中的supplier_id
                supplierDetail.setSupplierId(nowId);
                //两张表要同步，所以这个也要设置创建时间
                supplierDetail.setCreateAt(date);
                supplierDetail.setUpdateAt(date);
                //统一信用代码
                supplierDetail.setUniformCreditCode(handleCreateSupplerByOperator.getUniformCreditCode());
                //'对公银行名称
                supplierDetail.setPublicBankName(handleCreateSupplerByOperator.getPublicBankName());
                //对公银行账号
                supplierDetail.setPublicBanAccountNumber(handleCreateSupplerByOperator.getPublicBanAccountNumber());
                //存在
                supplierDetail.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                try{
                    j=tSupplierDetailInfoMapper.insertSelective(supplierDetail);
                }catch (BusinessException e){
                    LOGGER.error("tSupplierDetailInfoMapper.insertSelective : {运营商添加供应商detail信息}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tSupplierDetailInfoMapper.insertSelective : {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }

                /*
                    创建运营商私库信息
                */
                TOperatorSupplier operatorSupplier=new TOperatorSupplier();
                //设置手机号(登录账号)
                operatorSupplier.setCellphone(cellphone);
                //设置创建时间
                operatorSupplier.setCreateAt(date);
                operatorSupplier.setUpdateAt(date);
                //设置状态，已注册(错误，暂时不设，因为只是添加到数据库，供应商如果进行登陆时，才开始设置状态)
//                operatorSupplier.setState(Const.STATE.REGISTERED);
                //设置供应商的姓名
                operatorSupplier.setSupplierName(name);
                //设置来源
                operatorSupplier.setSource(handleCreateSupplerByOperator.getSource());
                //设置当前 添加供应商 的操作人ID（添加这个供应商的员工id）
                operatorSupplier.setCreaterId(id);
                //设置运营商(法人)operator_id
                operatorSupplier.setOperatorId(operatorId);
//                System.out.println("000000  id   111111  operator_id :"+id+"   +++   "+operatorId);
                //设置是否删除
                operatorSupplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                //设置角色 supplier_id (是供应商法人)
                operatorSupplier.setSupplierId(nowId);

                try {
//                    k=tOperatorSupplierMapper.insertSelective(operatorSupplier);
                    k=tOperatorSupplierMapper.insert(operatorSupplier);
//                    System.out.println("kkkkkkk   k:"+k);
                }catch (BusinessException e){
                    LOGGER.error("tOperatorSupplierMapper.insert : {运营商添加供应商私库}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tOperatorSupplierMapper.insert : {}",e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error(e.getMessage());
                }
                return i>0 && j>0 && k>0 ? Result.success(true) : Result.success(false);
            }else{
                return Result.error("StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(name)");
            }
        }else{
            return Result.error("运营商员工id不能为空");
        }

    }

}
