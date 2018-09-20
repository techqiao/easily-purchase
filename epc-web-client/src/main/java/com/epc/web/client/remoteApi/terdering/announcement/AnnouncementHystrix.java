package com.epc.web.client.remoteApi.terdering.announcement;

import com.epc.common.Result;
import com.epc.web.facade.terdering.announcement.FacadeAnnouncementService;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;

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
}
