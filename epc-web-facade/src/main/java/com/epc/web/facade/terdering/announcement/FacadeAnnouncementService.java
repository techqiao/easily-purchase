package com.epc.web.facade.terdering.announcement;

import com.epc.common.Result;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncementVO;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:31
 * <p>@Author : wjq
 */
public interface FacadeAnnouncementService {

    /**
     * 添加预告信息
     * @param handleAnnouncement
     * @return
     */
    @PostMapping(value = "insertAnnouncement", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertAnnouncement(@RequestBody HandleAnnouncement handleAnnouncement);

    /**
     * 公告状态 审核审批发布
     * @param handleAnnouncementStatus
     * @return
     */
    @PostMapping(value = "updateAnnouncementStatus", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateAnnouncementStatus(@RequestBody HandleAnnouncementStatus handleAnnouncementStatus);

    /**
     * 项目经理查询相关公告
     * @param queryAnnouncementVO
     * @return
     */
    @PostMapping(value = "getPurchaseProjectAnnouncementList", consumes = "application/json; charset=UTF-8")
    Result<List<PurchaseProjectAnnouncement>> getPurchaseProjectAnnouncementList(@RequestBody QueryAnnouncementVO queryAnnouncementVO);
}
