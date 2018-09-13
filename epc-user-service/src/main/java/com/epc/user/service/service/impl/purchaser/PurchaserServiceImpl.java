package com.epc.user.service.service.impl.purchaser;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.user.service.domain.operator.TOperatorPurchaser;
import com.epc.user.service.domain.purchaser.TPurchaserBasicInfo;
import com.epc.user.service.mapper.operator.TOperatorPurchaserMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserBasicInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserDetailInfoMapper;
import com.epc.user.service.mapper.purchaser.TPurchaserUserMapper;
import com.epc.user.service.service.impl.operator.OperatorServiceImpl;
import com.epc.user.service.service.purchaser.PurchaserService;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PurchaserServiceImpl implements PurchaserService {
    @Autowired
    TPurchaserBasicInfoMapper  tPurchaserBasicInfoMapper;
    @Autowired
    TPurchaserUserMapper tPurchaserUserMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TOperatorPurchaserMapper tOperatorPurchaserMapper;
    /**
     * @Description 新增 采购人员登陆信息
     * @Author lzx
     * @param handleOperator
     * @return
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    public Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType) {

        TPurchaserBasicInfo pojo=new TPurchaserBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.COMMITTED);
        pojo.setRole(roleType);
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);

        try {
            tPurchaserBasicInfoMapper.insertSelective(pojo);
        }catch (BusinessException e) {
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException createPurchaserUserInfo : {}", e);
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    public  Result<Boolean> createOperatePurchaser(HandlePurchaser handleOperator){
        TOperatorPurchaser pojo=new TOperatorPurchaser();
        Date date =new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setOperatorId(handleOperator.getOperatorId());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        try {
            tOperatorPurchaserMapper.insertSelective(pojo);
        }catch (BusinessException e){
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }catch (Exception e){
            LOGGER.error("BusinessException createOperatePurchaser : {}", e);
            return Result.error(ErrorMessagesEnum.INSERT_FAILURE);
        }
        return Result.success();
    }

}