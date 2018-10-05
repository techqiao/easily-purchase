package com.epc.web.client.controller.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.enrolmentinvitation.handle.ClientInvitationHandle;
import com.epc.web.client.controller.enrolmentinvitation.handle.ClientSignUpHandle;
import com.epc.web.client.remoteApi.enrolmentinvitation.EnrolmentInvitationClient;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 15:59
 * <p>@Author : luozhixin
 */
@RestController
@RequestMapping(value = "EnrolmentInvitation")
public class EnrolmentInvitationController  extends BaseController {
    @Autowired
    private EnrolmentInvitationClient enrolmentInvitationClient;

    @ApiOperation(value = "供应商报名采购项目",notes = "供应商报名采购项目")
    @PostMapping(value = "signUp" ,consumes = "application/json,charset=UTF-8")
    public Result signUp(@RequestBody ClientSignUpHandle clientSignUpHandle){
        SignUpHandle signUpHandle = new SignUpHandle();
        BeanUtils.copyProperties(clientSignUpHandle,signUpHandle);
        return enrolmentInvitationClient.signUp(signUpHandle);
    }

    @ApiOperation(value = "采购人邀请供应商参加采购项目",notes = "采购人邀请供应商参加采购项目")
    @PostMapping(value = "signUp" ,consumes = "application/json,charset=UTF-8")
    public Result invitation(@RequestBody ClientInvitationHandle clientInvitationHandle){
        InvitationHandle invitationHandle = new InvitationHandle();
        BeanUtils.copyProperties(clientInvitationHandle,invitationHandle);
        return enrolmentInvitationClient.invitation(invitationHandle);
    }



}
