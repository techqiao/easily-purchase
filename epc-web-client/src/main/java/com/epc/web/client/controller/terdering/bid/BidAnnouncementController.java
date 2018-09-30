package com.epc.web.client.controller.terdering.bid;


import com.epc.common.Result;
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

@Api(value = "唱标业务",tags="唱标业务")
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class BidAnnouncementController {
    @Autowired
    BidAnnouncementClient bidAnnouncementClient;

    /**
     * 新增一条唱标记录
     * @param dto
     * @return
     */
    @ApiOperation(value = "创建唱标记录")
    @PostMapping(value = "insertBidAnnouncement")
    public  Result<Boolean> insertBidAnnouncement(@RequestBody  ClientBidAnnouncement dto){
        HandleBidAnnouncement handleBidAnnouncement=new HandleBidAnnouncement();
        BeanUtils.copyProperties(dto,handleBidAnnouncement);
        return bidAnnouncementClient.insertBidAnnouncement(handleBidAnnouncement);
    }


    /**
     * 根据标段查询 供应商投标报告
     * @param dto
     * @return
     */
    @ApiOperation(value = "根据标段查询供应商投标报告")
    @PostMapping(value = "queryBidAnnouncement")
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(@RequestBody ClientBidAnnouncement dto) {
        QueryBidAnnouncement queryBidAnnouncement=new QueryBidAnnouncement();
        BeanUtils.copyProperties(dto,queryBidAnnouncement);
        return bidAnnouncementClient.queryBidAnnouncement(queryBidAnnouncement);
    }


    @ApiOperation(value = "根据标段查询供应商投标报告")
    @PostMapping(value = "getBidAnnouncementDetail")
    Result<String> getBidAnnouncementDetail(@RequestParam("bidId") Long bidId){
        return bidAnnouncementClient.bidAnnouncementDetail(bidId);
    }

}
