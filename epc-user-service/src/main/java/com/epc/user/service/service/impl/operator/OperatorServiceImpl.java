package com.epc.user.service.service.impl.operator;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.user.service.domain.handle.operator.HandleOperator;
import com.epc.user.service.domain.operator.TOperatorBasicInfo;
import com.epc.user.service.domain.operator.TOperatorDetailInfo;
import com.epc.user.service.domain.operator.TOperatorUser;
import com.epc.user.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.user.service.mapper.operator.TOperatorUserMapper;
import com.epc.user.service.service.operator.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class OperatorServiceImpl  implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Autowired
    TOperatorUserMapper tOperatorUserMapper;
    @Autowired
    TOperatorBasicInfoMapper tOperatorBasicInfoMapper;

    /**
     * 新增运营商人员信息
     */
    @Override
    public void createOperatorUser(HandleOperator handleOperator,Long userId) {
        TOperatorUser pojo = new TOperatorUser();
        Date date = new Date();
        pojo.setName(handleOperator.getUserName());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setOperatorId(handleOperator.getOperatorId());
        pojo.setUserId(userId);
        try {
            tOperatorUserMapper.insertSelective(pojo);
        } catch (Exception e) {
            LOGGER.error("exception insertOperatorBasicInfo : {}", e);
        }
    }

    /**
     * 新增运营商人员--法人关系
     * @param handleOperator
     * @return
     */
    @Override
    public Result<Boolean> createOperatorUserInfo( HandleOperator handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassWord());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        pojo.setRole(handleOperator.getRole());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        try {
            tOperatorBasicInfoMapper.insertSelective(pojo);
        } catch (Exception e) {
            LOGGER.error("exception insertOperatorBasicInfo : {}", e);
            return  Result.error(e.getMessage());
        }
        createOperatorUser(handleOperator,pojo.getId());
       return Result.success();
    }

    public Result<Boolean> createOperatorAttachment( HandleOperator handleOperator) {

        return null;
    }
}
