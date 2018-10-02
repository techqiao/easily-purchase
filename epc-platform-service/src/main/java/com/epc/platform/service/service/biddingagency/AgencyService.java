package com.epc.platform.service.service.biddingagency;

import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.AgencyForbiddenHandle;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.administration.facade.biddingagency.handle.UserBasicInfo;
import com.epc.administration.facade.biddingagency.vo.BiddingAgencyVO;
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
     * 招标代理机构完善资料
     * @param biddingHandle
     * @return
     */
    Result<Boolean> updateBiddingAgencyDetailInfo(BiddingHandle biddingHandle);

    /**
     * 删除运营商资料
     * @param whereid
     * @return
     */
    Result deleteBiddingAgencyDetailInfo(Long  whereid);

    /**根据传入运营商ID查询
     * 查询运营商资料
     * @param whereId
     * @return
     */
    Result queryBiddingAgencyDetailInfo(Long whereId);
    /**
     * 查询所有
     * @param queryDetailIfo
     * @return
     */
    List<BiddingAgencyVO> selectAllAgencyByPage(QueryDetailIfo queryDetailIfo);

    /**
     * 审核招标代理机构
     * @param examineAgencyHandle
     * @return
     */
    Result<Boolean> examineAgency(ExamineAgencyHandle examineAgencyHandle);

    /**
     * 锁定招标代理机构
     * @param agencyForbiddenHandle
     * @return
     */
    Result<Boolean> forbiddenAgencyUser(AgencyForbiddenHandle agencyForbiddenHandle);
}
