package com.epc.administration.facade.operator.biddingAgency;

import com.epc.administration.facade.operator.handle.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * <p>Description : 招标代理机构接口
 */
public interface BiddingAgencyService {
    /**
     * 招标代理机构注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "insertBiddingAgencyBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertBiddingAgencyBasicInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 招标代理机构完善资料
     * @param roleDetailIfo 附件信息
     * @return
     */
    @PostMapping(value = "insertBiddingAgencyDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody RoleDetailIfo roleDetailIfo);


    /**
     * 删除招标代理机构资料
     * @param
     * @return
     */
    @PostMapping(value = "deleteBiddingAgencyDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据id查询招标代理机构详情
     * @param
     * @return
     */
    @PostMapping(value = "queryBiddingAgencyDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result queryBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据模糊name查询招标代理机构详情
     * @param
     * @return
     */
    @PostMapping(value = "selectBiddingAgencyDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result selectBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);




}
