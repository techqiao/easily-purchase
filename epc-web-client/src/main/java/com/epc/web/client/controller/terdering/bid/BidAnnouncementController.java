package com.epc.web.client.controller.terdering.bid;


import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientBidAnnouncement;
import com.epc.web.client.remoteApi.terdering.bid.BidAnnouncementClient;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 唱标业务
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Api(value = "唱标业务", tags = "唱标业务")
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BidAnnouncementController extends BaseController {

    @Autowired
    private BidAnnouncementClient bidAnnouncementClient;

    /**
     * 新增一条唱标记录
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "创建唱标记录")
    @PostMapping(value = "insertBidAnnouncement")
    public Result<Boolean> insertBidAnnouncement(@RequestBody ClientBidAnnouncement dto) {
        HandleBidAnnouncement handleBidAnnouncement = new HandleBidAnnouncement();
        BeanUtils.copyProperties(dto, handleBidAnnouncement);
        handleBidAnnouncement.setOperateId(getLoginUser().getUserId());
        handleBidAnnouncement.setCreator(getLoginUser().getName());
        return bidAnnouncementClient.insertBidAnnouncement(handleBidAnnouncement);
    }


    /**
     * 根据标段查询 供应商投标报告
     *
     * @return
     */
    @ApiOperation(value = "根据标段查询供应商投标报告")
    @PostMapping(value = "queryBidAnnouncement")
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(@RequestParam("bidId") Long bidId) {
        return bidAnnouncementClient.queryBidAnnouncement(bidId);
    }


    @ApiOperation(value = "查询供应商投标报详情")
    @GetMapping(value = "getBidAnnouncementDetail")
    public Result<String> getBidAnnouncementDetail(@RequestParam("bidId") Long bidId) {
        return bidAnnouncementClient.bidAnnouncementDetail(bidId);
    }

}
