package com.epc.bidding.controller.bidding;

import com.epc.bidding.service.monitoring.FileMonitoring.FileMonitoringService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileMonitorService;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 文件监控
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */

@RestController
public class BiddingFileMonitorController implements FacadeFileMonitorService {
@Autowired
FileMonitoringService fileMonitoringService;

    @Override
    public Result<List<MonitorFileVO>> ListBMonitoringFile(QueryMonitoringFileDTO dto){
        return  fileMonitoringService.ListBMonitoringFile(dto);
    }

    @Override
    public Result<Boolean> createMonitoringFile(HandleMonitoringFile handle){
        return fileMonitoringService.createMonitoringFile(handle);
    }

}


