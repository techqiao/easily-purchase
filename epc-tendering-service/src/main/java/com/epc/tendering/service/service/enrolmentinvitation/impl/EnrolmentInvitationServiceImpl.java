package com.epc.tendering.service.service.enrolmentinvitation.impl;

import com.epc.common.Result;
import com.epc.tendering.service.domain.signup.BInvitation;
import com.epc.tendering.service.domain.signup.BSignUp;
import com.epc.tendering.service.mapper.signup.BInvitationMapper;
import com.epc.tendering.service.mapper.signup.BSignUpMapper;
import com.epc.tendering.service.service.enrolmentinvitation.EnrolmentInvitationService;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:41
 * <p>@Author : luozhixin
 * <p>EnrolmentInvitationServiceImpl
 */
@Service
public class EnrolmentInvitationServiceImpl implements EnrolmentInvitationService {

    @Autowired
    private BSignUpMapper bSignUpMapper;
    @Autowired
    private BInvitationMapper bInvitationMapper;

    /**
     * * 供应商报名采购项目
     * @param signUpHandle
     * @return
     */
    @Override
    public Result signUp(SignUpHandle signUpHandle) {
        BSignUp bSignUp = new BSignUp();
        BeanUtils.copyProperties(signUpHandle,bSignUp);
        Date date = new Date();
        bSignUp.setCreateAt(date);
        bSignUp.setUpdateAt(date);
        return Result.success( bSignUpMapper.insertSelective(bSignUp)>0);
    }

    /**
     * 采购人要求供应商参加采购项目
     * @param invitationHandle
     * @return
     */
    @Override
    public Result invitation(InvitationHandle invitationHandle) {
        BInvitation bInvitation = new BInvitation();
        BeanUtils.copyProperties(invitationHandle,bInvitation);
        Date data = new Date();
        bInvitation.setCreateAt(data);
        bInvitation.setUpdateAt(data);
        return Result.success(bInvitationMapper.insertSelective(bInvitation)>0);
    }
}
