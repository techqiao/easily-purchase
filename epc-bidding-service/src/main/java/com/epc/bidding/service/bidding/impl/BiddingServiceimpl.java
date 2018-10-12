package com.epc.bidding.service.bidding.impl;


import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.DateTimeUtil;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    TSupplierAttachmentMapper tSupplierAttachmentMapper;
    @Autowired
    TPurchaseProjectFileDownloadMapper tPurchaseProjectFileDownloadMapper;
    @Autowired
    BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    TPurchaseProjectFilePayMapper tPurchaseProjectFilePayMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    TProcurementProjectSupplierMapper tProcurementProjectSupplierMapper;


    /**
     * 查询公告列表（公告 + 私库邀请）
     * @param queryNoticeDTO
     * @return
     */
    @Override
    public List<NoticeDetailVO> findBySupplierId(QueryNoticeDTO queryNoticeDTO) {
        final BReleaseAnnouncementCriteria criteria = new BReleaseAnnouncementCriteria();
        final BReleaseAnnouncementCriteria.Criteria subCriteria=criteria.createCriteria();
        //根据名称模糊查询
        if(StringUtils.isNotBlank(queryNoticeDTO.getTitle())){
            subCriteria.andTitleLike("%"+queryNoticeDTO.getTitle()+"%");
        }
        //开始日期
        if(queryNoticeDTO.getBiddingStart()!=null){
            subCriteria.andBiddingStartGreaterThanOrEqualTo(queryNoticeDTO.getBiddingStart());
        }
        //结束日期
        if(queryNoticeDTO.getBiddingEnd()!=null){
            subCriteria.andBiddingEndGreaterThanOrEqualTo(queryNoticeDTO.getBiddingEnd());
        }
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<NoticeDetailVO> resultList=new ArrayList<>();
        List<BReleaseAnnouncement> list= bReleaseAnnouncementMapper.selectByExampleWithBLOBs(criteria);
        for(BReleaseAnnouncement entity:list){
                NoticeDetailVO clientNoticeDetailVO = new NoticeDetailVO();
                clientNoticeDetailVO.setBiddingDocumentsUrl(null);

            //获取采购项目信息
                TPurchaseProjectBasicInfo purchaseProjectBasicInfo=tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(entity.getProcurementProjectId());
                if(purchaseProjectBasicInfo==null){
                   LOGGER.error("采购项目信息不存在");
                   Result.error();
               }
                if(purchaseProjectBasicInfo.getPurchaseRange().equals(0)){
                    //范围全网可见
                   BeanUtils.copyProperties(entity,clientNoticeDetailVO);
                   clientNoticeDetailVO.setBiddingType(purchaseProjectBasicInfo.getPurchaseMode());
                   clientNoticeDetailVO.setProcurementProjectName(purchaseProjectBasicInfo.getPurchaseProjectName());
                   //日期格式转换
                   clientNoticeDetailVO.setBiddingStart(DateTimeUtil.dateToStr(entity.getBiddingStart()));
                   clientNoticeDetailVO.setBiddingEnd(DateTimeUtil.dateToStr(entity.getBiddingEnd()));
                   clientNoticeDetailVO.setDefecationStart(DateTimeUtil.dateToStr(entity.getDefecationStart()));
                   clientNoticeDetailVO.setDefecationEnd(DateTimeUtil.dateToStr(entity.getDefecationEnd()));
                   resultList.add(clientNoticeDetailVO);
                }else if(purchaseProjectBasicInfo.getPurchaseRange().equals(1)){
                    //私库查询指定列表
                    TProcurementProjectSupplierCriteria criteria1=new TProcurementProjectSupplierCriteria();
                    TProcurementProjectSupplierCriteria.Criteria cubCriteria1=criteria1.createCriteria();
                    cubCriteria1.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
                    cubCriteria1.andSupplierIdEqualTo(queryNoticeDTO.getSupplierId());
                    List<TProcurementProjectSupplier> newList=tProcurementProjectSupplierMapper.selectByExample(criteria1);
                    if(newList!=null && newList.size()>0){
                        BeanUtils.copyProperties(entity,clientNoticeDetailVO);
                        clientNoticeDetailVO.setBiddingType(purchaseProjectBasicInfo.getPurchaseMode());
                        clientNoticeDetailVO.setProcurementProjectName(purchaseProjectBasicInfo.getPurchaseProjectName());
                        //日期格式转换
                        clientNoticeDetailVO.setBiddingStart(DateTimeUtil.dateToStr(entity.getBiddingStart()));
                        clientNoticeDetailVO.setBiddingEnd(DateTimeUtil.dateToStr(entity.getBiddingEnd()));
                        clientNoticeDetailVO.setDefecationStart(DateTimeUtil.dateToStr(entity.getDefecationStart()));
                        clientNoticeDetailVO.setDefecationEnd(DateTimeUtil.dateToStr(entity.getDefecationEnd()));
                        resultList.add(clientNoticeDetailVO);
                    }
                }
            }
        return  resultList;

    }

    /**
     * 查看公告详情
     * @param queryNoticeDetail
     * @return
     */
    @Override
    public NoticeDetailVO findByNoticeId(QueryNoticeDetail queryNoticeDetail) {
        if(queryNoticeDetail.getNoticeId()==null){
            return null;
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //根据公告ID查看详情
        BReleaseAnnouncement bReleaseAnnouncement = bReleaseAnnouncementMapper.selectByPrimaryKey(
                queryNoticeDetail.getNoticeId());
        NoticeDetailVO noticeDetailVO = new NoticeDetailVO();
        if (bReleaseAnnouncement==null){
            return null;
        }
        BeanUtils.copyProperties(bReleaseAnnouncement, noticeDetailVO);
        noticeDetailVO.setBiddingStart(sdf.format(bReleaseAnnouncement.getBiddingStart()));
        noticeDetailVO.setBiddingEnd(sdf.format(bReleaseAnnouncement.getBiddingEnd()));
        noticeDetailVO.setDefecationStart(sdf.format(bReleaseAnnouncement.getDefecationStart()));
        noticeDetailVO.setDefecationEnd(sdf.format(bReleaseAnnouncement.getDefecationEnd()));
        //查询采购项目详情
        TPurchaseProjectBasicInfo tPurchaseProjectBasicInfo= tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(
                bReleaseAnnouncement.getProcurementProjectId());
        if(tPurchaseProjectBasicInfo!=null){
            noticeDetailVO.setProcurementProjectName(tPurchaseProjectBasicInfo.getPurchaseProjectName());
            noticeDetailVO.setBiddingType(tPurchaseProjectBasicInfo.getPurchaseType());
        }
        return noticeDetailVO;
    }

}
