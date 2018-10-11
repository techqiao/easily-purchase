package com.epc.web.facade.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.web.facade.bidding.vo.PayListForAllVO;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.query.PayForGuarantyDTO;
import com.epc.web.facade.enrolmentinvitation.query.QuerySignUpList;
import com.epc.web.facade.enrolmentinvitation.vo.BSignUpVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:13
 * <p>@Author : luozhixin
 * <p>FacadeEnrolmentInvitation
 */
public interface FacadeEnrolmentInvitation {

    /**
     * 供应商报名采购项目
     * @param signUpHandle
     * @return
     */
    @PostMapping(value = "signUp",consumes = "application/json;charset=UTF-8")
    Result signUp(@RequestBody SignUpHandle signUpHandle);

    /**
     * 采购人邀请供应商参加采购项目
     * @param invitationHandle
     * @return
     */
    @PostMapping(value ="invitation",consumes = "application/json;charset=UTF-8")
    Result invitation(@RequestBody InvitationHandle invitationHandle);

    /**
     * 供应商查询邀请列表
     * @param invitationForSupplierDTO
     * @return
     */
    @PostMapping(value ="invitationListForSupplier",consumes = "application/json;charset=UTF-8")
    Result invitationListForSupplier(@RequestBody InvitationForSupplierDTO invitationForSupplierDTO);


    /**
     * 同意/拒绝 邀请
     * @param updateInvitation
     * @return
     */
    @PostMapping(value ="updateInvitation",consumes = "application/json;charset=UTF-8")
    Result updateInvitation(@RequestBody UpdateInvitation updateInvitation);


    /**
     * 供应商参与的项目列表
     * @param dto
     * @return
     */
    @PostMapping(value ="queryInvitationList",consumes = "application/json;charset=UTF-8")
    Result<List<BSignUpVO>> queryInvitationList(@RequestBody InvitationForSupplierDTO dto);


    /**
     * 供应商参与的项目列表保证金支付情况
     * @return
     */
    @PostMapping(value ="isPayForGuaranty",consumes = "application/json;charset=UTF-8")
    Result<List<PayListForAllVO>> isPayForGuaranty(@RequestBody PayForGuarantyDTO dto);

    /**
     * 供应商招标文件下载支付情况
     * @return
     */
    @PostMapping(value ="getBiddingDocumentListForAll",consumes = "application/json;charset=UTF-8")
    Result<List<PayListForAllVO>> getBiddingDocumentListForAll(@RequestBody PayForGuarantyDTO payForGuarantyDTO);


    /**
     * 采购人查看报名列表
     * @param dto
     * @return
     */
    @PostMapping(value ="querySignUpList",consumes = "application/json;charset=UTF-8")
    Result querySignUpList(@RequestBody QuerySignUpList dto);
}
