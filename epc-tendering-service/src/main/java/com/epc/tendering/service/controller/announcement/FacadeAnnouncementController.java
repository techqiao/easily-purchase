package com.epc.tendering.service.controller.announcement;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.announcement.AnnouncementService;
import com.epc.web.facade.terdering.announcement.FacadeAnnouncementService;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:45
 * <p>@Author : wjq
 */
@RestController
public class FacadeAnnouncementController extends BaseController implements FacadeAnnouncementService {
    @Autowired
    private AnnouncementService announcementService;
    @Override
    public Result<Boolean> insertAnnouncement(@RequestBody HandleAnnouncement handleAnnouncement) {
        return announcementService.insertAnnouncement(handleAnnouncement);
    }

    @Override
    public Result<Boolean> updateAnnouncementStatus(@RequestBody HandleAnnouncementStatus handleAnnouncementStatus) {
        return announcementService.updateAnnouncementStatus(handleAnnouncementStatus);
    }

    @Override
    public Result<Map<String, Object>> getPurchaseProjectAnnouncementList(@RequestBody QueryAnnouncement queryAnnouncement) {
        PageHelper.startPage(queryAnnouncement.getPage(),queryAnnouncement.getRows());
        Result<List<PurchaseProjectAnnouncement>> listResult = announcementService.getPurchaseProjectAnnouncementList(queryAnnouncement);
        PageInfo<PurchaseProjectAnnouncement> pageInfo = new PageInfo<>(listResult.getData());
        return Result.success(getDataTable(pageInfo));
    }

    @Override
    public Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(@RequestBody String type) {
        return announcementService.getAnnouncementListOfficialNetwork(type);
    }
}
