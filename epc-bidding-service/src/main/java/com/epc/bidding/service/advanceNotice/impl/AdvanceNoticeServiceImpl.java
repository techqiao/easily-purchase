package com.epc.bidding.service.advanceNotice.impl;

import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.advanceNotice.AdvanceNoticeService;
import com.epc.common.Result;
import com.epc.common.constants.BiddingPreviewStatusEnum;
import com.epc.common.constants.PretrialMessageEnum;
import com.epc.common.util.DateTimeUtil;
import com.epc.web.facade.bidding.dto.OfflineDetailDTO;
import com.epc.web.facade.bidding.dto.OnlineDetailDTO;
import com.epc.web.facade.bidding.query.notice.PretrialMessageDTO;
import com.epc.web.facade.bidding.query.notice.PretrialMessageDetailDTO;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import com.epc.web.facade.bidding.vo.PretrialMessageDetailVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 预告
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Service
public class AdvanceNoticeServiceImpl  implements AdvanceNoticeService {

    @Autowired
    TBiddingPreviewMapper tBiddingPreviewMapper;
    @Autowired
    TPretrialMessageMapper tPretrialMessageMapper;
    @Autowired
    BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    BTenderDocumentsPlaceSaleMapper bTenderDocumentsPlaceSaleMapper;
    @Autowired
    BSaleDocumentsFileMapper bSaleDocumentsFileMapper;
    /**
     * 查看 预告列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<AdvanceNoticeVO>> ListAdvanceNotice(QueryAdvanceNoticeDTO dto){
        TBiddingPreviewCriteria criteria=new TBiddingPreviewCriteria();
        TBiddingPreviewCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andStatusEqualTo(BiddingPreviewStatusEnum.RELEASE.getCode());
        if(StringUtils.isNotEmpty(dto.getProjectCode())){
            cubCriteria.andProjectCodeLike("%"+dto.getProjectCode()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getProjectName())){
            cubCriteria.andProjectNameLike("%"+dto.getProjectName()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getPreviewTitle())){
            cubCriteria.andPreviewTitleLike("%"+dto.getPreviewTitle()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getPreviewMemo())){
            cubCriteria.andPreviewMemoLike("%"+dto.getPreviewMemo()+"%");
        }
        List<TBiddingPreview> result= tBiddingPreviewMapper.selectByExampleWithRowbounds(criteria,dto.getRowBounds());
        List<AdvanceNoticeVO> voList=new ArrayList<>();
        for(TBiddingPreview entity:result){
           AdvanceNoticeVO vo=new AdvanceNoticeVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
       }
       return  Result.success(voList);
    }

    /**
     * 根据ID获取预告详情
     * @param id
     * @return
     */
    @Override
    public Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(Long id) {
        TBiddingPreview entity=tBiddingPreviewMapper.selectByPrimaryKey(id);
        if(entity==null){
            return Result.success(null);
        }
        AdvanceNoticeDetailVO vo= new AdvanceNoticeDetailVO();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BeanUtils.copyProperties(entity,vo);
        vo.setCreateAt(sdf.format(entity.getCreateAt()));
        return Result.success(vo);
    }

    /**
     * 是否通过预审
     * @param pretrialMessageDTO
     * @return
     */
    @Override
    public Boolean getPretrialMessage(PretrialMessageDTO pretrialMessageDTO) {
        TPretrialMessageCriteria criteria=new TPretrialMessageCriteria();
        TPretrialMessageCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andReleaseAnnouncementIdEqualTo(pretrialMessageDTO.getNoticeId());
        cubCriteria.andCompanyIdEqualTo(pretrialMessageDTO.getSupplierId());
        List<TPretrialMessage> result=tPretrialMessageMapper.selectByExample(criteria);
        if(!CollectionUtils.isEmpty(result)){
            //判断预审信息是否通过
            if(PretrialMessageEnum.PASS.getCode().equals(result.get(0).getStatus())){
                return  true;
            }
        }
        return false;
    }

    /**
     * 根据类别获取招标信息
     * @return
     */
    @Override
    public PretrialMessageDetailVO getPretrigetPretrialMessageDetail(Long procurementProjectId) {
        PretrialMessageDetailVO vo= new PretrialMessageDetailVO();
        //线下详情
        OfflineDetailDTO offline=new OfflineDetailDTO();
        //线上详情
        OnlineDetailDTO online=new OnlineDetailDTO();

        BSaleDocumentsCriteria criteria=new  BSaleDocumentsCriteria();
        BSaleDocumentsCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andProcurementProjectIdEqualTo(procurementProjectId);
        List<BSaleDocuments> entityList=bSaleDocumentsMapper.selectByExample(criteria);
        if(!CollectionUtils.isEmpty(entityList)){
            BSaleDocuments entity=entityList.get(0);
            switch (entity.getIsUnderLine()){
               //0-线下,1-线上,3-线上线下
                case 0:
                    BTenderDocumentsPlaceSaleCriteria criteria1=new BTenderDocumentsPlaceSaleCriteria();
                    BTenderDocumentsPlaceSaleCriteria.Criteria cubCriteria1=criteria1.createCriteria();
                    cubCriteria1.andProcurementProjectIdEqualTo(procurementProjectId);
                    List<BTenderDocumentsPlaceSale> placeSales=bTenderDocumentsPlaceSaleMapper.selectByExample(criteria1);
                    if(!CollectionUtils.isEmpty(placeSales)){
                        BTenderDocumentsPlaceSale placeSale=placeSales.get(0);
                        BeanUtils.copyProperties(placeSale,offline);
                        offline.setSaleTimeStart(DateTimeUtil.dateToStr(placeSale.getSaleTimeStart()));
                        offline.setSaleTimeEnd(DateTimeUtil.dateToStr(placeSale.getSaleTimeEnd()));
                    }
                    break;
                case 1:
                    BSaleDocumentsFileCriteria criteria2=new BSaleDocumentsFileCriteria();
                    BSaleDocumentsFileCriteria.Criteria cubCriteria2=criteria2.createCriteria();
                    cubCriteria2.andProcurementProjectIdEqualTo(procurementProjectId);
                    List<BSaleDocumentsFile> documentsFiles=bSaleDocumentsFileMapper.selectByExample(criteria2);
                    if(!CollectionUtils.isEmpty(documentsFiles)){
                        BSaleDocumentsFile documentsFile=documentsFiles.get(0);
                        BeanUtils.copyProperties(documentsFile,online);
                    }
                    break;
                case 3:
                    BTenderDocumentsPlaceSaleCriteria mcriteria1=new BTenderDocumentsPlaceSaleCriteria();
                    BTenderDocumentsPlaceSaleCriteria.Criteria mcubCriteria1=mcriteria1.createCriteria();
                    mcubCriteria1.andProcurementProjectIdEqualTo(procurementProjectId);
                    List<BTenderDocumentsPlaceSale> pplaceSales=bTenderDocumentsPlaceSaleMapper.selectByExample(mcriteria1);
                    if(!CollectionUtils.isEmpty(pplaceSales)){
                        BTenderDocumentsPlaceSale placeSale=pplaceSales.get(0);
                        BeanUtils.copyProperties(placeSale,offline);
                        offline.setSaleTimeStart(DateTimeUtil.dateToStr(placeSale.getSaleTimeStart()));
                        offline.setSaleTimeEnd(DateTimeUtil.dateToStr(placeSale.getSaleTimeEnd()));
                    }
                    BSaleDocumentsFileCriteria mcriteria2=new BSaleDocumentsFileCriteria();
                    BSaleDocumentsFileCriteria.Criteria mcubCriteria2=mcriteria2.createCriteria();
                    mcubCriteria2.andProcurementProjectIdEqualTo(procurementProjectId);
                    List<BSaleDocumentsFile> mdocumentsFiles=bSaleDocumentsFileMapper.selectByExample(mcriteria2);
                    if(!CollectionUtils.isEmpty(mdocumentsFiles)){
                        BSaleDocumentsFile documentsFile=mdocumentsFiles.get(0);
                        BeanUtils.copyProperties(documentsFile,online);
                    }
                    break;
                default:
                    break;
            }
            vo.setOffline(offline);
            vo.setOnline(online);
        }
        return vo;
    }
}
