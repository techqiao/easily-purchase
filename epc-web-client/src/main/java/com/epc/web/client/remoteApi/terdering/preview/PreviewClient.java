package com.epc.web.client.remoteApi.terdering.preview;

import com.epc.web.facade.terdering.preview.PreviewService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:27
 * <p>@Author : luozhixin
 * <p>PreviewClient
 */
@FeignClient(value = "epc-tendering-service",fallback = previewHystrix.class)
public interface PreviewClient extends PreviewService {
}
