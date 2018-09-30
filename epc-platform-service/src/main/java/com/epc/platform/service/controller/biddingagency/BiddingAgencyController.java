package com.epc.platform.service.controller.biddingagency;

import com.epc.administration.facade.biddingagency.BiddingAgencyService;
import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.AgencyForbiddenHandle;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.administration.facade.biddingagency.handle.UserBasicInfo;
import com.epc.administration.facade.biddingagency.vo.BiddingAgencyVO;
import com.epc.common.Result;
import com.epc.platform.service.controller.admin.BaseController;
import com.epc.platform.service.domain.operator.TOperatorDetailInfo;
import com.epc.platform.service.domain.tagency.TAgencyDetailInfo;
import com.epc.platform.service.service.biddingagency.AgencyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Result<Boolean> deleteBiddingAgencyDetailInfo(@RequestParam("whereId") Long whereId) {
        return agencyService.deleteBiddingAgencyDetailInfo(whereId);
    }
    /**
     * 招标代理机构资料查询
     */
    @Override
    public Result<TOperatorDetailInfo> queryBiddingAgencyDetailInfo(@RequestParam("whereId") Long whereId) {
        return agencyService.queryBiddingAgencyDetailInfo(whereId);
    }

    /**
     * 查询所有招标代理机构分页展示
     * @param queryDetailIfo
     * @return
     */
    @Override
    public Result selectAllAgencyByPage(@RequestBody QueryDetailIfo queryDetailIfo) {
        PageHelper.startPage(queryDetailIfo.getPageNum(),queryDetailIfo.getPageSize());
        List<BiddingAgencyVO> biddingAgencyVOS = agencyService.selectAllAgencyByPage(queryDetailIfo);
        PageInfo<BiddingAgencyVO> pageInfo = new PageInfo<>(biddingAgencyVOS);
        return Result.success(getDataTable(pageInfo)) ;
    }

    /**
     * 审核招标代理结构
     * @param examineAgencyHandle
     * @return
     */
    @Override
    public Result<Boolean> examineAgency(@RequestBody ExamineAgencyHandle examineAgencyHandle) {
        return agencyService.examineAgency( examineAgencyHandle);
    }

    /**
     * 启用禁用招标代理机构
     * @param agencyForbiddenHandle
     * @return
     */
    @Override
    public Result<Boolean> forbiddenAgencyUser(@RequestBody AgencyForbiddenHandle agencyForbiddenHandle) {
        return agencyService.forbiddenAgencyUser(agencyForbiddenHandle);
    }
}
