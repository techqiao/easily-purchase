package com.epc.platform.service.service.operator.impl;

import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.mapper.operator.TOperatorBasicInfoMapper;
import com.epc.platform.service.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Description : 运营商接口实现类
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService{
    @Autowired
    private TOperatorBasicInfoMapper tOperatorBasicInfoMapper;

    @Override
    public Boolean insertOperator(TOperatorBasicInfo tOperatorBasicInfo) {
        return tOperatorBasicInfoMapper.insertSelective(tOperatorBasicInfo) > 0;
    }
}
