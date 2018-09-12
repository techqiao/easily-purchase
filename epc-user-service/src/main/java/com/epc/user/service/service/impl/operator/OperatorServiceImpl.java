package com.epc.user.service.service.impl.operator;

import com.epc.common.Const;
import com.epc.user.service.domain.handle.operator.HandleOperator;
import com.epc.user.service.domain.operator.TOperatorBasicInfo;
import com.epc.user.service.domain.operator.TOperatorUser;
import com.epc.user.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.user.service.mapper.operator.TOperatorUserMapper;
import com.epc.user.service.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class OperatorServiceImpl  implements OperatorService {
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
        tOperatorUserMapper.insertSelective(pojo);
    }

    /**
     * 新增运营商人员--法人关系
     */
    @Override
    public Boolean createOperatorUserInfo( HandleOperator handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellPhone());
        pojo.setPassword(handleOperator.getPassWord());
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.AUDIT_SUCCESS);
        pojo.setRole(handleOperator.getRole());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        tOperatorBasicInfoMapper.insertSelective(pojo);
        createOperatorUser(handleOperator,pojo.getId());
        return true;
    }

}
