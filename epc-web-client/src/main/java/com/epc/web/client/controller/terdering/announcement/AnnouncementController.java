package com.epc.web.client.controller.terdering.announcement;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.announcement.handle.ClientHandleAnnouncement;
import com.epc.web.client.controller.terdering.announcement.handle.ClientHandleAnnouncementStatus;
import com.epc.web.client.controller.terdering.announcement.query.ClientQueryAnnouncement;
import com.epc.web.client.remoteApi.terdering.announcement.AnnouncementClient;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:27
 * <p>@Author : wjq
 */
@Api(value = "招标公告服务",tags = {"招标公告服务"})
@RestController
@RequestMapping(value = "/announcement", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AnnouncementController extends BaseController {

    @Autowired
    private AnnouncementClient announcementClient;

    @ApiOperation(value = "添加|修改|刪除公告")
    @PostMapping(value="/insertAnnouncement", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertAnnouncement(@RequestBody ClientHandleAnnouncement clientHandleAnnouncement){
        HandleAnnouncement handleBidsBasicInfo = new HandleAnnouncement();
        BeanUtils.copyProperties(clientHandleAnnouncement, handleBidsBasicInfo);
        handleBidsBasicInfo.setOperateId(getLoginUser().getUserId());
        handleBidsBasicInfo.setCreator(getLoginUser().getName());
        return announcementClient.insertAnnouncement(handleBidsBasicInfo);
    }

    @ApiOperation(value = "公告状态 审批审核发布提交")
    @PostMapping(value="/updateAnnouncementStatus", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateAnnouncementStatus(@RequestBody ClientHandleAnnouncementStatus clientHandleAnnouncementStatus){
        HandleAnnouncementStatus handleAnnouncementStatus = new HandleAnnouncementStatus();
        BeanUtils.copyProperties(clientHandleAnnouncementStatus,handleAnnouncementStatus);
        handleAnnouncementStatus.setOperateId(getLoginUser().getUserId());
        return announcementClient.updateAnnouncementStatus(handleAnnouncementStatus);
    }

    @ApiOperation(value = "监控 ： 项目经理查询相关公告")
    @PostMapping(value = "getPurchaseProjectAnnouncementList", consumes = "application/json; charset=UTF-8")
    public Result<Map<String, Object>> getPurchaseProjectAnnouncementList(@RequestBody ClientQueryAnnouncement clientQueryAnnouncement){
        QueryAnnouncement queryAnnouncement = new QueryAnnouncement();
        BeanUtils.copyProperties(clientQueryAnnouncement, queryAnnouncement);
        return announcementClient.getPurchaseProjectAnnouncementList(queryAnnouncement);
    }


    @ApiOperation(value = "查询官网相关公告预告")
    @PostMapping(value = "getAnnouncementListOfficialNetwork", consumes = "application/json; charset=UTF-8")
    public Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(@RequestBody String type){
        return announcementClient.getAnnouncementListOfficialNetwork(type);
    }


}
