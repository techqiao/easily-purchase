package com.epc.web.client.remoteApi.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.web.facade.enrolmentinvitation.FacadeEnrolmentInvitation;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:17
 * <p>@Author : luozhixin
 * <p>EnrolmentInvitationHystrix
 */
public class EnrolmentInvitationHystrix implements FacadeEnrolmentInvitation {
    @Override
    public Result signUp(SignUpHandle signUpHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result invitation(InvitationHandle invitationHandle) {
        return Result.hystrixError();
    }
}
