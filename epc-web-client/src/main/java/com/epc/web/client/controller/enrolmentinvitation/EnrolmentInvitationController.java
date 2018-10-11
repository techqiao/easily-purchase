package com.epc.web.client.controller.enrolmentinvitation;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.enrolmentinvitation.handle.*;
import com.epc.web.client.remoteApi.enrolmentinvitation.EnrolmentInvitationClient;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.query.QuerySignUpList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 15:59
 * <p>@Author : luozhixin && linzhixiang
 */
@Api(value = "招投标邀请",tags = "招投标邀请")
@RestController
@RequestMapping(value = "EnrolmentInvitation")
public class EnrolmentInvitationController  extends BaseController {

    @Autowired
    private EnrolmentInvitationClient enrolmentInvitationClient;

    @ApiOperation(value = "供应商报名采购项目(公告入口)",notes = "供应商报名采购项目(公告入口)")
    @PostMapping(value = "signUp",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result signUp(@RequestBody ClientSignUpHandle clientSignUpHandle){
        SignUpHandle signUpHandle = new SignUpHandle();
        BeanUtils.copyProperties(clientSignUpHandle,signUpHandle);
        signUpHandle.setSupplierId(getLoginUser().getBossId());
        return enrolmentInvitationClient.signUp(signUpHandle);
    }

    @ApiOperation(value = "采购人邀请供应商参加采购项目",notes = "采购人邀请供应商参加采购项目")
    @PostMapping(value = "invitation" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result invitation(@RequestBody ClientInvitationHandle clientInvitationHandle){
        InvitationHandle invitationHandle = new InvitationHandle();
        BeanUtils.copyProperties(clientInvitationHandle,invitationHandle);
        invitationHandle.setPurchaserId(getLoginUser().getBossId());
        return enrolmentInvitationClient.invitation(invitationHandle);
    }

    @ApiOperation(value = "供应商收到的邀请列表",notes = "供应商收到的邀请列表")
    @PostMapping(value = "invitationListForSupplier" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result invitationListForSupplier(@RequestBody ClientInvitationForSupplier clientInvitationForSupplier){
        InvitationForSupplierDTO dto=new InvitationForSupplierDTO();
        dto.setSupplierId(getLoginUser().getBossId());
        dto.setSupplierName(getLoginUser().getBossName());
        return enrolmentInvitationClient.invitationListForSupplier(dto);
    }

    @ApiOperation(value = "供应商查看自己的报名列表",notes = "供应商查看自己的报名列表")
    @PostMapping(value = "queryInvitationList" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result queryInvitationList(@RequestBody ClientInvitationForSupplier clientInvitationForSupplier){
        InvitationForSupplierDTO dto=new InvitationForSupplierDTO();
        dto.setSupplierId(getLoginUser().getBossId());
        dto.setSupplierName(getLoginUser().getBossName());
        return enrolmentInvitationClient.queryInvitationList(dto);
    }

    @ApiOperation(value = "采购人查看标段报名列表",notes = "采购人查看标段报名列表")
    @PostMapping(value = "querySignUpList" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result querySignUpList(@RequestBody ClientSignUpList ClientSignUpList){
        QuerySignUpList dto=new QuerySignUpList();
        dto.setPurchaserId(getLoginUser().getBossId());
        BeanUtils.copyProperties(ClientSignUpList,dto);
        return enrolmentInvitationClient.querySignUpList(dto);
    }

    @ApiOperation(value = "供应商确认/拒绝邀请",notes = "供应商确认/拒绝邀请")
    @PostMapping(value = "updateInvitation" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result updateInvitation(@RequestBody ClientInvitation clientInvitation){
        UpdateInvitation dto=new UpdateInvitation();
        BeanUtils.copyProperties(clientInvitation,dto);
        dto.setSupplierId(getLoginUser().getBossId());
        return enrolmentInvitationClient.updateInvitation(dto);
    }
}
