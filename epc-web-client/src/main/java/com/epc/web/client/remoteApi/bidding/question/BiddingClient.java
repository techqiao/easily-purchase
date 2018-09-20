package com.epc.web.client.remoteApi.bidding.question;

import com.epc.web.facade.bidding.FacadeQuestionService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
* @Description:  投标接口
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@FeignClient(value = "epc-bidding-service",fallback = BiddingHystrix.class)

public interface BiddingClient extends FacadeQuestionService {

}