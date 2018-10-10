package com.epc.tendering.service.service.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.tendering.service.domain.signup.BSignUp;
import com.epc.web.facade.bidding.vo.PayListForAllVO;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.query.PayForGuarantyDTO;
import com.epc.web.facade.enrolmentinvitation.vo.BSignUpVO;

import java.util.List;

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


    /**
     * 供应商参与的采购项目列表
     * @param dto
     * @return
     */
    Result<List<BSignUpVO>> queryInvitationList(InvitationForSupplierDTO dto);

    /**
     * 供应商参与的采购项目列表保证金支付列表
     * @param payForGuarantyDTO
     * @return
     */
    Result<List<PayListForAllVO>> isPayForGuaranty(PayForGuarantyDTO payForGuarantyDTO);
}
