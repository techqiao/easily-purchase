package com.epc.platform.service.service.biddingagency;

import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfo;

import java.util.List;

/**
 * <p>Description : 招标代理机构
 * <p>Date : 2018-09-14 10:31:14
 * <p>@author : lzx
 */
public interface AgencyService {
    /**
     * 预添加招标代理机构
     * @param userBasicInfo
     * @return
     */
    Result<Boolean> insertBiddingAgencyBasicInfo(UserBasicInfo userBasicInfo);
    /**
     * 招标代理机构完善资料
     * @param biddingHandle
     * @return
     */
    Result<Boolean> insertBiddingAgencyDetailInfo(BiddingHandle biddingHandle);

    /**
     * 删除运营商资料
     * @param queryDetailIfo
     * @return
     */
    Result deleteBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo);

    /**根据传入运营商ID查询
     * 查询运营商资料
     * @param queryDetailIfo
     * @return
     */
    Result queryBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo);


    /**
     * 根据传入运营商公司名称模糊查询
     * @param queryDetailIfo
     * @return
     */
    Result selectBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo);

    /**
     * 查询所有
     * @param queryRequest
     * @return
     */
    List<TAgencyDetailInfo> selectAllAgencyByPage(QueryRequest queryRequest);
}
