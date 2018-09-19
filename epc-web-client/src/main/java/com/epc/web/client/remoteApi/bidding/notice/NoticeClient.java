package com.epc.web.client.remoteApi.bidding.notice;

import com.epc.web.facade.bidding.FacadeNoticeService;
import org.springframework.cloud.netflix.feign.FeignClient;
/**
* @Description:  投标接口
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@FeignClient(value = "epc-bidding-service",fallback = NoticeHystrix.class)

public interface NoticeClient extends FacadeNoticeService {

}