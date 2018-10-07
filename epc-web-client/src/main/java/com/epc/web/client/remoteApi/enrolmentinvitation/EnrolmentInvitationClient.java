package com.epc.web.client.remoteApi.enrolmentinvitation;

import com.epc.web.facade.enrolmentinvitation.FacadeEnrolmentInvitation;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:17
 * <p>@Author : luozhixin
 * <p>EnrolmentInvitationClient
 */
@FeignClient(value = "epc-tendering-service" ,fallback = EnrolmentInvitationHystrix.class)
public interface EnrolmentInvitationClient extends FacadeEnrolmentInvitation {
}
