package com.epc.tendering.service.controller.announcement;

import com.epc.common.Result;
import com.epc.tendering.service.service.announcement.AnnouncementService;
import com.epc.web.facade.terdering.announcement.FacadeAnnouncementService;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:45
 * <p>@Author : wjq
 */
@RestController
public class FacadeAnnouncementController implements FacadeAnnouncementService {
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
    public Result<List<PurchaseProjectAnnouncement>> getPurchaseProjectAnnouncementList(@RequestBody QueryAnnouncement queryAnnouncement) {
        return announcementService.getPurchaseProjectAnnouncementList(queryAnnouncement);
    }

    @Override
    public Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(@RequestBody String type) {
        return announcementService.getAnnouncementListOfficialNetwork(type);
    }
}
