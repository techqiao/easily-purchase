package com.epc.platform.service.service.operator;

import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.administration.facade.operator.handle.HandleOperatorDetailIfo;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;

/**
 * <p>Description : 运营商相关接口
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
public interface OperatorService {
    /**
     * 预添加运营商
     * @param handleOperatorBasicInfo
     * @return
     */
    Result<Boolean> insertOperatorBasicInfo(HandleOperatorBasicInfo handleOperatorBasicInfo);

    /**
     * 运营商完善资料
     * @param handleOperatorDetailIfo
     * @return
     */
    Result<Boolean> insertOperatorDetailInfo(HandleOperatorDetailIfo handleOperatorDetailIfo);
}
