package com.epc.mobile.client.remoteApi.terdering.announcement;

import com.epc.common.Result;
import com.epc.web.facade.terdering.announcement.FacadeAnnouncementService;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:38
 * <p>@Author : wjq
 */
public class AnnouncementHystrix implements FacadeAnnouncementService {
    @Override
    public Result<Boolean> insertAnnouncement(HandleAnnouncement handleAnnouncement) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateAnnouncementStatus(HandleAnnouncementStatus handleAnnouncementStatus) {
        return Result.hystrixError();
    }

    @Override
    public Result<Map<String, Object>> getPurchaseProjectAnnouncementList(QueryAnnouncement queryAnnouncement) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(String type) {
        return Result.hystrixError();
    }
}
