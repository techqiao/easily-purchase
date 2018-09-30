package com.epc.bidding.service.monitoring.FileMonitoring;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.vo.MonitorFileVO;

import java.util.List;

public interface FileMonitoringService {

     Result<List<MonitorFileVO>> ListBMonitoringFile(QueryMonitoringFileDTO dto);

     Result<Boolean> createMonitoringFile(HandleMonitoringFile handle);


    }
