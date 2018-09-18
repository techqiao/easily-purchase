package com.epc.web.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;
import com.epc.web.service.domain.operator.TOperatorPurchaser;
import com.epc.web.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.web.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.web.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserAttachmentMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.web.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.web.service.service.impl.purchaser.PurchaserServiceImpl;
import com.epc.web.service.service.operator.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
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
    @Transactional
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
    @Transactional
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

}
