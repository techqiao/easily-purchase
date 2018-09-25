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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
     * 运营商通过id来修改员工信息
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        //通过id来查询出一条员工对象信息
        TOperatorBasicInfo pojo = tOperatorBasicInfoMapper.selectByPrimaryKey(handleOperatorUpdateEmployeeById.getId());
        //利用这个对象把最新从网页传输过来的的数据set进去，更新数据库,达到更新的目的

        pojo.setName(handleOperatorUpdateEmployeeById.getName());
        pojo.setCellphone(handleOperatorUpdateEmployeeById.getCellphone());
        pojo.setIsDeleted(handleOperatorUpdateEmployeeById.getIsDeleted());
        try{
            return Result.success(tOperatorBasicInfoMapper.updateByPrimaryKeySelective(pojo)>0);
        }catch (BusinessException e){
            return Result.error(ErrorMessagesEnum.UPDATE_FAILURE);
        }
    }

    /**
     * 根据运营商输入的员工姓名来模糊匹配，得到员工列表
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName) {

        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();

        Long operatorId=handleOperatorFindAllByName.getOperatorId();
        String where=handleOperatorFindAllByName.getName();

        if(StringUtils.isNotBlank(where)){
            subCriteria.andNameLike("%"+where+"%");
        }
        subCriteria.andOperatorIdEqualTo(operatorId);
        List<TOperatorBasicInfo> listTOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria);
        List<OperatorBasicInfoVO> listVO=new ArrayList<OperatorBasicInfoVO>();
        for(TOperatorBasicInfo tOperatorBasicInfo: listTOperatorBasicInfos){
            OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
            BeanUtils.copyProperties(tOperatorBasicInfo,vo);
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
        tOperatorBasicInfo.setCellphone(handleOperator.getCellphone());
        tOperatorBasicInfo.setPassword(MD5Util.MD5EncodeUtf8(handleOperator.getPassword()));

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

        int i = tOperatorBasicInfoMapper.insertSelective(tOperatorBasicInfo);

        //将主键id设置为operatorId,更新当前插入的数据
        Long operatorId=tOperatorBasicInfo.getId();
        tOperatorBasicInfo.setOperatorId(operatorId);
        int i1 = tOperatorBasicInfoMapper.updateByPrimaryKeySelective(tOperatorBasicInfo);

        return i>0 && i1>0 ? Result.success(true) : Result.success(false);
    }



    /**
     * 查询运营商用户信息
     * @author donghuan
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<OperatorBasicInfoVO> findByName(HandleOperator handleOperator) {
        TOperatorBasicInfoCriteria criteria=new TOperatorBasicInfoCriteria();
        TOperatorBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        String name=handleOperator.getName();
        String cellphone=handleOperator.getCellphone();
        if(StringUtils.isNotBlank(name)){
            subCriteria.andNameEqualTo(name);
        }
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        List<TOperatorBasicInfo> list = tOperatorBasicInfoMapper.selectByExample(criteria);
        OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
        BeanUtils.copyProperties(list.get(0),vo);

        return Result.success(vo);
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
        if(StringUtils.isNotBlank(cellphone)){
            subCriteria.andCellphoneEqualTo(cellphone);
        }
        TOperatorBasicInfo tOperatorBasicInfos = tOperatorBasicInfoMapper.selectByExample(criteria).get(0);
        System.out.println("运营商的全部信息："+tOperatorBasicInfos);
        //拿到这个对象
        String newPassword=tOperatorBasicInfos.getPassword();
        System.out.println("newPassword:::"+newPassword);
        //重新设置密码,更新数据库中的这条记录中的密码
        tOperatorBasicInfos.setPassword(newPassword);

        return tOperatorBasicInfoMapper.updateByExample(tOperatorBasicInfos,criteria) >0 ? Result.success(true) : Result.success(false);
    }
    /**
     *    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {
     * //        System.out.println("进来忘记密码方法了");
     *         TSupplierBasicInfoCriteria criteria=new TSupplierBasicInfoCriteria();
     *         TSupplierBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
     *         //得到手机号,查询数据库中有没有这条数据
     *         String cellphone=handleSupplierForgetPassword.getCellphone();
     *         if(StringUtils.isNotBlank(cellphone)){
     *             subCriteria.andCellphoneEqualTo(cellphone);
     * //            System.out.println("电话不为空"+cellphone);
     *         }
     *         //查询出一条结果,然后将密码改掉
     *         List<TSupplierBasicInfo> listTSupplierBasicInfos = tSupplierBasicInfoMapper.selectByExample(criteria);
     *         System.out.println(listTSupplierBasicInfos.get(0).getPassword());
     *         //加密传过来的密码
     *         String newPassword = MD5Util.MD5EncodeUtf8(handleSupplierForgetPassword.getPassword());
     *         TSupplierBasicInfo tSupplierBasicInfo=listTSupplierBasicInfos.get(0);
     *         tSupplierBasicInfo.setPassword(newPassword);
     *         //将新数据更新到数据 库中
     *         return tSupplierBasicInfoMapper.updateByExampleSelective(tSupplierBasicInfo,criteria)>0?Result.<Boolean>success(true):Result.<Boolean>success(false);
     *     }
     */


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
        //电话
        String cellphone=handleCreateSupplerByOperator.getCellphone();
        //公司名称
        String companyName = handleCreateSupplerByOperator.getCompanyName();
        //法人名字
        String name = handleCreateSupplerByOperator.getName();
        //操作人id
        String operatorId=handleCreateSupplerByOperator.getOperatorId();

        /*
            创建公库信息
         */
        /*供应商:法人及其员工基本(登录)信息  表*/
        TSupplierBasicInfo supplierBasic=new TSupplierBasicInfo();
        //设置电话
        supplierBasic.setCellphone(cellphone);
        //创建时间
        supplierBasic.setCreateAt(date);
        //状态已注册
        supplierBasic.setState(Const.STATE.REGISTERED);
        //存在
        supplierBasic.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //供应商名字
        supplierBasic.setName(name);

        /*供应商:审核所需详细信息  表*/
        TSupplierDetailInfo supplierDetail=new TSupplierDetailInfo();
        //供应商的公司名字
        supplierDetail.setCompanyName(companyName);
        //两张表要同步，所以这个也要设置创建时间
        supplierDetail.setCreateAt(date);
        //存在
        supplierDetail.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        /*
            创建私库信息
         */
        TOperatorSupplier operatorSupplier=new TOperatorSupplier();
        //设置手机号(登录账号)
        operatorSupplier.setCellphone(cellphone);
        //设置创建时间
        operatorSupplier.setCreateAt(date);
        //设置状态，已注册
        operatorSupplier.setState(Const.STATE.REGISTERED);
        //设置供应商的姓名
        operatorSupplier.setSupplierName(name);
        //设置来源

        //设置操作人ID
        operatorSupplier.setOperatorId(operatorId);
        //设置是否删除
        operatorSupplier.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        int resultSupplierBasic = tSupplierBasicInfoMapper.insertSelective(supplierBasic);
        int resultSupplierDetail = tSupplierDetailInfoMapper.insertSelective(supplierDetail);
        int resultOperator = tOperatorSupplierMapper.insertSelective(operatorSupplier);
        return resultSupplierBasic>0 && resultSupplierDetail>0 && resultOperator>0 ? Result.success(true) : Result.success(false);
    }






}
