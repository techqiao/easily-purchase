package com.epc.tendering.service.service.enrolmentinvitation.impl;
import com.epc.web.facade.bidding.dto.SupplierSignDTO;
import com.google.common.collect.Lists;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.DateTimeUtil;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.domain.project.TProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.*;
import com.epc.tendering.service.domain.signup.BInvitation;
import com.epc.tendering.service.domain.signup.BInvitationCriteria;
import com.epc.tendering.service.domain.signup.BSignUp;
import com.epc.tendering.service.domain.signup.BSignUpCriteria;
import com.epc.tendering.service.mapper.bid.BBidOpeningPayMapper;
import com.epc.tendering.service.mapper.bid.BBidsGuaranteeAmountMapper;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.mapper.project.TProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectFileDownloadMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectFilePayMapper;
import com.epc.tendering.service.mapper.signup.BInvitationMapper;
import com.epc.tendering.service.mapper.signup.BSignUpMapper;
import com.epc.tendering.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.tendering.service.service.enrolmentinvitation.EnrolmentInvitationService;
import com.epc.web.facade.bidding.vo.PayListForAllVO;
import com.epc.web.facade.bidding.vo.QuerySignUpListVO;
import com.epc.web.facade.enrolmentinvitation.handle.InvitationHandle;
import com.epc.web.facade.enrolmentinvitation.handle.SignUpHandle;
import com.epc.web.facade.enrolmentinvitation.handle.UpdateInvitation;
import com.epc.web.facade.enrolmentinvitation.query.InvitationForSupplierDTO;
import com.epc.web.facade.enrolmentinvitation.query.PayForGuarantyDTO;
import com.epc.web.facade.enrolmentinvitation.query.QuerySignUpList;
import com.epc.web.facade.enrolmentinvitation.vo.BInvitationVO;
import com.epc.web.facade.enrolmentinvitation.vo.BSignUpVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
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

    final private Logger LOGGER = LoggerFactory.getLogger(Exception.class);
    @Autowired
    private BSignUpMapper bSignUpMapper;
    @Autowired
    private BInvitationMapper bInvitationMapper;
    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    BBidOpeningPayMapper bBidOpeningPayMapper;
    @Autowired
    BBidsGuaranteeAmountMapper bBidsGuaranteeAmountMapper;
    @Autowired
    TProjectBasicInfoMapper tProjectBasicInfoMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    TPurchaseProjectFileDownloadMapper tPurchaseProjectFileDownloadMapper;
    @Autowired
    TPurchaseProjectFilePayMapper tPurchaseProjectFilePayMapper;

    /**
     * * 供应商报名采购项目
     *
     * @param signUpHandle
     * @return
     */
    @Override
    public Result signUp(SignUpHandle signUpHandle) {
        BSignUp bSignUp = new BSignUp();
        BeanUtils.copyProperties(signUpHandle, bSignUp);
        Date date = new Date();
        bSignUp.setCreateAt(date);
        bSignUp.setUpdateAt(date);
        bSignUp.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        return Result.success(bSignUpMapper.insertSelective(bSignUp) > 0);
    }

    /**
     * 采购人邀请供应商参加采购项目
     *
     * @param invitationHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result invitation(InvitationHandle invitationHandle) {
        BInvitation bInvitation = new BInvitation();
        for (Long supplierId : invitationHandle.getSupplierList()) {
            BeanUtils.copyProperties(invitationHandle, bInvitation);
            Date data = new Date();
            bInvitation.setCreateAt(data);
            bInvitation.setUpdateAt(data);
            bInvitation.setSupplierId(supplierId);
            try {
                //邀请表插入
                bInvitationMapper.insertSelective(bInvitation);
            } catch (Exception e) {
                LOGGER.error("UpdateInvitation_" + bInvitation.toString() + "_" + e.getMessage(), e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        return Result.success(true);
    }

    /**
     * 供应商查询邀请列表
     *
     * @param invitationForSupplierDTO
     * @return
     */
    @Override
    public Result<List<BInvitationVO>> invitationListForSupplier(InvitationForSupplierDTO invitationForSupplierDTO) {
        BInvitationCriteria criteria = new BInvitationCriteria();
        BInvitationCriteria.Criteria cubCriteria = criteria.createCriteria();
        cubCriteria.andSupplierIdEqualTo(invitationForSupplierDTO.getSupplierId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<BInvitation> result = bInvitationMapper.selectByExample(criteria);
        List<BInvitationVO> voList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (BInvitation entity : result) {
            BInvitationVO vo = new BInvitationVO();
            BeanUtils.copyProperties(entity, vo);
            String dateString = sdf.format(entity.getCreateAt());
            vo.setId(entity.getId());
            vo.setCreateAt(dateString);
            vo.setSupplierName(invitationForSupplierDTO.getSupplierName());
            voList.add(vo);
        }
        return Result.success(voList);
    }

    /**
     * 供应商 确认/拒绝 邀请
     *
     * @param updateInvitation
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateInvitation(UpdateInvitation updateInvitation) {
        //查询出数据
        BInvitation entity = bInvitationMapper.selectByPrimaryKey(updateInvitation.getId());
        entity.setIsDeleted(Const.IS_DELETED.IS_DELETED);
        SignUpHandle signUpHandle = new SignUpHandle();
        BeanUtils.copyProperties(entity, signUpHandle);
        //更新数据（操作后下次不能查出来）
        try {
            bInvitationMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            LOGGER.error("UpdateInvitation_" + entity.toString() + "_" + e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error();
        }
        //确认则添加一条报名记录
        if (updateInvitation.getStatus() == true) {
            signUp(signUpHandle);
        }
        return Result.success(true);
    }

    /**
     * 供应商参与的采购项目标段列表
     *
     * @param dto
     * @return
     */
    @Override
    public Result<List<BSignUpVO>> queryInvitationList(InvitationForSupplierDTO dto) {
        BSignUpCriteria criteria = new BSignUpCriteria();
        BSignUpCriteria.Criteria cubCriteria = criteria.createCriteria();
        cubCriteria.andSupplierIdEqualTo(dto.getSupplierId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<BSignUp> result = bSignUpMapper.selectByExample(criteria);
        List<BSignUpVO> voList = new ArrayList<>();
        for (BSignUp entity : result) {
            TPurchaseProjectBasicInfo newEntity = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(entity.getProcurementProjectId());
            BSignUpVO vo = new BSignUpVO();
            BeanUtils.copyProperties(entity, vo);
            vo.setIsEnd(newEntity.getIsEnd());
            voList.add(vo);
        }
        return Result.success(voList);
    }

    /**
     * 供应商参与的采购项目 保证金支付列表
     *
     * @return
     */
    @Override
    public Result<List<PayListForAllVO>> isPayForGuaranty(PayForGuarantyDTO payForGuarantyDTO) {
        List<BSignUpVO> newList = payForGuarantyDTO.getList();
        List<PayListForAllVO> voList = new ArrayList<>();
        for (BSignUpVO list : newList) {
            //切分bid数组
            String[] bidList = list.getBidsId().split(",");

            //获取项目详情
            PayListForAllVO vo = new PayListForAllVO();
            TPurchaseProjectBasicInfo purchaseProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(list.getProcurementProjectId());
            if (purchaseProjectBasicInfo != null) {
                vo.setStartDate(DateTimeUtil.dateToStr(purchaseProjectBasicInfo.getPurchaseStartTime()));
                vo.setEndDate(DateTimeUtil.dateToStr(purchaseProjectBasicInfo.getPurchaseEndTime()));
                vo.setProjectStatus(list.getIsEnd());
            }

            for (String bidIdString : bidList) {
                Long bidId = Long.parseLong(bidIdString);
                vo.setPayStatus("未支付");
                //获取标段详情
                TPurchaseProjectBids purchaseProjectBids = tPurchaseProjectBidsMapper.selectByPrimaryKey(bidId);
                if (purchaseProjectBids != null) {
                    vo.setProjectCode(purchaseProjectBids.getProjectCode());
                    vo.setProjectName(purchaseProjectBids.getProjectName());
                    vo.setBidId(purchaseProjectBids.getId());
                    vo.setBidName(purchaseProjectBids.getBidName());
                }
                BigDecimal money = null;
                //获取标段保证金金额
                BBidsGuaranteeAmountCriteria bBidsGuaranteeAmountCriteria = new BBidsGuaranteeAmountCriteria();
                BBidsGuaranteeAmountCriteria.Criteria cubBBidsGuaranteeAmountCriteria = bBidsGuaranteeAmountCriteria.createCriteria();
                cubBBidsGuaranteeAmountCriteria.andBidsIdEqualTo(bidId);
                List<BBidsGuaranteeAmount> result = bBidsGuaranteeAmountMapper.selectByExample(bBidsGuaranteeAmountCriteria);
                if (result.size() > 0) {
                    money = result.get(0).getTenderGuaranteeAmount();
                }
                //查询保证金支付情况(以及比较金额大小)

                BBidOpeningPayCriteria criteria = new BBidOpeningPayCriteria();
                BBidOpeningPayCriteria.Criteria cubCriteria = criteria.createCriteria();
                cubCriteria.andBidIdEqualTo(bidId);
                cubCriteria.andTendererCompanyIdEqualTo(list.getSupplierId());
                List<BBidOpeningPay> openingPayList = bBidOpeningPayMapper.selectByExample(criteria);
                for (BBidOpeningPay pay : openingPayList) {
                    if (pay.getAmountMoney().compareTo(money) > -1) {
                        if (pay.getIsBack() == 0) {
                            vo.setPayStatus("已支付");
                        } else if (pay.getIsBack() == 1) {
                            vo.setPayStatus("已退回");
                        }
                    }
                }
                voList.add(vo);
            }
        }
        //条件查询
        List<PayListForAllVO> firstList = new ArrayList<>();
        List<PayListForAllVO> secondList = new ArrayList<>();
        List<PayListForAllVO> ThreeList = new ArrayList<>();
        if (payForGuarantyDTO.getProjectName() != null) {
            for (PayListForAllVO vo : voList) {
                if (vo.getProjectName().contains(payForGuarantyDTO.getProjectName())) {
                    firstList.add(vo);
                }
            }
        } else {
            firstList = voList;
        }
        if (payForGuarantyDTO.getProjectStatus() != null) {
            for (PayListForAllVO vo : firstList) {
                if (vo.getProjectStatus().equals(payForGuarantyDTO.getProjectStatus())) {
                    secondList.add(vo);
                }
            }
        } else {
            secondList = firstList;
        }
        if (payForGuarantyDTO.getPayStatus() != null) {
            for (PayListForAllVO vo : secondList) {
                if (vo.getPayStatus().equals(payForGuarantyDTO.getPayStatus())) {
                    ThreeList.add(vo);
                }
            }
        } else {
            ThreeList = secondList;
        }
        return Result.success(ThreeList);
    }


    /**
     * 下载文件缴费情况（角色列表）
     *
     * @param payForGuarantyDTO
     * @return
     */
    @Override
    public Result<List<PayListForAllVO>> getBiddingDocumentListForAll(PayForGuarantyDTO payForGuarantyDTO) {
        List<BSignUpVO> newList = payForGuarantyDTO.getList();
        List<PayListForAllVO> voList = new ArrayList<>();
        for (BSignUpVO list : newList) {

            //获取采购项目详情
            PayListForAllVO vo = new PayListForAllVO();
            TPurchaseProjectBasicInfo purchaseProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(list.getProcurementProjectId());
            if (purchaseProjectBasicInfo != null) {
                vo.setStartDate(DateTimeUtil.dateToStr(purchaseProjectBasicInfo.getPurchaseStartTime()));
                vo.setEndDate(DateTimeUtil.dateToStr(purchaseProjectBasicInfo.getPurchaseEndTime()));
                vo.setProjectStatus(list.getIsEnd());
            }

            vo.setPayStatus("未支付");
            //获取项目详情
            TProjectBasicInfo projectBasicInfo = tProjectBasicInfoMapper.selectByPrimaryKey(list.getProcurementProjectId());
            if (projectBasicInfo != null) {
                vo.setProjectCode(projectBasicInfo.getProjectCode());
                vo.setProjectName(projectBasicInfo.getProjectName());
            }
            BigDecimal money = null;
            //获取下载文件金额
            TPurchaseProjectFileDownloadCriteria bBidsGuaranteeAmountCriteria = new TPurchaseProjectFileDownloadCriteria();
            TPurchaseProjectFileDownloadCriteria.Criteria cubTPurchaseProjectFileDownloadCriteria = bBidsGuaranteeAmountCriteria.createCriteria();
            cubTPurchaseProjectFileDownloadCriteria.andPurchaseProjectIdEqualTo(list.getProcurementProjectId());
            List<TPurchaseProjectFileDownload> result = tPurchaseProjectFileDownloadMapper.selectByExample(bBidsGuaranteeAmountCriteria);
            if (result.size() > 0) {
                money = result.get(0).getFilePayment();
            } else {
                break;
            }

            //查询下载文件金额支付情况(以及比较金额大小)
            TPurchaseProjectFilePayCriteria criteria = new TPurchaseProjectFilePayCriteria();
            TPurchaseProjectFilePayCriteria.Criteria cubCriteria = criteria.createCriteria();
            cubCriteria.andPurchaseProjectFileIdEqualTo(result.get(0).getId());
            cubCriteria.andCompanyIdEqualTo(list.getSupplierId());
            List<TPurchaseProjectFilePay> openingPayList = tPurchaseProjectFilePayMapper.selectByExample(criteria);
            for (TPurchaseProjectFilePay pay : openingPayList) {
                if (pay.getFilePaymentReal().compareTo(money) > -1) {
                    vo.setPayStatus("已支付");
                }
            }
            voList.add(vo);
        }
        //条件查询
        List<PayListForAllVO> firstList = new ArrayList<>();
        List<PayListForAllVO> secondList = new ArrayList<>();
        List<PayListForAllVO> ThreeList = new ArrayList<>();
        if (payForGuarantyDTO.getProjectName() != null) {
            for (PayListForAllVO newVo : voList) {
                if (newVo.getProjectName().contains(payForGuarantyDTO.getProjectName())) {
                    firstList.add(newVo);
                }
            }
        } else {
            firstList = voList;
        }
        if (payForGuarantyDTO.getProjectStatus() != null) {
            for (PayListForAllVO newVo : firstList) {
                if (newVo.getProjectStatus().equals(payForGuarantyDTO.getProjectStatus())) {
                    secondList.add(newVo);
                }
            }
        } else {
            secondList = firstList;
        }
        if (payForGuarantyDTO.getPayStatus() != null) {
            for (PayListForAllVO newVo : secondList) {
                if (newVo.getPayStatus().equals(payForGuarantyDTO.getPayStatus())) {
                    ThreeList.add(newVo);
                }
            }
        } else {
            ThreeList = secondList;
        }
        return Result.success(ThreeList);

    }


    /**
     * 采购人查看报名列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<QuerySignUpListVO>> querySignUpList(QuerySignUpList dto) {
        //获取采购项目下面的标段列表
        TPurchaseProjectBidsCriteria cite=new TPurchaseProjectBidsCriteria();
        TPurchaseProjectBidsCriteria.Criteria cubCite=cite.createCriteria();
        cubCite.andPurchaseProjectIdEqualTo(dto.getProcurementProjectId());
        List< TPurchaseProjectBids> bidsList= tPurchaseProjectBidsMapper.selectByExample(cite);
        List<QuerySignUpListVO> voList=new ArrayList<>();
        //根据bidList 遍历
        for(TPurchaseProjectBids entity:bidsList){
            //获取签到信息
            QuerySignUpListVO vo=new QuerySignUpListVO();
            vo.setBidsId(entity.getId());
            vo.setBidsName(entity.getBidName());
            BSignUpCriteria criteria=new BSignUpCriteria();
            BSignUpCriteria.Criteria cubCriteria=criteria.createCriteria();
            cubCriteria.andBidsIdLike(entity.getId().toString());
            List<BSignUp> bSignUpList=bSignUpMapper.selectByExample(criteria);
            //获取总数
            int count =bSignUpMapper.countByExample(criteria);
            List<SupplierSignDTO> SupplierSignList=new ArrayList<>();
            for(BSignUp bSignUp:bSignUpList){
                SupplierSignDTO supplierSignDTO=new SupplierSignDTO();
                BeanUtils.copyProperties(bSignUp,supplierSignDTO);
                supplierSignDTO.setSignUpTime( DateTimeUtil.dateToStr(bSignUp.getCreateAt()));
                SupplierSignList.add(supplierSignDTO);
            }
            vo.setSupplierSignList(SupplierSignList);
            vo.setCount(count);
            voList.add(vo);
        }
        return Result.success(voList);
    }
}