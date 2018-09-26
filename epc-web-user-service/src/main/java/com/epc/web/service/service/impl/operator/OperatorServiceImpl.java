package com.epc.web.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static sun.plugin2.os.windows.OSVERSIONINFOA.size;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee) {

        Date date =new Date();

        //实例化一个与数据库映射对象
        TOperatorBasicInfo pojo=new TOperatorBasicInfo();
        //将页面的数据来封装到对象中
        pojo.setOperatorId(handleOperatorAddEmployee.getOperatorId());
        pojo.setName(handleOperatorAddEmployee.getName());
        pojo.setPassword(MD5Util.MD5EncodeUtf8(handleOperatorAddEmployee.getPassword()));
        pojo.setCellphone(handleOperatorAddEmployee.getCellphone());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setRole(Const.Role.ROLE_CUSTOMER);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try{
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo)>0);
        }catch (BusinessException e){
            LOGGER.error("exception insertTOperatorBasicInfoMapper{}",e);
            return Result.success(e.getMessage());
        }
    }

    /**
     * 通过员工id来修改员工信息
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
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
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 根据运营商输入的员工姓名来模糊匹配，得到员工列表
     *      查询 哪个运营商下面的哪些员工
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName) {

        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        Long operatorId=handleOperatorFindAllByName.getOperatorId();
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
     *  运营商注册
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> registerOperator(HandleOperator handleOperator) {

        Date date=new Date();

        TOperatorBasicInfo tOperatorBasicInfo=new TOperatorBasicInfo();
        //设置 电话 密码
        String cellphone = handleOperator.getCellphone();
        String password=handleOperator.getPassword();
        if(StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(password)){

            tOperatorBasicInfo.setCellphone(cellphone);
            tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(password));
        }
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

        tOperatorBasicInfoMapper.insertSelective(tOperatorBasicInfo);

        //将主键id设置为operatorId,更新当前插入的数据
        Long id=tOperatorBasicInfo.getId();
        tOperatorBasicInfo.setOperatorId(id);

        return tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo)>0 ? Result.success(true) : Result.success(false);
    }


    /**
     * 依据id查询已经登陆的个人信息
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<OperatorBasicInfoVO> findByName(HandleOperatorId handleOperatorId) {

        Long id=handleOperatorId.getId();
        if(id!=null){
            TOperatorBasicInfo tOperatorBasicInfo = tOperatorBasicInfoMapper.selectByPrimaryKey(id);
            OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
            vo.setCreateAt(format.format(tOperatorBasicInfo.getCreateAt()));
            vo.setUpdateAt(format.format(tOperatorBasicInfo.getUpdateAt()));
            BeanUtils.copyProperties(tOperatorBasicInfo,vo);
            return Result.success(vo);
        }else{
            return Result.error("用户id为空");
        }


//        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
//        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
//        String name=handleOperator.getName();
//        String cellphone=handleOperator.getCellphone();
//        if(StringUtils.isNotBlank(name)){
//            subCriteria.andNameEqualTo(name);
//        }
//        if(StringUtils.isNotBlank(cellphone)){
//            subCriteria.andCellphoneEqualTo(cellphone);
//        }
//        List<TOperatorBasicInfo> list = tOperatorBasicInfoMapper.selectByExample(criteria);
//        OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
//        BeanUtils.copyProperties(list.get(0),vo);
//
//        return Result.success(vo);
    }

    /**
     * 忘记密码
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword) {

        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        //通过手机号查询 数据库中有没有，有就能查到一个对象
        String cellphone=handleOperatorForgetPassword.getCellphone();
        List<TOperatorBasicInfo> tOperatorBasicInfos=null;
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
            tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
        }
        TOperatorBasicInfo tOperatorBasicInfo=null;
        if(tOperatorBasicInfos.size()>0){
            tOperatorBasicInfo = tOperatorBasicInfos.get(0);
        }
        //拿到输入新的密码
        String newPassword = handleOperatorForgetPassword.getPassword();
        System.out.println("你输入新的密码："+newPassword);
        //重新设置密码,更新数据库中的这条记录中的密码
        tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
        int i = tOperatorBasicInfoMapper.updateByExample(tOperatorBasicInfo, criteria);
        return  i>0 ? Result.success(true) : Result.success(false);
    }

    /**
     * @Description:    运营商新增采购人
     * @Author:         linzhixiang
     * @CreateDate:     2018/9/13 9:48
     * @UpdateUser:     linzhixiang
     * @UpdateDate:     2018/9/13 9:48
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> createPurchaseByOperator(HandlePurchaser handlePurchaser){

        //创建公库信息
        TPurchaserBasicInfo pojo=new TPurchaserBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handlePurchaser.getCellPhone());
        pojo.setName(handlePurchaser.getName());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);

        //创建私库信息
        TOperatorPurchaser operator=new TOperatorPurchaser();
        operator.setCellphone(handlePurchaser.getCellPhone());
        operator.setPurchaserName(handlePurchaser.getName());
        operator.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        operator.setState(Const.STATE.REGISTERED);
        operator.setCreateAt(date);
        operator.setUpdateAt(date);

        try {
            tPurchaserBasicInfoMapper.insertSelective(pojo);
            tOperatorPurchaserMapper.insertSelective(operator);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException createPurchaseByOperator : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException createPurchaseByOperator : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @Override
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
                    LOGGER.error("tSupplierBasicInfoMapper.insertSelective : {}",e);
                    return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tSupplierBasicInfoMapper.insertSelective : {}",e);
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
                    LOGGER.error("tSupplierDetailInfoMapper.insertSelective : {}",e);
                    return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tSupplierDetailInfoMapper.insertSelective : {}",e);
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
                System.out.println("000000  id   111111  operator_id :"+id+"   +++   "+operatorId);
                //设置是否删除
                operatorSupplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                try {
                    k=tOperatorSupplierMapper.insertSelective(operatorSupplier);
                    System.out.println("kkkkkkk   k:"+k);
                }catch (BusinessException e){
                    LOGGER.error("tOperatorSupplierMapper.insertSelective : {}",e);
                    return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
                }catch (Exception e){
                    LOGGER.error("tOperatorSupplierMapper.insertSelective : {}",e);
                    return Result.error(e.getMessage());
                }

                return i>0 && j>0 && k>0 ? Result.success(true) : Result.success(false);
            }else{
                return Result.error("StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(name)");
            }
        }else{
            return Result.error("运营商员工id不能为空或非法参数");
        }

    }



}
