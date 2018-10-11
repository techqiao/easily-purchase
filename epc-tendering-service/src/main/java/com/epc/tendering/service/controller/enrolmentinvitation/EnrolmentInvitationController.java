package com.epc.tendering.service.controller.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.tendering.service.domain.signup.BSignUp;
import com.epc.tendering.service.service.enrolmentinvitation.EnrolmentInvitationService;
import com.epc.web.facade.bidding.vo.PayListForAllVO;
import com.epc.web.facade.enrolmentinvitation.FacadeEnrolmentInvitation;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.query.PayForGuarantyDTO;
import com.epc.web.facade.enrolmentinvitation.vo.BSignUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 供应商的采购项目参与列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<BSignUpVO>> queryInvitationList(@RequestBody InvitationForSupplierDTO dto){
        return enrolmentInvitationService.queryInvitationList(dto);
    }

    /**
     * 供应商参与的项目列表保证金支付情况
     * @return
     */
    @Override
    public Result<List<PayListForAllVO>> isPayForGuaranty(@RequestBody PayForGuarantyDTO payForGuarantyDTO){
        return enrolmentInvitationService.isPayForGuaranty(payForGuarantyDTO);
    }

    @Override
    public Result<List<PayListForAllVO>> getBiddingDocumentListForAll(@RequestBody PayForGuarantyDTO payForGuarantyDTO) {
        return enrolmentInvitationService.getBiddingDocumentListForAll(payForGuarantyDTO);
    }

}
