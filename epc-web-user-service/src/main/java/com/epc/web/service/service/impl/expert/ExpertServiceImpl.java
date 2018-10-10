package com.epc.web.service.service.impl.expert;

import com.epc.common.Result;
import com.epc.common.constants.AttachmentEnum;
import com.epc.common.constants.Const;
import com.epc.web.facade.agency.handle.Attachement;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.expert.dto.IdleExpertDto;
import com.epc.web.facade.expert.dto.ProjectDto;
import com.epc.web.service.domain.bid.TPurchaseProjectBids;
import com.epc.web.service.domain.expert.BAssessmentCommitteeExpert;
import com.epc.web.service.domain.expert.TExpertAttachment;
import com.epc.web.service.domain.expert.TExpertBasicInfo;
import com.epc.web.service.domain.expert.TExpertDetailInfo;
import com.epc.web.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.web.service.mapper.expert.BAssessmentCommitteeExpertMapper;
import com.epc.web.service.mapper.expert.TExpertAttachmentMapper;
import com.epc.web.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.web.service.mapper.expert.TExpertDetailInfoMapper;
import com.epc.web.service.service.expert.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpertServiceImpl implements ExpertService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpertServiceImpl.class);

    @Autowired
    TExpertBasicInfoMapper tExpertBasicInfoMapper;

    @Autowired
    TExpertDetailInfoMapper tExpertDetailInfoMapper;

    @Autowired
    TExpertAttachmentMapper tExpertAttachmentMapper;

    @Autowired
    BAssessmentCommitteeExpertMapper bAssessmentCommitteeExpertMapper;

    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;

    /**
     * @author :winlin
     * @Description :专家完善自己的详细信息
     * @date:2018/10/9
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> completeExpertInfo(HandleExpert expert) {
        //对传入专家id进行校验
        Long expertId = expert.getExpertId();
        if (expertId == null) {
            return Result.success("请传入有效的信息");
        }
        //完善的时间
        Date date = new Date();
        //查询专家的注册信息
        TExpertBasicInfo tExpertBasicInfo = null;
        try {
            tExpertBasicInfo = tExpertBasicInfoMapper.selectByPrimaryKey(expertId);
            if (tExpertBasicInfo == null) {
                return Result.success("没有该专家的注册信息,请注册或检查信息重新输入");
            }
        } catch (Exception e) {
            LOGGER.error("完善专家信息Exception:{}", e);
            return Result.error("完善专家信息失败");
        }
        //更新基本信息
        tExpertBasicInfo.setProfession(expert.getProfession());
        tExpertBasicInfo.setPositional(expert.getPositional());
        tExpertBasicInfo.setLevel(expert.getLevel());
        tExpertBasicInfo.setIsIdle(Const.IS_IDLE_OR_NOT.IS_IDLE);
        tExpertBasicInfo.setCircularDt(expert.getCircularDt());
        tExpertBasicInfo.setCircularDtEnd(expert.getCircularDtEnd());
        tExpertBasicInfo.setCircularMethod(expert.getCircularMethod());
        tExpertBasicInfo.setOtherInformation(expert.getOtherInformation());
        tExpertBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
        tExpertBasicInfo.setInviterId(Long.parseLong(Const.INVITER_TYPE.PLATFORM_ID + ""));
        tExpertBasicInfo.setInviterCompanyId(Const.INVITER_TYPE.PLATFORM_ID);
        tExpertBasicInfo.setState(Const.STATE.COMMITTED);
        tExpertBasicInfo.setCreateAt(date);
        tExpertBasicInfo.setUpdateAt(date);
        //更新详情表的信息
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        tExpertDetailInfo.setExpertId(expertId);
        tExpertDetailInfo.setCreateAt(date);
        tExpertDetailInfo.setUpdateAt(date);
        //附件信息更新
        TExpertAttachment expertAttachment = new TExpertAttachment();
        expertAttachment.setExpertId(expertId);
        expertAttachment.setCreateAt(date);
        expertAttachment.setUpdateAt(date);
        try {
            //更新基本的信息
            tExpertBasicInfoMapper.updateByPrimaryKeySelective(tExpertBasicInfo);
            //添加详细信息
            tExpertDetailInfoMapper.insertSelective(tExpertDetailInfo);
            //添加身份证信息
            this.addExpertAttachment(expertAttachment, expertId, expert);
        } catch (Exception e) {
            //回滚并记录错误
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善专家信息失败Exception:{}", e);
            return Result.error("完善专家信息失败");
        }
        return Result.success("完善专家信息成功");
    }

    /**
     * @author :winlin
     * @Description :跟新专家的信息
     * @date:2018/10/9
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result<Boolean> updateExpertSelfInfo(HandleExpert expert) {
        //对传入专家id进行校验
        Long expertId = expert.getExpertId();
        if (expertId == null) {
            return Result.success("请传入有效的信息");
        }
        //完善的时间
        Date date = new Date();
        //查询专家的审核信息
        TExpertBasicInfo tExpertBasicInfo = null;
        try {
            tExpertBasicInfo = tExpertBasicInfoMapper.selectByPrimaryKey(expertId);
            if (tExpertBasicInfo.getState() == Const.STATE.AUDIT_SUCCESS) {
                return Result.success("您的信息已审核通过无法进行修改");
            }
        } catch (Exception e) {
            LOGGER.error("修改专家信息Exception:{}", e);
            return Result.error("修改专家信息失败");
        }
        //更新基本信息
        tExpertBasicInfo.setProfession(expert.getProfession());
        tExpertBasicInfo.setPositional(expert.getPositional());
        tExpertBasicInfo.setLevel(expert.getLevel());
        tExpertBasicInfo.setIsIdle(Const.IS_IDLE_OR_NOT.IS_IDLE);
        tExpertBasicInfo.setCircularDt(expert.getCircularDt());
        tExpertBasicInfo.setCircularDtEnd(expert.getCircularDtEnd());
        tExpertBasicInfo.setCircularMethod(expert.getCircularMethod());
        tExpertBasicInfo.setOtherInformation(expert.getOtherInformation());
//        tExpertBasicInfo.setInviterType(Const.INVITER_TYPE.PLATFORM);
//        tExpertBasicInfo.setInviterId(Long.parseLong(Const.INVITER_TYPE.PLATFORM_ID + ""));
//        tExpertBasicInfo.setInviterCompanyId(Const.INVITER_TYPE.PLATFORM_ID);
//        tExpertBasicInfo.setState(Const.STATE.COMMITTED);
//        tExpertBasicInfo.setCreateAt(date);
        tExpertBasicInfo.setUpdateAt(date);
        //更新详情表的信息
        TExpertDetailInfo tExpertDetailInfo = new TExpertDetailInfo();
        tExpertDetailInfo.setExpertId(expertId);
        tExpertDetailInfo.setCreateAt(date);
        tExpertDetailInfo.setUpdateAt(date);
        //附件信息更新
        TExpertAttachment expertAttachment = new TExpertAttachment();
        expertAttachment.setExpertId(expertId);
        expertAttachment.setCreateAt(date);
        expertAttachment.setUpdateAt(date);
        try {
            //更新基本的信息
            tExpertBasicInfoMapper.updateByPrimaryKeySelective(tExpertBasicInfo);
            //添加详细信息
            tExpertDetailInfoMapper.updateByPrimaryKeySelective(tExpertDetailInfo);
            //查询附件信息看初次完善是否添加
            int nums = tExpertAttachmentMapper.selectAttchamentNumsByExpertId(expertId);
            if (nums > 0) {
                tExpertAttachmentMapper.deleteByAttachmentByExpertId(expertId);
                //添加身份证信息
                this.addExpertAttachment(expertAttachment, expertId, expert);
            }
            //添加身份证信息
            this.addExpertAttachment(expertAttachment, expertId, expert);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error("完善专家信息失败Exception:{}", e);
            return Result.error("完善专家信息失败");
        }
        return Result.success("完善专家信息成功");
    }

    /**
     * @author :winlin
     * @Description :专家是否接受评审邀请
     * @date:2018/10/9
     */
    @Override
    public Result<Boolean> acceptRequestForSubject() {
        return null;
    }

    /**
     * @author :winlin
     * @Description :查看自己名下所有的标段
     * @date:2018/10/9
     */
    @Override
    public Result selectAllBid(ProjectDto projecctDto) {
        //通过专家id获得自己对应标段的的所有的标段id
        List<BAssessmentCommitteeExpert> bAssessmentCommitteeExpert = null;
        List<TPurchaseProjectBids> tPurchaseProjectBids = null;
        try {
            Long expertId = projecctDto.getExpertId();
            bAssessmentCommitteeExpert = bAssessmentCommitteeExpertMapper.selectByExpertId(expertId);
            if (CollectionUtils.isEmpty(bAssessmentCommitteeExpert)) {
                return Result.success("该专家下没有再评审的标段");
            }
            //获得所有该专家名下的标段id
            List<Long> bids = new ArrayList<>();
            for (BAssessmentCommitteeExpert committeeExpert : bAssessmentCommitteeExpert) {
                bids.add(committeeExpert.getBidsId());
            }
            //通过id获得采购目标段详情t_purchaser_project_bids
            tPurchaseProjectBids = tPurchaseProjectBidsMapper.selectProjectByExpertIds(projecctDto,bids);
            if (CollectionUtils.isEmpty(tPurchaseProjectBids)) {
                return Result.success("该专家下没有再评审的标段");
            }

        } catch (Exception e) {
            LOGGER.error("查看评审标段详情失败Exception:{}", e);
            return Result.error("查看评审标段详情失败");
        }
        return null;
    }

    @Override
    public Result<Boolean> hasIntentionOrNot(IdleExpertDto dto) {
        int success = 0;
        try {
            success = tExpertBasicInfoMapper.updateIsIdleOrNot(dto);
        } catch (Exception e) {
            LOGGER.error("修改专家空闲状态失败Exception:{}", e);
            return Result.error("修改专家空闲状态失败");
        }
        return success > 0 ? Result.success("修改专家空闲状态成功") : Result.success("修改专家空闲状态失败");
    }

    @Override
    public Result queryFinishedSubject() {
        return null;
    }

    @Override
    public Result<Boolean> evaluateSubject() {
        return null;
    }

    /**
     * @author :winlin
     * @Description :添加专家信息附件的方法
     * @date:2018/10/9
     */
    public void addExpertAttachment(TExpertAttachment expertAttachment, Long expertId, HandleExpert expert) {
        //添加身份证信息
        expertAttachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getCode());
        expertAttachment.setCertificateFilePath(expert.getLegalIdCardPositive());
        expertAttachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_POSITIVE.getDesc());
        tExpertAttachmentMapper.insertSelective(expertAttachment);
        expertAttachment.setCertificateType(AttachmentEnum.LEGAL_ID_CARD_OTHER.getCode());
        expertAttachment.setCertificateFilePath(expert.getLegalIdCardOther());
        expertAttachment.setCertificateName(AttachmentEnum.LEGAL_ID_CARD_OTHER.getDesc());
        tExpertAttachmentMapper.insertSelective(expertAttachment);
        //添加资质证书信息
        List<Attachement> list = expert.getAtts();
        if (!CollectionUtils.isEmpty(list)) {
            for (Attachement att : list) {
                expertAttachment.setCertificateFilePath(att.getCertificateFilePath());
                expertAttachment.setCertificateType(AttachmentEnum.QUALIFICATION_CERTIFICATE.getCode());
                expertAttachment.setCertificateName(AttachmentEnum.QUALIFICATION_CERTIFICATE.getDesc());
                tExpertAttachmentMapper.insertSelective(expertAttachment);
            }
        }
    }

}
