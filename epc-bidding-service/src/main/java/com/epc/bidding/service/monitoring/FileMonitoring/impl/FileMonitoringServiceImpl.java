package com.epc.bidding.service.monitoring.FileMonitoring.impl;

import com.epc.bidding.domain.bidding.BMonitoringFile;
import com.epc.bidding.domain.bidding.BMonitoringFileCriteria;
import com.epc.bidding.mapper.bidding.BMonitoringFileMapper;
import com.epc.bidding.service.monitoring.FileMonitoring.FileMonitoringService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
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
}
