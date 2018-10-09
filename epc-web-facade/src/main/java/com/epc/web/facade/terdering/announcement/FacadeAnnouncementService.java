package com.epc.web.facade.terdering.announcement;

import com.epc.common.Result;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncement;
import com.epc.web.facade.terdering.announcement.handle.HandleAnnouncementStatus;
import com.epc.web.facade.terdering.announcement.query.QueryAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncement;
import com.epc.web.facade.terdering.announcement.vo.PurchaseProjectAnnouncementOfficialNetwork;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:31
 * <p>@Author : wjq
 */
public interface FacadeAnnouncementService {

    /**
     * 添加公告信息
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
     * @param queryAnnouncement
     * @return
     */
    @PostMapping(value = "getPurchaseProjectAnnouncementList", consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> getPurchaseProjectAnnouncementList(@RequestBody QueryAnnouncement queryAnnouncement);


    /**
     * 查询官网相关公告预告
     * @param type
     * @return
     */
    @PostMapping(value = "getAnnouncementListOfficialNetwork", consumes = "application/json; charset=UTF-8")
    Result<List<PurchaseProjectAnnouncementOfficialNetwork>> getAnnouncementListOfficialNetwork(@RequestBody String type);

}
