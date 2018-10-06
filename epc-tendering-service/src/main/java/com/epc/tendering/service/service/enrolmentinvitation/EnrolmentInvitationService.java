package com.epc.tendering.service.service.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;

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



    /**
     * 供应商查询邀请列表
     * @param invitationForSupplierDTO
     * @return
     */

    Result invitationListForSupplier(InvitationForSupplierDTO invitationForSupplierDTO);


    /**
     * 确认/拒绝
     * @param updateInvitation
     * @return
     */
    Result updateInvitation(UpdateInvitation updateInvitation);

}
