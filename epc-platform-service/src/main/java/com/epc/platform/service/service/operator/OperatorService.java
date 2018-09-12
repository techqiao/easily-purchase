package com.epc.platform.service.service.operator;

import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.common.Result;

/**
 * <p>Description : 运营商相关接口
 * <p>Date : 2018-09-10  19:46
 * <p>@author : wjq
 */
public interface OperatorService {
    /**
     * 预添加运营商
     * @param userBasicInfo
     * @return
     */
    Result<Boolean> insertOperatorBasicInfo(UserBasicInfo userBasicInfo);

    /**
     * 运营商完善资料
     * @param roleDetailIfo
     * @return
     */
    Result<Boolean> insertOperatorDetailInfo(RoleDetailIfo roleDetailIfo);
}
