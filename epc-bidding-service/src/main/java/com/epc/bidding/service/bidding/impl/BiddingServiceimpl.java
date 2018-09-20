package com.epc.bidding.service.bidding.impl;


import com.epc.bidding.domain.bidding.*;
import com.epc.bidding.mapper.bidding.*;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.handle.BasePretriaFile;
import com.epc.web.facade.bidding.handle.HandleFileUpload;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @Description:  投标接口
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@Service
public class BiddingServiceimpl implements BiddingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiddingServiceimpl.class);

    @Autowired
    BReleaseAnnouncementMapper bReleaseAnnouncementMapper;
    @Autowired
    BAnswerQuestionMapper bAnswerQuestionMapper;
    @Autowired
    TSupplierAttachmentMapper tSupplierAttachmentMapper;
    @Autowired
    TPurchaseProjectFileDownloadMapper tPurchaseProjectFileDownloadMapper;
    @Autowired
    BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    TPurchaseProjectFilePayMapper tPurchaseProjectFilePayMapper;
    /**
     * 查询公告列表（暂时不做黑名单）
     * @param queryNoticeDTO
     * @return
     */
    @Override
    public Result<List<NoticeDetailVO>> findBySupplierId(QueryNoticeDTO queryNoticeDTO) {
        final BReleaseAnnouncementCriteria criteria = new BReleaseAnnouncementCriteria();
        final BReleaseAnnouncementCriteria.Criteria subCriteria=criteria.createCriteria();

        //根据名称模糊查询
        if(StringUtils.isNotBlank(queryNoticeDTO.getTitle())){
            subCriteria.andTitleLike("%"+queryNoticeDTO.getTitle()+"%");
        }
        if(queryNoticeDTO.getBiddingStart()!=null){
            subCriteria.andBiddingStartGreaterThanOrEqualTo(queryNoticeDTO.getBiddingStart());
        }
        if(queryNoticeDTO.getBiddingEnd()!=null){
            subCriteria.andBiddingEndGreaterThanOrEqualTo(queryNoticeDTO.getBiddingEnd());
        }
        if(StringUtils.isNotBlank(queryNoticeDTO.getBiddingType())){
            subCriteria.andBiddingTypeEqualTo(queryNoticeDTO.getBiddingType());
        }
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<NoticeDetailVO> resultList=new ArrayList<>();
        try{
            List<BReleaseAnnouncement> list= bReleaseAnnouncementMapper.selectByExampleWithBLOBsWithRowbounds(criteria,queryNoticeDTO.getRowBounds());
            for(BReleaseAnnouncement entity:list){
                NoticeDetailVO clientNoticeDetailVO = new NoticeDetailVO();
                BeanUtils.copyProperties(entity,clientNoticeDetailVO);
                resultList.add(clientNoticeDetailVO);
            }
        }catch (Exception e){
            LOGGER.error("供应商Id不能为null", e);
            return Result.error();
        }
        return  Result.success(resultList);

    }

    /**
     * 查看公告详情
     * @param queryNoticeDetail
     * @param isPay
     * @return
     */
    @Override
    public Result<NoticeDetailVO> findByNoticeId(QueryNoticeDetail queryNoticeDetail,Boolean isPay) {
        if(queryNoticeDetail.getNoticeId()==null){
            return Result.error("公告Id不能为空");
        }

        //根据公告ID查看详情
        BReleaseAnnouncement bReleaseAnnouncement = bReleaseAnnouncementMapper.selectByPrimaryKey(queryNoticeDetail.getNoticeId());
        NoticeDetailVO clientNoticeDetailVO = new NoticeDetailVO();
        if (bReleaseAnnouncement==null){
            return Result.success(null);
        }
        BeanUtils.copyProperties(bReleaseAnnouncement, clientNoticeDetailVO);

        //未支付招标文件下载金，则不能下载，路径为空
        if(isPay==false){
            clientNoticeDetailVO.setBiddingDocumentsUrl(null);
        }
        return Result.success(clientNoticeDetailVO);
    }

    /**
     * 查看答疑列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<QueryAnswerQustionListVO>> getAnswerQuestionfindByNoticeId(QueryAnswerQuestionDTO dto) {
        final BAnswerQuestionCriteria criteria = new BAnswerQuestionCriteria();
        final BAnswerQuestionCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        criteria.setOrderByClause("createAt desc");
        List<BAnswerQuestion> list=bAnswerQuestionMapper.selectByExampleWithRowbounds(criteria,dto.getRowBounds());
        List<QueryAnswerQustionListVO> returnList = new ArrayList<QueryAnswerQustionListVO>();
        list.forEach(item -> {
            QueryAnswerQustionListVO vo = new QueryAnswerQustionListVO();
            BeanUtils.copyProperties(item, vo);
            returnList.add(vo);
        });
        return Result.success(returnList);
    }


    /**
     * 上传 预审/投标 文件列表
     * @param handleFileUpload
     * @return
     */

    @Override
    public Result<Boolean> updatePretrialFile(HandleFileUpload handleFileUpload){
        TSupplierAttachment attachment=new TSupplierAttachment();
        attachment.setSupplierId(handleFileUpload.getSupplierId());
        attachment.setCreateAt(new Date());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        attachment.setUpdateAt(new Date());
        List<BasePretriaFile> list=handleFileUpload.getFilePathList();
        for(BasePretriaFile filePath:list){
            attachment.setCertificateFilePath(filePath.getFilePath());
            attachment.setCertificateName(filePath.getFileName());
            try{
                tSupplierAttachmentMapper.insertSelective(attachment);
            }catch(Exception e){
                return Result.error();
            }
        }
        return Result.success();
    }


    /**
     * 查询供应商是否支付下载招标文件金额
     * @return
     */

    @Override
    public Result<Boolean> IsPayForProjectFile(QueryProgramPayDTO dto){
        final TPurchaseProjectFileDownloadCriteria criteria=new TPurchaseProjectFileDownloadCriteria();
        final TPurchaseProjectFileDownloadCriteria.Criteria subCriteria=criteria.createCriteria();
        subCriteria.andPurchasProjectIdEqualTo(dto.getProcurementProjectId());
        subCriteria.andPurchaserIdEqualTo(dto.getPurchaserId());
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //根据采购项目Id 查询招标文件
        List<TPurchaseProjectFileDownload> list=tPurchaseProjectFileDownloadMapper.selectByExample(criteria);
        if(list.size()==0){
            return Result.success("尚未发布招标文件");
        }
        //获取招标文件ID
        Long fileId=list.get(0).getId();
        BigDecimal money=list.get(0).getFilePayment();
        //根据招标文件ID 和 下载机构id 查询是否付费
        final TPurchaseProjectFilePayCriteria pay =new TPurchaseProjectFilePayCriteria();
        final TPurchaseProjectFilePayCriteria.Criteria subPay=pay.createCriteria();

        subPay.andCompanyIdEqualTo(dto.getCompanyId());
        subPay.andPurchasProjectFileIdEqualTo(fileId);

        List<TPurchaseProjectFilePay> payList=tPurchaseProjectFilePayMapper.selectByExample(pay);
        //未查询到支付记录
        if(payList.size()==0){
            return   Result.success(false);
        }else{
            //第一次支付，暂时不考虑多次
            BigDecimal realPay= payList.get(0).getFilePaymentReal();
            //compareTo  -1:<   0:=   1:>
            if(money.compareTo(realPay)>-1){
                Result.success(true);
            }
        }
        return null;
    }
}