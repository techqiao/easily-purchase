package com.epc.platform.service.controller.biddingagency;

import com.epc.administration.facade.biddingagency.BiddingAgencyService;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfo;
import com.epc.platform.service.service.biddingagency.AgencyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 招标代理机构
 * <p>Date : 2018-09-14 10:31:14
 * <p>@author : lzx
 */
@RestController
public class BiddingAgencyController extends BaseController implements BiddingAgencyService {
    @Autowired
    private AgencyService agencyService;

    /**
     * 招标代理机构注册
     */
    @Override
    public Result<Boolean> insertBiddingAgencyBasicInfo(@RequestBody UserBasicInfo userBasicInfo) {
        return agencyService.insertBiddingAgencyBasicInfo(userBasicInfo);
    }
    /**
     * 招标代理机构资料补全
     */
    @Override
    public Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody BiddingHandle biddingHandle) {
        return agencyService.insertBiddingAgencyDetailInfo(biddingHandle);
    }
    /**
     * 招标代理机构资料删除
     */
    @Override
    public Result<Boolean> deleteBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return agencyService.deleteBiddingAgencyDetailInfo(queryDetailIfo);
    }
    /**
     * 招标代理机构资料查询
     */
    @Override
    public Result<TOperatorDetailInfo> queryBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return agencyService.queryBiddingAgencyDetailInfo(queryDetailIfo);
    }
    /**
     * 招标代理机构资料模糊查询
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result<List<TOperatorDetailInfo>> selectBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return agencyService.selectBiddingAgencyDetailInfo(queryDetailIfo);
    }

    /**
     * 查询所有招标代理机构分页展示
     * @param queryRequest
     * @return
     */
    @Override
    public Result selectAllAgencyByPage(@RequestBody QueryRequest queryRequest) {
        PageHelper.startPage(queryRequest.getPageNum(),queryRequest.getPageSize());
        List<TAgencyDetailInfo> tAgencyDetailInfos = agencyService.selectAllAgencyByPage(queryRequest);
        PageInfo<TAgencyDetailInfo> pageInfo = new PageInfo<>(tAgencyDetailInfos);
        return Result.success(getDataTable(pageInfo)) ;
    }

}
