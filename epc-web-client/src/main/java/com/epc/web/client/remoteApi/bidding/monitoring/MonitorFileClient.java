package com.epc.web.client.remoteApi.bidding.monitoring;
import com.epc.web.facade.bidding.FacadeFileMonitorService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-bidding-service",fallback = MonitorFileHystrix.class)
public interface MonitorFileClient extends FacadeFileMonitorService {

}
