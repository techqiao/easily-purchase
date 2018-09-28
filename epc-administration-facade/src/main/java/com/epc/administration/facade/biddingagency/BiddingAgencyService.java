package com.epc.administration.facade.biddingagency;

import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.administration.facade.biddingagency.handle.UserBasicInfo;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>Description : 招标代理机构接口
 * @author luozhixin
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
     * @param biddingHandle 附件信息
     * @return
     */
    @PostMapping(value = "insertBiddingAgencyDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody BiddingHandle biddingHandle);


    /**
     * 删除招标代理机构资料
     * @param whereId
     * @return
     */
    @GetMapping(value = "deleteBiddingAgencyDetailInfo" )
    Result<Boolean> deleteBiddingAgencyDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询招标代理机构详情
     * @param whereId
     * @return
     */
    @GetMapping(value = "queryBiddingAgencyDetailInfo" )
    Result queryBiddingAgencyDetailInfo(@RequestParam("whereId") Long whereId);


    /**
     * 查询所有招标代理机构分页
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectAllByPage" ,consumes = "application/json; charset=UTF-8")
    Result selectAllAgencyByPage(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 审核招标代理机构
     * @param examineAgencyHandle
     * @return
     */
    @PostMapping(value ="examineAgency",consumes =  "application/json; charset=UTF-8")
    Result<Boolean> examineAgency(ExamineAgencyHandle examineAgencyHandle);
}
