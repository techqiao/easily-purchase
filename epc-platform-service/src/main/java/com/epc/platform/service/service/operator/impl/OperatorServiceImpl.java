package com.epc.platform.service.service.operator.impl;

import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.common.Const;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.platform.service.service.operator.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>Description : 运营商接口实现类
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Autowired
    private TOperatorBasicInfoMapper tOperatorBasicInfoMapper;

    @Override
    public Result<Boolean> insertOperatorBasicInfo(HandleOperatorBasicInfo handleOperator) {
        TOperatorBasicInfo pojo = new TOperatorBasicInfo();
        Date date = new Date();
        pojo.setCellphone(handleOperator.getCellphone());
        pojo.setPassword(handleOperator.getPassword());
        pojo.setCreateAt(date);
        pojo.setUpdateAt(date);
        pojo.setRole(Const.Role.ROLE_CORPORATION);
        pojo.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        pojo.setState(Const.STATE.REGISTERED);
        try {
            return null;
        } catch (Exception e) {
            LOGGER.error("exception insertOperatorBasicInfo : {}", e);
            return null;
        }
    }

    @Override
    public Boolean insertOperatorDetailInfo(TOperatorDetailInfo tOperatorDetailInfo) {
        return null;
    }
}
