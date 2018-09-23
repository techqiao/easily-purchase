package com.epc.web.client.remoteApi.bidding.moneyPay;

import com.epc.web.facade.bidding.FacadeMoneyPayService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-bidding-service",fallback = MoneyPayHystrix.class)
public interface MoneyPayClient extends FacadeMoneyPayService {

}
