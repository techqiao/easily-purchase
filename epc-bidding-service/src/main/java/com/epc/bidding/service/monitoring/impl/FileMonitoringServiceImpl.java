package com.epc.bidding.service.monitoring.impl;

import com.epc.bidding.domain.bidding.*;
import com.epc.bidding.mapper.bidding.BMonitoringFileMapper;
import com.epc.bidding.mapper.bidding.TPurchaseProjectBasicInfoMapper;
import com.epc.bidding.mapper.bidding.TPurchaseProjectParticipantMapper;
import com.epc.bidding.mapper.bidding.TPurchaseProjectParticipantPermissionMapper;
import com.epc.bidding.service.monitoring.FileMonitoringService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ParticipantPermissionEnum;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.query.monitor.list.QueryListMonitor;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import com.epc.web.facade.bidding.vo.listMonitorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 文件监控
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Service
public class FileMonitoringServiceImpl implements FileMonitoringService {
    final private Logger LOGGER=LoggerFactory.getLogger(FileMonitoringServiceImpl.class);
    @Autowired
    BMonitoringFileMapper bMonitoringFileMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    TPurchaseProjectParticipantMapper tPurchaseProjectParticipantMapper;
    @Autowired
    TPurchaseProjectParticipantPermissionMapper tPurchaseProjectParticipantPermissionMapper;

    /**
     * 监控文件列表
     * @return
     */
    @Override
    public Result<List<MonitorFileVO>> ListBMonitoringFile(QueryMonitoringFileDTO dto){

        BMonitoringFileCriteria criteria=new BMonitoringFileCriteria();
        BMonitoringFileCriteria.Criteria cubCriteria=criteria.createCriteria();
        if(dto.getProjectId()>0){
            cubCriteria.andProjectIdEqualTo(dto.getProjectId());
        }

        List<MonitorFileVO> voList= new ArrayList<>();
        List<BMonitoringFile> result=bMonitoringFileMapper.selectByExampleWithRowbounds(criteria,dto.getRowBounds());
        for(BMonitoringFile entity:result){
            MonitorFileVO vo =new MonitorFileVO();
            BeanUtils.copyProperties(entity,vo);
            switch (entity.getFileType()){
                case "pretrialFile":
                    vo.setFileType("资格预审文件");
                    break;
                case "biddingDocuments":
                    vo.setFileType("招标文件");
                    break;
                case "invitation":
                    vo.setFileType("投标邀请书");
                    break;
                case "tenderDocuments":
                    vo.setFileType("投标文件");
                case "evaluationRepost":
                    vo.setFileType("评标报告");
                    break;
                case "winBid":
                    vo.setFileType("中标通知书");
                    break;
                case "contract":
                    vo.setFileType("合同");
                    break;
                default:vo.setFileType("");
                    break;
            }
            voList.add(vo);
        }
        return Result.success(voList);
    }


    /**
     * 监控新增 文件记录
     * @param handle
     * @return
     */
    @Override
    public Result<Boolean> createMonitoringFile(HandleMonitoringFile handle){
        BMonitoringFile entity=new BMonitoringFile();
        BeanUtils.copyProperties(handle,entity);
        try{
            bMonitoringFileMapper.insertSelective(entity);
        }catch (Exception e){
            LOGGER.error("createMonitoringFile_"+entity.toString()+"_"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  Result.error();
        }
        return  Result.success(true);
    }

    /**
     * 查询监控项目列表
     * @param queryListMonitor
     * @return
     */
    @Override
    public Result<List<listMonitorVO>> listMonitor(QueryListMonitor queryListMonitor){
        TPurchaseProjectParticipantPermissionCriteria criteria=new TPurchaseProjectParticipantPermissionCriteria();
        TPurchaseProjectParticipantPermissionCriteria.Criteria newCriteria=criteria.createCriteria();
        newCriteria.andUserIdEqualTo(queryListMonitor.getSupplier());
        newCriteria.andParticipantTypeEqualTo(4);
        newCriteria.andParticipantPermissionEqualTo(ParticipantPermissionEnum.PERSON_LIABLE.getCode());
        newCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //获取自己是负责人的项目
        List<TPurchaseProjectParticipantPermission> result=tPurchaseProjectParticipantPermissionMapper.selectByExample(criteria);
        List<listMonitorVO> voList=new ArrayList<>();
        for(TPurchaseProjectParticipantPermission entity:result){
                listMonitorVO vo =new listMonitorVO();
                TPurchaseProjectBasicInfo tPurchaseProjectBasicInfo=tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(entity.getPurchaseProjectId());
                BeanUtils.copyProperties(tPurchaseProjectBasicInfo,vo);
                vo.setPurchaseProjectId(entity.getPurchaseProjectId());
                voList.add(vo);
        }
        return Result.success(voList);
    }

}
