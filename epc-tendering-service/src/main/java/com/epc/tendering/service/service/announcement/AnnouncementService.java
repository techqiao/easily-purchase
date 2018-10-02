package com.epc.tendering.service.service.announcement;

import com.epc.common.Result;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:46
 * <p>@Author : wjq
 */
public interface AnnouncementService {
    /**
     * 添加|修改|刪除预告信息
     * @param handleAnnouncement
     * @return
     */
    Result<Boolean> insertAnnouncement( HandleAnnouncement handleAnnouncement);

    /**
     * 公告状态 审核审批发布
     * @param handleAnnouncementStatus
     * @return
     */
    Result<Boolean> updateAnnouncementStatus(HandleAnnouncementStatus handleAnnouncementStatus);

    /**
     * 公告失效
     * @return
     */
    Boolean handleAnnouncementBiddingEnd();

    /**
     * 项目经理查询相关公告
     *
     * @param queryAnnouncement
     * @return
     */
    Result<List<PurchaseProjectAnnouncement>> getPurchaseProjectAnnouncementList(QueryAnnouncement queryAnnouncement);

    /**
     * 查询官网预告公告
     * @param type
     * @return
     */
    Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(String type);

}
