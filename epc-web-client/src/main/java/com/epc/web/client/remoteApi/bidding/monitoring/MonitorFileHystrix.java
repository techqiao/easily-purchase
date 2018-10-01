package com.epc.web.client.remoteApi.bidding.monitoring;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeFileMonitorService;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.vo.MonitorFileVO;

import java.util.List;

public class MonitorFileHystrix implements FacadeFileMonitorService {
    @Override
    public Result<List<MonitorFileVO>> ListBMonitoringFile(QueryMonitoringFileDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createMonitoringFile(HandleMonitoringFile handle) {
        return Result.hystrixError();
    }
}
