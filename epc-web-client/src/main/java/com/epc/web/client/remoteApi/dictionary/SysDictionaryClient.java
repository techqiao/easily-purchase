package com.epc.web.client.remoteApi.dictionary;

import com.epc.web.facade.dictionay.FacadeSysDictionaryService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-platform-service",fallback = SysDictionaryHystrix.class)
public interface SysDictionaryClient extends FacadeSysDictionaryService {
}