package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeBidAnnouncementService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-tendering-service",fallback = BidAnnouncementHystrix.class)

public interface BidAnnouncementClient extends FacadeBidAnnouncementService {


}
