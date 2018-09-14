package com.epc.platform.service.service.reviewexpert;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;

import java.util.List;

public interface ReviewExpertService {
    /**
     * 预添加运营商
     * @param userBasicInfo
     * @return
     */
    Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo);

    /**
     * 运营商完善资料
     * @param
     * @return
     */
    Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle);


    /**
     * 删除运营商资料
     * @param
     * @return
     */
    Result<Boolean> deleteExpertDetailInfo(QueryDetailIfo queryDetailIfo);

    /**
     * 根据传入运营商ID查询
     * 查询运营商资料
     * @param
     * @return
     */
    Result<TOperatorDetailInfo> queryExpertDetailInfo(QueryDetailIfo queryDetailIfo);


    /**
     * 根据传入运营商公司名称模糊查询
     * @param queryDetailIfo
     * @return
     */
    Result<List<TOperatorDetailInfo>> selectExpertDetailInfo(QueryDetailIfo queryDetailIfo);
}
