package com.epc.platform.service.service.operator;

import com.epc.platform.service.domain.operator.TOperatorBasicInfo;

/**
 * <p>Description : 运营商相关接口
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
public interface OperatorService {
    /**
     * 预添加运营商
     * @param tOperatorBasicInfo
     * @return
     */
    Boolean insertOperator(TOperatorBasicInfo tOperatorBasicInfo);
}
