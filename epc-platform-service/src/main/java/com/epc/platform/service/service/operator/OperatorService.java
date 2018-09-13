package com.epc.platform.service.service.operator;

import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;

import java.util.List;

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


    /**
     * 删除运营商资料
     * @param
     * @return
     */
    Result<Boolean> deleteOperatorDetailInfo(QueryDetailIfo queryDetailIfo);

    /**
     * 根据传入运营商ID查询
     * 查询运营商资料
     * @param
     * @return
     */
    Result<TOperatorDetailInfo> queryOperatorDetailInfo(QueryDetailIfo queryDetailIfo);


    /**
     * 根据传入运营商公司名称模糊查询
     * @param queryDetailIfo
     * @return
     */
    Result<List<TOperatorDetailInfo>> selectOperatorDetailInfo(QueryDetailIfo queryDetailIfo);


}
