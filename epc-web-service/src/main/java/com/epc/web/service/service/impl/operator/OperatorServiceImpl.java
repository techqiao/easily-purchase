package com.epc.web.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.common.util.MD5Util;
import com.epc.web.facade.operator.handle.HandleOperatorAddEmployee;
import com.epc.web.facade.operator.handle.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.handle.HandleOperatorUpdateEmployeeById;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorBasicInfoCriteria;
import com.epc.web.service.domain.operator.TOperatorPurchaser;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.web.service.service.impl.purchaser.PurchaserServiceImpl;
import com.epc.web.service.service.operator.OperatorService;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
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
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TOperatorBasicInfoMapper tOperatorBasicInfoMapper;
    @Autowired
    TPurchaserAttachmentMapper tPurchaserAttachmentMapper;
    @Autowired
    PurchaserServiceImpl purchaserServiceImpl;
    @Autowired
    TPurchaserBasicInfoMapper tPurchaserBasicInfoMapper;
    @Autowired
    TOperatorPurchaserMapper tOperatorPurchaserMapper;

    /**
    * @Description:    新增运营商人员
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 9:48
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 9:48
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> createOperatorBasicInfo(HandleOperator handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date =new Date();
        pojo.setName(handleOperator.getUserName());
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        try {
            return Result.success(tOperatorBasicInfoMapper.insertSelective(pojo) > 0);
        } catch (Exception e) {
            LOGGER.error("exception createOperatorBasicInfo : {}", e);
            return Result.error(e.getMessage());
        }
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


    /*===============================*/


    /**
     * 运营商增加一个员工
     * @author donghuan
     * @param handleOperatorAddEmployee
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee) {
        //实例化一个与数据库映射对象
        TOperatorBasicInfo pojo=new TOperatorBasicInfo();
        //将页面的数据来封装到对象中
        pojo.setName(handleOperatorAddEmployee.getName());
        pojo.setPassword(MD5Util.MD5EncodeUtf8(handleOperatorAddEmployee.getPassword()));
        pojo.setCellphone(handleOperatorAddEmployee.getCellphone());
        pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        pojo.setRole(Const.Role.ROLE_CUSTOMER);
        pojo.setCreateAt(new Date());
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
     * @param handleOperatorUpdateEmployeeById
     * @return
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
     * @param handleOperatorFindAllByName
     * @return
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
        List<OperatorBasicInfoVO> listVO=new ArrayList<>();
        for(TOperatorBasicInfo tOperatorBasicInfo: listTOperatorBasicInfos){
            OperatorBasicInfoVO vo=new OperatorBasicInfoVO();
            BeanUtils.copyProperties(tOperatorBasicInfo,vo);
            listVO.add(vo);
        }
        return Result.success(listVO);
    }


}
