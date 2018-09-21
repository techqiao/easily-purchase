package com.epc.web.client.remoteApi.bidding.file;

import com.epc.web.facade.bidding.FacadeFileUploadService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-bidding-service",fallback = FileHystrix.class)

public interface FileClient extends FacadeFileUploadService {

}