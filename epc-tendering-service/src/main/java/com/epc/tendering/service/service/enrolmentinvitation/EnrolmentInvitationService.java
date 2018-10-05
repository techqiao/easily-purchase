package com.epc.tendering.service.service.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:41
 * <p>@Author : luozhixin
 * <p>EnrolmentInvitationService
 */
public interface EnrolmentInvitationService {

    /**
     * 供应商报名采购项目
     * @param signUpHandle
     * @return
     */
    Result signUp(SignUpHandle signUpHandle);

    /**
     * 采购人邀请供应商参加采购项目
     * @param invitationHandle
     * @return
     */
    Result invitation(InvitationHandle invitationHandle);
}
