package com.epc.web.client.remoteApi.bidding.pretrialFile;

import com.epc.web.facade.bidding.FacadeFileUploadService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
* @Description:  投标接口
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@FeignClient(value = "epc-bidding-service",fallback = BiddingHystrix.class)

public interface BiddingClient extends FacadeFileUploadService {

}