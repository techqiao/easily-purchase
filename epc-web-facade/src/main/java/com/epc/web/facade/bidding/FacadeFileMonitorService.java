package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleMonitoringFile;
import com.epc.web.facade.bidding.query.monitor.file.QueryMonitoringFileDTO;
import com.epc.web.facade.bidding.vo.MonitorFileVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FacadeFileMonitorService {

    @PostMapping(value = "ListBMonitoringFile", consumes = "application/json; charset=UTF-8")
     Result<List<MonitorFileVO>> ListBMonitoringFile(@RequestBody  QueryMonitoringFileDTO dto);

    @PostMapping(value = "createMonitoringFile", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createMonitoringFile(@RequestBody HandleMonitoringFile handle);
}
