package com.epc.mobile.client.remoteApi.terdering.announcement;

import com.epc.web.facade.terdering.announcement.FacadeAnnouncementService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:30
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = AnnouncementHystrix.class)
public interface AnnouncementClient extends FacadeAnnouncementService {
}
