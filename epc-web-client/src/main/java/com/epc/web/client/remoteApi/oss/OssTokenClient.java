package com.epc.web.client.remoteApi.oss;

import com.epc.web.client.remoteApi.operator.OperatorHystrix;
import com.epc.web.facade.oss.FacadeOssTokenService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *  对象存储 凭证服务
 * @author SongXing
 * @Date 2018-10-9 14:22:59
 */
@FeignClient(value = "EPC-OSSUTIL-SERVICE",fallback = OssTokenHystrix.class)
public interface OssTokenClient extends FacadeOssTokenService {

}
