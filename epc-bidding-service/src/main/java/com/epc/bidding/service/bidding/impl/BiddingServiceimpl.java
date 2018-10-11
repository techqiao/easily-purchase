package com.epc.bidding.service.bidding.impl;


import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.PretrialMessageEnum;
import com.epc.common.util.DateTimeUtil;
import com.epc.web.facade.bidding.dto.FileListDTO;
import com.epc.web.facade.bidding.handle.BasePretriaFile;
import com.epc.web.facade.bidding.handle.HandleNotice;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import org.apache.commons.lang.StringUtils;
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
    TPretrialMessageMapper tPretrialMessageMapper;
    @Autowired
    TPretrialFileMapper tPretrialFileMapper;
    @Autowired
    TTenderMessageMapper tTenderMessageMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    TTenderFileMapper tTenderFileMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;

    /*******************************************公告*******************************************************/

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
        List<BReleaseAnnouncement> list= bReleaseAnnouncementMapper.selectByExampleWithBLOBsWithRowbounds(criteria,queryNoticeDTO.getRowBounds());
            for(BReleaseAnnouncement entity:list){
                NoticeDetailVO clientNoticeDetailVO = new NoticeDetailVO();
                //获取采购项目信息
                TPurchaseProjectBasicInfo purchaseProjectBasicInfo=tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(entity.getProcurementProjectId());
                BeanUtils.copyProperties(entity,clientNoticeDetailVO);
                clientNoticeDetailVO.setBiddingType(purchaseProjectBasicInfo.getPurchaseMode());
                clientNoticeDetailVO.setProcurementProjectName(purchaseProjectBasicInfo.getPurchaseProjectName());
                //日期格式转换
                clientNoticeDetailVO.setBiddingDocumentsUrl(null);
                clientNoticeDetailVO.setBiddingStart(DateTimeUtil.dateToStr(entity.getBiddingStart()));
                clientNoticeDetailVO.setBiddingEnd(DateTimeUtil.dateToStr(entity.getBiddingEnd()));
                clientNoticeDetailVO.setDefecationStart(DateTimeUtil.dateToStr(entity.getDefecationStart()));
                clientNoticeDetailVO.setDefecationEnd(DateTimeUtil.dateToStr(entity.getDefecationEnd()));
                resultList.add(clientNoticeDetailVO);
            }

        return  Result.success(resultList);

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

/*******************************************投标文件记录********************************************************/

    /**
     * 投标文件记录(新增/修改/删除)
     * @param handleNotice
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertNotice(HandleNotice handleNotice){
        //删除
        if(handleNotice.getId()!=null && handleNotice.getIsDelete()==1){
            try{
                tTenderMessageMapper.deleteByPrimaryKey(handleNotice.getId());
            }catch (Exception e){
                LOGGER.error("insertNotice"+handleNotice.getId().toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }

        TTenderMessage entity=new TTenderMessage();
        BeanUtils.copyProperties(handleNotice,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        if(handleNotice.getId()!=null){
            //更新
            try{
                tTenderMessageMapper.updateByPrimaryKey(entity);
            }catch (Exception e){
                LOGGER.error("insertNotice"+entity.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }else if(handleNotice.getId()==null){
            //新增
            try{
                tTenderMessageMapper.insertSelective(entity);
            }catch (Exception e){
                LOGGER.error("insertNotice"+entity.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        //查看文件是否上传
        List<BasePretriaFile> list=handleNotice.getFilePathList();
        if(list.size()==0){
            return  Result.success(true);
        }
        //新增 修改 投标文件（一条记录可以对应多个文件）
        for(BasePretriaFile file:list){
            TTenderFile tTenderFile=new TTenderFile();
            tTenderFile.setTenderMessageId(entity.getId());
            tTenderFile.setFilePath(file.getFilePath());
            tTenderFile.setFileName(file.getFileName());
            tTenderFile.setCreateAt(new Date());
            tTenderFile.setUpdateAt(new Date());
            tTenderFile.setOperateId(handleNotice.getOperateId());
            if(file.getId()!=null){
                //文件id不为空则修改记录
                try{
                    tTenderFileMapper.updateByPrimaryKey(tTenderFile);
                }catch(Exception e){
                    LOGGER.error("updateByPrimaryKey_"+e.getMessage());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return  Result.error();
                }
            }else  if(file.getId()==null){
                //文件id为空则新增记录
                try{
                    tTenderFileMapper.insertSelective(tTenderFile);
                }catch(Exception e){
                    LOGGER.error("insertSelective_"+e.getMessage());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return  Result.error();
                }
            }
        }
        return Result.success();
    }

/*******************************************预审文件记录********************************************************/

    /**
     * 预审文件记录 新增/更新/删除
     * @param handlePretriaFile
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updatePretrialFile(HandlePretriaFile handlePretriaFile) {
        TPretrialMessage attachment=new TPretrialMessage();
        BeanUtils.copyProperties(handlePretriaFile,attachment);
        attachment.setCreateAt(new Date());
        attachment.setUpdateAt(new Date());
        attachment.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        attachment.setStatus(PretrialMessageEnum.REVIEW.getCode());
        attachment.setCreator(handlePretriaFile.getOperateName());
        if(handlePretriaFile.getId()!=null && handlePretriaFile.getIsDelete()!=null && handlePretriaFile.getIsDelete()==1 ){
            try{
                //删除
                tPretrialMessageMapper.deleteByPrimaryKey(handlePretriaFile.getId());
                return  Result.success(true);
            }catch (Exception e){
                LOGGER.error("updatePretrialFile_"+attachment.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        if(handlePretriaFile.getId()!=null){
            try{
                //更新审查信息记录
                tPretrialMessageMapper.updateByPrimaryKey(attachment);
            }catch (Exception e){
                LOGGER.error("updatePretrialFile_"+attachment.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }else if(handlePretriaFile.getId()==null){
            try{
                //新增审查信息记录
                tPretrialMessageMapper.insertSelective(attachment);
            }catch (Exception e){
                LOGGER.error("updatePretrialFile_"+attachment.toString()+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
        }
        //查看是否存在文件
        List<BasePretriaFile> list=handlePretriaFile.getFilePathList();
        if(list.size()==0){
            return  Result.success(true);
        }
        for(BasePretriaFile entity:list){
            TPretrialFile tPretrialFile=new TPretrialFile();
            tPretrialFile.setPretrialMessageId(attachment.getId());
            tPretrialFile.setFilePath(entity.getFilePath());
            tPretrialFile.setFileName(entity.getFileName());
            tPretrialFile.setCreateAt(new Date());
            tPretrialFile.setUpdateAt(new Date());
            tPretrialFile.setOperateId(handlePretriaFile.getOperateId());
            tPretrialFile.setCreator(handlePretriaFile.getOperateName());
            if(entity.getId()!=null && entity.getId()>0){
                //文件id为空则修改原记录
                try{
                    tPretrialFileMapper.updateByPrimaryKey(tPretrialFile);
                }catch(Exception e){
                    LOGGER.error("updatePretrialFile_"+tPretrialFile.toString()+e.getMessage(),e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }else{
                //文件id为空则新增记录
                try{
                    tPretrialFileMapper.insertSelective(tPretrialFile);
                }catch(Exception e){
                    LOGGER.error("updatePretrialFile_"+tPretrialFile.toString()+e.getMessage(),e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }
        }
        return  Result.success(true);
    }


    /**
     * 供应商 查看预审信息 + 附件列表
     * @return
     */

    @Override
    public Result<PretrialMessageVO>  getTPretrialMessage(HandlePretriaFile handlePretriaFile){
        TPretrialMessageCriteria criteria =new TPretrialMessageCriteria();
        TPretrialMessageCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(handlePretriaFile.getPurchaseProjectId());
        cubCriteria.andReleaseAnnouncementIdEqualTo(handlePretriaFile.getReleaseAnnouncementId());
        cubCriteria.andCompanyIdEqualTo(handlePretriaFile.getCompanyId());
        //获取预审信息
        List<TPretrialMessage> list=tPretrialMessageMapper.selectByExample(criteria);
        if(list.size()==0){
            return Result.error();
        }
        PretrialMessageVO vo =new PretrialMessageVO();
        BeanUtils.copyProperties(list.get(0),vo);

        //获取预审信息 对应的文件列表
        TPretrialFileCriteria newCriteria =new TPretrialFileCriteria();
        TPretrialFileCriteria.Criteria cubNewCriteria=newCriteria.createCriteria();
        cubNewCriteria.andPretrialMessageIdEqualTo(vo.getId());
        List<TPretrialFile> newList=tPretrialFileMapper.selectByExample(newCriteria);
        FileListDTO dto=new FileListDTO();
        List<FileListDTO> dtoList=new ArrayList<>();
        for(TPretrialFile entity:newList){
            BeanUtils.copyProperties(entity,dto);
            dtoList.add(dto);
        }

        vo.setFileList(dtoList);
        return Result.success(vo);
    }


    /**
     * 查询供应商是否支付下载招标文件金额
     * @return
     */

    @Override
    public Boolean IsPayForProjectFile(QueryProgramPayDTO dto){
        if(dto.getProcurementProjectId()==null){
            return  false;
        }
        final TPurchaseProjectFileDownloadCriteria criteria=new TPurchaseProjectFileDownloadCriteria();
        final TPurchaseProjectFileDownloadCriteria.Criteria subCriteria=criteria.createCriteria();
        subCriteria.andPurchaseProjectIdEqualTo(dto.getProcurementProjectId());
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //根据采购项目Id 查询招标文件
        List<TPurchaseProjectFileDownload> list=tPurchaseProjectFileDownloadMapper.selectByExample(criteria);
        if(list.size()==0){
            LOGGER.error("尚未发布招标文件");
            return false;
        }
        //获取招标文件ID
        Long fileId=list.get(0).getId();
        BigDecimal money=list.get(0).getFilePayment();
        //根据招标文件ID 和 下载机构id 查询是否付费 t_purchase_project_file_pay
        final TPurchaseProjectFilePayCriteria pay =new TPurchaseProjectFilePayCriteria();
        final TPurchaseProjectFilePayCriteria.Criteria subPay=pay.createCriteria();
        subPay.andCompanyIdEqualTo(dto.getCompanyId());
        subPay.andPurchaseProjectFileIdEqualTo(fileId);

        List<TPurchaseProjectFilePay> payList=tPurchaseProjectFilePayMapper.selectByExample(pay);
        //未查询到支付记录
        if(payList.size()==0){
            LOGGER.error("未找到支付记录");
            return false;
        }else{
            //(实付金额 比对 下载金额)
            for(TPurchaseProjectFilePay entity:payList){
                if(entity.getFilePaymentReal().compareTo(money)>-1){
                    return true;
                }
            }
            return true;
        }
    }

}
