package com.epc.tendering.service.controller.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.tendering.service.service.enrolmentinvitation.EnrolmentInvitationService;
import com.epc.web.facade.enrolmentinvitation.FacadeEnrolmentInvitation;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:38
 * <p>@Author : luozhixin
 * <p>EnrolmentInvitationController
 */
@RestController
public class EnrolmentInvitationController implements FacadeEnrolmentInvitation {

    @Autowired
    private EnrolmentInvitationService enrolmentInvitationService;


    /**
     * 供应商报名采购项目
     * @param signUpHandle
     * @return
     */
    @Override
    public Result signUp(@RequestBody SignUpHandle signUpHandle) {
        return enrolmentInvitationService.signUp(signUpHandle);
    }

    /**
     * 采购人邀请供应商参加采购项目
     * @param invitationHandle
     * @return
     */
    @Override
    public Result invitation(@RequestBody InvitationHandle invitationHandle) {
        return enrolmentInvitationService.invitation(invitationHandle);
    }

    /**
     * 供应商查询邀请列表
     * @param invitationForSupplierDTO
     * @return
     */
    @Override
    public Result invitationListForSupplier(@RequestBody InvitationForSupplierDTO invitationForSupplierDTO){
        return enrolmentInvitationService.invitationListForSupplier(invitationForSupplierDTO);

    }


    @Override
    public Result updateInvitation(@RequestBody UpdateInvitation updateInvitation){
        return enrolmentInvitationService.updateInvitation(updateInvitation);

    }


}
