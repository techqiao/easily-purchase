package com.epc.tendering.service.service.enrolmentinvitation.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.signup.BInvitation;
import com.epc.tendering.service.domain.signup.BInvitationCriteria;
import com.epc.tendering.service.domain.signup.BSignUp;
import com.epc.tendering.service.domain.supplier.TSupplierBasicInfo;
import com.epc.tendering.service.domain.supplier.TSupplierDetailInfo;
import com.epc.tendering.service.domain.supplier.TSupplierDetailInfoCriteria;
import com.epc.tendering.service.mapper.signup.BInvitationMapper;
import com.epc.tendering.service.mapper.signup.BSignUpMapper;
import com.epc.tendering.service.mapper.supplier.TSupplierBasicInfoMapper;
import com.epc.tendering.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.tendering.service.service.enrolmentinvitation.EnrolmentInvitationService;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.vo.BInvitationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:41
 * <p>@Author : luozhixin && linzhixiang
 * <p>EnrolmentInvitationServiceImpl
 */
@Service
public class EnrolmentInvitationServiceImpl implements EnrolmentInvitationService {

    final  private Logger LOGGER=LoggerFactory.getLogger(Exception.class);
    @Autowired
    private BSignUpMapper bSignUpMapper;
    @Autowired
    private BInvitationMapper bInvitationMapper;
    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
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
        bSignUp.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        return Result.success( bSignUpMapper.insertSelective(bSignUp)>0);
    }

    /**
     * 采购人邀请供应商参加采购项目
     * @param invitationHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result invitation(InvitationHandle invitationHandle) {
        BInvitation bInvitation = new BInvitation();
        for(Long supplierId:invitationHandle.getSupplierList()){
            BeanUtils.copyProperties(invitationHandle,bInvitation);
            Date data = new Date();
            bInvitation.setCreateAt(data);
            bInvitation.setUpdateAt(data);
            bInvitation.setSupplierId(supplierId);
            try{
                //邀请表插入
                bInvitationMapper.insertSelective(bInvitation);
            }catch (Exception e){
                LOGGER.error("UpdateInvitation_"+bInvitation.toString()+"_"+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        return Result.success(true);
    }

    /**
     * 供应商查询邀请列表
     * @param invitationForSupplierDTO
     * @return
     */
    @Override
    public Result<List<BInvitationVO>> invitationListForSupplier(InvitationForSupplierDTO invitationForSupplierDTO) {
        BInvitationCriteria criteria=new BInvitationCriteria();
        BInvitationCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andSupplierIdEqualTo(invitationForSupplierDTO.getSupplierId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<BInvitation> result=bInvitationMapper.selectByExample(criteria);
        List<BInvitationVO> voList=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(BInvitation entity:result){
            BInvitationVO vo=new BInvitationVO();
            BeanUtils.copyProperties(entity,vo);
            String dateString = sdf.format(entity.getCreateAt());
            vo.setCreateAt(dateString);
            vo.setSupplierName(invitationForSupplierDTO.getSupplierName());
            voList.add(vo);
        }
        return Result.success(voList);
    }

    /**
     * 供应商 确认/拒绝 邀请
     * @param updateInvitation
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateInvitation(UpdateInvitation updateInvitation){
        //查询出数据
        BInvitation entity=bInvitationMapper.selectByPrimaryKey(updateInvitation.getId());
        entity.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        SignUpHandle signUpHandle=new SignUpHandle();
        BeanUtils.copyProperties(entity,signUpHandle);
        //更新数据（操作后下次不能查出来）
        try{
            bInvitationMapper.updateByPrimaryKey(entity);
        }catch (Exception e){
            LOGGER.error("UpdateInvitation_"+entity.toString()+"_"+e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error();
        }
        //确认则添加一条报名记录
        if(updateInvitation.getStatus()==true){
            signUp(signUpHandle);
        }
        return Result.success(true);
    }
}