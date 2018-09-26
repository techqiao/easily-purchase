package com.epc.tendering.service.controller.task;

import com.epc.tendering.service.service.announcement.AnnouncementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>Description : TaskExecutor
 * <p>Date : 2018-03-28 10:45
 * <p>@Author : wjq
 */
@Component("taskExecutor")
public class TaskExecutor {
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutor.class);
    @Autowired
    private AnnouncementService announcementService;
    /**
     * 凌晨跑一次
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void executeCaseData() {
        logger.warn("定时处理失效公告 start......");
        announcementService.handleAnnouncementBiddingEnd();
        logger.warn("定时处理失效公告 end......");
    }

}
